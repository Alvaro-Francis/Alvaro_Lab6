package com.example.alvaro_lab6

import android.media.AudioAttributes
import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import android.widget.ImageView
import com.example.alvaro_lab6.model.RadioStation
import com.example.alvaro_lab6.model.RadioStations


lateinit var allStations : MutableList<RadioStation>

var radioOn = false

class RadioAdapter(var radioStations: RadioStations) : RecyclerView.Adapter<RadioAdapter.RadioViewHolder> () {

    class RadioViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        init {
            itemView.setOnClickListener(this)
        }

        var name: TextView = itemView.findViewById(R.id.name_text)
        var uri: TextView = itemView.findViewById(R.id.uri_text)
        var radioImage: ImageView = itemView.findViewById(R.id.radio_image)
        var whichCard: Int = 0
        var mediaPlayer1 = MediaPlayer()
        //var radioButton: Button = itemView.findViewById(R.id.on_off_button)

        fun bind(position: Int) {
            name.text = allStations[position].name
            uri.text = allStations[position].uri

            whichCard = position

        }

        override fun onClick(p0: View?) {
            Toast.makeText(p0?.context, "Station: " + whichCard.toString(), Toast.LENGTH_LONG).show()
            var url = allStations[whichCard].uri.toString()

            if (radioOn) {
                mediaPlayer1.pause()
                radioOn = false
            } else {
                setAndPrepareRadioLink(url)
                mediaPlayer1.start()
                radioOn = true

            }
        }

        private fun setAndPrepareRadioLink(url: String) {
            mediaPlayer1.reset()
            mediaPlayer1.setDataSource(url)
            mediaPlayer1.prepare()
            mediaPlayer1.apply {
                setAudioAttributes(
                    AudioAttributes.Builder()
                        .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                        .setUsage(AudioAttributes.USAGE_MEDIA)
                        .build())
            }

        }
    }

    init {
        allStations = radioStations.getStations()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RadioViewHolder {
        var view =
            LayoutInflater.from(parent.context).inflate(R.layout.radio_card, parent, false)

        return RadioViewHolder(view)
    }

    override fun onBindViewHolder(holder: RadioViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return allStations.size
    }

}

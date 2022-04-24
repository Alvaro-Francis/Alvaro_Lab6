package com.example.alvaro_lab6.model

import kotlin.collections.MutableList

var stations: MutableList<RadioStation> = mutableListOf(RadioStation())


class RadioStations() {

    init {
        stations.add(RadioStation("RnB", "https://usa19.fastcast4u.com/hrjmedia"))
        stations.add(RadioStation("DnB", "https://www.partyviberadio.com:8061/;listen.pls?sid=1"))
        stations.add(RadioStation("Rap", "https://www.partyvibe.com:8063/;listen.pls?sid=1"))
        stations.add(RadioStation("Dubstep", "https://www.partyvibe.com:8067/;listen.pls?sid=1"))
        stations.add(RadioStation("Pop","https://www.partyvibe.com:8065/;listen.pls?sid=1"))
        stations.add(RadioStation("UK Soul Chart: Funk","http://uk5.internet-radio.com:8174/;"))
        stations.add(RadioStation("Blood Stream Radio: Metal","https://uk1.internet-radio.com/proxy/bloodstream?mp=/stream"))
        stations.add(RadioStation("Majestic Juke Box: Soul","https://uk3.internet-radio.com/proxy/majesticjukebox?mp=/stream"))
        stations.add(RadioStation("Magic Oldies Florida: Oldies","https://ais-edge51-live365-dal02.cdnstream.com/a46209?listenerId=Live365-Widget-AdBlock&aw_0_1st.playerid=Live365-Widget&aw_0_1st.skey=1648607808"))
        stations.add(RadioStation("Smooth Jazz Florida: Smooth Jazz", "https://us4.internet-radio.com/proxy/wsjf?mp=/stream;"))
    }

    public fun getStations() : MutableList<RadioStation> {

        return stations
    }

    public fun size() : Int {
        return stations.size
    }
}
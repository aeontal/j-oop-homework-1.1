package ru.netology.radio;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class Radio {

    private int channelMin = 0;
    private int currentChannel = 1;
    private int channelNum = 10;
    private int channelMax = channelNum;
    private int volumeMin = 0;
    private int volumeLevel = 3;
    private int volumeMax = 100;

    public Radio(int channelNum) {
        this.channelNum = channelNum;
    }

    public void setChannel(int currentChannel) {
        if (currentChannel > channelMax) {
            currentChannel = channelMax;
        }
        if (currentChannel < channelMin) {
            currentChannel = channelMin;
        }
        this.currentChannel = currentChannel;
    }

    public void setVolumeLevel(int volumeLevel) {
        if (volumeLevel > volumeMax) {
            volumeLevel = volumeMax;
        }
        if (volumeLevel < volumeMin) {
            volumeLevel = volumeMin;
        }
        this.volumeLevel = volumeLevel;
    }

    public void nextChannel() {
        int currentChannel = getCurrentChannel();
        currentChannel++;
        if (currentChannel > channelNum) {
            currentChannel = channelMin;
        }
        this.currentChannel = currentChannel;
    }

    public void previousChannel() {
        int currentChannel = getCurrentChannel();
        currentChannel--;
        if (currentChannel < channelMin) {
            currentChannel = channelNum;
        }
        this.currentChannel = currentChannel;
    }

    public void increaseVolume() {
        int currentVolume = getVolumeLevel();
        currentVolume++;
        if (currentVolume > volumeMax) {
            return;
        }
        this.volumeLevel = currentVolume;
    }

    public void decreaseVolume() {
        int currentVolume = getVolumeLevel();
        currentVolume--;
        if (currentVolume < volumeMin) {
            return;
        }
        this.volumeLevel = currentVolume;
    }
}
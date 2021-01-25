package ru.netology.radio;

import javax.swing.*;

public class Radio {
    private int channelNum;
    private int channelMax = 9;
    private int channelMin = 1;
    private int volumeLevel;
    private int volumeMax = 10;
    private int volumeMin = 0;

    public void setChannelNum(int channelNum) {
        if (channelNum > channelMax) {
            this.channelNum = channelMax;
        } else if (channelNum < channelMin) {
            this.channelNum = channelMin;
        } else {
            this.channelNum = channelNum;
        }
    }

    public int getChannelNum() {
        return channelNum;
    }

    public void setVolumeLevel(int volumeLevel) {
        if (volumeLevel > volumeMax) {
            this.volumeLevel = volumeMax;
        } else {
            this.volumeLevel = volumeLevel;
        }
    }

    public int getVolumeLevel() {
        return volumeLevel;
    }

    public int increaseVolume() {
        if (volumeLevel < volumeMax) {
            this.volumeLevel++;
        } else {
            this.volumeLevel = volumeMax;
        }
        return volumeLevel;
    }

    public int decreaseVolume() {
        if (volumeLevel > volumeMin) {
            this.volumeLevel--;
        } else {
            this.volumeLevel = volumeMin;
        }
        return volumeLevel;
    }

    public int nextChannel() {
        if (channelNum < channelMax) {
            this.channelNum++;
        } else {
            this.channelNum = 1;
        }
        return channelNum;
    }

    public int previousChannel() {
        if (channelNum > channelMin) {
            this.channelNum--;
        } else {
            this.channelNum = 9;
        }
        return channelNum;
    }

}

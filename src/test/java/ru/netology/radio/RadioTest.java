package ru.netology.radio;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {

    @Test
    void shouldCheckNextChannel() {

        Radio radio = new Radio();
        radio.setChannelNum(5);
        int expected = 6;
        int actual = radio.nextChannel();
        assertEquals(expected, actual);
    }

    @Test
    void shouldCheckNextChannelMax() {

        Radio radio = new Radio(20);
        radio.setChannelNum(20);
        int expected = 1;
        int actual = radio.nextChannel();
        assertEquals(expected, actual);
    }

    @Test
    void shouldCheckPreviousChannel() {

        Radio radio = new Radio();
        radio.setChannelNum(5);
        int expected = 4;
        int actual = radio.previousChannel();
        assertEquals(expected, actual);
    }

    @Test
    void shouldCheckPreviousChannelMin() {

        Radio radio = new Radio(20);
        radio.setChannelNum(1);
        int expected = radio.getChannelMax();
        int actual = radio.previousChannel();
        assertEquals(expected, actual);
    }

    @Test
    void shouldCheckIncreaseVolume() {
        Radio radio = new Radio();
        radio.setVolumeLevel(1);
        int expected = 2;
        int actual = radio.increaseVolume();
        assertEquals(expected, actual);
    }

    @Test
    void shouldCheckDecreaseVolume() {
        Radio radio = new Radio();
        radio.setVolumeLevel(2);
        int expected = 1;
        int actual = radio.decreaseVolume();
        assertEquals(expected, actual);
    }

    @Test
    void shouldCheckIncreaseVolumeMax() {
        Radio radio = new Radio();
        radio.setVolumeLevel(100);
        int expected = 100;
        int actual = radio.increaseVolume();
        assertEquals(expected, actual);
    }

    @Test
    void shouldCheckDecreaseVolumeMin() {
        Radio radio = new Radio();
        radio.setVolumeLevel(0);
        int expected = 0;
        int actual = radio.decreaseVolume();
        assertEquals(expected, actual);
    }

    @Test
    void shouldCheckSetChannel() {
        Radio radio = new Radio();
        radio.setChannelNum(1);
        int expected = 1;
        int actual = radio.getChannelNum();
        assertEquals(expected, actual);
    }

    @Test
    void shouldCheckSetChannelMin() {
        Radio radio = new Radio();
        radio.setChannelNum(0);
        int expected = 1;
        int actual = radio.getChannelNum();
        assertEquals(expected, actual);
    }

    @Test
    void shouldCheckSetChannelBeyondLimits() {
        Radio radio = new Radio(10);
        radio.setChannelNum(33);
        int expected = radio.getChannelMax();
        int actual = radio.getChannelNum();
        assertEquals(expected, actual);
    }

    @Test
    void shouldCheckGetVolume() {
        Radio radio = new Radio();
        radio.setVolumeLevel(1);
        int expected = 1;
        int actual = radio.getVolumeLevel();
        assertEquals(expected, actual);
    }

    @Test
    void shouldCheckSetVolumeBeyondLimits() {
        Radio radio = new Radio();
        radio.setVolumeLevel(110);
        int expected = 100;
        int actual = radio.getVolumeLevel();
        assertEquals(expected, actual);
    }


}
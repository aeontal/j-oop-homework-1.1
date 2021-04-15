package ru.netology.radio;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RadioTest {

    //  проверяем начальные значения
    @Test
    public void shouldCheckSetInitSettings() {
        Radio radio = new Radio();
        assertEquals(0, radio.getChannelMin());
        assertEquals(1, radio.getCurrentChannel());
        assertEquals(10, radio.getChannelNum());
        assertEquals(3, radio.getVolumeLevel());
        assertEquals(10, radio.getChannelMax());
        assertEquals(0, radio.getVolumeMin());
        assertEquals(100, radio.getVolumeMax());
    }

    // -- Проверка работы с каналами
    @Test
    public void shouldCheckNextChannel() {

        Radio radio = new Radio(10);
        radio.setChannel(5);
        radio.nextChannel();
        assertEquals(6, radio.getCurrentChannel());
    }

    @Test
    public void shouldCheckNextChannelMax() {
        Radio radio = new Radio(10);
        radio.setChannelMax(radio.getChannelNum());
        radio.setChannel(radio.getChannelMax());
        radio.nextChannel();
        assertEquals(0, radio.getCurrentChannel());
    }

    @Test
    public void shouldCheckPreviousChannel() {
        Radio radio = new Radio();
        radio.setChannel(5);
        radio.previousChannel();
        assertEquals(4, radio.getCurrentChannel());
    }

    @Test
    public void shouldCheckPreviousChannelMin() {
        Radio radio = new Radio(10);
        radio.setChannelMin(0);
        radio.setCurrentChannel(radio.getChannelMin());
        radio.previousChannel();
        assertEquals(10, radio.getCurrentChannel());
    }

    @Test
    public void shouldCheckSetChannelBeyondLimits() {
        Radio radio = new Radio(10);
        radio.setChannel(11);
        assertEquals(10, radio.getCurrentChannel());
    }

    @Test
    void shouldCheckSetChannelMin() {
        Radio radio = new Radio(10);
        radio.setChannelNum(0);
        assertEquals(1, radio.getCurrentChannel());
    }

    @Test
    public void shouldCheckSetChannel() {
        Radio radio = new Radio(10);
        radio.setChannelNum(1);
        assertEquals(1, radio.getCurrentChannel());
    }

    // -- Проверка работы с громкостью

    @Test
    public void shouldCheckGetVolume() {
        Radio radio = new Radio();
        radio.setVolumeLevel(5);
        assertEquals(5, radio.getVolumeLevel());
    }

    @Test
    void shouldCheckIncreaseVolume() {
        Radio radio = new Radio();
        radio.setVolumeLevel(1);
        radio.increaseVolume();
        assertEquals(2, radio.getVolumeLevel());
    }

    @Test
    void shouldCheckDecreaseVolume() {
        Radio radio = new Radio();
        radio.setVolumeLevel(2);
        int expected = 1;
       radio.decreaseVolume();
        assertEquals(expected,radio.getVolumeLevel());
    }

    @Test
    public void shouldCheckSetVolumeBeyondLimits() {
        Radio radio = new Radio();
        radio.setVolumeLevel(101);
        assertEquals(100, radio.getVolumeLevel());
    }

    @Test
    public void shouldCheckIncreaseVolumeMax() {
        Radio radio = new Radio();
        radio.setVolumeMax(100);
        radio.setVolumeLevel(radio.getVolumeMax());
        radio.increaseVolume();
        assertEquals(100, radio.getVolumeLevel());
    }

    @Test
    public void shouldCheckDecreaseVolumeMin() {
        Radio radio = new Radio();
        radio.setVolumeMin(0);
        radio.setVolumeLevel(radio.getVolumeMin());
        radio.decreaseVolume();
        assertEquals(0, radio.getVolumeLevel());
    }
}
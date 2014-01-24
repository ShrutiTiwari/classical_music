package com.aqua.music.example.easymidi;

import javax.sound.midi.Instrument;
import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Synthesizer;

public class Tools {
        static MidiChannel drumChannel = null;
        static Synthesizer synthesizer = null;
        static int[][] channels = new int[8][128];
        static Instrument[] instruments;

        static void initSynthesizer() {
                if (synthesizer == null) {
                        System.out.println("init EasyMIDI");
                        try {
                                synthesizer = MidiSystem.getSynthesizer();
                                synthesizer.open();
                                instruments = synthesizer.getDefaultSoundbank().getInstruments();
                                int c = openNote(0, 60, 0);
                                Thread.sleep(100);
                                closeNote(60, c);
                        } catch (Throwable t) {
                                t.printStackTrace();
                        }
                        if (drumChannel == null) {
                                drumChannel = synthesizer.getChannels()[9];
                        }
                }
        }

        public static void playNote(final int pitch, int instrument, int velocity, final int delay) {
                final int c = openNote(instrument, pitch, velocity);
                new Thread(new Runnable() {
                        @Override
                        public void run() {
                                try {
                                        Thread.sleep(delay);
                                        closeNote(pitch, c);
                                } catch (Throwable t) {
                                        t.printStackTrace();
                                }
                        }
                }).start();

        }

        public static void playDrum(final int instrument, int velocity, final int delay) {
                openDrum(instrument, velocity);
                new Thread(new Runnable() {
                        @Override
                        public void run() {
                                try {
                                        Thread.sleep(delay);
                                        closeDrum(instrument);
                                } catch (Throwable t) {
                                        t.printStackTrace();
                                }
                        }
                }).start();

        }

        public static void openDrum(int instrument, int velocity) {
                initSynthesizer();
                drumChannel.noteOn(instrument, velocity);
        }

        public static void closeDrum(int instrument) {
                initSynthesizer();
                drumChannel.noteOff(instrument);
        }

        public static void closeNote(int pitch, int channel) {
                initSynthesizer();
                MidiChannel voiceChannel = synthesizer.getChannels()[channel];
                voiceChannel.noteOff(pitch);
                channels[channel][pitch] = 0;
        }

        public static int openNote(int instrument, int pitch, int velocity) {
                initSynthesizer();
                int c = 0;
                for (int i = 0; i < 8; i++) {
                        if (channels[i][pitch] == 0) {
                                channels[i][pitch] = 1;
                                c = i;
                                break;
                        }
                }
                MidiChannel voiceChannel = synthesizer.getChannels()[c];
                synthesizer.loadInstrument(instruments[instrument]);
                voiceChannel.programChange(instrument);
                voiceChannel.noteOn(pitch, velocity);
                return c;
        }
}
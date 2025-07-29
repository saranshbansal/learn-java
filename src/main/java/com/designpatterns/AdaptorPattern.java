package com.designpatterns;

/**
 * Adapter Design Pattern Implementation
 * <p>
 * This example demonstrates the Adapter Pattern which allows incompatible interfaces
 * to work together. The AudioPlayer can play MP3 files natively, but uses an adapter
 * to play MP4 and MOV files through advanced media players.
 *
 * @author sbansal
 */

/**
 * Basic media player interface that defines the contract for playing audio files.
 */
interface MediaPlayer {
    /**
     * Plays an audio file of the specified type.
     *
     * @param audioType the type of audio file (mp3, mp4, mov)
     * @param fileName the name of the file to play
     */
    void play(String audioType, String fileName);
}

/**
 * Advanced media player interface for handling specialized audio formats.
 */
interface AdvanceMediaPlayer {
    /**
     * Plays an MP4 file.
     *
     * @param fileName the name of the MP4 file to play
     */
    void playMp4(String fileName);

    /**
     * Plays a MOV file.
     *
     * @param fileName the name of the MOV file to play
     */
    void playMov(String fileName);
}

/**
 * Concrete implementation for playing MP4 files.
 */
class Mp4Player implements AdvanceMediaPlayer {

    @Override
    public void playMp4(String fileName) {
        System.out.println("Playing mp4 file: " + fileName);
    }

    @Override
    public void playMov(String fileName) {
        // This player only supports MP4 format
        System.out.println("MP4 player cannot play MOV files");
    }
}

/**
 * Concrete implementation for playing MOV files.
 */
class MovPlayer implements AdvanceMediaPlayer {

    @Override
    public void playMov(String fileName) {
        System.out.println("Playing mov file: " + fileName);
    }

    @Override
    public void playMp4(String fileName) {
        // This player only supports MOV format
        System.out.println("MOV player cannot play MP4 files");
    }
}

/**
 * Adapter class that bridges the gap between MediaPlayer and AdvanceMediaPlayer interfaces.
 * This allows the basic AudioPlayer to use advanced media players for specialized formats.
 */
class MediaAdaptor implements MediaPlayer {
    private AdvanceMediaPlayer advanceMediaPlayer;

    /**
     * Creates a media adapter for the specified audio type.
     *
     * @param type the type of advanced media player needed (mp4 or mov)
     */
    public MediaAdaptor(String type) {
        if ("mp4".equalsIgnoreCase(type)) {
            advanceMediaPlayer = new Mp4Player();
        } else if ("mov".equalsIgnoreCase(type)) {
            advanceMediaPlayer = new MovPlayer();
        }
    }

    @Override
    public void play(String audioType, String fileName) {
        if ("mp4".equalsIgnoreCase(audioType)) {
            advanceMediaPlayer.playMp4(fileName);
        } else if ("mov".equalsIgnoreCase(audioType)) {
            advanceMediaPlayer.playMov(fileName);
        }
    }
}

/**
 * Basic audio player that natively supports MP3 files.
 * Uses MediaAdaptor to play other advanced file formats (MP4, MOV).
 *
 * This demonstrates the Adapter Pattern where the AudioPlayer (client) uses
 * the MediaAdaptor to work with AdvanceMediaPlayer implementations.
 *
 * @author sbansal
 */
class AudioPlayer implements MediaPlayer {
    private MediaAdaptor mediaAdaptor;

    @Override
    public void play(String audioType, String fileName) {
        // Native support for MP3 files
        if ("mp3".equalsIgnoreCase(audioType)) {
            System.out.println("Playing mp3 file: " + fileName);
        }
        // Use adapter for advanced formats
        else if ("mp4".equalsIgnoreCase(audioType) || "mov".equalsIgnoreCase(audioType)) {
            mediaAdaptor = new MediaAdaptor(audioType);
            mediaAdaptor.play(audioType, fileName);
        }
        // Unsupported format
        else {
            System.out.println("Invalid media type: " + audioType + " format not supported");
        }
    }
}

/**
 * Demonstration class for the Adapter Design Pattern.
 *
 * The Adapter Pattern allows objects with incompatible interfaces to collaborate.
 * In this example:
 * - AudioPlayer natively plays MP3 files
 * - MediaAdaptor allows AudioPlayer to play MP4 and MOV files
 * - Advanced players (Mp4Player, MovPlayer) handle specific formats
 *
 * @author sbansal
 */
public class AdaptorPattern {

    /**
     * Main method demonstrating the Adapter Pattern in action.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();

        // Test different audio formats
        audioPlayer.play("mp3", "beyond the horizon.mp3");
        audioPlayer.play("mp4", "alone.mp4");
        audioPlayer.play("mov", "far far away.mov");
        audioPlayer.play("avi", "mind me.avi");  // Unsupported format
    }
}

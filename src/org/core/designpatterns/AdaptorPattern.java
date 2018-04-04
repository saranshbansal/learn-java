package org.core.designpatterns;

/**
 * @author sbansal
 * Adapter design pattern (S)
 */
interface MediaPlayer {
	void play(String audioType, String fileName);
}

interface AdvanceMediaPlayer {
	void playMp4(String fileName);

	void playMov(String fileName);
}

class Mp4Player implements AdvanceMediaPlayer {

	@Override
	public void playMp4(String fileName) {
		System.out.println("Playing mp3 file: " + fileName);
	}

	@Override
	public void playMov(String fileName) {
		// TODO Auto-generated method stub

	}

}

class MovPlayer implements AdvanceMediaPlayer {

	@Override
	public void playMov(String fileName) {
		System.out.println("Playing mp3 file: " + fileName);
	}

	@Override
	public void playMp4(String fileName) {
		// TODO Auto-generated method stub

	}

}

class MediaAdaptor implements MediaPlayer {
	AdvanceMediaPlayer advanceMediaPlayer;

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
 * @author sbansal
 * Natively plays mp3 only. Adapted to play other advanced files using Media Adaptor
 */
class AudioPlayer implements MediaPlayer {
	MediaAdaptor mediaAdaptor;

	@Override
	public void play(String audioType, String fileName) {
		if ("mp4".equalsIgnoreCase(audioType) || "mov".equalsIgnoreCase(audioType)) {
			mediaAdaptor = new MediaAdaptor(audioType);
			mediaAdaptor.play(audioType, fileName);
		} else if("mp3".equalsIgnoreCase(audioType)) {
			System.out.println("Playing " + audioType + " file: " + fileName);
		} else {
			System.out.println("Invalid Media type.");
		}

	}

}

/**
 * @author sbansal
 *
 */
public class AdaptorPattern {
	public static void main(String[] args) {
		AudioPlayer audioPlayer = new AudioPlayer();
		audioPlayer.play("mp3", "beyond the horizon.mp3");
		audioPlayer.play("mp4", "alone.mp4");
		audioPlayer.play("mov", "far far away.mov");
		audioPlayer.play("avi", "mind me.avi");
	}
}

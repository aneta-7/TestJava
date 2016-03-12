package com.mp3;

import java.util.ArrayList;

public class MockMp3Player implements Mp3Player {

	private boolean isPlaying;
	private String currentPlaying = null;
	private double nowPosition = 0.0;
	private ArrayList playList = new ArrayList();
	private int currentPlaying_index = -1;

	@Override
	public void play() {
		if (playList.isEmpty())
			return;
		else
			isPlaying = true;
		currentPlaying = (String) playList.get(0);
		currentPlaying_index = 0;
		nowPosition = 0.1;
	}

	@Override
	public void pause() {
		if (isPlaying) {
			isPlaying = false;
			nowPosition = 0.1;
		}
	}

	@Override
	public void stop() {
		if (isPlaying) {
			isPlaying = false;
			nowPosition = 0.0;
		}
		if (!playList.isEmpty()) {
			currentPlaying = (String) playList.get(0);
		}
		nowPosition = 0.0;
	}

	@Override
	public double currentPosition() {
		return nowPosition;
	}

	@Override
	public String currentSong() {
		return currentPlaying;
	}

	@Override
	public void next() {
		int next_position = currentPlaying_index + 1;
		if (next_position < playList.size()) {
			currentPlaying = (String) playList.get(next_position);
			currentPlaying_index = next_position;
		}
	}

	@Override
	public void prev() {
		int prev_position = currentPlaying_index - 1;
		if (prev_position > -1) {
			currentPlaying = (String) playList.get(prev_position);
			currentPlaying_index = prev_position;
		}
	}

	@Override
	public boolean isPlaying() {
		return isPlaying;
	}

	@Override
	public void loadSongs(ArrayList names) {
		playList = names;
	}
}

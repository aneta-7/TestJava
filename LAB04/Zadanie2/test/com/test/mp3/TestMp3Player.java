package com.test.mp3;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.easymock.EasyMock.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mp3.MockMp3Player;
import com.mp3.Mp3Player;

public class TestMp3Player {

	private Mp3Player mp3;
	private ArrayList list;
	private static final double DELTA = 1e-15;

	@Before
	public void setUp() {
		mp3 = new MockMp3Player();
		list = new ArrayList();
		list.add("Bill Chase -- Open Up Wide");
		list.add("Jethro Tull -- Locomotive Breath");
		list.add("The Boomtown Rats -- Monday");
		list.add("Carl Orff -- O Fortuna");
	}

	@Test
	public void testPlay() {
		mp3.loadSongs(list);
	    assertFalse(mp3.isPlaying());
	    mp3.play();
	    assertTrue(mp3.isPlaying());
	    assertTrue(mp3.currentPosition() != 0.0);
	    mp3.pause();
	    assertTrue(mp3.currentPosition() != 0.0);
	    mp3.stop();
	    assertEquals(mp3.currentPosition(), 0.0, DELTA);
	}

	@Test
	public void testPlayNoList() {
		assertFalse(mp3.isPlaying());
	    mp3.play();
	    assertFalse(mp3.isPlaying());
	    assertEquals(mp3.currentPosition(), 0.0, 0.1);
	    mp3.pause();
	    assertEquals(mp3.currentPosition(), 0.0, 0.1);
	    assertFalse(mp3.isPlaying());
	    mp3.stop();
	    assertEquals(mp3.currentPosition(), 0.0, 0.1);
	    assertFalse(mp3.isPlaying());
	}

	@Test
	public void testAdvance() {
		mp3.loadSongs(list);

		mp3.play();

	    assertTrue(mp3.isPlaying());

	    mp3.prev();
	    assertEquals(mp3.currentSong(), list.get(0));
	    assertTrue(mp3.isPlaying());

	    mp3.next();
	    assertEquals(mp3.currentSong(), list.get(1));
	    mp3.next();
	    assertEquals(mp3.currentSong(), list.get(2));
	    mp3.prev();

	    assertEquals(mp3.currentSong(), list.get(1));
	    mp3.next();
	    assertEquals(mp3.currentSong(), list.get(2));
	    mp3.next();
	    assertEquals(mp3.currentSong(), list.get(3));
	    mp3.next();
	    assertEquals(mp3.currentSong(), list.get(3));
	    assertTrue(mp3.isPlaying());
	}

	@After
	public void teardown() {
		mp3 = null;
		list = null;
	}
}

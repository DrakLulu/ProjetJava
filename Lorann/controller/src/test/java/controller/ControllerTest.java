package controller;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ControllerTest {

	public int score = 0;
	@Test
	public void testgetScore() {
		assertEquals (score,this.getScore(score));
	}
	private Object getScore(int score) {
		// TODO Auto-generated method stub
		return score;
	}

}

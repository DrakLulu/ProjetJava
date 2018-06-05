package model.element;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ElementTest {
	
	public char sprite;
	
	@Test
	public void testgetSprite() {
		assertEquals (sprite,this.getScore(sprite));
	}
	private Object getScore(int score) {
		// TODO Auto-generated method stub
		return sprite;
	}


}

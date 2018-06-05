package model.element.motion;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MotionElementTest {

	public int x= 0;
	public int y = 0;
	
	@Test
	public void testmoveRight() {
		assertTrue (x,y,this.moveRight(x+1, y));
		
	}

	private void assertTrue(int x, int y, int moveRight) {
		// TODO Auto-generated method stub
		
	}
	private int moveRight(int x,int y) {
		// TODO Auto-generated method stub
		return x;
	}


}

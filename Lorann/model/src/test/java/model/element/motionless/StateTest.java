package model.element.motionless;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class StateTest {

	public boolean state;
	@Test
	public void testsetState() {
		assertEquals (state,this.setState(state));
	}
	private Object setState(boolean state) {
		// TODO Auto-generated method stub
		return state;
	}


}

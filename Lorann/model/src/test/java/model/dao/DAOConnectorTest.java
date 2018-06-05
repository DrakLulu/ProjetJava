package model.dao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DAOConnectorTest {

	public int userchoice = 1;
	@Test
	public void testDAOConnector() {
		assertEquals (userchoice,this.getScore(userchoice));
	}
	private Object getScore(int userchoice) {
		// TODO Auto-generated method stub
		return userchoice;
	}
	
	
}



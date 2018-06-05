package model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ModelTest {

	public boolean Spellexist;
	@Test
	public void testisSpellexist() {
		assertSame (Spellexist,this.getScore(Spellexist));
	}
	private Object getScore(boolean spellexist) {
		// TODO Auto-generated method stub
		return spellexist;
	}


}

package jp.mixi.sample.test;

import android.test.AndroidTestCase;

public class TestSample extends AndroidTestCase {
	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}
	
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testAdd() throws Exception {
		SampleTestTarget1 target = new SampleTestTarget1();
		
		assertEquals(2, target.add(1, 1));
		assertEquals(3, target.add(1, 2));
		assertEquals(4, target.add(2, 2));
	}
	
	public void testDivide() throws Exception {
		SampleTestTarget1 target = new SampleTestTarget1();
		
		assertEquals(2, target.div(4, 2));
		assertEquals(0, target.div(0, 2));
	}
	
}

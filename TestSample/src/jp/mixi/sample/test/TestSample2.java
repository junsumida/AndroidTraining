package jp.mixi.sample.test;

import android.content.Intent;
import android.os.IBinder;
import android.test.ServiceTestCase;

public class TestSample2 extends ServiceTestCase<TestTargetService> {
	public TestSample2() {
		this(TestTargetService.class);
	}

	public TestSample2(Class<TestTargetService> serviceClass) {
		super(serviceClass);
		// TODO Auto-generated constructor stub
	}
	
	public void testStartingProperly() throws Exception {
		startService(new Intent(getContext(), TestTargetService.class));
	}
	
	public void testBinding() throws Exception {
		IBinder binder = bindService(new Intent(getContext(), TestTargetService.class));
		assertNull(binder);
	}

}

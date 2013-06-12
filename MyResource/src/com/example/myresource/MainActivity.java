package com.example.myresource;

import android.os.Bundle;
import android.widget.TextView;
import android.app.Activity;
// import android.graphics.drawable.*;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		TextView view = (TextView) findViewById(R.id.format1);
		
		String formatted = getString(R.string.format2, "ほげ", "もげ");
		view.setText(formatted);
		
		// Drawable drawable = getResources().getDrawable(R.drawable.ic_launcher);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}

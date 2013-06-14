package jp.mixi.contentprovidecaller;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	Uri uri;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		uri = Uri.parse("content://" + "jp.mixi.sample.contentprovider.Book" + "/book");
		Cursor cursor = getContentResolver().query(uri, null, null, null, null);
		while(cursor.moveToNext()){
			Log.d("CPCaller", "call:" + cursor.getString(cursor.getColumnIndexOrThrow("title")));
		}
		cursor.close();
		
		Button insert = (Button) findViewById(R.id.button1);
		insert.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
	    		ContentValues values = new ContentValues();
	    		values.put("title", "hoge");
	    		values.put("publisher", "hoge shuppan");
	    		values.put("price", "450");
				getContentResolver().insert(uri, values);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}

package jp.mixi.practice.intent.beg;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.content.Intent;

public class NewActivity2 extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    // do something...

	    // この Activity への Intent オブジェクトを取得する
	    Intent received = getIntent();
	    String stringExtra = received.getStringExtra("toast_message"); // 文字列の Extra を取り出す
	    Log.d("NA2", stringExtra);
	}
}
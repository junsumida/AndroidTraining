
package jp.mixi.practice.intent.beg;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View button1 = findViewById(R.id.CallActivity1);
        View button2 = findViewById(R.id.CallActivity2);
        View button3 = findViewById(R.id.CallActivity3);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	Intent intent = new Intent(getApplicationContext(), HogeActivity.class);
            	startActivity(intent);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	Intent intent = new Intent(getApplicationContext(), NewActivity2.class);
            	intent.putExtra("toast_message", "hogehoge");
            	startActivity(intent);
                
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	Intent intent = new Intent(getApplicationContext(), NewActivity3.class);
            	intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
            }
        });
    }
}
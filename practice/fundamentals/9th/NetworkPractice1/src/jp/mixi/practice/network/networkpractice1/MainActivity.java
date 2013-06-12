package jp.mixi.practice.network.networkpractice1;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import jp.mixi.practice.network.networkpractice1.MyAsyncTaskLoader;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.AsyncTaskLoader;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.content.Loader;
import android.os.StrictMode;

public class MainActivity extends FragmentActivity implements LoaderCallbacks<String>{
    public static final String TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB) {
            StrictMode.setThreadPolicy(
                    new StrictMode.ThreadPolicy.Builder()
                    .detectNetwork()
                    .penaltyDeath()
                    .build());
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View buttonGet = findViewById(R.id.buttonGet);
        buttonGet.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                // http getの処理を書く
				// ローダの管理をするオブジェクト
            	android.app.LoaderManager manager = getLoaderManager();
            	Bundle argsForLoader = new Bundle();
            	// ローダを初期化して非同期処理を開始する
            	manager.initLoader(0, argsForLoader, MainActivity.this);
            }
        });
        View buttonPost = findViewById(R.id.buttonPost);
        buttonPost.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                // http postの処理を書く
            }
        });
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

	@Override
	public void onLoadFinished(android.support.v4.content.Loader<String> arg0,
			String arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onLoaderReset(android.support.v4.content.Loader<String> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public android.support.v4.content.Loader<String> onCreateLoader(int arg0,
			Bundle arg1) {
		// TODO Auto-generated method stub
		return null;
	}
}

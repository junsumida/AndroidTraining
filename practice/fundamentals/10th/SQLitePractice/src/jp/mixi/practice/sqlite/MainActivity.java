
package jp.mixi.practice.sqlite;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity {
	BookOpenHelper bookOpenHelper;
	CodeNameOpenHelper codeNameOpenHelper;
	SQLiteDatabase db;
	SQLiteDatabase db2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
		bookOpenHelper = new BookOpenHelper(getApplicationContext());
		codeNameOpenHelper = new CodeNameOpenHelper(getApplicationContext());
		db  = bookOpenHelper.getWritableDatabase();
		db2 = codeNameOpenHelper.getWritableDatabase();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.Insert).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                insert();
                insertCodename();
            }
        });
        findViewById(R.id.Delete).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                delete();
            }
        });
        findViewById(R.id.Update).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                update();
            }
        });
        findViewById(R.id.Query).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                query();
            }
        });

    }

    private void insert() {
        // TODO:ここにinsert処理を実装してください
    	db.beginTransaction();
    	try {
    		ContentValues values = new ContentValues();
	    	values.put(Book.COLUMN_NAME_BOOK_TITLE, "TITLE1");
	    	values.put(Book.COLUMN_NAME_BOOK_PUBLISHER, "PUBLISHER1");
	    	values.put(Book.COLUMN_NAME_BOOK_PRICE, "PROCE1");
	    	db.insert(Book.BOOK_TABLE_NAME, null, values);
	    	db.setTransactionSuccessful();
    	} catch(IllegalStateException e){
    	}finally{
    		db.endTransaction();
    	}
    }

    private void insertCodename() {
        // TODO:ここにinsert処理を実装してください
    	db2.beginTransaction();
    	try {
    		ContentValues values = new ContentValues();
	    	values.put(Codename.COLUMN_NAME_CODENAME_NAME, "NAME1");
	    	values.put(Codename.COLUMN_NAME_CODENAME_VERSION, "CODENAME1");
	    	db2.insert(Codename.CODENAME_TABLE_NAME, null, values);
	    	db2.setTransactionSuccessful();
    	} catch(IllegalStateException e){
    	}finally{
    		db2.endTransaction();
    	}
    }

    private void delete() {
        // TODO:ここにdelete処理を実装してください
		String selection = Book.COLUMN_NAME_BOOK_PRICE + " = ?";
    	String[] selectionArgs = {
    			"PRICE"
    	};
    	int deletedCount = db.delete(Book.BOOK_TABLE_NAME, selection, selectionArgs);
    	Log.v("DB", Integer.toString(deletedCount));
    }

    private void update() {
        // TODO:ここにupdate処理を実装してください
    	ContentValues values = new ContentValues();
    	values.put(Book.COLUMN_NAME_BOOK_TITLE, "NEW_TITLE");
    	String selection = Book.COLUMN_NAME_BOOK_TITLE + " LIKE ?";
    	String[] selectionArgs = {
    			"TITLE%"
    	};
    	int updatedCount = db.update(Book.BOOK_TABLE_NAME, values, selection, selectionArgs);
    	Log.v("DB", Integer.toString(updatedCount));
    }

    private void query() {
        // TODO:ここにquery処理を実装してください
    	String[] projection = {
    			Book._ID,
    			Book.COLUMN_NAME_BOOK_TITLE,
    			Book.COLUMN_NAME_BOOK_PUBLISHER,
    			Book.COLUMN_NAME_BOOK_PRICE
    	};
    	Cursor cursor = db.query(Book.BOOK_TABLE_NAME, projection, null, null, null, null, null);
    	boolean moveToFirst = cursor.moveToFirst();
    	long itemId  = cursor.getLong(cursor.getColumnIndexOrThrow(Book._ID));
    	Log.d("DB", Long.toString(itemId));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}

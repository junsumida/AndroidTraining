package jp.mixi.practice.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CodeNameOpenHelper extends SQLiteOpenHelper {
	
	private static final int DATABASE_VERSION = 2;
	
	public static final String DATABASE_NAME = "Codename.db";
	
	private static final String CODENAME_TABLE_CREATE =
			"CREATE TABLE " + Codename.CODENAME_TABLE_NAME + " (" +
					Codename._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
					Codename.COLUMN_NAME_CODENAME_NAME + " TEXT NOT NULL, " + 
					Codename.COLUMN_NAME_CODENAME_VERSION + " TEXT NOT NULL);" ;
	
    private static final String CODENAME_TABLE_DELETE =
	            "DROP TABLE IF EXISTS " + Codename.CODENAME_TABLE_NAME;

    public CodeNameOpenHelper(Context context) {
    	super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(CODENAME_TABLE_CREATE);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL(CODENAME_TABLE_DELETE);
		onCreate(db);
	}

}

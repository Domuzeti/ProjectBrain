package be.Stude.stude.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class ThemeHelper extends SQLiteOpenHelper {

	private final String CREAT_REQUEST = "CREATE TABLE " 
			+ ThemeAdaptater.tableName + " ( " 
			+ ThemeAdaptater.colonne_id + " INTEGER PRIMARY KEY AUTOINCREMENT, "
			+ ThemeAdaptater.colonne_Name + " TEXT NOT NULL)";
	
	public ThemeHelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(CREAT_REQUEST);
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {

	}

}

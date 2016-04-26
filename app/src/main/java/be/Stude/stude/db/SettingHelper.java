package be.Stude.stude.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class SettingHelper extends SQLiteOpenHelper {
	
	private final String CREATE_REQUEST = "CREATE TABLE " 
			+ SettingAdaptater.tableName + " ( " 
			+ SettingAdaptater.colonne_id + " INTEGER PRIMARY KEY AUTOINCREMENT, "
			+ SettingAdaptater.colonne_Mode + " INT NULL,"
			+ SettingAdaptater.colonne_Fond + " INT NULL ) ";
	
	public SettingHelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(CREATE_REQUEST);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

	}

}

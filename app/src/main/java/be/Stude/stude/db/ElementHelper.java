package be.Stude.stude.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class ElementHelper extends SQLiteOpenHelper {

	private final String CREAT_REQUEST = "CREATE TABLE " 
			+ ElementAdaptater.tableName + " ( " 
			+ ElementAdaptater.colonne_id + " INTEGER PRIMARY KEY AUTOINCREMENT, "
			+ ElementAdaptater.colonne_ThemeId + " INT NULL, "
			+ ElementAdaptater.colonne_Word + " TEXT NOT NULL, "
			+ ElementAdaptater.colonne_Description + " TEXT NOT NULL ) ";
	
	
	public ElementHelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(CREAT_REQUEST);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		onCreate(db);
	}

}

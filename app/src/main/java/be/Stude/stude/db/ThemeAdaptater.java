package be.Stude.stude.db;

import java.util.ArrayList;
import java.util.List;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

import be.Stude.stude.struct.Theme;

public class ThemeAdaptater {

	public static String dbName = "Brains";
	public static String tableName = "Themes";
	public static String colonne_id = "_id";
	public static String colonne_Name = "Name";

	private ThemeHelper helper;
	private SQLiteDatabase db;
	private Context context;

	public ThemeAdaptater(Context c) {
		this.context = c;
	}

	public ThemeAdaptater openWritable() {
		helper = new ThemeHelper(context, dbName, null, 1);
		db = helper.getWritableDatabase();
		return this;
	}

	public void close() {
		db.close();
		helper.close();
	}

	public long insertTheme(Theme t) {
		ContentValues values = new ContentValues();
		values.put(colonne_Name, t.getName());
		return db.insert(tableName, null, values);
	}

	public void editNames(int id, String name) {
		ContentValues values = new ContentValues();
		values.put(colonne_Name, name);
		String clause = "_id=" + id;

		db.update(tableName, values, clause, null);
	}

	public void delAll() {
		db.execSQL("DELETE FROM " + tableName);
	}
	
	public List<Theme> getAllCharList() {
	    List<Theme> themeList = new ArrayList<Theme>();

	    String selectQuery = "SELECT * FROM " + tableName;
	    Cursor cursor = db.rawQuery(selectQuery, null);

	    if (cursor.moveToFirst()) {
	        do {
	        	Theme theme = new Theme(cursor.getInt(0), cursor.getString(1));
	        	themeList.add(theme);
	        } while (cursor.moveToNext());
	    }

	    return themeList;
	}
	
	public Cursor getAllCharCursor() {
		String[] selectAll = { colonne_id, colonne_Name };
		Cursor c = null;
		try {
			c = db.query(tableName, selectAll, null, null, null, null, null);
		} catch (SQLiteException e) {

		}
		return c;
	}
}

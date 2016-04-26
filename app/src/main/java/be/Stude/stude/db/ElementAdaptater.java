package be.Stude.stude.db;

import java.util.ArrayList;
import java.util.List;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import be.Stude.stude.struct.Element;

public class ElementAdaptater {
	public static String dbName = "Brain";
	public static String tableName = "Quiz";
	public static String colonne_id = "_id";
	public static String colonne_ThemeId = "ThemeId";
	public static String colonne_Word = "Word";
	public static String colonne_Description = "Description";

	private ElementHelper helper;
	private SQLiteDatabase db;
	private Context context;

	public ElementAdaptater(Context c) {
		this.context = c;
	}

	public ElementAdaptater openWritable() {
		helper = new ElementHelper(context, dbName, null, 1);
		db = helper.getWritableDatabase();
		return this;
	}

	public void close() {
		db.close();
		helper.close();
	}

	public long insertElement(Element e) {
		ContentValues values = new ContentValues();

		values.put(colonne_ThemeId, e.getThemeId());
		values.put(colonne_Word, e.getWord());
		values.put(colonne_Description, e.getDescription());

		return db.insert(tableName, null, values);
	}

	public void delElement(int id) {
		db.delete(tableName, colonne_id + " = ?",
				new String[] { String.valueOf(id) });
	}

	public void delTheme(int themeId) {
		db.delete(tableName, colonne_id + " = ?",
				new String[] { String.valueOf(themeId) });
	}

	public void editWord(int id, String word) {
		ContentValues values = new ContentValues();
		values.put(colonne_Word, word);
		String clause = "_id=" + id;
		
		db.update(tableName, values, clause, null);
	}

	public void editDescription(int id, String description) {
		ContentValues values = new ContentValues();
		values.put(colonne_Description, description);
		String clause = "_id=" + id;
		
		db.update(tableName, values, clause, null);
	}
	
	public List<Element> getAllCharFromThemeList(int themeId) {
	    List<Element> elementList = new ArrayList<Element>();

	    String selectQuery = "SELECT * FROM " + tableName + " WHERE " + colonne_ThemeId + "=" + themeId;
	    Cursor cursor = db.rawQuery(selectQuery, null);

	    if (cursor.moveToFirst()) {
	        do {
	        	Element elem = new Element(cursor.getInt(0), cursor.getInt(1), cursor.getString(2), cursor.getString(3));
	        	elementList.add(elem);
	        } while (cursor.moveToNext());
	    }

	    return elementList;
	}
	
	public Cursor getAllCharFromThemeCursor(int themeId) {		
		String sql = "SELECT * FROM " + tableName + " WHERE " + colonne_ThemeId + "=" + themeId;
		
		Cursor c = db.rawQuery(sql, null);
		return c;
	}
}

package be.Stude.stude.db;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

import be.Stude.stude.struct.Setting;

public class SettingAdaptater {
	public static String dbName = "BrainTrain";
	public static String tableName = "Settings";
	public static String colonne_id = "_id";
	public static String colonne_Mode = "Mode";
	public static String colonne_Fond = "Fond";
	
	private SettingHelper helper;
	private SQLiteDatabase db;
	private Context context;
	
	public SettingAdaptater(Context c) {
		this.context = c;
	}

	public SettingAdaptater openWritable() {
		helper = new SettingHelper(context, dbName, null, 1);
		db = helper.getWritableDatabase();
		return this;
	}

	public void close() {
		db.close();
		helper.close();
	}

	public long insertSetting(Setting s) {
		ContentValues values = new ContentValues();

		values.put(colonne_Mode, s.getMode());
		values.put(colonne_Fond, s.getFond());

		return db.insert(tableName, null, values);
	}
	
	public Cursor getSettigns() {
		String[] selectAll = { colonne_id, colonne_Mode, colonne_Fond };
		Cursor c = null;
		try {
			c = db.query(tableName, selectAll, null, null, null, null, null);
		} catch (SQLiteException e) {
			
		}
		return c;
	}
	
	public void editSettings(String mode, String fond) {
		ContentValues values = new ContentValues();
		values.put(colonne_Mode, mode);
		values.put(colonne_Fond, fond);
		String clause = "_id=" + 2;
		
		db.update(tableName, values, clause, null);
	}
}

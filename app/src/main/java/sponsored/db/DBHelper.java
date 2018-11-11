package sponsored.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "sponsors_db";
    // Table Names
    private static final String TABLE_SPONSOR = "sponsor";
    // Common column names
    private static final String KEY_ID = "_id";
    private static final String KEY_TITLE = "title";
    private static final String KEY_DESCRIPTION = "description";
    private static final String KEY_AMOUNT_DONATE = "amountDonate";

    private static final String CREATE_TABLE_SPONSOR =
                    "CREATE TABLE "
                    + TABLE_SPONSOR + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
                    + KEY_TITLE + " TEXT," + KEY_DESCRIPTION + " TEXT, " + ","
                    + KEY_AMOUNT_DONATE + " LONG " + ")";

    private static DBHelper instance;

    private DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static DBHelper getInstance(Context context) {
        if (instance == null) instance = new DBHelper(context);
        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_SPONSOR);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + CREATE_TABLE_SPONSOR);
        onCreate(db);
    }
}
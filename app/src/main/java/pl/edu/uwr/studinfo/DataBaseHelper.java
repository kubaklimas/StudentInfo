package pl.edu.uwr.studinfo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String USERS = "users";
    public static final String LOGIN = "login";
    public static final String PASS1 = "password1";
    public static final String PASS2 = "password2";

    public DataBaseHelper(@Nullable Context context) {
        super(context, "users.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = "CREATE TABLE " +USERS+ " (login TEXT, password1 TEXT, password2 TEXT)";
        db.execSQL(createTableStatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean addOne(UserModel userModel){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(LOGIN,userModel.getNr_indeksu());
        cv.put(PASS1,userModel.getPass1());
        cv.put(PASS2,userModel.getPass2());

        long insert = db.insert(USERS, null, cv);
        if (insert == -1){
            return false;
        }
        else{
            return true;
        }

    }

    public boolean login(String username, String password){

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor;

        try{
            cursor = db.rawQuery("SELECT password1 FROM users WHERE login = ?", new String[]{username});
        }
        catch(Exception e) {
            return false;
        }

        if(cursor.moveToFirst()){

            return cursor.getString(cursor.getColumnIndex("password1")).equals(password);
        }

        return false;
    }


}

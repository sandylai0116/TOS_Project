package com.project.tos_project;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import com.project.tos_project.model.Card;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LAI on 2015/5/26.
 */
public class DBHelper extends SQLiteOpenHelper {

    //entity class list
    public static abstract class CardEntity implements BaseColumns {
        public static final String TABLE_NAME = "CARD";
        public static final String Card_ID = "Card_ID";
        public static final String Level1_HP = "Level1_HP";
        public static final String Level1_ATTACK = "Level1_ATTACK";
        public static final String Level1_RECOVERY = "Level1_RECOVERY";
        public static final String Level99_HP = "Level99_HP";
        public static final String Level99_ATTACK = "Level99_ATTACK";
        public static final String Level99_RECOVERY = "Level99_RECOVERY";
        public static final String SKILL = "SKILL";
        public static final String LEADER_SKILL = "LEADER_SKILL";
    }

    //database
    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "database.db";
    private static final String TEXT_TYPE = " TEXT";
    private static final String INTEGER_TYPE = " INTEGER";
    private static final String REAL_TYPE = " REAL";
    private static final String BLOB_TYPE = " BLOB";
    private static final String COMMA_SEP = ",";

    //create table
    private static final String SQL_CREATE_CARD_DATA =
            "CREATE TABLE " + CardEntity.TABLE_NAME + " (" +
                    CardEntity._ID + " INTEGER PRIMARY KEY," +
                    CardEntity.Card_ID + INTEGER_TYPE + COMMA_SEP +
                    CardEntity.Level1_HP + INTEGER_TYPE + COMMA_SEP +
                    CardEntity.Level1_ATTACK + INTEGER_TYPE + COMMA_SEP +
                    CardEntity.Level1_RECOVERY + INTEGER_TYPE + COMMA_SEP +
                    CardEntity.Level99_HP + INTEGER_TYPE + COMMA_SEP +
                    CardEntity.Level99_ATTACK + INTEGER_TYPE + COMMA_SEP +
                    CardEntity.Level99_RECOVERY + INTEGER_TYPE + COMMA_SEP +
                    CardEntity.SKILL + TEXT_TYPE + COMMA_SEP +
                    CardEntity.LEADER_SKILL + TEXT_TYPE +
            " )";


    private static final String SQL_DELETE_CARD_DATA =
            "DROP TABLE IF EXISTS " + CardEntity.TABLE_NAME;

   public DBHelper(Context context) {
       super(context, DATABASE_NAME, null, DATABASE_VERSION);
   }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_CARD_DATA);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_CARD_DATA);
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    public void closeDB() {
        SQLiteDatabase db = this.getReadableDatabase();
        if (db != null && db.isOpen())
            db.close();
    }

    public long createToCard(Card card) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(CardEntity.Card_ID, card.getId());
        values.put(CardEntity.Level1_HP, card.getLevel1HP());
        values.put(CardEntity.Level1_ATTACK, card.getLevel1Attack());
        values.put(CardEntity.Level1_RECOVERY, card.getLevel1Recovery());
        values.put(CardEntity.Level99_HP, card.getLevel99HP());
        values.put(CardEntity.Level99_ATTACK, card.getLevel99Attack());
        values.put(CardEntity.Level99_RECOVERY, card.getLevel99Recovery());
        values.put(CardEntity.SKILL, card.getSkill());
        values.put(CardEntity.LEADER_SKILL, card.getLeaderSkill());

        // insert row
        long id = db.insert(CardEntity.TABLE_NAME, null, values);

        return id;
    }

    public List<Card> getCart(long id) {
        List<Card> cards = new ArrayList<Card>();
        SQLiteDatabase db = this.getReadableDatabase();

        //select statement
        String[] projection = {
                CardEntity.Card_ID
        };
        String sortOrder =
                CardEntity.Card_ID + " DESC";
        //query
        Cursor c = db.query(
                CardEntity.TABLE_NAME,             // The table to query
                projection,                               // The columns to return
                null,                                // The columns for the WHERE clause
                null,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                sortOrder                                 // The sort order
        );
        //put to model
        if (c.moveToFirst()) {
            do {
                Card card = new Card();
                card.setId(c.getInt((c.getColumnIndex(CardEntity.Card_ID))));

                // adding to tags list
                cards.add(card);
            } while (c.moveToNext());
        }
        return cards;
    }
}
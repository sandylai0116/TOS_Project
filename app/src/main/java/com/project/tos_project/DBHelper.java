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

    public void addData(SQLiteDatabase db){
        insertCardToDB(db, 1, "blue", "human", 5, 86, 47, 15, 129, 71, 24, null, "b1.5");
        insertCardToDB(db, 2, "blue", "human", 15, 216, 118, 36, 364, 200, 68, null, "b1.5");
        insertCardToDB(db, 3, "blue", "human", 35, 441, 242, 74, 801, 440, 151, null, "b2");
        insertCardToDB(db, 4, "blue", "human", 99, 846, 465, 141, 1881, 1035, 364, null, "b2");
        insertCardToDB(db, 5, "red", "human", 5, 91, 51, 13, 136, 76, 21, null, "r1.5");
        insertCardToDB(db, 6, "red", "human", 15, 228, 127, 32, 384, 214, 60, null, "r1.5");
        insertCardToDB(db, 7, "red", "human", 35, 464, 259, 66, 842, 470, 135, null, "r2");
        insertCardToDB(db, 8, "red", "human", 99 ,891, 498, 126, 1980, 1107, 324, null, "r2");
        insertCardToDB(db, 9, "green", "human", 5, 100, 44, 14, 149, 66, 23, null, "g1.5");
        insertCardToDB(db, 10, "green", "human", 15, 250, 109, 34, 421, 184, 64, null, "g1.5");
        insertCardToDB(db, 11, "green", "human", 35, 510, 223, 69, 925, 405, 141, null, "g2");
        insertCardToDB(db, 12, "green", "human", 99 ,979, 429, 132, 2176, 953, 340, null, "g2");
        insertCardToDB(db, 13, "yellow", "human", 5, 90, 44, 15, 134, 66, 25, null, "y1.5");
        insertCardToDB(db, 14, "yellow", "human", 15, 226, 110, 37, 380, 186, 70, null, "y1.5");
        insertCardToDB(db, 15, "yellow", "human", 35, 460, 226, 76, 834, 410, 156, null, "y2");
        insertCardToDB(db, 16, "yellow", "human", 99 ,882, 433, 145, 1960, 963, 374, null, "y2");
        insertCardToDB(db, 17, "purple", "human", 5, 84, 52, 14, 126, 78, 23, null, "p1.5");
        insertCardToDB(db, 18, "purple", "human", 15, 212, 130, 34, 357, 220, 64, null, "p1.5");
        insertCardToDB(db, 19, "purple", "human", 35, 432, 266, 68, 784, 483, 140, null, "p2");
        insertCardToDB(db, 20, "purple", "human", 99 ,829, 511, 131, 1843, 1137, 337, null, "p2");
        insertCardToDB(db, 21, "blue", "dragon", 10, 143, 52, 6, 309, 94, 7, null, "dragon2");
        insertCardToDB(db, 22, "blue", "dragon", 15, 358, 134, 17, 616, 198, 18, null, "dragon2");
        insertCardToDB(db, 23, "blue", "dragon", 35, 729, 276, 36, 1354, 431, 39, null, "dragon2");
        insertCardToDB(db, 24, "blue", "dragon", 99, 1398, 532, 70, 3199, 979, 78, null, "dragon2.5");
    }

    //entity class list
    public static abstract class CardEntity implements BaseColumns {
        public static final String TABLE_NAME = "CARD";
        public static final String CARD_ID = "CARD_ID";
        public static final String COLOR = "COLOR";
        public static final String RACE = "RACE";
        public static final String MAX_LEVEL = "MAX_LEVEL";
        public static final String LEVEL_1_HP = "LEVEL_1_HP";
        public static final String LEVEL_1_ATTACK = "LEVEL_1_ATTACK";
        public static final String LEVEL_1_RECOVERY = "LEVEL_1_RECOVERY";
        public static final String LEVEL_MAX_HP = "LEVEL_MAX_HP";
        public static final String LEVEL_MAX_ATTACK = "LEVEL_MAX_ATTACK";
        public static final String LEVEL_MAX_RECOVERY = "LEVEL_MAX_RECOVERY";
        public static final String SKILL = "SKILL";
        public static final String LEADER_SKILL = "LEADER_SKILL";
    }

    //database
    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 2;
    public static final String DATABASE_NAME = "database.db";
    private static final String TEXT_TYPE = " TEXT";
    private static final String INTEGER_TYPE = " INTEGER";
    private static final String REAL_TYPE = " REAL";
    private static final String BLOB_TYPE = " BLOB";
    private static final String COMMA_SEP = ",";

    //create table
    private static final String SQL_CREATE_CARD_ENTITY =
            "CREATE TABLE " + CardEntity.TABLE_NAME + " (" +
                    CardEntity._ID + " INTEGER PRIMARY KEY," +
                    CardEntity.CARD_ID + INTEGER_TYPE + COMMA_SEP +
                    CardEntity.COLOR + TEXT_TYPE + COMMA_SEP +
                    CardEntity.RACE + TEXT_TYPE + COMMA_SEP +
                    CardEntity.MAX_LEVEL + INTEGER_TYPE + COMMA_SEP +
                    CardEntity.LEVEL_1_HP + INTEGER_TYPE + COMMA_SEP +
                    CardEntity.LEVEL_1_ATTACK + INTEGER_TYPE + COMMA_SEP +
                    CardEntity.LEVEL_1_RECOVERY + INTEGER_TYPE + COMMA_SEP +
                    CardEntity.LEVEL_MAX_HP + INTEGER_TYPE + COMMA_SEP +
                    CardEntity.LEVEL_MAX_ATTACK + INTEGER_TYPE + COMMA_SEP +
                    CardEntity.LEVEL_MAX_RECOVERY + INTEGER_TYPE + COMMA_SEP +
                    CardEntity.SKILL + TEXT_TYPE + COMMA_SEP +
                    CardEntity.LEADER_SKILL + TEXT_TYPE +
            " )";

    //card entity id indexing
    private static final String SQL_CARD_ID_INDEXING =
            "CREATE INDEX idxCard ON " + CardEntity.TABLE_NAME + " (" + CardEntity.CARD_ID +
            ")";

    private static final String SQL_DELETE_CARD_ENTITY =
            "DROP TABLE IF EXISTS " + CardEntity.TABLE_NAME;

   public DBHelper(Context context) {
       super(context, DATABASE_NAME, null, DATABASE_VERSION);
   }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_CARD_ENTITY);
        addData(db);
        db.execSQL(SQL_CARD_ID_INDEXING);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_CARD_ENTITY);
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    public void onOpen(SQLiteDatabase db) {
        db.execSQL(SQL_DELETE_CARD_ENTITY);
        db.execSQL(SQL_CREATE_CARD_ENTITY);
        addData(db);
        db.execSQL(SQL_CARD_ID_INDEXING);
    }

    public void closeDB() {
        SQLiteDatabase db = this.getReadableDatabase();
        if (db != null && db.isOpen())
            db.close();
    }

    public long insertCardToDB(SQLiteDatabase db, long id, String color, String race, int maxLevel, int level1HP, int level1Attack, int level1Recovery, int levelMaxHP, int levelMaxAttack, int levelMaxRecovery, String skill, String leaderSkill) {
        Card card = new Card(id, color, race, maxLevel, level1HP, level1Attack, level1Recovery, levelMaxHP, levelMaxAttack, levelMaxRecovery, skill, leaderSkill);
        ContentValues values = new ContentValues();

        values.put(CardEntity.CARD_ID, card.getId());
        values.put(CardEntity.COLOR, card.getColor());
        values.put(CardEntity.RACE, card.getRace());
        values.put(CardEntity.MAX_LEVEL, card.getMaxLevel());
        values.put(CardEntity.LEVEL_1_HP, card.getLevel1HP());
        values.put(CardEntity.LEVEL_1_ATTACK, card.getLevel1Attack());
        values.put(CardEntity.LEVEL_1_RECOVERY, card.getLevel1Recovery());
        values.put(CardEntity.LEVEL_MAX_HP, card.getLevelMaxHP());
        values.put(CardEntity.LEVEL_MAX_ATTACK, card.getLevelMaxAttack());
        values.put(CardEntity.LEVEL_MAX_RECOVERY, card.getLevelMaxRecovery());
        values.put(CardEntity.SKILL, card.getSkill());
        values.put(CardEntity.LEADER_SKILL, card.getLeaderSkill());
        // insert row
        return db.insert(CardEntity.TABLE_NAME, null, values);
    }

    public Card getCard(long id) {
        Card card = new Card();
        SQLiteDatabase db = this.getReadableDatabase();

        //select statement
        String[] projection = {
            CardEntity.CARD_ID,
            CardEntity.COLOR,
            CardEntity.RACE,
            CardEntity.MAX_LEVEL,
            CardEntity.LEVEL_1_HP,
            CardEntity.LEVEL_1_ATTACK,
            CardEntity.LEVEL_1_RECOVERY,
            CardEntity.LEVEL_MAX_HP,
            CardEntity.LEVEL_MAX_ATTACK,
            CardEntity.LEVEL_MAX_RECOVERY,
            CardEntity.SKILL,
            CardEntity.LEADER_SKILL
        };
        String sortOrder =
            CardEntity.CARD_ID + " DESC";
        //query
        Cursor c = db.query(
            CardEntity.TABLE_NAME,               // The table to query
            projection,                              // The columns to return
            CardEntity.CARD_ID + " = " + id,        // The columns for the WHERE clause
            null,                                     // The values for the WHERE clause
            null,                                     // group by
            null,                                     // having
            sortOrder,                                 // order by
            "1"                                        //limit
        );

        //put to model
        if (c.moveToFirst()) {
            //do
                card.setId(c.getLong(c.getColumnIndex(CardEntity.CARD_ID)));
                card.setColor(c.getString(c.getColumnIndex(CardEntity.COLOR)));
                card.setRace(c.getString(c.getColumnIndex(CardEntity.RACE)));
                card.setMaxLevel(c.getInt(c.getColumnIndex(CardEntity.MAX_LEVEL)));
                card.setLevel1HP(c.getInt(c.getColumnIndex(CardEntity.LEVEL_1_HP)));
                card.setLevel1Attack(c.getInt(c.getColumnIndex(CardEntity.LEVEL_1_ATTACK)));
                card.setLevel1Recovery(c.getInt(c.getColumnIndex(CardEntity.LEVEL_1_RECOVERY)));
                card.setLevelMaxHP(c.getInt(c.getColumnIndex(CardEntity.LEVEL_MAX_HP)));
                card.setLevelMaxAttack(c.getInt(c.getColumnIndex(CardEntity.LEVEL_MAX_ATTACK)));
                card.setLevelMaxRecovery(c.getInt(c.getColumnIndex(CardEntity.LEVEL_MAX_RECOVERY)));
                card.setSkill(c.getString(c.getColumnIndex(CardEntity.SKILL)));
                card.setLeaderSkill(c.getString(c.getColumnIndex(CardEntity.LEADER_SKILL)));
            //} while (c.moveToNext());
        }
        return card;
    }
}
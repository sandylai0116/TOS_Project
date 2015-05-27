package com.project.tos_project;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.project.tos_project.model.Card;

import java.util.List;

public class Home extends ActionBarActivity {

    // Database Helper
    DBHelper db;

    private TextView view;

    public long insertCardToDB( DBHelper db, long id, String color, String race, int maxLevel, int level1HP, int level1Attack, int level1Recovery, int levelMaxHP, int levelMaxAttack, int levelMaxRecovery, String skill, String leaderSkill){
        Card card = new Card(id, color, race, maxLevel, level1HP, level1Attack, level1Recovery, levelMaxHP, levelMaxAttack, levelMaxRecovery, skill, leaderSkill);
        return db.createToCard(card);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        db = new DBHelper(getApplicationContext());

        //add data to database
        insertCardToDB(db, 1, "blue", "human", 5, 86, 47, 15, 129, 71, 24, null, "b1.5");
        insertCardToDB(db, 2, "blue", "human", 15, 216, 118, 36, 364, 200, 68, null, "b1.5");
        insertCardToDB(db, 3, "blue", "human", 35, 441, 242, 74, 801, 440, 151, null, "b2");
        insertCardToDB(db, 4, "blue", "human", 99, 846, 465, 141, 1881, 1035, 364, null, "b2");
        insertCardToDB(db, 5, "red", "human", 5, 91, 51, 13, 136, 76, 21, null, "r1.5");
        insertCardToDB(db, 6, "red", "human", 15, 228, 127, 32, 384, 214, 60, null, "r1.5");
        insertCardToDB(db, 7, "red", "human", 35, 464, 259, 66, 842, 470, 135, null, "r2");
        
        //create 6 card
        Card card[] = new Card[6];
        for(int i=0;i<6;i++) {
            card[i] = db.getCard(1); //assume card no is 1
        }
        //calculation
        for(int i=0;i<6;i++) {
            card[i].setCurrentLevel(5); //assume current level is 5
            card[i].setCalculatedAttack( card[i].getCurrentAttack() );
        }

        //calculated final attack
        int finalAttack = 0;
        for(int i=0;i<6;i++) {
            finalAttack += card[i].getCalculatedAttack();
        }

        //get card
        //view = (TextView)findViewById(R.id.testView);
        //view.append(" " + finalAttack );
        System.out.println(finalAttack);


        //close db
        db.closeDB();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

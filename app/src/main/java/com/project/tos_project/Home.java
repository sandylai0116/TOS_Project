package com.project.tos_project;


import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.*;
import android.view.View;

import com.project.tos_project.model.Card;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Home extends ActionBarActivity{

    // Database Helper
    DBHelper db;

    private TextView view;
    private ImageButton card1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        db = new DBHelper(getApplicationContext());

        card1 =(ImageButton) findViewById(R.id.card1);

        //create 6 card
        Card card[] = new Card[6];


        card1.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v){
                Toast.makeText(getApplicationContext(), "Hello ",
                        Toast.LENGTH_SHORT).show();
                try
                {
                    // get input stream
                    InputStream ims = getAssets().open("card/card-1.png");
                    // load image as Drawable
                    Drawable d = Drawable.createFromStream(ims, null);
                    // set image to ImageView
                    card1.setImageDrawable(d);
                }
                catch(IOException ex)
                {
                    return;
                }
            }
        });


        //assume card NO is 1
        //assume current level is 5
        for(int i=0;i<6;i++) {
            card[i] = db.getCard(1);
            card[i].setCurrentLevel(5);
        }

        //assume combo is 3
        int combo =3;

        //calculate leader skill
        LeaderSkill.processLeaderSkill(card);

        //calculate final attack
        int finalAttack = 0;
        for(int i=0;i<6;i++) {
            finalAttack += card[i].getCalculatedAttack();
        }

        //get card
        System.out.println(card[0].getCalculatedAttack() + "," + card[1].getCalculatedAttack() + "," + card[2].getCalculatedAttack() + ","
                + card[3].getCalculatedAttack() + "," + card[4].getCalculatedAttack() + "," + card[5].getCalculatedAttack());
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

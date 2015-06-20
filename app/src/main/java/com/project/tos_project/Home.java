package com.project.tos_project;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.InputType;
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
    private ImageButton card1, card2, card3, card4, card5, card6;
    private final static int REQUEST_CODE = 1;
    private EditText md;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        md = (EditText)findViewById(R.id.monsterDefense);

        db = new DBHelper(getApplicationContext());

        card1 =(ImageButton) findViewById(R.id.card1);
        card2 =(ImageButton) findViewById(R.id.card2);
        card3 =(ImageButton) findViewById(R.id.card3);
        card4 =(ImageButton) findViewById(R.id.card4);
        card5 =(ImageButton) findViewById(R.id.card5);
        card6 =(ImageButton) findViewById(R.id.card6);

       card1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               selectCard("card1");
           }
       });

        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectCard("card1");
            }
        });

        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectCard("card2");
            }
        });

        card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectCard("card3");
            }
        });

        card4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectCard("card4");
            }
        });

        card5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectCard("card5");
            }
        });

        card6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectCard("card6");
            }
        });

        //test
        Computation.testFinalAttack(db);

        //close db
        db.closeDB();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == SelectCardActivity.RESULT_CODE) {
            if (data.hasExtra("returnCardLV")) {
                EditText tv = (EditText) findViewById(R.id.monsterDefense);
                String cardNo = data.getExtras().getString("cardNo");
                String btnNo = data.getExtras().getString("btnNo");
                switch (btnNo) {
                    case "card1":
                        try {
                            InputStream ims = getAssets().open(cardNo);
                            Drawable d = Drawable.createFromStream(ims, null);
                            card1.setImageDrawable(d);
                        }catch(Exception e){
                            card1.setImageResource(R.drawable.card_unknow);
                        }
                        break;
                    case "card2":
                        try {
                            InputStream ims = getAssets().open(cardNo);
                            Drawable d = Drawable.createFromStream(ims, null);
                            card2.setImageDrawable(d);
                        }catch(Exception e){
                            card2.setImageResource(R.drawable.card_unknow);
                        }
                        break;
                    case "card3":
                        try {
                            InputStream ims = getAssets().open(cardNo);
                            Drawable d = Drawable.createFromStream(ims, null);
                            card3.setImageDrawable(d);
                        }catch(Exception e){
                            card3.setImageResource(R.drawable.card_unknow);
                        }
                        break;
                    case "card4":
                        try {
                            InputStream ims = getAssets().open(cardNo);
                            Drawable d = Drawable.createFromStream(ims, null);
                            card4.setImageDrawable(d);
                        }catch(Exception e){
                            card4.setImageResource(R.drawable.card_unknow);
                        }
                        break;
                    case "card5":
                        try {
                            InputStream ims = getAssets().open(cardNo);
                            Drawable d = Drawable.createFromStream(ims, null);
                            card5.setImageDrawable(d);
                        }catch(Exception e){
                            card5.setImageResource(R.drawable.card_unknow);
                        }
                        break;
                    case "card6":
                        try {
                            InputStream ims = getAssets().open(cardNo);
                            Drawable d = Drawable.createFromStream(ims, null);
                            card6.setImageDrawable(d);
                        }catch(Exception e){
                            card6.setImageResource(R.drawable.card_unknow);
                        }
                        break;
                    default:
                        break;
                }

//                card1.setImageResource(R.drawable.card_unknow);

              //  tv.setText(data.getExtras().getString("returnCardLV"));
       //         tv.setText(data.getExtras().getString("cardNo"));
            }
        }
    }

    // selectCard will be running when image button clicked
    public void selectCard(String btnNo){
        //  set the target activity
        Intent intent = new Intent(this, SelectCardActivity.class);
        // set the value
        intent.putExtra("btnNo", btnNo);
        // go to another activity
        startActivityForResult(intent, REQUEST_CODE);
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

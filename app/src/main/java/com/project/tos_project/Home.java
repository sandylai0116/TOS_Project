package com.project.tos_project;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.*;
import android.view.View;

import com.project.tos_project.model.Battle;
import com.project.tos_project.model.Card;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Home extends ActionBarActivity{

    // Database Helper
    DBHelper db;

    private TextView view;
    private ImageButton cardButton[] = new ImageButton[6];
    private final static int REQUEST_CODE = 1;
    private EditText tv;
    private Button calBtn;
    Battle battle;
    Card card[] = new Card[6];
    int[] selectedCard = {0,0,0,0,0,0};
    int[] cardLevel = {0,0,0,0,0,0};
    public final static String SER_KEY = "com.project.tos_project.model.ser";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

       tv = (EditText) findViewById(R.id.monsterDefense);

        db = new DBHelper(getApplicationContext());
        battle = new Battle();

        cardButton[0] =(ImageButton) findViewById(R.id.card1);
        cardButton[1] =(ImageButton) findViewById(R.id.card2);
        cardButton[2] =(ImageButton) findViewById(R.id.card3);
        cardButton[3] =(ImageButton) findViewById(R.id.card4);
        cardButton[4] =(ImageButton) findViewById(R.id.card5);
        cardButton[5] =(ImageButton) findViewById(R.id.card6);

        calBtn =(Button)findViewById(R.id.calculateBtn);

        for(int i=0; i<card.length; i++){
            if(card[i] == null){
                card[i] = db.getCard(0);
                card[i].setCurrentLevel(0);
            }
        }

        calBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
        //       for(int i=0; i<card.length; i++){
        //           card[i] = db.getCard(selectedCard[i]);
        //           card[i].setCurrentLevel(cardLevel[i]);
        //       }
          //      tv.setText(Integer.toString(0));
                Computation.finalAttack(battle, card);
            }
        });

        cardButton[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectCard(0, selectedCard, cardLevel);
            }
        });

        cardButton[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectCard(1, selectedCard, cardLevel);
            }
        });

        cardButton[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectCard(2, selectedCard, cardLevel);
            }
        });

        cardButton[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectCard(3, selectedCard, cardLevel);
            }
        });

        cardButton[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectCard(4, selectedCard, cardLevel);
            }
        });

        cardButton[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectCard(5, selectedCard, cardLevel);
            }
        });

        //test
        //Computation.testFinalAttack(db);

        //close db
        db.closeDB();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == SelectCardActivity.RESULT_CODE) {
            if (data.hasExtra("card")) {
                String cardNum = data.getExtras().getString("cardNo");
                int index = data.getExtras().getInt("selectIndex");
                selectedCard = data.getExtras().getIntArray("card");
                cardLevel = data.getExtras().getIntArray("cardLVSel");
                        try {
                            InputStream ims = getAssets().open("card/card-" + cardNum + ".png");
                            Drawable d = Drawable.createFromStream(ims, null);
                            cardButton[index].setImageDrawable(d);
                        } catch (Exception e) {
                            cardButton[index].setImageResource(R.drawable.card_unknow);
                        }
            //    String cardLv = data.getExtras().getString("returnCardLV");
            //    String[] cardNo = cardImage.split("-");
            //    String cardNum = cardNo[1].substring(0, cardNo[1].length() - 4);
                //    String btnNo = data.getExtras().getString("btnNo");
            //    Card c = (Card) data.getExtras().getSerializable("returnCardData");
            /*    switch (btnNo) {
                    case "card1":
                        try {
                            InputStream ims = getAssets().open(cardImage);
                            Drawable d = Drawable.createFromStream(ims, null);
                            card1.setImageDrawable(d);
                        }catch(Exception e){
                            card1.setImageResource(R.drawable.card_unknow);
                        }
                        card[0] =  db.getCard(Integer.parseInt(cardNum));
                        card[0].setCurrentLevel(Integer.parseInt(cardLv));
                        break;
                    case "card2":
                        try {
                            InputStream ims = getAssets().open(cardImage);
                            Drawable d = Drawable.createFromStream(ims, null);
                            card2.setImageDrawable(d);
                        }catch(Exception e){
                            card2.setImageResource(R.drawable.card_unknow);
                        }
                        Log.d("test1", String.valueOf(card));
                        card[1] =  db.getCard(Integer.parseInt(cardNum));
                        card[1].setCurrentLevel(Integer.parseInt(cardLv));
                        break;
                    case "card3":
                        try {
                            InputStream ims = getAssets().open(cardImage);
                            Drawable d = Drawable.createFromStream(ims, null);
                            card3.setImageDrawable(d);
                        }catch(Exception e){
                            card3.setImageResource(R.drawable.card_unknow);
                        }
                        Log.d("test2", String.valueOf(card));
                        card[2] =  db.getCard(Integer.parseInt(cardNum));
                        card[2].setCurrentLevel(Integer.parseInt(cardLv));
                        break;
                    case "card4":
                        try {
                            InputStream ims = getAssets().open(cardImage);
                            Drawable d = Drawable.createFromStream(ims, null);
                            card4.setImageDrawable(d);
                        }catch(Exception e){
                            card4.setImageResource(R.drawable.card_unknow);
                        }
                        card[3] =  db.getCard(Integer.parseInt(cardNum));
                        card[3].setCurrentLevel(Integer.parseInt(cardLv));
                        break;
                    case "card5":
                        try {
                            InputStream ims = getAssets().open(cardImage);
                            Drawable d = Drawable.createFromStream(ims, null);
                            card5.setImageDrawable(d);
                        }catch(Exception e){
                            card5.setImageResource(R.drawable.card_unknow);
                        }
                        card[4] =  db.getCard(Integer.parseInt(cardNum));
                        card[4].setCurrentLevel(Integer.parseInt(cardLv));
                        break;
                    case "card6":
                        try {
                            InputStream ims = getAssets().open(cardImage);
                            Drawable d = Drawable.createFromStream(ims, null);
                            card6.setImageDrawable(d);
                        }catch(Exception e){
                            card6.setImageResource(R.drawable.card_unknow);
                        }
                        card[5] =  db.getCard(Integer.parseInt(cardNum));
                        card[5].setCurrentLevel(Integer.parseInt(cardLv));
                        break;
                    default:
                        break;
                }
    */
//                card1.setImageResource(R.drawable.card_unknow);

              //  tv.setText(data.getExtras().getString("returnCardLV"));
                tv.setText(cardNum);
            }
        }
    }

    // selectCard will be running when image button clicked
    public void selectCard(int btnNo, int selCard[],  int selCardLv[]){
        //  set the target activity
        Intent intent = new Intent(this, SelectCardActivity.class);
        // set the value
        Bundle mBundle = new Bundle();
        intent.putExtra("cardSelData", selCard);
        intent.putExtra("cardLVData", selCardLv);
    //    intent.putExtra("cardData", mBundle);
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

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
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putIntArray("selectedCard", selectedCard);
        outState.putIntArray("cardLevel", cardLevel);
        outState.putParcelable("battle", battle);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

       tv = (EditText) findViewById(R.id.monsterDefense);

        db = new DBHelper(getApplicationContext());

        battle = new Battle();
        Computation.testPreSetBattle(battle); // the line should be deleted after some works are done

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

        if( savedInstanceState != null ) {
            selectedCard = savedInstanceState.getIntArray("selectedCard");
            cardLevel = savedInstanceState.getIntArray("cardLevel");
            battle = savedInstanceState.getParcelable("battle");
        }

        calBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
              for(int i=0; i<card.length; i++){
                   card[i] = db.getCard(selectedCard[i]);
                   card[i].setCurrentLevel(cardLevel[i]);
               }
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
                battle = (Battle) data.getExtras().getParcelable("battle");
                for(int i=0; i<selectedCard.length; i++) {
                    if(selectedCard[i] != 0) {
                        try {
                            InputStream ims = getAssets().open("card/card-" + selectedCard[i] + ".png");
                            Drawable d = Drawable.createFromStream(ims, null);
                            cardButton[i].setImageDrawable(d);
                        } catch (Exception e) {
                            cardButton[i].setImageResource(R.drawable.card_unknow);
                        }
                    }
                }
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
        mBundle.putParcelable(SER_KEY, battle);
        //    intent.putExtra("cardData", mBundle);
        intent.putExtra("btnNo", btnNo);
        intent.putExtras(mBundle);

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

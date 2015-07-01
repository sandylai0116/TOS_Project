package com.project.tos_project;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Home extends ActionBarActivity{

    // Database Helper
    DBHelper db;

    private TextView view;
    private ImageView cardButton[] = new ImageView[6];
    private final static int REQUEST_CODE = 1;
    private EditText tv;
    private Button calBtn;
    Battle battle;
    Card card[] = new Card[6];
    int[] selectedCard = {0,0,0,0,0,0};
    int[] cardLevel = {0,0,0,0,0,0};
    boolean isFive = false;
    int[] disableCard = {-1,-1,-1,-1,-1,-1};
    Integer[] combinCard ={656, 657, 658, 659, 660, 666, 667, 668, 669, 670, 721, 722, 723, 724, 725};
    int fiveInOne = 620;
  //  int[] combinCard = {620, 656, 657, 658, 659, 660, 666, 667, 668, 669, 670, 721, 722, 723, 724, 725};
    public final static String SER_KEY = "com.project.tos_project.model.ser";

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putIntArray("selectedCard", selectedCard);
        outState.putIntArray("cardLevel", cardLevel);
        outState.putParcelable("battle", battle);
   //     outState.putIntArray("disbaleCard", disableCard);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

       tv = (EditText) findViewById(R.id.monsterDefense);

        db = new DBHelper(getApplicationContext());

        battle = new Battle();
        Computation.testPreSetBattle(battle); // the line should be deleted after some works are done

        LinearLayout cardArea = (LinearLayout)findViewById(R.id.cardArea);

        cardButton[0] =(ImageView) findViewById(R.id.card1);
        cardButton[1] =(ImageView) findViewById(R.id.card2);
        cardButton[2] =(ImageView) findViewById(R.id.card3);
        cardButton[3] =(ImageView) findViewById(R.id.card4);
        cardButton[4] =(ImageView) findViewById(R.id.card5);
        cardButton[5] =(ImageView) findViewById(R.id.card6);

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
        //    disableCard = savedInstanceState.getIntArray("disableCard");
        }

        printButton();

        calBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                for (int i = 0; i < card.length; i++) {
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
        //        disableCard = data.getExtras().getIntArray("disableData");


                // card 620
                if(selectedCard[0] == fiveInOne){
                    isFive = true;
                    LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 5f);
                    LinearLayout.LayoutParams hlp = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 0f);
                    lp.setMargins(4, 4, 4, 4);
                    cardButton[0].setLayoutParams(lp);
                    for(int i=1; i<5; i++){
                        cardButton[i].setLayoutParams(hlp);
                    }
                }
                else {
                       if (Arrays.asList(combinCard).contains(Integer.parseInt(cardNum))) {
                           LinearLayout.LayoutParams conlp = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 2f);
                           conlp.setMargins(4, 4, 4, 4);
                           LinearLayout.LayoutParams hlp = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 0f);
                           cardButton[index].setLayoutParams(conlp);
                           cardButton[index + 1].setLayoutParams(hlp);
                           disableCard[index+1] = 0;
                           disableCard[index] = 0;
                       }
                       else {
                           LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 1f);
                           lp.setMargins(4, 4, 4, 4);
                           if(index < 5) {
                               disableCard[index + 1] = -1;
                           }
                           disableCard[index] = -1;
                           for (int i = 0; i < selectedCard.length; i++) {
                                   if(disableCard[i] == -1) {
                                       cardButton[i].setLayoutParams(lp);
                                   }
                           }
                       }

                }

    /*            if(!isFive) {
                    if (Arrays.asList(combinCard).contains(Integer.parseInt(cardNum))) {
                        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 2f);
                        LinearLayout.LayoutParams hlp = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 0f);
                        lp.setMargins(4, 4, 4, 4);
                        //           cardButton[index].setLayoutParams(new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 2f));
                        cardButton[index].setLayoutParams(lp);
                        //   cardButton[index+1].setVisibility(View.INVISIBLE);
                        cardButton[index + 1].setLayoutParams(hlp);
                    } else {
                        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 1f);
                        lp.setMargins(4, 4, 4, 4);
                        cardButton[index].setLayoutParams(lp);
                    }
                }
*/
                printButton();
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
  //      intent.putExtra("disableData", disableCard);
        mBundle.putParcelable(SER_KEY, battle);
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

    public void printButton(){

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
            else{
                //  cardButton[i].setBackgroundColor(Color.parseColor("#80C0C0C0"));
                cardButton[i].setImageResource(0);
                cardButton[i].setImageDrawable(null);
            }
        }
    }

}

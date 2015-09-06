package com.project.tos_project;


import android.app.Activity;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.DragEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.*;
import android.view.View;

import com.project.tos_project.model.Battle;
import com.project.tos_project.model.Card;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;

public class Home extends Activity implements View.OnDragListener{

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
    GridView gridview;
    private int draggedIndex = -1;
    private BaseAdapter adapter;
    ArrayList<Integer> mThumbIds = new ArrayList<Integer>();
    int col = 0;
    int row = 0;
    int prevCol = 0;
    int prevRow = 0;
    int prevItem;
    LinearLayout topArea;
    LinearLayout homeArea;


    //  int[] combinCard = {620, 656, 657, 658, 659, 660, 666, 667, 668, 669, 670, 721, 722, 723, 724, 725};
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

        mThumbIds.add(R.drawable.enemy1); mThumbIds.add(R.drawable.enemy2);
        mThumbIds.add(R.drawable.enemy1); mThumbIds.add(R.drawable.enemy2);
        mThumbIds.add(R.drawable.enemy1); mThumbIds.add(R.drawable.enemy2);
        mThumbIds.add(R.drawable.enemy1); mThumbIds.add(R.drawable.enemy2);
        mThumbIds.add(R.drawable.enemy1); mThumbIds.add(R.drawable.enemy2);
        mThumbIds.add(R.drawable.enemy1); mThumbIds.add(R.drawable.enemy2);
        mThumbIds.add(R.drawable.enemy1); mThumbIds.add(R.drawable.enemy2);
        mThumbIds.add(R.drawable.enemy1); mThumbIds.add(R.drawable.enemy2);
        mThumbIds.add(R.drawable.enemy1); mThumbIds.add(R.drawable.enemy2);
        mThumbIds.add(R.drawable.enemy1); mThumbIds.add(R.drawable.enemy2);
        mThumbIds.add(R.drawable.enemy1); mThumbIds.add(R.drawable.enemy2);
        mThumbIds.add(R.drawable.enemy1); mThumbIds.add(R.drawable.enemy2);
        mThumbIds.add(R.drawable.enemy1); mThumbIds.add(R.drawable.enemy2);
        mThumbIds.add(R.drawable.enemy1); mThumbIds.add(R.drawable.enemy2);
        mThumbIds.add(R.drawable.enemy1); mThumbIds.add(R.drawable.enemy2);

       tv = (EditText) findViewById(R.id.monsterDefense);

        db = new DBHelper(getApplicationContext());

        battle = new Battle();
        Computation.testPreSetBattle(battle); // the line should be deleted after some works are done

        topArea = (LinearLayout)findViewById(R.id.topArea);
        homeArea = (LinearLayout)findViewById(R.id.homeArea);

        cardButton[0] =(ImageView) findViewById(R.id.card1);
        cardButton[1] =(ImageView) findViewById(R.id.card2);
        cardButton[2] =(ImageView) findViewById(R.id.card3);
        cardButton[3] =(ImageView) findViewById(R.id.card4);
        cardButton[4] =(ImageView) findViewById(R.id.card5);
        cardButton[5] =(ImageView) findViewById(R.id.card6);


        gridview = (GridView) findViewById(R.id.gridviewElement);
        gridview.setOnItemLongClickListener(new GridView.OnItemLongClickListener() {
            public boolean onItemLongClick(AdapterView gridView, View view,
                                           int position, long row) {
                ClipData.Item item = new ClipData.Item((String) view.getTag());
                ClipData clipData = new ClipData((CharSequence) view.getTag(),
                        new String[]{ClipDescription.MIMETYPE_TEXT_PLAIN}, item);
                view.startDrag(clipData, new View.DragShadowBuilder(view), null, 0);

                //        trashCan.setVisibility(View.VISIBLE);
                gridView.setOnDragListener(Home.this);

                draggedIndex = position;
                return true;
            }
        });
      //  gridview.setAdapter(new ImageAdapter(this));
        gridview.setAdapter(adapter = new BaseAdapter() {

            public int getCount() {
                return mThumbIds.size();
            }
            public Object getItem(int position) {
                return mThumbIds.get(position);
            }
            public long getItemId(int position) {
                return position;
            }

            // create a new ImageView for each item referenced by the Adapter
            public View getView(int position, View convertView, ViewGroup parent) {
                ImageView imageView;

                Resources r = Resources.getSystem();
                float px = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 55, r.getDisplayMetrics());

                if (convertView == null) {  //if it's not recycled, initialize some 				attributes
                    imageView = new ImageView(Home.this);
                    imageView.setLayoutParams(new
                            GridView.LayoutParams((int) px, (int) px));
                    imageView.setScaleType(
                            ImageView.ScaleType.CENTER_CROP);
                    imageView.setPadding(5, 5, 5, 5);
                } else {
                    imageView = (ImageView) convertView;
                }

                imageView.setImageResource(mThumbIds.get(position));
                if(position == draggedIndex){
                    imageView.setAlpha(100);
                }
                else{
                    imageView.setAlpha(255);
                }
                imageView.setTag(String.valueOf(position));

                return imageView;
            }
        });

        //    calBtn =(Button)findViewById(R.id.calculateBtn);


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
  //          disableCard = savedInstanceState.getIntArray("disableCard");
        }

        printButton();
/*
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
*/
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
                if(!cardNum.equals("0")) {
                    int index = data.getExtras().getInt("selectIndex");
                    selectedCard = data.getExtras().getIntArray("card");
                    cardLevel = data.getExtras().getIntArray("cardLVSel");
                    battle = (Battle) data.getExtras().getParcelable("battle");
                    //          disableCard = data.getExtras().getIntArray("disableData");
                }
                else{
                    int index = data.getExtras().getInt("selectIndex");
                    selectedCard = data.getExtras().getIntArray("card");
                    cardLevel = data.getExtras().getIntArray("cardLVSel");
                    battle = (Battle) data.getExtras().getParcelable("battle");
                    selectedCard[index] = 0;
                }
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
  //     intent.putExtra("disableData", disableCard);
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
    public boolean onDrag(View view, DragEvent dragEvent) {

        int yCoordinate = homeArea.getHeight() - topArea.getHeight();

        switch (dragEvent.getAction()) {
            case DragEvent.ACTION_DRAG_STARTED:
                // Drag has started
                // If called for trash resize the view and return true
   //             Log.v("test", "Start: "+String.valueOf(row));

                break;

            case DragEvent.ACTION_DRAG_ENTERED:
                Log.v("Enter", "Enter"+String.valueOf(dragEvent.getY()));

                int viewHeight = view.getHeight() / 5;
                int viewWidth = view.getWidth() / 6;

                if(dragEvent.getX() <= viewWidth){
                    col = 0;
                }else if(dragEvent.getX() <= viewWidth * 2){
                    col = 1;
                }else if(dragEvent.getX() <= viewWidth * 3){
                    col = 2;
                }else if(dragEvent.getX() <= viewWidth * 4){
                    col = 3;
                }else if(dragEvent.getX() <= viewWidth * 5){
                    col = 4;
                }else if(dragEvent.getX() <= viewWidth * 6){
                    col = 5;
                }

                if(dragEvent.getY() <=  viewHeight){
                    row = 0;
                }else if(dragEvent.getY() <= viewHeight * 2){
                    row = 1;
                }else if(dragEvent.getY() <= viewHeight * 3){
                    row = 2;
                }else if(dragEvent.getY() <= viewHeight * 4){
                    row = 3;
                }else if(dragEvent.getY() <= viewHeight * 5){
                    row = 4;
                }



                break;
            case DragEvent.ACTION_DRAG_LOCATION:
        //      Log.v("test", String.valueOf(dragEvent.getY()));

                int viewHeight1 = view.getHeight() / 5;
                int viewWidth1 = view.getWidth() / 6;

      //          Log.v("height", String.valueOf(viewHeight1));
      //          Log.v("width", String.valueOf(viewWidth1));

                prevCol = col;
                prevRow = row;
                prevItem = mThumbIds.get(draggedIndex);

                if(dragEvent.getX() <= viewWidth1){
                    col = 0;
                }else if(dragEvent.getX() <= viewWidth1 * 2){
                    col = 1;
                }else if(dragEvent.getX() <= viewWidth1 * 3){
                    col = 2;
                }else if(dragEvent.getX() <= viewWidth1 * 4){
                    col = 3;
                }else if(dragEvent.getX() <= viewWidth1 * 5){
                    col = 4;
                }else if(dragEvent.getX() <= viewWidth1 * 6){
                    col = 5;
                }

                if(dragEvent.getY() <=  viewHeight1){
                    row = 0;
                }else if(dragEvent.getY() <= viewHeight1 * 2){
                    row = 1;
                }else if(dragEvent.getY() <= viewHeight1 * 3){
                    row = 2;
                }else if(dragEvent.getY() <= viewHeight1 * 4){
                    row = 3;
                }else if(dragEvent.getY() <= viewHeight1 * 5){
                    row = 4;
                }

                if(col > prevCol){
                    mThumbIds.set(draggedIndex, (mThumbIds.get(draggedIndex+1)));
                    mThumbIds.set(draggedIndex+1, prevItem);
                    draggedIndex = draggedIndex+1;
                }
                else if(col < prevCol){
                    mThumbIds.set(draggedIndex, (mThumbIds.get(draggedIndex-1)));
                    mThumbIds.set(draggedIndex-1, prevItem);
                    draggedIndex = draggedIndex-1;
                }

                if(row > prevRow){
                    mThumbIds.set(draggedIndex, (mThumbIds.get(draggedIndex+6)));
                    mThumbIds.set(draggedIndex+6, prevItem);
                    draggedIndex = draggedIndex+6;
                }
                else if(row < prevRow){
                    mThumbIds.set(draggedIndex, (mThumbIds.get(draggedIndex-6)));
                    mThumbIds.set(draggedIndex-6, prevItem);
                    draggedIndex = draggedIndex-6;
                }

    //            Log.v("test", String.valueOf(row+" "+prevRow));
    //           Log.v("test", String.valueOf(draggedIndex));


       //         if(dragEvent.getX() >= view.getWidth() / 6)
      //          if(!(view.getTag().toString().equals(draggedIndex))){
      //              mThumbIds.set(draggedIndex, (mThumbIds.get(Integer.valueOf(view.getTag().toString()))));
      //              draggedIndex = Integer.valueOf(view.getTag().toString());
      //          }
                adapter.notifyDataSetChanged();
      //          view.invalidate();

      //          Log.v("test", String.valueOf(view.getX()));
                break;
            case DragEvent.ACTION_DROP:

                break;
            case DragEvent.ACTION_DRAG_EXITED:

                view.setOnDragListener(null);

    //            view.invalidate();
                break;
            case DragEvent.ACTION_DRAG_ENDED:


                Log.v("test", "Exit");
                row = -1;
                col = -1;
                draggedIndex = -1;
                adapter.notifyDataSetChanged();
                Computation.finalAttack(battle, card);
                // Hide the trash can
                view.setOnDragListener(null);
        //        return true;
                break;
        }
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

        if(selectedCard[0] == fiveInOne){
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 5f);
            LinearLayout.LayoutParams hlp = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 0f);
            lp.setMargins(4, 4, 4, 4);
            cardButton[0].setLayoutParams(lp);
            for(int i=1; i<5; i++){
                cardButton[i].setLayoutParams(hlp);
            }
        }
        else {
            for(int i=0; i<selectedCard.length; i++) {
                if (Arrays.asList(combinCard).contains(selectedCard[i])) {
                    LinearLayout.LayoutParams conlp = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 2f);
                    conlp.setMargins(4, 4, 4, 4);
                    LinearLayout.LayoutParams hlp = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 0f);
                    cardButton[i].setLayoutParams(conlp);
                    cardButton[i + 1].setLayoutParams(hlp);
                    disableCard[i + 1] = 0;
                    disableCard[i] = 0;
                } else {
                    LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 1f);
                    lp.setMargins(4, 4, 4, 4);
                    if (i < 5) {
                        disableCard[i + 1] = -1;
                    }
                    disableCard[i] = -1;

                    if(i > 0) {
                        if (!Arrays.asList(combinCard).contains(selectedCard[i - 1])) {
                            cardButton[i].setLayoutParams(lp);
                        }
                    }
                    else{
                        cardButton[i].setLayoutParams(lp);
                    }
                }
            }

        }

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

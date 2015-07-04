package com.project.tos_project;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.project.tos_project.model.Battle;
import com.project.tos_project.model.Card;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SelectCardActivity extends ActionBarActivity{
    SQLiteDatabase db;
    Bitmap bitmap;
    DBHelper dbHelper;
    Battle battle;
    GridView gridview;
    int[] card, cardLVSel, disbaleCard;
    List<String> mThumbIds = new ArrayList<String>();
    ArrayList<String> color = new ArrayList<String>();
    ArrayList<String> race = new ArrayList<String>();
    final int[] filterColorBtn = {R.id.blue_icon , R.id.red_icon, R.id.green_icon, R.id.yellow_icon, R.id.purple_icon};
    final int[] filterRaceBtn = {R.id.god_icon, R.id.fiend_icon, R.id.human_icon, R.id.beast_icon, R.id.dragon_icon, R.id.elf_icon, R.id.evolve_icon, R.id.level_up_icon};
    final int[] filterColorImage = {R.drawable.blue_icon , R.drawable.red_icon, R.drawable.green_icon, R.drawable.yellow_icon, R.drawable.purple_icon};
    final int[] filterRaceImage = {R.drawable.god_icon, R.drawable.fiend_icon, R.drawable.human_icon, R.drawable.beast_icon, R.drawable.dragon_icon, R.drawable.elf_icon, R.drawable.evolve_icon, R.drawable.level_up_icon};
    final int[] darkFilterColorImage = {R.drawable.dark_blue_icon , R.drawable.dark_red_icon, R.drawable.dark_green_icon, R.drawable.dark_yellow_icon, R.drawable.dark_purple_icon};
    final int[] darkFilterRaceImage = {R.drawable.dark_god_icon, R.drawable.dark_fiend_icon, R.drawable.dark_human_icon, R.drawable.dark_beast_icon, R.drawable.dark_dragon_icon, R.drawable.dark_elf_icon, R.drawable.dark_evolve_icon, R.drawable.dark_level_up_icon};
    final String[] colorFilter = {"blue", "red", "green", "yellow", "purple"};
    final String[] raceFilter = {"god", "demon", "human", "beast", "dragon", "elf", "evolveElements", "levelUpElements"};
    final int[] tempCol = {-1, -1, -1, -1, -1};
    final int[] tempRace = {-1, -1, -1, -1, -1, -1, -1, -1};
    Cursor cursor;
    Home h = new Home();
    Integer[] combinCard = h.combinCard;
    int fiveInOne = h.fiveInOne;
    public final static int RESULT_CODE  = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_card);
        gridview = (GridView) findViewById(R.id.gridview);
        final ImageButton ib = (ImageButton) findViewById(R.id.searchCard);
        card = getIntent().getIntArrayExtra("cardSelData");
        cardLVSel = getIntent().getIntArrayExtra("cardLVData");
        disbaleCard = getIntent().getIntArrayExtra("disableData");

        ib.setOnClickListener(new ImageView.OnClickListener(){

            @Override
            public void onClick(View v) {
                LayoutInflater layoutInflater
                            = (LayoutInflater) getBaseContext()
                            .getSystemService(LAYOUT_INFLATER_SERVICE);
                View popupView = layoutInflater.inflate(R.layout.activity_card_filter, null);
                final PopupWindow popupWindow = new PopupWindow(
                            popupView,
                            LinearLayout.LayoutParams.WRAP_CONTENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT);

                popupWindow.setOutsideTouchable(true);
                popupWindow.setFocusable(true);

                    final Button okbtn = (Button) popupView.findViewById(R.id.OK);

                    for (int i = 0; i < filterColorBtn.length; i++) {
                        final ImageView b = (ImageView) popupView.findViewById(filterColorBtn[i]);
                        b.setOnClickListener(new MyListener(b, i, "color"));
                        if(tempCol[i] == 0){
                            b.setImageResource(filterColorImage[i]);
                        }
                    }

                    for (int i = 0; i < filterRaceBtn.length; i++) {
                        final ImageView b = (ImageView) popupView.findViewById(filterRaceBtn[i]);
                        b.setOnClickListener(new MyListener(b, i, "race"));
                        if(tempRace[i] == 0){
                            b.setImageResource(filterRaceImage[i]);
                        }
                    }

                    okbtn.setOnClickListener(new Button.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            // TODO Auto-generated method stub
                            popupWindow.dismiss();
                        }
                    });

                    popupWindow.showAsDropDown(ib, 50, -30);

            }});


        // cancel card
        mThumbIds.add("card/card-0.png");

        battle = (Battle)getIntent().getParcelableExtra(Home.SER_KEY);
        try {
            // eg. 1 - RawQuery
            dbHelper = new DBHelper(SelectCardActivity.this);
            db = dbHelper.getWritableDatabase();
            cursor = dbHelper.query(db, "SELECT CARD_ID as cardNo FROM CARD", null);
            while (cursor.moveToNext()) {
                String cardNo = cursor.getString(cursor.getColumnIndex("cardNo"));
                String imagPathOpen = "card-";
                for(int i=0; i<combinCard.length; i++){
                    if(combinCard[i] == Integer.parseInt(cardNo)) {
                        imagPathOpen = "cardMin-";
                        break;
                    }
                }
                mThumbIds.add("card/"+ imagPathOpen + cardNo + ".png");
            }
        } catch (SQLiteException e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
        db.close();

        gridview.setAdapter(new ImageAdapter(this, mThumbIds));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Toast.makeText(SelectCardActivity.this, "" + position, Toast.LENGTH_SHORT).show();
                if (position > 0) {
                    createCardLevelDialogBox(mThumbIds.get(position));
                } else {
                    int btnNo = getIntent().getIntExtra("btnNo", 0);
                    Intent data = new Intent();
                    data.putExtra("card", card);
                    data.putExtra("cardLVSel", cardLVSel);
                    data.putExtra("selectIndex", btnNo);
                    data.putExtra("battle", battle);
                    data.putExtra("cardNo", "0");
                    setResult(RESULT_CODE, data);
                    finish();
                }

            }
        });
    }

    private class MyListener implements ImageView.OnClickListener {
        int pos;
        String element;
        String[] elementArr;
        ImageView b;
        int[] filterImage, darkFiliterImage;
        boolean isColor = false;
        ArrayList<String> filterArr;
        public MyListener (ImageView b, int position, String element) {
            this.pos = position;
            this.element = element;
            this.b = b;
        }
        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            if(element.equals("color")){
                elementArr = colorFilter;
                filterArr = color;
                filterImage = filterColorImage;
                darkFiliterImage = darkFilterColorImage;
                isColor = true;
            }
            else{
                elementArr = raceFilter;
                filterArr = race;
                filterImage = filterRaceImage;
                darkFiliterImage = darkFilterRaceImage;
                isColor = false;
            }

            if (filterArr.contains(elementArr[pos])) {
                filterArr.remove(elementArr[pos]);
                b.setImageResource(darkFiliterImage[pos]);
                if(isColor){
                    tempCol[pos] = -1;
                }
                else{
                    tempRace[pos] = -1;
                }
                cardFilter(color, race);
            }
            else{
                filterArr.add(elementArr[pos]);
                b.setImageResource(filterImage[pos]);
                if(isColor){
                    tempCol[pos] = 0;
                }
                else{
                    tempRace[pos] = 0;
                }
                cardFilter(color, race);
            }
            //        popupWindow.dismiss();
        }
    }

    public void cardFilter(ArrayList<String>color, ArrayList<String>race){

        mThumbIds.clear();
        mThumbIds.add("card/card-0.png");
        String sql = "";
        String[] args;
        if(color.size() == 0 && race.size() == 0){
            args = new String[0];
            sql = "";
        }
        else {
            String[] colorArr = new String[color.size()];
            String[] raceArr = new String[race.size()];

            for (int i = 0; i < color.size(); i++) {
                colorArr[i] = color.get(i);
            }

            for (int i = 0; i < race.size(); i++) {
                raceArr[i] = race.get(i);
            }
            boolean hasColor = false;

            for (int i = 0; i < colorArr.length; i++) {
                if (i == 0) {
                    hasColor = true;
                    sql += " WHERE ( COLOR = ? ";
                } else {
                    sql += " OR COLOR = ? ";
                }
            }

            if (hasColor && raceArr.length > 0) sql += " )";

            for (int i = 0; i < raceArr.length; i++) {
                if (i == 0) {
                    if (hasColor) {
                        sql += " AND ( RACE =  ? ";
                    } else {
                        sql += " WHERE ( RACE =  ? ";
                    }
                } else {
                    sql += " OR RACE = ? ";
                }
            }

            sql += " )";
            args = new String[colorArr.length + raceArr.length];
            if (raceArr.length > 0 && colorArr.length > 0) {
                System.arraycopy(colorArr, 0, args, 0, colorArr.length);
                System.arraycopy(raceArr, 0, args, colorArr.length, raceArr.length);
            } else if( colorArr.length > 0){
                args = colorArr;
            } else{
                args = raceArr;
            }
        }
        try {
            // eg. 1 - RawQuery
            dbHelper = new DBHelper(SelectCardActivity.this);
            db = dbHelper.getWritableDatabase();
            cursor = dbHelper.query(db, "SELECT CARD_ID as cardNo FROM CARD "+sql, args);
            while (cursor.moveToNext()) {
                String cardNo = cursor.getString(cursor.getColumnIndex("cardNo"));
                String imagPathOpen = "card-";
                for(int i=0; i<combinCard.length; i++){
                    if(combinCard[i] == Integer.parseInt(cardNo)) {
                        imagPathOpen = "cardMin-";
                        break;
                    }
                }
                mThumbIds.add("card/"+ imagPathOpen + cardNo + ".png");
            }
        } catch (SQLiteException e) {
            Toast.makeText(getApplicationContext(), "SQL Error ", Toast.LENGTH_SHORT).show();
        }
        db.close();

        gridview.setAdapter(new ImageAdapter(SelectCardActivity.this, mThumbIds));
    }

    public void createCardLevelDialogBox(String cN) {
        AlertDialog.Builder cardLV = new AlertDialog.Builder(SelectCardActivity.this);
        final String cardNumber = cN;
        cardLV.setTitle("請輸入等級!");
        final EditText LVText = new EditText(SelectCardActivity.this);
        cardLV.setView(LVText);
        //   cardLV.setIcon(R.drawable.ic_launcher);
        cardLV.setCancelable(false);


        cardLV.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }

        });
        cardLV.setPositiveButton("確定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        int btnNo = getIntent().getIntExtra("btnNo", 0);

                        //    String cardLv = data.getExtras().getString("returnCardLV");
                        String[] cardNum = cardNumber.split("-");
                        String cardID = cardNum[1].substring(0, cardNum[1].length() - 4);

                        for (int i = 0; i < combinCard.length; i++) {
                            if (combinCard[i] == Integer.parseInt(cardID)) {
                                if (btnNo == 5 || btnNo == 0) {
                                    Toast.makeText(getApplicationContext(), "隊長或隊友不能選擇合體卡 ", Toast.LENGTH_SHORT).show();
                                    return;
                                }

                                if (btnNo == 4) {
                                    if (card[btnNo - 1] != 0) {
                                        Toast.makeText(getApplicationContext(), "沒有位置放合體卡 ", Toast.LENGTH_SHORT).show();
                                        return;
                                    } else {
                                        if (Arrays.asList(combinCard).contains(card[2])) {
                                            Toast.makeText(getApplicationContext(), "沒有位置放合體卡 ", Toast.LENGTH_SHORT).show();
                                            return;
                                        }
                                        btnNo = 3;
                                    }
                                } else if (btnNo == 1) {
                                    if (card[btnNo + 1] != 0) {
                                        Toast.makeText(getApplicationContext(), "隊長或隊友不能選擇合體卡 ", Toast.LENGTH_SHORT).show();
                                        return;
                                    }
                                    btnNo = 1;
                                } else {
                                    if (card[btnNo + 1] != 0) {
                                        if (card[btnNo - 1] != 0) {
                                            Toast.makeText(getApplicationContext(), "沒有位置放合體卡 ", Toast.LENGTH_SHORT).show();
                                            return;
                                        } else {
                                            btnNo = btnNo - 1;
                                        }
                                    }
                                }
                            }
                        }

                        if (Integer.parseInt(cardID) == fiveInOne) {
                            if (btnNo == 5) {
                                Toast.makeText(getApplicationContext(), "隊友不能選擇「超獸魔神」 ", Toast.LENGTH_SHORT).show();
                                return;
                            }
                            for (int i = 1; i < card.length - 1; i++) {
                                if (card[i] != 0) {
                                    Toast.makeText(getApplicationContext(), "沒有位置放「超獸魔神」 ", Toast.LENGTH_SHORT).show();
                                    return;
                                }
                            }
                            btnNo = 0;
                        }

                        card[btnNo] = Integer.parseInt(cardID);
                        cardLVSel[btnNo] = Integer.parseInt(LVText.getText().toString());

                        Intent data = new Intent();
                        data.putExtra("card", card);
                        data.putExtra("cardLVSel", cardLVSel);
                        data.putExtra("selectIndex", btnNo);
                        data.putExtra("battle", battle);
                        data.putExtra("disableData", disbaleCard);
                        data.putExtra("cardNo", cardID);
                        setResult(RESULT_CODE, data);
                        finish();
                    }
                }
        );

            //     cardLV.create();
            cardLV.show();
        }

        public class ImageAdapter extends BaseAdapter {
        private Context mContext;
        List<String> mThumbIds = new ArrayList<String>();
        public ImageAdapter(Context c, List<String> mThumbIds) {
            mContext = c;
            this.mThumbIds = mThumbIds;
        }

        public int getCount() {
            return mThumbIds.size();
        }

        public Object getItem(int position) {
            return null;
        }

        public long getItemId(int position) {
            return 0;
        }

        // create a new ImageView for each item referenced by the Adapter
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView;

            Resources r = Resources.getSystem();
            float px = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 70, r.getDisplayMetrics());

            if (convertView == null) {  //if it's not recycled, initialize some 				attributes
                imageView = new ImageView(mContext);
                imageView.setLayoutParams(new
                        GridView.LayoutParams((int) px, (int) px));
                imageView.setScaleType(
                        ImageView.ScaleType.CENTER_CROP);
                //    imageView.setPadding(5, 5, 5, 5);
            } else {
                imageView = (ImageView) convertView;
            }

            try {
                InputStream ims = getAssets().open(mThumbIds.get(position));
                BitmapFactory.Options options = new BitmapFactory.Options();
                //options.inSampleSize = 2;
                bitmap = BitmapFactory.decodeStream(ims, null, options);
                ims.close();
                imageView.setImageBitmap(bitmap);
            } catch (IOException ex) {
                imageView.setImageResource(R.drawable.card_unknow);
                //   Toast.makeText(getApplicationContext(), "Hello ", Toast.LENGTH_SHORT).show();
            }
            return imageView;
        }
    }

}
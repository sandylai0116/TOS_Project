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
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.project.tos_project.model.Battle;
import com.project.tos_project.model.Card;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public class SelectCardActivity extends ActionBarActivity{
    SQLiteDatabase db;
    Bitmap bitmap;
    DBHelper dbHelper;
    Battle battle;
    int[] card, cardLVSel, disbaleCard;
    List<String> mThumbIds = new ArrayList<String>();
    Cursor cursor;
    Home h = new Home();
    int cut = 4;
    int[] combinCard = h.combinCard;
    public final static int RESULT_CODE  = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_card);
        GridView gridview = (GridView) findViewById(R.id.gridview);
        card = getIntent().getIntArrayExtra("cardSelData");
        cardLVSel = getIntent().getIntArrayExtra("cardLVData");
        disbaleCard = getIntent().getIntArrayExtra("disableData");

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
                createCardLevelDialogBox(mThumbIds.get(position));
            }
        });
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

                card[btnNo] = Integer.parseInt(cardID);
                cardLVSel[btnNo] = Integer.parseInt(LVText.getText().toString());

                for (int i = 0; i < combinCard.length; i++) {
                    if (combinCard[i] == Integer.parseInt(cardID)) {
                        if (btnNo == 5) {
                            Toast.makeText(getApplicationContext(), "合體卡不能選擇在最後的位置 ", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        break;
                    }
                }

                Intent data = new Intent();
                data.putExtra("card", card);
                data.putExtra("cardLVSel", cardLVSel);
                data.putExtra("selectIndex", btnNo);
                data.putExtra("battle", battle);
                data.putExtra("disableData", disbaleCard);
                //        data.putExtra("btnNo", getIntent().getStringExtra("btnNo"));
                //        data.putExtra("returnCardLV", LVText.getText().toString());
                data.putExtra("cardNo", cardID);

                //        data.putExtra("returnCardData", card);
                setResult(RESULT_CODE, data);
                finish();
            }
        });

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





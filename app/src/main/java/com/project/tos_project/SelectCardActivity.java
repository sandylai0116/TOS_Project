package com.project.tos_project;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;
import com.project.tos_project.model.Card;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by man on 31/5/2015.
 */
public class SelectCardActivity extends Activity {

    ImageButton b[];
    LinearLayout ll;
    SQLiteDatabase db;
    EditText text1;
    DBHelper dbHelper;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_card);

        ll = (LinearLayout) findViewById(R.id.selectCardArea);// initialize linearlayout

        dbHelper = new DBHelper(SelectCardActivity.this);
        db = dbHelper.getWritableDatabase();
     //   text1 = (EditText) findViewById(R.id.searchCardByName);
     //   text1.setText(getIntent().getStringExtra("Value1"));
        setresource();
    }

    public void setresource() {

        Cursor cursor = dbHelper.query(db, "SELECT count(1) FROM CARD");
        cursor.moveToFirst();

       int totalRecordRow = Integer.parseInt(cursor.getString(0)) / 5;
        int totalRecord = Integer.parseInt(cursor.getString(0));
        int printCardNum = 0;
        db.close();

     //   int totalRecordRow = 53 / 5;
     //   int totalRecord = 12;
        b = new ImageButton[totalRecordRow];
        int currentCardNo = 1;
        for (int i = 0 ; i < totalRecordRow; i++){

            LinearLayout supLL = new LinearLayout(this);
            supLL.setWeightSum(5f);
            supLL.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));

        //    supLL.setGravity(Gravity.CENTER);
            if(totalRecord >= 5)
                printCardNum = 5;
            else
                printCardNum = totalRecord;

            for(int j=0; j < printCardNum; j++) {
                totalRecord--;
                currentCardNo++;
                b[i] = new ImageButton(this); // initilize
                b[i].setLayoutParams(new LinearLayout.LayoutParams(1 , LinearLayout.LayoutParams.WRAP_CONTENT, 1f));
                b[i].setScaleType(ImageButton.ScaleType.CENTER);
                b[i].setAdjustViewBounds(true);
                b[i].setPadding(5,5,5,5);

                try {
                    InputStream ims = getAssets().open("card/card-"+currentCardNo+".png");
                    // load image as Drawable
                    Drawable d = Drawable.createFromStream(ims, null);
                    // set image to ImageView
                    b[i].setImageDrawable(d);
                }
                catch(IOException ex){
                    b[i].setImageResource(R.drawable.card_unknow);
                 //   Toast.makeText(getApplicationContext(), "Hello ", Toast.LENGTH_SHORT).show();
                }

                supLL.addView(b[i]);
            }

            ll.addView(supLL);
        }
    }

}

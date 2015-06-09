package com.project.tos_project;


import android.content.Intent;
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

   /*     card1.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v){
          //      Toast.makeText(getApplicationContext(), "Hello ",
          //              Toast.LENGTH_SHORT).show();

          //     startActivity(new Intent(getApplicationContext(), SelectCardActivity.class));

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
                    Toast.makeText(getApplicationContext(), "Hello ", Toast.LENGTH_SHORT).show();
                }
            }
        });
*/

        //test
        Computation.testFinalAttack(db);

        //close db
        db.closeDB();
    }

    // selectCard will be running when image button clicked
    public void selectCard(View view){
        //  set the target activity
        Intent intent = new Intent(this, SelectCardActivity.class);
        // set the value
        intent.putExtra("Value1", "Value two from Activity1");
        // go to another activity
        startActivity(intent);
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

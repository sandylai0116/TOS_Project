package com.project.tos_project;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.project.tos_project.model.Card;

import java.util.List;


public class Home extends ActionBarActivity {

    // Database Helper
    DBHelper db;

    private TextView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //database
        db = new DBHelper(getApplicationContext());
        Card card = new Card(100,"red","human",99,1,1,1,10,10,10,null,null);
        // Inserting card in db
        long id = db.createToCard(card);

        //get card
        view = (TextView)findViewById(R.id.testView);
        List<Card> allCard = db.getCard(100);
        for (Card c : allCard) {
            view.append(" " + c.getId() );
        }

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

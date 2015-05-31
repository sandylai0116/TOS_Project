package com.project.tos_project;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;

/**
 * Created by man on 31/5/2015.
 */
public class SelectCardActivity extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_card);

        EditText text1 = (EditText) findViewById(R.id.EditText01);
        text1.setText(getIntent().getStringExtra("Value1"));

    }

}

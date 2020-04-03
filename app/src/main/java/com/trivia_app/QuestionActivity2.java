package com.trivia_app;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.snackbar.Snackbar;
import com.trivia_app.SQLiteDataBaseHelper.DatabaseHelper;
import java.util.ArrayList;

public class QuestionActivity2 extends AppCompatActivity implements View.OnClickListener {

    TextView tv_question2;
    CheckBox cb1, cb2, cb3, cb4;
    Button btn_next2;

    Typeface tf_semi_bold, tf_regular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);

        tv_question2 = (TextView) findViewById(R.id.tv_question2);
        cb1 = (CheckBox) findViewById(R.id.cb1);
        cb2 = (CheckBox) findViewById(R.id.cb2);
        cb3 = (CheckBox) findViewById(R.id.cb3);
        cb4 = (CheckBox) findViewById(R.id.cb4);
        btn_next2 = (Button) findViewById(R.id.btn_next2);

        tf_semi_bold = Typeface.createFromAsset(getAssets(), "OpenSans-Semibold.ttf");
        tv_question2.setTypeface(tf_semi_bold);
        btn_next2.setTypeface(tf_semi_bold);
        tf_regular = Typeface.createFromAsset(getAssets(), "OpenSans-Regular.ttf");
        cb1.setTypeface(tf_regular);
        cb2.setTypeface(tf_regular);
        cb3.setTypeface(tf_regular);
        cb4.setTypeface(tf_regular);

        btn_next2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btn_next2){
            if (!cb1.isChecked() && !cb2.isChecked() && !cb3.isChecked() && !cb4.isChecked()){
                Snackbar snackbar = Snackbar.make(view, "Mandatory to select any open option.", Snackbar.LENGTH_LONG);
                snackbar.show();
                TextView tv = (TextView) (snackbar.getView()).findViewById(com.google.android.material.R.id.snackbar_text);
                tv.setTypeface(tf_regular);
                tv.setTextSize(14);
            }
            else {
                String answer1 = getIntent().getStringExtra("answer1");

                ArrayList<CheckBox> items = new ArrayList<CheckBox>();
                items.add(cb1);
                items.add(cb2);
                items.add(cb3);
                items.add(cb4);

                StringBuilder ans2 = new StringBuilder();
                for (CheckBox item : items){
                    if(item.isChecked()) {
                        ans2.append(item.getText().toString()).append(", ");
                    }
                }
                String answer2 = ans2.substring(0, ans2.length() - 2);
                Log.e("Answer", "Answer1 = " + answer1 + "\nAnswer2 = " + answer2);

                DatabaseHelper databaseHelper = new DatabaseHelper(QuestionActivity2.this);
                databaseHelper.insertSummary(getString(R.string.question1), getString(R.string.q1_option1), getString(R.string.q1_option2),
                        getString(R.string.q1_option3), getString(R.string.q1_option4), answer1, getString(R.string.question2),
                        getString(R.string.q2_option1), getString(R.string.q2_option2), getString(R.string.q2_option3),
                        getString(R.string.q2_option4), answer2);

                Intent intent = new Intent(QuestionActivity2.this, SummaryActivity.class);
                intent.putExtra("answer1", answer1);
                intent.putExtra("answer2", answer2);
                startActivity(intent);
            }
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
    }
}

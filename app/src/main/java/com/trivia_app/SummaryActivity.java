package com.trivia_app;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.trivia_app.Utils.SessionManager;

public class SummaryActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tv_summary, tv_summary1, tv_user_name, tv_question1, tv_answer1, tv_question2, tv_answer2;
    Button btn_finish, btn_history;

    Typeface tf_semi_bold, tf_regular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        tv_summary = (TextView) findViewById(R.id.tv_summary);
        tv_summary1 = (TextView) findViewById(R.id.tv_summary1);
        tv_user_name = (TextView) findViewById(R.id.tv_user_name);
        tv_question1 = (TextView) findViewById(R.id.tv_question1);
        tv_answer1 = (TextView) findViewById(R.id.tv_answer1);
        tv_question2 = (TextView) findViewById(R.id.tv_question2);
        tv_answer2 = (TextView) findViewById(R.id.tv_answer2);
        btn_finish = (Button) findViewById(R.id.btn_finish);
        btn_history = (Button) findViewById(R.id.btn_history);

        tf_semi_bold = Typeface.createFromAsset(getAssets(), "OpenSans-Semibold.ttf");
        tv_summary.setTypeface(tf_semi_bold);
        tv_summary1.setTypeface(tf_semi_bold);
        tv_user_name.setTypeface(tf_semi_bold);
        tv_question1.setTypeface(tf_semi_bold);
        tv_question2.setTypeface(tf_semi_bold);
        btn_finish.setTypeface(tf_semi_bold);
        btn_history.setTypeface(tf_semi_bold);
        tf_regular = Typeface.createFromAsset(getAssets(), "OpenSans-Regular.ttf");
        tv_answer1.setTypeface(tf_regular);
        tv_answer2.setTypeface(tf_regular);

        tv_user_name.setText("Hello \"" + SessionManager.getPreference(SummaryActivity.this, SessionManager.userName) + "\" : ");
        tv_answer1.setText("Answer : " + getIntent().getStringExtra("answer1"));
        tv_answer2.setText("Answer : " + getIntent().getStringExtra("answer2"));

        btn_finish.setOnClickListener(this);
        btn_history.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if(view.getId() == R.id.btn_finish){
            SessionManager.savePreference(SummaryActivity.this, SessionManager.userName, "");

            Intent intent = new Intent(SummaryActivity.this, SplashActivity.class);
            startActivity(intent);
            finish();
        }
        else if(view.getId() == R.id.btn_history){
            Intent intent = new Intent(SummaryActivity.this, HistoryActivity.class);
            startActivity(intent);
        }
    }
}

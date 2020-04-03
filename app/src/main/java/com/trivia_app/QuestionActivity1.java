package com.trivia_app;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.snackbar.Snackbar;

public class QuestionActivity1 extends AppCompatActivity implements View.OnClickListener {

    TextView tv_question1;
    RadioGroup rg_mcq_options;
    RadioButton rb1, rb2, rb3, rb4;
    Button btn_next1;

    Typeface tf_semi_bold, tf_regular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question1);

        tv_question1 = (TextView) findViewById(R.id.tv_question1);
        rg_mcq_options = (RadioGroup) findViewById(R.id.rg_mcq_options);
        rb1 = (RadioButton) findViewById(R.id.rb1);
        rb2 = (RadioButton) findViewById(R.id.rb2);
        rb3 = (RadioButton) findViewById(R.id.rb3);
        rb4 = (RadioButton) findViewById(R.id.rb4);
        btn_next1 = (Button) findViewById(R.id.btn_next1);

        tf_semi_bold = Typeface.createFromAsset(getAssets(), "OpenSans-Semibold.ttf");
        tv_question1.setTypeface(tf_semi_bold);
        btn_next1.setTypeface(tf_semi_bold);
        tf_regular = Typeface.createFromAsset(getAssets(), "OpenSans-Regular.ttf");
        rb1.setTypeface(tf_regular);
        rb2.setTypeface(tf_regular);
        rb3.setTypeface(tf_regular);
        rb4.setTypeface(tf_regular);

        btn_next1.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btn_next1){
            if (rg_mcq_options.getCheckedRadioButtonId() == -1){
                Snackbar snackbar = Snackbar.make(view, "Mandatory to select any open option.", Snackbar.LENGTH_LONG);
                snackbar.show();
                TextView tv = (TextView) (snackbar.getView()).findViewById(com.google.android.material.R.id.snackbar_text);
                tv.setTypeface(tf_regular);
                tv.setTextSize(14);
            }
            else {
                int selectedId = rg_mcq_options.getCheckedRadioButtonId();
                RadioButton radioButton = (RadioButton) findViewById(selectedId);

                Intent intent = new Intent(QuestionActivity1.this, QuestionActivity2.class);
                intent.putExtra("answer1",String.valueOf(radioButton.getText()));
                startActivity(intent);
            }
        }
    }

    boolean doubleBackToExitPressedOnce = false;
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            finishAffinity();
        }

        this.doubleBackToExitPressedOnce = true;
        Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), "Please click BACK again to exit", Snackbar.LENGTH_LONG);
        snackbar.show();
        TextView tv = (TextView) (snackbar.getView()).findViewById(com.google.android.material.R.id.snackbar_text);
        tv.setTypeface(tf_regular);
        tv.setTextSize(14);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }
}

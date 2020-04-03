package com.trivia_app;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;
import com.trivia_app.SQLiteDataBaseHelper.DatabaseHelper;
import com.trivia_app.Utils.SessionManager;

public class SplashActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView iv_logo;
    LinearLayout ll_name;
    TextInputLayout til_name;
    EditText et_name;
    Button btn_continue;

    Animation logo_zoom, from_bottom;
    Typeface tf_semi_bold, tf_regular;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        iv_logo = (ImageView) findViewById(R.id.iv_logo);
        ll_name = (LinearLayout) findViewById(R.id.ll_name);
        til_name = (TextInputLayout) findViewById(R.id.til_name);
        et_name = (EditText) findViewById(R.id.et_name);
        btn_continue = (Button) findViewById(R.id.btn_continue);

        til_name.setBoxBackgroundMode(TextInputLayout.BOX_BACKGROUND_OUTLINE);
        til_name.setBoxCornerRadii(5, 5, 5, 5);

        logo_zoom = AnimationUtils.loadAnimation(SplashActivity.this, R.anim.anim_logo);
        from_bottom = AnimationUtils.loadAnimation(SplashActivity.this, R.anim.anim_from_bottom);
        iv_logo.setAnimation(logo_zoom);
        ll_name.setAnimation(from_bottom);

        databaseHelper = new DatabaseHelper(SplashActivity.this);

        tf_regular = Typeface.createFromAsset(getAssets(), "OpenSans-Regular.ttf");
        et_name.setTypeface(tf_semi_bold);
        tf_semi_bold = Typeface.createFromAsset(getAssets(), "OpenSans-Semibold.ttf");
        btn_continue.setTypeface(tf_semi_bold);

        btn_continue.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btn_continue){
            if(!et_name.getText().toString().trim().equalsIgnoreCase("")) {
                SessionManager.savePreference(SplashActivity.this, SessionManager.userName, et_name.getText().toString().trim());

                Intent intent = new Intent(SplashActivity.this, QuestionActivity1.class);
                startActivity(intent);
                finish();
            }
            else
                et_name.setError("Name cannot be blank.");
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

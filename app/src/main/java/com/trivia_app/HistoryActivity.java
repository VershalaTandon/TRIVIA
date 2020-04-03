package com.trivia_app;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.trivia_app.Adapter.HistoryAdapter;
import com.trivia_app.Model.Summary;
import com.trivia_app.SQLiteDataBaseHelper.DatabaseHelper;
import java.util.ArrayList;

import static androidx.recyclerview.widget.RecyclerView.HORIZONTAL;

public class HistoryActivity extends AppCompatActivity{

    TextView tv_history;
    RecyclerView rv_history;

    DatabaseHelper databaseHelper;
    Typeface tf_semi_bold, tf_regular;
    ArrayList<Summary> summary_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        tv_history = (TextView) findViewById(R.id.tv_history);
        rv_history = (RecyclerView) findViewById(R.id.rv_history);

        tf_semi_bold = Typeface.createFromAsset(getAssets(), "OpenSans-Semibold.ttf");
        tv_history.setTypeface(tf_semi_bold);

        databaseHelper = new DatabaseHelper(HistoryActivity.this);
        summary_list = databaseHelper.getAllHistory();

        LinearLayoutManager llm = new LinearLayoutManager(HistoryActivity.this);
        rv_history.setLayoutManager(llm);
        rv_history.setItemAnimator(new DefaultItemAnimator());

        HistoryAdapter adapter = new HistoryAdapter(HistoryActivity.this, summary_list);
        rv_history.setAdapter(adapter);
    }
}

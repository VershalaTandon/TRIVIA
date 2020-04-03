package com.trivia_app.Adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import com.trivia_app.Model.Summary;
import com.trivia_app.R;
import java.util.ArrayList;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.MarketViewHolder>{
    Context context;
    ArrayList<Summary> summaryLists;

    Typeface tf_semi_bold, tf_regular;

    public HistoryAdapter(Context context, final ArrayList<Summary> summaryLists) {
        this.context = context;
        this.summaryLists = summaryLists;
    }

    @Override
    public HistoryAdapter.MarketViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new HistoryAdapter.MarketViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_history, parent, false));
    }

    @Override
    public void onBindViewHolder(HistoryAdapter.MarketViewHolder holder, final int position) {
        tf_semi_bold = Typeface.createFromAsset(context.getAssets(), "OpenSans-Semibold.ttf");
        tf_regular = Typeface.createFromAsset(context.getAssets(), "OpenSans-Regular.ttf");
        
        holder.tv_game.setTypeface(tf_semi_bold);
        holder.tv_user_name.setTypeface(tf_semi_bold);
        holder.tv_question1.setTypeface(tf_regular);
        holder.tv_answer1.setTypeface(tf_regular);
        holder.tv_question2.setTypeface(tf_regular);
        holder.tv_answer2.setTypeface(tf_regular);

        holder.tv_game.setText("GAME " + (position + 1) + " : " + summaryLists.get(position).getDate());
        holder.tv_user_name.setText("Name : " +summaryLists.get(position).getName());
        holder.tv_question1.setText(summaryLists.get(position).getQuestion1());
        holder.tv_answer1.setText("Answer : " + summaryLists.get(position).getAnswer1());
        holder.tv_question2.setText(summaryLists.get(position).getQuestion2());
        holder.tv_answer2.setText("Answer : " + summaryLists.get(position).getAnswer2());
    }

    @Override
    public int getItemCount() {
        return summaryLists.size();
    }

    public class MarketViewHolder extends RecyclerView.ViewHolder {
        TextView tv_game, tv_user_name, tv_question1, tv_answer1, tv_question2, tv_answer2;

        public MarketViewHolder(View view){
            super(view);

            tv_game = (TextView) view.findViewById(R.id.tv_game);
            tv_user_name = (TextView) view.findViewById(R.id.tv_user_name);
            tv_question1 = (TextView) view.findViewById(R.id.tv_question1);
            tv_answer1 = (TextView) view.findViewById(R.id.tv_answer1);
            tv_question2 = (TextView) view.findViewById(R.id.tv_question2);
            tv_answer2 = (TextView) view.findViewById(R.id.tv_answer2);
        }
    }
}
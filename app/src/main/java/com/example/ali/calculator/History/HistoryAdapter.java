package com.example.ali.calculator.History;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.tonmo.calculator.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ali on 2/5/2017.
 */

public class HistoryAdapter extends BaseAdapter {

    Context context;
    List<History> historyList;

    public HistoryAdapter(Context context, List<History> list){
        this.context = context;
        this.historyList = list;
    }

    @Override
    public int getCount() {
        return historyList.size();
    }

    @Override
    public Object getItem(int position) {
        return historyList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        view = View.inflate(context, R.layout.history_row_layout,null);
        TextView tvInput = (TextView) view.findViewById(R.id.history_input);
        TextView tvOutput = (TextView) view.findViewById(R.id.history_output);
        tvInput.setText(historyList.get(position).getInput());
        tvOutput.setText(historyList.get(position).getOutput());
        return  view;
    }

    public void clear(){
        historyList.clear();
    }
}

package com.example.app_tieng;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class AdapterTieng extends BaseAdapter {
    private Context context;
    private int layout;
    private List<TiengCacNuoc> arraylist;

    public AdapterTieng(Context context, int layout, List<TiengCacNuoc> arraylist) {
        this.context = context;
        this.layout = layout;
        this.arraylist = arraylist;
    }

    @Override
    public int getCount() {
        return arraylist.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout,null);
        TextView textView = view.findViewById(R.id.txtmain);
        TiengCacNuoc tiengCacNuoc = arraylist.get(position);

        textView.setText(tiengCacNuoc.getTieng());
        return view;
    }
}

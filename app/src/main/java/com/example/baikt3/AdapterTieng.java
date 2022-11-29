package com.example.baikt3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Timer;

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
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout,null);
        TiengCacNuoc tiengCacNuoc = arraylist.get(i);
        TextView textView = view.findViewById(R.id.txttieng);
        textView.setText(tiengCacNuoc.getTieng());
        return view;
    }
}

package com.example.app_tieng;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class DuLieuAdapter extends ArrayAdapter<DuLieu> {
    private Activity activity;
    private int resource;
    @NonNull
    private List<DuLieu> objects;

    public DuLieuAdapter(Activity activity, int resource, @NonNull List<DuLieu> objects) {
        super(activity,resource,objects);
        this.activity = activity;
        this.resource = resource;
        this.objects = objects;
    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = this.activity.getLayoutInflater();
        View view = inflater.inflate(this.resource, null);

        TextView txtVidu = view.findViewById(R.id.tv_vidu);

        DuLieu duLieu = this.objects.get(position);
        txtVidu.setText(duLieu.getVidu());
        return view;
    }

}

package com.dnu.k1202.quanlyvattu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class VatTuAdapter extends BaseAdapter {
    Context context;
    int layout;
    List<VatTu> list;

    public VatTuAdapter(Context context, int layout, List<VatTu> list) {
        this.context = context;
        this.layout = layout;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
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
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout, null);
        ImageView imgAvatar = view.findViewById(R.id.imgAvatar);
        TextView txtHoTen = view.findViewById(R.id.txtTen);
        TextView txtMoTa = view.findViewById(R.id.txtMoTa);
        VatTu cauThu = list.get(i);
        imgAvatar.setImageResource(cauThu.getAvatar());
        txtHoTen.setText(cauThu.getName());
        txtMoTa.setText(cauThu.getDetail());
        return view;
    }
}

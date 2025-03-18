package com.example.prm392_project.adapter;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.prm392_project.R;
import com.example.prm392_project.entity.TinTuc;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class HienThiTinTucApdapter extends ArrayAdapter<TinTuc> {
    private Context context;
    private List<TinTuc> lists;
    TextView tv_title, tv_link, tv_date, tv_content;
    ImageView iv_news;
    public HienThiTinTucApdapter(@NonNull Context context, ArrayList<TinTuc> list) {
        super(context, 0, list);
        this.context = context;
        this.lists = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        if (v == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.item_newss, null);
        }
        final TinTuc item = lists.get(position);

        if (item != null){
            tv_title = v.findViewById(R.id.tv_title_item_news);
            tv_date = v.findViewById(R.id.tv_date_news);
            iv_news = v.findViewById(R.id.iv_news);

            tv_title.setText(item.getTenBaiBao());

            try {
                // Lấy ID resource từ tên drawable
                int resourceId = context.getResources().getIdentifier(
                        item.getAnh().replace("@drawable/", ""),
                        "drawable",
                        context.getPackageName()
                );

                // Hiển thị ảnh từ drawable
                Picasso.get()
                        .load(resourceId)
                        .placeholder(R.mipmap.ic_launcher)
                        .error(R.mipmap.ic_launcher)
                        .into(iv_news);
            } catch (Exception e) {
                // Nếu có lỗi, hiển thị ảnh mặc định
                iv_news.setImageResource(R.mipmap.ic_launcher);
            }

            try {
                String date = item.getNgayDang();
                date = date.substring(0, date.length() - 6);
                tv_date.setText(date);
            } catch (Exception e){
            }
        }
        return v;
    }
}

package com.example.prm392_project.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.prm392_project.R;
import com.example.prm392_project.entity.DanhMuc;
import com.squareup.picasso.Picasso;

import java.util.List;

public class DanhMucAdapter extends RecyclerView.Adapter<DanhMucAdapter.DanhMucVH> {
    Context context;
    List<DanhMuc> list;
    ItemCallback itemCallback;
    public DanhMucAdapter(List<DanhMuc> list, Context context, ItemCallback itemCallback) {
        this.context = context;
        this.list = list;
        this.itemCallback = itemCallback;
    }
    @NonNull
    @Override
    public DanhMucVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.layoutitemgrid, parent, false);
        return new DanhMucVH(view);
    }
    @Override
    public void onBindViewHolder(@NonNull DanhMucVH holder, int position) {
        DanhMuc danhMuc = list.get(position);

        holder.tv_name.setText(danhMuc.getTenDanhMuc());

        try {
            // Lấy ID resource từ tên drawable
            int resourceId = context.getResources().getIdentifier(
                    danhMuc.getAnh().replace("@drawable/", ""),
                    "drawable",
                    context.getPackageName()
            );

            // Hiển thị ảnh từ drawable
            Picasso.get()
                    .load(resourceId)
                    .placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.ic_launcher_background)
                    .into(holder.imAvartar);
        } catch (Exception e) {
            // Nếu có lỗi, hiển thị ảnh mặc định
            holder.imAvartar.setImageResource(R.drawable.ic_launcher_background);
        }

        holder.itemView.setOnClickListener(view -> itemCallback.onItemClick("IDDanhMuc :" + String.valueOf(danhMuc.getIDDanhMuc())));
    }
    @Override
    public int getItemCount() {
        return list.size();
    }
    class DanhMucVH extends RecyclerView.ViewHolder{
        TextView tv_name;
        ImageView imAvartar;
        public DanhMucVH(@NonNull View itemView) {
            super(itemView);
            tv_name = itemView.findViewById((R.id.tv_name));
            imAvartar = itemView.findViewById(R.id.ivAvartar);
        }
    }
}

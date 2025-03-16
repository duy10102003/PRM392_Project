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
import com.example.prm392_project.entity.TinTuc;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PheDuyetApdapter extends RecyclerView.Adapter<PheDuyetApdapter.myViewHolder> {

    Context context;
    List<TinTuc> list;
    ItemCallback itemCallback;
    public PheDuyetApdapter(List<TinTuc> list, Context context, ItemCallback itemCallback) {
        this.context = context;
        this.list = list;
        this.itemCallback = itemCallback;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.layout_tintuc_pheduyet, parent, false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        TinTuc tinTuc = list.get(position);
        holder.tvTenBaiBao.setText(tinTuc.getTenBaiBao());
        holder.tvDate.setText(tinTuc.getNgayDang());

        try {
            // Lấy ID resource từ tên drawable
            int resourceId = context.getResources().getIdentifier(
                    tinTuc.getAnh().replace("@drawable/", ""),
                    "drawable",
                    context.getPackageName()
            );

            // Hiển thị ảnh từ drawable
            Picasso.get()
                    .load(resourceId)
                    .placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.ic_launcher_background)
                    .into(holder.img);
        } catch (Exception e) {
            // Nếu có lỗi, hiển thị ảnh mặc định
            holder.img.setImageResource(R.drawable.ic_launcher_background);
        }

        holder.tvTrangThai.setText("Trạng thái: " + tinTuc.getTrangThai());
        holder.itemView.setOnClickListener(view -> itemCallback.onItemClick("IDBaiBao:" + String.valueOf(tinTuc.getIDBaiBao())));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView tvTenBaiBao, tvDate, tvTrangThai;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            tvTenBaiBao = itemView.findViewById(R.id.tv_title_item_newspd);
            tvDate = itemView.findViewById(R.id.tv_date_newspd);
            tvTrangThai = itemView.findViewById(R.id.tv_trangThaipd);
            img = itemView.findViewById(R.id.iv_newspd);

        }
    }
}

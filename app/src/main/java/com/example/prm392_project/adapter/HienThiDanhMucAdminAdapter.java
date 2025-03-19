package com.example.prm392_project.adapter;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.prm392_project.R;
import com.example.prm392_project.admin.UpdateTinTucActivity;
import com.example.prm392_project.entity.DanhMuc;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.squareup.picasso.Picasso;

import java.util.List;

public class HienThiDanhMucAdminAdapter extends RecyclerView.Adapter<HienThiDanhMucAdminAdapter.myViewHolder> {

    Context context;
    List<DanhMuc> list;
    ItemCallback itemCallback;

    public HienThiDanhMucAdminAdapter(List<DanhMuc> list, Context context, ItemCallback itemCallback) {
        this.context = context;
        this.list = list;
        this.itemCallback = itemCallback;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.layout_danhmuc_admin, parent, false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        DanhMuc danhMuc = list.get(position);
        holder.tvDanhMuc.setText(danhMuc.getTenDanhMuc());

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
                    .into(holder.img);
        } catch (Exception e) {
            // Nếu có lỗi, hiển thị ảnh mặc định
            holder.img.setImageResource(R.drawable.ic_launcher_background);
        }

        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseFirestore.getInstance().collection("DanhMuc")
                        .document(danhMuc.getIDDanhMuc())
                        .delete()
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Toast.makeText(context, "Xóa thành công", Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });
        holder.btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, UpdateTinTucActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("IDBaiBao", danhMuc.getIDDanhMuc());
                i.putExtras(bundle);
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView tvDanhMuc;
        Button btnUpdate, btnDelete;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            tvDanhMuc = itemView.findViewById(R.id.tv_name_admin);
            btnDelete = itemView.findViewById(R.id.btn_deleteDM_admin);
            btnUpdate = itemView.findViewById(R.id.btn_updateDM_admin);
            img = itemView.findViewById(R.id.ivAvartar_admin);

        }
    }
}

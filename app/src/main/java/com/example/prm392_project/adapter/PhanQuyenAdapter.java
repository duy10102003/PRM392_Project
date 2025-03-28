package com.example.prm392_project.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.prm392_project.R;
import com.example.prm392_project.adapter.ItemCallback;
import com.example.prm392_project.entity.TaiKhoan;

import java.util.List;

public class PhanQuyenAdapter extends RecyclerView.Adapter<PhanQuyenAdapter.myViewHolder> {

    Context context;
    List<TaiKhoan> list;
    ItemCallback itemCallback;
    public PhanQuyenAdapter(List<TaiKhoan> list, Context context, ItemCallback itemCallback) {
        this.context = context;
        this.list = list;
        this.itemCallback = itemCallback;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.item_phanquyen, parent, false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        TaiKhoan taiKhoan = list.get(position);
        holder.tvemail.setText(taiKhoan.getEmail());
        holder.tvquyen.setText(taiKhoan.getQuyen());
        holder.itemView.setOnClickListener(view -> itemCallback.onItemClick("IDTK :" + String.valueOf(taiKhoan.getIdTaiKhoan())));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        TextView tvemail, tvquyen;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            tvemail = itemView.findViewById(R.id.tv_emailPhanQuyen);
            tvquyen = itemView.findViewById(R.id.tv_quyenPhanQuyen);
        }
    }
}

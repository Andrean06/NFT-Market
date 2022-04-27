package com.example.nftmarket.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.nftmarket.R;
import com.example.nftmarket.models.RecomendedModel;

import java.util.List;

public class RecomendedAdapter extends RecyclerView.Adapter<RecomendedAdapter.ViewHolder> {

    Context context;
    List<RecomendedModel> recomendedModelList;

    public RecomendedAdapter(Context context, List<RecomendedModel> recomendedModelList) {
        this.context = context;
        this.recomendedModelList = recomendedModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recommended_item,parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Glide.with(context).load(recomendedModelList.get(position).getImg_url()).into(holder.imageView);
        holder.name.setText(recomendedModelList.get(position).getName());
        holder.description.setText(recomendedModelList.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return recomendedModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView name,description;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.rec_img);
            name = itemView.findViewById(R.id.rec_name);
            description = itemView.findViewById(R.id.rec_dec);
        }
    }
}

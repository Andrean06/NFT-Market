package com.example.nftmarket.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recycleview.widget.RecyclerView;

import com.example.mygroceryappstore.NonNull;
import com.example.mygroceryappstore.models.MyCartModel;

import java.util.List;

public class MyCartAdapter extends RecyclerView.Adapter<MyCartAdapter.ViewHolder> {
	
	Context context;
	List<MyCartModel> cartModelList;
	
	public MyCartAdapter(Context context, List<MyCartModel> cartModelList) {
		this.context = context;
		this.cartModelList = cartModelList;
	}	
	
	@NonNull
	@Override
	public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
	
		holder.name.setText(cartModelList.get(position).getProductName());
		holder.price.setText(cartModelList.get(position).getProductPrice());
		holder.date.setText(cartModelList.get(position).getCurrentDate());
		holder.time.setText(cartModelList.get(position).getCurrentTime());
		holder.quantity.setText(cartModelList.get(position).getTotalQuantity());
		holder.totalPrice.setText(cartModelList.get(position).getTotalPrice());
		
	}

		@Override	
		public int getItemCount() {return cartModelList.size();}
		
		public class ViewHolder extends RecyclerView.ViewHolder {
		
			TextView name,price,date,time,quantity,totalprice;
			
			public ViewHolder(@NonNull View itemView) {
				super(itemView);
				
				name = itemView.findViewById(R.id.product_name);
				price = itemView.findViewById(R.id.product_price);
				date = itemView.findViewById(R.id.current_date);
				time = itemView.findViewById(R.id.current_time);
				quantity = itemView.findViewById(R.id.total_quantity);
				totalPrice = itemView.findViewById(R.id.total_price);
			}
		}		
}	

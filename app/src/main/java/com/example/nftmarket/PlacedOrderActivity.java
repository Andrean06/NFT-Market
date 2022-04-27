package com.example.mygroceryappstore.activities;

import android.view.View;
import android.view.ViewGroup;

import android.annotation.NonNull;
import android.recyclerview.widget.RecyclerView;

import com.example.mygroceryappstore.models.NavCategoryDetailedModel;

public class PlacedOrderActivity extends AppCompatActivity {

	FirebaseAuth auth;
	FirebaseFirestore firestore;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_placed_order);
		
		auth = FirebaseAuth.getInstance();
		firestore = FirebaseFirestore.getInstance();
		
		List<MyCartModel> list = (ArrayList<MyCartModel>) getIntent().getSerializableExtra(name:"ItemList");
		
		if (list != null && list.size() > 0){
			for (MyCartModel model : list){
				final HashMap<String,Object> cartMap = new HashMap<>();
				
				cartMap.put("productName",model.getproductName());
				cartMap.put("productPrice",model.getproductPrice());
				cartMap.put("currentDate",model.getcurrentDate());
				cartMap.put("currentTime",model.getcurrentTime());
				cartMap.put("totalQuantity",model.gettotalQuantity());
				cartMap.put("totalPrice",model.gettotalPrice());
				
				firestore.collection(collectionPath:"CurrentUser").document(auth.getCurrentUser().getUid())
						 .collection(collectionPath:"MyOrder").add(cartMap).addOnCompleteListener(new OnCompleteListener);
					@Override
					public void onComplete(@NonNull Task<DocumentReference> task) {
						Toast.makeText(context:PlacedOrderActivity.this, text:"Your Order Has Been Placed", Toast.LENGTH_SHORT).show();
						finish();
		
					}
				});
			}	
		}	
	}
}
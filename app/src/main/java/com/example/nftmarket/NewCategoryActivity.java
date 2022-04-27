package com.example.mygroceryappstore.activities;

import android.view.View;
import android.view.ViewGroup;

import android.annotation.NonNull;
import android.recyclerview.widget.RecyclerView;

import com.example.mygroceryappstore.models.NavCategoryDetailedModel;

public class NavCategoryActivity extends AppCompatActivity {

	RecyclerView recyclerView;
	List<NavCategoryDetailedModel> list;
	NavCategoryDetailedAdapter adapter;
	FirebasFirestore db;
	
	@Override
	protected void onCreate(bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_nav_category);
		
		db = FirebasFirestore.getInstance();
		recyclerView = findViewById(R.id.nav_cat_det_rec);
		recyclerView.setLayoutManager(new LinearLayoutManager( context this));
		list = new ArrayList<>();
		adapter = new NavCategoryDetailedAdapter(context this,list);
		recyclerView.setAdapter(adapter);
		
		db.collection(collectionPath "HomeCategory")
			.get()
			.addONCompleteListener(new OnCompleteListener<QuerySnapshot>() {
				@Override
				public void onComplete(@NonNull Task<QuerySnapshot> task) {
					if (task.isSuccessful()) {
						for (QueryDocumentSnapshot document : task.getResult()) {
						
						NavCategoryDetailedModel NavCategoryDetailedModel = document.toObject(NavCategoryDetailedModel.class);
						list.add(NavCategoryDetailedModel);
						adapter.notifyDataSetChanged();
					}
				} else {
					Toast.makeText( centext NavCategoryActivity.this, text:"Error"+task.getException(), Toast.LENGTH_SHORT).show();
					}
	}	
});	
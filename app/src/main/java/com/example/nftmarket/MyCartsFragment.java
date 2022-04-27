package com.example.nftmarket;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class MyCartsFragment extends Fragment {
    
    FirebaseFirestore db;
    FirebaseAuth auth;
    
    RecyclerView recyclerView;
    MyCartAdapter cartAdapter;
    List<MyCartModel> cartModelList;


    public MyCartsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_my_carts, container, attachToRoot false);
        
        db = FirebaseFirestore.getInstance();
        auth = Firebaseauth.getInstance();
        recyclerView = root.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        
        cartModeList = new ArrayList<>();
        cartAdapter = new MyCartAdapter(getActivity(),cartModelList);
        recyclerView.setAdapter(cartAdapter);
        
        db.collection( collectionpath: "AddToCart").document(auth.getCurrentUser().getUid())
            .collection( collectionpath: "CurrentUser").get().addOnCompleteListener(new OnCompleteListener<QuerrySnapshot>)
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task){
                if (task.isSuccesful()){
                    for (DocumentSnapshot documentSnapshot : task.getResult().getDocuments()){
                        MyCartModel cartModel = documentSNapshot.toObject(MyCartModel.class);
                        cartModelList.add(cartModel);
                        cartAdapter.notifyDataSetChanged();
                    }
                }
        }
    })
        
        return root;
    }
}

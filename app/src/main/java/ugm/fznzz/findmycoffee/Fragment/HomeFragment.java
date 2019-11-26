package ugm.fznzz.findmycoffee.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ugm.fznzz.findmycoffee.Adapter.RecyclerViewAdapter;
import ugm.fznzz.findmycoffee.DataClass.ItemMenu;
import ugm.fznzz.findmycoffee.DataClass.Shop;
import ugm.fznzz.findmycoffee.R;

public class HomeFragment extends Fragment {

    List<ItemMenu> listData;
    List<Shop> shopList;
    FirebaseDatabase FDB;
    DatabaseReference DBR;
    private RecyclerView rview;
    private RecyclerViewAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_home, container, false);
        rview = v.findViewById(R.id.menuItem); //this is line 42
        rview.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext());
        rview.setLayoutManager(layoutManager);
        listData = new ArrayList<>();
        adapter = new RecyclerViewAdapter(getContext(), listData, shopList);
        FDB = FirebaseDatabase.getInstance();
        GetDataFirebase();

        return v;
    }

    void GetDataFirebase() {
        DBR = FDB.getReference("Shop");

        DBR.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                ItemMenu data = new ItemMenu();
                data = dataSnapshot.getValue(ItemMenu.class);
                listData.add(data);
                rview.setAdapter(adapter);

//                Shop data2 = new Shop();
//                data2 = dataSnapshot.getValue(Shop.class);
//                shopList.add(data2);
//                rview.setAdapter(adapter);

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

}

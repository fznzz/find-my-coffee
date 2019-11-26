package ugm.fznzz.findmycoffee.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import ugm.fznzz.findmycoffee.DataClass.ItemMenu;
import ugm.fznzz.findmycoffee.R;

public class StoreView extends Fragment {
    private TextView ShopName;
    private TextView Address;
    private TextView OpenHours;
    private TextView Link;
    private TextView PriceRange;

    private List<ItemMenu> itemMenuList;

    public StoreView() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View itemView = inflater.inflate(R.layout.details_storeview, container, false);
        ShopName = itemView.findViewById(R.id.tvShopName);
        Address = itemView.findViewById(R.id.tvAddress);
        OpenHours = itemView.findViewById(R.id.tvOpenHours);
        Link = itemView.findViewById(R.id.tvLink);
        PriceRange = itemView.findViewById(R.id.tvPriceRange);


        // Getting the bundles that we passed from the BoardMateDetailActivity.class
        Bundle bundle = getArguments();

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("User");
        final DatabaseReference table_shop = database.getReference("Shop");

        table_shop.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String shopname = String.valueOf(dataSnapshot.child("shopName").getValue());
                String address = String.valueOf(dataSnapshot.child("address").getValue());
                String openhours = String.valueOf(dataSnapshot.child("openHours").getValue());
                String link = String.valueOf(dataSnapshot.child("link").getValue());
                String pricerange = String.valueOf(dataSnapshot.child("priceRange").getValue());

                ShopName.setText(shopname);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

//        ShopName.setText(shopname);
//        Address.setText(address);
//        OpenHours.setText(number);
//        Link.setText(status);
//        PriceRange.setText(String.valueOf(payable));
        return itemView;
    }
}

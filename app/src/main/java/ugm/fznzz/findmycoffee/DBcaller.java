package ugm.fznzz.findmycoffee;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

import ugm.fznzz.findmycoffee.DataClass.Shop;

public class DBcaller {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    final DatabaseReference table_user = database.getReference("User");
    final DatabaseReference table_shop = database.getReference("Shop");
    List<Shop> shopList;

    public DBcaller() {
        table_shop.getDatabase();

    }
}

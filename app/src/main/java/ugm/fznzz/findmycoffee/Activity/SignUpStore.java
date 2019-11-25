package ugm.fznzz.findmycoffee.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import ugm.fznzz.findmycoffee.R;
import ugm.fznzz.findmycoffee.DataClass.Shop;
import ugm.fznzz.findmycoffee.DataClass.User;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SignUpStore extends AppCompatActivity {

    EditText edtStoreName, edtAddress, edtOpenHours, edtLink, edtPriceRange;
    Button btSignUp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_store);

        Bundle extras = getIntent().getExtras();
        final String phoneS = extras.getString("phoneS");
        final String nameS = extras.getString("nameS");
        final String passS = extras.getString("passS");

        edtStoreName = findViewById(R.id.formStoreName);
        edtAddress = findViewById(R.id.formAddress);
        edtOpenHours = findViewById(R.id.formOpenHours);
        edtLink = findViewById(R.id.formLink);
        edtPriceRange = findViewById(R.id.formRangePrice);

        btSignUp = findViewById(R.id.btnSignUpStore);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("User");
        final DatabaseReference table_shop = database.getReference("Shop");

        btSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtStoreName.getText().toString().isEmpty()||edtPriceRange.getText().toString().isEmpty()||edtOpenHours.getText().toString().isEmpty()||edtAddress.getText().toString().isEmpty()||edtLink.getText().toString().isEmpty())
                {
                    Toast.makeText(SignUpStore.this, "Please fill the whole form correctly", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    table_shop.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                            User user = new User(nameS, passS);
                            table_user.child(phoneS).setValue(user);
                            Shop shop = new Shop(edtStoreName.getText().toString(), edtAddress.getText().toString(), edtOpenHours.getText().toString(), edtLink.getText().toString(), edtOpenHours.getText().toString());
                            table_shop.child(phoneS).setValue(shop);
                            finish();
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }
            }
        });



    }
}

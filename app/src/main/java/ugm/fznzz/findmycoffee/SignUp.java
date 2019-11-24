package ugm.fznzz.findmycoffee;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
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

public class SignUp extends AppCompatActivity {

    EditText edtPhone, edtName, edtPass;
    Button btnUp;
    String phoneS, nameS, passS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        edtPhone = findViewById(R.id.formRegUsername);
        edtName = findViewById(R.id.formRegName);
        edtPass = findViewById(R.id.formRegPass);

        btnUp = findViewById(R.id.btnSignUp);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("User");

        btnUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(edtName.getText().toString().isEmpty()||edtPass.getText().toString().isEmpty()||edtPhone.getText().toString().isEmpty())
                {
                    Toast.makeText(SignUp.this, "Please fill the form correctly", Toast.LENGTH_SHORT).show();
                }
                else {
                    final ProgressDialog mDialog = new ProgressDialog(SignUp.this);
                    mDialog.setMessage("Loading . . .");
                    mDialog.show();

                    table_user.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if (dataSnapshot.child(edtPhone.getText().toString()).exists()) {
                                mDialog.dismiss();
                                Toast.makeText(SignUp.this, "Phone Number already exist", Toast.LENGTH_SHORT).show();
                            } else {
                                mDialog.dismiss();
                                Intent sign_up = new Intent(SignUp.this, SignUpStore.class);
                                sign_up.putExtra("phoneS", edtPhone.getText().toString());
                                sign_up.putExtra("nameS", edtPass.getText().toString());
                                sign_up.putExtra("passS", edtPass.getText().toString());
                                startActivity(sign_up);
                                finish();

                                //go to activity sign up store, send string to next activity, then if success, register User and Shop at the same time.
//                            User user = new User(edtName.getText().toString(),edtPass.getText().toString());
//                            table_user.child(edtPhone.getText().toString()).setValue(user);
//                            Toast.makeText(SignUp.this, "Sign Up successfully", Toast.LENGTH_SHORT).show();

                            }
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

package ugm.fznzz.findmycoffee.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import ugm.fznzz.findmycoffee.R;
import ugm.fznzz.findmycoffee.DataClass.User;

import android.app.ProgressDialog;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button log_in = findViewById(R.id.btnLogin);

        TextView txtLogin = findViewById(R.id.textLogin);
        Typeface face = Typeface.createFromAsset(getAssets(), "Fonts/font1.otf");
        txtLogin.setTypeface(face);

        final EditText edtPhone = findViewById(R.id.formUsername);
        final EditText edtPass = findViewById(R.id.formPass);



        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("User");

        log_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (edtPhone.getText().toString().isEmpty()) {
                    Toast.makeText(Login.this, "Please fill the Phone Number", Toast.LENGTH_SHORT).show();
                } else {
                    if (edtPass.getText().toString().isEmpty()) {
                        Toast.makeText(Login.this, "Please fill the Password", Toast.LENGTH_SHORT).show();
                    } else {
                        final ProgressDialog mDialog = new ProgressDialog(Login.this);
                        mDialog.setMessage("Loading . . .");
                        mDialog.show();

                        table_user.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                if (dataSnapshot.child(edtPhone.getText().toString()).exists()) {
                                    mDialog.dismiss();
                                    User user = dataSnapshot.child(edtPhone.getText().toString()).getValue(User.class);
                                    if (user.getPass().equals(edtPass.getText().toString())) {
                                        Toast.makeText(Login.this, "Logged in", Toast.LENGTH_SHORT).show();


                                    } else {
                                        Toast.makeText(Login.this, "Username/Password is incorrect", Toast.LENGTH_SHORT).show();
                                    }
                                } else {
                                    mDialog.dismiss();
                                    Toast.makeText(Login.this, "Username/Password is nonexist", Toast.LENGTH_LONG).show();
                                }
                            }


                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {

                            }
                        });

                    }
                }
            }
        });
    }
}

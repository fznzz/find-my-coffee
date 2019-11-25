package ugm.fznzz.findmycoffee.Activity;

import androidx.appcompat.app.AppCompatActivity;
import ugm.fznzz.findmycoffee.R;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSignIn = findViewById(R.id.btnEnter);
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainMenu = new Intent(MainActivity.this,MainMenu.class);
                startActivity(mainMenu);
            }
        });





//        Button btnSignUp = (Button)findViewById(R.id.btnSignUp);
//
        TextView txtTitle = findViewById(R.id.textTitle);
        Typeface face = Typeface.createFromAsset(getAssets(),"Fonts/font1.otf");
        txtTitle.setTypeface(face);
//
//        final EditText edtPhone = (EditText)findViewById(R.id.formUsername);
//        final EditText edtPass = (EditText)findViewById(R.id.formPass);
//
//        FirebaseDatabase database = FirebaseDatabase.getInstance();
//        final DatabaseReference table_user = database.getReference("User");
//
//        btnSignIn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                if(edtPhone.getText().toString().isEmpty())
//                {
//                    Toast.makeText(MainActivity.this, "Please fill the Phone Number", Toast.LENGTH_SHORT).show();
//                }
//                else {
//                    if(edtPass.getText().toString().isEmpty())
//                    {
//                        Toast.makeText(MainActivity.this, "Please fill the Password", Toast.LENGTH_SHORT).show();
//                    }
//                    else {
//                        final ProgressDialog mDialog = new ProgressDialog(MainActivity.this);
//                        mDialog.setMessage("Loading . . .");
//                        mDialog.show();
//
//                        table_user.addValueEventListener(new ValueEventListener() {
//                            @Override
//                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//
//
//                                if (dataSnapshot.child(edtPhone.getText().toString()).exists()) {
//                                    mDialog.dismiss();
//                                    User user = dataSnapshot.child(edtPhone.getText().toString()).getValue(User.class);
//                                    if (user.getPass().equals(edtPass.getText().toString())) {
//                                        Toast.makeText(MainActivity.this, "Sign In Success", Toast.LENGTH_SHORT).show();
//                                        Intent mainMenu = new Intent(MainActivity.this,MainMenu.class);
//                                        startActivity(mainMenu);
//                                    } else {
//                                        Toast.makeText(MainActivity.this, "Wrong Password", Toast.LENGTH_SHORT).show();
//                                    }
//                                } else {
//                                    mDialog.dismiss();
//                                    Toast.makeText(MainActivity.this, "User doesn't exist", Toast.LENGTH_LONG).show();
//                                }
//                            }
//
//                            @Override
//                            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//                            }
//                        });
//                    }
//                }
//            }
//        });
//        btnSignUp.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Intent signupAct = new Intent(MainActivity.this,SignUp.class);
//                startActivity(signupAct);
//
//            }
//
//        });


    }

}

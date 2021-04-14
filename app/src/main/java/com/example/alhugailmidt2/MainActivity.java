package com.example.alhugailmidt2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.NumberFormat;


public class MainActivity extends AppCompatActivity {
            DatabaseHelper Mydatab;
            EditText edtext1, edtext2, edtext3, edtext4;
            Button btninsert;


            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);
                edtext1 = (EditText)findViewById(R.id.idinput);
                edtext2 = (EditText)findViewById(R.id.nameiput);
                edtext3 = (EditText)findViewById(R.id.editTextTextEmailAddress);
                edtext4 = (EditText)findViewById(R.id.phonenumber);

                new CountDownTimer( 50000, 1000 ) {
                    public void onTick(long millisUntilFinished) {
                        // Used for formatting digit to be in 2 digits only
                        NumberFormat f = new DecimalFormat( "00" );
                        long hour = (millisUntilFinished / 3600000) % 24;
                        long min = (millisUntilFinished / 60000) % 60;
                        long sec = (millisUntilFinished / 1000) % 60;
                        textView.setText ( f.format ( hour ) + ":" + f.format ( min ) + ":" + f.format ( sec ) );
                    }

                            activity2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            openNewActivity();
                        }
                    });
                }
                public void openNewActivity(){
                    Intent intent = new Intent (this, secondactivity.class);
                    startActivity(intent);
                }
            }

                    // When the task is over it will print 00:00:00 there
                    public void onFinish() {
                        textView.setText ( "00:00:00" );
                    }
                }.start ();

                Mydatab = new DatabaseHelper(this);


                btninsert = (Button)findViewById(R.id.buttonInsert);

                btninsert.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Mydatab.Addinfo(edtext1.getText().toString(),
                                edtext2.getText().toString(),
                                Integer.parseInt(edtext3.getText().toString()));
                        Toast.makeText(MainActivity.this, "Successful Add", Toast.LENGTH_LONG).show();
                        edtext1.getText().clear();
                        edtext2.getText().clear();
                        edtext3.getText().clear(); }

                });



                Button goto2=findViewById(R.id.activity3);
                Button goto3=findViewById(R.id.activity2);

                goto2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(MainActivity.this,secondactivity.class));
                    }
                });
                goto3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(MainActivity.this,Activity3.class));
                    }
                });

            }
        }
    }

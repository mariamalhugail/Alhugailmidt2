package com.example.alhugailmidt2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Activity3 extends AppCompatActivity {
    @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate ( savedInstanceState );
                setContentView ( R.layout.activity_3 );
                final DatabaseHelper myDB = new DatabaseHelper ( this );
                final EditText employeeId = (EditText) findViewById ( R.id.idinput );
                final EditText employeeName = (EditText) findViewById ( R.id.nameiput );
                final Button delete = findViewById ( R.id.search );
                final Button view = findViewById ( R.id.view );
        final Button go1 = findViewById ( R.id.go1 );
        final Button go2 = findViewById ( R.id.go2 );


            go1.setOnClickListener(new View.OnClickListener() {

                                       public void onClick(View v) {


            }
    }

                delete.setOnClickListener ( new View.OnClickListener () {
                    @Override
                    public void onClick(View v) {
                        String id=employeeId.getText ().toString ();
                        myDB.DeleteEmployees ( id );
                        Toast toast = Toast.makeText ( getApplicationContext (),
                                Toast.makeText(Activity3.this,"Successfully deleted entry",Toast.LENGTH_SHORT).show();

                        toast.show ();
                    }


        view.setOnClickListener ( new View.OnClickListener () {
            public void onClick(View v) {

                Cursor cur = mydatab.ViewEmployees ();
                StringBuffer buffer = new StringBuffer ();
                while (cur.moveToNext ()) {
                    buffer.append ( "id: " + cur.getString ( 0 ) + "\n" );
                    buffer.append ( "Name: " + cur.getString ( 1 ) + "\n" );
                    buffer.append ( "email " + cur.getString ( 2 ) + "\n\n" );
                    buffer.append ( "Phone " + cur.getString ( 2 ) + "\n\n\n\n" );
                  }
                                                 }



                        go1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                startActivity(new Intent(Activity3.this,MainActivity.class));
                            }
                        });

                        go2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                startActivity(new Intent(Activity3.this,secondactivity.class));
                            }
                        });

                            AlertDialog.Builder builder = new AlertDialog.Builder(Activity3.this);
                            builder.setCancelable(true);
                            builder.setTitle("All Employees");
                            builder.setMessage(buffer.toString());
                            builder.show();
                        }
                    });
        } );


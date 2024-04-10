package com.example.quadraticequationsolverfrommaximfilippov;

import static java.lang.Math.random;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.Nullable;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    

    String st;
    final int REQUEST_CODE=100;
    int x1;
    int x2;
    TextView Formula;
    TextView a;
    TextView b;
    TextView c;
    int a1;
    int b1;
    int c1;
    Button answer;
    EditText a2;
    EditText b2;
    EditText c2;
    int max = 50;
    int min = -50;

    @Override
    protected void onActivityResult(int source, int result, @Nullable Intent data_back){

        super.onActivityResult(source, result, data_back);

        if (source == REQUEST_CODE) {

            if (result == Second_MainActivity.RESULT_OK) {

                if (data_back != null) {

                    x1 = data_back.getIntExtra("x1", -1);
                    x2 = data_back.getIntExtra("x2", -1);
                }

            }

        }

    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Formula= findViewById(R.id.textView);
        a= findViewById(R.id.textView3);
        b= findViewById(R.id.textView4);
        c= findViewById(R.id.textView5);
        answer= findViewById(R.id.button);
        a2= findViewById(R.id.editTextNumberSigned);
        b2= findViewById(R.id.editTextNumberSigned2);
        c2= findViewById(R.id.editTextNumberSigned3);
        a1=0;
        b1=0;
        c1=0;

    }

    public void answer(View view){

        st=a2.getText().toString();
        a1=Integer.parseInt(st);
        st=b2.getText().toString();
        b1=Integer.parseInt(st);
        st=c2.getText().toString();
        c1=Integer.parseInt(st);
        Intent si = new Intent(this, Second_MainActivity.class);
        si.putExtra("a", a1);
        si.putExtra("b", b1);
        si.putExtra("c", c1);
        startActivityForResult(si, REQUEST_CODE);
    }

    public void random(View view){
        //a1= new Random().nextInt((max - min) + 1) + min;
        //b1= new Random().nextInt((max - min) + 1) + min;
        //c1= new Random().nextInt((max - min) + 1) + min;
        Intent si = new Intent(this, Second_MainActivity.class);
        si.putExtra("a", a1);
        si.putExtra("b", b1);
        si.putExtra("c", c1);
        startActivityForResult(si, REQUEST_CODE);
    }


}
package com.example.quadraticequationsolverfrommaximfilippov;

import static java.lang.Math.*;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Second_MainActivity extends AppCompatActivity {

    Intent si;
    Intent gi;
    int a;
    int b;
    int c;
    double d;
    Button back;
    TextView answer;
    double x1;
    double x2;
    String x;
    boolean isAll_x;
    boolean is_x1;
    boolean is_x2;
    TextView Formula;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Formula= findViewById(R.id.textView2);
        x1=0;
        si = getIntent();
        a = si.getIntExtra("a", 1);
        b = si.getIntExtra("b", 1);
        c = si.getIntExtra("c", 1);
        back = findViewById(R.id.button3);
        answer = findViewById(R.id.textView7);
        int d = b * b - 4 * a * c;
        double sqrt_val = sqrt(abs(d));
        is_x1=true;
        is_x2=false;
        isAll_x=false;
        Formula.setText(a + "x^2+" + b + "x+" + c);
            if(a==0||b==0||c==0){
                if(a==0&&b==0&&c==0) {
                    isAll_x = true;
                    answer.setText("0=0\nevery x");
                }
                else if(c==0){
                    x1 = 0;
                    x2 = (-b)/a;
                    answer.setText("x(" + a + "x" + b + ")=0\nx = " + x1 + ",x = " + x2);
                }
                else if(a==0){
                    x1 = -c / b;
                    answer.setText(b + "x = " + c + "\nx = " + x1);
                }
                else if(b==0){
                    if((-c)/a<0){
                        is_x1=false;
                        answer.setText("x^2!=" + ((-c)/a) + "\nno x");
                    }
                    else if((-c)/a==0){
                        x1=0;
                        answer.setText("x^2!=" + ((-c)/a) + "\nx = 0");
                    }
                    else {
                        x1=sqrt(abs((-c)/a));
                        x2=-x1;
                        answer.setText("x^2=" + ((-c)/a) + "\nx1 = " + x1 + ", x2 = " + x2);
                    }
                }
            }
            else {
                x1 = ((-b + sqrt_val) / (2 * a));
                x2 = ((-b - sqrt_val) / (2 * a));
                answer.setText("d = " + d + "\nx1 = " + x1 + "\nx2 = " + x2);
            }


    }
    protected void back(){
        gi = new Intent(this, MainActivity.class);
        gi.putExtra("x1",x1);
        gi.putExtra("x2",x2);
        setResult(RESULT_OK, gi);
        finish();
    }
}
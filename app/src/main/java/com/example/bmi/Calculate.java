package com.example.bmi;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Calculate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);

        final Button calculate = findViewById(R.id.calculate);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText heightEditText = findViewById(R.id.height);
                EditText weightEditText = findViewById(R.id.weight);

                int h = Integer.parseInt(heightEditText.getText().toString());
                int w = Integer.parseInt(weightEditText.getText().toString());
                float bmi = calBMI(h,w);
                String printtext = "" ;
                if (bmi < 18.5){
                    printtext = "ผอมมากอีดอก" ;
                }
                else if (bmi <25){
                    printtext = "หุ่นดีขนาดนี้ไปประกวดนางแบบสิ" ;
                }
                else if (bmi <30){
                    printtext = "อีอ้วน รู้ตัวก็ลดน้ำหนักซะ" ;
                }
                else {
                    printtext = "อ้วนขนาดนี้ใกล้แล้วละ ใกล้ตายอ่ะ";
                }
                Toast t = Toast.makeText(Calculate.this,printtext,Toast.LENGTH_LONG);
                t.show();

                AlertDialog.Builder dialog = new AlertDialog.Builder(Calculate.this);
                dialog.setTitle("Result");
                dialog.setMessage(printtext);
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //todo : Code ที่ให้ทำเมื่อ User คลิก OK ใน dialog
                    }
                });
                dialog.setNegativeButton("No",null);
                dialog.setCancelable(false);//ถ้าเปลี่ยนเป็นtrueก็จะไม่ต้องกดปุ่มno,ok
                //todo : ถ้าไม่ใส่ dialog.setCancelable(false); เราจะสามารถออกจากหน้าต่างของ dialog โดยการกดข้างนอกปุ่มได้ แต่ถ้าใส่ เราต้องกดปุ่มใน dialog เท่านั้นจึงจะออกจากหน้าต่างของ dialog ได้
                dialog.show();
            }

        });
    }
    private float calBMI (int h,int w){
        float height = h/100f ;
        float bmi = w/(height*height);
        return bmi;
    }
 }

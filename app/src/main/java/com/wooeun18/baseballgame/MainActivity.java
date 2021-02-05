package com.wooeun18.baseballgame;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.RenderNode;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button[] btns = new Button[10];
    TextView tv01, tv02, tv03, tv04;
    Button btn;
    int com1, com2, com3,i,c=0;
    String ss="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv01 = findViewById(R.id.tv01);
        tv02 = findViewById(R.id.tv02);
        tv03 = findViewById(R.id.tv03);
        tv04 = findViewById(R.id.tv04);
        btn = findViewById(R.id.btn_ok);


        Random rnd = new Random();
        do {
            com1 = rnd.nextInt(10);
            com2 = rnd.nextInt(10);
            com3 = rnd.nextInt(10);
        } while (com1 == com2 || com1 == com3 || com2 == com3);


        for (i = 0; i < btns.length; i++) {
            int k = i;
            btns[i] = findViewById(R.id.btn00 + i);
            //우리가 배열을 클릭했을경우 tv숫자가 들어갈경우
            btns[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (c == 0) {
                        tv01.setText(k + "");
                        c++;
                    } else if (c == 1) {
                        tv02.setText(k + "");
                        c++;
                    } else if (c == 2) {
                        tv03.setText(k + "");
                        c++;
                    }


                }
            });


            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int s1 = Integer.parseInt(tv01.getText().toString());
                    int s2 = Integer.parseInt(tv02.getText().toString());
                    int s3 = Integer.parseInt(tv03.getText().toString());
                    int strike = 0, ball = 0;


                    if (s1 == com1) strike++;
                    else if (s1 == com2) ball++;
                    else if (s1 == com3) ball++;

                    if (s2 == com1) ball++;
                    else if (s2 == com2) strike++;
                    else if (s2 == com3) ball++;

                    if (s3 == com1) ball++;
                    else if (s3 == com2) ball++;
                    else if (s3 == com3) strike++;

                    ss+=s1 + "" + s2 + "" + s3 + "" + "strike :" + strike + " " + "" + "ball :" + ball + " \n";

                    tv04.setText(ss);


                    tv01.setText("");
                    tv02.setText("");
                    tv03.setText("");

                    c=0;

                    if(strike==3){
                        tv04.setText("정답입니다!");
                    }

                }
            });
        }


    }//onCreate

    public void clickBtn(View v) {
    }

}//엑티비티 클래스
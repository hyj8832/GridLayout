package com.example.admin.gridcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import static android.R.id.edit;

public class MainActivity extends AppCompatActivity  {
    Button[] butNums=new Button[10];
    Button[] butOps=new Button[4];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for(int i=0; i<butNums.length;i++){
            butNums[i]=(Button)findViewById(R.id.btn_0+i); //만약에 변수명이 어떤 것은 btn으로 시작하지 않는다면 이렇게 반복문을 돌릴 수 없다.
            butNums[i].setOnClickListener(butNumHandler);
        }
        for(int i=0;i<butOps.length;i++){
            butOps[i]=(Button)findViewById(R.id.btn_p+i);
            butOps[i].setOnClickListener(butOpHandler);
        }
    }

    View.OnClickListener butNumHandler =new View.OnClickListener(){

        public void onClick(View view){

        }
    };

    View.OnClickListener butOpHandler =new View.OnClickListener(){

        public void onClick(View view){

        }
    };
}

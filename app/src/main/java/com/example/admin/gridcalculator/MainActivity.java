package com.example.admin.gridcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import org.w3c.dom.Text;

import static android.R.id.edit;

public class MainActivity extends AppCompatActivity {//AppCompatActivity 는 안드로이드에서 제공하는 클래스
    EditText edit1, edit2;
    Button[] butNums = new Button[10];//0~9까지의 숫자 버튼
    Button[] butOps = new Button[4];
    public static final int SELECT_EDIT1 = 0;//상수
    public static final int SELECT_EDIT2 = 1;
    int selectEdit = SELECT_EDIT1;//
    String numStr = "";//초기화;
    TextView textResult;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit1 = (EditText) findViewById(R.id.edit1); //객체참조값 변수
        edit2 = (EditText) findViewById(R.id.edit2);
        edit1.setOnTouchListener(editHandler);
        edit2.setOnTouchListener(editHandler);
        textResult = (TextView) findViewById(R.id.text_result);
        for (int i = 0; i < butNums.length; i++) {
            butNums[i] = (Button) findViewById(R.id.btn_0 + i); //만약에 변수명이 어떤 것은 btn으로 시작하지 않는다면 이렇게 반복문을 돌릴 수 없다.
            butNums[i].setOnClickListener(butNumHandler);
        }
        for (int i = 0; i < butOps.length; i++) {
            butOps[i] = (Button) findViewById(R.id.btn_p + i);
            butOps[i].setOnClickListener(butOpHandler);
        }
    }


    View.OnClickListener butNumHandler = new View.OnClickListener() {

        public void onClick(View view) {
            Button but = (Button) view;
            numStr += but.getText();//문자열 연결
            switch (selectEdit) {
                case SELECT_EDIT1:
                    edit1.setText(numStr);//누적을 시켜줘야해 1있고 12는 2을 추가하는 거니까
                    break;
                case SELECT_EDIT2:
                    edit2.setText(numStr);//누적을 시켜줘야해 1있고 12는 2을 추가하는 거니까
                    //setText알고 보기.
                    break;
            }//end Switch

        }
    };


    View.OnClickListener butOpHandler = new View.OnClickListener() {//사칙연산 버튼 눌렀을때 밑의 함수 실행된다.
        public void onClick(View view) {
            int num1 = Integer.parseInt(edit1.getText().toString());
            int num2 = Integer.parseInt(edit2.getText().toString());
            double result = 0;
            switch (view.getId()) {//set 과 get을 이용해 값을 갖고와서 계산식을 통해 결과값을 뿌리기
                case R.id.btn_p:
                    result = num1 + num2;
                    break;
                case R.id.btn_mis:
                    result = num1 - num2;
                    break;
                case R.id.btn_mul:
                    result = num1 * num2;
                    break;
                case R.id.btn_d:
                    result = (double) num1 / num2;
                    break;

            }
            textResult.setText("* 계산 결과 = " + result);//숫자값을 문자열로 보여주기 위해 +""
        }
        };


        View.OnTouchListener editHandler = new View.OnTouchListener() { //이름없는 클래스 ,,일종의 객체 생성,오른쪽 애가 왼쪽으로
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                numStr = "";//초기화
                switch (v.getId()) {//터치된 위젯객체의 참조값이 매개변수로 온다.
                    case R.id.edit1:
                        selectEdit = SELECT_EDIT1;
                        break;
                    case R.id.edit2:
                        selectEdit = SELECT_EDIT2;
                        break;
                }
                return true;
            }
        };
}


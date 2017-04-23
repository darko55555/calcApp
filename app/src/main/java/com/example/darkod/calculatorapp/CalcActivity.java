package com.example.darkod.calculatorapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class CalcActivity extends Activity {

    String runningNumber = "";
    TextView resultsView;
    String leftValueStr = "";
    String rightValueStr = "";
    Operation currentOperation;
    int result = 0;

    public enum Operation{
            ADD, SUBTRACT, DIVIDE, MULTIPLY, EQUAL
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);

        final Button button0 = (Button)findViewById(R.id.button0);
        Button button1 = (Button)findViewById(R.id.button1);
        Button button2 = (Button)findViewById(R.id.button2);
        Button button3 = (Button)findViewById(R.id.button3);
        Button button4 = (Button)findViewById(R.id.button4);
        Button button5 = (Button)findViewById(R.id.button5);
        Button button6 = (Button)findViewById(R.id.button6);
        Button button7 = (Button)findViewById(R.id.button7);
        Button button8 = (Button)findViewById(R.id.button8);
        Button button9 = (Button)findViewById(R.id.button9);

        Button buttonAdd = (Button)findViewById(R.id.addBtn);
        Button buttonDivide = (Button)findViewById(R.id.divideBtn);
        Button buttonSubtract = (Button)findViewById(R.id.subtrackBtn);
        Button buttonMultiply = (Button)findViewById(R.id.multiplyBtn);
        Button buttonClear = (Button)findViewById(R.id.clearBtn);

        ImageButton equals = (ImageButton)findViewById(R.id.calcButton);

        resultsView = (TextView)findViewById(R.id.textView2);
        resultsView.setText("");

        button0.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
            numberPressed(0);

            }

        });
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                numberPressed(1);

            }

        });
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                numberPressed(2);
            }

        });
        button3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                numberPressed(3);

            }

        });
        button4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                numberPressed(4);
            }

        });
        button5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                numberPressed(5);

            }

        });
        button6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                numberPressed(6);

            }

        });
        button7.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                numberPressed(7);

            }

        });
        button8.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                numberPressed(8);

            }

        });

        button9.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                numberPressed(9);

            }

        });

        buttonAdd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                processOperation(Operation.ADD);
            }

        });

        buttonSubtract.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

            processOperation(Operation.SUBTRACT);
            }

        });

        buttonDivide.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                processOperation(Operation.DIVIDE);
            }

        });

        buttonMultiply.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                processOperation(Operation.MULTIPLY);
            }

        });

        equals.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                processOperation(Operation.EQUAL);

            }

        });

        buttonClear.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
            leftValueStr = "";
            rightValueStr = "";
            result = 0;
            runningNumber = "";
            resultsView.setText("");
            }

        });

    }

    void processOperation(Operation operation){
        if (currentOperation != null){

            if (runningNumber != ""){
                rightValueStr = runningNumber;
                runningNumber = "";

                switch (currentOperation){
                    case ADD:
                        result = Integer.parseInt(leftValueStr) + Integer.parseInt(rightValueStr);
                        break;
                    case SUBTRACT:
                        result = Integer.parseInt(leftValueStr) - Integer.parseInt(rightValueStr);
                        break;
                    case MULTIPLY:
                        result = Integer.parseInt(leftValueStr) * Integer.parseInt(rightValueStr);
                        break;
                    case DIVIDE:
                        result = Integer.parseInt(leftValueStr) / Integer.parseInt(rightValueStr);
                        break;

                }

                leftValueStr = String.valueOf(result);
                resultsView.setText(leftValueStr);
            }




        }else{
            leftValueStr = runningNumber;
            runningNumber = "";

        }
        currentOperation = operation;

    }
    void numberPressed(int number){
        runningNumber += String.valueOf(number);
        resultsView.setText(runningNumber);
    }


}

package com.example.h_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView mytextview;
    Button mybutton;
    EditText myinput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myinput = (EditText) findViewById(R.id.input);
        mytextview = (TextView) findViewById(R.id.mytextview);
        mybutton = (Button) findViewById(R.id.mybutton);
        mybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countdown1();
            }
        });

    }



    void countdown(int n){
        Thread countthread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for(int i = n;i>0;i--) {
                        int finalI = i;
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                mytextview.setText(Integer.toString(finalI));
                            }
                        });
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        countthread.start();
    }

    void countdown1(){
        Thread countthread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    boolean isnum = true;
                    String ns;
                    int n;
                    ns = String.valueOf(myinput.getText());
                    for(char c : ns.toCharArray()){
                        if(!('0' <= c  && c <= '9')) {
                            isnum = false;
                            break;
                        }
                    }
                    if(isnum){
                        n = Integer.parseInt(ns);
                        for(int i = n;i>0;i--) {
                            int finalI = i;
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    mytextview.setText(Integer.toString(finalI));
                                }
                            });
                            Thread.sleep(1000);
                        }
                    }
                    else{
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getApplicationContext(),"숫자만 입력해 주세요",Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        myinput.setText("");
                    }
                });
            }
        });

        countthread.start();
    }

}
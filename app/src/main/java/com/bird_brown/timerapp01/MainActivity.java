package com.bird_brown.timerapp01;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

import androidx.appcompat.app.AppCompatActivity;

                //ボタンを押した時の処理を行えるようにOnClickListenerインターフェースを実装
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Chronometer ch;     // クロノメーター

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //クロノメーターのオブジェクト取得
        ch = (Chronometer)findViewById(R.id.chronometer1);

        //スタートボタンのオブジェクト取得とイベントリスナ登録
        Button start = (Button)findViewById(R.id.button1);
        start.setOnClickListener(this);

        //ストップボタンのオブジェクト取得とイベントリスナ登録
        Button stop = (Button)findViewById(R.id.button2);
        stop.setOnClickListener(this);

        //リセットボタンのオブジェクト取得とイベントリスナ登録
        Button reset = (Button)findViewById(R.id.button3);
        reset.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {    //ボタンが押された時に呼び出されるonClickメソッド
        //クリックしたボタンのリソースIDを取得
        int id = view.getId();

        switch (id) {
            case R.id.button1:
                ch.setBase(SystemClock.elapsedRealtime());  //タイマーを0秒に設定
                ch.start();     //タイマー起動
                break;
            case R.id.button2:
                ch.stop();      //タイマー停止
                break;
            case R.id.button3:
                ch.stop();      //タイマー停止
                ch.setBase(SystemClock.elapsedRealtime());  //タイマーを0秒に設定
                break;
        }
    }
}

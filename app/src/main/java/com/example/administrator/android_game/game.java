package com.example.administrator.android_game;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class game extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        initImg();
    }
    int[] score = new int[12];
    int max_score=0;
    String score_str;
    Timer timer = null;
    TimerTask mTimerTask = null;
    boolean flag = false;
    public void play_btn(View view){
        ((TextView)findViewById(R.id.score)).setText("score:0");
        if (timer == null) timer = new Timer();
        if (mTimerTask == null) mTimerTask = new TimerTask() {
            @Override
            public void run() {
                for (int i = 0; i < 6; i++) {
                    random_img[i] = random.nextInt(12);
                }
                for(int i=0;i<12;i++) score[i] = 0;
                max_score = 0;
                setImg(R.id.img1, random_img[0]);
                setImg(R.id.img2, random_img[1]);
                setImg(R.id.img3, random_img[2]);
                setImg(R.id.img4, random_img[3]);
                setImg(R.id.img5, random_img[4]);
                setImg(R.id.img6, random_img[5]);
                for(int i=0;i<12;i++){
                    if(score[i] > max_score) max_score = score[i];
                }
            }
        };
        timer.schedule(mTimerTask, 100L, 100L);

    }

    public void Stop_btn(View view)
    {
        score_str = String.valueOf("score:"+max_score);
        ((TextView)findViewById(R.id.score)).setText(score_str);
        if (timer != null) {
            timer.cancel();
            timer = null;
        }

        if (mTimerTask != null) {
            mTimerTask.cancel();
            mTimerTask = null;
        }
    }

    Random random = new Random();
    int[] img = new int[12];
    int[] random_img = new int[12];
    public void initImg(){
        img[0] = R.drawable.bear;
        img[1] = R.drawable.cat;
        img[2] = R.drawable.elephant;
        img[3] = R.drawable.honey;
        img[4] = R.drawable.kangaroo;
        img[5] = R.drawable.leo;
        img[6] = R.drawable.lion;
        img[7] = R.drawable.pig;
        img[8] = R.drawable.rhino;
        img[9] = R.drawable.tiger;
        img[10] = R.drawable.wolf;
        img[11] = R.drawable.hypo;
        for (int i=0;i<6;i++)
        {
            random_img[i] = random.nextInt(12);
        }
    }

    public void setImg(int id, int index){
        switch (index){
            case 0:{((ImageView)findViewById(id)).setImageResource(R.drawable.bear);score[0]++;break;}
            case 1:{((ImageView)findViewById(id)).setImageResource(R.drawable.cat);score[1]++;break;}
            case 2:{((ImageView)findViewById(id)).setImageResource(R.drawable.elephant);score[2]++;break;}
            case 3:{((ImageView)findViewById(id)).setImageResource(R.drawable.honey);score[3]++;break;}
            case 4:{((ImageView)findViewById(id)).setImageResource(R.drawable.kangaroo);score[4]++;break;}
            case 5:{((ImageView)findViewById(id)).setImageResource(R.drawable.leo);score[5]++;break;}
            case 6:{((ImageView)findViewById(id)).setImageResource(R.drawable.lion);score[6]++;break;}
            case 7:{((ImageView)findViewById(id)).setImageResource(R.drawable.pig);score[7]++;break;}
            case 8:{((ImageView)findViewById(id)).setImageResource(R.drawable.rhino);score[8]++;break;}
            case 9:{((ImageView)findViewById(id)).setImageResource(R.drawable.tiger);score[9]++;break;}
            case 10:{((ImageView)findViewById(id)).setImageResource(R.drawable.wolf);score[10]++;break;}
            case 11:{((ImageView)findViewById(id)).setImageResource(R.drawable.hypo);score[11]++;break;}
            default:return;
        }
    }


}

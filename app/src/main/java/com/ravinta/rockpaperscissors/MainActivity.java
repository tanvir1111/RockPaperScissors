package com.ravinta.rockpaperscissors;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView rock,paper,scissors,result;
    ImageView welcomeImg;
    Animation zoomIn,zoomOut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        rock=findViewById(R.id.rockBtn);
        paper=findViewById(R.id.paperBtn);
        scissors=findViewById(R.id.scissorsBtn);
        result=findViewById(R.id.result);
        welcomeImg=findViewById(R.id.welcomeText);
        rock.setOnClickListener(this);
        paper.setOnClickListener(this);
        scissors.setOnClickListener(this);
        result.setOnClickListener(this);
         zoomIn= AnimationUtils.loadAnimation(this,R.anim.zoom_in);
        zoomOut= AnimationUtils.loadAnimation(this,R.anim.zoom_out);
        welcomeImg.setAnimation(zoomIn);


    }


    @Override
    protected void onResume() {
        super.onResume();
        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                welcomeImg.setAnimation(zoomOut);
                welcomeImg.setVisibility(View.GONE);
                startNew();


            }
        },2000);




    }
    private void startNew() {
        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                welcomeImg.setVisibility(View.GONE);
                result.setVisibility(View.GONE);
                rock.setBackground(getDrawable(R.drawable.rock));
                paper.setBackground(getDrawable(R.drawable.paper));
                scissors.setBackground(getDrawable(R.drawable.scissors));
                rock.setVisibility(View.VISIBLE);
                paper.setVisibility(View.VISIBLE);
                scissors.setVisibility(View.VISIBLE);


            }
        },400);




    }
    void showResult(String userChoice){
        paper.setVisibility(View.GONE);
        String botOptions[]={"rock","paper","scissors"};
        int botChoice,id;
        botChoice= new Random().nextInt(3);
        id = getResources().getIdentifier(botOptions[botChoice], "drawable", getPackageName());
        scissors.setBackground(getDrawable(id));
        if(userChoice.equals(botOptions[botChoice])){
            result.setVisibility(View.VISIBLE);
            result.setText("Draw");
        }
        else
        {
            if(userChoice.equals("rock")){
                if(botOptions[botChoice].equals("paper")){
                    result.setVisibility(View.VISIBLE);
                    result.setText("You Lost");
                }
                else {
                    result.setVisibility(View.VISIBLE);
                    result.setText("You win");
                }
            }
            else if(userChoice.equals("paper")){
                if(botOptions[botChoice].equals("scissors")){
                    result.setVisibility(View.VISIBLE);
                    result.setText("You Lost");
                }
                else {

                    result.setVisibility(View.VISIBLE);
                    result.setText("You win");
                }
            }
            else if(userChoice.equals("scissors")){
                if(botOptions[botChoice].equals("paper")){
                    result.setVisibility(View.VISIBLE);
                    result.setText("You Lost");

                }
                else {
                    result.setVisibility(View.VISIBLE);
                    result.setText("You Win");

                }
            }
        }



    }


    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.rockBtn:
                rock.setBackground(v.getBackground());

                showResult("rock");
                break;
            case R.id.paperBtn:
                rock.setBackground(v.getBackground());
                showResult("paper");
                break;
            case R.id.scissorsBtn:
                rock.setBackground(v.getBackground());
                showResult("scissors");
                break;
            case R.id.result:
                startNew();
                break;
        }



    }




}
package com.ravinta.rockpaperscissors;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView rock,paper,scissors,result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        rock=findViewById(R.id.rockBtn);
        paper=findViewById(R.id.paperBtn);
        scissors=findViewById(R.id.scissorsBtn);
        result=findViewById(R.id.result);
        rock.setOnClickListener(this);
        paper.setOnClickListener(this);
        scissors.setOnClickListener(this);
        result.setOnClickListener(this);


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

    private void startNew() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            Intent intent=new Intent(MainActivity.this,MainActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
package tw.edu.pu.s1063680.little_earth;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class GameActivity3 extends AppCompatActivity  implements DialogInterface.OnClickListener{
    Random rand = new Random();
    int randNumber;
    int counter ;
    private SoundPool soundPool;
    private int soundID,soundID2;
    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == DialogInterface.BUTTON_POSITIVE){
            ImageView image = (ImageView) findViewById(R.id.imageView);
            image.setImageResource(R.drawable.empty);
            //再玩一次，設定遊戲初始值
            counter=0;
            //設定全螢幕顯示
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
        else if (i == DialogInterface.BUTTON_NEGATIVE) {
            Intent it = new Intent();
            it.setClass(this, GameActivity6.class);
            startActivity(it);
            finish();
        }
    }
    @SuppressLint("NewApi")
    private void initSound(){
        soundPool = new SoundPool.Builder().build();
        soundID = soundPool.load(this, R.raw.bingo, 5);
        soundID2 = soundPool.load(this, R.raw.error, 5);

    }
    private void playSound() {
        soundPool.play(
                soundID,
                0.1f,      //左耳道音量【0~1】
                0.5f,      //右耳道音量【0~1】
                0,         //播放优先级【0表示最低优先级】
                0,         //循环模式【0表示循环一次，-1表示一直循环，其他表示数字+1表示当前数字对应的循环次数】
                1          //播放速度【1是正常，范围从0~2】
        );
    }
    private void playSound2() {
        soundPool.play(
                soundID2,
                0.1f,      //左耳道音量【0~1】
                0.5f,      //右耳道音量【0~1】
                0,         //播放优先级【0表示最低優先级】
                0,         //循环模式【0表示循环一次，-1表示一直循环，其他表示数字+1表示当前数字对应的循环次数】
                1          //播放速度【1是正常，范围从0~2】
        );
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initSound();
        counter=0;
        //設定全螢幕顯示
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        //設定螢幕為橫式
        setContentView(R.layout.activity_game3);
        Button button10 = findViewById(R.id.button10);//给按钮rollButton设置点击监听器，一旦用户点击按钮，就触发监听器的onClick方法
        button10.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int prerandNumber = randNumber;
//                产生随机数
                randNumber = rand.nextInt(10) + 1;
//                String randNumber2 = rand.nextInt(10)+1;
                ImageView image = (ImageView) findViewById(R.id.imageView);
                if(randNumber != prerandNumber){
                    image.setImageResource(R.drawable.empty);
                }
//                获取对ImageView对象的引用
                ImageView diceImage = findViewById(R.id.imageView12);

                int drawableResource;
//                将随机数与对应的图片资源联系起来
                switch (randNumber) {
                    case 1:
                        drawableResource = R.drawable.paper;
                        break;
                    case 2:
                        drawableResource = R.drawable.box;
                        break;
                    case 3:
                        drawableResource = R.drawable.carton;
                        break;
                    case 4:
                        drawableResource = R.drawable.chopsticks;
                        break;
                    case 5:
                        drawableResource = R.drawable.smoke;
                        break;
                    case 6:
                        drawableResource = R.drawable.apple;
                        break;
                    case 7:
                        drawableResource = R.drawable.bag;
                        break;
                    case 8:
                        drawableResource = R.drawable.banana;
                        break;
                    case 9:
                        drawableResource = R.drawable.bottle;
                        break;
                    case 10:
                        drawableResource = R.drawable.toast;
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + randNumber);
                }

//                随机图片根据rangNumber的值对应drawableResource的int值，实例Drawable类
                Drawable drawable = getBaseContext().getResources().getDrawable(drawableResource);

//                设置ImageView控件最终显示的图片
                diceImage.setImageDrawable(drawable);
            }
        });
        Button button12 = (Button) findViewById(R.id.button12);
        button12.setOnClickListener(new View.OnClickListener() {
            ImageView image = (ImageView) findViewById(R.id.imageView);
            @Override
            public void onClick(View arg0) {
                arg0.bringToFront();

                boolean clickTrashCan = false;

                // 按下按鈕,來切換圖片
                if (!clickTrashCan) {

                    if (randNumber == 1 || randNumber == 4 || randNumber == 5) {
                        image.setImageResource(R.drawable.correct);
                        playSound();
                        counter++;
                        clickTrashCan = true;
                    }else {
                        image.setImageResource(R.drawable.error);
                        playSound2();
                        clickTrashCan = false;
                    }
                }
                if(counter==3) GameOver();
            }

        });
        Button button13 = (Button) findViewById(R.id.button13);
        button13.setOnClickListener(new View.OnClickListener() {
            ImageView image = (ImageView) findViewById(R.id.imageView);
            @Override
            public void onClick(View arg0) {
                arg0.bringToFront();

                boolean clickTrashCan = false;

                // 按下按鈕,來切換圖片
                if (!clickTrashCan) {

                    if (randNumber == 2 || randNumber == 3) {
                        image.setImageResource(R.drawable.correct);
                        playSound();
                        counter++;
                        clickTrashCan = true;
                    }else {
                        image.setImageResource(R.drawable.error);
                        playSound2();
                        clickTrashCan = false;
                    }
                }
                if(counter==3) GameOver();
            }

        });
        Button button14 = (Button) findViewById(R.id.button14);
        button14.setOnClickListener(new View.OnClickListener() {
            ImageView image = (ImageView) findViewById(R.id.imageView);
            @Override
            public void onClick(View arg0) {
                arg0.bringToFront();

                boolean clickTrashCan = false;

                // 按下按鈕,來切換圖片
                if (!clickTrashCan) {

                    if (randNumber == 7|| randNumber == 9) {
                        image.setImageResource(R.drawable.correct);
                        playSound();
                        counter++;
                        clickTrashCan = true;
                    }else {
                        image.setImageResource(R.drawable.error);
                        playSound2();
                        clickTrashCan = false;
                    }
                }
                if(counter==3) GameOver();
            }

        });
        Button button17 = (Button) findViewById(R.id.button17);
        button17.setOnClickListener(new View.OnClickListener() {
            ImageView image = (ImageView) findViewById(R.id.imageView);
            @Override
            public void onClick(View arg0) {
                arg0.bringToFront();

                boolean clickTrashCan = false;

                // 按下按鈕,來切換圖片
                if (!clickTrashCan) {

                    if (randNumber == 6|| randNumber == 8 || randNumber == 10) {
                        image.setImageResource(R.drawable.correct);
                        playSound();
                        counter++;
                        clickTrashCan = true;
                    }else {
                        image.setImageResource(R.drawable.error);
                        playSound2();
                        clickTrashCan = false;
                    }
                }
                if(counter==3) GameOver();
            }

        });
    }
    public void GameOver(){
        //遊戲結束處理
        new AlertDialog.Builder(this)
                .setTitle("恭喜過關")
                .setMessage("目前分數:" + String.valueOf(counter))
                .setIcon(R.drawable.earthicon)
                .setPositiveButton("再玩一次", this)
                .setNegativeButton("進度表", this)
                .show();
    }
    public void backgame(View v){
        Intent it = new Intent();
        it.setClass(this, GameActivity1.class);
        startActivity(it);
        finish();
    }
}
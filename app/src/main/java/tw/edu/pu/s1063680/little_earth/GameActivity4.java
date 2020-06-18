package tw.edu.pu.s1063680.little_earth;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class GameActivity4 extends AppCompatActivity {
    Random rand = new Random();
    int randNumber;
    private SoundPool soundPool;
    private int soundID,soundID2;
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
        //設定全螢幕顯示
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        //設定螢幕為橫式
        setContentView(R.layout.activity_game4);
        Button button11 = findViewById(R.id.button11);//给按钮rollButton设置点击监听器，一旦用户点击按钮，就触发监听器的onClick方法
        button11.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int prerandNumber = randNumber;
//                产生随机数
                 randNumber = rand.nextInt(12) + 1;
//                String randNumber2 = rand.nextInt(12)+1;
                ImageView image2 = (ImageView) findViewById(R.id.imageView2);
                if(randNumber != prerandNumber){
                    image2.setImageResource(R.drawable.empty);
                }
//                获取对ImageView对象的引用
                ImageView diceImage = findViewById(R.id.imageView13);

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
                    case 11:
                        drawableResource = R.drawable.tincan;
                        break;
                    case 12:
                        drawableResource = R.drawable.tincan2;
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
        Button button18 = (Button) findViewById(R.id.button18);
        button18.setOnClickListener(new View.OnClickListener() {
            ImageView image2 = (ImageView) findViewById(R.id.imageView2);
            @Override
            public void onClick(View arg0) {
                arg0.bringToFront();

                boolean clickTrashCan = false;

                // 按下按鈕,來切換圖片
                if (!clickTrashCan) {

                    if (randNumber == 1 || randNumber == 4 || randNumber == 5) {
                        image2.setImageResource(R.drawable.correct);
                        playSound();
                        clickTrashCan = true;
                    }else {
                        image2.setImageResource(R.drawable.error);
                        playSound2();
                        clickTrashCan = false;
                    }
                }

            }

        });
        Button button20 = (Button) findViewById(R.id.button20);
        button20.setOnClickListener(new View.OnClickListener() {
            ImageView image2 = (ImageView) findViewById(R.id.imageView2);
            @Override
            public void onClick(View arg0) {
                arg0.bringToFront();

                boolean clickTrashCan = false;

                // 按下按鈕,來切換圖片
                if (!clickTrashCan) {

                    if (randNumber == 2 || randNumber == 3) {
                        image2.setImageResource(R.drawable.correct);
                        playSound();
                        clickTrashCan = true;
                    }else {
                        image2.setImageResource(R.drawable.error);
                        playSound2();
                        clickTrashCan = false;
                    }
                }

            }

        });
        Button button22 = (Button) findViewById(R.id.button22);
        button22.setOnClickListener(new View.OnClickListener() {
            ImageView image2 = (ImageView) findViewById(R.id.imageView2);
            @Override
            public void onClick(View arg0) {
                arg0.bringToFront();

                boolean clickTrashCan = false;

                // 按下按鈕,來切換圖片
                if (!clickTrashCan) {

                    if (randNumber == 6|| randNumber == 8 || randNumber == 10) {
                        image2.setImageResource(R.drawable.correct);
                        playSound();
                        clickTrashCan = true;
                    }else {
                        image2.setImageResource(R.drawable.error);
                        playSound2();
                        clickTrashCan = false;
                    }
                }

            }

        });
        Button button19 = (Button) findViewById(R.id.button19);
        button19.setOnClickListener(new View.OnClickListener() {
            ImageView image2 = (ImageView) findViewById(R.id.imageView2);
            @Override
            public void onClick(View arg0) {
                arg0.bringToFront();

                boolean clickTrashCan = false;

                // 按下按鈕,來切換圖片
                if (!clickTrashCan) {

                    if (randNumber == 7|| randNumber == 9) {
                        image2.setImageResource(R.drawable.correct);
                        playSound();
                        clickTrashCan = true;
                    }else {
                        image2.setImageResource(R.drawable.error);
                        playSound2();
                        clickTrashCan = false;
                    }
                }

            }

        });
        Button button21 = (Button) findViewById(R.id.button21);
        button21.setOnClickListener(new View.OnClickListener() {
            ImageView image2 = (ImageView) findViewById(R.id.imageView2);
            @Override
            public void onClick(View arg0) {
                arg0.bringToFront();

                boolean clickTrashCan = false;

                // 按下按鈕,來切換圖片
                if (!clickTrashCan) {

                    if (randNumber == 11|| randNumber == 12) {
                        image2.setImageResource(R.drawable.correct);
                        playSound();
                        clickTrashCan = true;
                    }else {
                        image2.setImageResource(R.drawable.error);
                        playSound2();
                        clickTrashCan = false;
                    }
                }

            }

        });
    }
    public void backgame(View v){
        Intent it = new Intent();
        it.setClass(this, GameActivity1.class);
        startActivity(it);
        finish();
    }
}
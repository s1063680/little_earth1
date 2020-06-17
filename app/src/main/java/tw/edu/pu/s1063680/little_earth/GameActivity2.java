package tw.edu.pu.s1063680.little_earth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class GameActivity2 extends AppCompatActivity {
    Random rand = new Random();
    int randNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //設定全螢幕顯示
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        //設定螢幕為橫式
        setContentView(R.layout.activity_game2);
        Button button9 = findViewById(R.id.button9);
        //给按钮rollButton设置点击监听器，一旦用户点击按钮，就触发监听器的onClick方法
        button9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int prerandNumber = randNumber;
                //                产生随机数
                randNumber = rand.nextInt(5) + 1;
                //String randNumber2 = rand.nextInt(5)+1;

                ImageView image14 = (ImageView) findViewById(R.id.imageView14);
                if(randNumber != prerandNumber){
                    image14.setImageResource(R.drawable.empty);
                }

//                获取对ImageView对象的引用
                ImageView diceImage = findViewById(R.id.dice_image);

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
                    default:
                        throw new IllegalStateException("Unexpected value: " + randNumber);
                }

//                随机图片根据rangNumber的值对应drawableResource的int值，实例Drawable类
                Drawable drawable = getBaseContext().getResources().getDrawable(drawableResource);

//                设置ImageView控件最终显示的图片
                diceImage.setImageDrawable(drawable);
            }
        });
        Button button15 = (Button) findViewById(R.id.button15);
        button15.setOnClickListener(new OnClickListener() {
            ImageView image14 = (ImageView) findViewById(R.id.imageView14);
            @Override
            public void onClick(View arg0) {
                arg0.bringToFront();

                boolean clickTrashCan = false;

                // 按下按鈕,來切換圖片
                if (!clickTrashCan) {

                    if (randNumber == 1 || randNumber == 4 || randNumber == 5) {
                        image14.setImageResource(R.drawable.correct);
                        clickTrashCan = true;
                    }else {
                        image14.setImageResource(R.drawable.error);
                        clickTrashCan = false;
                    }
                }

            }

        });
        Button button16 = (Button) findViewById(R.id.button16);
        button16.setOnClickListener(new OnClickListener() {
            ImageView image14 = (ImageView) findViewById(R.id.imageView14);
            @Override
            public void onClick(View arg0) {
                arg0.bringToFront();

                boolean clickTrashCan = false;

                // 按下按鈕,來切換圖片
                if (!clickTrashCan) {

                    if (randNumber == 2 || randNumber == 3) {
                        image14.setImageResource(R.drawable.correct);
                        clickTrashCan = true;
                    }else {
                        image14.setImageResource(R.drawable.error);
                        clickTrashCan = false;
                    }
                }
            }

        });
        }
    public void backgame (View v){
            Intent it = new Intent();
            it.setClass(this, GameActivity1.class);
            startActivity(it);
            finish();
        }
}
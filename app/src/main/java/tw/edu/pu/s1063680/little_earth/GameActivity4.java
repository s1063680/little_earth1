package tw.edu.pu.s1063680.little_earth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class GameActivity4 extends AppCompatActivity {

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
        setContentView(R.layout.activity_game4);
        Button button11 = findViewById(R.id.button11);//给按钮rollButton设置点击监听器，一旦用户点击按钮，就触发监听器的onClick方法
        button11.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

//                产生随机数
                Random rand = new Random();
                int randNumber = rand.nextInt(15) + 1;
//                String randNumber2 = rand.nextInt(15)+1;

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
                        drawableResource = R.drawable.drink;
                        break;
                    case 12:
                        drawableResource = R.drawable.noodles;
                        break;
                    case 13:
                        drawableResource = R.drawable.tincan;
                        break;
                    case 14:
                        drawableResource = R.drawable.tincan2;
                        break;
                    case 15:
                        drawableResource = R.drawable.yakult;
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
    }
    public void backgame(View v){
        Intent it = new Intent();
        it.setClass(this, GameActivity1.class);
        startActivity(it);
        finish();
    }
}
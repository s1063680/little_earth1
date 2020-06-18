package tw.edu.pu.s1063680.little_earth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class GameActivity1 extends AppCompatActivity {

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
        setContentView(R.layout.activity_game1);
    }
    public void easygame(View v){
        Intent it = new Intent();
        it.setClass(this, GameActivity2.class);
        startActivity(it);
        finish();
    }
    public void commongame(View v){
        Intent it = new Intent();
        it.setClass(this, GameActivity3.class);
        startActivity(it);
        finish();
    }
    public void hardgame(View v){
        Intent it = new Intent();
        it.setClass(this, GameActivity4.class);
        startActivity(it);
        finish();
    }
    public void backearth(View v){
        Intent it = new Intent();
        it.setClass(this, GameActivity.class);
        startActivity(it);
        finish();
    }
}
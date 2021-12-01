package xyz.theadityamishra.musictunes.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;



import xyz.theadityamishra.musictunes.MainActivity;
import xyz.theadityamishra.musictunes.R;

public class SplashScreen extends AppCompatActivity {

    TextView app_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        app_name = findViewById(R.id.appName);

        int splashScreenTime = 2000;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, splashScreenTime);

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.fade_up);
        app_name.startAnimation(animation);

    }
}
package com.medicossv.medicosinfo.guiamedica;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import me.wangyuwei.particleview.ParticleView;

public class Splash extends AppCompatActivity {

    ParticleView mPvGithub;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);

        mPvGithub = (ParticleView) findViewById(R.id.pv_1);

        mPvGithub.startAnim();

        mPvGithub.setOnParticleAnimListener(new ParticleView.ParticleAnimListener() {
            @Override
            public void onAnimationEnd() {
                Intent intent = new Intent(Splash.this, Principal.class);
                Splash.this.startActivity(intent);
                finish();
            }
        });

    }
}

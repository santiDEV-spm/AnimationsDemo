package com.santidev.animationsdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity implements Animation.AnimationListener, View.OnClickListener {

    Animation animFadeIn, animFadeOut, animFadeInOut,
              animZoomIn, animZoomOut,
              animLeftRight, animTopBottom, animRightLeft,
              animBounce, animFlash,
              animRotateLeft, animRotateRight;


    ImageView imageView;
    TextView textViewStatus;

    Button btnFadeIn, btnFadeOut, btnFadeInOut,
           btnZoomIn, btnZoomOut,
           btnLeftRight, btnTopBottom, btnRightLeft,
           btnBounce, btnFlash,
           btnRotateLeft, btnRotateRight;

    SeekBar seekBarSpeed;
    TextView textViewSeekSpeed;

    int seekSpeedProgrees;

    private void loadAnimations(){

        animFadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        animFadeIn.setAnimationListener(this);

        animFadeOut = AnimationUtils.loadAnimation(this, R.anim.fade_out);
        animFadeOut.setAnimationListener(this);

        animFadeInOut = AnimationUtils.loadAnimation(this, R.anim.fade_in_out);
        animFadeInOut.setAnimationListener(this);

        animZoomIn = AnimationUtils.loadAnimation(this, R.anim.zoom_in);
        animZoomIn.setAnimationListener(this);

        animZoomOut = AnimationUtils.loadAnimation(this, R.anim.zoom_out);
        animZoomOut.setAnimationListener(this);

        animLeftRight = AnimationUtils.loadAnimation(this, R.anim.left_right);
        animLeftRight.setAnimationListener(this);

        animTopBottom= AnimationUtils.loadAnimation(this, R.anim.top_bottom);
        animTopBottom.setAnimationListener(this);

        animRightLeft = AnimationUtils.loadAnimation(this, R.anim.right_left);
        animRightLeft.setAnimationListener(this);

        animBounce = AnimationUtils.loadAnimation(this, R.anim.bounce);
        animBounce.setAnimationListener(this);

        animFlash = AnimationUtils.loadAnimation(this, R.anim.flash);
        animFlash.setAnimationListener(this);

        animRotateLeft = AnimationUtils.loadAnimation(this, R.anim.rotate_left);
        animRotateLeft.setAnimationListener(this);

        animRotateRight = AnimationUtils.loadAnimation(this, R.anim.rotate_right);
        animRotateRight.setAnimationListener(this);
    }

    private void loadUI(){
        imageView = (ImageView) findViewById(R.id.image_view);

        btnFadeIn = (Button) findViewById(R.id.btnFadeIn);
        btnFadeIn.setOnClickListener(this);

        btnFadeOut = (Button) findViewById(R.id.btnFadeOut);
        btnFadeOut.setOnClickListener(this);

        btnFadeInOut = (Button) findViewById(R.id.btnFadeInOut);
        btnFadeInOut.setOnClickListener(this);

        btnZoomIn = (Button) findViewById(R.id.btnZoomIn);
        btnZoomIn.setOnClickListener(this);

        btnZoomOut = (Button) findViewById(R.id.btnZoomOut);
        btnZoomOut.setOnClickListener(this);

        btnLeftRight = (Button) findViewById(R.id.btnLeftRight);
        btnLeftRight.setOnClickListener(this);

        btnTopBottom = (Button) findViewById(R.id.btnTopBottom);
        btnTopBottom.setOnClickListener(this);

        btnRightLeft = (Button) findViewById(R.id.btnRightLeft);
        btnRightLeft.setOnClickListener(this);

        btnBounce = (Button) findViewById(R.id.btnBounce);
        btnBounce.setOnClickListener(this);

        btnFlash = (Button) findViewById(R.id.btnFlash);
        btnFlash.setOnClickListener(this);

        btnRotateLeft = (Button) findViewById(R.id.btnRotateLeft);
        btnRotateLeft.setOnClickListener(this);

        btnRotateRight = (Button) findViewById(R.id.btnRotateRight);
        btnRotateRight.setOnClickListener(this);

        seekBarSpeed = (SeekBar) findViewById(R.id.seekBarSpeed);
        textViewSeekSpeed = (TextView) findViewById(R.id.textSeekSpeed);
        textViewStatus = (TextView) findViewById(R.id.text_status);

        seekBarSpeed.setProgress(2000);
        textViewSeekSpeed.setText(seekBarSpeed.getProgress()+"/"+seekBarSpeed.getMax());

        seekBarSpeed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int currentValue, boolean fromUser) {
                //Detecta un movimiento en la seekbar
                seekSpeedProgrees = currentValue;
                textViewSeekSpeed.setText(seekSpeedProgrees+"/"+seekBarSpeed.getMax());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //Detecta que el usuario empia a mover una seekbar
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //Detecta cuando el usuario acaba de mover la seekbar
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadAnimations();
        loadUI();
    }

    /*
    * Metodos del AnimationListener
    * */

    @Override
    public void onAnimationStart(Animation animation) {
        textViewStatus.setText("Running");
    }

    @Override
    public void onAnimationEnd(Animation animation) {
        textViewStatus.setText("Stopped");
    }

    @Override
    public void onAnimationRepeat(Animation animation) {
        textViewStatus.setText("Repeating");
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btnFadeIn:
                animFadeIn.setDuration(this.seekSpeedProgrees);
                imageView.startAnimation(animFadeIn);
                break;
            case R.id.btnFadeOut:
                animFadeOut.setDuration(this.seekSpeedProgrees);
                imageView.startAnimation(animFadeOut);
                break;
            case R.id.btnFadeInOut:
                animFadeInOut.setDuration(this.seekSpeedProgrees);
                imageView.startAnimation(animFadeInOut);
                break;
            case R.id.btnZoomIn:
                animZoomIn.setDuration(this.seekSpeedProgrees);
                imageView.setAnimation(animZoomIn);
                break;
            case R.id.btnZoomOut:
                animZoomOut.setDuration(this.seekSpeedProgrees);
                imageView.startAnimation(animZoomOut);
                break;
            case R.id.btnLeftRight:
                animLeftRight.setDuration(this.seekSpeedProgrees);
                imageView.setAnimation(animLeftRight);
                break;
            case R.id.btnTopBottom:
                animTopBottom.setDuration(this.seekSpeedProgrees);
                imageView.setAnimation(animTopBottom);
                break;
            case R.id.btnRightLeft:
                animRightLeft.setDuration(this.seekSpeedProgrees);
                imageView.setAnimation(animRightLeft);
                break;
            case R.id.btnBounce:
                animBounce.setDuration(this.seekSpeedProgrees/10);
                imageView.setAnimation(animBounce);
                break;
            case R.id.btnFlash:
                animFlash.setDuration(this.seekSpeedProgrees/10);
                imageView.setAnimation(animFlash);
                break;
            case R.id.btnRotateLeft:
                animRotateLeft.setDuration(this.seekSpeedProgrees);
                imageView.setAnimation(animRotateLeft);
                break;
            case R.id.btnRotateRight:
                animRotateRight.setDuration(this.seekSpeedProgrees);
                imageView.setAnimation(animRotateRight);
                break;

        }

    }
}
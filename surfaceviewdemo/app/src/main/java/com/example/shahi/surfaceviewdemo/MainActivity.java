package com.example.shahi.surfaceviewdemo;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
public class MainActivity extends AppCompatActivity {
    //Code from this program has been used from Beginning Android Games
    //Review SurfaceView, Canvas, continue
    GameSurface gameSurface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        gameSurface = new GameSurface(this);
        setContentView(gameSurface);
    }
    @Override
    protected void onPause(){
        super.onPause();
        gameSurface.pause();
    }
    @Override
    protected void onResume(){
        super.onResume();
        gameSurface.resume();
    }
    //----------------------------GameSurface Below This Line--------------------------
    public class GameSurface extends SurfaceView implements Runnable,SensorEventListener{
        Thread gameThread;
        SurfaceHolder holder;
        volatile boolean running = false;
        Bitmap ball;
        Bitmap cars;
        Bitmap cloud;
        Bitmap background;
        Bitmap missle;
        Bitmap boom;
        int misslex=0;
        int missley=0;
        boolean isMissle=false;
        int ballX=0;
        int carsX=-150;
        int cloudtemp=0;
        int cloudX=-1400;
        int cloudspeed=8;
        int x=200;
        int score=-1;
        boolean master=true;
        int hittimetemp=0;
        boolean hitfire=false;
        int hitlocationX=0;
        int hitlocationY=0;
        String sensorOutput="";
        int boomtime=0;
        boolean boomtimetemp=false;
        Paint paintProperty;
        int temp=0;
        int time=60;
        boolean canMove=true;
        int timetemp=0;
        int carspeedtemp=0;
        int acceleration=0;
        MediaPlayer mediaPlayer;
        MediaPlayer mediaPlayer2;
        MediaPlayer mediaPlayer3;
        MediaPlayer mediaPlayer4;
        int carspeed=0;
        int pewtemp=0;
        int screenWidth;
        int screenHeight;
        public GameSurface(Context context) {
            super(context);
            holder=getHolder();
            mediaPlayer=MediaPlayer.create(MainActivity.this,R.raw.backmusic);
            mediaPlayer2=MediaPlayer.create(MainActivity.this,R.raw.explosion);
            mediaPlayer3=MediaPlayer.create(MainActivity.this,R.raw.misslehit);
            mediaPlayer4=MediaPlayer.create(MainActivity.this,R.raw.shoot);
            ball=BitmapFactory.decodeResource(getResources(),R.drawable.ball);
            cars=BitmapFactory.decodeResource(getResources(),R.drawable.cars);
            missle=BitmapFactory.decodeResource(getResources(),R.drawable.missle);
            cloud=BitmapFactory.decodeResource(getResources(),R.drawable.cloud);
            boom=BitmapFactory.decodeResource(getResources(),R.drawable.boom);
            background=BitmapFactory.decodeResource(getResources(),R.drawable.background);
            Display screenDisplay = getWindowManager().getDefaultDisplay();
            Point sizeOfScreen = new Point();
            screenDisplay.getSize(sizeOfScreen);
            screenWidth=sizeOfScreen.x;
            screenHeight=sizeOfScreen.y;
            SensorManager sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
            Sensor accelerometerSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
            sensorManager.registerListener(this,accelerometerSensor,sensorManager.SENSOR_DELAY_NORMAL);
            paintProperty= new Paint();
            paintProperty.setTextSize(100);
            mediaPlayer.start();
        }
        @Override
        public void run() {
            while (running == true){
                if (holder.getSurface().isValid() == false)
                    continue;
                final Canvas canvas=holder.lockCanvas();
                canvas.drawBitmap( background, 0,0,null);
                canvas.drawText(sensorOutput,x,200,paintProperty);
                final Paint paintText = new Paint();
                paintText.setColor(Color.YELLOW);
                paintText.setStyle(Paint.Style.FILL);
                paintText.setAntiAlias(true);
                paintText.setTextSize(66);
                if(master&&time>=0){
                    if((carsX>screenHeight||temp>5000||temp==0)&&boomtimetemp==false){
                        carsX=-150;
                        temp=(int)(Math.random()*(screenWidth-80)+20);
                        score++;
                    }
                    if(cloudX>screenHeight||cloudtemp==0){
                        cloudX=-1400;
                        cloudtemp=(int)(Math.random()*(screenWidth-200))-200;
                        cloudspeed=(int)(Math.random()*10)+1;
                    }
                    canvas.drawBitmap( cloud, cloudtemp,cloudX,null);
                    if(boomtimetemp==false)
                        canvas.drawBitmap( ball,(screenWidth/2)-ball.getWidth()/2+ballX,(screenHeight/2) - ball.getHeight()/8,null);
                    if(boomtimetemp){
                        canvas.drawBitmap( boom,(screenWidth/2)-ball.getWidth()/2+ballX,(screenHeight/2) - ball.getHeight()/8,null);
                        boomtime++;
                        if(boomtime==180){
                            boomtimetemp=false;
                            boomtime=0;
                            canMove=true;
                        }
                    }
                    if(isMissle){
                        if(missley==0){
                            missley=(screenHeight/2) - ball.getHeight()/8;
                        }
                        if(misslex==0){
                            misslex=(screenWidth/2)-ball.getWidth()/2+ballX;
                        }
                        missley-=acceleration;
                        acceleration++;
             //           Log.d("Missle","X: "+misslex+"   Y: "+missley+"   temp: "+temp+"   BALOON Y: "+carsX);
                        canvas.drawBitmap(missle,misslex,missley-90,null);
                        if(missley<=0){
                            isMissle=false;
                            misslex=0;
                            missley=0;
                            acceleration=0;
                        }
                        if(misslex<=temp+100 && misslex>=temp-100 && missley<=carsX+100 && missley>=carsX-100){
                            hitlocationX=temp;
                            hitlocationY=carsX;
                            isMissle=false;
                            misslex=0;
                            missley=0;
                            acceleration=0;
                            mediaPlayer4.start();
                            score+=5;
                            temp=(int)(Math.random()*(screenWidth-80)+20);
                            carsX=-150;
                            hitfire=true;
                        }
                    }
                    if(hitfire){
                        canvas.drawBitmap( boom,hitlocationX,hitlocationY,null);
                        hittimetemp++;
                        if(hittimetemp==30){
                            hittimetemp=0;
                            hitfire=false;
                            hitlocationX=0;
                            hitlocationY=0;
                        }
                    }
                    canvas.drawBitmap( cars, temp,carsX,null);
              //      Log.d("ASDF","Cars Y: "+carsX+"  Cars X: "+(temp)+"   Player X: "+(((screenWidth/2) - ball.getWidth()/2 )+ballX)+"   Player Y: "+((screenHeight/2) - ball.getHeight()/8));
                    canvas.drawText("Points: "+String.valueOf(score), screenWidth/2-120, 100, paintText);
                    canvas.drawText("Time: "+String.valueOf(time), screenWidth/2-120, 200, paintText);
                    timetemp++;
                    if(timetemp%60==0){
                       time--;
                    }
                    holder.unlockCanvasAndPost(canvas);
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                    if(1+Math.round(score*1.25)<15){
                        carsX+=Math.abs(carspeed+3+Math.round(score*1.25));
                        carsX+=1;
                    }
                    else carsX+=Math.abs(carspeed)+15;
                   if(((temp<=(screenWidth/2)-ball.getWidth()/2+ballX+100)  &&  (temp>=(screenWidth/2)-ball.getWidth()/2+ballX))  &&  ((carsX<=((screenHeight/2)-ball.getHeight()/8)+30)  &&  carsX>=((screenHeight/2)-ball.getHeight()/8)-100)){
                        boomtimetemp=true;
                        score--;
                        carsX=-150;
                        temp=-10000;
                        mediaPlayer2.start();
                        canMove=false;
                    }
                    cloudX+=cloudspeed;
                }
                else {
                    paintText.setColor(Color.GREEN);
                    paintText.setStyle(Paint.Style.FILL);
                    paintText.setAntiAlias(true);
                    paintText.setTextSize(130);
                    canvas.drawText("Points: "+String.valueOf(score), screenWidth/4-120, 200, paintText);
                    canvas.drawText("GAME OVER", screenWidth/4-120, 600, paintText);
                    holder.unlockCanvasAndPost(canvas);
                }
            }
        }
        public void resume(){
            running=true;
            gameThread=new Thread(this);
            gameThread.start();
        }
        public boolean onTouchEvent(MotionEvent event) {
            //is clicked twice for release and press (idk how to stop this [if statements are useless])
            if(event.getX()>=0&&event.getX()<=screenWidth/2){   //TOUCH RIGHT SIDE OF SCREEN
                if(carspeed==0&&carspeedtemp==0){
                    carspeedtemp++;
                }
                else if(carspeed==0&&carspeedtemp==1){
                    carspeed=5;
                    carspeedtemp=0;
                }
                else if(carspeed==5&&carspeedtemp==0){
                    carspeedtemp+=2;
                }
                else if(carspeed==5&&carspeedtemp==2){
                    carspeed=0;
                    carspeedtemp=0;
                }
            }
            if(event.getX()>screenWidth/2&&event.getX()<=screenWidth){           //TOUCH LEFT SIDE OF SCREEN
                if(pewtemp==0){
                    pewtemp++;
                }
                if(pewtemp==1){
                    pewtemp--;
                    mediaPlayer3.start();
                    isMissle=true;
                }
            }
                return true;
        }
        public void pause() {
            running = false;
            while (true) {
                try {
                    gameThread.join();
                } catch (InterruptedException e) {
                }
            }
        }
        @Override
        public void onSensorChanged(SensorEvent event) {
            if(canMove){
                if(ballX>-285){
                    ballX+=-2*event.values[0];
                }
                else if(ballX<0){
                    ballX=-285;
                }
                if(ballX<285){
                    ballX+=-2*event.values[0];
                }
                else  if(ballX>0){
                    ballX=285;
                }
            }
            Log.d("TAG",ballX+"");
        }
        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    }//GameSurface
}//Activity
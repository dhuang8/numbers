package com.example.app8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Bitmap.Config;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.util.Log;

public class LoadingScreen extends Screen{
	AndroidPicture loading;

	public LoadingScreen(GLGraphics game) {
		super(game);
		/*Paint paint = new Paint();
		paint.setColor(Color.BLACK); 
    	Bitmap b= Bitmap.createBitmap(400, 100, Config.ARGB_8888);
    	Canvas c = new Canvas (b);
    	//paint.setStyle(Style.STROKE);
    	//paint.setStrokeWidth(10);
        //c.drawRect(0, 0, 99, 499, paint); 
    	paint.setColor(Color.WHITE);
    	paint.setTextSize(50);
    	paint.setTextAlign(Align.CENTER);
    	paint.setStrokeWidth(5);
    	paint.setStyle(Style.FILL);
        c.drawText("Loading...",200,50,paint);
        loading = new AndroidPicture(b);*/
	}

	@Override
	public void update(float deltaTime) {
        //loading.draw((int)Assets.targetwidth/2-800, (int)Assets.targetheight/2-200,(int)Assets.targetwidth/2+800, (int)Assets.targetheight/2+200);
	}

	@Override
	public void present(float deltaTime) {
		if (Assets.reload) 	load();
		/*Paint paint = new Paint();
		paint.setColor(Color.BLACK); 
    	Bitmap b= Bitmap.createBitmap(800, 60, Config.ARGB_8888);
    	Canvas c = new Canvas (b);
    	//paint.setStyle(Style.STROKE);
    	//paint.setStrokeWidth(10);
        //c.drawRect(0, 0, 99, 499, paint);
    	paint.setColor(Color.WHITE);
    	paint.setTextSize(50);
    	paint.setTextAlign(Align.CENTER);
    	paint.setStrokeWidth(5);
    	paint.setStyle(Style.FILL);
        c.drawText("Version 0.01a",400,60,paint);
        Assets.version = new AndroidPicture(b);*/
        
		game.setScreen(new MainScreen(game));
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	} 

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
	
	public static void load(){
		AssetManager assets = Assets.assets;
		try {
			/*if (Assets.music==null)	Assets.music = Assets.audio.newMusic("music.wav");
			Assets.music.setLooping(true);
	        if (Assets.music.isPlaying()){
				//something
			}
			else {
				Assets.music.play();
			}*/
	        Assets.bgp=new AndroidPicture(BitmapFactory.decodeStream(assets.open("bgp.png")));
	        //Assets.bgp=new AndroidPicture(BitmapFactory.decodeStream(assets.open("vfbgp.png")));
			Assets.sheet=new SpriteSheet(BitmapFactory.decodeStream(assets.open("sheet.png")),24);
			for (int n=0;n<10;n++){
				Assets.sheet.add(n*14, 24, 13+n*14, 37); //0-9 small num
			}
			for (int n=0;n<10;n++){
				Assets.sheet.add(n*19, 38, n*19+18, 62); //10-19 big num
			}
			for (int n=0;n<2;n++){
				for (int m=0;m<2;m++){
					Assets.sheet.add(m*19, 63+n*19, 18+m*19, 81+n*19); //20-23 signs
				}
			}
			InputStreamReader inputStreamReader = new InputStreamReader(assets.open("num.txt"));
			BufferedReader reader = new BufferedReader(inputStreamReader);
			String line;
			Assets.numcomb = new int[430];
			int count=0;
	        while ((line = reader.readLine()) != null) { 
	            Assets.numcomb[count]=Integer.parseInt(line);
	            count++;
	        } 
	        inputStreamReader.close();
	        reader.close();
			Assets.reload=false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
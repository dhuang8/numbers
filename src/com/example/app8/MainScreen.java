package com.example.app8;

import java.util.List;

import android.util.Log;

import com.example.app8.Input.TouchEvent;

public class MainScreen extends Screen{
	
	int[] numbers = new int[4];
	static int sign=0;
	Button[] button = new Button[10];
	static int leftslot=-1;
	static int rightslot=-1;
	static int totalslot=-1;
	boolean error=false;
	int score=0;
	static boolean calc=true;
	float timer=0;
	
	public MainScreen(GLGraphics game) {
		super(game); 
		GameNumber cur;
		for (int n=0;n<4;n++){
			cur=new GameNumber(52*n, 317, 22+52*n+26, 317+52);
			button[n]= cur;
		}
		SignButton curr;
		for (int n=0;n<4;n++){
			curr=new SignButton(52*n, 317-53, 52+52*n+26, 316);
			curr.set(n);
			button[n+4]= curr;
		}
		NewGame gamebutton=new NewGame(158,204,205,251);
		gamebutton.set(this);
		UndoButton undobutton=new UndoButton(158-50,204,205-50,251);
		undobutton.set(this);
		button[8]=gamebutton;
		button[9]=undobutton;
		newGame();
	}
 
	@Override
	public void update(float deltaTime) {
		timer+=deltaTime;
		List<TouchEvent> touchEvents = Assets.input.getTouchEvents();
		int len = touchEvents.size(); 
		for(int i = 0; i < len; i++) { 
			TouchEvent event = touchEvents.get(i); 
			if(event.type == TouchEvent.TOUCH_DOWN) {
				Log.d("touch down",event.x+","+event.y);
				for (int n=0;n<button.length;n++){
					if (button[n]!=null) button[n].check(event);
				}
			}
		}
		if (calc==false){
			int empty = 0;
			for (int n=0;n<4;n++){
				if (button[n].get()==-1){
					empty=n;
					break;
				}
			}
			if (sign==0){
				totalslot=leftslot+rightslot;
				button[empty].set(totalslot);
			}
			if (sign==1){
				if (rightslot>leftslot) error=true;
				else {
					totalslot=leftslot-rightslot;
					button[empty].set(totalslot);
				}
			}
			if (sign==2){
				totalslot=leftslot*rightslot;
				button[empty].set(totalslot);
			}
			if (sign==3){
				if (rightslot==0) error=true;
				else if (leftslot%rightslot!=0) error=true;
				else {
					totalslot=leftslot/rightslot;
					button[empty].set(totalslot);
				}
			}
			if (error) {
				button[empty].set(leftslot);
				for (int n=0;n<4;n++){
					if (button[n].get()==-1){
						empty=n;
						break;
					}
				}
				button[empty].set(rightslot);
				error=false;
			}
			calc=true;
		}
		if (button[1].get()==-1 &&button[2].get()==-1 &&button[3].get()==-1 && totalslot!=-1){
			if (button[0].get()==10) {
				score++;
				newGame();
			}
			else{
				for (int n=0;n<4;n++){
					button[n].set(numbers[n]);
				}
			}
		}
	}
	
	public void undo(){
		if (rightslot==-1) leftslot=-1;
		for (int n=0;n<4;n++){
			button[n].set(numbers[n]);
		}
	}

	@Override
	public void present(float deltaTime) {
		Assets.bgp.setBlend(false);
		Assets.bgp.draw(0, 0, Assets.targetwidth , Assets.targetheight);
		//Assets.sheet.draw(46+sign*35, 282, 63+sign*35, 299, sign+20); 
		Assets.sheet.draw(59, 170, 76, 187, sign+20); 
		for (int n=0; n<button.length;n++){
			if (button[n]!=null) button[n].draw();
		}
		if (leftslot!=-1) Numbers.draw(""+leftslot, 24, 167, 1);
		if (rightslot!=-1) Numbers.draw(""+rightslot, 112, 167, 1);
		if (totalslot!=-1) Numbers.draw(""+totalslot, 183, 167, 1);
		Numbers.draw(""+score, 198, 100, 0);
		Numbers.draw(""+(int)timer, 37, 100, 0);
	}
	
	public void newGame(){
		int current=Assets.numcomb[(int)(Math.random()*Assets.numcomb.length)];
		Log.d("newGame",""+current);
		int[] nums = new int[4];
		nums[0]=current/1000;
		current-=nums[0]*1000;
		nums[1]=current/100;
		current-=nums[1]*100;
		nums[2]=current/10;
		current-=nums[2]*10;
		nums[3]=current;
		current-=nums[3];
		for (int n=4;n>1;n--){
			int rand=(int)(Math.random()*n);
			int temp=nums[4-n];
			nums[4-n]=nums[rand+4-n];
			nums[rand+4-n]=temp;
		}
		numbers=nums;
		for (int n=0;n<4;n++){
			button[n].set(numbers[n]);
		}/*
		leftslot=-1;
		rightslot=-1;
		totalslot=-1;*/
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
	
}
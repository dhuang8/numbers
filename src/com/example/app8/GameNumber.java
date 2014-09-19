package com.example.app8;

public class GameNumber extends Button{
	int num;
	public GameNumber(int a, int b, int c, int d) {
		super(a, b, c, d);
	}
	
	public void set(int numb){
		num=numb;
	}
	
	public void act(){
		if (num!=-1){
			if (MainScreen.rightslot!=-1 || MainScreen.leftslot==-1) {
				MainScreen.leftslot=num;
				MainScreen.rightslot=-1;
				MainScreen.totalslot=-1;
			}
			else {
				MainScreen.rightslot=num;
				MainScreen.calc=false;
			}
			num=-1;
		}
	}
	
	public int get(){
		return num;
	}
	
	public void draw(){
		if (num!=-1) Numbers.draw(""+num, left+26, 331, 1);
	}
}
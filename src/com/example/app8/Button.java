package com.example.app8;

import com.example.app8.Input.TouchEvent;

public class Button {
	int left;
	int top;
	int right;
	int bot;
	Object a;
	Object b;
	
	public Button(int a, int b, int c, int d){
		left=a;
		top=b;
		right=c;
		bot=d;
	}
	
	public boolean check(TouchEvent event){
		if(event.x > left && event.x < right &&  event.y > top && event.y < bot){
			act();
			return true; 
		}
			
		else 
			return false; 
	}
	
	public void act(){}
	
	public int get(){
		return 0;
	}
	
	public void set(int a){}
	
	public void set(MainScreen a){}
	
	public void draw(){}
}
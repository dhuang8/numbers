package com.example.app8;

public class NewGame extends Button{
	
	MainScreen screen;

	public NewGame(int a, int b, int c, int d) {
		super(a, b, c, d);
		// TODO Auto-generated constructor stub
	}
	
	public void set(MainScreen screen){
		this.screen=screen;
	}
	
	public void act(){
		screen.newGame();
	}
}

package com.example.app8;

public class UndoButton extends Button{
	
	MainScreen screen;
	
	public UndoButton(int a, int b, int c, int d) {
		super(a, b, c, d);
	}
	
	public void set(MainScreen screen){
		this.screen=screen;
	}
	public void act(){
		screen.undo();
	}
}

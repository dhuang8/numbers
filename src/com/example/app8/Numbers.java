package com.example.app8;

public class Numbers {
	public static void draw(String s, int x, int y, int type){
		if (type==0){
			x-=s.length()*13;
			for (int n=0;n<s.length();n++){
				Assets.sheet.setBlend(true);
				Assets.sheet.draw(x,y,x+13,y+13,s.charAt(n)-48);	
				x+=13;
			}
		}
		else if (type==1){
			for (int n=0;n<s.length();n++){
				Assets.sheet.setBlend(true);
				Assets.sheet.draw(x-s.length()*9-1,y,x+17-s.length()*9,y+24,s.charAt(n)+10-48);	
				x+=18;
			}
		}
	}
}

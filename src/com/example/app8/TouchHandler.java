package com.example.app8;

import java.util.List;

import android.view.View.OnTouchListener;

import com.example.app8.Input.TouchEvent;

public interface TouchHandler extends OnTouchListener{ 
    public boolean isTouchDown(int pointer); 
     
    public int getTouchX(int pointer); 
     
    public int getTouchY(int pointer); 
     
    public List<TouchEvent> getTouchEvents(); 

    public void setScale(float scaleX, float scaleY);
}

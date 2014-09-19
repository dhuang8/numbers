package com.example.app8;

import java.io.IOException;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;

public class AndroidMusic {
	MediaPlayer mediaPlayer; 
	boolean isPrepared = false; 
	public AndroidMusic(AssetFileDescriptor assetDescriptor) { 
		mediaPlayer = new MediaPlayer(); 
		try { 
			mediaPlayer.setDataSource(assetDescriptor.getFileDescriptor(), 
					assetDescriptor.getStartOffset(), 
					assetDescriptor.getLength()); 
			mediaPlayer.prepare(); 
			isPrepared = true; 
		} catch (Exception e) { 
			throw new RuntimeException("Couldn't load music"); 
		} 
	}
	public void dispose() { 
		if (mediaPlayer.isPlaying()) 
			mediaPlayer.stop(); 
		mediaPlayer.release(); 
	}
	public boolean isLooping() { 
		return mediaPlayer.isLooping(); 
	} 
	public boolean isPlaying() { 
		return mediaPlayer.isPlaying(); 
	} 
	public boolean isStopped() { 
		return !isPrepared; 
	} 
	    
	public void pause() { 
		if (mediaPlayer.isPlaying()) 
			mediaPlayer.pause(); 
	} 
	public void play() { 
		if (mediaPlayer.isPlaying()) 
			return; 
		try { 
			synchronized (this) { 
				if (!isPrepared) 
					mediaPlayer.prepare(); 
				mediaPlayer.start(); 
			} 
		} catch (IllegalStateException e) { 
			e.printStackTrace(); 
		} catch (IOException e) { 
			e.printStackTrace(); 
		} 
	}
	public void setLooping(boolean isLooping) { 
		mediaPlayer.setLooping(isLooping); 
		
		/*mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
		    public void onCompletion(MediaPlayer mp) {

		    	mp.seekTo(0);
		    	mp.start(); // finish current activity
		    }
		});*/
	} 
	public void setVolume(float volume) { 
		mediaPlayer.setVolume(volume, volume); 
	}
	public void stop() { 
		mediaPlayer.stop(); 
		synchronized (this) { 
			isPrepared = false; 
		} 
	}  
	public void onCompletion(MediaPlayer player) { 
		/*synchronized (this) { 
			isPrepared = false; 
		} */
	} 
}

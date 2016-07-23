package com.leemo.util;

import java.util.HashMap;

import com.leemo.android_dailyrecord.R;

import android.app.Activity;
import android.content.Context;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.inputmethodservice.KeyboardView.OnKeyboardActionListener;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.EditText;




public class KeyBoardUtil {
	private Context mContext;
	private Activity mActivity;
	private KeyboardView mkv;
	private EditText et;
	
	public KeyBoardUtil(Context mContext, Activity mActivity,EditText et) {
		super();
		this.mContext = mContext;
		this.mActivity = mActivity;
		this.et=et;
		mkv=(KeyboardView) mActivity.findViewById(R.id.keyboard_view);
		mkv.setVisibility(View.VISIBLE);
		Keyboard kb=new Keyboard(mContext, R.layout.keyboard);
		mkv.setKeyboard(kb);
		mkv.setEnabled(true);
		mkv.setPreviewEnabled(true);
		mkv.setOnKeyboardActionListener(new KeyboardActionListener());
	}
	private class KeyboardActionListener implements OnKeyboardActionListener{
		

		@Override
		public void onPress(int primaryCode) {
			// TODO Auto-generated method stub
			Log.i("System.out.alex", "keyBoard onPress method");
		}

		@Override
		public void onRelease(int primaryCode) {
			// TODO Auto-generated method stub
			Log.i("System.out.alex", "keyBoard OnRelease method");
		}

		@Override
		public void onKey(int primaryCode, int[] keyCodes) {
			// TODO Auto-generated method stub
			Editable ed=et.getText();
			int start =et.getSelectionStart();
			if(primaryCode>=48&&primaryCode<=57) ed.insert(start, Character.toString((char)primaryCode)); //数字直接输入
			//回退和完成
			if(primaryCode==-3) hideKeyboard();
			if(primaryCode==-5) {
				if(et.getSelectionEnd()>=1)ed.delete(et.getSelectionEnd()-1,et.getSelectionEnd());
			}
			Log.i("System.out.alex", "KeyBoard onKey content="+et.getText().toString());	
		}

		@Override
		public void onText(CharSequence text) {
			// TODO Auto-generated method stub
			Log.i("System.out.alex", "keyBoard onText method");
		}

		@Override
		public void swipeLeft() {
			// TODO Auto-generated method stub
			Log.i("System.out.alex", "keyBoard swipLeft method");
		}

		@Override
		public void swipeRight() {
			// TODO Auto-generated method stub
			Log.i("System.out.alex", "keyBoard swipRight method");
		}

		@Override
		public void swipeDown() {
			// TODO Auto-generated method stub
			Log.i("System.out.alex", "keyBoard swipDown method");
		}

		@Override
		public void swipeUp() {
			// TODO Auto-generated method stub
			Log.i("System.out.alex", "keyBoard swipeUp method");
		}
		 
	}
	public void showKeyboard() {  
        int visibility = mkv.getVisibility();  
        if (visibility == View.GONE || visibility == View.INVISIBLE) {  
            mkv.setVisibility(View.VISIBLE);  
        }  
    }  
	 public void hideKeyboard() {  
	        int visibility = mkv.getVisibility();  
	        if (visibility == View.VISIBLE) {  
	            mkv.setVisibility(View.GONE);  
	        }  
	    }  
}

package com.leemo.android_dailyrecord;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends Activity {
	private TextView tvresultinfo;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.resultactivity);
		tvresultinfo=(TextView) findViewById(R.id.tvresultinfo);
		Intent intent=getIntent();
		tvresultinfo.setText("");
		String str=intent.getExtras().get("data").toString();
		String[] strarr=str.split("&");
		for (String string : strarr) {
			tvresultinfo.append(string+"\n");
		}
	}
	
}

package com.zigzagdigital.zigzag;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class SplashActivity extends Activity implements OnClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		
		TextView boton = (TextView) findViewById(R.id.splash_boton);
		boton.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()){
		
		case R.id.splash_boton:
			Context context = this;
			Intent intent = new Intent(context, ArticleList.class);
			startActivity(intent);
			break;
		}
	}
}

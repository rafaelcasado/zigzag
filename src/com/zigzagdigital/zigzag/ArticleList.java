package com.zigzagdigital.zigzag;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ArticleList extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_article_list);
		Button botonAbout = (Button) findViewById(R.id.about_boton);
		botonAbout.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		switch (v.getId()) {
		case R.id.about_boton:
			Context context = this;
			Intent intent = new Intent (context, AboutActivity.class);
			startActivity(intent);
			break;
		}
	}
}

package com.cdi.activities;

import com.example.cdicomplete25aug.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class Enviornment_MainForm extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.form8main);
		
		LinearLayout linearMain=(LinearLayout)findViewById(R.id.linearMain);
		linearMain.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i=new Intent(getApplicationContext(),Enviornment.class);
				startActivity(i);
				
			}
		});
	}
}

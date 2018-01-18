package com.cdi.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.cdicomplete25aug.R;

public class Peace_of_Mind_MainForm extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.form1main);
		LinearLayout LinearMain=(LinearLayout)findViewById(R.id.LinearMain);
		
		LinearMain.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i=new Intent(getApplicationContext(),Peace_of_Mind.class);
				startActivity(i);
				
			}
		});
	}
	

}

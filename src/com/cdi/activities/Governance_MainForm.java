package com.cdi.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.cdicomplete25aug.R;

public class Governance_MainForm extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.form6main);
		
		LinearLayout linearMain=(LinearLayout)findViewById(R.id.linearMain);
		linearMain.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i=new Intent(getApplicationContext(),Governance.class);
				startActivity(i);
				
			}
		});
	}
}

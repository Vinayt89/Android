package com.cdi.activities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.SeekBar.OnSeekBarChangeListener;

import com.example.cdicomplete25aug.R;

public class Health extends Activity {
	
	Button btnNext,btnBack;
	SeekBar sbNoofHealthyDays,sbLongTermDisability,sbActivityLimitations,sbEasyAccesstoHealthCare,
	sbLifeExpectancyatBirth,sbUnderFiveMortality,sbPreventionOfDiseases;
	TextView tvNoofHealthyDays,tvLongTermDisability,tvActivityLimitations,tvEasyAccesstoHealthCare,
	tvLifeExpectancyatBirth,tvUnderFiveMortality,tvPreventionOfDiseases;
	int progress = 0;
	
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.form2);
	
		references();
		seekBarImplimentation();
			
		btnBack=(Button)findViewById(R.id.btnBack);
		btnNext=(Button)findViewById(R.id.btnNext);
		
		btnBack.setOnClickListener(new View.OnClickListener() {
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				Intent i=new Intent(getApplicationContext(),Peace_of_Mind.class);
				startActivity(i);
			}
		});
		
		btnNext.setOnClickListener(new View.OnClickListener() {
			public void onClick(View arg0) {
				validation();
				new MyAsyncTask().execute(tvNoofHealthyDays.getText().toString(),tvLongTermDisability.getText().toString(),tvActivityLimitations.getText().toString(),
										  tvEasyAccesstoHealthCare.getText().toString(),tvLifeExpectancyatBirth.getText().toString(),
										  tvUnderFiveMortality.getText().toString(),tvPreventionOfDiseases.getText().toString());
			}
		});
	}
	public void references(){
		sbNoofHealthyDays=(SeekBar)findViewById(R.id.sbNoofHealthyDays);
		sbLongTermDisability=(SeekBar)findViewById(R.id.sbLongTermDisability);
		sbActivityLimitations=(SeekBar)findViewById(R.id.sbActivityLimitations);
		sbEasyAccesstoHealthCare=(SeekBar)findViewById(R.id.sbEasyAccesstoHealthCare);
		sbLifeExpectancyatBirth=(SeekBar)findViewById(R.id.sbLifeExpectancyatBirth);
		sbUnderFiveMortality=(SeekBar)findViewById(R.id.sbUnderFiveMortality);
		sbPreventionOfDiseases=(SeekBar)findViewById(R.id.sbPreventionOfDiseases);
		
		tvNoofHealthyDays=(TextView)findViewById(R.id.tvNoofHealthyDays);
		tvLongTermDisability=(TextView)findViewById(R.id.tvLongTermDisability);
		tvActivityLimitations=(TextView)findViewById(R.id.tvActivityLimitations);
		tvEasyAccesstoHealthCare=(TextView)findViewById(R.id.tvEasyAccesstoHealthCare);
		tvLifeExpectancyatBirth=(TextView)findViewById(R.id.tvLifeExpectancyatBirth);
		tvUnderFiveMortality=(TextView)findViewById(R.id.tvUnderFiveMortality);
		tvPreventionOfDiseases=(TextView)findViewById(R.id.tvPreventionOfDiseases);
	}
	public void seekBarImplimentation(){
		
		sbNoofHealthyDays.setOnSeekBarChangeListener(new OnSeekBarChangeListener() 
		{
			public void onStopTrackingTouch(SeekBar seekBar){
				tvNoofHealthyDays.setText(progress + "/" + seekBar.getMax());
			}
			public void onStartTrackingTouch(SeekBar arg0){}
			public void onProgressChanged(SeekBar seekBar,int progresValue, boolean fromUser){
				 progress = progresValue;
			}
		});
		sbLongTermDisability.setOnSeekBarChangeListener(new OnSeekBarChangeListener() 
		{
			public void onStopTrackingTouch(SeekBar seekBar){
				tvLongTermDisability.setText(progress + "/" + seekBar.getMax());
			}
			public void onStartTrackingTouch(SeekBar arg0){}
			public void onProgressChanged(SeekBar seekBar,int progresValue, boolean fromUser){
				 progress = progresValue;
			}
		});
		sbActivityLimitations.setOnSeekBarChangeListener(new OnSeekBarChangeListener() 
		{
			public void onStopTrackingTouch(SeekBar seekBar){
				tvActivityLimitations.setText(progress + "/" + seekBar.getMax());
			}
			public void onStartTrackingTouch(SeekBar arg0){}
			public void onProgressChanged(SeekBar seekBar,int progresValue, boolean fromUser){
				 progress = progresValue;
			}
		});
		sbEasyAccesstoHealthCare.setOnSeekBarChangeListener(new OnSeekBarChangeListener() 
		{
			public void onStopTrackingTouch(SeekBar seekBar){
				tvEasyAccesstoHealthCare.setText(progress + "/" + seekBar.getMax());
			}
			public void onStartTrackingTouch(SeekBar arg0){}
			public void onProgressChanged(SeekBar seekBar,int progresValue, boolean fromUser){
				 progress = progresValue;
			}
		});
		sbLifeExpectancyatBirth.setOnSeekBarChangeListener(new OnSeekBarChangeListener() 
		{
			public void onStopTrackingTouch(SeekBar seekBar){
				tvLifeExpectancyatBirth.setText(progress + "/" + seekBar.getMax());
			}
			public void onStartTrackingTouch(SeekBar arg0){}
			public void onProgressChanged(SeekBar seekBar,int progresValue, boolean fromUser){
				 progress = progresValue;
			}
		});
		sbUnderFiveMortality.setOnSeekBarChangeListener(new OnSeekBarChangeListener() 
		{
			public void onStopTrackingTouch(SeekBar seekBar){
				tvUnderFiveMortality.setText(progress + "/" + seekBar.getMax());
			}
			public void onStartTrackingTouch(SeekBar arg0){}
			public void onProgressChanged(SeekBar seekBar,int progresValue, boolean fromUser){
				 progress = progresValue;
			}
		});
		sbPreventionOfDiseases.setOnSeekBarChangeListener(new OnSeekBarChangeListener() 
		{
			public void onStopTrackingTouch(SeekBar seekBar){
				tvPreventionOfDiseases.setText(progress + "/" + seekBar.getMax());
			}
			public void onStartTrackingTouch(SeekBar arg0){}
			public void onProgressChanged(SeekBar seekBar,int progresValue, boolean fromUser){
				 progress = progresValue;
			}
		});
		
		
	}
	public void validation(){
		if(tvNoofHealthyDays.getText()==""){
		Toast.makeText(getApplicationContext(),"Please Give Rating to Number of healthy days in past year!!",Toast.LENGTH_LONG).show();
	    }
		else if(tvLongTermDisability.getText()==""){
		Toast.makeText(getApplicationContext(),"Please Give Rating to Long term disability!!",Toast.LENGTH_LONG).show();
	    }
		else if(tvActivityLimitations.getText()==""){
	    Toast.makeText(getApplicationContext(),"Please Give Rating to Activity limitations!!",Toast.LENGTH_LONG).show();
		}
		else if(tvEasyAccesstoHealthCare.getText()==""){
	    Toast.makeText(getApplicationContext(),"Please Give Rating to Easy access to healthcare services in city!!",Toast.LENGTH_LONG).show();
		}
		else if(tvLifeExpectancyatBirth.getText()==""){
		Toast.makeText(getApplicationContext(),"Please Give Rating to Life expectancy at birth!!",Toast.LENGTH_LONG).show();
		}
		else if(tvUnderFiveMortality.getText()==""){
		Toast.makeText(getApplicationContext(),"Please Give Rating to Under-five mortality!!",Toast.LENGTH_LONG).show();
		}
		else if(tvPreventionOfDiseases.getText()==""){
		Toast.makeText(getApplicationContext(),"Please Give Rating to Prevention of diseases,Public awareness and treatment!!",Toast.LENGTH_LONG).show();
		}
		else{
			Intent i=new Intent(getApplicationContext(),Education_MainForm.class);
			startActivity(i);
			finish();
		}
	}
		private class MyAsyncTask extends AsyncTask<String, Integer, Double>{
			protected Double doInBackground(String... params) 
			{
				// TODO Auto-generated method stub
				postData(params[0],params[1],params[2],params[3],params[4],params[5],params[6]);
				return null;
			}
			protected void onPostExecute(Double result)
			{	
			}
	 
			public void postData(String NoofHealthyDays,String LongTermDisability,String ActivityLimitations,String EasyAccesstoHealthCare,String LifeExpectancyatBirth,
								 String UnderFiveMortality,String PreventionOfDiseases)
			{
				// Create a new HttpClient and Post Header
				HttpClient httpclient = new DefaultHttpClient();
				HttpPost httppost = new HttpPost("http://www.comdevindex.0fees.us/Health.php");
	 
				try {
					// Add your data
					List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
					nameValuePairs.add(new BasicNameValuePair("NoofHealthyDays",NoofHealthyDays));
					nameValuePairs.add(new BasicNameValuePair("LongTermDisability",LongTermDisability));
					nameValuePairs.add(new BasicNameValuePair("ActivityLimitations",ActivityLimitations));
					nameValuePairs.add(new BasicNameValuePair("EasyAccesstoHealthCare",EasyAccesstoHealthCare));
					nameValuePairs.add(new BasicNameValuePair("LifeExpectancyatBirth",LifeExpectancyatBirth));
					nameValuePairs.add(new BasicNameValuePair("UnderFiveMortality",UnderFiveMortality));
					nameValuePairs.add(new BasicNameValuePair("PreventionOfDiseases",PreventionOfDiseases));

					httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
	 
					// Execute HTTP Post Request
					HttpResponse response = httpclient.execute(httppost);
					}
					catch (ClientProtocolException e) {
					// TODO Auto-generated catch block
				} 
				catch (IOException e) {
					// TODO Auto-generated catch block
				}
			}
			
		}
	}


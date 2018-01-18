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

import com.example.cdicomplete25aug.R;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;

public class Community_Vitality extends Activity {
	
	SeekBar sbTimeandMoneyDonation,sbSenceofBeloningness,sbOverallCrimeRate,sbWomenSafety,sbRoadAccidents,
	sbConstantPoliceSurvillance,sbGenderInequality,sbIncomeInquality,sbInequalityDuetoCaste;
	int progress=0;
	TextView tvTimeandMoneyDonation,tvSenceofBeloningness,tvOverallCrimeRate,tvWomenSafety,tvRoadAccidents,
	tvConstantPoliceSurvillance,tvGenderInequality,tvIncomeInquality,tvInequalityDuetoCaste;
	
	
	Button btnNext,btnBack;
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.form7);
		
		references();
		seekBarImplementation();
		
		btnBack=(Button)findViewById(R.id.btnBack);
		btnNext=(Button)findViewById(R.id.btnNext);
		
		btnBack.setOnClickListener(new View.OnClickListener() {
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i=new Intent(getApplicationContext(),Governance.class);
				startActivity(i);
			}
		});
		
		btnNext.setOnClickListener(new View.OnClickListener() {
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				validation();
				new MyAsyncTask().execute(tvTimeandMoneyDonation.getText().toString(),tvSenceofBeloningness.getText().toString(),tvOverallCrimeRate.getText().toString(),tvWomenSafety.getText().toString(),tvRoadAccidents.getText().toString(),
										  tvConstantPoliceSurvillance.getText().toString(),tvGenderInequality.getText().toString(),tvIncomeInquality.getText().toString(),tvInequalityDuetoCaste.getText().toString());
			}
		});
	}
	public void references(){
		
		sbTimeandMoneyDonation=(SeekBar)findViewById(R.id.sbTimeandMoneyDonation);
		sbSenceofBeloningness=(SeekBar)findViewById(R.id.sbSenceofBeloningness);
		sbOverallCrimeRate=(SeekBar)findViewById(R.id.sbOverallCrimeRate);
		sbWomenSafety=(SeekBar)findViewById(R.id.sbWomenSafety);
		sbRoadAccidents=(SeekBar)findViewById(R.id.sbRoadAccidents);
		sbConstantPoliceSurvillance=(SeekBar)findViewById(R.id.sbConstantPoliceSurvillance);
		sbGenderInequality=(SeekBar)findViewById(R.id.sbGenderInequality);
		sbIncomeInquality=(SeekBar)findViewById(R.id.sbIncomeInquality);
		sbInequalityDuetoCaste=(SeekBar)findViewById(R.id.sbInequalityDuetoCaste);
		
		tvTimeandMoneyDonation=(TextView)findViewById(R.id.tvTimeandMoneyDonation);
		tvSenceofBeloningness=(TextView)findViewById(R.id.tvSenceofBeloningness);
		tvOverallCrimeRate=(TextView)findViewById(R.id.tvOverallCrimeRate);
		tvWomenSafety=(TextView)findViewById(R.id.tvWomenSafety);
		tvRoadAccidents=(TextView)findViewById(R.id.tvRoadAccidents);
		tvConstantPoliceSurvillance=(TextView)findViewById(R.id.tvConstantPoliceSurvillance);
		tvGenderInequality=(TextView)findViewById(R.id.tvGenderInequality);
		tvIncomeInquality=(TextView)findViewById(R.id.tvIncomeInquality);
		tvInequalityDuetoCaste=(TextView)findViewById(R.id.tvInequalityDuetoCaste);
		
		
	}
	public void seekBarImplementation(){
		sbTimeandMoneyDonation.setOnSeekBarChangeListener(new OnSeekBarChangeListener() 
		{
			public void onStopTrackingTouch(SeekBar seekBar){
				tvTimeandMoneyDonation.setText(progress + "/" + seekBar.getMax());
			}
			public void onStartTrackingTouch(SeekBar arg0){}
			public void onProgressChanged(SeekBar seekBar,int progresValue, boolean fromUser){
				 progress = progresValue;
			}
		});
		sbSenceofBeloningness.setOnSeekBarChangeListener(new OnSeekBarChangeListener() 
		{
			public void onStopTrackingTouch(SeekBar seekBar){
				tvSenceofBeloningness.setText(progress + "/" + seekBar.getMax());
			}
			public void onStartTrackingTouch(SeekBar arg0){}
			public void onProgressChanged(SeekBar seekBar,int progresValue, boolean fromUser){
				 progress = progresValue;
			}
		});
		sbOverallCrimeRate.setOnSeekBarChangeListener(new OnSeekBarChangeListener() 
		{
			public void onStopTrackingTouch(SeekBar seekBar){
				tvOverallCrimeRate.setText(progress + "/" + seekBar.getMax());
			}
			public void onStartTrackingTouch(SeekBar arg0){}
			public void onProgressChanged(SeekBar seekBar,int progresValue, boolean fromUser){
				 progress = progresValue;
			}
		});
		sbWomenSafety.setOnSeekBarChangeListener(new OnSeekBarChangeListener() 
		{
			public void onStopTrackingTouch(SeekBar seekBar){
				tvWomenSafety.setText(progress + "/" + seekBar.getMax());
			}
			public void onStartTrackingTouch(SeekBar arg0){}
			public void onProgressChanged(SeekBar seekBar,int progresValue, boolean fromUser){
				 progress = progresValue;
			}
		});
		sbRoadAccidents.setOnSeekBarChangeListener(new OnSeekBarChangeListener() 
		{
			public void onStopTrackingTouch(SeekBar seekBar){
				tvRoadAccidents.setText(progress + "/" + seekBar.getMax());
			}
			public void onStartTrackingTouch(SeekBar arg0){}
			public void onProgressChanged(SeekBar seekBar,int progresValue, boolean fromUser){
				 progress = progresValue;
			}
		});
		sbConstantPoliceSurvillance.setOnSeekBarChangeListener(new OnSeekBarChangeListener() 
		{
			public void onStopTrackingTouch(SeekBar seekBar){
				tvConstantPoliceSurvillance.setText(progress + "/" + seekBar.getMax());
			}
			public void onStartTrackingTouch(SeekBar arg0){}
			public void onProgressChanged(SeekBar seekBar,int progresValue, boolean fromUser){
				 progress = progresValue;
			}
		});
		sbGenderInequality.setOnSeekBarChangeListener(new OnSeekBarChangeListener() 
		{
			public void onStopTrackingTouch(SeekBar seekBar){
				tvGenderInequality.setText(progress + "/" + seekBar.getMax());
			}
			public void onStartTrackingTouch(SeekBar arg0){}
			public void onProgressChanged(SeekBar seekBar,int progresValue, boolean fromUser){
				 progress = progresValue;
			}
		});
		sbIncomeInquality.setOnSeekBarChangeListener(new OnSeekBarChangeListener() 
		{
			public void onStopTrackingTouch(SeekBar seekBar){
				tvIncomeInquality.setText(progress + "/" + seekBar.getMax());
			}
			public void onStartTrackingTouch(SeekBar arg0){}
			public void onProgressChanged(SeekBar seekBar,int progresValue, boolean fromUser){
				 progress = progresValue;
			}
		});
		sbInequalityDuetoCaste.setOnSeekBarChangeListener(new OnSeekBarChangeListener() 
		{
			public void onStopTrackingTouch(SeekBar seekBar){
				tvInequalityDuetoCaste.setText(progress + "/" + seekBar.getMax());
			}
			public void onStartTrackingTouch(SeekBar arg0){}
			public void onProgressChanged(SeekBar seekBar,int progresValue, boolean fromUser){
				 progress = progresValue;
			}
		});


	}
	public void validation(){
		if(tvTimeandMoneyDonation.getText()==""){
			Toast.makeText(getApplicationContext(), "Please Give Rating to Time and Money Donated in year by people!!",Toast.LENGTH_LONG).show();
		}
		else if(tvSenceofBeloningness.getText()==""){
			Toast.makeText(getApplicationContext(), "Please Give Rating to Sense of Beloningness and trust in the community!!",Toast.LENGTH_LONG).show();
		}
		else if(tvOverallCrimeRate.getText()==""){
			Toast.makeText(getApplicationContext(), "Please Give Rating to Overall Crime Rate!!",Toast.LENGTH_LONG).show();
		}
		else if(tvWomenSafety.getText()==""){
			Toast.makeText(getApplicationContext(), "Please Give Rating to Women Safety!!",Toast.LENGTH_LONG).show();
		}
		else if(tvRoadAccidents.getText()==""){
			Toast.makeText(getApplicationContext(), "Please Give Rating to Road Accidents!!",Toast.LENGTH_LONG).show();
		}
		else if(tvConstantPoliceSurvillance.getText()==""){
			Toast.makeText(getApplicationContext(), "Please Give Rating to Constant Police Survillance!!",Toast.LENGTH_LONG).show();
		}
		else if(tvGenderInequality.getText()==""){
			Toast.makeText(getApplicationContext(), "Please Give Rating to Gender Inequality!!",Toast.LENGTH_LONG).show();
		}
		else if(tvIncomeInquality.getText()==""){
			Toast.makeText(getApplicationContext(), "Please Give Rating to Income Inquality!!",Toast.LENGTH_LONG).show();
		}
		else if(tvInequalityDuetoCaste.getText()==""){
			Toast.makeText(getApplicationContext(), "Please Give Rating to Inequality Due to Caste/Religion!!",Toast.LENGTH_LONG).show();
		}
		else{
			Intent i=new Intent(getApplicationContext(),Enviornment_MainForm.class);
			startActivity(i);
			finish();
		}
	}
	private class MyAsyncTask extends AsyncTask<String, Integer, Double>{
		protected Double doInBackground(String... params) 
		{
			// TODO Auto-generated method stub
			postData(params[0],params[1],params[2],params[3],params[4],params[5],params[6],params[7],params[8]);
			return null;
		}
		protected void onPostExecute(Double result)
		{
		}
 
		public void postData(String TimeandMoneyDonation,String SenceofBeloningness,String OverallCrimeRate,String WomenSafety,String RoadAccidents,
							 String ConstantPoliceSurvillance,String GenderInequality,String IncomeInquality,String InequalityDuetoCaste)
		{
			// Create a new HttpClient and Post Header
			HttpClient httpclient = new DefaultHttpClient();
			HttpPost httppost = new HttpPost("http://www.comdevindex.0fees.us/Community_Vitality.php");
 
			try {
				// Add your data
				List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
				nameValuePairs.add(new BasicNameValuePair("TimeandMoneyDonation",TimeandMoneyDonation));
				nameValuePairs.add(new BasicNameValuePair("SenceofBeloningness",SenceofBeloningness));
				nameValuePairs.add(new BasicNameValuePair("OverallCrimeRate",OverallCrimeRate));
				nameValuePairs.add(new BasicNameValuePair("WomenSafety",WomenSafety));
				nameValuePairs.add(new BasicNameValuePair("RoadAccidents",RoadAccidents));
				nameValuePairs.add(new BasicNameValuePair("ConstantPoliceSurvillance",ConstantPoliceSurvillance));
				nameValuePairs.add(new BasicNameValuePair("GenderInequality",GenderInequality));
				nameValuePairs.add(new BasicNameValuePair("IncomeInquality",IncomeInquality));
				nameValuePairs.add(new BasicNameValuePair("InequalityDuetoCaste",InequalityDuetoCaste));
				
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
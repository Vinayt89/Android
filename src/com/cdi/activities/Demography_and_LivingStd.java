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
import android.widget.TextView;
import android.widget.Toast;
import android.widget.SeekBar.OnSeekBarChangeListener;


public class Demography_and_LivingStd extends Activity {
	
	SeekBar sbAffordableHousingPurchase,sbAffordableHousingRentals,sbHouseHoldIncomeandPurchasing,
	sbPollutionDensity,sbPollutioninSlums,sbMigrationofCityEveryYear;
	int progress=0;
	TextView tvAffordableHousingPurchase,tvAffordableHousingRentals,tvHouseHoldIncomeandPurchasing,
	tvPollutionDensity,tvPollutioninSlums,tvMigrationofCityEveryYear;
	
	
	Button btnNext,btnBack;
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.form9);
		
		references();
		seekBarImplementation();
		
		btnBack=(Button)findViewById(R.id.btnBack);
		btnNext=(Button)findViewById(R.id.btnNext);
		
		btnBack.setOnClickListener(new View.OnClickListener() {
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				Intent i=new Intent(getApplicationContext(),Enviornment.class);
				startActivity(i);
			}
		});
		
		btnNext.setOnClickListener(new View.OnClickListener() {
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				validation();
				new MyAsyncTask().execute( tvAffordableHousingPurchase.getText().toString(),tvAffordableHousingRentals.getText().toString(),tvHouseHoldIncomeandPurchasing.getText().toString(),
										   tvPollutionDensity.getText().toString(),tvPollutioninSlums.getText().toString(),tvMigrationofCityEveryYear.getText().toString());
			}
		});
	}
	public void references(){
		
		sbAffordableHousingPurchase=(SeekBar)findViewById(R.id.sbAffordableHousingPurchase);
		sbAffordableHousingRentals=(SeekBar)findViewById(R.id.sbAffordableHousingRentals);
		sbHouseHoldIncomeandPurchasing=(SeekBar)findViewById(R.id.sbHouseHoldIncomeandPurchasing);
		sbPollutionDensity=(SeekBar)findViewById(R.id.sbPollutionDensity);
		sbPollutioninSlums=(SeekBar)findViewById(R.id.sbPollutioninSlums);
		sbMigrationofCityEveryYear=(SeekBar)findViewById(R.id.sbMigrationofCityEveryYear);
		
		tvAffordableHousingPurchase=(TextView)findViewById(R.id.tvAffordableHousingPurchase);
		tvAffordableHousingRentals=(TextView)findViewById(R.id.tvAffordableHousingRentals);
		tvHouseHoldIncomeandPurchasing=(TextView)findViewById(R.id.tvHouseHoldIncomeandPurchasing);
		tvPollutionDensity=(TextView)findViewById(R.id.tvPollutionDensity);
		tvPollutioninSlums=(TextView)findViewById(R.id.tvPollutioninSlums);
		tvMigrationofCityEveryYear=(TextView)findViewById(R.id.tvMigrationofCityEveryYear);
	}
	public void seekBarImplementation(){
		
		sbAffordableHousingPurchase.setOnSeekBarChangeListener(new OnSeekBarChangeListener() 
		{
			public void onStopTrackingTouch(SeekBar seekBar){
				tvAffordableHousingPurchase.setText(progress + "/" + seekBar.getMax());
			}
			public void onStartTrackingTouch(SeekBar arg0){}
			public void onProgressChanged(SeekBar seekBar,int progresValue, boolean fromUser){
				 progress = progresValue;
			}
		});
		sbAffordableHousingRentals.setOnSeekBarChangeListener(new OnSeekBarChangeListener() 
		{
			public void onStopTrackingTouch(SeekBar seekBar){
				tvAffordableHousingRentals.setText(progress + "/" + seekBar.getMax());
			}
			public void onStartTrackingTouch(SeekBar arg0){}
			public void onProgressChanged(SeekBar seekBar,int progresValue, boolean fromUser){
				 progress = progresValue;
			}
		});
		sbHouseHoldIncomeandPurchasing.setOnSeekBarChangeListener(new OnSeekBarChangeListener() 
		{
			public void onStopTrackingTouch(SeekBar seekBar){
				tvHouseHoldIncomeandPurchasing.setText(progress + "/" + seekBar.getMax());
			}
			public void onStartTrackingTouch(SeekBar arg0){}
			public void onProgressChanged(SeekBar seekBar,int progresValue, boolean fromUser){
				 progress = progresValue;
			}
		});
		sbPollutionDensity.setOnSeekBarChangeListener(new OnSeekBarChangeListener() 
		{
			public void onStopTrackingTouch(SeekBar seekBar){
				tvPollutionDensity.setText(progress + "/" + seekBar.getMax());
			}
			public void onStartTrackingTouch(SeekBar arg0){}
			public void onProgressChanged(SeekBar seekBar,int progresValue, boolean fromUser){
				 progress = progresValue;
			}
		});
		sbPollutioninSlums.setOnSeekBarChangeListener(new OnSeekBarChangeListener() 
		{
			public void onStopTrackingTouch(SeekBar seekBar){
				tvPollutioninSlums.setText(progress + "/" + seekBar.getMax());
			}
			public void onStartTrackingTouch(SeekBar arg0){}
			public void onProgressChanged(SeekBar seekBar,int progresValue, boolean fromUser){
				 progress = progresValue;
			}
		});
		sbMigrationofCityEveryYear.setOnSeekBarChangeListener(new OnSeekBarChangeListener() 
		{
			public void onStopTrackingTouch(SeekBar seekBar){
				tvMigrationofCityEveryYear.setText(progress + "/" + seekBar.getMax());
			}
			public void onStartTrackingTouch(SeekBar arg0){}
			public void onProgressChanged(SeekBar seekBar,int progresValue, boolean fromUser){
				 progress = progresValue;
			}
		});
		
	}
	public void validation(){
		
		if(tvAffordableHousingPurchase.getText()==""){
			Toast.makeText(getApplicationContext(), "Please Give Rating to Affordable Housing(Purchase)!!", Toast.LENGTH_LONG).show();
		}
		else if(tvAffordableHousingRentals.getText()==""){
			Toast.makeText(getApplicationContext(), "Please Give Rating to Affordable Housing(Rentals)!!", Toast.LENGTH_LONG).show();
		}
		else if(tvHouseHoldIncomeandPurchasing.getText()==""){
			Toast.makeText(getApplicationContext(), "Please Give Rating to HouseHold Income and Purchasing Power per House!!", Toast.LENGTH_LONG).show();
		}
		else if(tvPollutionDensity.getText()==""){
			Toast.makeText(getApplicationContext(), "Please Give Rating to Pollution Density!!", Toast.LENGTH_LONG).show();
		}
		else if(tvPollutioninSlums.getText()==""){
			Toast.makeText(getApplicationContext(), "Please Give Rating to Pollution in Slums!!", Toast.LENGTH_LONG).show();
		}
		else if(tvMigrationofCityEveryYear.getText()==""){
			Toast.makeText(getApplicationContext(), "Please Give Rating to Migration of City Every  Year!!", Toast.LENGTH_LONG).show();
		}
		else{
			Intent i=new Intent(getApplicationContext(),ThankYouPage.class);
			startActivity(i);
		}
	}
	private class MyAsyncTask extends AsyncTask<String, Integer, Double>{
		protected Double doInBackground(String... params) 
		{
			// TODO Auto-generated method stub
			postData(params[0],params[1],params[2],params[3],params[4],params[5]);
			return null;
		}
		protected void onPostExecute(Double result)
		{
		}
 
		public void postData(String AffordableHousingPurchase,String AffordableHousingRentals,String HouseHoldIncomeandPurchasing,String PollutionDensity,String PollutioninSlums,
							 String MigrationofCityEveryYear)
		{
			// Create a new HttpClient and Post Header
			HttpClient httpclient = new DefaultHttpClient();
			HttpPost httppost = new HttpPost("http://www.comdevindex.0fees.us/Demography_and_LivingStd.php");
 
			try {
				// Add your data
				List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
				nameValuePairs.add(new BasicNameValuePair("AffordableHousingPurchase",AffordableHousingPurchase));
				nameValuePairs.add(new BasicNameValuePair("AffordableHousingRentals",AffordableHousingRentals));
				nameValuePairs.add(new BasicNameValuePair("HouseHoldIncomeandPurchasing",HouseHoldIncomeandPurchasing));
				nameValuePairs.add(new BasicNameValuePair("PollutionDensity",PollutionDensity));
				nameValuePairs.add(new BasicNameValuePair("PollutioninSlums",PollutioninSlums));
				nameValuePairs.add(new BasicNameValuePair("MigrationofCityEveryYear",MigrationofCityEveryYear));
	
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
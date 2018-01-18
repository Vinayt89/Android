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

public class Economic_Enviornment extends Activity {
	
	SeekBar sbPerCapitaIncome,sbPeopleBelowPovertyLine,sbFrequencyOfBank,sbFrequencyOfMarkets,sbEnvandInfraForBuss,
	sbNoofStartupsFormCity,sbToPurchaseConsumer,sbUseofInovationandTechnolgy;
	int progress=0;
	TextView tvPerCapitaIncome,tvPeopleBelowPovertyLine,tvFrequencyOfBank,tvFrequencyOfMarkets,tvEnvandInfraForBuss,
	tvNoofStartupsFormCity,tvToPurchaseConsumer,tvUseofInovationandTechnolgy;
	
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.form4);
		
		Button btnBack=(Button)findViewById(R.id.btnBack);
		Button btnNext=(Button)findViewById(R.id.btnNext);
		
		references();
		seekBarImplementation();
		
		btnBack.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i=new Intent(getApplicationContext(),Economic_Enviornment_MainForm.class);
				startActivity(i);
			}
		});
		btnNext.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				validation();
				new MyAsyncTask().execute(tvPerCapitaIncome.getText().toString(),tvPeopleBelowPovertyLine.getText().toString(),tvFrequencyOfBank.getText().toString(),tvFrequencyOfMarkets.getText().toString(),
								          tvEnvandInfraForBuss.getText().toString(),tvToPurchaseConsumer.getText().toString(),tvNoofStartupsFormCity.getText().toString(),tvUseofInovationandTechnolgy.getText().toString());	
			}
		});
	}
	public void references(){
		sbPerCapitaIncome=(SeekBar)findViewById(R.id.sbPerCapitaIncome);
		sbPeopleBelowPovertyLine=(SeekBar)findViewById(R.id.sbPeopleBelowPovertyLine);
		sbFrequencyOfBank=(SeekBar)findViewById(R.id.sbFrequencyOfBank);
		sbFrequencyOfMarkets=(SeekBar)findViewById(R.id.sbFrequencyOfMarkets);
		sbEnvandInfraForBuss=(SeekBar)findViewById(R.id.sbEnvandInfraForBuss);
		sbNoofStartupsFormCity=(SeekBar)findViewById(R.id.sbNoofStartupsFormCity);
		sbToPurchaseConsumer=(SeekBar)findViewById(R.id.sbToPurchaseConsumer);
		sbUseofInovationandTechnolgy=(SeekBar)findViewById(R.id.sbUseofInovationandTechnolgy);
		
		tvPerCapitaIncome=(TextView)findViewById(R.id.tvPerCapitaIncome);
		tvPeopleBelowPovertyLine=(TextView)findViewById(R.id.tvPeopleBelowPovertyLine);
		tvFrequencyOfBank=(TextView)findViewById(R.id.tvFrequencyOfBank);
		tvFrequencyOfMarkets=(TextView)findViewById(R.id.tvFrequencyOfMarkets);
		tvEnvandInfraForBuss=(TextView)findViewById(R.id.tvEnvandInfraForBuss);
		tvNoofStartupsFormCity=(TextView)findViewById(R.id.tvNoofStartupsFormCity);
		tvToPurchaseConsumer=(TextView)findViewById(R.id.tvToPurchaseConsumer);
		tvUseofInovationandTechnolgy=(TextView)findViewById(R.id.tvUseofInovationandTechnolgy);
	}
	
	public void seekBarImplementation(){
		sbPerCapitaIncome.setOnSeekBarChangeListener(new OnSeekBarChangeListener() 
		{
			public void onStopTrackingTouch(SeekBar seekBar){
				tvPerCapitaIncome.setText(progress + "/" + seekBar.getMax());
			}
			public void onStartTrackingTouch(SeekBar arg0){}
			public void onProgressChanged(SeekBar seekBar,int progresValue, boolean fromUser){
				 progress = progresValue;
			}
		});
		sbPeopleBelowPovertyLine.setOnSeekBarChangeListener(new OnSeekBarChangeListener() 
		{
			public void onStopTrackingTouch(SeekBar seekBar){
				tvPeopleBelowPovertyLine.setText(progress + "/" + seekBar.getMax());
			}
			public void onStartTrackingTouch(SeekBar arg0){}
			public void onProgressChanged(SeekBar seekBar,int progresValue, boolean fromUser){
				 progress = progresValue;
			}
		});
		sbFrequencyOfBank.setOnSeekBarChangeListener(new OnSeekBarChangeListener() 
		{
			public void onStopTrackingTouch(SeekBar seekBar){
				tvFrequencyOfBank.setText(progress + "/" + seekBar.getMax());
			}
			public void onStartTrackingTouch(SeekBar arg0){}
			public void onProgressChanged(SeekBar seekBar,int progresValue, boolean fromUser){
				 progress = progresValue;
			}
		});
		sbFrequencyOfMarkets.setOnSeekBarChangeListener(new OnSeekBarChangeListener() 
		{
			public void onStopTrackingTouch(SeekBar seekBar){
				tvFrequencyOfMarkets.setText(progress + "/" + seekBar.getMax());
			}
			public void onStartTrackingTouch(SeekBar arg0){}
			public void onProgressChanged(SeekBar seekBar,int progresValue, boolean fromUser){
				 progress = progresValue;
			}
		});
		sbEnvandInfraForBuss.setOnSeekBarChangeListener(new OnSeekBarChangeListener() 
		{
			public void onStopTrackingTouch(SeekBar seekBar){
				tvEnvandInfraForBuss.setText(progress + "/" + seekBar.getMax());
			}
			public void onStartTrackingTouch(SeekBar arg0){}
			public void onProgressChanged(SeekBar seekBar,int progresValue, boolean fromUser){
				 progress = progresValue;
			}
		});
		sbNoofStartupsFormCity.setOnSeekBarChangeListener(new OnSeekBarChangeListener() 
		{
			public void onStopTrackingTouch(SeekBar seekBar){
				tvNoofStartupsFormCity.setText(progress + "/" + seekBar.getMax());
			}
			public void onStartTrackingTouch(SeekBar arg0){}
			public void onProgressChanged(SeekBar seekBar,int progresValue, boolean fromUser){
				 progress = progresValue;
			}
		});
		sbToPurchaseConsumer.setOnSeekBarChangeListener(new OnSeekBarChangeListener() 
		{
			public void onStopTrackingTouch(SeekBar seekBar){
				tvToPurchaseConsumer.setText(progress + "/" + seekBar.getMax());
			}
			public void onStartTrackingTouch(SeekBar arg0){}
			public void onProgressChanged(SeekBar seekBar,int progresValue, boolean fromUser){
				 progress = progresValue;
			}
		});
		sbUseofInovationandTechnolgy.setOnSeekBarChangeListener(new OnSeekBarChangeListener() 
		{
			public void onStopTrackingTouch(SeekBar seekBar){
				tvUseofInovationandTechnolgy.setText(progress + "/" + seekBar.getMax());
			}
			public void onStartTrackingTouch(SeekBar arg0){}
			public void onProgressChanged(SeekBar seekBar,int progresValue, boolean fromUser){
				 progress = progresValue;
			}
		});

	}
	public void validation(){
		if(tvPerCapitaIncome.getText()==""){
			Toast.makeText(getApplicationContext(), "Please Give Rating to Per Capita Income!!",Toast.LENGTH_LONG).show();
		}
		else if(tvPeopleBelowPovertyLine.getText()==""){
			Toast.makeText(getApplicationContext(), "Please Give Rating to People Below Poverty Line!!",Toast.LENGTH_LONG).show();
		}
		else if(tvFrequencyOfBank.getText()==""){
			Toast.makeText(getApplicationContext(), "Please Give Rating to People Frequency Of Bank!!",Toast.LENGTH_LONG).show();
		}
		else if(tvFrequencyOfMarkets.getText()==""){
			Toast.makeText(getApplicationContext(), "Please Give Rating to Frequency of Markets!!",Toast.LENGTH_LONG).show();
		}
		else if(tvEnvandInfraForBuss.getText()==""){
			Toast.makeText(getApplicationContext(), "Please Give Rating to Enviornment and Infrastucture For Business!!",Toast.LENGTH_LONG).show();
		}
		else if(tvNoofStartupsFormCity.getText()==""){
			Toast.makeText(getApplicationContext(), "Please Give Rating to Number of Startups Form City!!",Toast.LENGTH_LONG).show();
		}
		else if(tvToPurchaseConsumer.getText()==""){
			Toast.makeText(getApplicationContext(), "Please Give Rating to To purchase consumer durables,vehicles,gadgets and services!!",Toast.LENGTH_LONG).show();
		}
		else if(tvUseofInovationandTechnolgy.getText()==""){
			Toast.makeText(getApplicationContext(), "Please Give Rating to Use of Inovation and Technology!!",Toast.LENGTH_LONG).show();
		}
		else{
			Intent i=new Intent(getApplicationContext(),Infrastructure_Env_MainForm.class);
			startActivity(i);
			finish();
		}

		
	}
	private class MyAsyncTask extends AsyncTask<String, Integer, Double>{
		protected Double doInBackground(String... params) 
		{
			// TODO Auto-generated method stub
			postData(params[0],params[1],params[2],params[3],params[4],params[5],params[6],params[7]);
			return null;
		}
		protected void onPostExecute(Double result)
		{
		}
 
		public void postData(String PerCapitaIncome,String PeopleBelowPovertyLine,String FrequencyOfBank,String FrequencyOfMarkets,String EnvandInfraForBuss,
							 String NoofStartupsFormCity,String ToPurchaseConsumer,String UseofInovationandTechnolgy)
		{
			// Create a new HttpClient and Post Header
			HttpClient httpclient = new DefaultHttpClient();
			HttpPost httppost = new HttpPost("http://www.comdevindex.0fees.us/Economic_Enviornment.php");
 
			try {
				// Add your data
				List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
				nameValuePairs.add(new BasicNameValuePair("PerCapitaIncome",PerCapitaIncome));
				nameValuePairs.add(new BasicNameValuePair("PeopleBelowPovertyLine",PeopleBelowPovertyLine));
				nameValuePairs.add(new BasicNameValuePair("FrequencyOfBank",FrequencyOfBank));
				nameValuePairs.add(new BasicNameValuePair("FrequencyOfMarkets",FrequencyOfMarkets));
				nameValuePairs.add(new BasicNameValuePair("EnvandInfraForBuss",EnvandInfraForBuss));
				nameValuePairs.add(new BasicNameValuePair("NoofStartupsFormCity",NoofStartupsFormCity));
				nameValuePairs.add(new BasicNameValuePair("ToPurchaseConsumer",ToPurchaseConsumer));
				nameValuePairs.add(new BasicNameValuePair("UseofInovationandTechnolgy",UseofInovationandTechnolgy));
	
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

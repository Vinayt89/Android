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
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Toast;

import com.example.cdicomplete25aug.R;

public class Enviornment extends Activity {
	
	
	SeekBar sbPollutionRiversandStream,sbAirPollution,sbNoisePollution,sbAbsenseofWasteDisposalSites,
	sbLittering,sbFeelingofResponsibility;
	int progress=0;
	TextView tvPollutionRiversandStream,tvAirPollution,tvNoisePollution,tvAbsenseofWasteDisposalSites,
	tvLittering,tvFeelingofResponsibility;
	
	Button btnNext,btnBack;
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.form8);
		
		references();
		seekBarImplementation();
		
		btnBack=(Button)findViewById(R.id.btnBack);
		btnNext=(Button)findViewById(R.id.btnNext);
		
		btnBack.setOnClickListener(new View.OnClickListener() {
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

				Intent i=new Intent(getApplicationContext(),Community_Vitality.class);
				startActivity(i);
			}
		});
		
		btnNext.setOnClickListener(new View.OnClickListener() {
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				validation();
				new MyAsyncTask().execute(tvPollutionRiversandStream.getText().toString(),tvAirPollution.getText().toString(),tvNoisePollution.getText().toString(),tvAbsenseofWasteDisposalSites.getText().toString(),
										  tvLittering.getText().toString(),tvFeelingofResponsibility.getText().toString());
			}
		});
	}
	public void references(){
		
		sbPollutionRiversandStream=(SeekBar)findViewById(R.id.sbPollutionRiversandStream);
		sbAirPollution=(SeekBar)findViewById(R.id.sbAirPollution);
		sbNoisePollution=(SeekBar)findViewById(R.id.sbNoisePollution);
		sbAbsenseofWasteDisposalSites=(SeekBar)findViewById(R.id.sbAbsenseofWasteDisposalSites);
		sbLittering=(SeekBar)findViewById(R.id.sbLittering);
		sbFeelingofResponsibility=(SeekBar)findViewById(R.id.sbFeelingofResponsibility);
		
		tvPollutionRiversandStream=(TextView)findViewById(R.id.tvPollutionRiversandStream);
		tvAirPollution=(TextView)findViewById(R.id.tvAirPollution);
		tvNoisePollution=(TextView)findViewById(R.id.tvNoisePollution);
		tvAbsenseofWasteDisposalSites=(TextView)findViewById(R.id.tvAbsenseofWasteDisposalSites);
		tvLittering=(TextView)findViewById(R.id.tvLittering);
		tvFeelingofResponsibility=(TextView)findViewById(R.id.tvFeelingofResponsibility);
		
	}
	public void seekBarImplementation(){
		
		sbPollutionRiversandStream.setOnSeekBarChangeListener(new OnSeekBarChangeListener() 
		{
			public void onStopTrackingTouch(SeekBar seekBar){
				tvPollutionRiversandStream.setText(progress + "/" + seekBar.getMax());
			}
			public void onStartTrackingTouch(SeekBar arg0){}
			public void onProgressChanged(SeekBar seekBar,int progresValue, boolean fromUser){
				 progress = progresValue;
			}
		});
		sbAirPollution.setOnSeekBarChangeListener(new OnSeekBarChangeListener() 
		{
			public void onStopTrackingTouch(SeekBar seekBar){
				tvAirPollution.setText(progress + "/" + seekBar.getMax());
			}
			public void onStartTrackingTouch(SeekBar arg0){}
			public void onProgressChanged(SeekBar seekBar,int progresValue, boolean fromUser){
				 progress = progresValue;
			}
		});
		sbNoisePollution.setOnSeekBarChangeListener(new OnSeekBarChangeListener() 
		{
			public void onStopTrackingTouch(SeekBar seekBar){
				tvNoisePollution.setText(progress + "/" + seekBar.getMax());
			}
			public void onStartTrackingTouch(SeekBar arg0){}
			public void onProgressChanged(SeekBar seekBar,int progresValue, boolean fromUser){
				 progress = progresValue;
			}
		});
		sbAbsenseofWasteDisposalSites.setOnSeekBarChangeListener(new OnSeekBarChangeListener() 
		{
			public void onStopTrackingTouch(SeekBar seekBar){
				tvAbsenseofWasteDisposalSites.setText(progress + "/" + seekBar.getMax());
			}
			public void onStartTrackingTouch(SeekBar arg0){}
			public void onProgressChanged(SeekBar seekBar,int progresValue, boolean fromUser){
				 progress = progresValue;
			}
		});
		sbLittering.setOnSeekBarChangeListener(new OnSeekBarChangeListener() 
		{
			public void onStopTrackingTouch(SeekBar seekBar){
				tvLittering.setText(progress + "/" + seekBar.getMax());
			}
			public void onStartTrackingTouch(SeekBar arg0){}
			public void onProgressChanged(SeekBar seekBar,int progresValue, boolean fromUser){
				 progress = progresValue;
			}
		});
		sbFeelingofResponsibility.setOnSeekBarChangeListener(new OnSeekBarChangeListener() 
		{
			public void onStopTrackingTouch(SeekBar seekBar){
				tvFeelingofResponsibility.setText(progress + "/" + seekBar.getMax());
			}
			public void onStartTrackingTouch(SeekBar arg0){}
			public void onProgressChanged(SeekBar seekBar,int progresValue, boolean fromUser){
				 progress = progresValue;
			}
		});
		
	}
	public void validation(){
		
		if(tvPollutionRiversandStream.getText()==""){
			Toast.makeText(getApplicationContext(), "Please Give Rating to Pollution of Rivers and Stream!!", Toast.LENGTH_LONG).show();
		}
		else if(tvAirPollution.getText()==""){
			Toast.makeText(getApplicationContext(), "Please Give Rating to Air Pollution!!", Toast.LENGTH_LONG).show();
		}
		else if(tvNoisePollution.getText()==""){
			Toast.makeText(getApplicationContext(), "Please Give Rating to Noise Pollution!!", Toast.LENGTH_LONG).show();
		}
		else if(tvAbsenseofWasteDisposalSites.getText()==""){
			Toast.makeText(getApplicationContext(), "Please Give Rating to Absense of Waste Disposal Sites!!", Toast.LENGTH_LONG).show();
		}
		else if(tvLittering.getText()==""){
			Toast.makeText(getApplicationContext(), "Please Give Rating to Littering!!", Toast.LENGTH_LONG).show();
		}
		else if(tvFeelingofResponsibility.getText()==""){
			Toast.makeText(getApplicationContext(), "Please Give Rating to Feeling of Responsibility and Awareness towards Enviornment!!", Toast.LENGTH_LONG).show();
		}
		else{
			Intent i=new Intent(getApplicationContext(),Demography_and_LivingStd_MainForm.class);
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
 
		public void postData(String PollutionRiversandStream,String AirPollution,String NoisePollution,String AbsenseofWasteDisposalSites,String Littering,
							 String FeelingofResponsibility)
		{
			// Create a new HttpClient and Post Header
			HttpClient httpclient = new DefaultHttpClient();
			HttpPost httppost = new HttpPost("http://www.comdevindex.0fees.us/Enviornment.php");
			
			try {
				// Add your data
				List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
				nameValuePairs.add(new BasicNameValuePair("PollutionRiversandStream",PollutionRiversandStream));
				nameValuePairs.add(new BasicNameValuePair("AirPollution",AirPollution));
				nameValuePairs.add(new BasicNameValuePair("NoisePollution",NoisePollution));
				nameValuePairs.add(new BasicNameValuePair("AbsenseofWasteDisposalSites",AbsenseofWasteDisposalSites));
				nameValuePairs.add(new BasicNameValuePair("Littering",Littering));
				nameValuePairs.add(new BasicNameValuePair("FeelingofResponsibility",FeelingofResponsibility));
	
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
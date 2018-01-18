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

import android.annotation.SuppressLint;
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

@SuppressLint("NewApi")
public class Peace_of_Mind extends Activity {
	
	
	Button btnPrevious,btnNext;
	SeekBar sbSatisfactionWithHealth,sbSatisfactionWithSoL,sbSatisfactionWithOccupation,sbSatisfactionWithFamily,
	sbSatisfactionWithWork,sbSpiritualLevel,sbPrayerRecitation,sbMeditation,sbPositiveEmotions,sbNegativeEmotions,
	sbWorkingHours,sbSleepingHours,sbTimeSpenttoTravel,sbTimeSpentonHobbies;
	int progress = 0;
	TextView tvSatisfactionWithHealth,tvSatisfactionWithSoL,tvSatisfactionWithOccupation,tvSatisfactionWithFamily,
	tvSatisfactionWithWork,tvSpiritualLevel,tvPrayerRecitation,tvMeditation,tvPositiveEmotions,tvNegativeEmotions,
	tvWorkingHours,tvSleepingHours,tvTimeSpenttoTravel,tvTimeSpentonHobbies;
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.form1);
	   
		references();
		seekBarImplimentation();
	    
		btnNext=(Button)findViewById(R.id.btnNext);
		btnNext.setOnClickListener(new View.OnClickListener() {
			public void onClick(View arg0){
				validation();
				new MyAsyncTask().execute(tvSatisfactionWithHealth.getText().toString(),tvSatisfactionWithSoL.getText().toString(),tvSatisfactionWithOccupation.getText().toString(),
										  tvSatisfactionWithFamily.getText().toString(),tvSatisfactionWithWork.getText().toString(),tvSpiritualLevel.getText().toString(),tvPrayerRecitation.getText().toString(),
										  tvMeditation.getText().toString(),tvPositiveEmotions.getText().toString(),tvNegativeEmotions.getText().toString(),tvWorkingHours.getText().toString(),tvSleepingHours.getText().toString(),
										  tvTimeSpenttoTravel.getText().toString(),tvTimeSpentonHobbies.getText().toString());
			}
		});
	}
	public void references(){
		tvSatisfactionWithHealth=(TextView)findViewById(R.id.tvSatisfactionWithHealth);
		tvSatisfactionWithSoL=(TextView)findViewById(R.id.tvSatisfactionWithSoL);
		tvSatisfactionWithOccupation=(TextView)findViewById(R.id.tvSatisfactionWithOccupation);
		tvSatisfactionWithFamily=(TextView)findViewById(R.id.tvSatisfactionWithFamily);
		tvSatisfactionWithWork=(TextView)findViewById(R.id.tvSatisfactionWithWork);
		tvSpiritualLevel=(TextView)findViewById(R.id.tvSpiritualLevel);
		tvPrayerRecitation=(TextView)findViewById(R.id.tvPrayerRecitation);
		tvMeditation=(TextView)findViewById(R.id.tvMeditation);
		tvPositiveEmotions=(TextView)findViewById(R.id.tvPositiveEmotions);
		tvNegativeEmotions=(TextView)findViewById(R.id.tvNegativeEmotions);
		tvWorkingHours=(TextView)findViewById(R.id.tvWorkingHours);
		tvSleepingHours=(TextView)findViewById(R.id.tvSleepingHours);
		tvTimeSpenttoTravel=(TextView)findViewById(R.id.tvTimeSpenttoTravel);
		tvTimeSpentonHobbies=(TextView)findViewById(R.id.tvTimeSpentonHobbies);
	}
	public void seekBarImplimentation() {
		sbSatisfactionWithHealth=(SeekBar)findViewById(R.id.sbSatisfactionWithHealth);
		sbSatisfactionWithHealth.setOnSeekBarChangeListener(new OnSeekBarChangeListener() 
		{
			public void onStopTrackingTouch(SeekBar seekBar){
				tvSatisfactionWithHealth.setText(progress + "/" + seekBar.getMax());
			}
			public void onStartTrackingTouch(SeekBar arg0){}
			public void onProgressChanged(SeekBar seekBar,int progresValue, boolean fromUser){
				 progress = progresValue;
			}
		});
		
		sbSatisfactionWithSoL=(SeekBar)findViewById(R.id.sbSatisfactionWithSoL);
		sbSatisfactionWithSoL.setOnSeekBarChangeListener(new OnSeekBarChangeListener() 
		{
			public void onStopTrackingTouch(SeekBar seekBar){
				tvSatisfactionWithSoL.setText(progress + "/" + seekBar.getMax());
			}
			public void onStartTrackingTouch(SeekBar arg0){}
			public void onProgressChanged(SeekBar seekBar,int progresValue, boolean fromUser){
				 progress = progresValue;
			}
		});
		
		sbSatisfactionWithOccupation=(SeekBar)findViewById(R.id.sbSatisfactionWithOccupation);
		sbSatisfactionWithOccupation.setOnSeekBarChangeListener(new OnSeekBarChangeListener() 
		{
			public void onStopTrackingTouch(SeekBar seekBar){
				tvSatisfactionWithOccupation.setText(progress + "/" + seekBar.getMax());
			}
			public void onStartTrackingTouch(SeekBar arg0){}
			public void onProgressChanged(SeekBar seekBar,int progresValue, boolean fromUser){
				 progress = progresValue;
			}
		});
		
		sbSatisfactionWithFamily=(SeekBar)findViewById(R.id.sbSatisfactionWithFamily);
		sbSatisfactionWithFamily.setOnSeekBarChangeListener(new OnSeekBarChangeListener() 
		{
			public void onStopTrackingTouch(SeekBar seekBar){
				tvSatisfactionWithFamily.setText(progress + "/" + seekBar.getMax());
			}
			public void onStartTrackingTouch(SeekBar arg0){}
			public void onProgressChanged(SeekBar seekBar,int progresValue, boolean fromUser){
				 progress = progresValue;
			}
		});
		
		sbSatisfactionWithWork=(SeekBar)findViewById(R.id.sbSatisfactionWithWork);
		sbSatisfactionWithWork.setOnSeekBarChangeListener(new OnSeekBarChangeListener() 
		{
			public void onStopTrackingTouch(SeekBar seekBar){
				tvSatisfactionWithWork.setText(progress + "/" + seekBar.getMax());
			}
			public void onStartTrackingTouch(SeekBar arg0){}
			public void onProgressChanged(SeekBar seekBar,int progresValue, boolean fromUser){
				 progress = progresValue;
			}
		});
		
		sbSpiritualLevel=(SeekBar)findViewById(R.id.sbSpiritualLevel);
		sbSpiritualLevel.setOnSeekBarChangeListener(new OnSeekBarChangeListener() 
		{
			public void onStopTrackingTouch(SeekBar seekBar){
				tvSpiritualLevel.setText(progress + "/" + seekBar.getMax());
			}
			public void onStartTrackingTouch(SeekBar arg0){}
			public void onProgressChanged(SeekBar seekBar,int progresValue, boolean fromUser){
				 progress = progresValue;
			}
		});
		
		sbPrayerRecitation=(SeekBar)findViewById(R.id.sbPrayerRecitation);
		sbPrayerRecitation.setOnSeekBarChangeListener(new OnSeekBarChangeListener() 
		{
			public void onStopTrackingTouch(SeekBar seekBar){
				tvPrayerRecitation.setText(progress + "/" + seekBar.getMax());
			}
			public void onStartTrackingTouch(SeekBar arg0){}
			public void onProgressChanged(SeekBar seekBar,int progresValue, boolean fromUser){
				 progress = progresValue;
			}
		});
		
		sbMeditation=(SeekBar)findViewById(R.id.sbMeditation);
		sbMeditation.setOnSeekBarChangeListener(new OnSeekBarChangeListener() 
		{
			public void onStopTrackingTouch(SeekBar seekBar){
				tvMeditation.setText(progress + "/" + seekBar.getMax());
			}
			public void onStartTrackingTouch(SeekBar arg0){}
			public void onProgressChanged(SeekBar seekBar,int progresValue, boolean fromUser){
				 progress = progresValue;
			}
		});

		sbPositiveEmotions=(SeekBar)findViewById(R.id.sbPositiveEmotions);
		sbPositiveEmotions.setOnSeekBarChangeListener(new OnSeekBarChangeListener() 
		{
			public void onStopTrackingTouch(SeekBar seekBar){
				tvPositiveEmotions.setText(progress + "/" + seekBar.getMax());
			}
			public void onStartTrackingTouch(SeekBar arg0){}
			public void onProgressChanged(SeekBar seekBar,int progresValue, boolean fromUser){
				 progress = progresValue;
			}
		});
		
		sbNegativeEmotions=(SeekBar)findViewById(R.id.sbNegativeEmotions);
		sbNegativeEmotions.setOnSeekBarChangeListener(new OnSeekBarChangeListener() 
		{
			public void onStopTrackingTouch(SeekBar seekBar){
				tvNegativeEmotions.setText(progress + "/" + seekBar.getMax());
			}
			public void onStartTrackingTouch(SeekBar arg0){}
			public void onProgressChanged(SeekBar seekBar,int progresValue, boolean fromUser){
				 progress = progresValue;
			}
		});
		
		sbWorkingHours=(SeekBar)findViewById(R.id.sbWorkingHours);
		sbWorkingHours.setOnSeekBarChangeListener(new OnSeekBarChangeListener() 
		{
			public void onStopTrackingTouch(SeekBar seekBar){
				tvWorkingHours.setText(progress + "/" + seekBar.getMax());
			}
			public void onStartTrackingTouch(SeekBar arg0){}
			public void onProgressChanged(SeekBar seekBar,int progresValue, boolean fromUser){
				 progress = progresValue;
			}
		});
		
		sbSleepingHours=(SeekBar)findViewById(R.id.sbSleepingHours);
		sbSleepingHours.setOnSeekBarChangeListener(new OnSeekBarChangeListener() 
		{
			public void onStopTrackingTouch(SeekBar seekBar){
				tvSleepingHours.setText(progress + "/" + seekBar.getMax());
			}
			public void onStartTrackingTouch(SeekBar arg0){}
			public void onProgressChanged(SeekBar seekBar,int progresValue, boolean fromUser){
				 progress = progresValue;
			}
		});
		
		sbTimeSpenttoTravel=(SeekBar)findViewById(R.id.sbTimeSpenttoTravel);
		sbTimeSpenttoTravel.setOnSeekBarChangeListener(new OnSeekBarChangeListener() 
		{
			public void onStopTrackingTouch(SeekBar seekBar){
				tvTimeSpenttoTravel.setText(progress + "/" + seekBar.getMax());
			}
			public void onStartTrackingTouch(SeekBar arg0){}
			public void onProgressChanged(SeekBar seekBar,int progresValue, boolean fromUser){
				 progress = progresValue;
			}
		});
		
		sbTimeSpentonHobbies=(SeekBar)findViewById(R.id.sbTimeSpentonHobbies);
		sbTimeSpentonHobbies.setOnSeekBarChangeListener(new OnSeekBarChangeListener() 
		{
			public void onStopTrackingTouch(SeekBar seekBar){
				tvTimeSpentonHobbies.setText(progress + "/" + seekBar.getMax());
			}
			public void onStartTrackingTouch(SeekBar arg0){}
			public void onProgressChanged(SeekBar seekBar,int progresValue, boolean fromUser){
				 progress = progresValue;
			}
		});
	}
	public void validation(){
		if(tvSatisfactionWithHealth.getText()=="" ){
			Toast.makeText(getApplicationContext(),"Please Give Rating to Satisfaction with Health!!",Toast.LENGTH_LONG).show();
		}
		else if(tvSatisfactionWithSoL.getText()==""){
			Toast.makeText(getApplicationContext(),"Please Give Rating to Satisfaction with standard of living!!",Toast.LENGTH_LONG).show();
		}
		else if(tvSatisfactionWithOccupation.getText()==""){
			Toast.makeText(getApplicationContext(),"Please Give Rating to Satisfaction with occupation!!",Toast.LENGTH_LONG).show();
		}
		else if(tvSatisfactionWithFamily.getText()==""){
			Toast.makeText(getApplicationContext(),"Please Give Rating to Satisfaction with family relationship!!",Toast.LENGTH_LONG).show();
		}
		else if(tvSatisfactionWithWork.getText()==""){
			Toast.makeText(getApplicationContext(),"Please Give Rating to Satisfaction with work life balance!!",Toast.LENGTH_LONG).show();
		}
		else if(tvSpiritualLevel.getText()==""){
			Toast.makeText(getApplicationContext(),"Please Give Rating to Spirituality level!!",Toast.LENGTH_LONG).show();
		}
		else if(tvPrayerRecitation.getText()==""){
			Toast.makeText(getApplicationContext(),"Please Give Rating to Prayer recitation !!",Toast.LENGTH_LONG).show();
		}
		else if(tvMeditation.getText()==""){
			Toast.makeText(getApplicationContext(),"Please Give Rating to Meditation!!",Toast.LENGTH_LONG).show();
		}
		else if(tvPositiveEmotions.getText()==""){
			Toast.makeText(getApplicationContext(),"Please Give Rating to Positive emotions (calmness compassion forgiveness contentment generosity)!!",Toast.LENGTH_LONG).show();
		}
		else if(tvNegativeEmotions.getText()==""){
			Toast.makeText(getApplicationContext(),"Please Give Rating to Negative emotions (selfishness,jealousy,fear,worry,anger)!!",Toast.LENGTH_LONG).show();
		}
		else if(tvWorkingHours.getText()==""){
			Toast.makeText(getApplicationContext(),"Please Give Rating to Working hours!!",Toast.LENGTH_LONG).show();
		}
		else if(tvSleepingHours.getText()==""){
			Toast.makeText(getApplicationContext(),"Please Give Rating to Sleeping hours!!",Toast.LENGTH_LONG).show();
		}
		else if(tvTimeSpenttoTravel.getText()==""){
			Toast.makeText(getApplicationContext(),"Please Give Rating to Time spent to travel to workplace, non productive work etc!!",Toast.LENGTH_LONG).show();
		}
		else if(tvTimeSpentonHobbies.getText()==""){
			Toast.makeText(getApplicationContext(),"Please Give Rating to Time spent on hobbies!!",Toast.LENGTH_LONG).show();
		}
		else{
			Intent i =new Intent(getApplicationContext(),Health_MainForm.class);
			startActivity(i);
			finish();
		}
	}
	private class MyAsyncTask extends AsyncTask<String, Integer, Double>{
		protected Double doInBackground(String... params) 
		{
			// TODO Auto-generated method stub
			postData(params[0],params[1],params[2],params[3],params[4],params[5],params[6],params[7],params[8],
					 params[9],params[10],params[11],params[12],params[13]);
			return null;
		}
		protected void onPostExecute(Double result)
		{	
		}
 
		public void postData(String SatisfactionWithHealth,String SatisfactionWithSoL,String SatisfactionWithOccupation,
				             String SatisfactionWithFamily,String SatisfactionWithWork,String SpiritualLevel,String PrayerRecitation,
				             String Meditation,String PositiveEmotions,String NegativeEmotions,
				             String WorkingHours,String SleepingHours,String TimeSpenttoTravel,String TimeSpentonHobbies)
		{
			// Create a new HttpClient and Post Header
			HttpClient httpclient = new DefaultHttpClient();
			HttpPost httppost = new HttpPost("http://www.comdevindex.0fees.us/Peace_of_Mind.php");
 
			try {
				// Add your data
				List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
				nameValuePairs.add(new BasicNameValuePair("SatisfactionWithHealth",SatisfactionWithHealth));
				nameValuePairs.add(new BasicNameValuePair("SatisfactionWithSoL",SatisfactionWithOccupation));
				nameValuePairs.add(new BasicNameValuePair("SatisfactionWithOccupation",SatisfactionWithOccupation));
				nameValuePairs.add(new BasicNameValuePair("SatisfactionWithFamily",SatisfactionWithFamily));
				nameValuePairs.add(new BasicNameValuePair("SatisfactionWithWork",SatisfactionWithWork));
				nameValuePairs.add(new BasicNameValuePair("SpiritualLevel",SpiritualLevel));
				nameValuePairs.add(new BasicNameValuePair("PrayerRecitation",PrayerRecitation));
				nameValuePairs.add(new BasicNameValuePair("Meditation",Meditation));
				nameValuePairs.add(new BasicNameValuePair("PositiveEmotions",PositiveEmotions));
				nameValuePairs.add(new BasicNameValuePair("NegativeEmotions",NegativeEmotions));
				nameValuePairs.add(new BasicNameValuePair("WorkingHours",WorkingHours));
				nameValuePairs.add(new BasicNameValuePair("SleepingHours",SleepingHours));
				nameValuePairs.add(new BasicNameValuePair("TimeSpenttoTravel",TimeSpenttoTravel));
				nameValuePairs.add(new BasicNameValuePair("TimeSpentonHobbies",TimeSpentonHobbies));
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

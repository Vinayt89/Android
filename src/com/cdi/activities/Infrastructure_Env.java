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

public class Infrastructure_Env extends Activity {
	
	SeekBar sbAvailabilityofWaterSupply,sbQualityofWater,sbAvgCostofQualityofWater,sbAvailabilityofElectricity,
	sbAdequecyofParks,sbAdequecyofPlaygrounds,sbQualityofRoads,sbPresenceofFoothpath,sbConditionofFoothpath,
	sbPresenceofParkingSpace,sbSafetyofPedestrains,sbPresenceofStreetlightning,sbCoverageofPublicTransport,sbFrequencyandTimingofBuses,sbAvgCostPerKm,sbCrowdinginPublicTransport,sbCultureDiversityandRespect,sbPeaceandHarmony;
	int progress=0; 
	TextView tvAvailabilityofWaterSupply,tvQualityofWater,tvAvgCostofQualityofWater,tvAvailabilityofElectricity,
	tvAdequecyofParks,tvAdequecyofPlaygrounds,tvQualityofRoads,tvPresenceofFoothpath,tvConditionofFoothpath,
	tvPresenceofParkingSpace,tvSafetyofPedestrains,tvPresenceofStreetlightning,tvCoverageofPublicTransport,tvFrequencyandTimingofBuses,tvAvgCostPerKm,tvCrowdinginPublicTransport,tvCultureDiversityandRespect,tvPeaceandHarmony;
	
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.form5);
		
		references();
		seekBarImplementation();
		
		Button btnBack=(Button)findViewById(R.id.btnBack);
		Button btnNext=(Button)findViewById(R.id.btnNext);
		
		btnBack.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i=new Intent(getApplicationContext(),Infrastructure_Env_MainForm.class);
				startActivity(i);	
			}
		});
		btnNext.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				validation();
				new MyAsyncTask().execute(tvAvailabilityofWaterSupply.getText().toString(),tvQualityofWater.getText().toString(),tvAvgCostofQualityofWater.getText().toString(),tvAvailabilityofElectricity.getText().toString(),
										  tvAdequecyofParks.getText().toString(),tvAdequecyofPlaygrounds.getText().toString(),tvQualityofRoads.getText().toString(),tvPresenceofFoothpath.getText().toString(),tvConditionofFoothpath.getText().toString(),
										  tvPresenceofParkingSpace.getText().toString(),tvSafetyofPedestrains.getText().toString(),tvPresenceofStreetlightning.getText().toString(),tvCoverageofPublicTransport.getText().toString(),
										  tvFrequencyandTimingofBuses.getText().toString(),tvAvgCostPerKm.getText().toString(),tvCrowdinginPublicTransport.getText().toString(),tvCultureDiversityandRespect.getText().toString(),tvPeaceandHarmony.getText().toString());
				}
		});
	}
	public void references(){
		sbAvailabilityofWaterSupply=(SeekBar)findViewById(R.id.sbAvailabilityofWaterSupply);
		sbQualityofWater=(SeekBar)findViewById(R.id.sbQualityofWater);
		sbAvgCostofQualityofWater=(SeekBar)findViewById(R.id.sbAvgCostofQualityofWater);
		sbAvailabilityofElectricity=(SeekBar)findViewById(R.id.sbAvailabilityofElectricity);
		sbAdequecyofParks=(SeekBar)findViewById(R.id.sbAdequecyofParks);
		sbAdequecyofPlaygrounds=(SeekBar)findViewById(R.id.sbAdequecyofPlaygrounds);
		sbQualityofRoads=(SeekBar)findViewById(R.id.sbQualityofRoads);
		sbPresenceofFoothpath=(SeekBar)findViewById(R.id.sbPresenceofFoothpath);
		sbConditionofFoothpath=(SeekBar)findViewById(R.id.sbConditionofFoothpath);
		sbPresenceofParkingSpace=(SeekBar)findViewById(R.id.sbPresenceofParkingSpace);
		sbSafetyofPedestrains=(SeekBar)findViewById(R.id.sbSafetyofPedestrains);
		sbPresenceofStreetlightning=(SeekBar)findViewById(R.id.sbPresenceofStreetlightning);
		sbCoverageofPublicTransport=(SeekBar)findViewById(R.id.sbCoverageofPublicTransport);
		sbFrequencyandTimingofBuses=(SeekBar)findViewById(R.id.sbFrequencyandTimingofBuses);
		sbAvgCostPerKm=(SeekBar)findViewById(R.id.sbAvgCostPerKm);
		sbCrowdinginPublicTransport=(SeekBar)findViewById(R.id.sbCrowdinginPublicTransport);
		sbCultureDiversityandRespect=(SeekBar)findViewById(R.id.sbCultureDiversityandRespect);
		sbPeaceandHarmony=(SeekBar)findViewById(R.id.sbPeaceandHarmony);
		
		tvAvailabilityofWaterSupply=(TextView)findViewById(R.id.tvAvailabilityofWaterSupply);
		tvQualityofWater=(TextView)findViewById(R.id.tvQualityofWater);
		tvAvgCostofQualityofWater=(TextView)findViewById(R.id.tvAvgCostofQualityofWater);
		tvAvailabilityofElectricity=(TextView)findViewById(R.id.tvAvailabilityofElectricity);
		tvAdequecyofParks=(TextView)findViewById(R.id.tvAdequecyofParks);
		tvAdequecyofPlaygrounds=(TextView)findViewById(R.id.tvAdequecyofPlaygrounds);
		tvQualityofRoads=(TextView)findViewById(R.id.tvQualityofRoads);
		tvPresenceofFoothpath=(TextView)findViewById(R.id.tvPresenceofFoothpath);
		tvConditionofFoothpath=(TextView)findViewById(R.id.tvConditionofFoothpath);
		tvPresenceofParkingSpace=(TextView)findViewById(R.id.tvPresenceofParkingSpace);
		tvSafetyofPedestrains=(TextView)findViewById(R.id.tvSafetyofPedestrains);
		tvPresenceofStreetlightning=(TextView)findViewById(R.id.tvPresenceofStreetlightning);
		tvCoverageofPublicTransport=(TextView)findViewById(R.id.tvCoverageofPublicTransport);
		tvFrequencyandTimingofBuses=(TextView)findViewById(R.id.tvFrequencyandTimingofBuses);
		tvAvgCostPerKm=(TextView)findViewById(R.id.tvAvgCostPerKm);
		tvCrowdinginPublicTransport=(TextView)findViewById(R.id.tvCrowdinginPublicTransport);
		tvCultureDiversityandRespect=(TextView)findViewById(R.id.tvCultureDiversityandRespect);
		tvPeaceandHarmony=(TextView)findViewById(R.id.tvPeaceandHarmony);
	}
	public void seekBarImplementation(){
		sbAvailabilityofWaterSupply.setOnSeekBarChangeListener(new OnSeekBarChangeListener() 
		{
			public void onStopTrackingTouch(SeekBar seekBar){
				tvAvailabilityofWaterSupply.setText(progress + "/" + seekBar.getMax());
			}
			public void onStartTrackingTouch(SeekBar arg0){}
			public void onProgressChanged(SeekBar seekBar,int progresValue, boolean fromUser){
				 progress = progresValue;
			}
		});
		sbQualityofWater.setOnSeekBarChangeListener(new OnSeekBarChangeListener() 
		{
			public void onStopTrackingTouch(SeekBar seekBar){
				tvQualityofWater.setText(progress + "/" + seekBar.getMax());
			}
			public void onStartTrackingTouch(SeekBar arg0){}
			public void onProgressChanged(SeekBar seekBar,int progresValue, boolean fromUser){
				 progress = progresValue;
			}
		});
		sbAvgCostofQualityofWater.setOnSeekBarChangeListener(new OnSeekBarChangeListener() 
		{
			public void onStopTrackingTouch(SeekBar seekBar){
				tvAvgCostofQualityofWater.setText(progress + "/" + seekBar.getMax());
			}
			public void onStartTrackingTouch(SeekBar arg0){}
			public void onProgressChanged(SeekBar seekBar,int progresValue, boolean fromUser){
				 progress = progresValue;
			}
		});
		sbAvailabilityofElectricity.setOnSeekBarChangeListener(new OnSeekBarChangeListener() 
		{
			public void onStopTrackingTouch(SeekBar seekBar){
				tvAvailabilityofElectricity.setText(progress + "/" + seekBar.getMax());
			}
			public void onStartTrackingTouch(SeekBar arg0){}
			public void onProgressChanged(SeekBar seekBar,int progresValue, boolean fromUser){
				 progress = progresValue;
			}
		});
		sbAdequecyofParks.setOnSeekBarChangeListener(new OnSeekBarChangeListener() 
		{
			public void onStopTrackingTouch(SeekBar seekBar){
				tvAdequecyofParks.setText(progress + "/" + seekBar.getMax());
			}
			public void onStartTrackingTouch(SeekBar arg0){}
			public void onProgressChanged(SeekBar seekBar,int progresValue, boolean fromUser){
				 progress = progresValue;
			}
		});
		sbAdequecyofPlaygrounds.setOnSeekBarChangeListener(new OnSeekBarChangeListener() 
		{
			public void onStopTrackingTouch(SeekBar seekBar){
				tvAdequecyofPlaygrounds.setText(progress + "/" + seekBar.getMax());
			}
			public void onStartTrackingTouch(SeekBar arg0){}
			public void onProgressChanged(SeekBar seekBar,int progresValue, boolean fromUser){
				 progress = progresValue;
			}
		});
		sbQualityofRoads.setOnSeekBarChangeListener(new OnSeekBarChangeListener() 
		{
			public void onStopTrackingTouch(SeekBar seekBar){
				tvQualityofRoads.setText(progress + "/" + seekBar.getMax());
			}
			public void onStartTrackingTouch(SeekBar arg0){}
			public void onProgressChanged(SeekBar seekBar,int progresValue, boolean fromUser){
				 progress = progresValue;
			}
		});
		sbPresenceofFoothpath.setOnSeekBarChangeListener(new OnSeekBarChangeListener() 
		{
			public void onStopTrackingTouch(SeekBar seekBar){
				tvPresenceofFoothpath.setText(progress + "/" + seekBar.getMax());
			}
			public void onStartTrackingTouch(SeekBar arg0){}
			public void onProgressChanged(SeekBar seekBar,int progresValue, boolean fromUser){
				 progress = progresValue;
			}
		});
		sbConditionofFoothpath.setOnSeekBarChangeListener(new OnSeekBarChangeListener() 
		{
			public void onStopTrackingTouch(SeekBar seekBar){
				tvConditionofFoothpath.setText(progress + "/" + seekBar.getMax());
			}
			public void onStartTrackingTouch(SeekBar arg0){}
			public void onProgressChanged(SeekBar seekBar,int progresValue, boolean fromUser){
				 progress = progresValue;
			}
		});
		sbPresenceofParkingSpace.setOnSeekBarChangeListener(new OnSeekBarChangeListener() 
		{
			public void onStopTrackingTouch(SeekBar seekBar){
				tvPresenceofParkingSpace.setText(progress + "/" + seekBar.getMax());
			}
			public void onStartTrackingTouch(SeekBar arg0){}
			public void onProgressChanged(SeekBar seekBar,int progresValue, boolean fromUser){
				 progress = progresValue;
			}
		});
		sbSafetyofPedestrains.setOnSeekBarChangeListener(new OnSeekBarChangeListener() 
		{
			public void onStopTrackingTouch(SeekBar seekBar){
				tvSafetyofPedestrains.setText(progress + "/" + seekBar.getMax());
			}
			public void onStartTrackingTouch(SeekBar arg0){}
			public void onProgressChanged(SeekBar seekBar,int progresValue, boolean fromUser){
				 progress = progresValue;
			}
		});
		sbPresenceofStreetlightning.setOnSeekBarChangeListener(new OnSeekBarChangeListener() 
		{
			public void onStopTrackingTouch(SeekBar seekBar){
				tvPresenceofStreetlightning.setText(progress + "/" + seekBar.getMax());
			}
			public void onStartTrackingTouch(SeekBar arg0){}
			public void onProgressChanged(SeekBar seekBar,int progresValue, boolean fromUser){
				 progress = progresValue;
			}
		});
		sbCoverageofPublicTransport.setOnSeekBarChangeListener(new OnSeekBarChangeListener() 
		{
			public void onStopTrackingTouch(SeekBar seekBar){
				tvCoverageofPublicTransport.setText(progress + "/" + seekBar.getMax());
			}
			public void onStartTrackingTouch(SeekBar arg0){}
			public void onProgressChanged(SeekBar seekBar,int progresValue, boolean fromUser){
				 progress = progresValue;
			}
		});
		sbFrequencyandTimingofBuses.setOnSeekBarChangeListener(new OnSeekBarChangeListener() 
		{
			public void onStopTrackingTouch(SeekBar seekBar){
				tvFrequencyandTimingofBuses.setText(progress + "/" + seekBar.getMax());
			}
			public void onStartTrackingTouch(SeekBar arg0){}
			public void onProgressChanged(SeekBar seekBar,int progresValue, boolean fromUser){
				 progress = progresValue;
			}
		});
		sbAvgCostPerKm.setOnSeekBarChangeListener(new OnSeekBarChangeListener() 
		{
			public void onStopTrackingTouch(SeekBar seekBar){
				tvAvgCostPerKm.setText(progress + "/" + seekBar.getMax());
			}
			public void onStartTrackingTouch(SeekBar arg0){}
			public void onProgressChanged(SeekBar seekBar,int progresValue, boolean fromUser){
				 progress = progresValue;
			}
		});
		sbCrowdinginPublicTransport.setOnSeekBarChangeListener(new OnSeekBarChangeListener() 
		{
			public void onStopTrackingTouch(SeekBar seekBar){
				tvCrowdinginPublicTransport.setText(progress + "/" + seekBar.getMax());
			}
			public void onStartTrackingTouch(SeekBar arg0){}
			public void onProgressChanged(SeekBar seekBar,int progresValue, boolean fromUser){
				 progress = progresValue;
			}
		});
		sbCultureDiversityandRespect.setOnSeekBarChangeListener(new OnSeekBarChangeListener() 
		{
			public void onStopTrackingTouch(SeekBar seekBar){
				tvCultureDiversityandRespect.setText(progress + "/" + seekBar.getMax());
			}
			public void onStartTrackingTouch(SeekBar arg0){}
			public void onProgressChanged(SeekBar seekBar,int progresValue, boolean fromUser){
				 progress = progresValue;
			}
		});
		sbPeaceandHarmony.setOnSeekBarChangeListener(new OnSeekBarChangeListener() 
		{
			public void onStopTrackingTouch(SeekBar seekBar){
				tvPeaceandHarmony.setText(progress + "/" + seekBar.getMax());
			}
			public void onStartTrackingTouch(SeekBar arg0){}
			public void onProgressChanged(SeekBar seekBar,int progresValue, boolean fromUser){
				 progress = progresValue;
			}
		});
	}
	public void validation(){
		
		if(tvAvailabilityofWaterSupply.getText()==""){
			Toast.makeText(getApplicationContext(), "Please Give Rating to Availability of WaterSupply ", Toast.LENGTH_LONG).show();
		}
		else if(tvQualityofWater.getText()==""){
			Toast.makeText(getApplicationContext(), "Please Give Rating to Quality of Water!!", Toast.LENGTH_LONG).show();
		}
		else if(tvAvgCostofQualityofWater.getText()==""){
			Toast.makeText(getApplicationContext(), "Please Give Rating to Avgerage Cost of Quality of Water!!", Toast.LENGTH_LONG).show();
		}
		else if(tvAvailabilityofElectricity.getText()==""){
			Toast.makeText(getApplicationContext(), "Please Give Rating to Availability of Electricity!!", Toast.LENGTH_LONG).show();
		}
		else if(tvAdequecyofParks.getText()==""){
			Toast.makeText(getApplicationContext(), "Please Give Rating to Adequecy of Parks!!", Toast.LENGTH_LONG).show();
		}
		else if(tvAdequecyofPlaygrounds.getText()==""){
			Toast.makeText(getApplicationContext(), "Please Give Rating to Adequecy of Playgrounds!!", Toast.LENGTH_LONG).show();
		}
		else if(tvQualityofRoads.getText()==""){
			Toast.makeText(getApplicationContext(), "Please Give Rating to Quality of Roads!!", Toast.LENGTH_LONG).show();
		}
		else if(tvPresenceofFoothpath.getText()==""){
			Toast.makeText(getApplicationContext(), "Please Give Rating to Presence of Foothpath!!", Toast.LENGTH_LONG).show();
		}
		else if(tvConditionofFoothpath.getText()==""){
			Toast.makeText(getApplicationContext(), "Please Give Rating to Condition of Foothpath!!", Toast.LENGTH_LONG).show();
		}
		else if(tvPresenceofParkingSpace.getText()==""){
			Toast.makeText(getApplicationContext(), "Please Give Rating to Presence of Parking Space!!", Toast.LENGTH_LONG).show();
		}
		else if(tvSafetyofPedestrains.getText()==""){
			Toast.makeText(getApplicationContext(), "Please Give Rating to Safety of Pedestrains!!", Toast.LENGTH_LONG).show();
		}
		else if(tvPresenceofStreetlightning.getText()==""){
			Toast.makeText(getApplicationContext(), "Please Give Rating to Presence of Streetlightning!!", Toast.LENGTH_LONG).show();
		}
		else if(tvCoverageofPublicTransport.getText()==""){
			Toast.makeText(getApplicationContext(), "Please Give Rating to Culture Coverage of Public Transport!!", Toast.LENGTH_LONG).show();
		}
		else if(tvFrequencyandTimingofBuses.getText()==""){
			Toast.makeText(getApplicationContext(), "Please Give Rating to Culture Frequency and Timing of Buses!!", Toast.LENGTH_LONG).show();
		}
		else if(tvAvgCostPerKm.getText()==""){
			Toast.makeText(getApplicationContext(), "Please Give Rating to Culture Avg Cost Per KM!!", Toast.LENGTH_LONG).show();
		}
		else if(tvCrowdinginPublicTransport.getText()==""){
			Toast.makeText(getApplicationContext(), "Please Give Rating to Culture Crowding in Public Transport!!", Toast.LENGTH_LONG).show();
		}
		else if(tvCultureDiversityandRespect.getText()==""){
			Toast.makeText(getApplicationContext(), "Please Give Rating to Culture Diversity and Respect!!", Toast.LENGTH_LONG).show();
		}
		else if(tvPeaceandHarmony.getText()==""){
			Toast.makeText(getApplicationContext(), "Please Give Rating to Peace and Harmony!! ", Toast.LENGTH_LONG).show();
		}
		else{
			Intent i=new Intent(getApplicationContext(),Governance_MainForm.class);
			startActivity(i);
			finish();	
		}
		

	}
	private class MyAsyncTask extends AsyncTask<String, Integer, Double>{
		protected Double doInBackground(String... params) 
		{
			// TODO Auto-generated method stub
			postData(params[0],params[1],params[2],params[3],params[4],params[5],params[6],params[7],params[8],params[9],params[10],params[11],params[12],params[13],params[14],params[15],params[16],params[17]);
			return null;
		}
		protected void onPostExecute(Double result)
		{	
		}
 
		public void postData(String AvailabilityofWaterSupply,String QualityofWater,String AvgCostofQualityofWater,String AvailabilityofElectricity,String AdequecyofParks,
							 String AdequecyofPlaygrounds,String QualityofRoads,String PresenceofFoothpath,String ConditionofFoothpath,String PresenceofParkingSpace,
							 String SafetyofPedestrains,String PresenceofStreetlightning,String CoverageofPublicTransport,String FrequencyandTimingofBuses,String AvgCostPerKm,
							 String CrowdinginPublicTransport,String CultureDiversityandRespect,String PeaceandHarmony)
		{
			// Create a new HttpClient and Post Header
			HttpClient httpclient = new DefaultHttpClient();
			HttpPost httppost = new HttpPost("http://www.comdevindex.0fees.us/Infrastructure_Env.php");
 
			try {
				// Add your data
			
				List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
				nameValuePairs.add(new BasicNameValuePair("AvailabilityofWaterSupply",AvailabilityofWaterSupply));
				nameValuePairs.add(new BasicNameValuePair("QualityofWater",QualityofWater));
				nameValuePairs.add(new BasicNameValuePair("AvgCostofQualityofWater",AvgCostofQualityofWater));
				nameValuePairs.add(new BasicNameValuePair("AvailabilityofElectricity",AvailabilityofElectricity));
				nameValuePairs.add(new BasicNameValuePair("AdequecyofParks",AdequecyofParks));
				nameValuePairs.add(new BasicNameValuePair("AdequecyofPlaygrounds",AdequecyofPlaygrounds));
				nameValuePairs.add(new BasicNameValuePair("QualityofRoads",QualityofRoads));
				nameValuePairs.add(new BasicNameValuePair("PresenceofFoothpath",PresenceofFoothpath));
				nameValuePairs.add(new BasicNameValuePair("ConditionofFoothpath",ConditionofFoothpath));
				nameValuePairs.add(new BasicNameValuePair("PresenceofParkingSpace",PresenceofParkingSpace));
				nameValuePairs.add(new BasicNameValuePair("SafetyofPedestrains",SafetyofPedestrains));
				nameValuePairs.add(new BasicNameValuePair("PresenceofStreetlightning",PresenceofStreetlightning));				
				nameValuePairs.add(new BasicNameValuePair("CoverageofPublicTransport",CoverageofPublicTransport));
				nameValuePairs.add(new BasicNameValuePair("FrequencyandTimingofBuses",FrequencyandTimingofBuses));
				nameValuePairs.add(new BasicNameValuePair("AvgCostPerKm",AvgCostPerKm));
				nameValuePairs.add(new BasicNameValuePair("CrowdinginPublicTransport",CrowdinginPublicTransport));
				nameValuePairs.add(new BasicNameValuePair("CultureDiversityandRespect",CultureDiversityandRespect));
				nameValuePairs.add(new BasicNameValuePair("PeaceandHarmony",PeaceandHarmony));
				
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

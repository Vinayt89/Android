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

public class Governance extends Activity {
	
	SeekBar sbCreatingJobs,sbReducingGapBetwnRichandPoor,sbFightingCorruption,sbPreservingCultureandTraditions,
	sbProtectingEnv,sbProvidingEducationalNeeds,sbImprovingHeathService,sbPreservationofCulturalHeritage,
	sbRightandSpeachOpinion,sbRighttoVote,sbRighttoJoinPolitics,sbFreeFromDiscremination,sbConditonsofGovtSchools,sbWasteDisposalMethods,sbConditonsofGovtHospitals,
	sbSchemesforPoorPeoples,sbGovtPerformanceinCrisisMgmt;
	int progress=0;
	TextView tvCreatingJobs,tvReducingGapBetwnRichandPoor,tvFightingCorruption,tvPreservingCultureandTraditions,
	tvProtectingEnv,tvProvidingEducationalNeeds,tvImprovingHeathService,tvPreservationofCulturalHeritage,
	tvRightandSpeachOpinion,tvRighttoVote,tvRighttoJoinPolitics,tvFreeFromDiscremination,tvConditonsofGovtSchools,tvWasteDisposalMethods,tvConditonsofGovtHospitals,
	tvSchemesforPoorPeoples,tvGovtPerformanceinCrisisMgmt;
	
	Button btnNext,btnBack;
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.form6);
		
		references();
		seekBarImplementation();
		
		btnBack=(Button)findViewById(R.id.btnBack);
		btnNext=(Button)findViewById(R.id.btnNext);
		
		btnBack.setOnClickListener(new View.OnClickListener() {
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				Intent i=new Intent(getApplicationContext(),Infrastructure_Env.class);
				startActivity(i);
			}
		});
		
		btnNext.setOnClickListener(new View.OnClickListener() {
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				validation();
				new MyAsyncTask().execute(tvCreatingJobs.getText().toString(),tvReducingGapBetwnRichandPoor.getText().toString(),tvFightingCorruption.getText().toString(),tvPreservingCultureandTraditions.getText().toString(),
										  tvProtectingEnv.getText().toString(),tvProvidingEducationalNeeds.getText().toString(),tvImprovingHeathService.getText().toString(),tvPreservationofCulturalHeritage.getText().toString(),
										  tvRightandSpeachOpinion.getText().toString(),tvRighttoVote.getText().toString(),tvRighttoJoinPolitics.getText().toString(),tvFreeFromDiscremination.getText().toString(),tvConditonsofGovtSchools.getText().toString(),
										  tvWasteDisposalMethods.getText().toString(),tvConditonsofGovtHospitals.getText().toString(),tvSchemesforPoorPeoples.getText().toString(),tvGovtPerformanceinCrisisMgmt.getText().toString());
			}
		});
	}
	public void references(){
		
		tvCreatingJobs=(TextView)findViewById(R.id.tvCreatingJobs);
		tvReducingGapBetwnRichandPoor=(TextView)findViewById(R.id.tvReducingGapBetwnRichandPoor);
		tvFightingCorruption=(TextView)findViewById(R.id.tvFightingCorruption);
		tvPreservingCultureandTraditions=(TextView)findViewById(R.id.tvPreservingCultureandTraditions);
		tvProtectingEnv=(TextView)findViewById(R.id.tvProtectingEnv);
		tvProvidingEducationalNeeds=(TextView)findViewById(R.id.tvProvidingEducationalNeeds);
		tvImprovingHeathService=(TextView)findViewById(R.id.tvImprovingHeathService);
		tvPreservationofCulturalHeritage=(TextView)findViewById(R.id.tvPreservationofCulturalHeritage);
		tvRightandSpeachOpinion=(TextView)findViewById(R.id.tvRightandSpeachOpinion);
		tvRighttoVote=(TextView)findViewById(R.id.tvRighttoVote);
		tvRighttoJoinPolitics=(TextView)findViewById(R.id.tvRighttoJoinPolitics);
		tvFreeFromDiscremination=(TextView)findViewById(R.id.tvFreeFromDiscremination);
		tvConditonsofGovtSchools=(TextView)findViewById(R.id.tvConditonsofGovtSchools);
		tvWasteDisposalMethods=(TextView)findViewById(R.id.tvWasteDisposalMethods);
		tvConditonsofGovtHospitals=(TextView)findViewById(R.id.tvConditonsofGovtHospitals);
		tvSchemesforPoorPeoples=(TextView)findViewById(R.id.tvSchemesforPoorPeoples);
		tvGovtPerformanceinCrisisMgmt=(TextView)findViewById(R.id.tvGovtPerformanceinCrisisMgmt);
		
		sbCreatingJobs=(SeekBar)findViewById(R.id.sbCreatingJobs);
		sbReducingGapBetwnRichandPoor=(SeekBar)findViewById(R.id.sbReducingGapBetwnRichandPoor);
		sbFightingCorruption=(SeekBar)findViewById(R.id.sbFightingCorruption);
		sbPreservingCultureandTraditions=(SeekBar)findViewById(R.id.sbPreservingCultureandTraditions);
		sbProtectingEnv=(SeekBar)findViewById(R.id.sbProtectingEnv);
		sbProvidingEducationalNeeds=(SeekBar)findViewById(R.id.sbProvidingEducationalNeeds);
		sbImprovingHeathService=(SeekBar)findViewById(R.id.sbImprovingHeathService);
		sbPreservationofCulturalHeritage=(SeekBar)findViewById(R.id.sbPreservationofCulturalHeritage);
		sbRightandSpeachOpinion=(SeekBar)findViewById(R.id.sbRightandSpeachOpinion);
		sbRighttoVote=(SeekBar)findViewById(R.id.sbRighttoVote);
		sbRighttoJoinPolitics=(SeekBar)findViewById(R.id.sbRighttoJoinPolitics);
		sbFreeFromDiscremination=(SeekBar)findViewById(R.id.sbFreeFromDiscremination);
		sbConditonsofGovtSchools=(SeekBar)findViewById(R.id.sbConditonsofGovtSchools);
		sbWasteDisposalMethods=(SeekBar)findViewById(R.id.sbWasteDisposalMethods);
		sbConditonsofGovtHospitals=(SeekBar)findViewById(R.id.sbConditonsofGovtHospitals);
		sbSchemesforPoorPeoples=(SeekBar)findViewById(R.id.sbSchemesforPoorPeoples);
		sbGovtPerformanceinCrisisMgmt=(SeekBar)findViewById(R.id.sbGovtPerformanceinCrisisMgmt);
	}
	public void seekBarImplementation(){
		sbCreatingJobs.setOnSeekBarChangeListener(new OnSeekBarChangeListener() 
		{
			public void onStopTrackingTouch(SeekBar seekBar){
				tvCreatingJobs.setText(progress + "/" + seekBar.getMax());
			}
			public void onStartTrackingTouch(SeekBar arg0){}
			public void onProgressChanged(SeekBar seekBar,int progresValue, boolean fromUser){
				 progress = progresValue;
			}
		});
		sbReducingGapBetwnRichandPoor.setOnSeekBarChangeListener(new OnSeekBarChangeListener() 
		{
			public void onStopTrackingTouch(SeekBar seekBar){
				tvReducingGapBetwnRichandPoor.setText(progress + "/" + seekBar.getMax());
			}
			public void onStartTrackingTouch(SeekBar arg0){}
			public void onProgressChanged(SeekBar seekBar,int progresValue, boolean fromUser){
				 progress = progresValue;
			}
		});
		sbFightingCorruption.setOnSeekBarChangeListener(new OnSeekBarChangeListener() 
		{
			public void onStopTrackingTouch(SeekBar seekBar){
				tvFightingCorruption.setText(progress + "/" + seekBar.getMax());
			}
			public void onStartTrackingTouch(SeekBar arg0){}
			public void onProgressChanged(SeekBar seekBar,int progresValue, boolean fromUser){
				 progress = progresValue;
			}
		});
		sbPreservingCultureandTraditions.setOnSeekBarChangeListener(new OnSeekBarChangeListener() 
		{
			public void onStopTrackingTouch(SeekBar seekBar){
				tvPreservingCultureandTraditions.setText(progress + "/" + seekBar.getMax());
			}
			public void onStartTrackingTouch(SeekBar arg0){}
			public void onProgressChanged(SeekBar seekBar,int progresValue, boolean fromUser){
				 progress = progresValue;
			}
		});
		sbProtectingEnv.setOnSeekBarChangeListener(new OnSeekBarChangeListener() 
		{
			public void onStopTrackingTouch(SeekBar seekBar){
				tvProtectingEnv.setText(progress + "/" + seekBar.getMax());
			}
			public void onStartTrackingTouch(SeekBar arg0){}
			public void onProgressChanged(SeekBar seekBar,int progresValue, boolean fromUser){
				 progress = progresValue;
			}
		});
		sbProvidingEducationalNeeds.setOnSeekBarChangeListener(new OnSeekBarChangeListener() 
		{
			public void onStopTrackingTouch(SeekBar seekBar){
				tvProvidingEducationalNeeds.setText(progress + "/" + seekBar.getMax());
			}
			public void onStartTrackingTouch(SeekBar arg0){}
			public void onProgressChanged(SeekBar seekBar,int progresValue, boolean fromUser){
				 progress = progresValue;
			}
		});
		sbImprovingHeathService.setOnSeekBarChangeListener(new OnSeekBarChangeListener() 
		{
			public void onStopTrackingTouch(SeekBar seekBar){
				tvImprovingHeathService.setText(progress + "/" + seekBar.getMax());
			}
			public void onStartTrackingTouch(SeekBar arg0){}
			public void onProgressChanged(SeekBar seekBar,int progresValue, boolean fromUser){
				 progress = progresValue;
			}
		});
		sbPreservationofCulturalHeritage.setOnSeekBarChangeListener(new OnSeekBarChangeListener() 
		{
			public void onStopTrackingTouch(SeekBar seekBar){
				tvPreservationofCulturalHeritage.setText(progress + "/" + seekBar.getMax());
			}
			public void onStartTrackingTouch(SeekBar arg0){}
			public void onProgressChanged(SeekBar seekBar,int progresValue, boolean fromUser){
				 progress = progresValue;
			}
		});
		sbRightandSpeachOpinion.setOnSeekBarChangeListener(new OnSeekBarChangeListener() 
		{
			public void onStopTrackingTouch(SeekBar seekBar){
				tvRightandSpeachOpinion.setText(progress + "/" + seekBar.getMax());
			}
			public void onStartTrackingTouch(SeekBar arg0){}
			public void onProgressChanged(SeekBar seekBar,int progresValue, boolean fromUser){
				 progress = progresValue;
			}
		});
		sbRighttoVote.setOnSeekBarChangeListener(new OnSeekBarChangeListener() 
		{
			public void onStopTrackingTouch(SeekBar seekBar){
				tvRighttoVote.setText(progress + "/" + seekBar.getMax());
			}
			public void onStartTrackingTouch(SeekBar arg0){}
			public void onProgressChanged(SeekBar seekBar,int progresValue, boolean fromUser){
				 progress = progresValue;
			}
		});
		sbRighttoJoinPolitics.setOnSeekBarChangeListener(new OnSeekBarChangeListener() 
		{
			public void onStopTrackingTouch(SeekBar seekBar){
				tvRighttoJoinPolitics.setText(progress + "/" + seekBar.getMax());
			}
			public void onStartTrackingTouch(SeekBar arg0){}
			public void onProgressChanged(SeekBar seekBar,int progresValue, boolean fromUser){
				 progress = progresValue;
			}
		});
		sbFreeFromDiscremination.setOnSeekBarChangeListener(new OnSeekBarChangeListener() 
		{
			public void onStopTrackingTouch(SeekBar seekBar){
				tvFreeFromDiscremination.setText(progress + "/" + seekBar.getMax());
			}
			public void onStartTrackingTouch(SeekBar arg0){}
			public void onProgressChanged(SeekBar seekBar,int progresValue, boolean fromUser){
				 progress = progresValue;
			}
		});
		sbConditonsofGovtSchools.setOnSeekBarChangeListener(new OnSeekBarChangeListener() 
		{
			public void onStopTrackingTouch(SeekBar seekBar){
				tvConditonsofGovtSchools.setText(progress + "/" + seekBar.getMax());
			}
			public void onStartTrackingTouch(SeekBar arg0){}
			public void onProgressChanged(SeekBar seekBar,int progresValue, boolean fromUser){
				 progress = progresValue;
			}
		});
		sbWasteDisposalMethods.setOnSeekBarChangeListener(new OnSeekBarChangeListener() 
		{
			public void onStopTrackingTouch(SeekBar seekBar){
				tvWasteDisposalMethods.setText(progress + "/" + seekBar.getMax());
			}
			public void onStartTrackingTouch(SeekBar arg0){}
			public void onProgressChanged(SeekBar seekBar,int progresValue, boolean fromUser){
				 progress = progresValue;
			}
		});
		sbConditonsofGovtHospitals.setOnSeekBarChangeListener(new OnSeekBarChangeListener() 
		{
			public void onStopTrackingTouch(SeekBar seekBar){
				tvConditonsofGovtHospitals.setText(progress + "/" + seekBar.getMax());
			}
			public void onStartTrackingTouch(SeekBar arg0){}
			public void onProgressChanged(SeekBar seekBar,int progresValue, boolean fromUser){
				 progress = progresValue;
			}
		});
		sbSchemesforPoorPeoples.setOnSeekBarChangeListener(new OnSeekBarChangeListener() 
		{
			public void onStopTrackingTouch(SeekBar seekBar){
				tvSchemesforPoorPeoples.setText(progress + "/" + seekBar.getMax());
			}
			public void onStartTrackingTouch(SeekBar arg0){}
			public void onProgressChanged(SeekBar seekBar,int progresValue, boolean fromUser){
				 progress = progresValue;
			}
		});
		sbGovtPerformanceinCrisisMgmt.setOnSeekBarChangeListener(new OnSeekBarChangeListener() 
		{
			public void onStopTrackingTouch(SeekBar seekBar){
				tvGovtPerformanceinCrisisMgmt.setText(progress + "/" + seekBar.getMax());
			}
			public void onStartTrackingTouch(SeekBar arg0){}
			public void onProgressChanged(SeekBar seekBar,int progresValue, boolean fromUser){
				 progress = progresValue;
			}
		});
		
	}
	public void validation(){
		
		if(tvCreatingJobs.getText()==""){
			Toast.makeText(getApplicationContext(), "Please Give Rating to Creating Jobs!!",Toast.LENGTH_LONG).show();
		}
		else if(tvReducingGapBetwnRichandPoor.getText()==""){
			Toast.makeText(getApplicationContext(), "Please Give Rating to Reducing Gap Between Rich and Poor!!",Toast.LENGTH_LONG).show();
		}
		else if(tvFightingCorruption.getText()==""){
			Toast.makeText(getApplicationContext(), "Please Give Rating to Fighting Corruption!!",Toast.LENGTH_LONG).show();
		}
		else if(tvPreservingCultureandTraditions.getText()==""){
			Toast.makeText(getApplicationContext(), "Please Give Rating to Preserving Culture and Traditions!!",Toast.LENGTH_LONG).show();
		}
		else if(tvProtectingEnv.getText()==""){
			Toast.makeText(getApplicationContext(), "Please Give Rating to Protecting Environment!!",Toast.LENGTH_LONG).show();
		}
		else if(tvProvidingEducationalNeeds.getText()==""){
			Toast.makeText(getApplicationContext(), "Please Give Rating to Providing Educational Needs!!",Toast.LENGTH_LONG).show();
		}
		else if(tvImprovingHeathService.getText()==""){
			Toast.makeText(getApplicationContext(), "Please Give Rating to Improving Health Service!!",Toast.LENGTH_LONG).show();
		}
		else if(tvPreservationofCulturalHeritage.getText()==""){
			Toast.makeText(getApplicationContext(), "Please Give Rating to Preservation of Cultural Heritage!!",Toast.LENGTH_LONG).show();
		}
		else if(tvRightandSpeachOpinion.getText()==""){
			Toast.makeText(getApplicationContext(), "Please Give Rating to Right and Speach Opinion!!",Toast.LENGTH_LONG).show();
		}
		else if(tvRighttoVote.getText()==""){
			Toast.makeText(getApplicationContext(), "Please Give Rating to Right to Vote!!",Toast.LENGTH_LONG).show();
		}
		else if(tvRighttoJoinPolitics.getText()==""){
			Toast.makeText(getApplicationContext(), "Please Give Rating to Right to Join Politics and Services!!",Toast.LENGTH_LONG).show();
		}
		else if(tvFreeFromDiscremination.getText()==""){
			Toast.makeText(getApplicationContext(), "Please Give Rating to Free From Discremination!!",Toast.LENGTH_LONG).show();
		}
		else if(tvConditonsofGovtSchools.getText()==""){
			Toast.makeText(getApplicationContext(), "Please Give Rating to Conditons of Governmemnt Schools!!",Toast.LENGTH_LONG).show();
		}
		else if(tvWasteDisposalMethods.getText()==""){
			Toast.makeText(getApplicationContext(), "Please Give Rating to Waste Disposal Methods!!",Toast.LENGTH_LONG).show();
		}
		else if(tvConditonsofGovtHospitals.getText()==""){
			Toast.makeText(getApplicationContext(), "Please Give Rating to Conditons of Governmemnt Hospitals!!",Toast.LENGTH_LONG).show();
		}
		else if(tvSchemesforPoorPeoples.getText()==""){
			Toast.makeText(getApplicationContext(), "Please Give Rating to Schemes for Poor and People in slums!!",Toast.LENGTH_LONG).show();
		}
		else if(tvGovtPerformanceinCrisisMgmt.getText()==""){
			Toast.makeText(getApplicationContext(), "Please Give Rating to GovtPerformance in Crisis is Management!!",Toast.LENGTH_LONG).show();
		}
		else{
			Intent i=new Intent(getApplicationContext(),Community_Vitality_MainForm.class);
			startActivity(i);
			finish();
		}
		
		
	}
	private class MyAsyncTask extends AsyncTask<String, Integer, Double>{
		protected Double doInBackground(String... params) 
		{
			// TODO Auto-generated method stub
			postData(params[0],params[1],params[2],params[3],params[4],params[5],params[6],params[7],params[8],params[9],params[10],params[11],params[12],params[13],params[14],params[15],params[16]);
			return null;
		}
		protected void onPostExecute(Double result)
		{
		}
 
		public void postData(String CreatingJobs,String ReducingGapBetwnRichandPoor,String FightingCorruption,String PreservingCultureandTraditions,String ProtectingEnv,
							 String ProvidingEducationalNeeds,String ImprovingHeathService,String PreservationofCulturalHeritage,String RightandSpeachOpinion,String RighttoVote,
							 String RighttoJoinPolitics,String FreeFromDiscremination,String ConditonsofGovtSchools,String WasteDisposalMethods,String ConditonsofGovtHospitals ,String SchemesforPoorPeoples,String GovtPerformanceinCrisisMgmt)
		{
			// Create a new HttpClient and Post Header
			HttpClient httpclient = new DefaultHttpClient();
			HttpPost httppost = new HttpPost("http://www.comdevindex.0fees.us/Governance.php");
 
			try {
				// Add your data
			
				List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
				nameValuePairs.add(new BasicNameValuePair("CreatingJobs",CreatingJobs));
				nameValuePairs.add(new BasicNameValuePair("ReducingGapBetwnRichandPoor",ReducingGapBetwnRichandPoor));
				nameValuePairs.add(new BasicNameValuePair("FightingCorruption",FightingCorruption));
				nameValuePairs.add(new BasicNameValuePair("PreservingCultureandTraditions",PreservingCultureandTraditions));
				nameValuePairs.add(new BasicNameValuePair("ProtectingEnv",ProtectingEnv));
				nameValuePairs.add(new BasicNameValuePair("ProvidingEducationalNeeds",ProvidingEducationalNeeds));
				nameValuePairs.add(new BasicNameValuePair("ImprovingHeathService",ImprovingHeathService));
				nameValuePairs.add(new BasicNameValuePair("PreservationofCulturalHeritage",PreservationofCulturalHeritage));
				nameValuePairs.add(new BasicNameValuePair("RightandSpeachOpinion",RightandSpeachOpinion));
				nameValuePairs.add(new BasicNameValuePair("RighttoVote",RighttoVote));
				nameValuePairs.add(new BasicNameValuePair("RighttoJoinPolitics",RighttoJoinPolitics));
				nameValuePairs.add(new BasicNameValuePair("FreeFromDiscremination",FreeFromDiscremination));
				nameValuePairs.add(new BasicNameValuePair("ConditonsofGovtSchools",ConditonsofGovtSchools));
				nameValuePairs.add(new BasicNameValuePair("WasteDisposalMethods",WasteDisposalMethods));
				nameValuePairs.add(new BasicNameValuePair("ConditonsofGovtHospitals",ConditonsofGovtHospitals));
				nameValuePairs.add(new BasicNameValuePair("SchemesforPoorPeoples",SchemesforPoorPeoples));
				nameValuePairs.add(new BasicNameValuePair("GovtPerformanceinCrisisMgmt",GovtPerformanceinCrisisMgmt));
				
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
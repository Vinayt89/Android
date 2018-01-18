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

public class Education extends Activity {
	
	SeekBar sbLitracyLevel,sbFemaleLitracyLevel,sbFormalEducationLevel,sbNoofSchools,sbTeacherStudentRation,
	sbKnowledgeOnLaw,sbKnowledgeonHealthandFitness,sbKnowledgeOnLocalCulture,sbKilling,sbStealing,sbLying,sbCreatingDisharmony,sbSexualMisconduct;
	int progress=0;
	TextView tvLitracyLevel,tvFemaleLitracyLevel,tvFormalEducationLevel,tvNoofSchools,tvTeacherStudentRation,
	tvKnowledgeOnLaw,tvKnowledgeonHealthandFitness,tvKnowledgeOnLocalCulture,tvKilling,tvStealing,tvLying,tvCreatingDisharmony,tvSexualMisconduct;
	Button btnNext,btnBack;
	
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.form3);
		
		references();
		seekBarImplimentation();
		
		btnBack=(Button)findViewById(R.id.btnBack);
		btnNext=(Button)findViewById(R.id.btnNext);
		
		btnBack.setOnClickListener(new View.OnClickListener() {
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				Intent i=new Intent(getApplicationContext(),Health.class);
				startActivity(i);
				
			}
		});
		
		btnNext.setOnClickListener(new View.OnClickListener() {
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				validation();
				new MyAsyncTask().execute(tvLitracyLevel.getText().toString(),tvFemaleLitracyLevel.getText().toString(),tvFormalEducationLevel.getText().toString(),tvNoofSchools.getText().toString(),tvTeacherStudentRation.getText().toString(),
						                  tvKnowledgeOnLaw.getText().toString(),tvKnowledgeonHealthandFitness.getText().toString(),tvKnowledgeOnLocalCulture.getText().toString(),tvKilling.getText().toString(),tvStealing.getText().toString(),tvLying.getText().toString(),tvCreatingDisharmony.getText().toString(),tvSexualMisconduct.getText().toString());
			}
		});
	}
	public void references(){
		sbLitracyLevel=(SeekBar)findViewById(R.id.sbLitracyLevel);
		sbFemaleLitracyLevel=(SeekBar)findViewById(R.id.sbFemaleLitracyLevel);
		sbFormalEducationLevel=(SeekBar)findViewById(R.id.sbFormalEducationLevel);
		sbNoofSchools=(SeekBar)findViewById(R.id.sbNoofSchools);
		sbTeacherStudentRation=(SeekBar)findViewById(R.id.sbTeacherStudentRation);
		sbKnowledgeOnLaw=(SeekBar)findViewById(R.id.sbKnowledgeOnLaw);
		sbKnowledgeonHealthandFitness=(SeekBar)findViewById(R.id.sbKnowledgeonHealthandFitness);
		sbKnowledgeOnLocalCulture=(SeekBar)findViewById(R.id.sbKnowledgeOnLocalCulture);
		sbKilling=(SeekBar)findViewById(R.id.sbKilling);
		sbStealing=(SeekBar)findViewById(R.id.sbStealing);
		sbLying=(SeekBar)findViewById(R.id.sbLying);
		sbCreatingDisharmony=(SeekBar)findViewById(R.id.sbCreatingDisharmony);
		sbSexualMisconduct=(SeekBar)findViewById(R.id.sbSexualMisconduct);
		
		tvLitracyLevel=(TextView)findViewById(R.id.tvLitracyLevel);
		tvFemaleLitracyLevel=(TextView)findViewById(R.id.tvFemaleLitracyLevel);
		tvFormalEducationLevel=(TextView)findViewById(R.id.tvFormalEducationLevel);
		tvNoofSchools=(TextView)findViewById(R.id.tvNoofSchools);
		tvTeacherStudentRation=(TextView)findViewById(R.id.tvTeacherStudentRation);
		tvKnowledgeOnLaw=(TextView)findViewById(R.id.tvKnowledgeOnLaw);
		tvKnowledgeonHealthandFitness=(TextView)findViewById(R.id.tvKnowledgeonHealthandFitness);
		tvKnowledgeOnLocalCulture=(TextView)findViewById(R.id.tvKnowledgeOnLocalCulture);
		tvKilling=(TextView)findViewById(R.id.tvKilling);
		tvStealing=(TextView)findViewById(R.id.tvStealing);
		tvLying=(TextView)findViewById(R.id.tvLying);
		tvCreatingDisharmony=(TextView)findViewById(R.id.tvCreatingDisharmony);
		tvSexualMisconduct=(TextView)findViewById(R.id.tvSexualMisconduct);
	}
	public void seekBarImplimentation() {
		sbLitracyLevel.setOnSeekBarChangeListener(new OnSeekBarChangeListener() 
		{
			public void onStopTrackingTouch(SeekBar seekBar){
				tvLitracyLevel.setText(progress + "/" + seekBar.getMax());
			}
			public void onStartTrackingTouch(SeekBar arg0){}
			public void onProgressChanged(SeekBar seekBar,int progresValue, boolean fromUser){
				 progress = progresValue;
			}
		});
		sbFemaleLitracyLevel.setOnSeekBarChangeListener(new OnSeekBarChangeListener() 
		{
			public void onStopTrackingTouch(SeekBar seekBar){
				tvFemaleLitracyLevel.setText(progress + "/" + seekBar.getMax());
			}
			public void onStartTrackingTouch(SeekBar arg0){}
			public void onProgressChanged(SeekBar seekBar,int progresValue, boolean fromUser){
				 progress = progresValue;
			}
		});
		sbFormalEducationLevel.setOnSeekBarChangeListener(new OnSeekBarChangeListener() 
		{
			public void onStopTrackingTouch(SeekBar seekBar){
				tvFormalEducationLevel.setText(progress + "/" + seekBar.getMax());
			}
			public void onStartTrackingTouch(SeekBar arg0){}
			public void onProgressChanged(SeekBar seekBar,int progresValue, boolean fromUser){
				 progress = progresValue;
			}
		});
		sbNoofSchools.setOnSeekBarChangeListener(new OnSeekBarChangeListener() 
		{
			public void onStopTrackingTouch(SeekBar seekBar){
				tvNoofSchools.setText(progress + "/" + seekBar.getMax());
			}
			public void onStartTrackingTouch(SeekBar arg0){}
			public void onProgressChanged(SeekBar seekBar,int progresValue, boolean fromUser){
				 progress = progresValue;
			}
		});
		sbTeacherStudentRation.setOnSeekBarChangeListener(new OnSeekBarChangeListener() 
		{
			public void onStopTrackingTouch(SeekBar seekBar){
				tvTeacherStudentRation.setText(progress + "/" + seekBar.getMax());
			}
			public void onStartTrackingTouch(SeekBar arg0){}
			public void onProgressChanged(SeekBar seekBar,int progresValue, boolean fromUser){
				 progress = progresValue;
			}
		});
		sbKnowledgeOnLaw.setOnSeekBarChangeListener(new OnSeekBarChangeListener() 
		{
			public void onStopTrackingTouch(SeekBar seekBar){
				tvKnowledgeOnLaw.setText(progress + "/" + seekBar.getMax());
			}
			public void onStartTrackingTouch(SeekBar arg0){}
			public void onProgressChanged(SeekBar seekBar,int progresValue, boolean fromUser){
				 progress = progresValue;
			}
		});
		sbKnowledgeonHealthandFitness.setOnSeekBarChangeListener(new OnSeekBarChangeListener() 
		{
			public void onStopTrackingTouch(SeekBar seekBar){
				tvKnowledgeonHealthandFitness.setText(progress + "/" + seekBar.getMax());
			}
			public void onStartTrackingTouch(SeekBar arg0){}
			public void onProgressChanged(SeekBar seekBar,int progresValue, boolean fromUser){
				 progress = progresValue;
			}
		});
		sbKnowledgeOnLocalCulture.setOnSeekBarChangeListener(new OnSeekBarChangeListener() 
		{
			public void onStopTrackingTouch(SeekBar seekBar){
				tvKnowledgeOnLocalCulture.setText(progress + "/" + seekBar.getMax());
			}
			public void onStartTrackingTouch(SeekBar arg0){}
			public void onProgressChanged(SeekBar seekBar,int progresValue, boolean fromUser){
				 progress = progresValue;
			}
		});
		sbKilling.setOnSeekBarChangeListener(new OnSeekBarChangeListener() 
		{
			public void onStopTrackingTouch(SeekBar seekBar){
				tvKilling.setText(progress + "/" + seekBar.getMax());
			}
			public void onStartTrackingTouch(SeekBar arg0){}
			public void onProgressChanged(SeekBar seekBar,int progresValue, boolean fromUser){
				 progress = progresValue;
			}
		});
		sbStealing.setOnSeekBarChangeListener(new OnSeekBarChangeListener() 
		{
			public void onStopTrackingTouch(SeekBar seekBar){
				tvStealing.setText(progress + "/" + seekBar.getMax());
			}
			public void onStartTrackingTouch(SeekBar arg0){}
			public void onProgressChanged(SeekBar seekBar,int progresValue, boolean fromUser){
				 progress = progresValue;
			}
		});
		sbLying.setOnSeekBarChangeListener(new OnSeekBarChangeListener() 
		{
			public void onStopTrackingTouch(SeekBar seekBar){
				tvLying.setText(progress + "/" + seekBar.getMax());
			}
			public void onStartTrackingTouch(SeekBar arg0){}
			public void onProgressChanged(SeekBar seekBar,int progresValue, boolean fromUser){
				 progress = progresValue;
			}
		});
		sbCreatingDisharmony.setOnSeekBarChangeListener(new OnSeekBarChangeListener() 
		{
			public void onStopTrackingTouch(SeekBar seekBar){
				tvCreatingDisharmony.setText(progress + "/" + seekBar.getMax());
			}
			public void onStartTrackingTouch(SeekBar arg0){}
			public void onProgressChanged(SeekBar seekBar,int progresValue, boolean fromUser){
				 progress = progresValue;
			}
		});
		sbSexualMisconduct.setOnSeekBarChangeListener(new OnSeekBarChangeListener() 
		{
			public void onStopTrackingTouch(SeekBar seekBar){
				tvSexualMisconduct.setText(progress + "/" + seekBar.getMax());
			}
			public void onStartTrackingTouch(SeekBar arg0){}
			public void onProgressChanged(SeekBar seekBar,int progresValue, boolean fromUser){
				 progress = progresValue;
			}
		});
	}
	public void validation(){
		if(tvLitracyLevel.getText()==""){
			Toast.makeText(getApplicationContext(), "Please Give Rating to Litracy Level!!", Toast.LENGTH_LONG).show();
		}
		else if(tvFemaleLitracyLevel.getText()==""){
			Toast.makeText(getApplicationContext(), "Please Give Rating to  Female Litracy Level!!", Toast.LENGTH_LONG).show();
		}
		else if(tvFormalEducationLevel.getText()==""){
			Toast.makeText(getApplicationContext(), "Please Give Rating to Formal Education Level!!", Toast.LENGTH_LONG).show();
		}
		if(tvNoofSchools.getText()==""){
			Toast.makeText(getApplicationContext(), "Please Give Rating to No of Schools Level!!", Toast.LENGTH_LONG).show();
		}
		else if(tvTeacherStudentRation.getText()==""){
			Toast.makeText(getApplicationContext(), "Please Give Rating to Teacher Student Ration!!", Toast.LENGTH_LONG).show();
		}
		else if(tvKnowledgeOnLaw.getText()==""){
			Toast.makeText(getApplicationContext(), "Please Give Rating to Knowledge On Law!!", Toast.LENGTH_LONG).show();
		}
		else if(tvKnowledgeonHealthandFitness.getText()==""){
			Toast.makeText(getApplicationContext(), "Please Give Rating to Knowledgeon Health and Fitness!!", Toast.LENGTH_LONG).show();
		}
		else if(tvKilling.getText()==""){
			Toast.makeText(getApplicationContext(), "Please Give Rating to Killing!!", Toast.LENGTH_LONG).show();
		}
		else if(tvStealing.getText()==""){
			Toast.makeText(getApplicationContext(), "Please Give Rating to Stealing!!", Toast.LENGTH_LONG).show();
		}
		else if(tvLying.getText()==""){
			Toast.makeText(getApplicationContext(), "Please Give Rating to Lying!!", Toast.LENGTH_LONG).show();
		}
		else if(tvCreatingDisharmony.getText()==""){
			Toast.makeText(getApplicationContext(), "Please Give Rating to Creating Disharmony!!", Toast.LENGTH_LONG).show();
		}
		else if(tvSexualMisconduct.getText()==""){
			Toast.makeText(getApplicationContext(), "Please Give Rating to Creating Disharmony!!", Toast.LENGTH_LONG).show();
		}
		else{
			Intent i=new Intent(getApplicationContext(), Economic_Enviornment_MainForm.class);
			startActivity(i);
			finish();
		}
	}
	private class MyAsyncTask extends AsyncTask<String, Integer, Double>{
		protected Double doInBackground(String... params) 
		{
			// TODO Auto-generated method stub
			postData(params[0],params[1],params[2],params[3],params[4],params[5],params[6],params[7],params[8],
					 params[9],params[10],params[11],params[12]);
			return null;
		}
		protected void onPostExecute(Double result)
		{	
		}
 
		public void postData(String LitracyLevel,String FemaleLitracyLevel,String FormalEducationLevel,String NoofSchools,String TeacherStudentRation,
							 String KnowledgeOnLaw,String KnowledgeonHealthandFitness,String KnowledgeOnLocalCulture,String Killing,String Stealing,String Lying,
							 String CreatingDisharmony,String SexualMisconduct)
		{
			// Create a new HttpClient and Post Header
			HttpClient httpclient = new DefaultHttpClient();
			HttpPost httppost = new HttpPost("http://www.comdevindex.0fees.us/Education.php");
 
			try {
				// Add your data
				List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
				nameValuePairs.add(new BasicNameValuePair("LitracyLevel",LitracyLevel));
				nameValuePairs.add(new BasicNameValuePair("FemaleLitracyLevel",FemaleLitracyLevel));
				nameValuePairs.add(new BasicNameValuePair("FormalEducationLevel",FormalEducationLevel));
				nameValuePairs.add(new BasicNameValuePair("NoofSchools",NoofSchools));
				nameValuePairs.add(new BasicNameValuePair("TeacherStudentRation",TeacherStudentRation));
				nameValuePairs.add(new BasicNameValuePair("KnowledgeOnLaw",KnowledgeOnLaw));
				nameValuePairs.add(new BasicNameValuePair("KnowledgeonHealthandFitness",KnowledgeonHealthandFitness));
				nameValuePairs.add(new BasicNameValuePair("KnowledgeOnLocalCulture",KnowledgeOnLocalCulture));
				nameValuePairs.add(new BasicNameValuePair("Killing",Killing));
				nameValuePairs.add(new BasicNameValuePair("Stealing",Stealing));
				nameValuePairs.add(new BasicNameValuePair("Lying",Lying));
				nameValuePairs.add(new BasicNameValuePair("CreatingDisharmony",CreatingDisharmony));
				nameValuePairs.add(new BasicNameValuePair("SexualMisconduct",SexualMisconduct));
	
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

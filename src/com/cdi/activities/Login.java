package com.cdi.activities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.cdi.otherclasses.AlertDialogManager;
import com.cdi.otherclasses.ConnectionDetector;
import com.example.cdicomplete25aug.R;

public class Login extends Activity implements OnClickListener
{
	
	ProgressBar pb;
	EditText etEmail,etAreaPin;
	Button btnSubmit;
	Boolean isInternetPresent = false,isEmailIdPresentinDB=false;
	ConnectionDetector cd;
	AlertDialogManager alert = new AlertDialogManager();
	
	
	protected void onCreate(Bundle savedInstanceState){
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		
		etEmail=(EditText)findViewById(R.id.etEmail);
		etAreaPin=(EditText)findViewById(R.id.etAreaPin);	
	    btnSubmit=(Button)findViewById(R.id.btnSubmit);
	    btnSubmit.setOnClickListener(this);
	    pb=(ProgressBar)findViewById(R.id.pb);
		pb.setVisibility(View.GONE);
	
	}
	public void onClick(View v){
		
		
		
		cd = new ConnectionDetector(getApplicationContext());
		isInternetPresent = cd.isConnectingToInternet();
		
		if (!isInternetPresent) {
			alert.showAlertDialog(Login.this, "Internet Connection Error",
								  "Please connect to working Internet connection!!", false);
			return;
		}
		else if(etEmail.getText().toString().length()<12){
			Toast.makeText(getApplicationContext(), "EmailId Should be Minimum 11 Characters Long!!", Toast.LENGTH_LONG).show();
		}
		else if(etAreaPin.getText().toString().length()<1){
			Toast.makeText(getApplicationContext(), "Please Enter Your AreaCode!!", Toast.LENGTH_LONG).show();
		}
	
		else{
			pb.setVisibility(View.VISIBLE);
			new MyAsyncTask().execute(etEmail.getText().toString(),etAreaPin.getText().toString());
		}
		
		
	
	} 
	private class MyAsyncTask extends AsyncTask<String, Integer, Double>{
			protected Double doInBackground(String... params) 
			{
				// TODO Auto-generated method stub
				postData(params[0],params[1]);
				return null;
			}
			protected void onPostExecute(Double result)
			{
				pb.setVisibility(View.GONE);
				etEmail.setText("");
				etAreaPin.setText("");
				Intent i =new Intent(getApplicationContext(),Peace_of_Mind_MainForm.class);
				startActivity(i);	
			}
			protected void onProgressUpdate(Integer... progress){
				pb.setProgress(progress[0]);
			}
	 
			public void postData(String EmailId,String AreaCode) {
				HttpClient httpclient = new DefaultHttpClient();
				HttpPost httppost = new HttpPost("http://www.comdevindex.0fees.us/LoginMain.php");
	 
				try {
					List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
					nameValuePairs.add(new BasicNameValuePair("EmailId",EmailId));
					nameValuePairs.add(new BasicNameValuePair("AreaCode",AreaCode));
					httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
	
					if(isEmailIdPresentinDB){
						ResponseHandler<String> responseHandler = new BasicResponseHandler();
						final String responsefromserver = httpclient.execute(httppost, responseHandler);
						alert.showAlertDialog(Login.this,"Error",""+responsefromserver, false);
					}
					else{
						HttpResponse response = httpclient.execute(httppost);
					}
					
					}
					catch (ClientProtocolException e) {
				} 
					catch (IOException e) {
				}
			}
		}

}
 
	 

	        
	        
	        
	        
	        
	
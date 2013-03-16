package com.example.finder;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.Settings;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
public class MainActivity extends Activity  {
	  String phno1="";
      String phno2="";
      String phno3="";
    
    Button off;
    Button slide;
   
	private static final long MINIMUM_DISTANCE_CHANGE_FOR_UPDATES = 10; // in Meters 
    private static final long MINIMUM_TIME_BETWEEN_UPDATES = 120000; // in Milliseconds
    protected LocationManager locationManager;
    protected Button retrieveLocationButton;
    protected Button where;
    protected Button about;
      String message;
      
    @Override
    public void onCreate(Bundle savedInstanceState) {       
        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //reference for the buttons
        off=(Button)findViewById(R.id.off);
        retrieveLocationButton = (Button) findViewById(R.id.on);
        slide=(Button)findViewById(R.id.BtnSlide);
        where=(Button)findViewById(R.id.where);
        about=(Button)findViewById(R.id.about);
         locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        locationManager.requestLocationUpdates(
        LocationManager.GPS_PROVIDER,
        MINIMUM_TIME_BETWEEN_UPDATES,
        MINIMUM_DISTANCE_CHANGE_FOR_UPDATES,
        new MyLocationListener()
       );
    
        
    slide.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			 Intent i = new Intent(MainActivity.this, settings.class);     
             startActivity(i);
             finish();
		}
	});
    
    about.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
	     	Intent i = new Intent(MainActivity.this, aboutapp.class);     
            startActivity(i);
            finish();
	     	
		}
	});
    
    where.setOnClickListener(new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
	      new WhereIAm().execute();
		}
	});
        off.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
			System.exit(0);
			}
		});
        retrieveLocationButton.setOnClickListener(new View.OnClickListener() {
        	
            @Override
            public void onClick(View v) {
            	SharedPreferences settings = getSharedPreferences("info", MODE_PRIVATE);
                phno1 = settings.getString("pp1","");
                phno2 = settings.getString("pp2","");
                phno3 = settings.getString("pp3",""); 
            	if((phno1=="")&&(phno2=="")&&(phno3==""))
            	{
            	Toast.makeText(MainActivity.this,"Please enter the mobile number first",Toast.LENGTH_SHORT).show();
            	  Intent i = new Intent(MainActivity.this, settings.class);     
                  startActivity(i);
                 finish();
            	}
            	else
            	{
            		new Getlocatoin().execute();	
            	}
            	}
    });       
    }
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
	  	  if (keyCode == KeyEvent.KEYCODE_VOLUME_DOWN)
	  	  {
	         		SharedPreferences settings = getSharedPreferences("info", MODE_PRIVATE);
            phno1 = settings.getString("pp1", "");
            phno2 = settings.getString("pp2", "");
            phno3 = settings.getString("pp3", ""); 
        	
        	if((phno1=="")&&(phno2=="")&&(phno3==""))
        	{
        	Toast.makeText(MainActivity.this,"Please enter the mobile number first",Toast.LENGTH_SHORT).show();
        	  Intent i = new Intent(MainActivity.this, settings.class);     
              startActivity(i);
              finish();
        	}
        	else
        	{
        		new Getlocatoin().execute();	
        	}
        	return super.onKeyLongPress(keyCode, event);
	  	  	}
	  	  return true;
    	}

	  	  @Override
	  	 public boolean onKeyDown(int keyCode, KeyEvent event) {
	  	     if (keyCode == KeyEvent.KEYCODE_VOLUME_DOWN) {
	  	         event.startTracking();
	  	         return true;
	  	     }
	  	     return super.onKeyDown(keyCode, event);
	  	 }
	  	protected void showCurrentLocation() {
	        Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);  
	        if (location != null) {
	        message = String.format(
	                     "Current Location \n Longitude: %1$s \n Latitude: %2$s",
	 	                     location.getLongitude(), location.getLatitude()
	 	             );
	         
	            new Getaddress().execute(location.getLatitude(),location.getLongitude());	      
	             }
	         else
	         {
	        	 Toast.makeText(MainActivity.this, "Sorry no gps",Toast.LENGTH_SHORT).show();
	         }
	     }  
	  	 class MyLocationListener implements LocationListener 
	  	 {
	         public void onLocationChanged(Location location)
	         {
	        	 new Getlocatoin().execute();
	         }
	 
	 
	         public void onStatusChanged(String s, int i, Bundle b) {
	        	 new Getlocatoin().execute();	
		            
	
	         }
	 	
	         public void onProviderDisabled(String s) {
	 
	             Toast.makeText(MainActivity.this,
	                     "Provider disabled by the user. GPS turned off",
	                     Toast.LENGTH_LONG).show();
	             LocationManager service = (LocationManager) getSystemService(LOCATION_SERVICE);
	             boolean enabled = service
	               .isProviderEnabled(LocationManager.GPS_PROVIDER);

	             if (!enabled) {
	               Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
	               startActivity(intent);
	               finish();//new change
	             } 
	
	         }
	 
		         public void onProviderEnabled(String s) {
	 
	             Toast.makeText(MainActivity.this,
	 
	                     "Provider enabled by the user. GPS turned on",
	 
	                     Toast.LENGTH_LONG).show();
		         }
		 
	     }
	     private class WhereIAm  extends AsyncTask<Double, Integer, String> {
		  	   
	  		   	  String mes,addre;
		   	   protected void onPreExecute() {
		   		
		   	    }
		   	   @Override
		   	   protected String doInBackground(Double... params) {
		   		   
		   		 return "finished";
		     	   }
		   	   @Override
		   	   protected void onProgressUpdate(Integer... values) {
		   	      super.onProgressUpdate(values);
		   	   }
		   	   @Override
		   	   protected void onPostExecute(String result) {
		   		  Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);  
			        if (location != null) {
			         mes = String.format(
			                     "Current Location \n Longitude: %1$s \n Latitude: %2$s",
			 	                     location.getLongitude(), location.getLatitude()
			 	             );
			        Geocoder geocoder =new Geocoder(MainActivity.this, Locale.getDefault());
			   		 
					try {
			   				 List<Address> addresses = geocoder.getFromLocation(location.getLatitude(),location.getLongitude(), 1);
			   				addre=addresses.get(0).getAddressLine(0)+addresses.get(0).getAddressLine(1);
			   		  } catch (IOException e) {
			   				e.printStackTrace();
			   				addre="Unable to get the address";
			   		  }  
					Toast.makeText(MainActivity.this, mes+addre,Toast.LENGTH_LONG).show();
			          
			             }
			         else
			         {
			        	 Toast.makeText(MainActivity.this, "no gps",Toast.LENGTH_LONG).show();
			         }
		   	         super.onPostExecute(result);
			   	    
		   	     }
		   	   }

	     private class Getlocatoin extends AsyncTask<Double, Integer, String> {
		  	   
		  	  		   	  
		   	   protected void onPreExecute() {
		   		  Log.d("ASYN", "STARTED");
		   		showCurrentLocation();
		   	    }
		   	   @Override
		   	   protected String doInBackground(Double... params) {
		   		 return "finished";
		     	   }
		   	   @Override
		   	   protected void onProgressUpdate(Integer... values) {
		   	      super.onProgressUpdate(values);
		   	   }
		   	   @Override
		   	   protected void onPostExecute(String result) {
		   	         super.onPostExecute(result);
		   	      
		   	     }
		   	   }

	     private class Getaddress extends AsyncTask<Double, Integer, String> {
		  	   List<Address> addresses=null;
		  	   String address;
		   	   @Override
		   	   protected void onPreExecute() {
		   		  Log.d("ASYN", "STARTED");
		   		    		
		   	    }
		   	   @Override
		   	   protected String doInBackground(Double... params) {
		   		  Geocoder geocoder =new Geocoder(MainActivity.this, Locale.getDefault());
		   		  try {
		   				addresses = geocoder.getFromLocation(params[0],params[1], 1);
		   				address=addresses.get(0).getAddressLine(0)+addresses.get(0).getAddressLine(1);
		   		  } catch (IOException e) {
		   				e.printStackTrace();
		   				address="Unable to get the address";
		   		  }  
		  	 return "finished";
		     	   }
		   	   @Override
		   	   protected void onProgressUpdate(Integer... values) {
		   	      super.onProgressUpdate(values);
		   	   }
		   	   @Override
		   	   protected void onPostExecute(String result) {
		   	         super.onPostExecute(result);
		   	    
		   	     //    finish();
		   	         String mes= "i am in danger \n"+message+"\n"+address;
		   	      SmsManager sms = SmsManager.getDefault();
		   	      if(phno1!="")
		          sms.sendTextMessage(phno1, null, mes, null, null);
		   	      if(phno2!="")
		   	      sms.sendTextMessage(phno2, null, mes, null, null);     
		   	      if(phno3!="")   
		   	      sms.sendTextMessage(phno3, null, mes, null, null);
		   	   }
		   	   
		   }
	     

		
	     

}
     
package com.example.finder;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class aboutapp extends Activity {
	
	Button on, off, where, settings, more, back;
	
	protected void onCreate(Bundle savedInstanceState) {
	
		super.onCreate(savedInstanceState);
        setContentView(R.layout.aboutapp);
		
		on = (Button) findViewById(R.id.aon);
		off = (Button) findViewById(R.id.aoff);
		where = (Button) findViewById(R.id.awhere);
		settings = (Button) findViewById(R.id.asettings);
		more = (Button) findViewById(R.id.amore);
		back = (Button) findViewById(R.id.aback);
	
		
		
		on.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
	             Toast.makeText(aboutapp.this,
	                     "Sends text to the saved numbers repeatedly with an interval of 2 mins in background",
	                     Toast.LENGTH_LONG).show();	
			}
		});
		
		off.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
	             Toast.makeText(aboutapp.this,
	                     "Exits the app and messaging service",
	                     Toast.LENGTH_LONG).show();	
			}
		});

	where.setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
         Toast.makeText(aboutapp.this,
                 "Displays your current location",
                 Toast.LENGTH_LONG).show();	
	}
});

	settings.setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
         Toast.makeText(aboutapp.this,
                 "The numbers must be specified here for the first time",
                 Toast.LENGTH_LONG).show();	
	}
});

	more.setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
         Toast.makeText(aboutapp.this,
                 "App developed by Kathikeyan CEG for abacus :-) ",
                 Toast.LENGTH_LONG).show();	
	}
});

	back.setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent i = new Intent(aboutapp.this, MainActivity.class);     
        startActivity(i);
        finish();
	}
});
	}
	

}

package com.example.finder;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class settings extends Activity{
	int 	phoneflag=0;
public static String phno1="";
public static String phno2="";
public static String phno3="";
EditText ph1;
EditText ph2;
EditText ph3;
Button back;
int a,b,c;


     @Override
        protected void onCreate(Bundle savedInstanceState) {
    	 SharedPreferences settings = getSharedPreferences("info", MODE_PRIVATE);
    	 phno1 = settings.getString("pp1", "");
    	 phno2 = settings.getString("pp2", "");
    	 phno3 = settings.getString("pp3", ""); 
    	      
    	 
    	super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
        ph1=(EditText)findViewById(R.id.phone1);
        ph2=(EditText)findViewById(R.id.phone2);
        ph3=(EditText)findViewById(R.id.phone3);
        back=(Button)findViewById(R.id.back);
        ph1.setText(phno1);
        ph2.setText(phno2);
        ph3.setText(phno3);
        
        Button save, contact1, contact2, contact3;
        
        contact1 = (Button) findViewById(R.id.contact1);
        contact2 = (Button) findViewById(R.id.contact2);
        contact3 = (Button) findViewById(R.id.contact3);
        back.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(settings.this,MainActivity.class);     
                startActivity(i);
                finish();
				
			}
		});
        
        contact1.setOnClickListener(new View.OnClickListener(){
        	
     	   @Override
     	   
     	    public void onClick(View arg0) {
     	   // TODO Auto-generated method stub
     		  phoneflag=1;

     	   Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
     	   intent.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE);
     	   startActivityForResult(intent, 1);             
     	   

     	    }});
     	  
        
         contact2.setOnClickListener(new View.OnClickListener(){
        	
      	   @Override
      	    public void onClick(View arg0) {
      	   // TODO Auto-generated method stub
      		 
      		 phoneflag=2;
      	   Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
      	   intent.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE);
      	   startActivityForResult(intent, 1);             


      	    }});
        
        contact3.setOnClickListener(new View.OnClickListener(){
        
      	   @Override
      	    public void onClick(View arg0) {
      	   // TODO Auto-generated method stub
      		
      			phoneflag=3;
      	   Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
      	   intent.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE);
      	   startActivityForResult(intent, 1);             


      	    }}); 
        

        
        save = (Button) findViewById(R.id.bsave);
        save.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				
		        phno1=ph1.getText().toString();
				phno2=ph2.getText().toString();
				phno3=ph3.getText().toString();
				//int a,b,c;
				a=0;
				b=0;
				c=0;
				if(phno1.length()==0 && phno2.length()==0 && phno3.length()==0)
				{
					Toast.makeText(settings.this,"Enter atleast one valid number",Toast.LENGTH_SHORT).show();
				}
				
			else
			{
					if(phno1.length()!=10 && phno1.length()!=13 && phno1.length()!=0 && phno1.length()!=12 && phno1.length()!=16)
					{
						a=1;
						phno1="";
					}
					if(phno2.length()!=10 && phno2.length()!=13 && phno2.length()!= 16 && phno2.length()!=12 && phno2.length()!=0)
					{
						b=1;
						phno2="";
					}
					if(phno3.length()!=10 && phno3.length()!=13 && phno3.length()!=0 && phno3.length()!=16 && phno3.length()!=12)
					{
						c=1;
						phno3="";
					}
				
				if(a ==1 || b == 1 || c == 1)
				{
					if(a==1 && b==1 && c==1)
					{
						Toast.makeText(settings.this,"Enter atleast one valid number",Toast.LENGTH_SHORT).show();
						ph1.setText("");
						ph2.setText("");
						ph3.setText("");
					}
					
					else if(a==1 && b==1)
					{
						if(phno3.length()==0)
						{Toast.makeText(settings.this,"Enter atleast one valid number",Toast.LENGTH_SHORT).show();
						}
						else
						{
						Toast.makeText(settings.this,"Number 1,2 are invalid",Toast.LENGTH_SHORT).show();
						ph1.setText("");
						ph2.setText("");
						}
					}
					
					else if(b==1 && c==1)
					{
						if(phno1.length()==0)
						{
							Toast.makeText(settings.this,"Enter atleast one valid number",Toast.LENGTH_SHORT).show();
						}
						else
						{
							Toast.makeText(settings.this,"Number 2,3 are invalid",Toast.LENGTH_SHORT).show();
							ph2.setText("");
							ph3.setText("");
						}
					}
					
					else 
					if(a==1 && c==1)
					{
							if(phno3.length()==0)
							{
								Toast.makeText(settings.this,"Enter atleast one valid number",Toast.LENGTH_SHORT).show();
							}
							else
							{
								Toast.makeText(settings.this,"Number 1,3 are invalid",Toast.LENGTH_SHORT).show();
								ph1.setText("");
								ph3.setText("");
							}
					}
					
					else 
						if(a==1)
						{
							if(phno2.length()==0 && phno3.length()==0)
							{
								Toast.makeText(settings.this,"Enter atleast one valid number",Toast.LENGTH_SHORT).show();
							}
							else
							{
								Toast.makeText(settings.this,"Number 1 is invalid",Toast.LENGTH_SHORT).show();
								ph1.setText("");
							}
						}
						else 
							if(b==1)
							{
								if(phno1.length()==0 && phno3.length()==0){Toast.makeText(settings.this,"Enter atleast one valid number",Toast.LENGTH_SHORT).show();
						}
								else
								{
									Toast.makeText(settings.this,"Number 2 is invalid",Toast.LENGTH_SHORT).show();
									ph2.setText("");
								}
							}
							else
							{
								if(phno2.length()==0 && phno1.length()==0){Toast.makeText(settings.this,"Enter atleast one valid number",Toast.LENGTH_SHORT).show();
								}
								else
								{
									Toast.makeText(settings.this,"Number 3 is invalid",Toast.LENGTH_SHORT).show();
						            ph3.setText("");
								}
							}
				}
			else
			{

				//shared preference
				SharedPreferences settingsSave = getSharedPreferences("info", MODE_PRIVATE);
		        SharedPreferences.Editor editor = settingsSave.edit();
		        editor.putString("pp1", phno1);
		        editor.commit();
		        editor.putString("pp2", phno2);
		        editor.commit();
		        editor.putString("pp3", phno3);
		        editor.commit();
		        Toast.makeText(settings.this,"Saved successfully",Toast.LENGTH_LONG).show();
		        Intent i = new Intent(settings.this,MainActivity.class);     
                startActivity(i);
                finish();
			}
				
			}
			}
			});
        
        
     }
     
     @Override
	    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	    // TODO Auto-generated method stub
	    super.onActivityResult(requestCode, resultCode, data);
	   if(resultCode == RESULT_OK){
	    Uri contactData = data.getData();
	    Cursor cursor =  extracted(contactData);
	    cursor.moveToFirst();

	      String number = cursor.getString(cursor.getColumnIndexOrThrow(ContactsContract.CommonDataKinds.Phone.NUMBER));

	     
          //contactName.setText(name);
	      if(phoneflag==1)
	      {
	      ph1.setText(number);
	      phno1=number;
	      }
	      if(phoneflag==2)
	      {
	      ph2.setText(number);
	      phno2=number;
	      }
	      if(phoneflag==3)
	      {
	      ph3.setText(number);
	      phno3=number;
	      }
	      //contactEmail.setText(email);
	     }
	   
	   
	     }

	@SuppressWarnings("deprecation")
	private Cursor extracted(Uri contactData) {
		return managedQuery(contactData, null, null, null, null);
	}
	
	

     
}

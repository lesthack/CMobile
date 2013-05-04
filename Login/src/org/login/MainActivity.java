package org.login;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends Activity {
	
	static String USERNAME = "root";
	static String PASSWORD = "toor";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button btnlogin = (Button) findViewById(R.id.btnlogin);
		btnlogin.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				EditText txtusername = (EditText) findViewById(R.id.username);
				EditText txtpassword = (EditText) findViewById(R.id.password);
				
				if(txtusername.getText().toString().equals(USERNAME) && txtpassword.getText().toString().equals(PASSWORD)){
					Intent intent = new Intent(v.getContext(), ReferenceActivity.class);
			        startActivity(intent);
				}
				else{
					Toast.makeText(v.getContext(), "Password y/o Usuario incorrectos", Toast.LENGTH_LONG).show();
				}
			}
		});
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}

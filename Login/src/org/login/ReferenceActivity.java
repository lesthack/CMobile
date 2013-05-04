package org.login;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class ReferenceActivity extends Activity {

	static ToggleButton btntoggle;
	static Spinner Cmb1;
	static ListView Lista1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_reference);
		
		btntoggle = (ToggleButton) findViewById(R.id.btntoggle);
		btntoggle.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(btntoggle.isChecked())
					Toast.makeText(arg0.getContext(), "Lo has prendido", 
							Toast.LENGTH_SHORT).show();
				else
					Toast.makeText(arg0.getContext(), "Lo has apagado", 
							Toast.LENGTH_SHORT).show();
			}
		});
		
		TextView txt1 = (TextView) findViewById(R.id.txt1);
			txt1.setText("Texto modificado");
		TextView txt2 = (TextView) findViewById(R.id.txt2);
			txt2.setText("desde el código");
			
		Cmb1 = (Spinner) findViewById(R.id.Cmb1);
		String[] datos = new String[]{"Elem1","Elem2","Elem3","Elem4","Elem5"};
		
		ArrayAdapter<String> adaptador =
		        new ArrayAdapter<String>(this,
		            android.R.layout.simple_spinner_item, datos);
		
		Cmb1.setAdapter(adaptador);
		
		Lista1 = (ListView) findViewById(R.id.Lista1);
		ArrayAdapter<String> adaptador2 =
		        new ArrayAdapter<String>(this,
		            android.R.layout.simple_list_item_1, datos);
		Lista1.setAdapter(adaptador2);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.reference, menu);
		return true;
	}

}

package org.suma;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends Activity {
	static EditText numero1;
	static EditText numero2;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		numero1 = (EditText) findViewById(R.id.numero1);
		numero2 = (EditText) findViewById(R.id.numero2);
		
		Button btnsumar = (Button) findViewById(R.id.btnsumar);
		btnsumar.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(numero1.getText().toString().length() == 0 
						|| numero2.getText().toString().length() == 0){
					Toast.makeText(v.getContext(), "Ingrese los valores correctos por favor", Toast.LENGTH_SHORT).show();
				}
				else{
					float rsuma = Float.parseFloat(numero1.getText().toString()) 
							+ Float.parseFloat(numero2.getText().toString());
					Toast.makeText(v.getContext(), "La suma es: " + rsuma, Toast.LENGTH_LONG).show();
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

package org.localizame;

import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private Button btnstart;
	private TextView txtlatitud;
	private TextView txtlongitud;
	private Button btnpush;
	private Button btnshow;
	private LocationManager locationManager;
	
	private Boolean connectionStatus = false;
	private DataBaseOpenHelper dbconnection;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		
		//this.getApplicationContext().deleteDatabase("dblocalizame");
		dbconnection = new DataBaseOpenHelper(this);
		
		this.setObjects();
		this.setEvents();
	}
	
	public void setObjects(){
		btnstart = (Button) findViewById(R.id.btnstart);
		btnpush = (Button) findViewById(R.id.btnpush);
		btnshow = (Button) findViewById(R.id.btnshow);
		txtlatitud = (TextView) findViewById(R.id.txtlatitud);
		txtlongitud = (TextView) findViewById(R.id.txtlongitud);
	}
	
	public void setEvents(){
		btnstart.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (connectionStatus == false) {
                    txtlatitud.setText("0");
                    txtlongitud.setText("0");
                    btnpush.setEnabled(true);
                    
                    Criteria cri = new Criteria();
                    cri.setAccuracy(Criteria.ACCURACY_FINE);
                    locationManager.requestLocationUpdates(locationManager.getBestProvider(cri, true), 1000, 0, locationListener);

                    connectionStatus = true;
                    btnstart.setText("Stop");
                } else {
                	btnpush.setEnabled(false);
                    locationManager.removeUpdates(locationListener);
                    btnstart.setText("Start");
                    connectionStatus = false;
                }
			}
			
		});		
		
		btnshow.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(v.getContext(), PointsActivity.class);
                startActivityForResult(intent, 1);
			}
		});
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	private final LocationListener locationListener = new LocationListener() {

        public void onLocationChanged(Location location) {
            txtlatitud.setText(String.format("%9.6f", location.getLatitude()));
            txtlongitud.setText(String.format("%9.6f", location.getLongitude()));
        }

		@Override
		public void onProviderDisabled(String arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onProviderEnabled(String arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
			// TODO Auto-generated method stub
			
		}        
    };
}

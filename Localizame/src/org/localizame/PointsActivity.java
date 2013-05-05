package org.localizame;

import android.os.Bundle;
import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class PointsActivity extends Activity {
	
	private DataBaseOpenHelper dbconnection;	
	private ListView lstpoints;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_points);
		
		dbconnection = new DataBaseOpenHelper(this);
		SQLiteDatabase db = dbconnection.getReadableDatabase();
		
		lstpoints = (ListView) findViewById(R.id.lstpoints);
		
		
		Cursor cursor = db.rawQuery("SELECT * FROM points", null);
		String[] points = new String[cursor.getCount()];
		
		int i=0;
		
		if(cursor.moveToFirst()){
			do{
				points[i++] = String.format("%s, %s", cursor.getString(0), cursor.getString(0));
			}while(cursor.moveToNext());
		}
		
		ArrayAdapter<String> pointsadapter =
		        new ArrayAdapter<String>(this,
		            android.R.layout.simple_spinner_item, points);
		
		lstpoints.setAdapter(pointsadapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.points, menu);
		return true;
	}

}

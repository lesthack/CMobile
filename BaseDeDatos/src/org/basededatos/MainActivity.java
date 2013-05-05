package org.basededatos;

import android.os.Bundle;
import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	private Button btnagregar; 
	private Button btnconsultar;
	private Button btneliminar;
	private Button btnmodificar;
	
	private SQLiteOpenHelper dbconnection;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		dbconnection = new UsuariosSQLiteHelper(this, "dbejemplo", null, 3);
		
		btnagregar = (Button) findViewById(R.id.btnagregar);
		btnconsultar = (Button) findViewById(R.id.btnconsultar);
		btneliminar = (Button) findViewById(R.id.btneliminar);
		btnmodificar = (Button) findViewById(R.id.btnmodificar);
		
		btnagregar.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				double n = (Math.random()*10);
				SQLiteDatabase db = dbconnection.getWritableDatabase();
				db.execSQL("INSERT INTO usuarios(username, password)" +
						"	Values('" + n + "','toor')");
				Log.i("db","Se agrego el usuario " + n);
				db.close();
				
			}
		});
		
		btnconsultar.setOnClickListener(new View.OnClickListener() {			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				SQLiteDatabase db = dbconnection.getReadableDatabase();
				Cursor cursor = db.rawQuery("SELECT * FROM usuarios", null);
				if(cursor.moveToFirst()){
					do{
						Log.i("db", String.format("usuario: %s password: %s", 
								cursor.getString(0), cursor.getString(1)));
					}while(cursor.moveToNext());
				}
				db.close();
			}
		});
		
		btnmodificar.setOnClickListener(new View.OnClickListener() {			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				SQLiteDatabase db = dbconnection.getWritableDatabase();
				db.execSQL(" UPDATE usuarios SET password='otro' ");
				db.close();
			}
		});
		
			
		btneliminar.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				SQLiteDatabase db = dbconnection.getWritableDatabase();
				db.execSQL(" DELETE FROM usuarios WHERE username like '1%' ");
				db.close();
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

package com.edavid.changeactivitygrid;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.GridView;

public class MainActivity extends Activity {

	public final static String EXTRA_SELECTED = "com.edavid.changeactivitygrid.SELECTEDVALUE";
	GridView gridView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		gridView = (GridView)findViewById(R.id.griditem);
		
		String[] values = new String[] {"A","B","C","D","E","F","G","H","I",
										"J","K","L","M","N","O","P","Q","R",
										"S","T","U","V","W","X","Y","Z"};
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.item_layout, R.id.item_text, values);
		
		gridView.setAdapter(adapter);
		gridView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Intent intent = new Intent(MainActivity.this, ItemDisplayActivity.class);
				intent.putExtra(EXTRA_SELECTED, (String)parent.getItemAtPosition(position));
				startActivity(intent);
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

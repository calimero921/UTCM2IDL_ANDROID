package com.edavid.hellobutton;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		EditText editText = (EditText) findViewById(R.id.edit_message);
		editText.setOnEditorActionListener(new EditText.OnEditorActionListener() {
		    @Override
		    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
		        if (actionId == EditorInfo.IME_ACTION_DONE) {
		    		changeMessage();
		            return true;
		        }
		        return false;
		    }
		});
	}

	private void changeMessage() {
		EditText editText = (EditText) findViewById(R.id.edit_message);
		TextView textView = (TextView) findViewById(R.id.text_message);
		textView.setText(editText.getText().toString());
		editText.setText("");
	}
	
	public void sendMessage(View view) {
		changeMessage();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}

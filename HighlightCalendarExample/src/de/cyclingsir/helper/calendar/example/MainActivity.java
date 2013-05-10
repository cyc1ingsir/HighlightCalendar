package de.cyclingsir.helper.calendar.example;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {
	
	
	private Button btn_customCalendar;
	private Button btn_nativCalendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_customCalendar = (Button) findViewById(R.id.btn_customCalendar);
        btn_nativCalendar = (Button) findViewById(R.id.btn_nativCalendar);
        btn_customCalendar.setOnClickListener(this);
        btn_nativCalendar.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


	@Override
	public void onClick(View view) {
		Intent intent = null;
		switch (view.getId()) {
		case R.id.btn_customCalendar:
			intent = new Intent(this, CustomCalendarActivity.class);
			break;
		case R.id.btn_nativCalendar:
			intent = new Intent(this, NativCalendarActivity.class);
			break;
		default:
			break;
		}
		if(intent != null)
			startActivity(intent);
	}
    
}

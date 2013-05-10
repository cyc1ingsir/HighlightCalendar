package de.cyclingsir.helper.calendar.example;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;
import android.widget.CalendarView;
import android.widget.CalendarView.OnDateChangeListener;

public class NativCalendarActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.nativ_calendar);
		CalendarView calendarView = (CalendarView) findViewById(R.id.calendarView);
		calendarView.setOnDateChangeListener( new OnDateChangeListener() {
			
			@Override
			public void onSelectedDayChange(CalendarView view, int year, int month,
					int dayOfMonth) {
				Toast.makeText(getApplicationContext(), "" + dayOfMonth, Toast.LENGTH_SHORT).show();
				
			}
		}); 
	}
}


package de.cyclingsir.helper.calendar;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;
import de.cyclingsir.helper.calendar.HighlightCalendarView.OnDateSelectedListener;

public class CalendarActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.highlight_calendar);
		HighlightCalendarView calendarView = (HighlightCalendarView) findViewById(R.id.calendarView1);
		calendarView.setOnDateSelectedListener( new OnDateSelectedListener() {
			
			
			@Override
			public void onDaySelected(HighlightCalendarView view, int year, int month,
					int dayOfMonth) {
				Toast.makeText(getApplicationContext(), "" + dayOfMonth, Toast.LENGTH_LONG).show();
				
			}
		}); 
	}
}

package de.cyclingsir.helper.calendar.example;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;
import de.cyclingsir.helper.calendar.HighlightCalendarView;
import de.cyclingsir.helper.calendar.HighlightCalendarView.OnDateSelectedListener;

public class CustomCalendarActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.custom_calendar);
		HighlightCalendarView calendarView = (HighlightCalendarView) findViewById(R.id.calendarView);
		calendarView.setOnDateSelectedListener( new OnDateSelectedListener() {
			
			
			@Override
			public void onDaySelected(HighlightCalendarView view, int year, int month,
					int dayOfMonth) {
				Toast.makeText(getApplicationContext(), "" + dayOfMonth, Toast.LENGTH_SHORT).show();
				
			}
		}); 
	}
}

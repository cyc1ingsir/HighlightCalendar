package de.cyclingsir.helper.calendar.example;

import java.util.Calendar;

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

			@Override
			public void onViewChanged(long startDate, long endDate) {
				Calendar startCalendar = Calendar.getInstance();
				startCalendar.setTimeInMillis(startDate);
				Calendar endCalendar = Calendar.getInstance();
				endCalendar.setTimeInMillis(endDate);
				Toast.makeText(getApplicationContext(), "srolled to " 
					+ startCalendar.get(Calendar.DAY_OF_MONTH) + "." + (startCalendar.get(Calendar.MONTH)+1)+ "."
					+ " - "
					+ endCalendar.get(Calendar.DAY_OF_MONTH) + "." + (endCalendar.get(Calendar.MONTH)+1)+ ".", 
					Toast.LENGTH_SHORT).show();
			}
			
		}); 
	}
}

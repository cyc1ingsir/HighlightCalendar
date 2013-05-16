package de.cyclingsir.helper.calendar.example;

import java.util.ArrayList;
import java.util.Calendar;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import de.cyclingsir.helper.calendar.HighlightCalendarView;
import de.cyclingsir.helper.calendar.HighlightCalendarView.OnDateSelectedListener;

public class CustomCalendarActivity extends Activity {

	final Calendar mCal = Calendar.getInstance();
	final ArrayList<ExampleEvent> mEvents = new ArrayList<ExampleEvent>();
	HighlightCalendarView calendarView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.custom_calendar);
		calendarView = (HighlightCalendarView) findViewById(R.id.calendarView);

		mEvents.add( new ExampleEvent(mCal.getTimeInMillis()));
		mCal.add(Calendar.DAY_OF_MONTH, -2);
		mEvents.add( new ExampleEvent(mCal.getTimeInMillis()));
		mCal.add(Calendar.DAY_OF_MONTH, 4);
		mEvents.add( new ExampleEvent(mCal.getTimeInMillis()));
		calendarView.addEvents(mEvents);

		calendarView.setOnDateSelectedListener( new OnDateSelectedListener() {


			@Override
			public void onDaySelected(HighlightCalendarView view, int year, int month,
					int dayOfMonth) {
				Toast.makeText(getApplicationContext(), "" + dayOfMonth, Toast.LENGTH_SHORT).show();

			}

			@Override
			public void onViewChanged(long startDate, long endDate) {
				final Calendar startCalendar = Calendar.getInstance();
				startCalendar.setTimeInMillis(startDate);
				final Calendar endCalendar = Calendar.getInstance();
				endCalendar.setTimeInMillis(endDate);
				Toast.makeText(getApplicationContext(), "srolled to "
					+ startCalendar.get(Calendar.DAY_OF_MONTH) + "." + (startCalendar.get(Calendar.MONTH)+1)+ "."
					+ " - "
					+ endCalendar.get(Calendar.DAY_OF_MONTH) + "." + (endCalendar.get(Calendar.MONTH)+1)+ ".",
					Toast.LENGTH_SHORT).show();
				mEvents.clear();

				mEvents.add(new ExampleEvent(startDate));
				mEvents.add(new ExampleEvent(startDate));
				mEvents.add(new ExampleEvent(endDate));
				mCal.setTimeInMillis(startDate + (endDate - startDate)/2);
				mEvents.add(new ExampleEvent(mCal.getTimeInMillis()));
				mCal.setTimeInMillis(endDate);
				mCal.add(Calendar.DAY_OF_MONTH, -10 - mCal.get(Calendar.MONTH));
				mEvents.add(new ExampleEvent(mCal.getTimeInMillis()));
				mCal.setTimeInMillis(startDate);
				mCal.add(Calendar.DAY_OF_MONTH, 8 + mCal.get(Calendar.MONTH));
				mEvents.add(new ExampleEvent(mCal.getTimeInMillis()));
				calendarView.addEvents(mEvents);
			}

		});
	}
}

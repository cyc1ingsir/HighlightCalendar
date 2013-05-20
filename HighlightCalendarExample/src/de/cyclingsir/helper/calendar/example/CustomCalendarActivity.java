package de.cyclingsir.helper.calendar.example;

/*
 * Copyright (C) 2013 M. Ritscher
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


import java.util.ArrayList;
import java.util.Calendar;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;
import de.cyclingsir.helper.calendar.DateEvent;
import de.cyclingsir.helper.calendar.HighlightCalendarView;
import de.cyclingsir.helper.calendar.HighlightCalendarView.OnDateSelectedListener;

/**
 * An Example how to use the HighlightCalendarView.
 *
 * @author M. Ritscher
 * May 2013
 */
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

			@Override
			public void onEventSelected(DateEvent event) {
				Toast.makeText(getApplicationContext(), "Event selected: " + event,
						Toast.LENGTH_SHORT).show();
			}

			@Override
			public void onAddEvent(long date) {
				final Calendar cal = Calendar.getInstance();
				cal.setTimeInMillis(date);
				Toast.makeText(getApplicationContext(), "New Event at: "
						+ cal.get(Calendar.DAY_OF_MONTH) + "."
						+ cal.get(Calendar.MONTH) + ".",
						Toast.LENGTH_SHORT).show();
			}

		});
	}
}

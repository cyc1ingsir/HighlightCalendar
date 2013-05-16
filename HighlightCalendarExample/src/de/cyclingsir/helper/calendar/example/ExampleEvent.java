/**
 *
 */
package de.cyclingsir.helper.calendar.example;

import de.cyclingsir.helper.calendar.DateEvent;

/**
 * @author M. Ritscher
 * 15 May 2013
 */
public class ExampleEvent implements DateEvent {

	long mDate = 0;

	public ExampleEvent( long date ) {
		this.mDate = date;
	}

	/* (non-Javadoc)
	 * @see de.cyclingsir.helper.calendar.DateEvent#getDate()
	 */
	@Override
	public long getDate() {
		return mDate;
	}

}

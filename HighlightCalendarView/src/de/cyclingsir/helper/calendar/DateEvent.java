/**
 * @author M. Ritscher
 * created: 2013-05-10
 */
package de.cyclingsir.helper.calendar;

/**
 * Enables the {@link de.cyclingsir.helper.calendar.HighlightCalendarView}
 * to query the adapters for the date the event took place 
 *
 */
public interface DateEvent {
	/**
	 * Queries the implementing object for the date the event
	 * took place
	 * @return the date in milliseconds since epoche
	 */
	public long getDate();
}

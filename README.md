HighlightCalendar
=================

Adopting Android's CalendarView and mark events on the days. The (multiple) events per day are selectable.

Questions on StackOverflow
--------------------------

After searching SO and not finding a solution but similar questions only, I
started to create an own project.

Just to name a few:

http://stackoverflow.com/questions/13756866/android-event-calendar
http://stackoverflow.com/questions/11507914/how-to-add-events-to-android-calendarview
http://stackoverflow.com/questions/16556254/android-calendarview-for-showing-events


TODOs and known issues
----------------------

I started with copying the original Android's calendar view which I didn't like
but it seemed the best (?) approach to tackle this.
The Layout is far from winning a design award and on the way to getting this
view working I removed the stylable attributes for simplicity. I'd love to
improve the visual appreance and reference the style attributes to the ones
refered by the original view again. I'm not sure if that is possible yet.

Within the example one can compare the original view to the customized. I
noticed that the onSelectedDay method is called not only when a day was selected
but after scrolling stopped also. I assume this is not the intended behaviour.


License
-------

Since I started by copying from the original Android source I kept the Apache
License. Having licensed my work under the GPL in the past, I would have
prefered this but to make it simpler the complete code is licensed under the
Apache License now.

Anyhow I do hope this is useful for some. Forking and comments are welcome.


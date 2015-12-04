# PersianScheduler


  What is it?
  -----------

  The Persian Scheduler is a JSF Component for Scheduling with Persian Calendar 
  It's useful for Java EE Web Projects that used JSF 2.x framework and need Scheduler
  with Persian TimeZone in their Projects.
  PersianScheduler is based on Javascript Persian Calendar that retrieved from FullCalendar.js
  As a project, the developers aim to collaboratively develop and maintain a robust,
  standards-based JSF Component with freely available source code.


  Documentation
  -------------

  The documentation available as of the date of this release is
  included in HTML and PNG and UML format in the docs directory.


  Installation
  ------------
  For install PersianScheduler Component in your project need to build it with Apache ANT 
  and then copy the generated PersianScheduler.jar file from build directory into classpath of your JSF project,
  Or change the deploy directory in build.xml file <property name="deploy.dir" value="/home/hatami/project/sample/lib"/>
  to automatic build and deploy into your project with below command line

  # ant deploy 


  The usage of this component is in the example directory like below :

   <s:persianScheduler value="
               defaultDate: '2015-12-12',
   			editable: false,
   			eventLimit: true,
   			events: [
   				{
   					title: 'All Day Event',
   					start: '2015-12-03'
   				},
   				{
   					title: 'Long Event',
   					start: '2015-12-07',
   					end: '2015-12-10'
   				},
   				{
   					id: 999,
   					title: 'Repeating Event',
   					start: '2015-12-09T16:00:00'
   				},
   				{
   					id: 999,
   					title: 'Repeating Event',
   					start: '2015-12-16T16:00:00'
   				},
   				{
   					title: 'Conference',
   					start: '2015-12-11',
   					end: '2015-12-13'
   				},
   				{
   					title: 'Meeting',
   					start: '2015-12-12T10:30:00',
   					end: '2015-12-12T12:30:00'
   				},
   				{
   					title: 'Lunch',
   					start: '2015-12-12T12:00:00'
   				},
   				{
   					title: 'Meeting',
   					start: '2015-12-12T14:30:00'
   				},
   				{
   					title: 'Happy Hour',
   					start: '2015-12-12T17:30:00'
   				},
   				{
   					title: 'Dinner',
   					start: '2015-12-12T20:00:00'
   				},
   				{
   					title: 'Birthday Party',
   					start: '2015-12-13T07:00:00'
   				},
   				{
   					title: 'Click for Google',
   					url: 'http://google.com/',
   					start: '2015-12-28'
   				}
   			]});"/>

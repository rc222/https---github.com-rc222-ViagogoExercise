Viagogo Readme
--------------

This read me is accompanied by a implementation of the world map exercise
given to me.

Name: Robert Cobb (rbc31@bath.ac.uk)

How to run
----------

Program is simple Java application, with main method in the Map class
simple compile all code and then run the Map class.

Answers to questions
---------------------
1) How might you change your program if you needed to support multiple events at the same location?

-> Implement some form of bucket system, where you chain events at same location together using a link list
-> Or more probably put it all in an SQL database and set up quesries that return all relevant events


2) How would you change your program if you were working with a much larger world size?

-> Current program uses a very simple algorithm (nlog(n) in number of events)
-> This has problem that as world grows (and presumably events) algorithm slows
-> calulating distances for places that are a long way away
-> Could be modified to only consider subsets of events based on location
	-> i.e. if in england only consider events in England
-> Another option would be to represent events in some graph and perform
-> search algorithm such as BFS or IDS to find closest events

Assumptions made
----------------

-> Ticket prices generated will only go up to 100 $
-> As stated above, number of events is relativly small
-> Users are expected to enter a location on the map, however will working
	for invalid input such as 50,50 (off world)
-> No multithreading, little thought has been put into making the code
	thread safe, in the real world this would be very key to prevent ticket
	purchase run offs
-> no removal of tickets, finding cheap tickets is based on consistency of an array
	that keeps cheapest tickets at the front of the list
	
# voronoi-processor
Small tool which allows you to transfer your image into Voronoi Map.

See http://en.wikipedia.org/wiki/Voronoi_diagram.

Build:
  mvn clean package
  
Usage:
  java -jar voronoi-processor.jar filename algorith_name number_of_control_points
  Supported algorith names are:
	* EUCLIDEAN - for euclidean distance;
	* MANHATTAN - for taxicab distance.
	
  E.g. 'java -jar voronoi-processor.jar cat.jpg EUCLIDEAN 1000'

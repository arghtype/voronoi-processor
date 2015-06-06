# voronoi-processor
Small tool which allows you to transfer your image into Voronoi Map.

See http://en.wikipedia.org/wiki/Voronoi_diagram.

Build:
  mvn clean package
  
Usage:
  java -jar voronoi-processor.jar filename number_of_control_points
  E.g. 'java -jar voronoi-processor.jar cat.jpg 1000'

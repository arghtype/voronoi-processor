package argh.voronoi.processor.algorithm;

import argh.voronoi.processor.RGBColouredPoint;

import java.util.HashMap;

/**
 * @author arghtype
 * @since 10.06.2015
 */
public class ManhattanDistanceAlgorithm extends EuclideanDistanceAlgorithm {

    private Integer getDistance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    @Override
    protected int calculateNewColour(int x, int y) {
        HashMap<Integer, Integer> distanceToColor = new HashMap<>();
        int min = height + width;
        for (RGBColouredPoint point : nodes) {
            int distance = getDistance(point.getX(), point.getY(), x, y);
            if (distance < min) {
                min = distance;
            }
            distanceToColor.put(distance, point.getRgb());
        }
        return distanceToColor.get(min);
    }
}

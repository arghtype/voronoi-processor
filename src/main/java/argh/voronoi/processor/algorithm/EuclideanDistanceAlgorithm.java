package argh.voronoi.processor.algorithm;

import argh.voronoi.processor.RGBColouredPoint;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author arghtype
 * @since 06.06.2015
 */
public class EuclideanDistanceAlgorithm implements VoronoiAlgorithm {
    private Set<RGBColouredPoint> nodes = new HashSet<>();
    int height;
    int width;

    @Override
    public BufferedImage process(BufferedImage input, int n) {
        height = input.getHeight();
        width = input.getWidth();
        System.out.println("Processing image, height = " + height + ", width = " + width);
        //find N leading points and save them into map
        prepareMapNodes(input, n);
        //for each point find closest leading and use its colour
        System.out.print("Applying new colors...");
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                input.setRGB(x, y, calculateNewColour(x, y));
            }
        }
        System.out.println("Done!");
        return input;
    }

    private int calculateNewColour(int x, int y) {
        HashMap<Double, Integer> distanceToColor = new HashMap<>();
        nodes.stream().forEach(point -> {
            double distance = getDistance(point.getX(), point.getY(), x, y);
            distanceToColor.put(distance, point.getRgb());
        });
        List<Double> collect = distanceToColor.keySet().stream().collect(Collectors.toList());
        collect.sort((o1, o2) -> {
            if (o1 < o2) {
                return -1;
            } else if (o1 == o2) {
                return 0;
            }
            return 1;
        });
        return distanceToColor.get(collect.get(0));
    }

    private double getDistance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }

    private void prepareMapNodes(BufferedImage input, int n) {
        Random rnd = new Random();
        System.out.print("Preparing control points... ");
        while (nodes.size() < n) {
            int x = rnd.nextInt(width);
            int y = rnd.nextInt(height);
            nodes.add(new RGBColouredPoint(x, y, input.getRGB(x, y)));
        }
        System.out.println("Done!");
    }
}

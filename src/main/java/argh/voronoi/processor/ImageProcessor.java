package argh.voronoi.processor;

import argh.voronoi.processor.algorithm.Algorithm;
import argh.voronoi.processor.algorithm.AlgorithmFactory;
import argh.voronoi.processor.algorithm.VoronoiAlgorithm;

import java.awt.image.BufferedImage;

/**
 * @author arghtype
 * @since 05.06.2015
 */
public class ImageProcessor {
    private int controlPointsNumber;
    private ImageIOProcessor io;

    public ImageProcessor(int n, ImageIOProcessor io) {
        this.controlPointsNumber = n;
        this.io = io;
    }

    public void process() throws Exception {
        BufferedImage img = io.readImage();
        processImage(img, controlPointsNumber);
        io.writeImage(img);
    }

    private void processImage(BufferedImage img, int n) {
        VoronoiAlgorithm algorithmInstance = AlgorithmFactory.getAlgorithmInstance(Algorithm.EUCLIDEAN_DISTANCE);
        algorithmInstance.process(img, n);
    }

}

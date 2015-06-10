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
    private Algorithm algorithm;
    private int controlPointsNumber;
    private ImageIOProcessor io;

    public ImageProcessor(Algorithm algorithm,int n, ImageIOProcessor io) {
        this.algorithm = algorithm;
        this.controlPointsNumber = n;
        this.io = io;
    }

    public void process() throws Exception {
        BufferedImage img = io.readImage();
        processImage(img);
        io.writeImage(img);
    }

    private void processImage(BufferedImage img) {
        VoronoiAlgorithm algorithmInstance = AlgorithmFactory.getAlgorithmInstance(algorithm);
        algorithmInstance.process(img, controlPointsNumber);
    }

}

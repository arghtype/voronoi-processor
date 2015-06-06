package argh.voronoi.processor;

import argh.voronoi.exception.ImageProcessingException;
import argh.voronoi.processor.algorithm.AlgorithmFactory;
import argh.voronoi.processor.algorithm.VoronoiAlgorithm;
import argh.voronoi.processor.algorithm.Algorithm;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author arghtype
 * @since 05.06.2015
 */
public class ImageProcessor {
    private String path;
    private File input;
    private static final String OUT = "/%sout.PNG";

    public void process() throws ImageProcessingException {
        path = "D:/SANDBOX/voronoi-processor/target/classes/cat.jpg";
        BufferedImage img = readImage();
        processImage(img, Algorithm.EUCLIDEAN_DISTANCE, 5000);
        writeImage(img);
    }

    private void processImage(BufferedImage img, Algorithm algorithm, int n) {
        VoronoiAlgorithm algorithmInstance = AlgorithmFactory.getAlgorithmInstance(algorithm);
        algorithmInstance.process(img, n);
    }

    private BufferedImage readImage() throws ImageProcessingException {
        BufferedImage image;
        input = new File(path);
        try {
            image = ImageIO.read(input);
        } catch (IOException e) {
            throw new ImageProcessingException(e);
        }
        return image;
    }

    private void writeImage(BufferedImage img) throws ImageProcessingException {
        File output = new File(input.getParent() + String.format(OUT, System.currentTimeMillis()));
        try {
            if (output.createNewFile()) {
                ImageIO.write(img, "PNG", output);
            } else {
                throw new IOException("Failed to create output file");
            }
        } catch (IOException e) {
            throw new ImageProcessingException(e);
        }
    }
}

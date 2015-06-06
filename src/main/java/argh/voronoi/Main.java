package argh.voronoi;

import argh.voronoi.exception.ImageProcessingException;
import argh.voronoi.processor.ImageProcessor;

/**
 * @author arghtype
 * @since 05.06.2015.
 */
public class Main {

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Too few arguments.");
            printHelp();
        } else {
            try {
                new ImageProcessor().process();
            } catch (ImageProcessingException e) {
                e.printStackTrace();
            }
        }
    }

    private static void printHelp() {
        System.out.println("Usage:\n java -jar voronoi-processor.jar image.jpg N\n Where N is number of control points for Voronoi algorithm.");

    }
}

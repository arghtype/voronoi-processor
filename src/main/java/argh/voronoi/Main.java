package argh.voronoi;

import argh.voronoi.processor.ImageIOProcessor;
import argh.voronoi.processor.ImageProcessor;
import argh.voronoi.processor.algorithm.Algorithm;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.CodeSource;

/**
 * @author arghtype
 * @since 05.06.2015.
 */
public class Main {

    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Incorrect argument number.");
            printHelp();
        } else {
            try {
                String path = args[0];
                String algPart = args[1];
                int n = Integer.valueOf(args[2]);
                MainImageIOProcessor io = new MainImageIOProcessor();
                io.setInputImagePath(path);
                new ImageProcessor(Algorithm.getByPartialName(algPart), n, io).process();
            } catch (NumberFormatException e) {
                e.printStackTrace();
                System.out.println("Incorrect N parameter");
                printHelp();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static void printHelp() {
        System.out.println("\nUsage:\n java -jar voronoi-processor.jar image.jpg ALG N\nWhere:\n  N is a number of" +
                " control points for Voronoi algorithm;\n  ALG is an algorithm alias. Allowed values are: EUCLIDEAN, MANHATTAN");
    }

    static class MainImageIOProcessor implements ImageIOProcessor {

        private String path;

        @Override
        public void setInputImagePath(String path) {
            this.path = path;
        }

        @Override
        public BufferedImage readImage() throws IOException {
            BufferedImage image;
            File input = new File(path);
            image = ImageIO.read(input);
            return image;
        }

        @Override
        public void writeImage(BufferedImage img) throws IOException {
            File output = new File(prepareOutputFileName());
            if (output.createNewFile()) {
                ImageIO.write(img, "PNG", output);
            } else {
                System.out.println("Output file already exists");
            }
        }

        private String prepareOutputFileName() {
            CodeSource codeSource = Main.class.getProtectionDomain().getCodeSource();
            File jarFile = null;
            try {
                jarFile = new File(codeSource.getLocation().toURI().getPath());
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            String jarDir = "";
            if (jarFile != null) {
                jarDir = jarFile.getParentFile().getPath();
            }
            int i = path.indexOf(".");
            return jarDir + "/processed_" + path.substring(0, i) + ".png";
        }
    }
}

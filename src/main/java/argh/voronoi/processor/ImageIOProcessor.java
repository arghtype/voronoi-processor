package argh.voronoi.processor;

import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author arghtype
 * @since 06.06.2015
 */
public interface ImageIOProcessor {
    void setInputImagePath(String path);

    void writeImage(BufferedImage img) throws IOException;

    BufferedImage readImage() throws IOException;
}

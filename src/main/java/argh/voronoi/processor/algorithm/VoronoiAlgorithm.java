package argh.voronoi.processor.algorithm;

import java.awt.image.BufferedImage;

/**
 * @author arghtype
 * @since 06.06.2015
 */
public interface VoronoiAlgorithm {

    /**
     * @param input original image
     * @param n     number of regions in final Voronoi Map
     * @return processed image
     */
    BufferedImage process(BufferedImage input, int n);


}

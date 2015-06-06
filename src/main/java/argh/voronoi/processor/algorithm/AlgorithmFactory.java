package argh.voronoi.processor.algorithm;

/**
 * @author arghtype
 * @since 06.06.2015
 */
public class AlgorithmFactory {

    public static VoronoiAlgorithm getAlgorithmInstance(Algorithm alg) {
        VoronoiAlgorithm result = null;
        switch (alg) {
            case EUCLIDEAN_DISTANCE:
                result = new EuclideanDistanceAlgorithm();
                break;
        }
        return result;
    }
}

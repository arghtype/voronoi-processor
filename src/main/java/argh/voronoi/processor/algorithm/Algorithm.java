package argh.voronoi.processor.algorithm;

/**
 * @author arghtype
 * @since 06.06.2015
 */
public enum Algorithm {
    EUCLIDEAN_DISTANCE,
    MANHATTAN_DISTANCE;

    public static Algorithm getByPartialName(String prefix) {
        if (prefix.startsWith("MANHATTAN")) {
            return MANHATTAN_DISTANCE;
        }
        //we use EUCLIDEAN_DISTANCE by default
        return EUCLIDEAN_DISTANCE;
    }

}

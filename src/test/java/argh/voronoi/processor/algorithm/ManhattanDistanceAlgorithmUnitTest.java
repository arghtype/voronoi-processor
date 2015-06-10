package argh.voronoi.processor.algorithm;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.awt.image.BufferedImage;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author arghtype
 * @since 10.06.2015
 */
public class ManhattanDistanceAlgorithmUnitTest {
    @Mock
    private BufferedImage image;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void simpleRun() {
        int height = 100;
        int width = 100;
        int n = 10;
        when(image.getHeight()).thenReturn(height);
        when(image.getWidth()).thenReturn(width);

        VoronoiAlgorithm alg = new ManhattanDistanceAlgorithm();
        alg.process(image, n);

        verify(image, times(n)).getRGB(anyInt(), anyInt());
        verify(image, times(height * width)).setRGB(anyInt(), anyInt(), anyInt());
    }

}

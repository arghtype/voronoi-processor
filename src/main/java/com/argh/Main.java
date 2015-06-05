package com.argh;

import com.argh.exception.ImageProcessingException;
import com.argh.processor.ImageProcessor;

/**
 * @author arghtype
 * @since 05.06.2015.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world");
        try {
            new ImageProcessor().process();
        } catch (ImageProcessingException e) {
            e.printStackTrace();
        }
    }
}

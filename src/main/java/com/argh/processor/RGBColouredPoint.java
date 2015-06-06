package com.argh.processor;

/**
 * @author arghtype
 * @since 06.06.2015
 */
public class RGBColouredPoint {
    private int x;
    private int y;
    private int rgb;

    public RGBColouredPoint(int x, int y, int rgb) {
        this.x = x;
        this.y = y;
        this.rgb = rgb;
    }

    public int getRgb() {
        return rgb;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof RGBColouredPoint)) {
            return false;
        }
        RGBColouredPoint that = (RGBColouredPoint) other;
        return this.x == that.x && this.y == that.y;
    }

    @Override
    public int hashCode(){
        return (x * 31 + y * 31) * 31;
    }

}

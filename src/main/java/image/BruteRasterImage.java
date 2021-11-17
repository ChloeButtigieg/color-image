package image;

import javafx.scene.paint.Color;

public class BruteRasterImage extends RasterImage {
    private Color[][] pixels;

    public BruteRasterImage(Color color, int width, int height) {
        super(color, width, height);
    }

    public BruteRasterImage(Color[][] colors) throws NullPointerException, IllegalArgumentException {
        super(colors);
    }

    public void initializeRepresentation() {
        pixels = new Color[width][height];
    }

    public void setPixelColor(Color color, int x, int y) {
        pixels[x][y] = color;
    }

    @Override
    public Color getPixelColor(int x, int y) {
        return pixels[x][y];
    }

}

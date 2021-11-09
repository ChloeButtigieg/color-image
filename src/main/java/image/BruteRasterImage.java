package image;

import javafx.scene.paint.Color;
import util.Matrices;

public class BruteRasterImage implements Image {
    private Color[][] pixels;

    public BruteRasterImage(Color color, int width, int height) {
        pixels = new Color[height][width];
        for (int x = 0; x < height; x++) {
            for (int y = 0; y < width; y++) {
                pixels[x][y] = color;
            }
        }
    }
    public BruteRasterImage(Color[][] colors) throws NullPointerException, IllegalArgumentException {
        Matrices.requiresNonNull(colors);
        Matrices.requiresNonZeroDimensions(colors);
        Matrices.requiresRectangularMatrix(colors);
        pixels = new Color[Matrices.getRowCount(colors)][Matrices.getColumnCount(colors)];
        for (int x = 0; x < Matrices.getRowCount(colors); x++) {
            for (int y = 0; y < Matrices.getColumnCount(colors); y++) {
                pixels[x][y] = colors[x][y];
            }
        }
    }
    public void createRepresentation() {

    }

    public void setPixelColor(Color color, int x, int y) {
        pixels[x][y] = color;
    }

    @Override
    public Color getPixelColor(int x, int y) {
        return pixels[x][y];
    }

    private void setPixelsColor(Color[][] pixels) throws NullPointerException, IllegalArgumentException {
        Matrices.requiresNonNull(pixels);
        Matrices.requiresNonZeroDimensions(pixels);
        Matrices.requiresRectangularMatrix(pixels);
        for (int x = 0; x < Matrices.getRowCount(pixels); x++) {
            for (int y = 0; y < Matrices.getColumnCount(pixels); y++) {
                pixels[x][y] = pixels[x][y];
            }
        }
    }

    private void setPixelsColor(Color color) {
        for (int x = 0; x < Matrices.getRowCount(pixels); x++) {
            for (int y = 0; y < Matrices.getColumnCount(pixels); y++) {
                pixels[x][y] = color;
            }
        }
    }

    @Override
    public int getHeight() {
        return Matrices.getRowCount(pixels);
    }

    @Override
    public int getWidth() {
        return Matrices.getColumnCount(pixels);
    }

    protected void setWidth(int width) {
        Color[][] newPixels = new Color[Matrices.getRowCount(pixels)][width];
        for (int x = 0; x < Matrices.getRowCount(pixels); x++) {
            for (int y = 0; y < width; y++) {
                newPixels[x][y] = pixels[x][y];
            }
        }
        pixels = newPixels;
    }

    protected void setHeight(int height) {

    }
}

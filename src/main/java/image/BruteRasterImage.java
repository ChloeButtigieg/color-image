package image;

import javafx.scene.paint.Color;
import util.Matrices;

public class BruteRasterImage implements Image {
    private Color[][] pixels;
    private int width,height;

    public BruteRasterImage(Color color, int width, int height) {
        this.width = width;
        this.height = height;
        createRepresentation();
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                pixels[x][y] = color;
            }
        }
    }
    public BruteRasterImage(Color[][] colors) throws NullPointerException, IllegalArgumentException {
        Matrices.requiresNonNull(colors);
        Matrices.requiresNonZeroDimensions(colors);
        Matrices.requiresRectangularMatrix(colors);

        this.width = Matrices.getRowCount(colors);
        this.height = Matrices.getColumnCount(colors);
        createRepresentation();
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                pixels[x][y] = colors[x][y];
            }
        }
    }
    public void createRepresentation() {
        pixels = new Color[width][height];
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
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                this.pixels[x][y] = pixels[x][y];
            }
        }
    }

    private void setPixelsColor(Color color) {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                pixels[x][y] = color;
            }
        }
    }

    @Override
    public int getHeight() {
        return this.height;
    }

    @Override
    public int getWidth() {
        return this.width;
    }

    protected void setWidth(int width) {
        Color[][] newPixels = new Color[width][height];
        int maxWidth = Math.min(width, this.width);
        for (int x = 0; x < maxWidth; x++) {
            for (int y = 0; y < height; y++) {
                newPixels[x][y] = pixels[x][y];
            }
        }
        this.width = width;
        pixels = newPixels;
    }

    protected void setHeight(int height) {
        Color[][] newPixels = new Color[width][height];
        int maxHeight = Math.min(height, this.height);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < maxHeight; y++) {
                newPixels[x][y] = pixels[x][y];
            }
        }
        this.height = height;
        pixels = newPixels;
    }
}

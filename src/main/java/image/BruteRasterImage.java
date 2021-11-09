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

        this.width = Matrices.getColumnCount(colors);
        this.height = Matrices.getRowCount(colors);
        createRepresentation();
        for (int x = 0; x < height; x++) {
            for (int y = 0; y < width; y++) {
                pixels[x][y] = colors[x][y];
            }
        }
    }
    public void createRepresentation() {
        pixels = new Color[height][width];
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
        for (int x = 0; x < height; x++) {
            for (int y = 0; y < width; y++) {
                this.pixels[x][y] = pixels[x][y];
            }
        }
    }

    private void setPixelsColor(Color color) {
        for (int x = 0; x < height; x++) {
            for (int y = 0; y < width; y++) {
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
        Color[][] newPixels = new Color[height][width];
        int maxWidth = width;
        if (width > this.width) maxWidth = this.width;

        for (int x = 0; x < Matrices.getRowCount(pixels); x++) {
            for (int y = 0; y < maxWidth; y++) {
                newPixels[x][y] = pixels[x][y];
            }
        }
        this.width = width;
        pixels = newPixels;
    }

    protected void setHeight(int height) {
        Color[][] newPixels = new Color[height][width];
        int maxHeight = height;
        if (height > this.height) maxHeight = this.height;

        for (int x = 0; x < maxHeight; x++) {
            for (int y = 0; y < width; y++) {
                newPixels[x][y] = pixels[x][y];
            }
        }
        this.height = height;
        pixels = newPixels;
    }
}

package image;

import javafx.scene.paint.Color;
import util.Matrices;

public abstract class RasterImage implements Image {
    protected int width, height;

    public RasterImage(Color color, int width, int height) {
        this.width = width;
        this.height = height;
        initializeRepresentation();
        setPixelsColor(color);
    }

    public RasterImage(Color[][] pixels) throws NullPointerException, IllegalArgumentException {
        this.width = Matrices.getRowCount(pixels);
        this.height = Matrices.getColumnCount(pixels);
        initializeRepresentation();
        setPixelsColor(pixels);
    }

    public abstract void initializeRepresentation();
    public abstract void setPixelColor(Color color, int x, int y);
    public abstract Color getPixelColor(int x, int y);
    protected void setWidth(int width) {
        Color[][] newPixels = new Color[width][height];
        int maxWidth = Math.max(this.width, width);
        for (int x = 0; x < maxWidth; x++) {
            for (int y = 0; y < height; y++) {
                newPixels[x][y] = getPixelColor(x, y);
            }
        }
        this.width = width;
        initializeRepresentation();
        setPixelsColor(newPixels);
    }

    protected void setHeight(int height) {
        Color[][] newPixels = new Color[width][height];
        int maxHeight = Math.max(this.height, height);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < maxHeight; y++) {
                newPixels[x][y] = getPixelColor(x, y);
            }
        }
        this.height = height;
        initializeRepresentation();
        setPixelsColor(newPixels);
    }

    private void setPixelsColor(Color[][] pixels) throws NullPointerException, IllegalArgumentException {
        Matrices.requiresNonNull(pixels);
        Matrices.requiresNonZeroDimensions(pixels);
        Matrices.requiresRectangularMatrix(pixels);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                setPixelColor(pixels[x][y], x, y);
            }
        }
    }

    private void setPixelsColor(Color color) {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                setPixelColor(color, x, y);
            }
        }
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public int getWidth() {
        return width;
    }
}

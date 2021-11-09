package image;

import javafx.scene.paint.Color;
import util.Matrices;

import java.util.ArrayList;
import java.util.List;

public class PaletteRasterImage extends RasterImage implements Image {
    private List<Color> palette;
    private int[][] indexesOfColors;

    public PaletteRasterImage(Color color, int width, int height) {
        super(width, height);
        palette.add(color);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                indexesOfColors[x][y] = 0;
            }
        }
    }

    public PaletteRasterImage(Color[][] pixels) throws NullPointerException, IllegalArgumentException {
        super(Matrices.getRowCount(pixels), Matrices.getColumnCount(pixels));
        Matrices.requiresNonNull(pixels);
        Matrices.requiresNonZeroDimensions(pixels);
        Matrices.requiresRectangularMatrix(pixels);

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Color color = pixels[x][y];
                if (!(palette.contains(color))) palette.add(color);
                indexesOfColors[x][y] = palette.indexOf(color);
            }
        }
    }

    public void createRepresentation() {
        palette = new ArrayList<>();
        indexesOfColors = new int[width][height];
    }

    public void setPixelColor(Color color, int x, int y) {
        if (!(palette.contains(color))) palette.add(color);
        indexesOfColors[x][y] = palette.indexOf(color);
    }

    @Override
    public Color getPixelColor(int x, int y) {
        return palette.get(indexesOfColors[x][y]);
    }

    public void setPixelsColor(Color[][] pixels) throws NullPointerException, IllegalArgumentException {
        Matrices.requiresNonNull(pixels);
        Matrices.requiresNonZeroDimensions(pixels);
        Matrices.requiresRectangularMatrix(pixels);

        palette.clear();
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Color color = pixels[x][y];
                if (!(palette.contains(color))) palette.add(color);
                indexesOfColors[x][y] = palette.indexOf(color);
            }
        }
    }

    private void setPixelsColor(Color color) {
        palette.clear();
        palette.add(color);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                indexesOfColors[x][y] = 0;
            }
        }
    }

    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public int getHeight() {
        return this.height;
    }

    protected void setWidth(int width) {
        int[][] newIndexesOfColor = new int[width][height];
        List<Color> newPalette = new ArrayList<>();
        int maxWidth = Math.min(width, this.width);
        for (int x = 0; x < maxWidth; x++) {
            for (int y = 0; y < height; y++) {
                Color color = palette.get(indexesOfColors[x][y]);
                if (!(newPalette.contains(color))) newPalette.add(color);
                newIndexesOfColor[x][y] = indexesOfColors[x][y];
            }
        }
        this.width = width;
        palette = newPalette;
        indexesOfColors = newIndexesOfColor;
    }

    protected void setHeight(int height) {
        int[][] newIndexesOfColor = new int[width][height];
        List<Color> newPalette = new ArrayList<>();
        int maxHeight = Math.min(height, this.height);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < maxHeight; y++) {
                Color color = palette.get(indexesOfColors[x][y]);
                if (!(newPalette.contains(color))) newPalette.add(color);
                newIndexesOfColor[x][y] = indexesOfColors[x][y];
            }
        }
        this.height = height;
        palette = newPalette;
        indexesOfColors = newIndexesOfColor;

    }
}

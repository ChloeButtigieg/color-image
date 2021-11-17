package image;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class PaletteRasterImage extends RasterImage {
    private List<Color> palette;
    private int[][] indexesOfColors;

    public PaletteRasterImage(Color color, int width, int height) {
        super(color, width, height);
    }

    public PaletteRasterImage(Color[][] pixels) throws NullPointerException, IllegalArgumentException {
        super(pixels);
    }

    public void initializeRepresentation() {
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

}

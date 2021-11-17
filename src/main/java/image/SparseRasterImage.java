package image;

import javafx.scene.paint.Color;

import java.util.HashMap;
import java.util.Map;

public class SparseRasterImage extends RasterImage {
    private Map<Point, Color> pixels;

    public SparseRasterImage(Color color, int width, int height) {
        super(color, width, height);
    }

    public SparseRasterImage(Color[][] pixels) throws NullPointerException, IllegalArgumentException {
        super(pixels);
    }

    @Override
    public void initializeRepresentation() {
        pixels = new HashMap<>();
    }

    @Override
    public Color getPixelColor(int x, int y) {
        return pixels.get(new Point(x, y));
    }

    @Override
    public void setPixelColor(Color color, int x, int y) {
        pixels.put(new Point(x, y), color);
    }
}

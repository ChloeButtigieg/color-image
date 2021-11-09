package image;

import javafx.scene.paint.Color;

public abstract class RasterImage {
    protected int width, height;

    public RasterImage( int width, int height) {
        this.width = width;
        this.height = height;
        createRepresentation();
    }

    public abstract void createRepresentation();
    public abstract void setPixelColor(Color color, int x, int y);
    protected abstract void setWidth(int width);
    protected abstract void setHeight(int height);
}

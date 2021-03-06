package image;

public enum RasterImageType {
    BRUTE(0),
    PALETTE(1),
    SPARSE(2);

    private int type;

    private RasterImageType(int type) {
        this.type = type;
    }
}

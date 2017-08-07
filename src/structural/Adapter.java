package structural;

/**
 * Created by eugene on 07.08.17.
 */
public class Adapter {
    public static void main(String[] args) {
        VectorGraphics vectorGraphics = new VectorAdapterFromRaster();
        vectorGraphics.drawLine();
        vectorGraphics.drawSquare();

        VectorGraphics vectorGraphics2 = new VectorAdapterFromRaster2(new RasterGraphics());
        vectorGraphics2.drawLine();
        vectorGraphics2.drawSquare();
    }
}

interface VectorGraphics {
    void drawLine();

    void drawSquare();
}

class RasterGraphics {
    void drawRasterLine() {
        System.out.println("Draw line");
    }

    void drawRasterSquare() {
        System.out.println("draw square");
    }
}

class VectorAdapterFromRaster extends RasterGraphics implements VectorGraphics {
    @Override
    public void drawLine() {
        drawRasterLine();
    }

    @Override
    public void drawSquare() {
        drawRasterSquare();
    }
}

class VectorAdapterFromRaster2 implements VectorGraphics {
    RasterGraphics rasterGraphics;

    public VectorAdapterFromRaster2(RasterGraphics rasterGraphics) {
        this.rasterGraphics = rasterGraphics;
    }

    @Override
    public void drawLine() {
        rasterGraphics.drawRasterLine();
    }

    @Override
    public void drawSquare() {
        rasterGraphics.drawRasterSquare();
    }
}
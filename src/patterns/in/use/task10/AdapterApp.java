package patterns.in.use.task10;

/**
 * Created by eugene on 10.08.17.
 */
public class AdapterApp {
    public static void main(String[] args) {
            DVI dvi = new SVGADVIadapter();
            dvi.connect();
    }
}
interface DVI{
    void connect();
}
class SVGA{
    void connectSVGA(){
        System.out.println("SVGA.connectSVGA");
    }
}
class SVGADVIadapter extends SVGA implements DVI{
    @Override
    public void connect() {
        connectSVGA();
    }
}
import java.awt.geom.Point2D;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;
import model.PositionHistogram;
import model.Simulation;

/**
 *
 * @author tadaki
 */
public class CLIMain {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        int n = 100000;
        int tmax = 1000;
        double p = 0.5;
        Simulation sys = new Simulation(n,p);
        for (int t = 0; t < tmax; t++) {
            sys.oneStep();
        }
        List<Point2D.Double> plist
                = PositionHistogram.getHist(sys.getWalkers());
        String filename = Simulation.class.getSimpleName()
                + "-output-" + String.valueOf(n) + "-"+String.valueOf(p)+ ".txt";
        try (BufferedWriter out
                = myLib.utils.FileIO.openWriter(filename)) {
            for (Point2D.Double pp : plist) {
                myLib.utils.FileIO.writeSSV(out, pp.x, pp.y);
            }
        }
    }

}

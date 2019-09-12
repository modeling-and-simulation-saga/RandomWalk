import java.util.List;
import java.awt.geom.Point2D;

model.Simulation sys;
final int n=100000;//number of walkers
final int tmax=1000;
final int xmax=100;
final int xsize=1000;
final int ysize=1000;
final double p=0.5;//probability of moving right
int t=0;
final float fx = xsize/2./xmax;
final float fy = 10000.;
void setup(){
  size(1000,1000);
  smooth();
  frameRate(10);
  sys = new Simulation(n,p);
}

void draw(){
  if ( t%tmax==0){
    t=0;
    sys = new Simulation(n,p);
  }
  background(255);
  fill(255,0,0);
  sys.oneStep();
  List<Point2D.Double> plist
                = model.PositionHistogram.getHist(sys.getWalkers());
  for(int i=0;i<plist.size();i++){
    float x = (float)plist.get(i).x;
    float y = (float)plist.get(i).y;
    rect((x+xmax-1)*fx,ysize-20-y*fy,2*fx,y*fy);
  }
  t++;
}

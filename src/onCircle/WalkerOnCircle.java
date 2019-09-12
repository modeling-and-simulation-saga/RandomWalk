package onCircle;

import model.Walker;

/**
 *
 * @author tadaki
 */
public class WalkerOnCircle extends Walker{
    private final int length;

    public WalkerOnCircle(int length, int x) {
        super(x);
        this.length = length;
    }

    public WalkerOnCircle(int length, int x, double p) {
        super(x, p);
        this.length = length;
    }

    @Override
    public int walk() {
        x = super.walk();
        x = (x+length)%length;
        return x; //
    }
    
    
}

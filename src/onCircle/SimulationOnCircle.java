package onCircle;
import java.util.List;
import model.Walker;
import myLib.utils.Utils;

/**
 * 一次元酔歩モデルのシミュレーション
 *
 * 多数のwalkerを同時に動かす
 *
 * @author tadaki
 */
public class SimulationOnCircle {

    private final List<WalkerOnCircle> walkers;//Walkerのリスト
    private double p;//右への移動確率
    private int n;//walkerの数
    private int length;

    /**
     * コンストラクタ
     *
     * @param n walkerの数
     */
    public SimulationOnCircle(int length,int n) {
        this(length,n, 0.5);//下に記述された標準コンストラクタを呼ぶ
    }

    /**
     * コンストラクタ
     *
     * @param n walkerの数
     * @param p 右への移動確率
     */
    public SimulationOnCircle(int length,int n, double p) {
        walkers = Utils.createList();
        this.p = p;
        this.n = n;
        this.length = length;
        // Walkerを初期化
        for (int i = 0; i < n; i++) {
            walkers.add(new WalkerOnCircle(length,0, p));
        }
    }

    /**
     * 全てのWalkerの情報を消去し、新たにリストを生成
     */
    public void initialize() {
        walkers.clear();
        for (int i = 0; i < n; i++) {
            walkers.add(new WalkerOnCircle(length,0, p));
        }
    }

    /**
     * 一時間ステップの動作
     *
     * @return 更新したWalkerの位置の一覧
     */
    public List<Integer> oneStep() {
        List<Integer> pList = Utils.createList();
        //リストwalkers中の各要素にたいして、移動を行う
        //さらに、それぞれの位置をpListに格納する
        for (WalkerOnCircle w : walkers) {
            int x = w.walk();
            pList.add(x);
        }
        return pList;
    }

    public List<Walker> getWalkers() {
        List<Walker> list = Utils.createList();
        for(WalkerOnCircle w:walkers){
            list.add(w);
        }
        return list;
    }

    public void setP(double p) {
        this.p = p;
    }

    public void setN(int n) {
        this.n = n;
    }

}


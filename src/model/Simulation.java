package model;

import java.util.List;
import myLib.utils.Utils;

/**
 * 一次元酔歩モデルのシミュレーション
 *
 * 多数のwalkerを同時に動かす
 *
 * @author tadaki
 */
public class Simulation {

    private final List<Walker> walkers;//Walkerのリスト
    private double p;//右への移動確率
    private int n;//walkerの数

    /**
     * コンストラクタ
     *
     * @param n walkerの数
     */
    public Simulation(int n) {
        this(n, 0.5);//下に記述された標準コンストラクタを呼ぶ
    }

    /**
     * コンストラクタ
     *
     * @param n walkerの数
     * @param p 右への移動確率
     */
    public Simulation(int n, double p) {
        walkers = Utils.createList();
        this.p = p;
        this.n = n;
        // Walkerを初期化
        for (int i = 0; i < n; i++) {
            walkers.add(new Walker(0, p));
        }
    }

    /**
     * 全てのWalkerの情報を消去し、新たにリストを生成
     */
    public void initialize() {
        walkers.clear();
        for (int i = 0; i < n; i++) {
            walkers.add(new Walker(0, p));
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
        for (Walker w : walkers) {
            int x = w.walk();
            pList.add(x);
        }
        return pList;
    }

    public List<Walker> getWalkers() {
        return walkers;
    }

    public void setP(double p) {
        this.p = p;
    }

    public void setN(int n) {
        this.n = n;
    }

}

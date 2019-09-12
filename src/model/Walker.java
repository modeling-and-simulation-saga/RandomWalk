package model;/** * Walkerのクラス * * 一つのrandom walkを表す * * @author tadaki */public class Walker {    protected int x;//Walkerの位置    protected final double p;//右に動く確率    /**     * コンストラクタ     *     * @param x 初期位置     */    public Walker(int x) {        this(x, 0.5);//右への移動確率は1/2    }    /**     * コンストラクタ     *     * @param x 初期位置     * @param p 右への移動確率     */    public Walker(int x, double p) {        this.x = x;        this.p = p;    }    /**     * 一時間ステップの移動     *     * @return 新しい位置     */    public int walk() {        double r = Math.random();        /**        * 確率p でxを一つ増やす        * 確率1-p でxを一つ減らす        **/                                        return x;    }    /**     * 現在の位置を返す     * @return      */    public int getX() {        return x;    }}
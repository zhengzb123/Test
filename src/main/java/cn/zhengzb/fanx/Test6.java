package cn.zhengzb.fanx;

/**
 * 泛型基础 之 泛型方法
 * Created by zhengzb on 2019/3/10 14:52
 */
public class Test6 {

    //声明一个泛型方法很简单，只要在返回类型前面加上一个类似<K, V>的形式就行了：
    public static <K,V> boolean compare(Pair<K,V> p1, Pair<K,V> p2){
        return p1.getKey().equals(p2.getKey()) &&
                p1.getValue().equals(p2.getValue());
    }

    public static void main(String[] args) {
        Pair<Integer, String> p1 = new Pair<>(1, "apple");
        Pair<Integer, String> p2 = new Pair<>(2, "pear");
        boolean same = Test6.compare(p1, p2);
        System.out.println(same);
    }


}

class Pair<K,V>{
    private K key;
    private V value;
    public Pair(K key, V value){
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}

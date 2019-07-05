package cn.zhengzb.lambda;

import java.util.Arrays;
import java.util.List;

/**
 * Created by zhengzb on 2019/3/17 17:55
 */
public class Lambda6 {
    public static void main(String[] args) {
        // 新方法：
        List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
        double bill = costBeforeTax.stream().map((cost) -> cost + cost*0.12).reduce((sum,cost) -> sum+cost ).get();
        System.out.println("Total : " + bill);
    }
}

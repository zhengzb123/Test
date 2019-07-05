package cn.zhengzb.j8sz.chapter2;

import cn.zhengzb.common.Artist;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhengzb on 2019/7/4 13:59
 */
public class page35 {

    public static void main(String[] args) {
        Artist artist1 = new Artist("zhangsan", 20, "London");
        Artist artist2 = new Artist("lishi", 27, "London");
        Artist artist3 = new Artist("wangwu", 30, "shanghai");
        List allArtists = new ArrayList();
        allArtists.add(artist1);
        allArtists.add(artist2);
        allArtists.add(artist3);

        System.out.println("惰性求值：");
        allArtists.stream().max()
                .filter(artist -> {
                    System.out.println(artist.toString());
                    return true;
                });

        System.out.println("及早求值：");
        allArtists.stream()
                .filter(artist -> {
                    System.out.println(artist.toString());
                    return true;
                }).count();

    }

}

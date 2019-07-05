package cn.zhengzb.j8sz.chapter1;

import java.io.File;
import java.io.FileFilter;

/**
 * Created by zhengzb on 2019/5/5 16:03
 */
public class page10 {

    public static void main(String[] args) {

        //筛选隐藏文件
        File[] hiddenFiles = new File(".").listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.isHidden();
            }
        });


        //jdk1.8 写法
        File[] hiddenFiles1 = new File(".").listFiles(File::isHidden);
    }
}

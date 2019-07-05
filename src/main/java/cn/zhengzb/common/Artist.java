package cn.zhengzb.common;

import java.io.Serializable;

/**
 * Created by zhengzb on 2019/7/4 14:09
 */
public class Artist implements Serializable {
    private String name;
    private int age;
    private String from;
    public Artist(){
        super();
    }
    public Artist(String name, int age, String from){
        this.name = name;
        this.age = age;
        this.from = from;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public boolean isFrom(String from){
        if(from != null && from.equals(this.from)){
            return true;
        }
        return false;
    }
}

package com.liuhui.demo.test;

import java.util.ArrayList;

//运行时常量池内存溢出
//VM Args：-XX:PermSize=10M -XX:MaxPermSize=10M
public class RuntimeConstantPoolOOM {
    //JDK1.6及之前的版本中，由于常量池分配在永久代中，我们可以通过限制方法区大小，
    //间接限制常量池容量，产生运行时常量池内存溢出
    public static void main(String[] args) {
        //使用List保持着常量池引用，避免Full GC回收常量池行为
        ArrayList<String> list = new ArrayList<>();
        //10MB的PermSize在integer范围内足够产生OOM了
        int i = 0;
        while (true){
            list.add(String.valueOf(i++).intern());
        }
    }
}

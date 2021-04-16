package com.liuhui.demo.test;

import java.util.ArrayList;
import java.util.List;

/**
 * 如果要执行一下代码，记得先保存当前工作。由于在Windows平台的虚拟机中，java的线程是映射到操作系统的内核线程上的，
 * 因此以下代码执行时有较大的风险，可能导致操作系统假死
 */
//java堆溢出
//VM Args：-Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
public class HeapOOM {
    static class OOMObject{
    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<OOMObject>();
        while (true){
            list.add(new OOMObject());
        }
    }
}

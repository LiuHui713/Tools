package com.liuhui.demo.util;

import org.junit.Test;
import org.springframework.util.StringUtils;

public class LeetcodeProblem {
    @Test
    public void test1(){
        int [] map = new int[128];
        System.out.println( map[97]);
    }

    //返回无重复字符的最长子串的长度
    public int lengthOfLongestSubstring(String s){
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            System.out.println(chars[i]);
        }
        return 0;
    }
}

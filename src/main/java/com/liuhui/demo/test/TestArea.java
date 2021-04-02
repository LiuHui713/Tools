package com.liuhui.demo.test;

import com.liuhui.demo.bean.Article;
import org.junit.Test;
import org.springframework.cglib.beans.BeanMap;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class TestArea {

    @Test//对象放入map后再设置值，依旧有效
    public void test4(){
        HashMap<Object, Object> mapInner = new HashMap<>();
        HashMap<Object, Object> mapOuter = new HashMap<>();
        mapOuter.put("innerMap",mapInner);
        mapInner.put("后设置的值","111");
        System.out.println(mapOuter);
    }
    @Test//String.replaceAll
    public void test3(){
        String content = "12345678910";
        content = content.replace("1","s");
        System.out.println(content);
    }
    @Test//beanToMap
    public void test2(){
        Article article = new Article();
        article.setAuthor("LiuHui");
        article.setContent("正文start……正文end");
        article.setDate(DateFormat.getDateInstance().format(new Date()));
        article.setTitle("页面静态化");
        Map data = new HashMap<>();
        data.put("article",beanToMap(article));
        System.out.println(data);
    }
    //对象转map
    private Map<String, String> beanToMap(Object bean){
        Map<String, String> map = new HashMap<>();
        BeanMap beanMap = BeanMap.create(bean);
        beanMap.forEach((key, value) -> {
            map.put(String.valueOf(key), String.valueOf(value));
        });
        return map;
    }
    @Test//时间格式化
    public void test1(){
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        String addTime = formatter.format(date);
        System.out.printf(addTime);
    }

}

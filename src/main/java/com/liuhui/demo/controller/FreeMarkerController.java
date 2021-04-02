package com.liuhui.demo.controller;

import com.liuhui.demo.bean.Article;
import com.liuhui.demo.bean.Catalog;
import com.liuhui.demo.util.FreeMarker;
import org.junit.Test;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/freemarker")
public class FreeMarkerController {

    @RequestMapping("/ftlToHtml")
    public void ftlToHtml() throws Exception {
        Map data = new HashMap<>();
        Article article = new Article();
        article.setAuthor("LiuHui");
        article.setContent("正文start……正文end");
        article.setDate(DateFormat.getDateInstance().format(new Date()));
        article.setTitle("页面静态化");
        Catalog catalog = new Catalog();
        catalog.setName("测试栏目");
        data.put("article",article);
        data.put("catalog",catalog);
        FreeMarker freeMarker = new FreeMarker();
        freeMarker.ftlToHtml(data);
    }

}

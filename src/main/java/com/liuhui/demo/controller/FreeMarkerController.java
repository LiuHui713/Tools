package com.liuhui.demo.controller;

import com.liuhui.demo.bean.Article;
import com.liuhui.demo.bean.Catalog;
import com.liuhui.demo.util.FreeMarker;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
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

    //数据模型中包含集合
    @RequestMapping("/ftlToHtml2")
    public void ftlToHtml2() throws Exception {
        Map catalogData = new HashMap<>();
        List articlePage = new ArrayList<>();
        Catalog catalog = new Catalog();
        catalog.setName("测试栏目");
        catalog.setListPage(2L);
        catalog.setListPageSize(2L);
        catalogData.put("Catalog",catalog);
        int listPage = 2;
        int listPageSize = 2;
        for (int i = 0; i < listPage; i++) {
            ArrayList<Article> articles = new ArrayList<>();
            for (int j = 0; j < listPageSize; j++) {
                Article article = new Article();
                article.setTitle("文稿"  + (i + 1) + "." + (j + 1));
                article.setDate(DateFormat.getDateInstance().format(new Date()));
                article.setContent("正文部分开始……");
                articles.add(article);
            }
            articlePage.add(articles);
        }
        catalogData.put("ArticlePage",articlePage);
        FreeMarker freeMarker = new FreeMarker();
        freeMarker.ftlToHtml2(catalogData);
    }
}

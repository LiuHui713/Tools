package com.liuhui.demo.util;

import freemarker.template.Configuration;
import freemarker.template.Template;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class FreeMarker {
    private static final String PATH = "/templates/" ;

    //ftl文件转静态页面
    public void ftlToHtml(Map data) throws Exception {
        // 创建配置类
        Configuration configuration = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
        // 设置模板路径
        String classpath = this.getClass().getResource("/").getPath();
        File file = new File(classpath + PATH);
        configuration.setDirectoryForTemplateLoading(file);
        // 获取模板
        Template template = configuration.getTemplate("freemarkerDemo.ftl");
        // 合并模板和数据模型
        String content = FreeMarkerTemplateUtils.processTemplateIntoString(template, data);
        System.out.println("content:{}" + content);
        InputStream inputStream = new ByteArrayInputStream(content.getBytes("UTF-8"));
        // 输出文件到指定目录
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        String fileName = "D:/workfiles/huaqiyun/PC/" + formatter.format(date) + "/FreeMarkerStaticPage.html";
        File file1 = new File(fileName);
        String filePath = fileName.substring(0, fileName.lastIndexOf('/'));
        File f = new File(filePath);
        if (!f.exists()) {
            f.mkdirs();
        }
        file1.createNewFile();
        FileOutputStream fileOutputStream = new FileOutputStream(file1);
        IOUtils.copy(inputStream, fileOutputStream);
        // 关闭流
        inputStream.close();
        fileOutputStream.close();
    }
}

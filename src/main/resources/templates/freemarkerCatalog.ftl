<html>
<head>
    <title>PageStatic-FreeMarker</title>
</head>
<body>
<ul>
    栏目名：${Catalog.name}<br>
    <br>
    <#list ArticlePage as page>
        <table border="1">
        <tr>
            <th>文章标题</th>
            <th>日期</th>
            <th>正文</th>
        </tr>
        <#list page as article>
            <tr>
                <td>${article.title}</td>
                <td>${article.date?string("yyyy-MM-dd HH:mm:ss")}</td>
                <td>${article.content}</td>
            </tr>
        </#list>
        </table>
        <br>
    </#list>
</ul>
</body>
</html>
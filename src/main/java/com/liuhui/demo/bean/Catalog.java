package com.liuhui.demo.bean;

public class Catalog {
    private Long id;
    private String name;
    private Long parentId;
    private Long listPageSize;

    public Long getListPageSize() {
        return listPageSize;
    }

    public void setListPageSize(Long listPageSize) {
        this.listPageSize = listPageSize;
    }

    public Long getListPage() {
        return listPage;
    }

    public void setListPage(Long listPage) {
        this.listPage = listPage;
    }

    private Long listPage;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
}

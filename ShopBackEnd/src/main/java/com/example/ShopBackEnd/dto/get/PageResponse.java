package com.example.ShopBackEnd.dto.get;

import java.util.List;

public class PageResponse <T> {
    private int pageNumber;
    private int pageSize;
    private List<T> contents;

    public PageResponse(int pageNumber, int pageSize, List<T> contents) {
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.contents = contents;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getContents() {
        return contents;
    }

    public void setContents(List<T> contents) {
        this.contents = contents;
    }
}

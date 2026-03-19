package com.darkenderhilda.alienized.foundation.utils;

public class PageHandler {

    private int currentPage = 1;
    private int pageCount = 1;

    public void prevPage() {
        if(currentPage == 1) {
            currentPage = pageCount;
        } else {
            currentPage--;
        }
    }

    public void nextPage() {
        if(currentPage == pageCount) {
            currentPage = 1;
        } else {
            currentPage++;
        }
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int pageIn) {
        if(pageIn > pageCount) {
            currentPage = pageCount;
            return;
        }

        if(pageIn < 1) {
            currentPage = 1;
            return;
        }

        currentPage = pageIn;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
}

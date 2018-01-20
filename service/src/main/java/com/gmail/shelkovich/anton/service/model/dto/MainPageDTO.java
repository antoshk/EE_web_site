package com.gmail.shelkovich.anton.service.model.dto;

import java.util.List;

public class MainPageDTO {
    private List<MainPagePieceOfNewsDTO> latestNews;
    private List<MainPageProductDTO> popularAndNewProducts;

    public List<MainPagePieceOfNewsDTO> getLatestNews() {
        return latestNews;
    }

    public void setLatestNews(List<MainPagePieceOfNewsDTO> latestNews) {
        this.latestNews = latestNews;
    }

    public List<MainPageProductDTO> getPopularAndNewProducts() {
        return popularAndNewProducts;
    }

    public void setPopularAndNewProducts(List<MainPageProductDTO> popularAndNewProducts) {
        this.popularAndNewProducts = popularAndNewProducts;
    }
}

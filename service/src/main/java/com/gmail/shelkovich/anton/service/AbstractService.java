package com.gmail.shelkovich.anton.service;

import com.gmail.shelkovich.anton.repository.dao.DaoList;
import com.gmail.shelkovich.anton.service.model.Pagination;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractService {

    @Autowired
    protected DaoList daoList;

    Pagination getAbstractPagination(Pagination pagination, Integer currentPage, int totalItems, int itemsPerPage) {
        int pageCount = (int) Math.ceil(totalItems / (double) itemsPerPage);
        if (currentPage == null){
            currentPage = 1;
        }
        pagination.setCurrentPage(currentPage);
        pagination.setTotalPages(pageCount);
        if (currentPage < pagination.getTotalPages()) {
            pagination.setNextPage(currentPage + 1);
        } else {
            pagination.setNextPage(0);
        }

        if (currentPage > 1) {
            pagination.setPrevPage(currentPage - 1);
        } else {
            pagination.setPrevPage(0);
        }

        return pagination;
    }

}

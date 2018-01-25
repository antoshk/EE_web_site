package com.gmail.shelkovich.anton.service;

import com.gmail.shelkovich.anton.repository.dao.DaoFabric;
import com.gmail.shelkovich.anton.service.DtoConstructor.impl.EntityDtoConstructorImpl;
import com.gmail.shelkovich.anton.service.model.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public abstract class AbstractService {

    @Autowired
    @Qualifier("daoFabric")
    protected DaoFabric daoFabric;

    @Autowired
    protected EntityDtoConstructorImpl dtoConstructor;

    protected int calculatePageCount(int total, int perPage){
        return (int)Math.ceil(total/(double)perPage);
    }

    public Pagination getAbstractPagination(Pagination pagination, int currentPage, int totalItems){
        pagination.setCurrentPage(currentPage);
        pagination.setTotalPages(totalItems);
        if(currentPage < pagination.getTotalPages()){
            pagination.setNextPage(currentPage+1);
        }else{
            pagination.setNextPage(0);
        }

        if(currentPage > 1){
            pagination.setPrevPage(currentPage-1);
        } else {
            pagination.setPrevPage(0);
        }

        return pagination;
    }

}

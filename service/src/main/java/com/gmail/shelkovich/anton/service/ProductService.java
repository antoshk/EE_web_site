package com.gmail.shelkovich.anton.service;

import com.gmail.shelkovich.anton.repository.dao.SortOrder;
import com.gmail.shelkovich.anton.repository.model.Product;
import com.gmail.shelkovich.anton.service.converter.ProductConverter;
import com.gmail.shelkovich.anton.service.model.Pagination;
import com.gmail.shelkovich.anton.service.model.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService extends AbstractService {

    @Autowired
    private Pagination pagination;

    @Transactional(readOnly = true)
    public List<ProductDTO> getMainPageProducts(){
        return getByPageAndOrder(6, 1, SortOrder.RANDOM);
    }

    @Transactional(readOnly = true)
    public List<ProductDTO> getByPage(int count, Integer page) {
        return getByPageAndOrder(count, page, SortOrder.ASC);
    }

    @Transactional(readOnly = true)
    public List<ProductDTO> getByPageAndOrder(int count, Integer page, SortOrder order){
        if (page == null){
            page = 1;
        }
        List<ProductDTO> productDTOList = new ArrayList<>();
        List<Product> products = daoList.getProductDao().getPage(count, page, order);
        for(Product product: products){
            ProductDTO productDTO = ProductConverter.toDTO(product);
            String description = productDTO.getDescription();
            if (description.length() > 140) {
                description = description.substring(0, 140) + "...";
                productDTO.setDescription(description);
            }
            productDTOList.add(productDTO);
        }
        return productDTOList;
    }

    @Transactional(readOnly = true)
    public ProductDTO getById(long id){
        Product product = daoList.getProductDao().getById(id);
        ProductDTO productDTO = ProductConverter.toDTO(product);
        return productDTO;
    }

    @Transactional(readOnly = true)
    public int getPageCount(int perPage){
        int total = daoList.getProductDao().getRowCount();
        return calculatePageCount(total, perPage);
    }

    @Transactional(readOnly = true)
    public Pagination getPagination(int itemsPerPage, Integer currentPage){
        return getAbstractPagination(pagination, currentPage, getPageCount(itemsPerPage));
    }

}

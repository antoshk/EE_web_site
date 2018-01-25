package com.gmail.shelkovich.anton.service;

import com.gmail.shelkovich.anton.repository.dao.SortOrder;
import com.gmail.shelkovich.anton.repository.model.Product;
import com.gmail.shelkovich.anton.service.model.Pagination;
import com.gmail.shelkovich.anton.service.model.dto.entity.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService extends AbstractService {

    @Autowired
    Pagination pagination;

    @Transactional(readOnly = true)
    public List<ProductDTO> getMainPageProducts(){
        return getProductsByPageAndOrder(6, 1, SortOrder.RANDOM);
    }

    @Transactional(readOnly = true)
    public List<ProductDTO> getProductsByPage(int count, int page) {
        return getProductsByPageAndOrder(count, page, SortOrder.ASC);
    }

    @Transactional(readOnly = true)
    public List<ProductDTO> getProductsByPageAndOrder(int count, int page, int order){
        List<ProductDTO> productDTOList = new ArrayList<>();
        List<Product> products = daoFabric.productDao.getPage(count, page, order);
        for(Product product: products){
            ProductDTO productDTO = dtoConstructor.getProductDTO(product);
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
    public ProductDTO getProductById(long id){
        Product product = daoFabric.productDao.getById(id);
        ProductDTO productDTO = dtoConstructor.getProductDTO(product);
        return productDTO;
    }

    @Transactional(readOnly = true)
    public int getPageCount(int perPage){
        int total = daoFabric.productDao.getRowCount();
        return calculatePageCount(total, perPage);
    }

    @Transactional(readOnly = true)
    public Pagination getPagination(int itemsPerPage, int currentPage){
        return getAbstractPagination(pagination, currentPage, getPageCount(itemsPerPage));
    }

}

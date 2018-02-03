package com.gmail.shelkovich.anton.service;

import com.gmail.shelkovich.anton.repository.dao.SortOrder;
import com.gmail.shelkovich.anton.service.model.Pagination;
import com.gmail.shelkovich.anton.service.model.dto.ProductDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProductService {
    @Transactional(readOnly = true)
    List<ProductDTO> getMainPageProducts();

    @Transactional(readOnly = true)
    List<ProductDTO> getByPage(int count, Integer page);

    @Transactional(readOnly = true)
    List<ProductDTO> getByPageAndOrder(int count, Integer page, SortOrder order);

    @Transactional(readOnly = true)
    ProductDTO getById(long id);

    @Transactional(readOnly = true)
    Pagination getPagination(int itemsPerPage, Integer currentPage);

    @Transactional
    void updateProduct(ProductDTO product);

    @Transactional
    void addNew(ProductDTO product);

    @Transactional
    void delete(Long id);
}

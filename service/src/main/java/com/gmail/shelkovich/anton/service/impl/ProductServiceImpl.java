package com.gmail.shelkovich.anton.service.impl;

import com.gmail.shelkovich.anton.repository.dao.SortOrder;
import com.gmail.shelkovich.anton.repository.model.Product;
import com.gmail.shelkovich.anton.service.FileService;
import com.gmail.shelkovich.anton.service.ProductService;
import com.gmail.shelkovich.anton.service.converter.ProductConverter;
import com.gmail.shelkovich.anton.service.model.Pagination;
import com.gmail.shelkovich.anton.service.model.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl extends AbstractService implements ProductService {

    @Autowired
    private Pagination pagination;

    @Value("${service.product.shortenDescription.length:140}")
    private Integer shortenDescriptionLength;

    @Autowired
    private FileService fileService;

    @Override
    @Transactional(readOnly = true)
    public List<ProductDTO> getMainPageProducts(){
        return getByPageAndOrder(6, 1, SortOrder.RANDOM);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductDTO> getByPage(int count, Integer page) {
        return getByPageAndOrder(count, page, SortOrder.ASC);
    }

    @Override
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
            if (description.length() > shortenDescriptionLength) {
                description = description.substring(0, shortenDescriptionLength) + "...";
                productDTO.setDescription(description);
            }
            productDTOList.add(productDTO);
        }
        return productDTOList;
    }

    @Override
    @Transactional(readOnly = true)
    public ProductDTO getById(long id){
        Product product = daoList.getProductDao().getById(id);
        return ProductConverter.toDTO(product);
    }

    @Override
    @Transactional(readOnly = true)
    public Pagination getPagination(int itemsPerPage, Integer currentPage){
        int total = daoList.getProductDao().getRowCount();
        return getAbstractPagination(pagination, currentPage, total, itemsPerPage);
    }

    @Override
    @Transactional
    public void updateProduct(ProductDTO product){
        ProductDTO old = getById(product.getId());
        if(product.getImageURI() == null){
            product.setImageURI(old.getImageURI());
        }
        product.setActive(true);
        daoList.getProductDao().update(ProductConverter.fromDTO(product));
    }

    @Override
    @Transactional
    public void addNew(ProductDTO product){
        product.setActive(true);
        daoList.getProductDao().add(ProductConverter.fromDTO(product));
    }

    @Override
    @Transactional
    public void delete(Long id){
        Product product = daoList.getProductDao().getById(id);
        product.setActive(false);
    }

}

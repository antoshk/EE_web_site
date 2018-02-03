package com.gmail.shelkovich.anton.service;

import com.gmail.shelkovich.anton.service.model.Pagination;
import com.gmail.shelkovich.anton.service.model.dto.PieceOfNewsDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface NewsService {
    @Transactional(readOnly = true)
    List<PieceOfNewsDTO> getMainPageNews();

    @Transactional(readOnly = true)
    List<PieceOfNewsDTO> getShortenNewsByPage(int count, Integer page);

    @Transactional(readOnly = true)
    Pagination getPagination(int itemsPerPage, Integer currentPage);

    @Transactional(readOnly = true)
    PieceOfNewsDTO getById(long id);

    @Transactional(readOnly = true)
    List<PieceOfNewsDTO> getAll();

    @Transactional
    void addNewComment(String message, Long newsId);

    @Transactional
    void updateNews(PieceOfNewsDTO pieceOfNews);

    @Transactional
    void addNew(PieceOfNewsDTO pieceOfNews);

    @Transactional
    void delete(Long id);

    @Transactional
    void deleteComment(Long id);
}

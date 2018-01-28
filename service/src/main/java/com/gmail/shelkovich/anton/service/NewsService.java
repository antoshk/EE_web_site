package com.gmail.shelkovich.anton.service;

import com.gmail.shelkovich.anton.repository.dao.SortOrder;
import com.gmail.shelkovich.anton.repository.model.PieceOfNews;
import com.gmail.shelkovich.anton.service.converter.NewsConverter;
import com.gmail.shelkovich.anton.service.model.dto.PieceOfNewsDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class NewsService extends AbstractService {

    @Transactional(readOnly = true)
    public List<PieceOfNewsDTO> getMainPageNews() {
        List<PieceOfNews> news = daoList.getNewsDao().getPage(3,1, SortOrder.DESC);
        List<PieceOfNewsDTO> newsDTO = new ArrayList<>();
        for (PieceOfNews pieceOfNews : news) {
            PieceOfNewsDTO pieceOfNewsDTO = NewsConverter.toDTO(pieceOfNews, false);
            String body = pieceOfNewsDTO.getNewsBody();
            if (body.length() > 140) {
                body = body.substring(0, 140) + "...";
                pieceOfNewsDTO.setNewsBody(body);
            }
            newsDTO.add(pieceOfNewsDTO);
        }
        return newsDTO;
    }
}

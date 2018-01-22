package com.gmail.shelkovich.anton.service;

import com.gmail.shelkovich.anton.repository.dao.DaoFabric;
import com.gmail.shelkovich.anton.repository.dao.impl.NewsDaoImpl;
import com.gmail.shelkovich.anton.repository.model.PieceOfNews;
import com.gmail.shelkovich.anton.service.DtoConstructor.impl.EntityDtoConstructorImpl;
import com.gmail.shelkovich.anton.service.model.dto.entity.PieceOfNewsDTO;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class NewsService {

    @Autowired
    @Qualifier("daoFabric")
    private DaoFabric daoFabric;

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private EntityDtoConstructorImpl dtoConstructor;

    @Transactional(readOnly = true)
    public List<PieceOfNewsDTO> getMainPageNews() {
        List<PieceOfNews> news = daoFabric.newsDao.getPage(3,1,false);
        List<PieceOfNewsDTO> newsDTO = new ArrayList<>();
        for (PieceOfNews pieceOfNews : news) {
            PieceOfNewsDTO pieceOfNewsDTO = dtoConstructor.getPieceOfNewsDTO(pieceOfNews, false);
            String body = pieceOfNewsDTO.getNewsBody();
            if (body.length() > 140) {
                body = body.substring(0, 140) + "...";
            }
            pieceOfNewsDTO.setNewsBody(body);
            newsDTO.add(pieceOfNewsDTO);
        }
        return newsDTO;
    }
}

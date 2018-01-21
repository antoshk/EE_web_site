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
public class TempService {

    @Autowired
    @Qualifier("daoFabric")
    private DaoFabric daoFabric;

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private EntityDtoConstructorImpl dtoConstructor;

    @Transactional(readOnly = true)
    public List<PieceOfNewsDTO> getNews(){
        //sessionFactory.getCurrentSession().beginTransaction();

        List<PieceOfNews> news = daoFabric.newsDao.getAll();
        List<PieceOfNewsDTO> newsDTO = new ArrayList<>();
        for (PieceOfNews pieceOfNews: news){
            newsDTO.add(dtoConstructor.getPieceOfNewsDTO(pieceOfNews, false));
        }
        //sessionFactory.getCurrentSession().getTransaction().commit();
        return newsDTO;
    }
}

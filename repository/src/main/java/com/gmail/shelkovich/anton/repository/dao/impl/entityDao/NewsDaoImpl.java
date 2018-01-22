package com.gmail.shelkovich.anton.repository.dao.impl.entityDao;

import com.gmail.shelkovich.anton.repository.dao.impl.GenericDaoImpl;
import com.gmail.shelkovich.anton.repository.model.PieceOfNews;
import org.springframework.stereotype.Repository;

@Repository("newsDAO")
public class NewsDaoImpl extends GenericDaoImpl<PieceOfNews, Long> {

    public NewsDaoImpl() {
        super(PieceOfNews.class);
    }
}

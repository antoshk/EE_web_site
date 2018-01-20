package com.gmail.shelkovich.anton.repository.dao.impl;

import com.gmail.shelkovich.anton.repository.dao.GenericDaoImpl;
import com.gmail.shelkovich.anton.repository.model.PieceOfNews;
import org.springframework.stereotype.Repository;

@Repository("newsDAO")
public class NewsDaoImpl extends GenericDaoImpl<PieceOfNews, Long> {
}

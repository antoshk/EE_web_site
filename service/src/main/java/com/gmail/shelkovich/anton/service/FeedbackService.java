package com.gmail.shelkovich.anton.service;

import com.gmail.shelkovich.anton.service.converter.FeedbackConverter;
import com.gmail.shelkovich.anton.service.model.dto.FeedbackDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FeedbackService extends AbstractService{

    @Transactional
    public void save(FeedbackDTO feedback){
        daoList.getFeedbackDao().add(FeedbackConverter.fromDTO(feedback));
    }
}

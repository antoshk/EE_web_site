package com.gmail.shelkovich.anton.service.impl;

import com.gmail.shelkovich.anton.service.FeedbackService;
import com.gmail.shelkovich.anton.service.converter.FeedbackConverter;
import com.gmail.shelkovich.anton.service.model.dto.FeedbackDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FeedbackServiceImpl extends AbstractService implements FeedbackService {

    @Transactional
    @Override
    public void save(FeedbackDTO feedback){
        daoList.getFeedbackDao().add(FeedbackConverter.fromDTO(feedback));
    }
}

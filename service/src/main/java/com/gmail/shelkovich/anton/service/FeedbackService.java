package com.gmail.shelkovich.anton.service;

import com.gmail.shelkovich.anton.service.model.dto.FeedbackDTO;
import org.springframework.transaction.annotation.Transactional;

public interface FeedbackService {
    @Transactional
    void save(FeedbackDTO feedback);
}

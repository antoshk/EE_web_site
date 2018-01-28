package com.gmail.shelkovich.anton.service.converter;

import com.gmail.shelkovich.anton.repository.model.Feedback;
import com.gmail.shelkovich.anton.service.model.dto.FeedbackDTO;

public class FeedbackConverter {

    public static FeedbackDTO toDTO(Feedback feedback){
        FeedbackDTO feedbackDTO = new FeedbackDTO();
        feedbackDTO.setEmail(feedback.getEmail());
        feedbackDTO.setId(feedback.getId());
        feedbackDTO.setMessage(feedback.getMessage());
        return feedbackDTO;
    }

    public static Feedback fromDTO(FeedbackDTO feedbackDTO){
        Feedback feedback = new Feedback();
        feedback.setEmail(feedbackDTO.getEmail());
        feedback.setId(feedbackDTO.getId());
        feedback.setMessage(feedbackDTO.getMessage());
        return feedback;
    }
}

package com.gmail.shelkovich.anton.repository.dao.impl;

import com.gmail.shelkovich.anton.repository.dao.FeedbackDao;
import com.gmail.shelkovich.anton.repository.model.Feedback;
import org.springframework.stereotype.Repository;

@Repository("feedbackDAO")
public class FeedbackDaoImpl extends GenericDaoImpl<Feedback, Long> implements FeedbackDao {

    public FeedbackDaoImpl() {
        super(Feedback.class);
    }

}

package com.gmail.shelkovich.anton.repository.dao.impl.entityDao;

import com.gmail.shelkovich.anton.repository.dao.impl.GenericDaoImpl;
import com.gmail.shelkovich.anton.repository.model.Feedback;
import org.springframework.stereotype.Repository;

@Repository("feedbackDAO")
public class FeedbackDaoImpl extends GenericDaoImpl<Feedback, Long> {

    public FeedbackDaoImpl() {
        super(Feedback.class);
    }

}

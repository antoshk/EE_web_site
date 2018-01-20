package com.gmail.shelkovich.anton.repository.dao.impl;

import com.gmail.shelkovich.anton.repository.dao.GenericDaoImpl;
import com.gmail.shelkovich.anton.repository.model.Feedback;
import org.springframework.stereotype.Repository;

@Repository("feedbackDAO")
public class FeedbackDaoImpl extends GenericDaoImpl<Feedback, Long> {
}

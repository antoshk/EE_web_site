package com.gmail.shelkovich.anton.service.model.dto;

import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.Size;

public class FeedbackDTO {

    private Long id;

    @Email(message = "{feedback.email.invalid}")
    private String email;

    @Size(min=1, max=2000, message = "{feedback.tooLongValue}")
    private String message;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

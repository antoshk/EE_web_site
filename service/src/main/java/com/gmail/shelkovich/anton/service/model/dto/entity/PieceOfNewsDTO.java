package com.gmail.shelkovich.anton.service.model.dto.entity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PieceOfNewsDTO {

    private Long id;
    private Date publicationDate;
    private String newsTilte;
    private String newsBody;
    private String photoURI;
    private UserDTO userDTO;
    private Integer commentCount;
    private List<CommentDTO> comments = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public String getStringPublicationDate(){
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(publicationDate);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getNewsTilte() {
        return newsTilte;
    }

    public void setNewsTilte(String newsTilte) {
        this.newsTilte = newsTilte;
    }

    public String getNewsBody() {
        return newsBody;
    }

    public void setNewsBody(String newsBody) {
        this.newsBody = newsBody;
    }

    public String getPhotoURI() {
        return photoURI;
    }

    public void setPhotoURI(String photoURI) {
        this.photoURI = photoURI;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public List<CommentDTO> getComments() {
        return comments;
    }

    public void setComments(List<CommentDTO> comments) {
        this.comments = comments;
    }
}

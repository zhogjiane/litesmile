package com.litesmile.litesmile.dto;

import com.litesmile.litesmile.model.User;

import lombok.Data;

@Data
public class QuestionDTO{
    private Integer id;
    private String title;
    private String description;
    private String tag;
    private Long gmtCreate;
    private Long gmtModified;
    private Integer creator;
    private Integer viewCount;
    private Integer commentCount;
    private Integer likedCount;
    User user;


}
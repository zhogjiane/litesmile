package com.litesmile.litesmile.service;

import java.util.ArrayList;
import java.util.List;

import com.litesmile.litesmile.dto.QuestionDTO;
import com.litesmile.litesmile.mapper.QuestionMapper;
import com.litesmile.litesmile.mapper.UserMpper;
import com.litesmile.litesmile.model.Question;
import com.litesmile.litesmile.model.User;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService{



    @Autowired
    private UserMpper userMapper;

    @Autowired
    private QuestionMapper questionMapper;




	public List<QuestionDTO> list() {

        List<Question> questions = questionMapper.list();
        List<QuestionDTO> questionDTOList = new ArrayList<>();
        for(Question question: questions){
            User user = userMapper.findById(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question, questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);

        }
        return questionDTOList;

	}



}
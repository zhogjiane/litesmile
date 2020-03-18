package com.litesmile.litesmile.controller;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import com.litesmile.litesmile.dto.QuestionDTO;
import com.litesmile.litesmile.mapper.UserMpper;
import com.litesmile.litesmile.model.User;
import com.litesmile.litesmile.service.QuestionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController{


    @Autowired
    private UserMpper userMapper;



    @Autowired
    private QuestionService questionService;
    






    @GetMapping("/")
    public String index(HttpServletRequest request,
                        Model model                    
    ){
        Cookie[] cookies = request.getCookies();
        if(cookies != null && cookies.length != 0)
            for(Cookie cookie: cookies){
                if(cookie.getName().equals("token")){
                    String token = cookie.getValue();
                    User user = userMapper.findByToken(token);
                    if(user!=null){
                        request.getSession().setAttribute("user",user);
                    }
                        break;
            }
        }
        
        List<QuestionDTO> questionList = questionService.list();
        model.addAttribute("questions",questionList);
        return "index";
    }


}
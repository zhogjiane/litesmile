package com.litesmile.litesmile.mapper;

import java.util.List;

import com.litesmile.litesmile.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface QuestionMapper{
    @Insert("insert into question (title,description,gmt_create,gmt_modified,creator,tag) values(#{title},#{description},#{gmtCreate},#{gmtModified},#{creator},#{tag})")
     void  create(Question question);

     @Select("select * from question")
	 List<Question> list();
}
package com.taotao.user.mapper;

import com.taotao.commen.pojo.user.UserDetlis;
import com.taotao.commen.pojo.user.UserDetlisExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDetlisMapper {
    int countByExample(UserDetlisExample example);

    int deleteByExample(UserDetlisExample example);

    int insert(UserDetlis record);

    int insertSelective(UserDetlis record);

    List<UserDetlis> selectByExample(UserDetlisExample example);

    int updateByExampleSelective(@Param("record") UserDetlis record, @Param("example") UserDetlisExample example);

    int updateByExample(@Param("record") UserDetlis record, @Param("example") UserDetlisExample example);

    int tryFrozen(@Param("uid")int uid);

    int confirmReduceMoney(@Param("uid")int uid,@Param("money") int money);

    int cancelFrozen(@Param("uid")int uid);
    int cancelFrozen(@Param("uid")int uid,String a);
}
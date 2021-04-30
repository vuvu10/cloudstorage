package com.udacity.jwdnd.course1.cloudstorage.mapper;


import com.udacity.jwdnd.course1.cloudstorage.model.Credential;
import com.udacity.jwdnd.course1.cloudstorage.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CredentialMapper {
    @Select("SELECT * FROM USERS WHERE credentialId = #{credentialId}")
    Credential getCredential(Integer credentialId);

    @Select("SELECT * FROM CREDENTIAL WHERE userId = #{userId}")
    List<Credential> getAllCredential(Long userId);

    @Insert("INSERT INTO CREDENTIAL (url, username, key, password, userId) VALUES (#{url}, #{username}, #{key}, #{password}, #{userId})" )
    @Options(useGeneratedKeys = true, keyProperty = "userId")
   public Integer insert(User user);

    @Update("UPDATE CREDENTIAL SET url = #{url}, username = #{username}, key = #{key}, password = #{password}, userid = #{userid} WHERE credentialId = #{credentialId}")
    public int updateCredential(Credential credential);

    @Delete("DELETE FROM CREDENTIAL WHERE credentialId = #{ credentialId}")
    public int deleteCredential(int credentialId);


}

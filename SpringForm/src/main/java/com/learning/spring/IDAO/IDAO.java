package com.learning.spring.IDAO;

import java.util.List;

import org.springframework.stereotype.Component;

import com.learning.spring.UserModel.UserModel;
@Component
public interface IDAO {

	boolean getConnection();

	List<UserModel> getRecords();

	boolean insertingRecords(UserModel model);

}

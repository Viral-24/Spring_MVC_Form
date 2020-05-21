package com.learning.spring.testcase;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.learning.spring.IDAO.IDAO;
import com.learning.spring.IDAO.IDAO_imp;
import com.learning.spring.UserModel.UserModel;

public class TestCase {

	IDAO ido=new IDAO_imp(); 
	@Ignore
	@Test
	public void testConncetion()
	{
		boolean isConnected=ido.getConnection();
		assertEquals(true,isConnected);
	}
	
	
	@Test
	public void testRecords()
	{	
		List<UserModel> userlist=new ArrayList<UserModel>();
		userlist=ido.getRecords();
		assertEquals(true,userlist.size()>0);
	}
	
	
	@Test
	public void testInsertValuse() {
		UserModel model=new UserModel();
		model.setId(03);
		model.setName("Yash");
		model.setEmail("yash@gmail.com");
		model.setAddr("Pune");
		model.setPhone("9826452561");
		boolean recordsInserted=ido.insertingRecords(model);
		assertEquals(true,recordsInserted);
	}
}
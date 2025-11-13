package com.example.quiz_1140818.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.quiz_1140818.constants.ResCodeMessage;
import com.example.quiz_1140818.dao.AccountDao;
import com.example.quiz_1140818.entity.Account;
import com.example.quiz_1140818.response.AccountRes;
import com.example.quiz_1140818.response.BasicRes;

@Service
public class AccountService {

	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	
	@Autowired
	private AccountDao dao;
	
	public BasicRes addInfo(String account, String password) {
		try {
			// 若文件有說明在新增資訊之前要先檢查帳號是否已存在
			int count = dao.selectCountByAccount(account);
			// 因為是透過 PK 欄位 account 來查詢是否有存在值，所以 count 只會 0 or 1 
            if (count > 0) {
                return new BasicRes(
                        ResCodeMessage.ACCOUNT_EXIST.getCode(),
                        ResCodeMessage.ACCOUNT_EXIST.getMessage()
                );
            }
			// 存進 DB 中的密碼要記得加密
            dao.addInfo(account, encoder.encode(password));
			return new BasicRes(ResCodeMessage.SUCCESS.getCode(),
					ResCodeMessage.SUCCESS.getMessage());
		}catch (Exception e) {
			// 若是 id(PK) 已存在，新增資料就會失敗
			// 發生 Exception 時 ，可以有以下2種處理方法
//			return new BasicRes(ResCodeMessage.ADD_INFO_FAILED.getCode(),
//					ResCodeMessage.ADD_INFO_FAILED.getMessage());
			
			throw e;
		}
	}
	public AccountRes login(String account, String password) {
		// 透過 account 取得對應資料
		Account data = dao.selectByAccount(account);
		if(data == null) {// data == null 表示沒有資料 -> 也表示該帳號不存在
			return new AccountRes(ResCodeMessage.NOT_FOUND.getCode(),//
					ResCodeMessage.NOT_FOUND.getMessage());
		}
		// 比對密碼: 使用排除法，所以前面記得要有驚嘆號，表示密碼匹配不成功
		if(!encoder.matches(password, data.getPassword())) {
			return new AccountRes(ResCodeMessage.PARAM_PASSWORD_ERROR.getCode(),//
					ResCodeMessage.PARAM_PASSWORD_ERROR.getMessage());
		}
		dao.selectCountByAccount(account);
		return new AccountRes(ResCodeMessage.SUCCESS.getCode(),//
				ResCodeMessage.SUCCESS.getMessage());
		
		
	}
	public BasicRes reqgister(String account, String password) {
		// 透過 account 取得對應資料
				Account data = dao.selectByAccount(account);
				if(data == null) {// data == null 表示沒有資料 -> 也表示該帳號不存在
					return new AccountRes(ResCodeMessage.NOT_FOUND.getCode(),//
							ResCodeMessage.NOT_FOUND.getMessage());
				}
				// 比對密碼: 使用排除法，所以前面記得要有驚嘆號，表示密碼匹配不成功
				if(!encoder.matches(password, data.getPassword())) {
					return new AccountRes(ResCodeMessage.PARAM_PASSWORD_ERROR.getCode(),//
							ResCodeMessage.PARAM_PASSWORD_ERROR.getMessage());
				}
				dao.selectCountByAccount(account);
				return new AccountRes(ResCodeMessage.SUCCESS.getCode(),//
						ResCodeMessage.SUCCESS.getMessage());
	}
	
	
}

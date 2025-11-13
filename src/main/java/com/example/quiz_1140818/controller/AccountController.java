package com.example.quiz_1140818.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.quiz_1140818.requerst.BasicReq;
import com.example.quiz_1140818.requerst.RegisterReq;
import com.example.quiz_1140818.response.AccountRes;
import com.example.quiz_1140818.response.BasicRes;
import com.example.quiz_1140818.service.AccountService;

import jakarta.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping(value = "quiz")
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	@PostMapping(value = "add_info")
	public BasicRes addInfo(@Valid @RequestBody BasicReq req) {
		return accountService.addInfo(req.getAccount(), req.getPassword());
	}
	
	@PostMapping(value = "reqgister")
	public BasicRes addInfo(@Valid @RequestBody RegisterReq req) {
		return accountService.reqgister(req.getAccount(), req.getPassword());
	}
	
	@PostMapping(value = "login")
	public AccountRes login(@Valid @RequestBody BasicReq req) {
		return accountService.login(req.getAccount(), req.getPassword());
	}
	
}

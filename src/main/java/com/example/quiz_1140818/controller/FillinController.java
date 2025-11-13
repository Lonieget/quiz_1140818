package com.example.quiz_1140818.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.quiz_1140818.requerst.FillinReq;
import com.example.quiz_1140818.response.BasicRes;
import com.example.quiz_1140818.response.FeedbackRes;
import com.example.quiz_1140818.response.StatisticRes;
import com.example.quiz_1140818.service.FillinService;

import jakarta.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping(value = "quiz")
public class FillinController  {

	@Autowired
    private FillinService fillinService;

    @PostMapping(value = "fillin")
    public BasicRes fillin(@Valid @RequestBody FillinReq req) throws Exception {
        return fillinService.fillin(req.getUser(), req.getQuizId(), req.getAnswerList());
    }
    
    @GetMapping(value = "feedback")
    public FeedbackRes feedback(@RequestParam("quizId") int quizId) throws Exception {
    	return fillinService.feeback(quizId);
    }
    
    // http://localhost:8080/quiz/feedback/3
    @GetMapping(value = "feedback/{quizId}")
    public FeedbackRes feedback_1(@PathVariable("quizId") int quizId) throws Exception {
    	return fillinService.feeback(quizId);
    }
    @GetMapping(value = "statistic")
    public StatisticRes statistic(@RequestParam("quizId") int quizId) throws Exception {
    	return fillinService.statistic(quizId);
    }
}

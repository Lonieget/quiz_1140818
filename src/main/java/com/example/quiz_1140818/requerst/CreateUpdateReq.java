package com.example.quiz_1140818.requerst;

import java.util.List;

import com.example.quiz_1140818.constants.ConstantsMessage;
import com.example.quiz_1140818.entity.Quiz;
import com.example.quiz_1140818.vo.QuestionVo;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotEmpty;

public class CreateUpdateReq {
	
	// 嵌套驗證：屬性是個類別(String 除外)，且也有對該類別中的屬性加上限制
	// 因為有對類別 Quiz 加上限制，為了要讓那些限制生效，就要在 Quiz 上面加上 @valid
	
	@Valid
    @NotNull(message = ConstantsMessage.QUIZ_ERROR)
    private Quiz quiz;


	@Valid
    @NotEmpty(message = ConstantsMessage.QUESTION_OPTIONS_ERROR)
    private List<QuestionVo> questionVoList;

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public List<QuestionVo> getQuestionVoList() {
        return questionVoList;
    }

    public void setQuestionVoList(List<QuestionVo> questionVoList) {
        this.questionVoList = questionVoList;
    }
}


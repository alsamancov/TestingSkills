package com.springapp.mvc.controller;

import com.springapp.mvc.entity.Answer;
import com.springapp.mvc.entity.Applicant;
import com.springapp.mvc.entity.Question;
import com.springapp.mvc.service.AnswerService;
import com.springapp.mvc.service.ApplicantService;
import com.springapp.mvc.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/")
public class MainController {

	@Autowired
	private ApplicantService applicantService;

	@Autowired
	private AnswerService answerService;

	@Autowired
	private QuestionService questionService;




	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		model.addAttribute("message", "Hello world!");
		return "index";
	}

	@RequestMapping(value = "/question", method = RequestMethod.GET)
	public String getQuesiton(Model model){
		Question question = this.questionService.findQuestionById(1);
		model.addAttribute("question", question);

		return "question";
	}


	@RequestMapping(value = "/insertapplicant", method = RequestMethod.GET)
	public String insertApplicant(){
		applicantService.insert(new Applicant("John", "Smith", "jsmith@ukr.net", "jsmith451", 10));
		return "index";
	}

	@RequestMapping(value = "/insertanswer", method = RequestMethod.GET)
	public String insertAnswer(){
		answerService.insert(new Answer("boolean value = 12;", false, 1));
		return "index";
	}

	@RequestMapping(value = "/insertquestion", method = RequestMethod.GET)
	public String insertQuestion(){
		questionService.insert(new Question("Which one of the following is NOT a correct variable name?", 1));
		return "index";
	}
}
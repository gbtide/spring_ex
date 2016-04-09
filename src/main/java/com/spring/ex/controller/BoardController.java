package com.spring.ex.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.ex.service.IBoardService;
import com.spring.ex.vo.BoardVO;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@Autowired
	private IBoardService boardService;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registGET(BoardVO vo, Model model) throws Exception {
		logger.info("register get ......");
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registPOST(BoardVO vo, Model model, RedirectAttributes attr) throws Exception {
		logger.info("register post ......");
		logger.info(vo.toString());

		boardService.regist(vo);
		
		return "redirect:/html/index.html#!/listAll?result=SUCCESS";
	}
	
	@RequestMapping(value="/listAll", method=RequestMethod.GET) 
	public void listAll(Model model) throws Exception {
		logger.info("show all list ......");
	}
}

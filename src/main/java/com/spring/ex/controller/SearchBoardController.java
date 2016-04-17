package com.spring.ex.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.ex.model.ItemResponse;
import com.spring.ex.model.ListResponse;
import com.spring.ex.model.PageMaker;
import com.spring.ex.model.PageResponse;
import com.spring.ex.model.SearchCriteria;
import com.spring.ex.service.IBoardService;
import com.spring.ex.vo.BoardVO;

@Controller
@RequestMapping("/sboard/")
public class SearchBoardController {
	private static final Logger logger = LoggerFactory.getLogger(SearchBoardController.class);
	
	@Autowired
	private IBoardService boardService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public PageResponse listPage(@ModelAttribute("cri") SearchCriteria searchCriteria, Model model) throws Exception {
		logger.info("#.searchCriteria : " + searchCriteria);
		
		int searchTotalCount = boardService.listSearchCount(searchCriteria);
		logger.info("#.searchTotalCount : " + searchTotalCount);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCriteria(searchCriteria);
		pageMaker.setTotalCount(searchTotalCount);
		
		logger.info("#.pageMaker : " + pageMaker);
		
		List<BoardVO> list = boardService.listSearchCriteria(searchCriteria);
		PageResponse response = new PageResponse();
		response.setList(list);
		response.setPageMaker(pageMaker);
		
		return response;		
	}

	
}

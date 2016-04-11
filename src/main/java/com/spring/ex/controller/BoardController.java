package com.spring.ex.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.ex.model.ItemResponse;
import com.spring.ex.model.ListResponse;
import com.spring.ex.model.Response;
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

	@RequestMapping(value = "/listAll", method = RequestMethod.GET)
	@ResponseBody
	public ListResponse<BoardVO> listAll(Model model) throws Exception {
		logger.info("show all list ......");
		
//		BoardVO nullVO = null;
//		nullVO.setBno(100);

		// model.addAttribute("list", boardService.listAll());
		List<BoardVO> list = boardService.listAll();

		logger.info("  :: list is > " + list);
		return new ListResponse<BoardVO>(list);
	}

	@RequestMapping(value = "/read", method = RequestMethod.GET)
	@ResponseBody
	public ItemResponse<BoardVO> read(@RequestParam("bno") int bno, Model model) throws Exception {
		BoardVO vo = boardService.read(bno);
		return new ItemResponse<BoardVO>().setItem(vo);
	}
	
	@RequestMapping(value = "/remove", method = RequestMethod.GET)
	public String remove(@RequestParam("bno") int bno) throws Exception {
		logger.info("remove post ...... " + bno);
		boardService.remove(bno);
		return "redirect:/html/index.html#!/listAll?result=SUCCESS";
	}

	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifyPOST(BoardVO vo) throws Exception {
		logger.info("modify post ...... " + vo);
		boardService.modify(vo);
		return "redirect:/html/index.html#!/listAll?result=SUCCESS";
	}	
	
}

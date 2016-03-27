package com.spring.ex.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.spring.ex.response.SampleResponse;
import com.spring.ex.vo.ProductVO;

@Controller
@RequestMapping("/sample")
public class SampleController {
	public static final String TAG = SampleController.class.getSimpleName();
	
	@RequestMapping("/do")
	@ResponseBody
	public SampleResponse doRequest() {
		System.out.println("==== do request!");
		
		SampleResponse response = new SampleResponse();
		response.setResult(200);
		response.setMessage("Good Response");
		
		return response;
	}
	
	@RequestMapping("/show")
	public String showJSP(@ModelAttribute("msg") String msg, String user) {
		System.out.println("=== do showJSP! : " + msg + " / " + user);
		return "result";
	}
	
	@RequestMapping("/model")
	public String requestModel(Model model) {
		System.out.println("=== request Model");
		ProductVO productVO = new ProductVO("pr", 3000);
		model.addAttribute(productVO);
		return "model";
	}
	
	@RequestMapping("/redirect")
	public String requestRedirect(RedirectAttributes attrs) {
		System.out.println("=== request Redirect");
		
		attrs.addFlashAttribute("msg", "attributeValue");
		return "redirect:redirectResult";
	}
	
	@RequestMapping("/redirectResult")
	@ResponseBody
	public SampleResponse redirectResult(HttpServletRequest request) {
		Map<String, ?> map = RequestContextUtils.getInputFlashMap(request);
		String msg = (String) ((map==null)? map : map.get("msg"));
		
		System.out.println("=== receive request at RedirectResult : " + msg);
		SampleResponse response = new SampleResponse();
		response.setResult(200);
		response.setMessage("200 Response : " + msg);
		return response;
	}

}

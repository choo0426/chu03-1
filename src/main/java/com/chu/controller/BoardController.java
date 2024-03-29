package com.chu.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.chu.model.BoardVO;
import com.chu.service.BoardService;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/board/*")
@Log4j
public class BoardController {

//	private static final Logger log = LoggerFactory.getLogger(BoardController.class);  // lombok라이브러리 추가시 log4j어노테이션 추가로 대체
	
	@Autowired
	private BoardService boardService;
	
	// 게시판 목록 페이지 접속
	@GetMapping("/list")
	// => @RequestMapping(value = "/list" , method = RequestMethod.GET)
	public void boardListGet(Model model) {
		log.info("게시판 목록 페이지 진입");
		model.addAttribute("list", boardService.getList());
	}
	
	// 게시판 등록 페이지 접속
	@GetMapping("/enroll")
	// => @RequestMapping(value = "/enroll" , method = RequestMethod.GET)
	public void boardEnrollGet() {
		log.info("게시판 등록 페이지 진입");
	}
	
	// 게시판 등록
	@PostMapping("/enroll")
	public String boardEnrollPost(BoardVO board, RedirectAttributes rttr) {
		log.info("BoardVO : " + board);
		boardService.enroll(board);
		rttr.addFlashAttribute("result", "enroll success");
		
		return "redirect:/board/list";
	}
	
	// 게시판 조회
	@GetMapping("/get")
	public void boardGetPageGet(int bno, Model model) {
		model.addAttribute("pageInfo", boardService.getPage(bno));
	}
	
	// 수정 페이지 이동
	@GetMapping("/modify")
	public void boardModifyGET(int bno, Model model) {
		model.addAttribute("pageInfo", boardService.getPage(bno));
	}
	
	// 페이지 수정
	@PostMapping("/modify")
	public String boardModifyPOST(BoardVO board, RedirectAttributes rttr) {
		boardService.modify(board);
		rttr.addFlashAttribute("result", "modify success");
		return "redirect:/board/list";
	}
}

// MovieController.java
// Spring MVC 영화 리뷰 게시판 Controller

package com.peisia.movie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.peisia.movie.dto.MovieDto;
import com.peisia.movie.service.MovieService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
  @RequestMapping("/movie/*")
  @AllArgsConstructor
  @Controller
  public class MovieController {
    	private MovieService service;

	@GetMapping("/getList")
    	public String getList(@RequestParam(value = "currentpage", defaultValue="1") int currentpage, Model model) {
        		int totalcount = service.getTotalCount();
        		int pagesize = 5;
        		int totalpage = (totalcount + pagesize - 1) / pagesize;

    		model.addAttribute("list", service.getList(currentpage));
        		model.addAttribute("totalpage", totalpage);
        		model.addAttribute("currentpage", currentpage);

    		return "movie/getList";
      }

	@GetMapping("/read")
    	public String read(@RequestParam("mno") int mno, Model model) {
        		model.addAttribute("mno", service.read(mno));
        		return "movie/read";
      }

	@GetMapping("/del")
    	public String del(@RequestParam("mno") int mno) {
        		service.del(mno);
        		return "redirect:/movie/getList";
      }

	@GetMapping("/write")
    	public String writeForm() {
        		return "movie/write";
      }

	@PostMapping("/write")
    	public String write(MovieDto dto) {
        		service.write(dto);
        		return "redirect:/movie/getList";
      }
  }

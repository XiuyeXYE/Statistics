package com.xy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CanvasHtmlController {

	@RequestMapping("histogram")
	public String histogram() {

		return "histogram";
	}

	@RequestMapping("canvas1")
	public String canvas1() {
		return "canvas/canvas1";
	}

}

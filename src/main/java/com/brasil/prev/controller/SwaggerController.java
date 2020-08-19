package com.brasil.prev.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping(value = "/swagger")
public class SwaggerController {

	@ApiIgnore
	@GetMapping
	public ModelAndView getSwagger() {
		return new ModelAndView("redirect:/swagger-ui.html");
	}
	
}
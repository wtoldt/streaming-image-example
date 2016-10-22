package com.wtoldt.controller;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.wtoldt.service.ImageService;

@Controller
public class IndexController {

	@Autowired
	private ImageService imageService;

	@RequestMapping("/")
	public String getIndexView(Model model) {
		final List<String> imagePaths = imageService.getImageIds().stream().map(id -> "images/"+id).collect(Collectors.toList());

		model.addAttribute("imagePaths", imagePaths);
		return "uploadForm";
	}

	@RequestMapping(value="/", method=RequestMethod.POST)
	public String handleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) throws IOException {

		imageService.store(file);

		return "redirect:/";
	}
}

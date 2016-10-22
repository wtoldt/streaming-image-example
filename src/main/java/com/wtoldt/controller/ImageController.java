package com.wtoldt.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wtoldt.service.ImageService;

@RestController
public class ImageController {

	@Autowired
	private ImageService imageService;

	@RequestMapping("/images/{id}")
	public byte[] getImage(@PathVariable Integer id) throws IOException {
		return imageService.getImageAsArray(id);
	}
}

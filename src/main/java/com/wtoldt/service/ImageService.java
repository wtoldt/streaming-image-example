package com.wtoldt.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImageService {

	private final List<byte[]> byteArrayList = new ArrayList<>();

	public void store(MultipartFile file) throws IOException {
		byteArrayList.add(IOUtils.toByteArray(file.getInputStream()));
	}

	public byte[] getImageAsArray(int id) throws IOException {
		return byteArrayList.get(id);
	}

	public List<Integer> getImageIds() {
		final List<Integer> imageIds = new ArrayList<>();
		for (int i = 0; i < byteArrayList.size(); i++) {
			imageIds.add(i);
		}
		return imageIds;
	}
}

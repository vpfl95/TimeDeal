package com.dh.home.util;

import java.io.File;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class FileManager {

	public String saveFile(MultipartFile multipartFile, String path)throws Exception{
		String filename =UUID.randomUUID().toString();
		
		StringBuffer buffer = new StringBuffer();
		buffer.append(filename);
		buffer.append("_");
		buffer.append(multipartFile.getOriginalFilename());
		
		File file = new File(path, buffer.toString());
		multipartFile.transferTo(file);
		return buffer.toString();
	}
}

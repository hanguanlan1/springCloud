package com.wisedu.cloud.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {

	@ResponseBody
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String getFileUpload(@RequestParam(value = "file", required = true) MultipartFile file) {
		try {
			byte[] b = file.getBytes();
			File f = new File(file.getOriginalFilename());
			FileCopyUtils.copy(b, f);
			return f.getAbsolutePath();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}

package com.Revature.Controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;

@Controller
public class HelloController {
	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public String submit(@RequestParam("file") MultipartFile mFile) {
		System.out.println("OK");
		try {
			String fileName = mFile.getOriginalFilename();// FilenameUtils.getName(mFile.getOriginalFilename());
			InputStream fileContent = mFile.getInputStream();
			String bucket_name = "assignforce-bucket";
			File file = new File(fileName);
			FileUtils.copyInputStreamToFile(fileContent, file);

			final AmazonS3 s3 = AmazonS3Client.builder().withRegion("us-east-1").build();
			try {
				s3.putObject(bucket_name, fileName, file);
			} catch (AmazonServiceException e) {
				System.err.println(e.getErrorMessage());
				System.exit(1);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "fileUploadView";
	}
	
	@GetMapping("/uploadfile")
	public String testep() {
		System.out.println("ok");
		return "OK";
	}
}

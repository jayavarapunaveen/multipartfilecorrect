package com.javasampleapproach.uploadfile.controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import com.javasampleapproach.uploadfile.model.ThingsD;

import com.javasampleapproach.uploadfile.repository.ThingsRepo;
import com.javasampleapproach.uploadfile.storage.StorageService;

@Controller
public class UploadController {

	@Autowired
	StorageService storageService;

	
	@Autowired
	ThingsRepo thingsRepo;

	List<String> files = new ArrayList<String>();
	List<ThingsD> row=new ArrayList<ThingsD>();
	@GetMapping("/")
	
	public String listUploadedFiles(Model model) {
		return "uploadForm";
	}

	@PostMapping("/")
	@ResponseBody
	public List<ThingsD> handleFileUpload(@RequestParam("file") MultipartFile file, Model model) {
		try {
			Logger log = LoggerFactory.getLogger(this.getClass().getName());
			storageService.store(file);
			model.addAttribute("message", "You successfully uploaded " + file.getOriginalFilename() + "!");
			files.add(file.getOriginalFilename());
			InputStream inputStream = file.getInputStream();
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
			String cvsSplitBy = ",";
			String line="";
			//Map<String, Integer> Col1= new HashMap<String,Integer>();
			while ((line = bufferedReader.readLine()) != null)
			{
				 String[] s = line.split(cvsSplitBy);

				ThingsD thingsd=new ThingsD();
				 thingsd.setCol1(s[0]);
				 thingsd.setCol2(s[1]);
				 thingsd.setCol3(s[2]);
				 thingsd.setCol4(s[3]);
				 thingsd.setCol5(s[4]);
				 thingsd.setCol6(s[5]);
				 thingsd.setCol7(s[6]);
				 if(s[0].isEmpty() || s[3].isEmpty()) 
				 {
				 row.add(thingsd);
				 //log.info("HI");
				 }
				 //System.out.println(row);
				else
				 {
				 try{thingsRepo.save(thingsd);
				 
				 }
				 catch(Exception e) { } 
				 log.info("Success");}
	             //log.info("Country [code= " + country[0] + " , type=" + country[8] + "]");
	}
		} catch (Exception e) {
			model.addAttribute("message", "FAIL to upload " + file.getOriginalFilename() + "!");
		}
		return row;
		
	}
	
	
	
	

	@GetMapping("/gellallfiles")
	public String getListFiles(Model model) {
		model.addAttribute("files",
				files.stream()
						.map(fileName -> MvcUriComponentsBuilder
								.fromMethodName(UploadController.class, "getFile", fileName).build().toString())
						.collect(Collectors.toList()));
		model.addAttribute("totalFiles", "TotalFiles: " + files.size());
		return "listFiles";
	}

	@GetMapping("/files/{filename:.+}")
	@ResponseBody
	public ResponseEntity<Resource> getFile(@PathVariable String filename) {
		Resource file = storageService.loadFile(filename);
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
				.body(file);
	}
}
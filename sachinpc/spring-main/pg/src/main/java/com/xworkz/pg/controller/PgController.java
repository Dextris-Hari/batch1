package com.xworkz.pg.controller;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.xworkz.pg.dto.PgDTO;
import com.xworkz.pg.service.PgService;

@Controller
@RequestMapping("/man")
public class PgController {
	@Autowired
	private PgService service;

	public PgController() {
		System.out.println(" nanu controller " + this.getClass().getSimpleName());
		// TODO Auto-generated constructor stub
	}

	@PostMapping
	String onSave(PgDTO dto ,@RequestParam("image") MultipartFile request) throws IOException {
		byte[] bytes = request.getBytes();
		 String saveFile=System.currentTimeMillis()+"_"+request.getOriginalFilename();
		 System.out.println(request.getOriginalFilename()+"yes");
		 System.out.println(saveFile);
			Path path = Paths.get("C://Users//Dell//Desktop//MANOJ/"+saveFile);
			System.out.println(path);

		Files.write(path, bytes);
		dto.setFileName(saveFile);
		
		
		
		System.out.println(" nanu controller method");
		service.vallidateAndSave(dto);

		return "Display";
	}

	@GetMapping
	String onReadAll(Model model) {
		List<PgDTO> all = service.validateAndReadAll();
		System.out.println("readalllllllllllll");
		if (all != null && !all.isEmpty()) {
			System.out.println(" size" + all.size());
			model.addAttribute("size", "details of pg" + all.size());
			// model.addAttribute("size","total criminals found :"+all.size());
			model.addAttribute("details", all);
  System.out.println("mauydrtfyguiuougf");
			return "Details";

		}
		return "null";
	}
	@GetMapping("/man")
	String onReadByName(Model model, HttpServletRequest request) {
		System.out.println("read by nameeeeeeeeeeeeeeeeeeeee");
		String parameter = request.getParameter("name");
		System.out.println("💖💖💖💖💖💖"+parameter);
		System.out.println("🤔🤔🤔🤔🤔🤔🤔🤔🤔🤔🤔🤔🤔🤔🤔🤔🤔🤔🤔");
		
		List<PgDTO> all = service.validateAndReadByName(parameter);
		if (all != null && !all.isEmpty()) {
			System.out.println(" size" + all.size());
			model.addAttribute("size", "details of pg" + all.size());
			// model.addAttribute("size","total criminals found :"+all.size());
			model.addAttribute("details", all);
			

			return "Details";//http://localhost:8080/pg/man

		}
		return null;
	}
	@GetMapping(value={"/image","/man/image"})//http://localhost:8080/pg/man/man?name=manojjyothi
    public void sendFile(@RequestParam String filename, HttpServletResponse response) throws IOException {
            System.out.println("running sendFile..."+filename);
            //file name from DB
            //Path can be static 
            File file = new File("C://Users//Dell//Desktop//MANOJ/"+filename);
            String mimeType = URLConnection.guessContentTypeFromName(file.getName());
            response.setContentType(mimeType);
            try (OutputStream stream = response.getOutputStream()) {
                    stream.write(Files.readAllBytes(file.toPath()));
                    
            }
            
    }
	
	
	

}

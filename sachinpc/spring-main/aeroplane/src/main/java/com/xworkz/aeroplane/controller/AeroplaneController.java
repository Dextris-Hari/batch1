package com.xworkz.aeroplane.controller;

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

import com.xworkz.aeroplane.dto.AeroplaneDTO;
import com.xworkz.aeroplane.service.AeroplainService;

@Controller
@RequestMapping("/man")
public class AeroplaneController {
	@Autowired
	private AeroplainService service;

	@PostMapping
	String onSave(AeroplaneDTO dto, @RequestParam("image") MultipartFile file) throws IOException {
		byte[] bytes = file.getBytes();
		String fileName=System.currentTimeMillis()+"_"+file.getOriginalFilename();
		Path path = Paths.get("C://Users//Dell//Desktop//MANOJ/"+fileName);
		
		Files.write(path, bytes);
		dto.setImage(fileName);
		service.validateAndSave(dto);

		return "Display";
	}

	@GetMapping
	String readAll(Model model) {
		List<AeroplaneDTO> list = service.validateAndSave();
		if (list != null && !list.isEmpty()) {
			System.out.println(list.size());
			model.addAttribute("all", list.size());
			model.addAttribute("manoj", list);

		}

		return "Details";

	}

	@GetMapping("/son")
	String ReadByName(HttpServletRequest request, Model model) {
		String string = request.getParameter("name");
		List<AeroplaneDTO> list = service.validateAndReadByName(string);

		if (list != null && !list.isEmpty()) {

			System.out.println(list.size());
			model.addAttribute("all", list.size());
			model.addAttribute("manoj", list);

		}

		return "Details";
	}
	@GetMapping(value={"/image","/man/image"})
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

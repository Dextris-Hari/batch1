package com.xworkz.foodandmusic.controler;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.foodandmusic.dto.MusicDTO;

@Component
@RequestMapping("/")
public class MusicController {
	private Collection<MusicDTO> collection = new ArrayList<MusicDTO>();

	public MusicController() {
		System.out.println("MusicControler is created " + getClass().getSimpleName());

		// TODO Auto-generated constructor stub
	}

	@RequestMapping("/music.manoj")
	public String addSong(MusicDTO dto, Model model) {
		System.out.println("addSong method is running ");
		System.out.println("fecthing the data from music dto" + dto);
		model.addAttribute("Musicdto", dto);
		collection.add(dto);

		return "Music.jsp";

	}
@RequestMapping("/view.manoj")
	public String viewSong(Model model) {
		System.out.println("running in view song method ");
		model.addAttribute("music", this.collection);
		return "DisplaySong.jsp";

	}

}

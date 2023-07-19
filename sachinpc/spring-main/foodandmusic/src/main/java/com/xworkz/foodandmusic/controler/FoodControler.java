package com.xworkz.foodandmusic.controler;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.foodandmusic.dto.FoodDTO;
import com.xworkz.foodandmusic.dto.MusicDTO;

@Component
public class FoodControler {
	private Collection<FoodDTO> collection = new ArrayList<FoodDTO>();
	public FoodControler() {
		System.out.println("Food controler is created "+this.getClass().getSimpleName());
		// TODO Auto-generated constructor stub
	}
	@RequestMapping("/food.manoj")
	public String addSong(FoodDTO dto, Model model) {
		System.out.println("ADDfood method is running ");
		System.out.println("fecthing the data from Food dto" + dto);
		model.addAttribute("FoodDTO", dto);
		collection.add(dto);

		return "Food.jsp";

	}
@RequestMapping("/view.manoj")
	public String viewSong(Model model) {
		System.out.println("running in view Food method ");
		model.addAttribute("Food", this.collection);
		return "DisplayFood.jsp";

	}


}

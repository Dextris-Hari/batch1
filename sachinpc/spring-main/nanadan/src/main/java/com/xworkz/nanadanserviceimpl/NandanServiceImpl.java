package com.xworkz.nanadanserviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xworkz.nanadandao.NandanDAO;
import com.xworkz.nanadanentity.NandanEntity;
import com.xworkz.nanadanservice.NandanService;

@Component
public class NandanServiceImpl  implements NandanService{
	@Autowired
	NandanDAO dao;

	@Override
	public String validAndSave(NandanEntity entity) {
		if(entity!=null) {
		dao.save(entity);
		}
		else
		System.out.println(" entity is null");
		
		
		return "banthu";
	}

}

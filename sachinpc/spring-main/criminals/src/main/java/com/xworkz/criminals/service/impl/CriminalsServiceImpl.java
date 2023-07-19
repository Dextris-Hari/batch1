package com.xworkz.criminals.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.criminals.dao.CriminalsRepository;
import com.xworkz.criminals.dto.CriminalsDTO;
import com.xworkz.criminals.service.CriminalsService;

@Service
public class CriminalsServiceImpl implements CriminalsService {
	@Autowired
	private CriminalsRepository repository;

	public CriminalsServiceImpl() {
		// TODO Auto-generated constructor stub
		System.out.println(" nanu criminalsservice implimantaion" + this.getClass().getSimpleName());
	}

	@Override
	public boolean validateAndSave(CriminalsDTO dto) {

		System.out.println(" running in validateandsave method");
		if (dto != null) {
			String name = dto.getName();
			String wifeName = dto.getWifeName();
			String rightHand = dto.getRightHand();
			String leftHand = dto.getLeftHand();
			String jailName = dto.getJailName();
			double netWorth = dto.getNetWorth();
			if (name.length() > 3 && name.length() < 30) {
				System.out.println("name is valid");
				if (wifeName.length() > 3 && wifeName.length() < 30) {
					System.out.println(" sabash maga wife name is valid");
					if (rightHand.length() > 3 && rightHand.length() < 30) {
						System.out.println("maga righthand is valid");
						if (leftHand.length() > 3 && leftHand.length() < 30) {
							System.out.println(" maga lefthand is valid");
							if (jailName.length() > 3 && jailName.length() < 30) {
								System.out.println(" macha nin jailname is valid");
								if (netWorth != 0) {
									System.out.println(" macha gud networth");
									repository.save(dto);
									return true;
								}
							} else {
								System.out.println(" mundede avan edidu e jail ali hala");
							}
						} else {
							System.out.println(" kajur lefthand is not valid");
						}

					} else {
						System.out.println(" sisya righthand sariyag kodole");
					}
				} else {

					System.out.println(" mundede wife name is not valid");
				}
			} else {
				System.out.println(" name sariyag kodo guldu");
			}
		} else {
			System.out.println(" dto is null");
		}
		// repository.save(dto);
		return false;
	}

	@Override
	public List<CriminalsDTO> validateAndReadAll() {
		// TODO Auto-generated method stub
		repository.readAll();
		return repository.readAll();
	}

	@Override
	public List<CriminalsDTO> findByName(String name) {
		return repository.findByName(name);
}

}

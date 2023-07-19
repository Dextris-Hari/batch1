package com.xworkz.college.collegedao;

import com.xworkz.college.entity.CollegeEntity;

public interface CollegeDAO {
	default Boolean save(CollegeEntity entity) {
		return null;

	}

}

package com.xworkz.booklist.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.booklist.dao.BookListDAO;
import com.xworkz.booklist.dto.BookListDTO;
import com.xworkz.booklist.service.BookListService;

@Service
public class BookListServiceImpl implements BookListService {
	@Autowired
	private BookListDAO dao;

	public BookListServiceImpl() {
		System.out.println(" nanu BookList Service " + this.getClass().getSimpleName());

		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean validateAndave(BookListDTO dto) {
		System.out.println(" nanu BookList Service ali validate andSave method");
		dao.save(dto);
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<BookListDTO> readAndValidateALL() {
		System.out.println(" nanu readall method from service");
		List<BookListDTO> list = dao.readAll();
		return list;
	}

	@Override
	public List<BookListDTO> readByName(String name) {
		return dao.readByName(name);
	}

}

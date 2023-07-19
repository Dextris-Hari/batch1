package com.xworkz.booklist.service;

import java.util.List;

import com.xworkz.booklist.dto.BookListDTO;

public interface BookListService {
	boolean validateAndave(BookListDTO dto);
	List<BookListDTO > readAndValidateALL();
	List<BookListDTO>readByName(String name);

}

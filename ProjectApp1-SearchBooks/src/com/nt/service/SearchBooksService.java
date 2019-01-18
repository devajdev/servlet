package com.nt.service;

import java.util.List;

import com.nt.dto.BookDTO;

public interface SearchBooksService {
	public List<BookDTO> searchBooks(String category)throws Exception;

}

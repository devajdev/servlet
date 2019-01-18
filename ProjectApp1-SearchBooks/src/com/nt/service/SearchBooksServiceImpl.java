package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import com.nt.bo.BookBO;
import com.nt.dao.SearchBooksDAO;
import com.nt.dao.SearchBooksDAOImpl;
import com.nt.dto.BookDTO;

public class SearchBooksServiceImpl implements SearchBooksService {

	@Override
	public List<BookDTO> searchBooks(String category) throws Exception {
		SearchBooksDAO dao=null;
		List<BookBO> listBO=null;
		List<BookDTO> listDTO=null;
		BookDTO dto=null;
		//create DAO class obj
		dao=new SearchBooksDAOImpl();
		//use DAO
		listBO=dao.findBooks(category);
		//convert listBO to listDTO
		listDTO=new ArrayList();
		for(BookBO bo:listBO){
			//copy each BO to each DTO
			dto=new BookDTO();
			dto.setSno(listDTO.size()+1);
			dto.setBookId(bo.getBookId());
			dto.setBookName(bo.getBookName());
			dto.setAuthor(bo.getAuthor());
			dto.setStatus(bo.getStatus());
			dto.setPrice(Math.round(bo.getPrice()));
			dto.setCategory(bo.getCategory());
			//add each DTO to listDTO
			listDTO.add(dto);
		}//method
		return listDTO;
	}//method
}//class

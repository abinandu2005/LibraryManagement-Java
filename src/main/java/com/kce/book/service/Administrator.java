package com.kce.book.service;

import com.kce.book.bean.BookBean;
import com.kce.book.dao.BookDAO;

public class Administrator {
	   
         public String addBook(BookBean bookBean) {
        	 if(bookBean==null || bookBean.getBookName().isEmpty() || bookBean.getIsbn().isEmpty() || 
        			 bookBean.getBookType()!=' '|| bookBean.getBookType()!='G'
        			 || bookBean.getBookType()!='T'
        			 || bookBean.getCost()==0
        			 ||bookBean.getAuthor().getAuthorName().isEmpty()) {
        		 return "invalid";
        	 }int result = new BookDAO().createBook(bookBean);
        	 if(result ==1) {
        		 return "success";
        	 }
        	 return "failure";
        	   
        	   
        	   
         }
         public BookBean viewBook(String isbn) {
        	 //BookDAO bookDAO = new BookDAO();
        	 //BookBean booKBean=bookDAO.fetchBook(isbn);
        	 return new BookDAO().fetchBook(isbn);
         }
}
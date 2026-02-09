package com.kce.book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kce.book.bean.BookBean;
import com.kce.book.util.DBUtil;

public class BookDAO {
        public int createBook(BookBean bookBean) {
        	   Connection connection =DBUtil.getDBConnection();
        	   String query="insert into Book_Tbl values (?,?,?,?,?)";
        	   int result=0;
        	  try { 
        	   PreparedStatement ps=connection.prepareStatement(query);
        	   ps.setString(1,bookBean.getIsbn());
        	   ps.setString(2,bookBean.getBookName());
        	   ps.setString(3, String.valueOf(bookBean.getBookType()));
        	   ps.setInt(4,bookBean.getAuthor().getAuthorCode());
        	   
        	   ps.setDouble(5,bookBean.getCost());
        	   int rows=ps.executeUpdate();

        	  if(rows>0) {
        		  result=1;
        	  }
        	   }
        	  catch(SQLException e) {
        		    
        		  e.printStackTrace();
        		  result =0;
        	  }
        	  return result;
        }
        public BookBean fetchBook(String isbn) {
            Connection connection = DBUtil.getDBConnection();
            BookBean bookBean = null;
            String query = "SELECT * FROM Book_Tbl WHERE isbn = ?";

            try {
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setString(1, isbn);

                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                   bookBean = new BookBean();

                    bookBean.setIsbn(rs.getString(1));
                    bookBean.setBookName(rs.getString(2));
                    bookBean.setBookType(rs.getString(3).charAt(0));
                    bookBean.setAuthor(new AuthorDAO().getAuthor(rs.getInt(4)));
                    bookBean.setCost(rs.getFloat(5));
                    return bookBean;
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        return bookBean;
        }
}
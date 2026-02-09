package com.kce.book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.kce.book.bean.AuthorBean;
import com.kce.book.util.DBUtil;

public class AuthorDAO {
       public AuthorBean getAuthor(int authorCode) {
    	   Connection connection =DBUtil.getDBConnection();
    	   String query="select *from Author_Tbl where author_code=?";
    	   try {
    		   PreparedStatement ps=connection.prepareStatement(query);
    		   ps.setInt(1,authorCode);
    		   ResultSet rs=ps.executeQuery();
    		   if(rs.next()) {
    			   AuthorBean authorBean=new AuthorBean();
    			   authorBean.setAuthorCode(rs.getInt(1));
    			   authorBean.setAuthorName(rs.getString(2));
    			   authorBean.setContactNo(rs.getLong(3));
    			   return authorBean;  
    		   }
    		   else {
    			   return null;
    		   }
    	   }
    	   catch(Exception e){
    		   
    	   }
		   return null;
       }
       public AuthorBean getAuthor(String authorName) {
    	   Connection connection =DBUtil.getDBConnection();
    	   String query="select *from Author_Tbl where Author_Name=?";
    	   try {
    		   PreparedStatement ps=connection.prepareStatement(query);
    		   ps.setString(1,authorName);
    		   ResultSet rs=ps.executeQuery();
    		   if(rs.next()) {
    			   AuthorBean authorBean=new AuthorBean();
    			   authorBean.setAuthorCode(rs.getInt(1));
    			   authorBean.setAuthorName(rs.getString(2));
    			   authorBean.setContactNo(rs.getLong(3));
    			   return authorBean;  
    		   }
    		   else {
    			   return null;
    		   }
    	   }
    	   catch(Exception e){
    		   
    	   }
		   return null;
       }
       
}
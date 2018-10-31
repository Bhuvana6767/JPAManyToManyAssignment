/*package com.cg.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.cg.bean.Book;
import com.cg.util.JPAUtil;

public class BookDaoImpl 
{
	EntityTransaction tran=null;
	EntityManager em=null;
	public BookDaoImpl()
	{
		em=JPAUtil.getEntityManager();
	}
	public Book addBook(Book buk)
	{
		
		tran=em.getTransaction();
		tran.begin();
		em.persist(buk);
		tran.commit();
		return buk;
	}
	
	public Book updateBookName(int bid,String btitle, int bprice)
	{
		Book bok=new Book();
		bok.setBookId(bid);
		bok.setBookTitle(btitle);
		bok.setBookPrice(bprice);

		//st.setStuName(newName);
		tran.begin();
		em.merge(bok);
		tran.commit();
		return bok;
		
	}
	public Book deleteBook(int bookId)
	{
		Book bok=em.find(Book.class,bookId);
		tran.begin();
		em.remove(bok);
		tran.commit();
		return bok;
	}
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		String selQry="SELECT bok FROM Book bok";
		TypedQuery<Book> myQry=em.createQuery(selQry, Book.class);
		List<Book> bukList=myQry.getResultList();
		return bukList;
		
	}


}
*/
package com.cg.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.cg.bean.Author;
//import com.cg.util.JPAUtil;
import com.cg.util.JPAUtil;

public class AuthorDaoImpl 
{
	EntityTransaction tran=null;
	EntityManager em=null;
	public AuthorDaoImpl()
	{
		em=JPAUtil.getEntityManager();
	}
	public Author addAuthor(Author auth)
	{
		
		tran=em.getTransaction();
		tran.begin();
		em.persist(auth);
		tran.commit();
		return auth;
	}
	
	public Author updateAuthorName(int aid,String newName)
	{
		Author aut=new Author();
		aut.setAuthorId(aid);
		aut.setAutName(newName);

		//st.setStuName(newName);
		tran.begin();
		em.merge(aut);
		tran.commit();
		return aut;
		
	}
	public Author deleteAuthor(int authorId)
	{
		Author aut=em.find(Author.class, authorId);
		tran.begin();
		em.remove(aut);
		tran.commit();
		return aut;
	}
	public List<Author> getAllAuthors() {
		// TODO Auto-generated method stub
		String selQry="SELECT aut FROM Author aut";
		TypedQuery<Author> myQry=em.createQuery(selQry, Author.class);
		List<Author> authList=myQry.getResultList();
		return authList;
		
	}

}

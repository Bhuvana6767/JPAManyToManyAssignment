//import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.cg.bean.Author;
import com.cg.bean.Book;
import com.cg.dao.AuthorDaoImpl;
//import com.cg.util.JPAUtil;


public class TestStuManytoManyClient 
{
	/*static EntityManager em=null;
	static AuthorDaoImpl autDao=null;*/

	public static void main(String[] args) 
	{
		
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("JPA-PU-Oracle");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();

		//em=JPAUtil.getEntityManager();
		//autDao=new AuthorDaoImpl();
		
		Book book1=new Book();
		book1.setBookId(1);
		book1.setBookTitle("Secrets of Persia");
		book1.setBookPrice(1000);
		
		Book book2=new Book();
		book2.setBookId(2);
		book2.setBookTitle("Harry Potter");
		book2.setBookPrice(5000);
		
		Book book3=new Book();
		book3.setBookId(3);
		book3.setBookTitle("Harry Potter");
		book3.setBookPrice(3000);
		
		
		Author at1=new Author();
		at1.setAuthorId(111);
		at1.setAutName("Sanjay");
		
		at1.addBook(book1);
		at1.addBook(book2);
		at1.addBook(book3);
		
		
		
		Author at2=new Author();
		at2.setAuthorId(222);
		at2.setAutName("Bhuvana");
		
		at2.addBook(book1);
		at2.addBook(book2);
		at2.addBook(book3);
		/*autDao.addAuthor(at1);
		autDao.addAuthor(at2);*/
		em.persist(at1);
		em.persist(at2);
/*		em.persist(book1);
		em.persist(book2);
		em.persist(book3);*/
		System.out.println("Added orders along with order details to database.");
		
		
		/*List atList=autDao.getAllAuthors();
		System.out.println(atList);*/
		em.getTransaction().commit();
		em.close();
		factory.close();

	}

}

package com.cg.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;




@Entity
@Table(name="authors")
public class Author implements Serializable
{
	
	private static final long serialVersionUID = 1L;
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="authorId")
	private int authorId;
	
	@Column(name="autName")
	private String autName;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "author_book", joinColumns = { @JoinColumn(name = "authorId") }, inverseJoinColumns = { @JoinColumn(name = "bookId") })
	private Set<Book> books = new HashSet<>();	//required to avoid NullPointerException

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public String getAutName() {
		return autName;
	}

	public void setAutName(String autName) {
		this.autName = autName;
	}

	/*@Override
	public String toString() {
		return "Author [authorId=" + authorId + ", autName=" + autName + "]";
	}
*/
	/*public Author(int authorId, String autName) {
		super();
		this.authorId = authorId;
		this.autName = autName;
	}

	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}*/
	
	public Set<Book> getBooks() {
		return books;
	}

	public void setProducts(Set<Book> books) {
		this.books = books;
	}

	public void addBook(Book book) {
		// TODO Auto-generated method stub
		this.getBooks().add(book);
	}

}

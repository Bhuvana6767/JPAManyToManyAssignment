package com.cg.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;




@Entity
@Table(name="books")
public class Book implements Serializable
{
	private static final long serialVersionUID=1L;
	
	@Id
	//@Column(name="BOOK_ID", length=5)
	//@GeneratedValue(strategy=GenerationType.AUTO)
	private int bookId;
	
	//@Column(name="BOOK_TITLE", length=10)
	private String bookTitle;;
	
	//@Column(name="BOOK_PRICE", length=5)
	private int bookPrice;

	@ManyToMany(fetch=FetchType.LAZY,mappedBy="books")
	private Set<Author> authors = new HashSet<>();
	
	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public int getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}

	/*public static long getSerialversionuid() {
		return serialVersionUID;
	}
*/
	/*@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookTitle=" + bookTitle
				+ ", bookPrice=" + bookPrice + "]";
	}*/
	public Set<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}
	

}

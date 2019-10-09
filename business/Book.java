package business;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;

/**
 *
 */
final public class Book implements Serializable {
	
	private static final long serialVersionUID = 6110690276685962829L;
	private BookCopy[] copies;
	private List<Author> authors=new ArrayList<>();
	private String isbn;
	private String title;
	private String checkoutPeriod;
	
	
	public Book() {}
	public Book(String isbn, String title, String checkoutPeriod, List<Author> authors) {
		this.isbn = isbn;
		this.title = title;
		this.checkoutPeriod = checkoutPeriod;
		this.authors = Collections.unmodifiableList(authors);
		copies = new BookCopy[]{new BookCopy(this, 1, true)};
		
	}
	
	public void updateCopies(BookCopy copy) {
		
	}

	
	public List<Integer> getCopyNums() {
		
		return null;
		
	}
	
	public void addCopy() {
		BookCopy[] newArr = new BookCopy[copies.length + 1];
		System.arraycopy(copies, 0, newArr, 0, copies.length);
		newArr[copies.length] = new BookCopy(this, copies.length +1, true);
		copies = newArr;
	}
	
	
	@Override
	public boolean equals(Object ob) {
		if(ob == null) return false;
		if(ob.getClass() != getClass()) return false;
		Book b = (Book)ob;
		return b.isbn.equals(isbn);
	}
	
	
	public boolean isAvailable() {
		return false;
	}
	@Override
	public String toString() {
		return "isbn: " + isbn + ", maxLength: " + checkoutPeriod +  ", available: " + isAvailable();
	}
	
	public String getCheckoutPeriod() {
		return checkoutPeriod;
	}

	public void setCheckoutPeriod(String checkoutPeriod) {
		this.checkoutPeriod = checkoutPeriod;
	}

	public int getNumCopies() {
		return copies.length;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
//	public StringProperty titleProperty() {
//		return title;
//	}
	public BookCopy[] getCopies() {
		return copies;
	}
	
	public List<Author> getAuthors() {
		return authors;
	}
	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}
//	public ObjectProperty<Author> authorProperty() {
//		return authors;
//	}
	
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
//	public StringProperty isbnProperty() {
//		return isbn;
//	}
	
	public BookCopy getNextAvailableCopy() {	
		return null;
	}
	
	public BookCopy getCopy(int copyNum) {
		
		return null;
	}
	public int getCopyNum() {
		return copies.length;
	}
	public void setCopies(BookCopy[] copies) {
		this.copies = copies;
	}


	
//	public String getMaxCheckoutLength() {
//		return maxCheckoutLength;
//	}
//	public void setMaxCheckoutLength(String maxCheckoutLength) {
//		this.maxCheckoutLength = maxCheckoutLength;
//	}
//	public IntegerProperty maxCheckoutLengthProperty() {
//		return maxCheckoutLength;
//	}


	
	
	
	
}

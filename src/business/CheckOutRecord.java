package business;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CheckOutRecord {
	
	List<CheckOutEntry> books=new ArrayList<>();
		
	CheckOutRecord(LibraryMember m,Book b){
		
		books.add(new CheckOutEntry(b,LocalDate.now(),LocalDate.now().plusDays(7)));
		m.setCr(this);
		
		
	}

	@Override
	public String toString() {
		return "CheckOutRecord [books=" + books + "]";
	}
	
}

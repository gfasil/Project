package util;

import business.Address;
import business.Author;
import dataaccess.DataAccessFacade;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class PopulateAuthor {
	
	private ObservableList<Author> personData = FXCollections.observableArrayList();
	private DataAccessFacade dataaccess;

	public PopulateAuthor() {
		// Add some sample data
		Address ad= new Address();
		ad.setCity("FF");
		ad.setZip("262353");
		ad.setState("IA");
		Author a=new Author("Fasil","Habtegiorgis","2024646252",ad,"fasil is a student at mum")
		personData.add(a);
		dataaccess=	new DataAccessFacade();
		dataaccess.saveNewAuthor(a);
	}

}

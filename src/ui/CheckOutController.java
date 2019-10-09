package ui;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import application.Main;
import business.Address;
import business.Book;
import business.LibraryMember;

import dataaccess.DataAccess;
import dataaccess.DataAccessFacade;
import dataaccess.User;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.util.Callback;


public class CheckOutController {
	@FXML
	private ComboBox<String> memberTable=new ComboBox<String>();
	@FXML
	private ComboBox<String> bookTable=new ComboBox<String>();

	private Label firstNameLabel;
	@FXML
	private Label lastNameLabel;
	@FXML
	private Label streetLabel;
	@FXML
	private Label postalCodeLabel;
	@FXML
	private Label cityLabel;
	@FXML
	private Label stateLabel;
	@FXML
	private Label memberId;
	@FXML
	private Label phoneNumberLabel;
	@FXML
	private Label pnumber;
	// Reference to the main application.
	private Main mainApp=null;

	/**
	 * The constructor. The constructor is called before the initialize()
	 * method.
	 */
	public CheckOutController() {
	}

	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {
		// Initialize the person table with the two columns.
//		firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
//		lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());

		preJava8();
		// Clear person details.
	//	showMemberDetails(null);

		// Listen for selection changes and show the person details when
	
	}

	private void preJava8() {
		
		
	}

	/**
	 * Is called by the main application to give a reference back to itself.
	 *
	 * @param mainApp
	 * @return 
	 */
	
	public void setMainApp(Main mainApp) {
		this.mainApp = mainApp;

		// Add observable list data to the table
		
				ObservableList<LibraryMember> temp=this.mainApp.getMemberData();
			//HashMap<String, Book> book = da.readBooksMap();
			
				List<String> temp1=new ArrayList<>();
				for(LibraryMember x:temp) {
					temp1.add(x.getMemberId());
					
				}
                
		//memberTable.setItems(mainApp.getMemberData());
				memberTable.setItems(FXCollections 
                        .observableArrayList(temp1)); 
				
			
	}
	public void setId() {
		cityLabel.setText(memberTable.getValue());
	}
	public void handleOk(LibraryMember m, Book b) {
		
		String id=memberTable.getValue();
		mainApp=new application.Main();
		DataAccess da = new DataAccessFacade();
		HashMap<String, LibraryMember> member = da.readMemberMap();
		HashMap<String, Book> book = da.readBooksMap();
			LibraryMember borrower=member.get(id);
			Book  checkoutBook=book.get(bookTable.getValue());// add bookid
			
		business.CheckOutRecordFactory.checkoutBook(borrower,checkoutBook);
		
	}
	}

	
	/**
	 * Called when the user clicks on the delete button.
	 */

	/**
	 * Called when the user clicks the new button. Opens a dialog to edit
	 * details for a new person.
	 */
	

	/**
	 * Called when the user clicks the edit button. Opens a dialog to edit
	 * details for the selected person.
	 */
	


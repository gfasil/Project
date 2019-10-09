package application;
	
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import business.LibraryMember;
import dataaccess.DataAccessFacade;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.stage.Modality;
import javafx.stage.Stage;

import ui.*;
import business.*;
//import ui.MemberEditDialogController;
//import ui.MemberoverViewController;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	private Stage primaryStage;
	//private Parent rootLayout;
	private BorderPane rootLayout;
	private ObservableList<Book> bookData =setBookData();
	private ObservableList<Author> authorData =setAuthorData();

	public Stage getPrimaryStage() {
		return primaryStage;
	}
	public ObservableList<Book> getBookData() {
		// TODO Auto-generated method stub
		
		
		return bookData;
	}
	public ObservableList<Author> getAuthorData() {
		// TODO Auto-generated method stub
		
		
		return authorData;
	}
	public ObservableList<Book> setBookData() {
		DataAccessFacade daf=new DataAccessFacade();
		HashMap<String, Book> temp= daf.readBooksMap();
		ObservableList<Book> memberData = FXCollections.observableArrayList();
		memberData.addAll(temp.values());
		return memberData;
		
	}
	
	public ObservableList<Author> setAuthorData() {
		DataAccessFacade daf=new DataAccessFacade();
		HashMap<String, Author> temp= daf.readAuthorMap();
		ObservableList<Author> memberData = FXCollections.observableArrayList();
		memberData.addAll(temp.values());
		return memberData;
		
	}
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("AddMember");
	//	this.primaryStage.getIcons().add(new Image("file:resources/images/Address_Book.png"));

			//initRootLayout();
		//Address ad = new Address("123 st", "Fairfield", "Iowa", "12345");
		//Author nahu = new Author("Nahu", "Merawi","123456789", "Great Writer");
		List<Author> author = new ArrayList<>();
		//author.add(nahu);
		Book book = new Book("432789", "Book Title", " 21 days", author);
		//EditMemberDialog(book);
		//AddMemberDialog();
		adminOverview();
		//AddAuthorDialog();
	}

	public void initRootLayout() {
		try {
			// Load root layout from fxml file.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("../application/myScene.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Show the scene containing the root layout.
			Scene scene = new Scene(page);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public boolean AddBookDialog(Book book) {
		try {
			// Load the fxml file and create a new stage for the popup dialog.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("../ui/AddBook.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Edit Person");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Set the person into the controller.
			AddBookController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			//controller.setPerson(person);
			controller.setMainApp(this);
			// Show the dialog and wait until the user closes it
			dialogStage.showAndWait();

			return controller.isOkClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean EditBookDialog(Book book) {
		try {
			// Load the fxml file and create a new stage for the popup dialog.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("../ui/EditBook.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Edit Person");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Set the person into the controller.
			EditBookController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setBook(book);

			// Show the dialog and wait until the user closes it
			dialogStage.showAndWait();

			return controller.isOkClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public void AddAuthorDialog(Book book) {
		try {
			// Load the fxml file and create a new stage for the popup dialog.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("../ui/AddAuthor.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Add Author");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Set the person into the controller.
			AddAuthorController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setBook(book);
			//controller.setPerson(person);

			// Show the dialog and wait until the user closes it
			dialogStage.showAndWait();

		//	return controller.isOkClicked();
		} catch (IOException e) {
			e.printStackTrace();
			//return false;
		}
	}
	
	public void adminOverview() {
		try {
			// Load person overview.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("../ui/AdminViewBooks.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
				
			//rootLayout.setCenter(page);
			// Create the dialog Stage.
						Stage dialogStage = new Stage();
						dialogStage.setTitle("Member Detail");
						dialogStage.initModality(Modality.WINDOW_MODAL);
						dialogStage.initOwner(primaryStage);
						Scene scene = new Scene(page);
						dialogStage.setScene(scene);
						dialogStage.show();
			AdminViewBookController controller = loader.getController();
			controller.setMainApp(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

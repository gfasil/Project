package ui;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.Arrays;

import application.Main;
import business.*;
//import model.Book;
//import util.DateUtil;

public class EditBookController {

	@FXML
	private TextField isbn;
	@FXML
	private TextField bookTitle;
	@FXML
	private TextField authors;
	@FXML
	private TextField checkoutPeriod;

	private Stage dialogStage;
	private Book book;
	private boolean okClicked = false;
	private Main mainApp;

	Author tempAuthor = new Author();
	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {
	}

	/**
	 * Sets the stage of this dialog.
	 *
	 * @param dialogStage
	 */
	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	/**
	 * Sets the book to be edited in the dialog.
	 *
	 * @param book
	 */
	public void setBook(Book book) {
		//this.book = book;

		isbn.setText(book.getIsbn());
		bookTitle.setText(book.getTitle());
		authors.setText("" +Arrays.asList(book.getAuthors()));
		checkoutPeriod.setText(book.getCheckoutPeriod());	
		}

	/**
	 * Returns true if the user clicked OK, false otherwise.
	 *
	 * @return
	 */
	public boolean isOkClicked() {
		return okClicked;
	}

	/**
	 * Called when the user clicks ok.
	 */
	@FXML
	private void handleOk() {
		if (isInputValid()) {
			book.setIsbn(isbn.getText());
			book.setTitle(bookTitle.getText());
			//book.setAuthors(authors.getText());
			book.setCheckoutPeriod(checkoutPeriod.getText());
			okClicked = true;
			dialogStage.close();
		}
	}
	
	@FXML
	private void handleNewAuthor() {
		
		boolean okClicked = mainApp.AddAuthorDialog();
		if (okClicked) {
			mainApp.getAuthorData().add(tempAuthor);
		}
	}

	/**
	 * Called when the user clicks cancel.
	 */
	@FXML
	private void handleCancel() {
		dialogStage.close();
	}

	/**
	 * Validates the user input in the text fields.
	 *
	 * @return true if the input is valid
	 */
	private boolean isInputValid() {
		String errorMessage = "";

		if (isbn.getText() == null || isbn.getText().length() == 0) {
			errorMessage += "No valid ISBN!\n";
		}
		if (bookTitle.getText() == null || bookTitle.getText().length() == 0) {
			errorMessage += "No valid Title!\n";
		}
		if (authors.getText() == null || authors.getText().length() == 0) {
			errorMessage += "No valid Authors!\n";
		}

		if (checkoutPeriod.getText() == null || checkoutPeriod.getText().length() == 0) {
			errorMessage += "No valid Checkout Period!\n";
		
		}



		if (errorMessage.length() == 0) {
			return true;
		} else {
			// Show the error message.
			Alert alert = new Alert(AlertType.ERROR);
			alert.initOwner(dialogStage);
			alert.setTitle("Invalid Fields");
			alert.setHeaderText("Please correct invalid fields");
			alert.setContentText(errorMessage);

			alert.showAndWait();

			return false;
		}
	}
}

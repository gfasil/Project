package application;
	
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import business.LibraryMember;
import business.SystemController;
import dataaccess.DataAccessFacade;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.stage.Modality;
import javafx.stage.Stage;

import ui.AddMemberDialogController;
import ui.CheckOutController;
import ui.MemberEditDialogController;
import ui.MemberOverViewLibrarianController;
import ui.MemberoverViewController;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	private Stage primaryStage;
	//private Parent rootLayout;
	private BorderPane rootLayout;
	private ObservableList<LibraryMember> memberData =setMemberData();

	public Stage getPrimaryStage() {
		return primaryStage;
	}
	public ObservableList<LibraryMember> getMemberData() {
		// TODO Auto-generated method stub
		
		
		return memberData;
	}
	public ObservableList<LibraryMember> setMemberData() {
		DataAccessFacade daf=new DataAccessFacade();
		HashMap<String, LibraryMember> temp= daf.readMemberMap();
		ObservableList<LibraryMember> memberData = FXCollections.observableArrayList();
		memberData.addAll(temp.values());
		return memberData;
		
	}
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("AddMember");
	//	this.primaryStage.getIcons().add(new Image("file:resources/images/Address_Book.png"));

			//initRootLayout();

	//	showMemberOverview();
		//AddMemberDialog();
	//	showMemberOverviewLib();
	//	LoginDialog();
		showCheckOutview();
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
	public boolean LoginDialog() {
		try {
			// Load the fxml file and create a new stage for the popup dialog.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("../ui/Login.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Edit Person");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Set the person into the controller.
			SystemController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			//controller.setPerson(person);

			// Show the dialog and wait until the user closes it
			dialogStage.show();

			return controller.isOkClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean AddMemberDialog() {
		try {
			// Load the fxml file and create a new stage for the popup dialog.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("../ui/AddMember.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Edit Person");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Set the person into the controller.
			AddMemberDialogController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			//controller.setPerson(person);

			// Show the dialog and wait until the user closes it
			dialogStage.showAndWait();

			return controller.isOkClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean EditMemberDialog(LibraryMember member) {
		try {
			// Load the fxml file and create a new stage for the popup dialog.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("../ui/AdminEditMember.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Edit Member");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Set the person into the controller.
			MemberEditDialogController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setMember(member);

			// Show the dialog and wait until the user closes it
			dialogStage.showAndWait();

			return controller.isOkClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public void showMemberOverview() {
		try {
			// Load person overview.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("../ui/MemberView.fxml"));
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
			MemberoverViewController controller = loader.getController();
			controller.setMainApp(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void showCheckOutview() {
		try {
			// Load person overview.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("../ui/CheckOutView.fxml"));
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
			CheckOutController controller = loader.getController();
			controller.setMainApp(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void showMemberOverviewLib() {
		try {
			// Load person overview.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("../ui/MemberView2.fxml"));
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
						MemberOverViewLibrarianController controller = loader.getController();
			controller.setMainApp(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

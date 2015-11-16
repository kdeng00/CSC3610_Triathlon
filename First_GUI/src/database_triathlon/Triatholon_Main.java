package database_triathlon;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import database_triatholon.Triatholon_Info;
import database_triatholon.Triatholon_DBaseDriver;
import database_triatholon.Triatholon_Main;

public class Triatholon_Main extends Application{
	private BorderPane rootLayout;
	private AnchorPane controlData;
	private Stage primaryStage;
	private Triatholon_DBaseDriver dbaseConnection;
	@FXML
	private TableView<Triatholon_Info> tblView;
	@FXML
	private TableColumn<Triatholon_Info, String>tblColumn_Name;
	@FXML
	private TableColumn<Triatholon_Info, String> tblColumn_Pos;
	@FXML
	private TableColumn<Triatholon_Info, String> tblColumn_Phone;
	@FXML
	private TableColumn<Triatholon_Info, String> tblColumn_Email;

	
	@Override
	public void start(Stage primaryStage) throws Exception{
		
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Triatholon Results");

		
		initializeRoot();
		showControlsData();
	}
	private void showControlsData() {
		FXMLLoader load = new FXMLLoader();
		load.setLocation(Triatholon_Main.class.getResource("ControlData.fxml"));
		
		try {
			controlData = (AnchorPane)load.load();
		}
		catch (IOException exc) {
			exc.printStackTrace();
		}
		rootLayout.setCenter(controlData);
	}
	private void initializeRoot() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Triatholon_Main.class.getResource("RootLayout.fxml"));
		
		try{
			rootLayout = (BorderPane)loader.load();
		}
		catch(IOException exc) {
			exc.printStackTrace();
		}
//		rootLayout.setCenter(staffTable);
		Scene scn = new Scene(rootLayout);
		primaryStage.setScene(scn);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}

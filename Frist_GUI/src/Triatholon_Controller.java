package database_triatholon;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import database_triatholon.Triatholon_DBaseDriver;

public class Triatholon_Controller {
	
	@FXML
	private MenuItem menuClose;
	
	@FXML
	private TableView<Triatholon_Info> tblMale;
	@FXML
	private TableView<Triatholon_Info> tblFemale;
	@FXML
	private TableColumn<Triatholon_Info, String> rankMale;
	@FXML
	private TableColumn<Triatholon_Info, String> nameMale;
	@FXML
	private TableColumn<Triatholon_Info, String> totalTimeMale;
	@FXML
	private TableColumn<Triatholon_Info, String> rankFemale;
	@FXML
	private TableColumn<Triatholon_Info, String> nameFemale;
	@FXML
	private TableColumn<Triatholon_Info, String> totalTimeFemale;
	
	
	private Triatholon_DBaseDriver dbaseConnection;

	private BorderPane rootLayout;
	private AnchorPane controlData;
	
	public Triatholon_Controller() throws IOException{
		
	}
	
	public void initialize() throws Exception {
		
		dbaseConnection = new Triatholon_DBaseDriver("jdbc:mysql://localhost:3306/athlete_results", "root", "password");

		rankMale.setCellValueFactory(new PropertyValueFactory<>("Rank"));
		nameMale.setCellValueFactory(new PropertyValueFactory<>("Names"));
		totalTimeMale.setCellValueFactory(new PropertyValueFactory<>("TotalTime"));
		
		
		tblMale.getItems().addAll(dbaseConnection.getMaleAthleteInfo());
		
		rankFemale.setCellValueFactory(new PropertyValueFactory<>("Rank"));
		nameFemale.setCellValueFactory(new PropertyValueFactory<>("Names"));
		totalTimeFemale.setCellValueFactory(new PropertyValueFactory<>("TotalTime"));
		
		
		tblFemale.getItems().addAll(dbaseConnection.getFemaleAthleteInfo());
		
		menuClose.setOnAction((e) -> {
			System.exit(0);
		});
		
		
	}

}

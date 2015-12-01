package deng;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class Triathlon_Controller {
	/**
	@FXML
	private MenuItem menuClose;
	@FXML
	private Label maleWinner;
	@FXML 
	private Label femaleWinner;
	@FXML
	private TableView<Triatholon_Info> tblMale;
	@FXML
	private TableView<Triatholon_Info> tblFemale;
	@FXML
	private TableColumn<Triatholon_Info, String> rankMale;
	@FXML
	private TableColumn<Triatholon_Info, String> nameFirstMale;
	@FXML
	private TableColumn<Triatholon_Info, String> nameLastMale;
	@FXML
	private TableColumn<Triatholon_Info, String> totalTimeMale;
	@FXML
	private TableColumn<Triatholon_Info, String> rankFemale;
	@FXML
	private TableColumn<Triatholon_Info, String> nameFirstFemale;
	@FXML
	private TableColumn<Triatholon_Info, String> nameLastFemale;
	@FXML
	private TableColumn<Triatholon_Info, String> totalTimeFemale;
	
	
	private Triatholon_DBaseDriver dbaseConnection;

	private BorderPane rootLayout;
	private AnchorPane controlData;
	
	public Triathlon_Controller() throws IOException{
		
	}
	
	public void initialize() throws Exception {
		
		dbaseConnection = new Triatholon_DBaseDriver("jdbc:mysql://localhost:3306/ath_info", "root", "password");

//		rankMale.setCellValueFactory(new PropertyValueFactory<>("Rank"));
		nameFirstMale.setCellValueFactory(new PropertyValueFactory<>("FirstNames"));
		nameLastMale.setCellValueFactory(new PropertyValueFactory<>("LastNames"));
		totalTimeMale.setCellValueFactory(new PropertyValueFactory<>("TotalTime"));
		
		
		tblMale.getItems().addAll(dbaseConnection.getMaleAthleteInfo());
		
//		rankFemale.setCellValueFactory(new PropertyValueFactory<>("Rank"));
		nameFirstFemale.setCellValueFactory(new PropertyValueFactory<>("FirstNames"));
		nameLastFemale.setCellValueFactory(new PropertyValueFactory<>("LastNames"));
		totalTimeFemale.setCellValueFactory(new PropertyValueFactory<>("TotalTime"));
		
		
		tblFemale.getItems().addAll(dbaseConnection.getFemaleAthleteInfo());
		
		menuClose.setOnAction((e) -> {
			System.exit(0);
		});
	}
	*/
}

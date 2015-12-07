import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class Triatholon_Controller {
	
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
	private TableColumn<Triatholon_Info, String> placeMale;
	@FXML
	private TableColumn<Triatholon_Info, String> numberMale;
	@FXML
	private TableColumn<Triatholon_Info, String> firstNameMale;
	@FXML
	private TableColumn<Triatholon_Info, String> lastNameMale;
	@FXML
	private TableColumn<Triatholon_Info, String> runTimeMale;
	@FXML
	private TableColumn<Triatholon_Info, String> runSpeedMale;
	@FXML
	private TableColumn<Triatholon_Info, String> swimTimeMale;
	@FXML
	private TableColumn<Triatholon_Info, String> swimSpeedMale;
	@FXML
	private TableColumn<Triatholon_Info, String> bikeTimeMale;
	@FXML
	private TableColumn<Triatholon_Info, String> bikeSpeedMale;
	@FXML
	private TableColumn<Triatholon_Info, String> totalTimeMale;
	@FXML
	private TableColumn<Triatholon_Info, String> placeFemale;
	@FXML
	private TableColumn<Triatholon_Info, String> numberFemale;
	@FXML
	private TableColumn<Triatholon_Info, String> firstNameFemale;
	@FXML
	private TableColumn<Triatholon_Info, String> lastNameFemale;
	@FXML
	private TableColumn<Triatholon_Info, String> runTimeFemale;
	@FXML
	private TableColumn<Triatholon_Info, String> runSpeedFemale;
	@FXML
	private TableColumn<Triatholon_Info, String> swimTimeFemale;
	@FXML
	private TableColumn<Triatholon_Info, String> swimSpeedFemale;
	@FXML
	private TableColumn<Triatholon_Info, String> bikeTimeFemale;
	@FXML
	private TableColumn<Triatholon_Info, String> bikeSpeedFemale;
	@FXML
	private TableColumn<Triatholon_Info, String> totalTimeFemale;
	
	
	
	private Triatholon_DBaseDriver dbaseConnection;
	private Statement stmt;

	private BorderPane rootLayout;
	private AnchorPane controlData;
	
	public Triatholon_Controller() throws IOException{
		
	}
public void populateDatabase() {
		try {
		
		dbaseConnection = new Triatholon_DBaseDriver("jdbc:mysql://localhost:3306/ath_info", "root", "password");

		placeMale.setCellValueFactory(new PropertyValueFactory<>("Place"));
		numberMale.setCellValueFactory(new PropertyValueFactory<>("Number"));
		firstNameMale.setCellValueFactory(new PropertyValueFactory<>("FirstNames"));
		lastNameMale.setCellValueFactory(new PropertyValueFactory<>("LastNames"));
		runTimeMale.setCellValueFactory(new PropertyValueFactory<>("RunTime"));
		runSpeedMale.setCellValueFactory(new PropertyValueFactory<>("RunSpeed"));
		swimTimeMale.setCellValueFactory(new PropertyValueFactory<>("SwimTime"));
		swimSpeedMale.setCellValueFactory(new PropertyValueFactory<>("SwimSpeed"));
		bikeTimeMale.setCellValueFactory(new PropertyValueFactory<>("BikeTime"));
		bikeSpeedMale.setCellValueFactory(new PropertyValueFactory<>("BikeSpeed"));
		totalTimeMale.setCellValueFactory(new PropertyValueFactory<>("TotalTime"));
		
		
		tblMale.getItems().addAll(dbaseConnection.getMaleAthleteInfo());
		
		placeFemale.setCellValueFactory(new PropertyValueFactory<>("Place"));
		numberFemale.setCellValueFactory(new PropertyValueFactory<>("Number"));
		firstNameFemale.setCellValueFactory(new PropertyValueFactory<>("FirstNames"));
		lastNameFemale.setCellValueFactory(new PropertyValueFactory<>("LastNames"));
		runTimeFemale.setCellValueFactory(new PropertyValueFactory<>("RunTime"));
		runSpeedFemale.setCellValueFactory(new PropertyValueFactory<>("RunSpeed"));
		swimTimeFemale.setCellValueFactory(new PropertyValueFactory<>("SwimTime"));
		swimSpeedFemale.setCellValueFactory(new PropertyValueFactory<>("SwimSpeed"));
		bikeTimeFemale.setCellValueFactory(new PropertyValueFactory<>("BikeTime"));
		bikeSpeedFemale.setCellValueFactory(new PropertyValueFactory<>("BikeSpeed"));
		totalTimeFemale.setCellValueFactory(new PropertyValueFactory<>("TotalTime"));
		
		
		tblFemale.getItems().addAll(dbaseConnection.getFemaleAthleteInfo());
		
		menuClose.setOnAction((e) -> {
			System.exit(0);
		});
		}
		catch (SQLException e) {
			e.printStackTrace();
			
		}
		
	}
	
	public void initialize() throws Exception {
//		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/csc3610_takehome2"
//				, "root", "password");
//		stmt = conn.createStatement();
//	    stmt.executeUpdate("delete from Salary;"); //deletes data from Salary every time application is run
		
		populateDatabase();
		
		
	}


}

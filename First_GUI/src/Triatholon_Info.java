package database_triatholon;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Triatholon_Info {
	
	public Triatholon_Info() {
		
	}
	
	private final StringProperty Names = new SimpleStringProperty(this, "Names");

	private final StringProperty Number = new SimpleStringProperty(this, "Number");
	
	private final StringProperty RunTime = new SimpleStringProperty(this, "RunTime");
	
	private final StringProperty BikeTime = new SimpleStringProperty(this, "BikeTime");

	private final StringProperty SwimTime = new SimpleStringProperty(this, "SwimTime");

	private final StringProperty TotalTime = new SimpleStringProperty(this, "TotalTime");
	
	private final StringProperty Gender = new SimpleStringProperty(this, "Gender");
	
	private final StringProperty Rank = new SimpleStringProperty(this, "Rank");
	
	public StringProperty NamesProperty() {
		return Names;
	}
	
	public StringProperty NumberProperty() {
		return Number;
	}
	
	public StringProperty RunProperty() {
		return RunTime;
	}
	
	public StringProperty BikeProperty() {
		return BikeTime;
	}
	
	public StringProperty SwimProperty() {
		return SwimTime;
	}
	
	public StringProperty TotalProperty() {
		return TotalTime;
	}
	
	public StringProperty GenderProperty() {
		return Gender;
	}
	
	public StringProperty RankProperty() {
		return Rank;
	}
	
	public final String getNames() {
		return NamesProperty().get();
	}
	
	public final String getNumber() {
		return NumberProperty().get();
	}
	
	public final String getRunTime() {
		return RunProperty().get();
	}
	
	public final String getBikeTime() {
		return BikeProperty().get();
	}
	
	public final String getSwimTime() {
		return SwimProperty().get();
	}
	
	public final String getTotalTime() {
		return TotalProperty().get();
	}
	
	public final String getGender() {
		return GenderProperty().get();
	}
	
	public final String getRank() {
		return RankProperty().get();
	}
	public final void setNames(String names) {
		NamesProperty().set(names);
	}
	
	public final void setNumber(String number) {
		NumberProperty().set(number);
	}
	
	public final void setRun(String runTime) {
		RunProperty().set(runTime);
	}
	
	public final void setBike(String bikeTime) {
		BikeProperty().set(bikeTime);
	}
	public final void setSwim(String swimTime) {
		SwimProperty().set(swimTime);
	}
	
	public final void setTotal(String totalTime) {
		TotalProperty().set(totalTime);
	}
	
	public final void setGender(String gender) {
		GenderProperty().set(gender);
	}
	
	public final void setRank(String rank) {
		RankProperty().set(rank);
	}
	public Triatholon_Info(String Names, String Number, String RunTime, String BikeTime, String SwimTime,
			String TotalTime, String Gender, String Rank) {
		setNames(Names);
		setNumber(Number);
		setRun(RunTime);
		setBike(BikeTime);
		setSwim(SwimTime);
		setTotal(TotalTime);
		setGender(Gender);
		setRank(Rank);
		
	}
}

package logic;

import java.util.ArrayList;

public class DatabaseHandler {
	//To-Do Connect the database;
	
	public final String DatabaseLocation = "efood.db";
	public final String PlateTable = "Plate";
	public final String PlateIDField = "PlateID";
	public final String PlateNameField = "Name";
	public final String PlateDescriptionField = "Description";
	public final String PlatePriceField = "Price";
	public final String PlateImagePathField = "Image";
	
	public DatabaseHandler() {
		CreateTables();
	}
	
	private void CreateTables() {
		//Creating tables.
		String PlateQuery = "CREATE TABLE IF NOT EXISTS " + PlateTable + "( " + PlateIDField + " INTEGER PRIMARY KEY AYTOINCREMENT, "
				+ PlateNameField + " STRING NOT NULL, " + PlateDescriptionField + " STRING, " + PlatePriceField + " REAL NOT NULL, "
						+ PlateImagePathField + " STRING NOT NULL) ";
		InsertItem("Burger","Juicy Burger",5.99,"images/burger.jpg");
		//To-Do Insert more Dummy Data
	}
	
	public void InsertItem(String plateName, String plateDesc, double price, String imagePath) {
		String InsertQuery = "INSERT INTO " + PlateTable + "(" + PlateNameField + "," + PlateDescriptionField + "," + PlatePriceField + "," + PlateImagePathField + ") VALUES (" + 
				"  '" + plateName+ "'," + 
				"  '" + plateDesc + "'," + 
				"  '" + price + "'," + 
				"  '" + imagePath + "'," + 
				"); ";
		
		//TO-DO complete insert statement
	}
	
	public ArrayList<Plate> getAllPlates(){
		String SelectQuery = "SELECT * FROM " + PlateTable + ";";
		//To-Do Complete Select statement
		return new ArrayList<Plate>();
	}
	
	
}

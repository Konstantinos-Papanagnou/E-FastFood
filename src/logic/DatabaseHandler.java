package logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DatabaseHandler {
	//To-Do Connect the database;
	Connection connection;
	public final String DatabaseLocation = "Plates.db";
	public final String PlateTable = "Plates";
	public final String PlateIDField = "ID";
	public final String PlateNameField = "Name";
	public final String PlateDescriptionField = "Description";
	public final String PlateCategoryField = "Category";
	public final String PlatePriceField = "Price";
	public final String PlateImagePathField = "ImagePath";
	
	public DatabaseHandler() {
		try
		{
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:Plates.db");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public ArrayList<Plate> getAllPlates(){
		String SelectQuery = "SELECT * FROM " + PlateTable;
		PreparedStatement preped = null;
		ResultSet res = null;
		ArrayList<Plate> plates = new ArrayList<Plate>();
		
		try {
			preped = connection.prepareStatement(SelectQuery);
			res = preped.executeQuery();
			while(res.next()) {
				plates.add(new Plate(res.getInt(PlateIDField), res.getString(PlateNameField), res.getString(PlateDescriptionField), res.getDouble(PlatePriceField), res.getString(PlateImagePathField), res.getString(PlateCategoryField)));
			}
			return plates;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	
}

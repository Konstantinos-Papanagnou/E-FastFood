package logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
			String CreateQuery = "CREATE TABLE IF NOT EXISTS CART(ID INTEGER PRIMARY KEY AUTOINCREMENT, PLATENAME STRING NOT NULL, PLATEQUANTITY INT NOT NULL, PRICE REAL NOT NULL)";
			Statement state;
			try {
				state = connection.createStatement();
				state.execute(CreateQuery);
			}catch(SQLException e){
				e.printStackTrace();
			}
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
	
	public boolean addToCart(String PlateName, int Quantity, double Real){
		
		String InsertQuery = "INSERT INTO CART (PLATENAME,PLATEQUANTITY,PRICE) VALUES (?,?,?)"; 
		PreparedStatement preped = null;
		
		try {
			preped = connection.prepareStatement(InsertQuery);
			preped.setString(1, PlateName);
			preped.setInt(2, Quantity);
			preped.setDouble(3, Real);
			
			preped.executeUpdate();
			
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	public ArrayList<Order> getCart(){
		String SelectQuery = "SELECT * FROM CART";
		PreparedStatement preped = null;
		ResultSet res = null;
		ArrayList<Order> plates = new ArrayList<Order>();
		
		try {
			preped = connection.prepareStatement(SelectQuery);
			res = preped.executeQuery();
			while(res.next()) {
				plates.add(new Order(Integer.toString(res.getInt("ID")), res.getString("PLATENAME"), Integer.toString(res.getInt("PLATEQUANTITY")), Double.toString(res.getDouble("PRICE"))));
			}
			return plates;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean deleteFromCart(int id) {
		String DeleteQuery = "DELETE FROM CART WHERE ID=?";
		PreparedStatement preped = null;
		try {
			preped = connection.prepareStatement(DeleteQuery);
			preped.setInt(1, id);
			preped.executeUpdate();
			
			return true;
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean clearCart() {
		String DeleteQuery = "DELETE FROM CART";
		PreparedStatement preped = null;
		try {
			preped = connection.prepareStatement(DeleteQuery);
			preped.executeUpdate();
			
			return true;
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}

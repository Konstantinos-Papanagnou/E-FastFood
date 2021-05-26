package logic;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Plate {
	public static ArrayList<Plate> platesInCart = new ArrayList<Plate>();
	private int plateID;
	private String imagePath;
	private String plateName;
	private double price;
	private String description;
	private int quantity;
	private String category;
	
	public int getQuantity() {
		return quantity;
	}
	public int getPlateID() {
		return plateID;
	}
	public String getImagePath() {
		return imagePath;
	}
	public String getPlateName() {
		return plateName;
	}
	public double getPrice() {
		return price;
	}
	public String getDescription() {
		return description;
	}
	public String getCategory() {
		return category;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public void setPlateID(int plateID) {
		this.plateID = plateID;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public void setPlateName(String plateName) {
		this.plateName = plateName;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	public Plate(String plateName, String description, double price, String imagePath, String category) {
		this.plateName = plateName;
		this.description = description;
		this.price = price;
		this.imagePath = imagePath;
		this.category = category;
	}
	public Plate(int plateID, String plateName, String description, double price, String imagePath, String category) {
		this.plateID = plateID;
		this.plateName = plateName;
		this.description = description;
		this.price = price;
		this.imagePath = imagePath;
		this.category = category;
	}
}

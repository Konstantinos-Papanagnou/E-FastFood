package logic;

public class Plate {
	private int plateID;
	private String imagePath;
	private String plateName;
	private double price;
	private String description;
	
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
	public String Description() {
		return description;
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
	
	public Plate(String plateName, String description, double price, String imagePath) {
		this.plateName = plateName;
		this.description = description;
		this.price = price;
		this.imagePath = imagePath;
	}
}

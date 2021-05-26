package logic;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Order {

	private final StringProperty ID;
	private final StringProperty proion;
	private final StringProperty posotita;
	private final StringProperty timi;
	

	public Order (String dataID,String dataproion,String dataposotita,String datatimi) {
		this.ID=new SimpleStringProperty(dataID);
		this.proion=new SimpleStringProperty(dataproion);
       this.posotita=new SimpleStringProperty(dataposotita);
       this.timi=new SimpleStringProperty(datatimi);
       
	}
	
	
	
	public StringProperty IDProperty() {
		return this.ID;
	}
  
	public String getID() {
		return this.IDProperty().get();
	}
	
	public void setID(String ID) {
		this.IDProperty().set(ID);
	}
	
	

	
	public StringProperty proionProperty() {
		return this.proion;
		
	}
	
	public String getproion() {
		return this.proionProperty().get();
	}
  
	public void setproion(String proion) {
		this.proionProperty().set(proion);
	}
	
	
	
	public StringProperty posotitaProperty() {
		return this.posotita;
		
	}
	
	public String getposotita() {
		return this.posotitaProperty().get();
	}
  
	public void setposotita(String posotita) {
		this.proionProperty().set(posotita);
	}
	
	
	
	
	
	
	public StringProperty timiProperty() {
		return this.timi;
		
	}
	
	public String gettimi() {
		return this.timiProperty().get();
	}
  
	public void settimi(String timi) {
		this.proionProperty().set(timi);
	}
}
	
	
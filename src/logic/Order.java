package logic;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Order {

	private final StringProperty proion;
	private final StringProperty posotita;
	private final StringProperty timi;

	public Order (String dataproion,String dataposotita,String datatimi) {
       this.proion=new SimpleStringProperty(dataproion);
       this.posotita=new SimpleStringProperty(dataposotita);
       this.timi=new SimpleStringProperty(datatimi);
       
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
	
	
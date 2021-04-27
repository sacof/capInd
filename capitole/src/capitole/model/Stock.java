package capitole.model;

import capitole.MainClass;

public class Stock {

	private int sizeId;
	private long quantity;
	
	
	public Stock(String csvItem) {
		
		String[] values = csvItem.split(MainClass.SEPARATOR);
		this.sizeId = Integer.parseInt(values[0].trim());
		this.quantity = Long.parseLong(values[1].trim());
	}

	public long getQuantity() {
		return quantity;
	}


	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}


	public int getSizeId() {
		return sizeId;
	}
	

	
	
	
	

}

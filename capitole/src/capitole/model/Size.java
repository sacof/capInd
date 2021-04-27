package capitole.model;

import capitole.MainClass;

public class Size {

	private int id;
	private long productId;
	private boolean backsoon;
	private boolean special;
	
	
	public Size(String csvItem)
	{
		String[] values = csvItem.split(MainClass.SEPARATOR);
		this.id = Integer.parseInt(values[0].trim());
		this.productId = Long.parseLong(values[1].trim());
		this.backsoon = Boolean.parseBoolean(values[2].trim());
		this.special = Boolean.parseBoolean(values[3].trim());
	}
	


	public boolean isBacksoon() {
		return backsoon;
	}


	public void setBacksoon(boolean backsoon) {
		this.backsoon = backsoon;
	}


	public boolean isSpecial() {
		return special;
	}


	public void setSpecial(boolean special) {
		this.special = special;
	}


	public int getId() {
		return id;
	}


	public long getProductId() {
		return productId;
	}
	
	
	

}

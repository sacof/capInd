package capitole.model;

import capitole.MainClass;

public class Product implements Comparable<Integer>{

	private long id;
	private int sequence;
	
	
	
	public Product(String csvItem)
	{
		String[] values = csvItem.split(MainClass.SEPARATOR);
		this.id = Long.parseLong(values[0].trim());
		this.sequence = Integer.parseInt(values[1].trim());
	}

	public long getId() {
		return id;
	}

	public int getSequence() {
		return sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}

	

	@Override
	public int compareTo(Integer o) {
		return this.sequence - o;
	}

}

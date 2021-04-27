package capitole.mgr;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import capitole.filesUtils.CSVReader;
import capitole.interf.ILoader;
import capitole.model.Product;

public class ProductManager implements ILoader{

	private static final String PATH = "./files/product.csv";
	List<Product> productList;
	
	public ProductManager() {
		productList = new ArrayList<>();
	}

	@Override
	public void addListItem(List<String> items) {
		
		for(String item:items)
		{
			Product product = new Product(item);
			productList.add(product);
		}
		
	}


	public void load()
	{
		addListItem(CSVReader.readCSV(PATH));
	}
	
	public List<Product> getProductList()
	{
		return Collections.unmodifiableList(productList);
	}
}

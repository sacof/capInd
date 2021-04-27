package capitole;

import java.util.Collections;
import java.util.List;

import capitole.mgr.FilterManager;
import capitole.mgr.ProductManager;
import capitole.mgr.SizeManager;
import capitole.mgr.StockManager;
import capitole.model.Product;

public class MainClass {

	public static final String SEPARATOR = ",";


	public static void main(String[] args) {

		ProductManager productMgr = new ProductManager();
		productMgr.load();
		SizeManager sizeMgr = new SizeManager();
		sizeMgr.load();
		StockManager stockMgr = new StockManager();
		stockMgr.load();
		
		FilterManager filterMgr = new FilterManager();
		List<Product> filteredProductList =  filterMgr.doFilter(productMgr, sizeMgr, stockMgr);
		Collections.sort(filteredProductList, (x, y) -> x.compareTo(y.getSequence()));
		if (filteredProductList.isEmpty())
		{
			System.out.println("No hay productos");
		}
		else
		{
			boolean first = Boolean.TRUE;
			for(Product product: filteredProductList)
			{
				if(!first)
				{
					System.out.print(",");
				}
				System.out.print(product.getId());
				first = Boolean.FALSE;
			}
			System.out.println();
		}
	}

}

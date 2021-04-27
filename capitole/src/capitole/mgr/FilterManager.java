package capitole.mgr;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import capitole.model.Product;
import capitole.model.Size;

public class FilterManager {

	public FilterManager() {
		
	}

	public List<Product> doFilter(ProductManager productMgr, SizeManager sizeMgr, StockManager stockMgr)
	{
		List<Product> filteredProductList = new ArrayList<>();
		
		List<Product> productList =  productMgr.getProductList();
		for(Product product : productList)
		{
			long productId = product.getId();
			boolean hasSpecialSize = sizeMgr.productHasSpecialSize(productId);
			boolean inStockNormal = Boolean.FALSE;
			boolean inStockSpecial = !hasSpecialSize;
			List<Size> sizeList = sizeMgr.getAllSizeByProduct(productId);
			Iterator<Size> sizeListIterator = sizeList.iterator();
			//while (sizeListIterator.hasNext() && !inStockNormal && ((hasSpecialSize && !inStockSpecial) || !hasSpecialSize))
			while (sizeListIterator.hasNext() &&
					(hasSpecialSize && !(inStockNormal && inStockSpecial))
					||(!hasSpecialSize && !inStockNormal))
			{
				Size sizeItem = sizeListIterator.next();
				if(sizeItem.isBacksoon())
				{
					if(sizeItem.isSpecial())
					{
						inStockSpecial = Boolean.TRUE;
					}
					else
					{
						inStockNormal = Boolean.TRUE;
					}
				}
				else {
					if(sizeItem.isSpecial())
					{
						inStockSpecial |= stockMgr.hasStockBySize(sizeItem.getId());
					}
					else
					{
						inStockNormal |= stockMgr.hasStockBySize(sizeItem.getId());
					}
				}
			}
			if(inStockNormal && inStockSpecial)
			{
				filteredProductList.add(product);
			}
		}
		return filteredProductList;
		
		
	}
}

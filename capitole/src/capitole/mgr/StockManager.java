package capitole.mgr;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

import capitole.filesUtils.CSVReader;
import capitole.interf.ILoader;
import capitole.model.Stock;

public class StockManager implements ILoader{

	private static final String PATH = "./files/stock.csv";
	Map<Integer,Stock> stockMap;
	
	
	public StockManager() {
		stockMap = new HashMap<>();
	}

	@Override
	public void addListItem(List<String> items) {
		
		for(String item:items)
		{
			Stock stockItem = new Stock(item);
			stockMap.put(stockItem.getSizeId(),stockItem);
		}
		
	}


	public void load()
	{
		addListItem(CSVReader.readCSV(PATH));
	}
	
	public boolean hasStockBySize(int sizeId)
	{
		boolean hasStock = Boolean.FALSE;
		if (stockMap.containsKey(sizeId))
		{
			hasStock = stockMap.get(sizeId).getQuantity() > 0;
		}
		return hasStock;
	}
	
	public List<Integer> getFilteredValues(long minQty)
	{
		List<Integer> collect = stockMap.entrySet().stream()
		        .filter(x -> x.getValue().getQuantity() >= minQty)
		        .map(x->x.getKey()) 
		        .collect(Collectors.toList());
		return collect;
	}
}

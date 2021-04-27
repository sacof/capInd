package capitole.mgr;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import capitole.filesUtils.CSVReader;
import capitole.interf.ILoader;
import capitole.model.Size;

public class SizeManager implements ILoader {

	private static final String PATH = "./files/size.csv";
	Map<Integer,Size> sizeMap;
	
	public SizeManager() {
		sizeMap = new HashMap<>();
	}
	
	
	@Override
	public void addListItem(List<String> items) {
		
		for(String item:items)
		{
			Size sizeItem = new Size(item);
			sizeMap.put(sizeItem.getId(),sizeItem);
		}
		
	}


	public void load()
	{
		addListItem(CSVReader.readCSV(PATH));
	}
	

	public List<Integer> getSizeInStock(List<Integer> sizeInStock)
	{
		List<Integer> collect = sizeMap.entrySet().stream()
		        .filter(x -> sizeInStock.contains(x.getKey()) || x.getValue().isBacksoon())
		        .map(x->x.getKey()) 
		        .collect(Collectors.toList());
		return collect;
	}
	
	public boolean productHasSpecialSize(long productId)
	{
		List<Size> collect = sizeMap.entrySet().stream()
		        .filter(x -> x.getValue().getProductId() == productId && x.getValue().isSpecial())
		        .map(x->x.getValue()) 
		        .collect(Collectors.toList());
		return !collect.isEmpty();
	}
	
	public List<Size> getAllSizeByProduct(long productId)
	{
		List<Size> collect = sizeMap.entrySet().stream()
		        .filter(x -> x.getValue().getProductId() == productId)
		        .map(x->x.getValue()) 
		        .collect(Collectors.toList());
		return collect;
	}
	
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;

public class Document extends Item {

	private double basicCharge;
	
	Document(String name, double weight) {
		super(name, weight,"D");
	}
	
	@SuppressWarnings("serial")
	private TreeMap<Double, Weight> weightTable = new TreeMap<Double, Weight>() {
		{
			put((double) 0, Weight.ZERO);
			put((double) 300, Weight.LIGHT);
			put((double) 1000, Weight.MEDIUM);
			put((double) 3000, Weight.HEAVY);
			put((double) 5000, Weight.TOOHEAVY);
			put((double) 10000, Weight.IMPOSSIBLE);

		}
	};

	@SuppressWarnings("serial")
	private TreeMap<Double, Distance> distanceTable = new TreeMap<Double, Distance>() {
		{
			put((double) 0, Distance.ZERO);
			put((double) 10, Distance.NEAR);
			put((double) 30, Distance.MEDIUM);
			put((double) 100, Distance.FAR);
		}
	};

	private ArrayList<ArrayList<Double>> priceTable = new ArrayList<ArrayList<Double>>(Arrays.asList(
			// distance = column 16 medium
			// weight = row 12  light
			new ArrayList<Double>(Arrays.asList((double) 0, (double)  0, (double)  0, (double)   0,(double)   0,(double)   0)),
			new ArrayList<Double>(Arrays.asList((double) 0, (double)  3, (double)  4, (double)   6,(double)  12,(double)  25)),
			new ArrayList<Double>(Arrays.asList((double) 0, (double)  3, (double)  5, (double)   8,(double)  18,(double)  30)),
			new ArrayList<Double>(Arrays.asList((double) 0, (double)  3, (double)  6, (double)  10,(double)  25,(double)  35))));

	

	@Override
	public double calCharge(TreeMap<Double, Weight> weight, TreeMap<Double, Distance> distance, double weightVal,double distanceVal) {
		Integer row = 0; 
		Integer col = 0;
		try {
			row = weight.higherEntry(weightVal).getValue().ordinal();
			col = distance.higherEntry(distanceVal).getValue().ordinal();
		}catch(Exception e) {
			System.out.println("ERROR");
			e.getMessage();
		}
		

		return priceTable.get(col).get(row);
	}
	
	@Override
	public double calCharge(double weightVal, double distanceVal) {
		return calCharge(weightTable, distanceTable, weightVal, distanceVal);
	}

}

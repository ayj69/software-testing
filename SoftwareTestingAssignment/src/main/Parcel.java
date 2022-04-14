import java.util.*;

enum Weight {
	ZERO, LIGHT, MEDIUM, HEAVY, TOOHEAVY, IMPOSSIBLE
};

enum Distance {
	ZERO, NEAR, MEDIUM, FAR
};

public class Parcel extends Item {

	private double basicCharge;
	
	
	Parcel(String name, double weight) {
		super(name, weight,"P");
	}
	
	
	@SuppressWarnings("serial")
	private TreeMap<Double, Weight> weightTable = new TreeMap<Double, Weight>() {
		{
			put((double) 0, Weight.ZERO);
			put((double) 1000, Weight.LIGHT);
			put((double) 2000, Weight.MEDIUM);
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
			// distance = col
			// weight = row
			new ArrayList<Double>(Arrays.asList((double) 0, (double)   0, (double)   0, (double)    0,(double)   0,(double)   0)),
			new ArrayList<Double>(Arrays.asList((double) 0, (double)   5, (double)  15, (double)   23,(double)  35,(double)  45)),
			new ArrayList<Double>(Arrays.asList((double) 0, (double)   8, (double)  18, (double)   28,(double)  40,(double)  50)),
			new ArrayList<Double>(Arrays.asList((double) 0, (double)  10, (double)  25, (double)   35,(double)  50,(double)  60))));
	
	@Override
	public double calCharge(TreeMap<Double, Weight> weight, TreeMap<Double, Distance> distance, double weightVal,double distanceVal) {
		int row = weight.higherEntry(weightVal).getValue().ordinal();
		int col = distance.higherEntry(distanceVal).getValue().ordinal();
		return priceTable.get(col).get(row);
	}
	
	@Override
	public double calCharge(double weightVal, double distanceVal) {
		if(weightVal <0 || distanceVal<0)
			throw new IllegalArgumentException("cant be nagative");
		return calCharge(weightTable, distanceTable, weightVal, distanceVal);
	}



}


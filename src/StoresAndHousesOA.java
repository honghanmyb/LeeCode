import java.util.TreeSet;

public class StoresAndHousesOA {
	public int[] findStores(int[] houses, int[] stores) {
		if(stores.length == 0 || houses.length == 0) {
			return new int[] {};
		}
		TreeSet<Integer> set = new TreeSet<>();
		for(int store: stores) {
			set.add(store);
		}
		int[] nearestStore = new int[houses.length];
		for(int i = 0; i < houses.length; i++) {
			Integer ceiling = set.ceiling(houses[i]);
			Integer floor = set.floor(houses[i]);
			if(ceiling == null) {
				nearestStore[i] = floor;
				continue;
			}
			if(floor == null) {
				nearestStore[i] = ceiling;
				continue;
			}
			if(ceiling == houses[i]) {
				nearestStore[i] = ceiling;
				continue;
			}
			nearestStore[i] = Math.abs(floor - houses[i]) > Math.abs(ceiling - houses[i]) ? ceiling: floor;
		}
		return nearestStore;
	}
}

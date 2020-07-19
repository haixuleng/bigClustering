package package1;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Clustering {
	public static void main(String args[]) throws FileNotFoundException {
		LoadText lt = new LoadText("data/clustering_big.txt");
		//LoadText lt = new LoadText("data/input_random_79_65536_24.txt");
		ArrayList<String> data = lt.get();
		System.out.println("# of total nodes: " + lt.numOfVer);
		System.out.println("# of unique nodes: " + data.size());
		KClusterByBits test = new KClusterByBits(lt.bits, data);
		test.merge();
	}
}

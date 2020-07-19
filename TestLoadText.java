package package1;

import java.io.FileNotFoundException;
import java.util.ArrayList;
//import java.util.HashSet;

public class TestLoadText {
	public static void main(String args[]) throws FileNotFoundException {
		LoadText lt = new LoadText("data/clustering_big.txt");
		ArrayList<String> data = lt.get();
		System.out.println("# of total nodes: " + lt.numOfVer);
		System.out.println("# of unique nodes: " + data.size());
		for(String i : data) {
			System.out.println(i);
		}
	}
}

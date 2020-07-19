package package1;

import java.util.ArrayList;
import java.util.HashSet;

public class KClusterByBits {
	int bits;
	int maxDifBits;
	ArrayList<String> data;
	Clusters clusters;
	public KClusterByBits(int bits, ArrayList<String> data) {
		this.maxDifBits = 2;
		this.bits = bits;
		this.data = data; // use array list for operations
		this.clusters = new Clusters(this.data.size());
	}
	
	public void merge() {
		// start the merge the string in data
		//boolean flag = true;
		for(int index = 0; index < data.size(); index++) {
			String firstString = this.data.get(index);
			
			for(int i = 0; i < this.data.size(); i++) {
				if(index == i) {
					continue;
				}
				if(checkDiff(firstString, this.data.get(i)) && this.clusters.find(i + 1) != this.clusters.find(index + 1)) {
					System.out.println(index + 1 + "'s root:" + this.clusters.find(index + 1));
					System.out.println(i + 1 + "'s root:" + this.clusters.find(i + 1));
					this.clusters.merge(index + 1, i + 1);
					System.out.println("Merge of " + (i + 1) + " and " + (index + 1));
					System.out.println(index + 1 + "'s root:" + this.clusters.find(index + 1));
					System.out.println(i + 1 + "'s root:" + this.clusters.find(i + 1));
					//System.out.println(this.data.get(index));
					//System.out.println(this.data.get(i));
					System.out.println(this.clusters.size);
				}
			}
			//flag = false;
		}
	}
	
	public boolean checkDiff(String a, String b) {
		int diffBits = 0;
		for(int i = 0; i < this.bits; i++) {
			if(a.charAt(i) != b.charAt(i)) {
				diffBits++;
			}
			if(diffBits > this.maxDifBits) {
				return false;
			}
		}
		return true;
	}
}

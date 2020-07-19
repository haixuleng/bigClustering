package package1;

import java.util.ArrayList;

public class Clusters {
	long size; // size of the clusters
	ArrayList<Node> nodes; // nodes map to its root, first integer is the index, the second one is it's root
	public Clusters(int s) {
		this.size = s; // initialize the size of clusters
		System.out.println(s);
		this.nodes = new ArrayList<Node>();
		for(int i = 1; i <= s; i++) {
			this.nodes.add(new Node(i, 0));
		}
	}
	
	public void merge(int i, int j) {
		// merge two nodes into one cluster
		int root_i = find(i);
		int root_j = find(j);
		int rank_i = this.nodes.get(root_i -1).rank;
		int rank_j = this.nodes.get(root_j -1).rank; 
		if (root_i != root_j) {
			if(rank_i > rank_j) {
				this.nodes.set(root_j - 1, new Node(root_i, rank_j));
			}
			else if(rank_i < rank_j) {
				this.nodes.set(root_i - 1, new Node(root_j, rank_i));
			}
			else {
				this.nodes.set(root_j - 1, new Node(root_i, rank_j)); // set j's root as i's root
				this.nodes.set(root_i - 1, new Node(root_i, rank_i + 1)); // update i's root's rank
			}
			this.size --;
		}
	}
	
	public int find(int i) {
		// find the root of node i
		Node node_i = this.nodes.get(i - 1);
		int root_i = node_i.root;
		// System.out.println("Node: " + i + ", root: " + root_i);
		if(i != root_i) {
			//this.nodes.set(i - 1, new Node(i, find(root_i)));
			// path compression is not yet implemented
			return find(root_i);
		}
		else {
			return i;
		}
	}
	
	public long size() {
		return this.size;
	}
	
}

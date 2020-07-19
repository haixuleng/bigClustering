package package1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.HashSet;
import java.util.Scanner;

public class LoadText {
	String fileToLoad;
	int length = 0;
	int numOfVer; // First line of the file stores the number of vertexes from the test file
	int bits;
	public LoadText(String fileName) throws FileNotFoundException {
		fileToLoad = fileName;
		System.out.println(fileName);
		size();
	}

	public void size() throws FileNotFoundException {
		int size = 0;
		File myObj = new File(fileToLoad);
		Scanner myReader = new Scanner(myObj);
		while(myReader.hasNextLine()) {
			size ++;
			myReader.nextLine();
			//System.out.println("Length of Input: " + size);
		}
		//myReader.close();
		length = size;
		System.out.println("Length of Input: " + size);
	}

	public ArrayList<String> get() throws FileNotFoundException {
		ArrayList<String> initData = new ArrayList<String>(length - 1);
		//System.out.println(length);
		File myObj = new File(fileToLoad);
		Scanner myReader = new Scanner(myObj);
		//int numOfVer = 0;
		while(myReader.hasNextLine()) {
			String[] data = myReader.nextLine().split("\\s");
			if(data.length < 3) {
				this.numOfVer = Integer.parseInt(data[0]);
				this.bits = Integer.parseInt(data[1]);
				continue; // starting line
			}
			StringBuffer sb = new StringBuffer();
			for(int i = 0; i < data.length; i++) {
		         sb.append(data[i]);
		      }
			String s = sb.toString();
			//System.out.println(s);
			initData.add(s);
		}
		myReader.close();
		return initData;
	}
}
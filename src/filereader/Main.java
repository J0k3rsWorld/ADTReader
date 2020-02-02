package filereader;

import java.util.ArrayList;
import java.util.List;

import filereader.files.ADT335;
import filereader.readers.AdtReader;


public class Main {
	public static void main(String args[]) {
		List<String> adtNames = new ArrayList<String>();
		List<ADT335> adts = new ArrayList<ADT335>();
		
		String path2Folder = "C:\\Users\\denni\\Documents\\WoWFiles\\extracted\\World\\Maps\\Azeroth\\";

		boolean readOneSpecADT = false;
		
		if(readOneSpecADT) {
			AdtReader.readOneAdt("C:\\Users\\denni\\Documents\\Azeroth_33_48.adt");			
		}else {
			AdtReader.readAllAdtsInFolder(path2Folder, adtNames, adts);			
		}
	}
}

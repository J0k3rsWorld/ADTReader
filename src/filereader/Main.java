package filereader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import filereader.files.ADT335;
import filereader.files.WDT335;
import filereader.readers.AdtReader;
import filereader.readers.WDTReader;


public class Main {

	/*
	 * ADT335 reading main
	 */
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
	
	/*
	 * WDT335 reading main
	 */
//	public static void main(String args[]) {
//		try {
//		
//			String wmoPath = "C:\\Users\\denni\\Documents\\WoWFiles\\Work\\World\\wmo\\Kalimdor\\Buildings\\NightElfSmallHouse\\NightElfSmallHomjo.wmo";
			
//			WDT335 wdt = WDTReader.createWDT("C:\\Users\\denni\\Documents\\WoWFiles\\extracted\\World\\Maps\\Azeroth\\Azeroth.wdt");
//			WDT335 adt = WDTReader.createWDT("C:\\Users\\denni\\Documents\\WoWFiles\\extracted\\World\\Maps\\Azeroth\\Azeroth_24_53.adt");
//			WDT335 wmo = WDTReader.createWDT(wmoPath);
//			WDT335 wdl = WDTReader.createWDT("C:\\Users\\denni\\Documents\\WoWFiles\\extracted\\World\\Maps\\Azeroth\\Azeroth.wdl");

			
//			WDTReader.printMagicsFromInt(wdt);
//			WDTReader.printMagicsFromInt(adt);
//			WDTReader.printMagicsFromInt(wmo);
//			WDTReader.printMagicsFromInt(wdl);
			
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
}

package filereader.readers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import filereader.files.ADT335;
import filereader.files.chunks.MCIN;
import filereader.files.chunks.MCLY;
import filereader.files.chunks.MCNK;
import filereader.files.chunks.MCNKheader;
import filereader.files.chunks.MCNR;
import filereader.files.chunks.MCVT;
import filereader.files.chunks.MDDF;
import filereader.files.chunks.MH2O;
import filereader.files.chunks.MHDR;
import filereader.files.chunks.MMDX;
import filereader.files.chunks.MMID;
import filereader.files.chunks.MODF;
import filereader.files.chunks.MTEX;
import filereader.files.chunks.MWID;
import filereader.files.chunks.MWMO;
import filereader.files.util.MCINEntry;
import filereader.files.util.MCLYEntry;
import filereader.files.util.MCNKEntry;
import filereader.files.util.MDDFEntry;
import filereader.files.util.MODFEntry;
import filereader.readers.util.ReaderUtil;

public class AdtReader {
	/*
	 * Taking a ByteBuffer and reading in the adt file. Starting with extracted
	 * adts. The goal is to load single adts and render them in a viewport with
	 * camera movement.
	 * 
	 * First start will be the terrain/wireframe. If the terrain is correctly
	 * rendered, it shall be textured
	 * 
	 * 
	 * reading structure:
	 * 
	 * load adt into ByteBuffer create an object of type adt fill the chunks which
	 * are essential to rendering the terrain. which chunks?
	 */

	public static ADT335 createAdt(String filename) throws IOException {
		ADT335 adt = new ADT335();

		ByteBuffer dataBuff = ReaderUtil.createByteBuffer(Files.readAllBytes(Paths.get(filename)));

		adt.setMver(readMVER(dataBuff));
		adt.setMhdr(readMHDR(dataBuff));
		adt.setMcin(readMCIN(dataBuff, adt.getMhdr()));
		adt.setMtex(readMTEX(dataBuff, adt.getMhdr()));
		adt.setMmdx(readMMDX(dataBuff, adt.getMhdr()));
		adt.setMmid(readMMID(dataBuff, adt.getMhdr()));
		adt.setMwmo(readMWMO(dataBuff, adt.getMhdr()));
		adt.setMwid(readMWID(dataBuff, adt.getMhdr()));
		adt.setMddf(readMDDF(dataBuff, adt.getMhdr()));
		adt.setModf(readMODF(dataBuff, adt.getMhdr()));
		adt.setMh2o(readMH2O(dataBuff, adt.getMhdr())); // TODO
		adt.setMcnk(readMCNK(dataBuff, adt.getMcin()));

		return adt;
	}

	public static int readMVER(ByteBuffer dataBuff) {
		return ReaderUtil.readInt4Bytes(dataBuff, 8);
	}

	public static MHDR readMHDR(ByteBuffer dataBuff) {
		MHDR mhdr = new MHDR();

		mhdr.setFlags(ReaderUtil.readInt4Bytes(dataBuff, 0x14));
		mhdr.setOfsMCIN(ReaderUtil.readInt4Bytes(dataBuff, 0x18));
		mhdr.setOfsMTEX(ReaderUtil.readInt4Bytes(dataBuff, 0x1C));
		mhdr.setOfsMMDX(ReaderUtil.readInt4Bytes(dataBuff, 0x20));
		mhdr.setOfsMMID(ReaderUtil.readInt4Bytes(dataBuff, 0x24));
		mhdr.setOfsMWMO(ReaderUtil.readInt4Bytes(dataBuff, 0x28));
		mhdr.setOfsMWID(ReaderUtil.readInt4Bytes(dataBuff, 0x2C));
		mhdr.setOfsMDDF(ReaderUtil.readInt4Bytes(dataBuff, 0x30));
		mhdr.setOfsMODF(ReaderUtil.readInt4Bytes(dataBuff, 0x34));
		mhdr.setOfsMFBO(ReaderUtil.readInt4Bytes(dataBuff, 0x38));
		mhdr.setOfsMH2O(ReaderUtil.readInt4Bytes(dataBuff, 0x3C));
		mhdr.setOfsMTXF(ReaderUtil.readInt4Bytes(dataBuff, 0x40));
		mhdr.setUnk1(ReaderUtil.readInt4Bytes(dataBuff, 0x44));
		mhdr.setUnk2(ReaderUtil.readInt4Bytes(dataBuff, 0x48));
		mhdr.setUnk3(ReaderUtil.readInt4Bytes(dataBuff, 0x4C));
		mhdr.setUnk4(ReaderUtil.readInt4Bytes(dataBuff, 0x50));

		return mhdr;
	}

	public static MCIN readMCIN(ByteBuffer dataBuff, MHDR mhdr) {
		MCIN mcin = new MCIN();
		MCINEntry entry;
		int counter = 0;
		int mcinDataStart = 0x14 + mhdr.getOfsMCIN() + 8;

		for (int i = 0; i < 256; i++) {
			entry = new MCINEntry();

			entry.setAddress(ReaderUtil.readInt4Bytes(dataBuff, mcinDataStart + counter));
			entry.setSize(ReaderUtil.readInt4Bytes(dataBuff, mcinDataStart + 4 + counter));
			entry.setFlags(ReaderUtil.readInt4Bytes(dataBuff, mcinDataStart + 8 + counter));
			entry.setAsyncID(ReaderUtil.readInt4Bytes(dataBuff, mcinDataStart + 12 + counter));

			mcin.getEntries().add(entry);

			counter += 16;
		}
		return mcin;
	}

	public static MTEX readMTEX(ByteBuffer dataBuff, MHDR mhdr) {
		MTEX mtex = new MTEX();
		int mtexDataStart = 0x14 + mhdr.getOfsMTEX() + 8;
		int mtexSize = ReaderUtil.readInt4Bytes(dataBuff, mtexDataStart - 4);

		mtex.setFilenames(ReaderUtil.readStringChunk(dataBuff, mtexDataStart, mtexSize));

		return mtex;
	}

	public static MMDX readMMDX(ByteBuffer dataBuff, MHDR mhdr) {
		MMDX mmdx = new MMDX();
		int mmdxDataStart = 0x14 + mhdr.getOfsMMDX() + 8;
		int mmdxSize = ReaderUtil.readInt4Bytes(dataBuff, mmdxDataStart - 4);

		mmdx.setFilenames(ReaderUtil.readStringChunk(dataBuff, mmdxDataStart, mmdxSize));

		return mmdx;
	}

	public static MMID readMMID(ByteBuffer dataBuff, MHDR mhdr) {
		MMID mmid = new MMID();
		int mmidDataStart = 0x14 + mhdr.getOfsMMID() + 8;
		int mmidSize = ReaderUtil.readInt4Bytes(dataBuff, mmidDataStart - 4);

		for (int i = 0; i < mmidSize; i += 4) {
			mmid.getEntries().add(ReaderUtil.readInt4Bytes(dataBuff, i + mmidDataStart));
		}

		return mmid;
	}

	public static MWMO readMWMO(ByteBuffer dataBuff, MHDR mhdr) {
		MWMO mwmo = new MWMO();
		int mwmoDataStart = 0x14 + mhdr.getOfsMWMO() + 8;
		int mwmoSize = ReaderUtil.readInt4Bytes(dataBuff, mwmoDataStart - 4);

		mwmo.setFilenames(ReaderUtil.readStringChunk(dataBuff, mwmoDataStart, mwmoSize));

		return mwmo;
	}

	public static MWID readMWID(ByteBuffer dataBuff, MHDR mhdr) {
		MWID mwid = new MWID();
		int mwidDataStart = 0x14 + mhdr.getOfsMWID() + 8;
		int mwidSize = ReaderUtil.readInt4Bytes(dataBuff, mwidDataStart - 4);

		for (int i = 0; i < mwidSize; i += 4) {
			mwid.getEntries().add(ReaderUtil.readInt4Bytes(dataBuff, i + mwidDataStart));
		}

		return mwid;
	}

	public static MDDF readMDDF(ByteBuffer dataBuff, MHDR mhdr) {
		MDDF mddf = new MDDF();
		int mddfDataStart = 0x14 + mhdr.getOfsMDDF() + 8;
		int mddfSize = ReaderUtil.readInt4Bytes(dataBuff, mddfDataStart - 4);

		MDDFEntry mddfEntry;

		for (int i = 0; i < mddfSize; i += 0x24) {
			mddfEntry = new MDDFEntry();

			int offset = i;

			mddfEntry.setNameID(ReaderUtil.readInt4Bytes(dataBuff, mddfDataStart + offset));
			offset += 4;
			mddfEntry.setUniqueId(ReaderUtil.readInt4Bytes(dataBuff, mddfDataStart + offset));
			offset += 4;
			mddfEntry.setPosition(ReaderUtil.createVector3f(dataBuff, mddfDataStart + offset));
			offset += 12;
			mddfEntry.setRotation(ReaderUtil.createVector3f(dataBuff, mddfDataStart + offset));
			offset += 12;
			mddfEntry.setScale(ReaderUtil.readInt2Bytes(dataBuff, mddfDataStart + offset));
			offset += 2;
			mddfEntry.setFlags(ReaderUtil.readInt2Bytes(dataBuff, mddfDataStart + offset));
			offset += 2;

			mddf.getEntries().add(mddfEntry);
		}

		return mddf;
	}

	public static MODF readMODF(ByteBuffer dataBuff, MHDR mhdr) {
		MODF modf = new MODF();
		int modfDataStart = 0x14 + mhdr.getOfsMODF() + 8;
		int modfSize = ReaderUtil.readInt4Bytes(dataBuff, modfDataStart - 4);

		MODFEntry modfEntry;

		for (int i = 0; i < modfSize; i += 0x40) {
			modfEntry = new MODFEntry();

			int offset = i;

			modfEntry.setMwidEntry(ReaderUtil.readInt4Bytes(dataBuff, modfDataStart + offset));
			offset += 4;
			modfEntry.setUniqueId(ReaderUtil.readInt4Bytes(dataBuff, modfDataStart + offset));
			offset += 4;
			modfEntry.setPosition(ReaderUtil.createVector3f(dataBuff, modfDataStart + offset));
			offset += 12;
			modfEntry.setRotation(ReaderUtil.createVector3f(dataBuff, modfDataStart + offset));
			offset += 12;
			modfEntry.setLowerBounds(ReaderUtil.createVector3f(dataBuff, modfDataStart + offset));
			offset += 12;
			modfEntry.setUpperBounds(ReaderUtil.createVector3f(dataBuff, modfDataStart + offset));
			offset += 12;
			modfEntry.setDoodadSet(ReaderUtil.readInt4Bytes(dataBuff, modfDataStart + offset));

			modf.getEntries().add(modfEntry);
		}
		return modf;
	}

	public static MH2O readMH2O(ByteBuffer dataBuff, MHDR mhdr) {
		/*
		 * BIG TODO
		 */
		return null;
	}

	public static MCNK readMCNK(ByteBuffer dataBuff, MCIN mcin) {
		/* MCNK */

		MCNK mcnk = new MCNK();

		for (MCINEntry mcnkEntry : mcin.getEntries()) {
			mcnk.entries.add(readMCNKEntry(dataBuff, mcnkEntry));
		}
		return mcnk;
	}

	public static MCNKEntry readMCNKEntry(ByteBuffer dataBuff, MCINEntry mcnkEntry/* , int offset */) {
		MCNKEntry cnk = new MCNKEntry();

		cnk.setHeader(readMCNKHeader(dataBuff, mcnkEntry));
		cnk.setMcvt(readMCVT(dataBuff, mcnkEntry, cnk.getHeader()));
		cnk.setMcnr(readMCNR(dataBuff, mcnkEntry, cnk.getHeader()));
		cnk.setMcly(readMCLY(dataBuff, mcnkEntry, cnk.getHeader()));

		/*
		 * TODO more will be done in the future aswell as a refactor of the code written
		 * until now. Now it is needed to make sure every MCNK (subchunk) is read.
		 * 
		 */

		return cnk;
	}

	private static MCLY readMCLY(ByteBuffer dataBuff, MCINEntry mcnkEntry, MCNKheader header) {
		MCLY mcly = new MCLY();
		int mclyDataStart = mcnkEntry.getAddress() + header.getOfsMCLY() + 8;
		int mclySize = ReaderUtil.readInt4Bytes(dataBuff, mclyDataStart - 4);

		MCLYEntry mclyEntry;

		for (int i = 0; i < mclySize; i += 0x10) {
			mclyEntry = new MCLYEntry();

			int offset = i;

			mclyEntry.setTextureId(ReaderUtil.readInt4Bytes(dataBuff, mclyDataStart + offset + 0));
			mclyEntry.setFlags(ReaderUtil.readInt4Bytes(dataBuff, mclyDataStart + offset + 4));
			mclyEntry.setOfsAlphaMap(ReaderUtil.readInt4Bytes(dataBuff, mclyDataStart + offset + 8));
			mclyEntry.setDetailTextureID(ReaderUtil.readInt4Bytes(dataBuff, mclyDataStart + offset + 12));

			mcly.getEntries().add(mclyEntry);
		}

		return mcly;
	}

	private static MCNR readMCNR(ByteBuffer dataBuff, MCINEntry mcnkEntry, MCNKheader header) {
		MCNR mcnr = new MCNR();
		dataBuff.position(mcnkEntry.getAddress() + header.getOfsMCNR() + 8);
		byte b;
		for (int i = 0; i < 145; i++) {

			b = dataBuff.get();
			(mcnr.getNormal_0())[i] = b & 0xFF;
			b = dataBuff.get();
			(mcnr.getNormal_1())[i] = b & 0xFF;
			b = dataBuff.get();
			(mcnr.getNormal_2())[i] = b & 0xFF;
		}
		return mcnr;
	}

	private static MCVT readMCVT(ByteBuffer dataBuff, MCINEntry mcnkEntry, MCNKheader header) {
		MCVT mcvt = new MCVT();
		int counterVert = 0;
		for (int i = 0; i < 145; i++) {
			mcvt.getVertices().add(ReaderUtil.readFloat4Bytes(dataBuff,
					mcnkEntry.getAddress() + header.getOfsMCVT() + 8 + counterVert));
			counterVert += 4;
		}
		return mcvt;
	}

	public static MCNKheader readMCNKHeader(ByteBuffer dataBuff, MCINEntry mcnkEntry) {
		MCNKheader mcnkHeader = new MCNKheader();

		int mcnkEntryDataStart = mcnkEntry.getAddress();

		mcnkHeader.setFlags(ReaderUtil.readInt4Bytes(dataBuff, mcnkEntryDataStart + 8));
		mcnkHeader.setIndexX(ReaderUtil.readInt4Bytes(dataBuff, mcnkEntryDataStart + 12));
		mcnkHeader.setIndexY(ReaderUtil.readInt4Bytes(dataBuff, mcnkEntryDataStart + 16));
		mcnkHeader.setnLayers(ReaderUtil.readInt4Bytes(dataBuff, mcnkEntryDataStart + 20));
		mcnkHeader.setnDoodadRefs(ReaderUtil.readInt4Bytes(dataBuff, mcnkEntryDataStart + 24));
		mcnkHeader.setOfsMCVT(ReaderUtil.readInt4Bytes(dataBuff, mcnkEntryDataStart + 28));
		mcnkHeader.setOfsMCNR(ReaderUtil.readInt4Bytes(dataBuff, mcnkEntryDataStart + 32));
		mcnkHeader.setOfsMCLY(ReaderUtil.readInt4Bytes(dataBuff, mcnkEntryDataStart + 36));
		mcnkHeader.setOfsMCRF(ReaderUtil.readInt4Bytes(dataBuff, mcnkEntryDataStart + 40));
		mcnkHeader.setOfsMCAL(ReaderUtil.readInt4Bytes(dataBuff, mcnkEntryDataStart + 44));
		mcnkHeader.setSizeAlpha(ReaderUtil.readInt4Bytes(dataBuff, mcnkEntryDataStart + 48));
		mcnkHeader.setOfsMCSH(ReaderUtil.readInt4Bytes(dataBuff, mcnkEntryDataStart + 52));
		mcnkHeader.setSizeShadows(ReaderUtil.readInt4Bytes(dataBuff, mcnkEntryDataStart + 56));
		mcnkHeader.setAreaID(ReaderUtil.readInt4Bytes(dataBuff, mcnkEntryDataStart + 60));
		mcnkHeader.setnMapObjRefs(ReaderUtil.readInt4Bytes(dataBuff, mcnkEntryDataStart + 64));
		mcnkHeader.setHoles(ReaderUtil.readInt4Bytes(dataBuff, mcnkEntryDataStart + 68));
		mcnkHeader.setUnk1(ReaderUtil.readInt4Bytes(dataBuff, mcnkEntryDataStart + 72));
		mcnkHeader.setUnk2(ReaderUtil.readInt4Bytes(dataBuff, mcnkEntryDataStart + 76));
		mcnkHeader.setUnk3(ReaderUtil.readInt4Bytes(dataBuff, mcnkEntryDataStart + 80));
		mcnkHeader.setUnk4(ReaderUtil.readInt4Bytes(dataBuff, mcnkEntryDataStart + 84));
		mcnkHeader.setPredTex(ReaderUtil.readInt4Bytes(dataBuff, mcnkEntryDataStart + 88));
		mcnkHeader.setNoEffectDoodad(ReaderUtil.readInt4Bytes(dataBuff, mcnkEntryDataStart + 92));
		mcnkHeader.setOfsMCSE(ReaderUtil.readInt4Bytes(dataBuff, mcnkEntryDataStart + 96));
		mcnkHeader.setnSndEmiters(ReaderUtil.readInt4Bytes(dataBuff, mcnkEntryDataStart + 100));
		mcnkHeader.setOfsMCLQ(ReaderUtil.readInt4Bytes(dataBuff, mcnkEntryDataStart + 104));
		mcnkHeader.setSizeLiquid(ReaderUtil.readInt4Bytes(dataBuff, mcnkEntryDataStart + 108));
		mcnkHeader.setPosition(ReaderUtil.createVector3f(dataBuff, mcnkEntryDataStart + 112));
		mcnkHeader.setOfsMCCV(ReaderUtil.readInt4Bytes(dataBuff, mcnkEntryDataStart + 124));
		mcnkHeader.setProps(ReaderUtil.readInt4Bytes(dataBuff, mcnkEntryDataStart + 128));
		mcnkHeader.setEffectId(ReaderUtil.readInt4Bytes(dataBuff, mcnkEntryDataStart + 132));
		return mcnkHeader;
	}

	public static ADT335 readOneAdt(String filePath) {
		try {
			long start = System.currentTimeMillis();
			
			ADT335 adt = AdtReader.createAdt(filePath);
			
			long end = System.currentTimeMillis();
			System.out.println("Single ADT read in " + (end - start) + " ms");
			return adt;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void readAllAdtsInFolder(String path2Folder, List<String> adtNames, List<ADT335> adts) {

		listFilesForFolder(new File(path2Folder), adtNames);

		long start = System.currentTimeMillis();

		for (String str : adtNames) {
			try {
				adts.add(AdtReader.createAdt(path2Folder + str));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		long end = System.currentTimeMillis();
		System.out.println("Many ADTs read in " + (end - start) + " ms");
	}

	public static void listFilesForFolder(File folder, List<String> adtNames) {
		for (final File fileEntry : folder.listFiles()) {
			if (fileEntry.isDirectory()) {
				listFilesForFolder(fileEntry, adtNames);
			} else {
				if (fileEntry.getName().contains(".adt")) {
					adtNames.add(fileEntry.getName());
				}
			}
		}
	}
}

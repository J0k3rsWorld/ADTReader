package filereader.readers;

import java.io.File;
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
import filereader.files.chunks.MVER;
import filereader.files.chunks.MWID;
import filereader.files.chunks.MWMO;
import filereader.files.util.MCINEntry;
import filereader.files.util.MCLYEntry;
import filereader.files.util.MCNKEntry;
import filereader.files.util.MDDFEntry;
import filereader.files.util.MH2OAttribute;
import filereader.files.util.MH2OHeaderEntry;
import filereader.files.util.MH2OInstance;
import filereader.files.util.MH2OVertexData;
import filereader.files.util.MODFEntry;
import filereader.readers.util.ReaderUtil;
import filereader.util.maths.Vector3f;

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
//		adt.setMh2o(readMH2O(dataBuff, adt.getMhdr())); // TODO
		adt.setMcnk(readMCNK(dataBuff, adt.getMcin()));

		return adt;
	}

	public static MVER readMVER(ByteBuffer dataBuff) {
		return new MVER(dataBuff.getInt(), dataBuff.getInt(), dataBuff.position(), dataBuff.getInt());
	}

	public static MHDR readMHDR(ByteBuffer dataBuff) {
		MHDR mhdr = new MHDR(dataBuff.getInt(), dataBuff.getInt(), dataBuff.position());

		mhdr.setFlags(dataBuff.getInt());
		mhdr.setOfsMCIN(dataBuff.getInt());
		mhdr.setOfsMTEX(dataBuff.getInt());
		mhdr.setOfsMMDX(dataBuff.getInt());
		mhdr.setOfsMMID(dataBuff.getInt());
		mhdr.setOfsMWMO(dataBuff.getInt());
		mhdr.setOfsMWID(dataBuff.getInt());
		mhdr.setOfsMDDF(dataBuff.getInt());
		mhdr.setOfsMODF(dataBuff.getInt());
		mhdr.setOfsMFBO(dataBuff.getInt());
		mhdr.setOfsMH2O(dataBuff.getInt());
		mhdr.setOfsMTXF(dataBuff.getInt());
		mhdr.setUnk1(dataBuff.getInt());
		mhdr.setUnk2(dataBuff.getInt());
		mhdr.setUnk3(dataBuff.getInt());
		mhdr.setUnk4(dataBuff.getInt());

		return mhdr;
	}

	public static MCIN readMCIN(ByteBuffer dataBuff, MHDR cnk) {
		dataBuff.position(cnk.getPosition() + cnk.getOfsMCIN());
		MCIN mcin = new MCIN(dataBuff.getInt(), dataBuff.getInt(), dataBuff.position());
		MCINEntry entry;

		for (int i = 0; i < 256; i++) {
			entry = new MCINEntry();

			entry.setAddress(dataBuff.getInt());
			entry.setSize(dataBuff.getInt());
			entry.setFlags(dataBuff.getInt());
			entry.setAsyncID(dataBuff.getInt());

			mcin.getEntries().add(entry);
		}
		return mcin;
	}

	public static MTEX readMTEX(ByteBuffer dataBuff, MHDR mhdr) {
		dataBuff.position(mhdr.getPosition() + mhdr.getOfsMTEX());
		MTEX mtex = new MTEX(dataBuff.getInt(), dataBuff.getInt(), dataBuff.position());

		mtex.setFilenames(ReaderUtil.readStringChunk(dataBuff, mtex));

		return mtex;
	}

	public static MMDX readMMDX(ByteBuffer dataBuff, MHDR mhdr) {
		dataBuff.position(mhdr.getPosition() + mhdr.getOfsMMDX());
		MMDX mmdx = new MMDX(dataBuff.getInt(), dataBuff.getInt(), dataBuff.position());

		mmdx.setFilenames(ReaderUtil.readStringChunk(dataBuff, mmdx));

		return mmdx;
	}

	public static MMID readMMID(ByteBuffer dataBuff, MHDR mhdr) {
		dataBuff.position(mhdr.getPosition() + mhdr.getOfsMMID());
		MMID mmid = new MMID(dataBuff.getInt(), dataBuff.getInt(), dataBuff.position());

		for (int i = 0; i < mmid.getSize(); i += 4) {
			mmid.getEntries().add(dataBuff.getInt());
		}

		return mmid;
	}

	public static MWMO readMWMO(ByteBuffer dataBuff, MHDR mhdr) {
		dataBuff.position(mhdr.getPosition() + mhdr.getOfsMWMO());
		MWMO mwmo = new MWMO(dataBuff.getInt(), dataBuff.getInt(), dataBuff.position());

		mwmo.setFilenames(ReaderUtil.readStringChunk(dataBuff, mwmo));

		return mwmo;
	}

	public static MWID readMWID(ByteBuffer dataBuff, MHDR mhdr) {
		dataBuff.position(mhdr.getPosition() + mhdr.getOfsMWID());
		MWID mwid = new MWID(dataBuff.getInt(), dataBuff.getInt(), dataBuff.position());

		for (int i = 0; i < mwid.getSize(); i += 4) {
			mwid.getEntries().add(dataBuff.getInt());
		}

		return mwid;
	}

	public static MDDF readMDDF(ByteBuffer dataBuff, MHDR mhdr) {
		dataBuff.position(mhdr.getPosition() + mhdr.getOfsMDDF());
		MDDF mddf = new MDDF(dataBuff.getInt(), dataBuff.getInt(), dataBuff.position());

		MDDFEntry mddfEntry;

		for (int i = 0; i < mddf.getSize(); i += 0x24) {
			mddfEntry = new MDDFEntry();

			mddfEntry.setNameID(dataBuff.getInt());
			mddfEntry.setUniqueId(dataBuff.getInt());
			mddfEntry.setPosition(new Vector3f(dataBuff.getFloat(), dataBuff.getFloat(), dataBuff.getFloat()));
			mddfEntry.setRotation(new Vector3f(dataBuff.getFloat(), dataBuff.getFloat(), dataBuff.getFloat()));
			mddfEntry.setScale(dataBuff.getInt());
			mddfEntry.setFlags(dataBuff.getInt());

			mddf.getEntries().add(mddfEntry);
		}

		return mddf;
	}

	public static MODF readMODF(ByteBuffer dataBuff, MHDR mhdr) {
		dataBuff.position(mhdr.getPosition() + mhdr.getOfsMODF());
		MODF modf = new MODF(dataBuff.getInt(), dataBuff.getInt(), dataBuff.position());

		MODFEntry modfEntry;

		for (int i = 0; i < modf.getSize(); i += 0x40) {
			modfEntry = new MODFEntry();

			modfEntry.setMwidEntry(dataBuff.getInt());
			modfEntry.setUniqueId(dataBuff.getInt());
			modfEntry.setPosition(new Vector3f(dataBuff.getFloat(), dataBuff.getFloat(), dataBuff.getFloat()));
			modfEntry.setRotation(new Vector3f(dataBuff.getFloat(), dataBuff.getFloat(), dataBuff.getFloat()));
			modfEntry.setLowerBounds(new Vector3f(dataBuff.getFloat(), dataBuff.getFloat(), dataBuff.getFloat()));
			modfEntry.setUpperBounds(new Vector3f(dataBuff.getFloat(), dataBuff.getFloat(), dataBuff.getFloat()));
			modfEntry.setDoodadSet(dataBuff.getInt());

			dataBuff.getInt(); // used to set the position, after the doodadset are 4 unknown or unsused bytes

			modf.getEntries().add(modfEntry);
		}
		return modf;
	}

	public static MH2O readMH2O(ByteBuffer dataBuff, MHDR mhdr) {
		/*
		 * BIG TODO
		 */

		dataBuff.position(mhdr.getPosition() + mhdr.getOfsMH2O());
		MH2O mh20 = new MH2O(dataBuff.getInt(), dataBuff.getInt(), dataBuff.position());

		for (int i = 0; i < 256; i++) {
			mh20.getMh2oHdrEntries().add(new MH2OHeaderEntry(dataBuff.getInt(), dataBuff.getInt(), dataBuff.getInt()));
		}

		for (int i = 0; i < 256; i++) {
			MH2OHeaderEntry header = mh20.getMh2oHdrEntries().get(i);
			MH2OInstance mh2oInstance;

			if (header.getOffsetInstances() != 0) {
				dataBuff.position(mh20.getPosition() + header.getOffsetInstances());

				mh2oInstance = new MH2OInstance();

				mh2oInstance.setLiquidType(dataBuff.getShort());
				mh2oInstance.setLiquidObjectOrLVF(dataBuff.getShort());
				mh2oInstance.setMinHeight(dataBuff.getFloat());
				mh2oInstance.setMaxHeight(dataBuff.getFloat());
				mh2oInstance.setxOffset(dataBuff.get());
				mh2oInstance.setyOffset(dataBuff.get());
				mh2oInstance.setWidth(dataBuff.get());
				mh2oInstance.setHeight(dataBuff.get());
				mh2oInstance.setOffsetExistsBitmap(dataBuff.getInt());
				mh2oInstance.setOffsetVertexData(dataBuff.getInt());

				mh20.getMh2oInstances().add(mh2oInstance);
			}
		}

		for (int i = 0; i < 256; i++) {
			MH2OHeaderEntry header = mh20.getMh2oHdrEntries().get(i);

			if (header.getOffsetAttributes() != 0) {

				dataBuff.position(mh20.getPosition() + header.getOffsetAttributes());

				for (int j = 0; j < header.getLayerCount(); j++) {
					mh20.getMh2oAttribs().add(new MH2OAttribute(dataBuff.getInt(), dataBuff.getInt()));
				}
			}
		}

		for (int i = 0; i < 256; i++) {
			MH2OHeaderEntry header = mh20.getMh2oHdrEntries().get(i);

			if (header.getLayerCount() != 0) {

			}
		}

		return mh20;
	}

	public static MCNK readMCNK(ByteBuffer dataBuff, MCIN mcin) {
		/* MCNK */

		MCNK mcnk = new MCNK();

		for (MCINEntry mcnkEntry : mcin.getEntries()) {
			mcnk.getEntries().add(readMCNKEntry(dataBuff, mcnkEntry));
		}
		return mcnk;
	}

	public static MCNKEntry readMCNKEntry(ByteBuffer dataBuff, MCINEntry mcnkEntry/* , int offset */) {
		dataBuff.position(mcnkEntry.getAddress());
		MCNKEntry cnk = new MCNKEntry(dataBuff.getInt(), dataBuff.getInt(), dataBuff.position());

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

	public static MCNKheader readMCNKHeader(ByteBuffer dataBuff, MCINEntry mcnkEntry) {
		MCNKheader mcnkHeader = new MCNKheader();

		mcnkHeader.setFlags(dataBuff.getInt());
		mcnkHeader.setIndexX(dataBuff.getInt());
		mcnkHeader.setIndexY(dataBuff.getInt());
		mcnkHeader.setnLayers(dataBuff.getInt());
		mcnkHeader.setnDoodadRefs(dataBuff.getInt());
		mcnkHeader.setOfsMCVT(dataBuff.getInt());
		mcnkHeader.setOfsMCNR(dataBuff.getInt());
		mcnkHeader.setOfsMCLY(dataBuff.getInt());
		mcnkHeader.setOfsMCRF(dataBuff.getInt());
		mcnkHeader.setOfsMCAL(dataBuff.getInt());
		mcnkHeader.setSizeAlpha(dataBuff.getInt());
		mcnkHeader.setOfsMCSH(dataBuff.getInt());
		mcnkHeader.setSizeShadows(dataBuff.getInt());
		mcnkHeader.setAreaID(dataBuff.getInt());
		mcnkHeader.setnMapObjRefs(dataBuff.getInt());
		mcnkHeader.setHoles(dataBuff.getInt());
		mcnkHeader.setUnk1(dataBuff.getInt());
		mcnkHeader.setUnk2(dataBuff.getInt());
		mcnkHeader.setUnk3(dataBuff.getInt());
		mcnkHeader.setUnk4(dataBuff.getInt());
		mcnkHeader.setPredTex(dataBuff.getInt());
		mcnkHeader.setNoEffectDoodad(dataBuff.getInt());
		mcnkHeader.setOfsMCSE(dataBuff.getInt());
		mcnkHeader.setnSndEmiters(dataBuff.getInt());
		mcnkHeader.setOfsMCLQ(dataBuff.getInt());
		mcnkHeader.setSizeLiquid(dataBuff.getInt());
		mcnkHeader.setVecPosition(new Vector3f(dataBuff.getFloat(), dataBuff.getFloat(), dataBuff.getFloat()));
		mcnkHeader.setOfsMCCV(dataBuff.getInt());
		mcnkHeader.setProps(dataBuff.getInt());
		mcnkHeader.setEffectId(dataBuff.getInt());
		return mcnkHeader;
	}
	
	private static MCLY readMCLY(ByteBuffer dataBuff, MCINEntry mcnkEntry, MCNKheader header) {
		dataBuff.position(mcnkEntry.getAddress() + header.getOfsMCLY());
		MCLY mcly = new MCLY(dataBuff.getInt(), dataBuff.getInt(), dataBuff.position());

		MCLYEntry mclyEntry;

		for (int i = 0; i < mcly.getSize(); i += 0x10) {
			mclyEntry = new MCLYEntry();

			int offset = i;

			mclyEntry.setTextureId(dataBuff.getInt());
			mclyEntry.setFlags(dataBuff.getInt());
			mclyEntry.setOfsAlphaMap(dataBuff.getInt());
			mclyEntry.setDetailTextureID(dataBuff.getInt());

			mcly.getEntries().add(mclyEntry);
		}

		return mcly;
	}

	private static MCNR readMCNR(ByteBuffer dataBuff, MCINEntry mcnkEntry, MCNKheader header) {
		
		dataBuff.position(mcnkEntry.getAddress() + header.getOfsMCNR());
		
		MCNR mcnr = new MCNR(dataBuff.getInt(), dataBuff.getInt(), dataBuff.position());

		byte b;
		for (int i = 0; i < 145; i++) {
			(mcnr.getNormal_0())[i] = dataBuff.get();
			(mcnr.getNormal_1())[i] = dataBuff.get();
			(mcnr.getNormal_2())[i] = dataBuff.get();
//			b = dataBuff.get();
//			(mcnr.getNormal_0())[i] = b & 0xFF;
//			b = dataBuff.get();
//			(mcnr.getNormal_1())[i] = b & 0xFF;
//			b = dataBuff.get();
//			(mcnr.getNormal_2())[i] = b & 0xFF;
		}
		return mcnr;
	}

	private static MCVT readMCVT(ByteBuffer dataBuff, MCINEntry mcnkEntry, MCNKheader header) {
		dataBuff.position(mcnkEntry.getAddress() + header.getOfsMCVT());
		MCVT mcvt = new MCVT(dataBuff.getInt(), dataBuff.getInt(), dataBuff.position());
		
		for (int i = 0; i < 145; i++) {
			mcvt.getVertices().add(dataBuff.getFloat());
		}
		return mcvt;
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
		System.out.println(adts.size() + " ADTs read in " + (end - start) + " ms");
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

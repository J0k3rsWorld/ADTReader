package filereader.files.chunks;

import java.util.ArrayList;
import java.util.List;

import filereader.files.util.Chunk;
import filereader.files.util.MH2OAttribute;
import filereader.files.util.MH2OHeaderEntry;
import filereader.files.util.MH2OInstance;
import filereader.files.util.MH2OVertexData;

public class MH2O extends Chunk{
	

	private List<MH2OHeaderEntry> mh2oHdrEntries = new ArrayList<MH2OHeaderEntry>();
	private List<MH2OAttribute> mh2oAttribs = new ArrayList<MH2OAttribute>();
	private List<MH2OInstance> mh2oInstances = new ArrayList<MH2OInstance>();
	private List<MH2OVertexData> mh2oVertData = new ArrayList<MH2OVertexData>();
	
	public MH2O(int magic, int size, int position) {
		super(magic, size, position);
	}

	public List<MH2OHeaderEntry> getMh2oHdrEntries() {
		return mh2oHdrEntries;
	}

	public void setMh2oHdrEntries(List<MH2OHeaderEntry> mh2oHdrEntries) {
		this.mh2oHdrEntries = mh2oHdrEntries;
	}

	public List<MH2OAttribute> getMh2oAttribs() {
		return mh2oAttribs;
	}

	public void setMh2oAttribs(List<MH2OAttribute> mh2oAttribs) {
		this.mh2oAttribs = mh2oAttribs;
	}

	public List<MH2OInstance> getMh2oInstances() {
		return mh2oInstances;
	}

	public void setMh2oInstances(List<MH2OInstance> mh2oInstances) {
		this.mh2oInstances = mh2oInstances;
	}

	public List<MH2OVertexData> getMh2oVertData() {
		return mh2oVertData;
	}

	public void setMh2oVertData(List<MH2OVertexData> mh2oVertData) {
		this.mh2oVertData = mh2oVertData;
	}


	
}

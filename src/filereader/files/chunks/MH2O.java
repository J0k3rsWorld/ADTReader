package filereader.files.chunks;

import java.util.ArrayList;
import java.util.List;

import filereader.files.util.MDDFEntry;
import filereader.files.util.MH2OAttribute;
import filereader.files.util.MH2OEntry;
import filereader.files.util.MH2OHeader;
import filereader.files.util.MH2OInstance;
import filereader.files.util.MH2OVertexData;

public class MH2O {
	public List<MH2OEntry> entries = new ArrayList<MH2OEntry>();

	public List<MH2OEntry> getEntries() {
		return entries;
	}

	public void setEntries(List<MH2OEntry> entries) {
		this.entries = entries;
	}
}

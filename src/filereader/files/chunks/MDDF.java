package filereader.files.chunks;

import java.util.ArrayList;
import java.util.List;

import filereader.files.util.MDDFEntry;

public class MDDF {
	public List<MDDFEntry> entries = new ArrayList<MDDFEntry>();

	public List<MDDFEntry> getEntries() {
		return entries;
	}

	public void setEntries(List<MDDFEntry> entries) {
		this.entries = entries;
	}
}

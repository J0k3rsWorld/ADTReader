package filereader.files.chunks;

import java.util.ArrayList;
import java.util.List;

import filereader.files.util.MODFEntry;

public class MODF {
	public List<MODFEntry> entries = new ArrayList<MODFEntry>();

	public List<MODFEntry> getEntries() {
		return entries;
	}

	public void setEntries(List<MODFEntry> entries) {
		this.entries = entries;
	}
}

package filereader.files.chunks;

import java.util.ArrayList;
import java.util.List;

import filereader.files.util.MCINEntry;

public class MCIN {
	public List<MCINEntry> entries = new ArrayList<MCINEntry>();

	public List<MCINEntry> getEntries() {
		return entries;
	}

	public void setEntries(List<MCINEntry> entries) {
		this.entries = entries;
	}
}

package filereader.files.chunks;

import java.util.ArrayList;
import java.util.List;

import filereader.files.util.MCNKEntry;

public class MCNK {
	
	private List<MCNKEntry> entries = new ArrayList<MCNKEntry>();

	public List<MCNKEntry> getEntries() {
		return entries;
	}

	public void setEntries(List<MCNKEntry> entries) {
		this.entries = entries;
	}
}

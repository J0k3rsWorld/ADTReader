package filereader.files.chunks;

import java.util.ArrayList;
import java.util.List;

import filereader.files.util.MCLYEntry;

public class MCLY {
	public List<MCLYEntry> entries = new ArrayList<MCLYEntry>();

	public List<MCLYEntry> getEntries() {
		return entries;
	}

	public void setEntries(List<MCLYEntry> entries) {
		this.entries = entries;
	}
}

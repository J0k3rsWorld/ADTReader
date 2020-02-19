package filereader.files.chunks;

import java.util.ArrayList;
import java.util.List;

import filereader.files.util.Chunk;
import filereader.files.util.MCINEntry;

public class MCIN extends Chunk{
	private List<MCINEntry> entries;

	public MCIN(int magic, int size, int position) {
		super(magic, size, position);
		entries = new ArrayList<MCINEntry>();
	}

	public List<MCINEntry> getEntries() {
		return entries;
	}

	public void setEntries(List<MCINEntry> entries) {
		this.entries = entries;
	}
}

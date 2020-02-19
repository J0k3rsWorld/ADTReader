package filereader.files.chunks;

import java.util.ArrayList;
import java.util.List;

import filereader.files.util.Chunk;
import filereader.files.util.MDDFEntry;

public class MDDF extends Chunk{
	private List<MDDFEntry> entries = new ArrayList<MDDFEntry>();

	public MDDF(int magic, int size, int position) {
		super(magic, size, position);
		entries = new ArrayList<MDDFEntry>();
	}
		
	public List<MDDFEntry> getEntries() {
		return entries;
	}

	public void setEntries(List<MDDFEntry> entries) {
		this.entries = entries;
	}
}

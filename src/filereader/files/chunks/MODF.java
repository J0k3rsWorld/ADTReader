package filereader.files.chunks;

import java.util.ArrayList;
import java.util.List;

import filereader.files.util.Chunk;
import filereader.files.util.MODFEntry;

public class MODF extends Chunk{
	private List<MODFEntry> entries = new ArrayList<MODFEntry>();

	public MODF(int magic, int size, int position) {
		super(magic, size, position);
		entries = new ArrayList<MODFEntry>();
	}
		
	public List<MODFEntry> getEntries() {
		return entries;
	}

	public void setEntries(List<MODFEntry> entries) {
		this.entries = entries;
	}
}

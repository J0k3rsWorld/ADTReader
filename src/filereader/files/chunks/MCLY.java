package filereader.files.chunks;

import java.util.ArrayList;
import java.util.List;

import filereader.files.util.Chunk;
import filereader.files.util.MCLYEntry;

public class MCLY extends Chunk{

	public List<MCLYEntry> entries = new ArrayList<MCLYEntry>();

	public MCLY(int magic, int size, int position) {
		super(magic, size, position);
		// TODO Auto-generated constructor stub
	}

	public List<MCLYEntry> getEntries() {
		return entries;
	}

	public void setEntries(List<MCLYEntry> entries) {
		this.entries = entries;
	}
}

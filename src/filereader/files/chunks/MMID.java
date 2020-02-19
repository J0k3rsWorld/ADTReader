package filereader.files.chunks;

import java.util.ArrayList;
import java.util.List;

import filereader.files.util.Chunk;

public class MMID extends Chunk{
	private List<Integer> entries;

	public MMID(int magic, int size, int position) {
		super(magic, size, position);
		entries = new ArrayList<Integer>();
	}
	
	public List<Integer> getEntries() {
		return entries;
	}

	public void setEntries(List<Integer> entries) {
		this.entries = entries;
	}
}

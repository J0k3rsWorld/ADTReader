package filereader.files.chunks;

import java.util.ArrayList;
import java.util.List;

import filereader.files.util.Chunk;

public class MWID extends Chunk{
	private List<Integer> entries = new ArrayList<Integer>();

	public MWID(int magic, int size, int position) {
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

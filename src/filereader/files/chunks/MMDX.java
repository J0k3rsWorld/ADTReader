package filereader.files.chunks;

import java.util.ArrayList;
import java.util.List;

import filereader.files.util.Chunk;

public class MMDX extends Chunk{
    private List<String> filenames;	// zero-terminated strings with complete paths to models. Referenced in MMID.
	
    public MMDX(int magic, int size, int position) {
		super(magic, size, position);
		filenames = new ArrayList<String>();
	}
        
	public List<String> getFilenames() {
		return filenames;
	}
	public void setFilenames(List<String> filenames) {
		this.filenames = filenames;
	}
}

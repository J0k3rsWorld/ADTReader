package filereader.files.chunks;

import java.util.ArrayList;
import java.util.List;

public class MWMO {
    public List<String> filenames = new ArrayList<String>();	// zero-terminated strings with complete paths to models. Referenced in MMID.
	
	public List<String> getFilenames() {
		return filenames;
	}
	public void setFilenames(List<String> filenames) {
		this.filenames = filenames;
	}
}

package filereader.files.chunks;

import java.util.ArrayList;
import java.util.List;

public class MTEX {
    public List<String> filenames = new ArrayList<String>();
	
	public List<String> getFilenames() {
		return filenames;
	}
	public void setFilenames(List<String> filenames) {
		this.filenames = filenames;
	}
	@Override
	public String toString() {
		return "MTEX [filenames=" + filenames + "]";
	}
}

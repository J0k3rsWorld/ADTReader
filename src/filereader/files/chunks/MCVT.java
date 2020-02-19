package filereader.files.chunks;

import java.util.ArrayList;
import java.util.List;

import filereader.files.util.Chunk;

public class MCVT extends Chunk{
	
	private List<Float> vertices = new ArrayList<Float>();

	public MCVT(int magic, int size, int position) {
		super(magic, size, position);
		// TODO Auto-generated constructor stub
	}
	
	public List<Float> getVertices() {
		return vertices;
	}

	public void setVertices(List<Float> vertices) {
		this.vertices = vertices;
	}
	
}

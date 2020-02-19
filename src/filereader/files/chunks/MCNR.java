package filereader.files.chunks;

import filereader.files.util.Chunk;

public class MCNR extends Chunk{
	
	private byte[] normal_0 = new byte[9*9+8*8];
    private byte[] normal_1 = new byte[9*9+8*8];
    private byte[] normal_2 = new byte[9*9+8*8];
    
    public MCNR(int magic, int size, int position) {
		super(magic, size, position);
	}
    
	public byte[] getNormal_0() {
		return normal_0;
	}
	public void setNormal_0(byte[] normal_0) {
		this.normal_0 = normal_0;
	}
	public byte[] getNormal_1() {
		return normal_1;
	}
	public void setNormal_1(byte[] normal_1) {
		this.normal_1 = normal_1;
	}
	public byte[] getNormal_2() {
		return normal_2;
	}
	public void setNormal_2(byte[] normal_2) {
		this.normal_2 = normal_2;
	}
}

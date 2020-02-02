package filereader.files.chunks;

public class MCNR {
	public int[] normal_0 = new int[9*9+8*8];
    public int[] normal_1 = new int[9*9+8*8];
    public int[] normal_2 = new int[9*9+8*8];
    
	public int[] getNormal_0() {
		return normal_0;
	}
	public void setNormal_0(int[] normal_0) {
		this.normal_0 = normal_0;
	}
	public int[] getNormal_1() {
		return normal_1;
	}
	public void setNormal_1(int[] normal_1) {
		this.normal_1 = normal_1;
	}
	public int[] getNormal_2() {
		return normal_2;
	}
	public void setNormal_2(int[] normal_2) {
		this.normal_2 = normal_2;
	}
}

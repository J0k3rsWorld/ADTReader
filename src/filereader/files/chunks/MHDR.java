package filereader.files.chunks;

public class MHDR {
    public int flags;
    public int ofsMCIN;
    public int ofsMTEX;
    public int ofsMMDX;
    public int ofsMMID;
    public int ofsMWMO;
    public int ofsMWID;
    public int ofsMDDF;
    public int ofsMODF;
    public int ofsMFBO;
    public int ofsMH2O;
    public int ofsMTXF;
    public int unk1;
    public int unk2;
    public int unk3;
    public int unk4;
	public int getFlags() {
		return flags;
	}
	public void setFlags(int flags) {
		this.flags = flags;
	}
	public int getOfsMCIN() {
		return ofsMCIN;
	}
	public void setOfsMCIN(int ofsMCIN) {
		this.ofsMCIN = ofsMCIN;
	}
	public int getOfsMTEX() {
		return ofsMTEX;
	}
	public void setOfsMTEX(int ofsMTEX) {
		this.ofsMTEX = ofsMTEX;
	}
	public int getOfsMMDX() {
		return ofsMMDX;
	}
	public void setOfsMMDX(int ofsMMDX) {
		this.ofsMMDX = ofsMMDX;
	}
	public int getOfsMMID() {
		return ofsMMID;
	}
	public void setOfsMMID(int ofsMMID) {
		this.ofsMMID = ofsMMID;
	}
	public int getOfsMWMO() {
		return ofsMWMO;
	}
	public void setOfsMWMO(int ofsMWMO) {
		this.ofsMWMO = ofsMWMO;
	}
	public int getOfsMWID() {
		return ofsMWID;
	}
	public void setOfsMWID(int ofsMWID) {
		this.ofsMWID = ofsMWID;
	}
	public int getOfsMDDF() {
		return ofsMDDF;
	}
	public void setOfsMDDF(int ofsMDDF) {
		this.ofsMDDF = ofsMDDF;
	}
	public int getOfsMODF() {
		return ofsMODF;
	}
	public void setOfsMODF(int ofsMODF) {
		this.ofsMODF = ofsMODF;
	}
	public int getOfsMFBO() {
		return ofsMFBO;
	}
	public void setOfsMFBO(int ofsMFBO) {
		this.ofsMFBO = ofsMFBO;
	}
	public int getOfsMH2O() {
		return ofsMH2O;
	}
	public void setOfsMH2O(int ofsMH2O) {
		this.ofsMH2O = ofsMH2O;
	}
	public int getOfsMTXF() {
		return ofsMTXF;
	}
	public void setOfsMTXF(int ofsMTXF) {
		this.ofsMTXF = ofsMTXF;
	}
	public int getUnk1() {
		return unk1;
	}
	public void setUnk1(int unk1) {
		this.unk1 = unk1;
	}
	public int getUnk2() {
		return unk2;
	}
	public void setUnk2(int unk2) {
		this.unk2 = unk2;
	}
	public int getUnk3() {
		return unk3;
	}
	public void setUnk3(int unk3) {
		this.unk3 = unk3;
	}
	public int getUnk4() {
		return unk4;
	}
	public void setUnk4(int unk4) {
		this.unk4 = unk4;
	}
	@Override
	public String toString() {
		return "MHDR [flags=" + flags + ", ofsMCIN=" + ofsMCIN + ", ofsMTEX=" + ofsMTEX + ", ofsMMDX=" + ofsMMDX
				+ ", ofsMMID=" + ofsMMID + ", ofsMWMO=" + ofsMWMO + ", ofsMWID=" + ofsMWID + ", ofsMDDF=" + ofsMDDF
				+ ", ofsMODF=" + ofsMODF + ", ofsMFBO=" + ofsMFBO + ", ofsMH2O=" + ofsMH2O + ", ofsMTXF=" + ofsMTXF
				+ ", unk1=" + unk1 + ", unk2=" + unk2 + ", unk3=" + unk3 + ", unk4=" + unk4 + "]";
	}
}

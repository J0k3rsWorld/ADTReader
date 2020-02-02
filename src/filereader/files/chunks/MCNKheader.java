package filereader.files.chunks;

import filereader.util.maths.Vector3f;

public class MCNKheader {
    private int flags;
    private int indexX;
    private int indexY;
    private int nLayers;
    private int nDoodadRefs;
    private int ofsMCVT;
    private int ofsMCNR;
    private int ofsMCLY;
    private int ofsMCRF;
    private int ofsMCAL;
    private int sizeAlpha;
    private int ofsMCSH;
    private int sizeShadows;
    private int areaID;
    private int nMapObjRefs;
    private int holes;
    private int unk1;
    private int unk2;
    private int unk3;
    private int unk4;
    private int predTex;
    private int noEffectDoodad;
    private int ofsMCSE;
    private int nSndEmiters;
    private int ofsMCLQ;
    private int sizeLiquid;
    private Vector3f position;
    private int ofsMCCV;
    private int props;
    private int effectId;
	
    public int getFlags() {
		return flags;
	}
	public void setFlags(int flags) {
		this.flags = flags;
	}
	public int getIndexX() {
		return indexX;
	}
	public void setIndexX(int indexX) {
		this.indexX = indexX;
	}
	public int getIndexY() {
		return indexY;
	}
	public void setIndexY(int indexY) {
		this.indexY = indexY;
	}
	public int getnLayers() {
		return nLayers;
	}
	public void setnLayers(int nLayers) {
		this.nLayers = nLayers;
	}
	public int getnDoodadRefs() {
		return nDoodadRefs;
	}
	public void setnDoodadRefs(int nDoodadRefs) {
		this.nDoodadRefs = nDoodadRefs;
	}
	public int getOfsMCVT() {
		return ofsMCVT;
	}
	public void setOfsMCVT(int ofsMCVT) {
		this.ofsMCVT = ofsMCVT;
	}
	public int getOfsMCNR() {
		return ofsMCNR;
	}
	public void setOfsMCNR(int ofsMCNR) {
		this.ofsMCNR = ofsMCNR;
	}
	public int getOfsMCLY() {
		return ofsMCLY;
	}
	public void setOfsMCLY(int ofsMCLY) {
		this.ofsMCLY = ofsMCLY;
	}
	public int getOfsMCRF() {
		return ofsMCRF;
	}
	public void setOfsMCRF(int ofsMCRF) {
		this.ofsMCRF = ofsMCRF;
	}
	public int getOfsMCAL() {
		return ofsMCAL;
	}
	public void setOfsMCAL(int ofsMCAL) {
		this.ofsMCAL = ofsMCAL;
	}
	public int getSizeAlpha() {
		return sizeAlpha;
	}
	public void setSizeAlpha(int sizeAlpha) {
		this.sizeAlpha = sizeAlpha;
	}
	public int getOfsMCSH() {
		return ofsMCSH;
	}
	public void setOfsMCSH(int ofsMCSH) {
		this.ofsMCSH = ofsMCSH;
	}
	public int getSizeShadows() {
		return sizeShadows;
	}
	public void setSizeShadows(int sizeShadows) {
		this.sizeShadows = sizeShadows;
	}
	public int getAreaID() {
		return areaID;
	}
	public void setAreaID(int areaID) {
		this.areaID = areaID;
	}
	public int getnMapObjRefs() {
		return nMapObjRefs;
	}
	public void setnMapObjRefs(int nMapObjRefs) {
		this.nMapObjRefs = nMapObjRefs;
	}
	public int getHoles() {
		return holes;
	}
	public void setHoles(int holes) {
		this.holes = holes;
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
	public int getPredTex() {
		return predTex;
	}
	public void setPredTex(int predTex) {
		this.predTex = predTex;
	}
	public int getNoEffectDoodad() {
		return noEffectDoodad;
	}
	public void setNoEffectDoodad(int noEffectDoodad) {
		this.noEffectDoodad = noEffectDoodad;
	}
	public int getOfsMCSE() {
		return ofsMCSE;
	}
	public void setOfsMCSE(int ofsMCSE) {
		this.ofsMCSE = ofsMCSE;
	}
	public int getnSndEmiters() {
		return nSndEmiters;
	}
	public void setnSndEmiters(int nSndEmiters) {
		this.nSndEmiters = nSndEmiters;
	}
	public int getOfsMCLQ() {
		return ofsMCLQ;
	}
	public void setOfsMCLQ(int ofsMCLQ) {
		this.ofsMCLQ = ofsMCLQ;
	}
	public int getSizeLiquid() {
		return sizeLiquid;
	}
	public void setSizeLiquid(int sizeLiquid) {
		this.sizeLiquid = sizeLiquid;
	}
	public Vector3f getPosition() {
		return position;
	}
	public void setPosition(Vector3f position) {
		this.position = position;
	}
	public int getOfsMCCV() {
		return ofsMCCV;
	}
	public void setOfsMCCV(int ofsMCCV) {
		this.ofsMCCV = ofsMCCV;
	}
	public int getProps() {
		return props;
	}
	public void setProps(int props) {
		this.props = props;
	}
	public int getEffectId() {
		return effectId;
	}
	public void setEffectId(int effectId) {
		this.effectId = effectId;
	}
}

package filereader.files.util;

public class MCLYEntry {
	public long textureId;
    public int flags;
    public long ofsAlphaMap;
    public int detailTextureID;

    public long getTextureId() {
		return textureId;
	}
	public void setTextureId(long textureId) {
		this.textureId = textureId;
	}
	public int getFlags() {
		return flags;
	}
	public void setFlags(int flags) {
		this.flags = flags;
	}
	
	public long getOfsAlphaMap() {
		return ofsAlphaMap;
	}
	public void setOfsAlphaMap(long ofsAlphaMap) {
		this.ofsAlphaMap = ofsAlphaMap;
	}
	public int getDetailTextureID() {
		return detailTextureID;
	}
	public void setDetailTextureID(int detailTextureID) {
		this.detailTextureID = detailTextureID;
	}
	
}

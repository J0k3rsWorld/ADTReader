package filereader.files.util;

import filereader.util.maths.Vector3f;

public class MDDFEntry {
    public long nameID;
    public long uniqueId;
    public Vector3f position;
    public Vector3f rotation;
    public short scale;
    public short flags;
    
	public long getNameID() {
		return nameID;
	}
	public void setNameID(long mmidEntry) {
		this.nameID = mmidEntry;
	}
	public long getUniqueId() {
		return uniqueId;
	}
	public void setUniqueId(long uniqueId) {
		this.uniqueId = uniqueId;
	}
	public Vector3f getPosition() {
		return position;
	}
	public void setPosition(Vector3f position) {
		this.position = position;
	}
	public Vector3f getRotation() {
		return rotation;
	}
	public void setRotation(Vector3f rotation) {
		this.rotation = rotation;
	}
	public short getScale() {
		return scale;
	}
	public void setScale(short scale) {
		this.scale = scale;
	}
	public short getFlags() {
		return flags;
	}
	public void setFlags(short flags) {
		this.flags = flags;
	}
}

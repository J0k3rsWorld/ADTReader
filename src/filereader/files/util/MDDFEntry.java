package filereader.files.util;

import filereader.util.maths.Vector3f;

public class MDDFEntry {
    private int nameID;
    private int uniqueId;
    private Vector3f position;
    private Vector3f rotation;
    private int scale;
    private int flags;
    
	public int getNameID() {
		return nameID;
	}
	public void setNameID(int mmidEntry) {
		this.nameID = mmidEntry;
	}
	public int getUniqueId() {
		return uniqueId;
	}
	public void setUniqueId(int uniqueId) {
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
	public int getScale() {
		return scale;
	}
	public void setScale(int scale) {
		this.scale = scale;
	}
	public int getFlags() {
		return flags;
	}
	public void setFlags(int flags) {
		this.flags = flags;
	}
}

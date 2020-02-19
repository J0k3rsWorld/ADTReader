package filereader.files.util;

import filereader.util.maths.Vector3f;

public class MODFEntry {
    public int mwidEntry;
    public int uniqueId;
    public Vector3f position;
    public Vector3f rotation;
    public Vector3f lowerBounds;
    public Vector3f upperBounds;
    public int flags;
    public int doodadSet;
    public int nameSet;
    public int scale;
	public int getMwidEntry() {
		return mwidEntry;
	}
	public void setMwidEntry(int mwidEntry) {
		this.mwidEntry = mwidEntry;
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
	public Vector3f getLowerBounds() {
		return lowerBounds;
	}
	public void setLowerBounds(Vector3f lowerBounds) {
		this.lowerBounds = lowerBounds;
	}
	public Vector3f getUpperBounds() {
		return upperBounds;
	}
	public void setUpperBounds(Vector3f upperBounds) {
		this.upperBounds = upperBounds;
	}
	public int getFlags() {
		return flags;
	}
	public void setFlags(int flags) {
		this.flags = flags;
	}
	public int getDoodadSet() {
		return doodadSet;
	}
	public void setDoodadSet(int doodadSet) {
		this.doodadSet = doodadSet;
	}
	public int getNameSet() {
		return nameSet;
	}
	public void setNameSet(int nameSet) {
		this.nameSet = nameSet;
	}
	public int getScale() {
		return scale;
	}
	public void setScale(int scale) {
		this.scale = scale;
	}
}

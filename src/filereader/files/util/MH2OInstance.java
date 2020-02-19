package filereader.files.util;

public class MH2OInstance {
    public short liquidType;
    public short liquidObjectOrLVF;
    public float minHeight;
    public float maxHeight;
    public byte xOffset;
    public byte yOffset;
    public byte width;
    public byte height;
    public int offsetExistsBitmap;
    public int offsetVertexData;
	
    public short getLiquidType() {
		return liquidType;
	}
	public void setLiquidType(short liquidType) {
		this.liquidType = liquidType;
	}
	public short getLiquidObjectOrLVF() {
		return liquidObjectOrLVF;
	}
	public void setLiquidObjectOrLVF(short liquidObjectOrLVF) {
		this.liquidObjectOrLVF = liquidObjectOrLVF;
	}
	public float getMinHeight() {
		return minHeight;
	}
	public void setMinHeight(float min_height_level) {
		this.minHeight = min_height_level;
	}
	public float getMaxHeight() {
		return maxHeight;
	}
	public void setMaxHeight(float max_height_level) {
		this.maxHeight = max_height_level;
	}
	public byte getxOffset() {
		return xOffset;
	}
	public void setxOffset(byte xOffset) {
		this.xOffset = xOffset;
	}
	public byte getyOffset() {
		return yOffset;
	}
	public void setyOffset(byte yOffset) {
		this.yOffset = yOffset;
	}
	public byte getWidth() {
		return width;
	}
	public void setWidth(byte width) {
		this.width = width;
	}
	public byte getHeight() {
		return height;
	}
	public void setHeight(byte height) {
		this.height = height;
	}
	public int getOffsetExistsBitmap() {
		return offsetExistsBitmap;
	}
	public void setOffsetExistsBitmap(int offsetExistsBitmap) {
		this.offsetExistsBitmap = offsetExistsBitmap;
	}
	public int getOffsetVertexData() {
		return offsetVertexData;
	}
	public void setOffsetVertexData(int offsetVertexData) {
		this.offsetVertexData = offsetVertexData;
	}
}

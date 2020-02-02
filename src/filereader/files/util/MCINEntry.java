package filereader.files.util;

public class MCINEntry {
	private int address; //absolute offset
	private int size;	//the size of MCNK, this is reffering to
	private int flags;  // always 0, only set in client, FLAG_LOADED = 1
	private int asyncID;

	public int getAddress() {
		return address;
	}
	public void setAddress(int offset) {
		this.address = offset;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getFlags() {
		return flags;
	}
	public void setFlags(int flags) {
		this.flags = flags;
	}
	public int getAsyncID() {
		return asyncID;
	}
	public void setAsyncID(int asyncID) {
		this.asyncID = asyncID;
	}
	@Override
	public String toString() {
		return "MCIN [address=" + address + ", size=" + size + ", flags=" + flags + ", asyncID=" + asyncID + "]";
	}
}

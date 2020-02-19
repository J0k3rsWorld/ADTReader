package filereader.files.util;

public class MH2OAttribute {
    public int fishable;
    public int deep;
	
    public MH2OAttribute(int fishable, int deep) {
		this.fishable = fishable;
		this.deep = deep;
	}

	public int getFishable() {
		return fishable;
	}

	public void setFishable(int fishable) {
		this.fishable = fishable;
	}

	public int getDeep() {
		return deep;
	}

	public void setDeep(int deep) {
		this.deep = deep;
	}
}

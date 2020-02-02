package filereader.files.util;

import filereader.files.chunks.MCBB;
import filereader.files.chunks.MCCV;
import filereader.files.chunks.MCLV;
import filereader.files.chunks.MCLY;
import filereader.files.chunks.MCNKheader;
import filereader.files.chunks.MCNR;
import filereader.files.chunks.MCSE;
import filereader.files.chunks.MCVT;

public class MCNKEntry {
	public MCNKheader header;
    public MCVT mcvt;
    public MCNR mcnr;
    public MCLY mcly;
    public MCCV mccv;
    public MCSE mcse;
    public MCBB[] mcbb;

    public MCNKheader getHeader() {
		return header;
	}
	public void setHeader(MCNKheader header) {
		this.header = header;
	}
	public MCVT getMcvt() {
		return mcvt;
	}
	public void setMcvt(MCVT mcvt) {
		this.mcvt = mcvt;
	}
	public MCNR getMcnr() {
		return mcnr;
	}
	public void setMcnr(MCNR mcnr) {
		this.mcnr = mcnr;
	}
	public MCLY getMcly() {
		return mcly;
	}
	public void setMcly(MCLY mcly) {
		this.mcly = mcly;
	}
	public MCCV getMccv() {
		return mccv;
	}
	public void setMccv(MCCV mccv) {
		this.mccv = mccv;
	}
	public MCSE getMcse() {
		return mcse;
	}
	public void setMcse(MCSE mcse) {
		this.mcse = mcse;
	}
	public MCBB[] getMcbb() {
		return mcbb;
	}
	public void setMcbb(MCBB[] mcbb) {
		this.mcbb = mcbb;
	}
	
}

package filereader.files;

import filereader.files.chunks.MCIN;
import filereader.files.chunks.MCNK;
import filereader.files.chunks.MDDF;
import filereader.files.chunks.MH2O;
import filereader.files.chunks.MHDR;
import filereader.files.chunks.MMDX;
import filereader.files.chunks.MMID;
import filereader.files.chunks.MODF;
import filereader.files.chunks.MTEX;
import filereader.files.chunks.MWID;
import filereader.files.chunks.MWMO;

public class ADT335 {
    private int mver;
    private MHDR mhdr;
    private MCIN mcin; // = new MCIN[256];
    private MTEX mtex;
    private MMDX mmdx;
    private MMID mmid;
    private MWMO mwmo;
    private MWID mwid;
    private MDDF mddf;
    private MODF modf;
    private MH2O mh2o; //skip for now, don't want water right now :'D
    private MCNK mcnk;
    
    public int getMver() {
		return mver;
	}
	public void setMver(int mver) {
		this.mver = mver;
	}
	public MHDR getMhdr() {
		return mhdr;
	}
	public void setMhdr(MHDR mhdr) {
		this.mhdr = mhdr;
	}
	public MCIN getMcin() {
		return mcin;
	}
	public void setMcin(MCIN mcin) {
		this.mcin = mcin;
	}
	public MTEX getMtex() {
		return mtex;
	}
	public void setMtex(MTEX mtex) {
		this.mtex = mtex;
	}
	
	public MMDX getMmdx() {
		return mmdx;
	}
	public void setMmdx(MMDX mmdx) {
		this.mmdx = mmdx;
	}
	public MMID getMmid() {
		return mmid;
	}
	public void setMmid(MMID mmid) {
		this.mmid = mmid;
	}
	public MWMO getMwmo() {
		return mwmo;
	}
	public void setMwmo(MWMO mwmo) {
		this.mwmo = mwmo;
	}
	public MWID getMwid() {
		return mwid;
	}
	public void setMwid(MWID mwid) {
		this.mwid = mwid;
	}
	public MDDF getMddf() {
		return mddf;
	}
	public void setMddf(MDDF mddf) {
		this.mddf = mddf;
	}

	@Override
	public String toString() {
		return "ADT335 [mver=" + mver + ", header=" + mhdr + ", mcin=" + mcin + ", mtex=" + mtex
				+ ", mmdx=" + mmdx + ", mmid=" + mmid + ", mwmo=" + mwmo + ", mwid=" + mwid + ", mddf=" + mddf
				+ ", modf=" + modf + ", mh2o=" + mh2o + ", mcnk=" + mcnk + "]";
	}
	public MODF getModf() {
		return modf;
	}
	public void setModf(MODF modf) {
		this.modf = modf;
	}
	public MH2O getMh2o() {
		return mh2o;
	}
	public void setMh2o(MH2O mh2o) {
		this.mh2o = mh2o;
	}
	public MCNK getMcnk() {
		return mcnk;
	}
	public void setMcnk(MCNK mcnk) {
		this.mcnk = mcnk;
	}    
}

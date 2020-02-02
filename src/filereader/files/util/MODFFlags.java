package filereader.files.util;

public enum MODFFlags {
	modf_destroyable(0x1),
	modf_use_lod(0x2), 
	modf_0x4_unk(0x4),
	modf_entry_is_filedataid(0x8);

    private final int value;                          
    
	MODFFlags(int value){
		this.value = value;
	}
}

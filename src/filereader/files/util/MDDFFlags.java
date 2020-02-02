package filereader.files.util;

public enum MDDFFlags {
	mddf_biodome(0x1),
    mddf_shrubbery(0x2), //probably deprecated < 18179
    mddf_0x4(0x4),
    mddf_0x8(0x8),
    mddf_liquid_known(0x20),
    mddf_entry_is_filedataid(0x40),
    mddf_0x100(0x100),                     
    mddf_0x200(0x200);

    private final int value;                          
    
	MDDFFlags(int value){
		this.value = value;
	}
}

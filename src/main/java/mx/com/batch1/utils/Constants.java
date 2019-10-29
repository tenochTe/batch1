package mx.com.batch1.utils;

public enum Constants {

	HOME( System.getProperty("user.home") ),
	TMP_DIR( "fichTemp" ),
	SEPARATOR( System.getProperty("file.separator") )
	;
	
	String value;
	
	private Constants(String value) {
		this.value=value;
	}
	
	public String getValue() {
		return this.value;
	}
}

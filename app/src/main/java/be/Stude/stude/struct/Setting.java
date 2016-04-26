package be.Stude.stude.struct;

public class Setting {

	private int mode;
	private int fond;
	//private String color;
	
	public Setting(int mode, int fond) {
		this.mode = mode;
		this.fond = fond;
	}

	public int getMode() {
		return mode;
	}

	public void setMode(int mode) {
		this.mode = mode;
	}

	public int getFond() {
		return fond;
	}

	public void setFond(int fond) {
		this.fond = fond;
	}
}

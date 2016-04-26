package be.Stude.stude.struct;

public class Element {

	private int ElementId;
	private int themeId;
	private String word;
	private String description;
	
	public Element(int themeId, String word, String desc) {
		this.themeId = themeId;
		this.word = word;
		description = desc;
	}
	
	public Element(int id, int themeId, String word, String desc) {
		ElementId = id;
		this.themeId = themeId;
		this.word = word;
		description = desc;
	}
	
	public int getElement_id() {
		return ElementId;
	}
	
	public void setId(int id) {
		this.ElementId = id;
	}

	public int getThemeId() {
		return themeId;
	}

	public void setThemeId(int themeId) {
		this.themeId = themeId;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}

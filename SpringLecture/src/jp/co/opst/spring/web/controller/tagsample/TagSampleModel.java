package jp.co.opst.spring.web.controller.tagsample;

public class TagSampleModel {
	private boolean breakfast;

	public boolean isBreakfast() {
		return breakfast;
	}

	public void setBreakfast(boolean breakfast) {
		this.breakfast = breakfast;
	}

	private boolean lunch;

	public boolean isLunch() {
		return lunch;

	}

	public void setLunch(boolean lunch) {
		this.lunch = lunch;

	}

	private String[] dinner;

	public String[] getDinner() {
		return dinner;
	}

	public void setDinner(String[] dinner) {
		this.dinner = dinner;
	}

	private String first;
	private String second;

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getSecond() {
		return second;
	}

	public void setSecond(String second) {
		this.second = second;
	}

	private String eto;

	public String getEto() {
		return eto;
	}

	public void setEto(String eto) {
		this.eto = eto;
	}

	private String fukawa;

	public String getFukawa() {
		return fukawa;
	}

	public void setFukawa(String fukawa) {
		this.fukawa = fukawa;
	}



}

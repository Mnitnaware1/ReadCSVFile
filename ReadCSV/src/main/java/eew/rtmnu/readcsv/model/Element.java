package eew.rtmnu.readcsv.model;

public class Element {
	private String elementName;
	private String elementReview;
	private String elementWeightage;

	public String getElementName() {
		return elementName;
	}

	public void setElementName(String elementName) {
		this.elementName = elementName;
	}

	public String getElementReview() {
		return elementReview;
	}

	public void setElementReview(String elementReview) {
		this.elementReview = elementReview;
	}

	public String getElementWeightage() {
		return elementWeightage;
	}

	public void setElementWeightage(String elementWeightage) {
		this.elementWeightage = elementWeightage;
	}

	@Override
	public String toString() {
		return "Element [elementName=" + elementName + ", elementReview=" + elementReview + ", elementWeightage="
				+ elementWeightage + "]";
	}

}

package com.nex.springboot.form.app.editors;

import java.beans.PropertyEditorSupport;

public class NameCapitalEditor extends PropertyEditorSupport{

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		setValue(text.toUpperCase().trim());
	}

}

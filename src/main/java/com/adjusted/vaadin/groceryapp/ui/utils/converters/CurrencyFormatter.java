package com.adjusted.vaadin.groceryapp.ui.utils.converters;

import com.adjusted.vaadin.groceryapp.ui.dataproviders.DataProviderUtil;
import com.adjusted.vaadin.groceryapp.ui.utils.FormattingUtils;
import com.vaadin.flow.templatemodel.ModelEncoder;

public class CurrencyFormatter implements ModelEncoder<Integer, String> {

	@Override
	public String encode(Integer modelValue) {
		return DataProviderUtil.convertIfNotNull(modelValue, FormattingUtils::formatAsCurrency);
	}

	@Override
	public Integer decode(String presentationValue) {
		throw new UnsupportedOperationException();
	}
}

package com.adjusted.vaadin.groceryapp.ui.utils.converters;

import java.time.LocalDateTime;

import com.adjusted.vaadin.groceryapp.ui.dataproviders.DataProviderUtil;
import com.adjusted.vaadin.groceryapp.ui.utils.FormattingUtils;
import com.vaadin.flow.templatemodel.ModelEncoder;

public class LocalDateTimeConverter implements ModelEncoder<LocalDateTime, String> {


	private static final LocalTimeConverter TIME_FORMATTER = new LocalTimeConverter();

	@Override
	public String encode(LocalDateTime modelValue) {
		return DataProviderUtil.convertIfNotNull(modelValue,
				v -> FormattingUtils.FULL_DATE_FORMATTER.format(v) + " " + TIME_FORMATTER.encode(v.toLocalTime()));
	}

	@Override
	public LocalDateTime decode(String presentationValue) {
		throw new UnsupportedOperationException();
	}
}

package com.adjusted.vaadin.groceryapp.ui.views.storefront.events;

import com.adjusted.vaadin.groceryapp.ui.views.orderedit.OrderEditor;
import com.vaadin.flow.component.ComponentEvent;

public class ReviewEvent extends ComponentEvent<OrderEditor> {

	public ReviewEvent(OrderEditor component) {
		super(component, false);
	}
}
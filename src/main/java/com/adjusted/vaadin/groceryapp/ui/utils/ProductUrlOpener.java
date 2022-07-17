package com.adjusted.vaadin.groceryapp.ui.utils;

import com.adjusted.vaadin.groceryapp.backend.data.entity.Product;
import com.vaadin.flow.component.UI;

import java.util.List;

public interface ProductUrlOpener {

    void openProductURLs(List<Product> products);

    void setUserInterface(UI ui);

}

package com.adjusted.vaadin.groceryapp.ui.utils;

import com.adjusted.vaadin.groceryapp.backend.data.entity.Product;
import com.vaadin.flow.component.UI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ProductUrlOpenerImplOther implements ProductUrlOpener {



    private static final Logger logger = LoggerFactory.getLogger(ProductUrlOpenerImplOther.class);

    @Override
    public void openProductURLs(List<Product> products) {

        logger.error("this is a test of openProductURLs");

    }

    @Override
    public void setUserInterface(UI ui) {}

    public void aaaa() {};
}

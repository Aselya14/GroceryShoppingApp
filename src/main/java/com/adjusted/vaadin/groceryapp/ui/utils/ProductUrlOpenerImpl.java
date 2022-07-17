package com.adjusted.vaadin.groceryapp.ui.utils;

import com.adjusted.vaadin.groceryapp.backend.data.entity.Product;
import com.vaadin.flow.component.UI;

import java.util.List;

public class ProductUrlOpenerImpl implements ProductUrlOpener {

    private UI ui;

    @Override
    public void openProductURLs(List<Product> products) {

        for (Product product: products)
        {
            if (product==null || product.getUrl()==null) {
                continue;
            }

            int amount = 1;

            if (product.getAmount()!=null) {
                amount = product.getAmount();
            }

            for (int i=1; i<=amount; i++) {

                ui.getPage().open(product.getUrl(), "_blank");

            }

        }

    }

    @Override
    public void setUserInterface(UI ui) {
        this.ui = ui;
    }
}

package com.adjusted.vaadin.groceryapp.ui.views.admin;

import com.adjusted.vaadin.groceryapp.backend.data.Role;
import com.adjusted.vaadin.groceryapp.backend.data.entity.Product;
import com.adjusted.vaadin.groceryapp.backend.repositories.ProductRepository;
import com.adjusted.vaadin.groceryapp.ui.MainView;
import com.adjusted.vaadin.groceryapp.ui.utils.BakeryConst;
import com.adjusted.vaadin.groceryapp.ui.utils.ProductUrlOpener;
import com.adjusted.vaadin.groceryapp.ui.utils.ProductUrlOpenerImpl;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;

import java.util.List;


@Route(value = BakeryConst.PAGE_DASHBOARD, layout = MainView.class)
@PageTitle(BakeryConst.TITLE_DASHBOARD)
@Secured(Role.ADMIN)
public class ActionView extends Div {

    private ProductRepository productRepository;

    @Autowired
    public ActionView(ProductRepository productRepository){
        this.productRepository = productRepository;
        init(productRepository);
    }

    public ProductRepository getRepository() {
        return productRepository;
    }


    public void init(ProductRepository productRepository) {

        Button urlGenerateButton = new Button("generate pages");

        setHeightFull();
        setWidthFull();
        add(urlGenerateButton);
        urlGenerateButton.addClickListener(event ->{

			ProductUrlOpener opener = new ProductUrlOpenerImpl();
			UI ui = getUI().get();
			opener.setUserInterface(ui);
			List<Product> productList = productRepository.findAll();
			opener.openProductURLs(productList);


		});

    }

}

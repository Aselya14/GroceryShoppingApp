package com.adjusted.vaadin.groceryapp.ui.views.admin.products;

import com.adjusted.vaadin.groceryapp.app.security.CurrentUser;
import com.adjusted.vaadin.groceryapp.backend.data.Role;
import com.adjusted.vaadin.groceryapp.backend.data.entity.Product;
import com.adjusted.vaadin.groceryapp.backend.service.ProductService;
import com.adjusted.vaadin.groceryapp.ui.MainView;
import com.adjusted.vaadin.groceryapp.ui.crud.AbstractBakeryCrudView;
import com.adjusted.vaadin.groceryapp.ui.utils.BakeryConst;
import com.adjusted.vaadin.groceryapp.ui.utils.converters.CurrencyFormatter;
import com.vaadin.flow.component.crud.BinderCrudEditor;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;

import java.util.Currency;


@Route(value = BakeryConst.PAGE_PRODUCTS, layout = MainView.class)
@PageTitle(BakeryConst.TITLE_PRODUCTS)
@Secured(Role.ADMIN)
public class ProductsView extends AbstractBakeryCrudView<Product> {

	private CurrencyFormatter currencyFormatter = new CurrencyFormatter();

	@Autowired
	public ProductsView(ProductService service, CurrentUser currentUser) {
		super(Product.class, service, new Grid<>(), createForm(), currentUser);
	}

	@Override
	protected void setupGrid(Grid<Product> grid) {
		grid.addColumn(Product::getName).setHeader("Product Name").setFlexGrow(10);
		grid.addColumn(Product::getUrl).setHeader("Product Url").setFlexGrow(10);
		grid.addColumn(Product::getAmount).setHeader("Product Amount").setFlexGrow(10);
	}

	@Override
	protected String getBasePage() {
		return BakeryConst.PAGE_PRODUCTS;
	}

	private static BinderCrudEditor<Product> createForm() {
		TextField name = new TextField("Product name");
		name.getElement().setAttribute("colspan", "2");
		TextField url = new TextField("Product name");
		name.getElement().setAttribute("colspan", "2");

		FormLayout form = new FormLayout(name);

		BeanValidationBinder<Product> binder = new BeanValidationBinder<>(Product.class);

		binder.bind(name, "name");

		String currencySymbol = Currency.getInstance(BakeryConst.APP_LOCALE).getSymbol();

		return new BinderCrudEditor<>(binder, form);
	}

}

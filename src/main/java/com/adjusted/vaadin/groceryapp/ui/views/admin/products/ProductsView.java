package com.adjusted.vaadin.groceryapp.ui.views.admin.products;

import com.adjusted.vaadin.groceryapp.app.security.CurrentUser;
import com.adjusted.vaadin.groceryapp.backend.data.Role;
import com.adjusted.vaadin.groceryapp.backend.data.entity.Product;
import com.adjusted.vaadin.groceryapp.backend.service.ProductService;
import com.adjusted.vaadin.groceryapp.ui.MainView;
import com.adjusted.vaadin.groceryapp.ui.crud.AbstractBakeryCrudView;
import com.adjusted.vaadin.groceryapp.ui.utils.BakeryConst;
import com.adjusted.vaadin.groceryapp.ui.utils.ProductUrlOpener;
import com.adjusted.vaadin.groceryapp.ui.utils.ProductUrlOpenerImpl;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.crud.BinderCrudEditor;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.provider.Query;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.function.ValueProvider;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;


@Route(value = BakeryConst.PAGE_PRODUCTS, layout = MainView.class)
@PageTitle(BakeryConst.TITLE_PRODUCTS)
@Secured(Role.ADMIN)
public class ProductsView extends AbstractBakeryCrudView<Product> {

	private static final String SLOT_KEY = "slot";
	private static final String TOOLBAR_SLOT_NAME = "toolbar";
	private static final Logger logger = LoggerFactory.getLogger(ProductsView.class);

//@Id("toolbar")
//	private Div toolbar;

	@Autowired
	public ProductsView(ProductService service, CurrentUser currentUser) {
		super(Product.class, service, new Grid<>(), createForm(), currentUser);

	}

//	@PostConstruct
//	private void init() {
//
//		Button urlGenerateButton =new Button("generate pages");
//
//		urlGenerateButton.addClickListener(event ->{
//
//			ProductUrlOpener opener = new ProductUrlOpenerImpl();
//			UI ui = getUI().get();
//			opener.setUserInterface(ui);
//			List<Product> productList = getDataProvider().fetch(new Query<>()).collect(Collectors.toList());
//			opener.openProductURLs(productList);
//
//
//		});
//
////		getChildren().forEach(component -> {
////
////			logger.error("component id: {}", component.getId());
////			logger.error("properties: {}", component.getElement().getPropertyNames());
////			logger.error("attributes: {}", component.getElement().getAttributeNames());
////
////		});
//
//
//		//Element element = urlGenerateButton.getElement();
//		//element.setAttribute(SLOT_KEY, TOOLBAR_SLOT_NAME);
////		List<Component> collect = getChildren().filter(component -> "toolbar".equals(component.getId())).collect(Collectors.toList());
////		Component collect = findComponentById(this, "toolbar");
////
////		if (collect!=null ) {
////			logger.error("FOUND!!!!!!!!!!!!");
////			Div toolBar = (Div) collect;
////
//
//
//
//		//toolbar.add(urlGenerateButton);
////
////		}
//
//		HorizontalLayout div = new HorizontalLayout();
////
//		div.add(urlGenerateButton);
//
//		Button createNew = new Button("CREATE NEW +");
//
//		createNew.addClickListener(event -> {
//			try {
//				getEditor().setItem(e.getItem() != null ? e.getItem()
//						: getBeanType().newInstance());
//				clearActiveItem();
//				setClientIsNew(true);
//			} catch (Exception ex) {
//				throw new RuntimeException(
//						"Unable to instantiate new bean", ex);
//			}
//
//		} );
//
//		div.add(createNew);
//
////
////
////		final Element[] existingToolbarElements =
////				getElement()
////						.getChildren()
////						.filter(e -> TOOLBAR_SLOT_NAME.equals(e.getAttribute(SLOT_KEY)))
////						.toArray(Element[]::new);
////
////		logger.error("-----------------------!!!!!---------------------");
////		for (Element element : existingToolbarElements)
////		{
////
////			if (element!=null) {
////				logger.error("toolbar element : {}", element.getClass());
////				//if (element.getComponent().isPresent()) {
////				div.getElement().appendChild(element);
////			}
////			//}
////
////		}
//////		div.add(urlGenerateButton);
//////		div.setWidthFull();
//////		div.setAlignItems(FlexComponent.Alignment.BASELINE);
//		setToolbar(div);
////		getElement().removeChild(existingToolbarElements);
//	}

	@Override
	protected void setupGrid(Grid<Product> grid) {
		grid.addColumn(Product::getName).setHeader("Product Name").setFlexGrow(10);
		grid.addColumn(Product::getUrl).setHeader("Product Url").setFlexGrow(10);
		grid.addColumn(Product::getAmount).setHeader("Product Amount").setFlexGrow(10);
		grid.addComponentColumn(new ValueProvider<Product, Component>() {
			@Override
			public Component apply(Product product) {

				Button button = new Button("Open");

				button.addClickListener(click -> {
					getUI().ifPresent(ui -> {
						ui.getPage().open(product.getUrl(), "_blank");
					});
				});


				return button;
			}
		}).setHeader("Open url").setFlexGrow(10);
	}

	@Override
	protected String getBasePage() {
		return BakeryConst.PAGE_PRODUCTS;
	}

	private static BinderCrudEditor<Product> createForm() {
		TextField name = new TextField("Product name");
		name.getElement().setAttribute("colspan", "2");
		TextField url = new TextField("Product url");
		url.getElement().setAttribute("colspan", "2");
		IntegerField amount = new IntegerField("Product amount");
		amount.getElement().setAttribute("colspan", "2");


		FormLayout form = new FormLayout(name, url, amount);

		BeanValidationBinder<Product> binder = new BeanValidationBinder<>(Product.class);

		binder.bind(name, "name");
		binder.bind(url, "url");
		binder.bind(amount, "amount");




		return new BinderCrudEditor<>(binder, form);
	}


	public static Component findComponentById(Component root, String id) {
		for (Component child : root.getChildren().collect(Collectors.toList())) {
			if (id.equals(child.getId())) {
				return child; // found it!
			} else if (child instanceof HasComponents) { // recursively go through all children that themselves have children
				Component result = findComponentById((Component) child, id);
				if (result != null) {
					return result;
				}
			}
		}
		return null; // none was found
	}
}

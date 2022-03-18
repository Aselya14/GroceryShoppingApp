package com.adjusted.vaadin.groceryapp.ui.views.person;

import com.adjusted.vaadin.groceryapp.app.security.CurrentUser;
import com.adjusted.vaadin.groceryapp.backend.data.Role;
import com.adjusted.vaadin.groceryapp.backend.data.entity.Person;
import com.adjusted.vaadin.groceryapp.backend.service.PersonService;
import com.adjusted.vaadin.groceryapp.ui.MainView;
import com.adjusted.vaadin.groceryapp.ui.crud.AbstractBakeryCrudView;
import com.adjusted.vaadin.groceryapp.ui.utils.BakeryConst;
import com.vaadin.flow.component.crud.BinderCrudEditor;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;


@Route(value = BakeryConst.PAGE_PERSON, layout = MainView.class)
@PageTitle(BakeryConst.TITLE_PERSON)
@Secured(Role.ADMIN)
public class PersonView extends AbstractBakeryCrudView<Person> {

	@Autowired
	public PersonView(PersonService service, CurrentUser currentUser) {
		super(Person.class, service, new Grid<>(), createForm(), currentUser);
	}

	@Override
	protected void setupGrid(Grid<Person> grid) {
		grid.addColumn(Person::getName).setHeader("Person Name").setFlexGrow(10);
	}

	@Override
	protected String getBasePage() {
		return BakeryConst.PAGE_PERSON;
	}

	private static BinderCrudEditor<Person> createForm() {
		TextField name = new TextField("Person name");
		name.getElement().setAttribute("colspan", "2");

		FormLayout form = new FormLayout(name);

		BeanValidationBinder<Person> binder = new BeanValidationBinder<>(Person.class);

		binder.bind(name, "name");

		return new BinderCrudEditor<>(binder, form);
	}

}

package com.kiroule.vaadin.bakeryapp.ui.views.weight;

import com.kiroule.vaadin.bakeryapp.app.security.CurrentUser;
import com.kiroule.vaadin.bakeryapp.backend.data.Role;
import com.kiroule.vaadin.bakeryapp.backend.data.entity.Person;
import com.kiroule.vaadin.bakeryapp.backend.data.entity.WeightData;
import com.kiroule.vaadin.bakeryapp.backend.repositories.WeightRepository;
import com.kiroule.vaadin.bakeryapp.backend.service.FilterableCrudService;
import com.kiroule.vaadin.bakeryapp.backend.service.WeightService;
import com.kiroule.vaadin.bakeryapp.ui.MainView;
import com.kiroule.vaadin.bakeryapp.ui.crud.AbstractBakeryCrudView;
import com.kiroule.vaadin.bakeryapp.ui.utils.BakeryConst.*;
import com.vaadin.flow.component.crud.BinderCrudEditor;
import com.vaadin.flow.component.crud.CrudEditor;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;

import static com.kiroule.vaadin.bakeryapp.ui.utils.BakeryConst.PAGE_WEIGHT;
import static com.kiroule.vaadin.bakeryapp.ui.utils.BakeryConst.TITLE_WEIGHT;

@Route(value = PAGE_WEIGHT, layout = MainView.class)
@PageTitle(TITLE_WEIGHT)
@Secured(Role.ADMIN)
public class WeightView extends AbstractBakeryCrudView<WeightData> {

    @Autowired
    public WeightView(WeightService service, CrudEditor<WeightData> editor, CurrentUser currentUser) {
        super(WeightData.class, service, new Grid<>(), createForm(), currentUser);
    }

    @Override
    protected String getBasePage() {
        return null;
    }

    private static BinderCrudEditor<Person> createForm() {
        TextField weight = new TextField("Weight");
        weight.getElement().setAttribute("colspan", "2");

        FormLayout form = new FormLayout(weight);

        BeanValidationBinder<Person> binder = new BeanValidationBinder<>(WeightView.class);

        binder.bind(weight, "Weight");

        return new BinderCrudEditor<>(binder, form);
    }


    @Override
    protected void setupGrid(Grid<WeightData> grid) {
        grid.addColumn(WeightView::getWeight).setHeader("Person Name").setFlexGrow(10);
    }
}

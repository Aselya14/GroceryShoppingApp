package com.adjusted.vaadin.groceryapp.ui.views.weight;

import com.adjusted.vaadin.groceryapp.app.security.CurrentUser;
import com.adjusted.vaadin.groceryapp.backend.data.Role;
import com.adjusted.vaadin.groceryapp.backend.data.entity.WeightData;
import com.adjusted.vaadin.groceryapp.backend.service.WeightService;
import com.adjusted.vaadin.groceryapp.ui.MainView;
import com.adjusted.vaadin.groceryapp.ui.crud.AbstractBakeryCrudView;
import com.adjusted.vaadin.groceryapp.ui.utils.BakeryConst;
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


@Route(value = BakeryConst.PAGE_WEIGHT, layout = MainView.class)
@PageTitle(BakeryConst.TITLE_WEIGHT)
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

    private static BinderCrudEditor<WeightData> createForm() {
        TextField weight = new TextField("Weight");
        weight.getElement().setAttribute("colspan", "2");

        FormLayout form = new FormLayout(weight);

        BeanValidationBinder<WeightData> binder = new BeanValidationBinder<WeightData>(WeightData.class);

        binder.bind(weight, "Weight");

        return new BinderCrudEditor<>(binder, form);
    }


    @Override
    protected void setupGrid(Grid<WeightData> grid) {
        //grid.addColumn(WeightView::getWeight).setHeader("Person Name").setFlexGrow(10);
    }
}

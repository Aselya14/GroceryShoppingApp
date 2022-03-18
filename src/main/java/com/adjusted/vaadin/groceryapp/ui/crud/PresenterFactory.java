/**
 *
 */
package com.adjusted.vaadin.groceryapp.ui.crud;

import com.adjusted.vaadin.groceryapp.app.security.CurrentUser;
import com.adjusted.vaadin.groceryapp.backend.data.entity.Order;
import com.adjusted.vaadin.groceryapp.backend.service.OrderService;
import com.adjusted.vaadin.groceryapp.ui.views.storefront.StorefrontView;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class PresenterFactory {

	@Bean
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public EntityPresenter<Order, StorefrontView> orderEntityPresenter(OrderService crudService, CurrentUser currentUser) {
		return new EntityPresenter<>(crudService, currentUser);
	}

}

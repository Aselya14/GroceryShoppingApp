package com.adjusted.vaadin.groceryapp.app.security;

import com.adjusted.vaadin.groceryapp.backend.data.entity.User;

@FunctionalInterface
public interface CurrentUser {

	User getUser();
}

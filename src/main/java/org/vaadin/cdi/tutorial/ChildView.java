package org.vaadin.cdi.tutorial;

import com.vaadin.cdi.annotation.RouteScopeOwner;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.router.Route;

import javax.inject.Inject;

@Route(value = "child", layout = ParentView.class)
public class ChildView extends Label {

    @Inject
    public ChildView(@RouteScopeOwner(ParentView.class) RouteGreeter routeGreeter) {
        // it's the same RouteGreeter instance as in the ParentView class
        setText(routeGreeter.sayHello("Child View"));
    }

}

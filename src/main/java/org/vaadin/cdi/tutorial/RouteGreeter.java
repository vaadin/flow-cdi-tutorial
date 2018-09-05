package org.vaadin.cdi.tutorial;

import com.vaadin.cdi.annotation.NormalRouteScoped;
import com.vaadin.cdi.annotation.RouteScopeOwner;

import java.io.Serializable;

@NormalRouteScoped
@RouteScopeOwner(ParentView.class)
public class RouteGreeter implements Serializable {

    public String sayHello(String source) {
        return source + " says hello from route scoped bean " + toString();
    }

}

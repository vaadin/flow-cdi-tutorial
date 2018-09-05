/*
 * Copyright 2000-2017 Vaadin Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.vaadin.cdi.tutorial;

import com.vaadin.cdi.annotation.RouteScopeOwner;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasElement;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.dom.Style;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RoutePrefix;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.router.RouterLink;

import javax.inject.Inject;

@Route("")
@RoutePrefix("view")
public class ParentView extends Div implements RouterLayout {

    private final RouteGreeter routeGreeter;
    private final Div container;
    private final RouterLink link;

    @Inject
    public ParentView(UiGreeter uiGreeter,
                      @RouteScopeOwner(ParentView.class) RouteGreeter routeGreeter) {
        this.routeGreeter = routeGreeter;
        // it's the same UiGreeter instance as in the RootComponent class
        Label uiGreetingLabel = new Label(uiGreeter.sayHello());
        setStyleBlock(uiGreetingLabel);
        add(uiGreetingLabel);

        link = new RouterLink();
        setStyleBlock(link);
        add(link);

        container = new Div();
        Style containerStyle = container.getElement().getStyle();
        containerStyle.set("border", "1px solid black");
        containerStyle.set("padding", "10px");
        containerStyle.set("margin", "10px");
        add(container);

        showRouterLayoutContent(null);
    }

    private void setStyleBlock(Component component) {
        Style style = component.getElement().getStyle();
        style.set("display", "block");
        style.set("margin-bottom", "10px");
    }

    @Override
    public void showRouterLayoutContent(HasElement content) {
        container.removeAll();
        if (content != null) {
            link.setText("show parent view");
            link.setRoute(UI.getCurrent().getRouter(), ParentView.class);
            container.getElement().appendChild(content.getElement());
        } else {
            link.setText("show child view");
            link.setRoute(UI.getCurrent().getRouter(), ChildView.class);
            Label routeGreetingLabel = new Label();
            routeGreetingLabel.setText(routeGreeter.sayHello("Parent view"));
            container.add(routeGreetingLabel);
        }
    }

}

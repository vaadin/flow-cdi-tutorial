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

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.dom.Style;
import com.vaadin.flow.i18n.LocaleChangeEvent;
import com.vaadin.flow.i18n.LocaleChangeObserver;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;

import javax.inject.Inject;
import java.util.Locale;

@Route("")
public class RootComponent extends Div implements LocaleChangeObserver {

    private RouterLink link;

    @Inject
    public RootComponent(UiGreeter uiGreeter, ExampleTemplate template) {
        Label greeting = new Label(uiGreeter.sayHello());
        Style greetingStyle = greeting.getElement().getStyle();
        greetingStyle.set("display", "block");
        greetingStyle.set("margin-bottom", "10px");

        Button button = new Button("Switch language to Chinese",
                event -> getUI().get().setLocale(Locale.CHINESE));

        link = new RouterLink(
                getTranslation("root.navigate_to_component"),
                ParentView.class);

        Style linkStyle = link.getStyle();
        linkStyle.set("display", "block");
        linkStyle.set("margin-bottom", "10px");

        add(greeting, button, link, template);
    }

    @Override
    public void localeChange(LocaleChangeEvent event) {
        link.setText(
                getTranslation("root.navigate_to_component"));
    }

}

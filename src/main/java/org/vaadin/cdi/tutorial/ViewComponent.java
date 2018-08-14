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

import com.vaadin.cdi.annotation.UIScoped;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.router.Route;

import javax.inject.Inject;

@Route("view")
@UIScoped
public class ViewComponent extends Label {

    @Inject
    public ViewComponent(Greeter greeter) {
        // it's the same Greeter instance as in the RootComponent class
        setText(greeter.sayHello());
    }
}

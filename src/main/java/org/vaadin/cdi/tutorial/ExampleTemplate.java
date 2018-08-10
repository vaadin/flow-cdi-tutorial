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

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.templatemodel.TemplateModel;
import org.vaadin.cdi.tutorial.ExampleTemplate.ExampleModel;

import javax.inject.Inject;

/**
 * Simple template example.
 */
@Tag("example-template")
@HtmlImport("frontend://ExampleTemplate.html")
public class ExampleTemplate extends PolymerTemplate<ExampleModel> {

    /**
     * Template model which defines the single "name" property.
     */
    public static interface ExampleModel extends TemplateModel {

        void setMessage(String message);
    }

    @Inject
    public ExampleTemplate(Greeter bean) {
        // Set the initial value to the "message" property.
        getModel().setMessage(bean.sayHello());
    }
}

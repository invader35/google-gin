/*
 * Copyright 2008 Google Inc.
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
package com.google.gwt.inject.client;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * An annotation to put on {@code @Ginjector} subtypes to indicate which
 * {@code GinModule} implementations to use. List the {@link GinModule} classes
 * using the {@code value} parameter. If you wish to specify gin module classes
 * from a GWT module file, list the name of the configuration properties as 
 * string using the {@code properties} parameter.
 * 
 * <p>Example:
 * <pre>  @GinModules(value=MyGinModule.class, properties="example.ginModules")
 *  public interface ConfigurationModulesGinjector extends Ginjector {
 *    // ...
 *  }</pre>
 *  
 * In <b>MyApp.gwt.xml</b>:
 * <pre>  &lt;define-configuration-property name="example.ginModules" is-multi-valued="true" /&gt;
 *  &lt;extend-configuration-property name="example.ginModules"
 *      value="com.company.myapp.client.ExampleModule1" /&gt;
 *  &lt;extend-configuration-property name="example.ginModules"
 *      value="com.company.myapp.client.ExampleModule2" /&gt;</pre>
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface GinModules {
  Class<? extends GinModule>[] value();
  String[] properties() default {};
}

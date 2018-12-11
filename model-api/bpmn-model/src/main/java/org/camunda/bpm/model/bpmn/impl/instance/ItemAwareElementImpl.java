/*
 * Copyright © 2014-2018 camunda services GmbH and various authors (info@camunda.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.camunda.bpm.model.bpmn.impl.instance;

import org.camunda.bpm.model.bpmn.instance.BaseElement;
import org.camunda.bpm.model.bpmn.instance.DataState;
import org.camunda.bpm.model.bpmn.instance.ItemAwareElement;
import org.camunda.bpm.model.bpmn.instance.ItemDefinition;
import org.camunda.bpm.model.xml.ModelBuilder;
import org.camunda.bpm.model.xml.impl.instance.ModelTypeInstanceContext;
import org.camunda.bpm.model.xml.type.ModelElementTypeBuilder;
import org.camunda.bpm.model.xml.type.child.ChildElement;
import org.camunda.bpm.model.xml.type.child.SequenceBuilder;
import org.camunda.bpm.model.xml.type.reference.AttributeReference;

import static org.camunda.bpm.model.bpmn.impl.BpmnModelConstants.*;

/**
 * @author Sebastian Menski
 */
public abstract class ItemAwareElementImpl extends BaseElementImpl implements ItemAwareElement {

  protected static AttributeReference<ItemDefinition> itemSubjectRefAttribute;
  protected static ChildElement<DataState> dataStateChild;

  public static void registerType(ModelBuilder modelBuilder) {
    ModelElementTypeBuilder typeBuilder = modelBuilder.defineType(ItemAwareElement.class, BPMN_ELEMENT_ITEM_AWARE_ELEMENT)
      .namespaceUri(BPMN20_NS)
      .extendsType(BaseElement.class)
      .abstractType();

    itemSubjectRefAttribute = typeBuilder.stringAttribute(BPMN_ATTRIBUTE_ITEM_SUBJECT_REF)
      .qNameAttributeReference(ItemDefinition.class)
      .build();

    SequenceBuilder sequenceBuilder = typeBuilder.sequence();

    dataStateChild = sequenceBuilder.element(DataState.class)
      .build();

    typeBuilder.build();
  }

  public ItemAwareElementImpl(ModelTypeInstanceContext instanceContext) {
    super(instanceContext);
  }

  public ItemDefinition getItemSubject() {
    return itemSubjectRefAttribute.getReferenceTargetElement(this);
  }

  public void setItemSubject(ItemDefinition itemSubject) {
    itemSubjectRefAttribute.setReferenceTargetElement(this, itemSubject);
  }

  public DataState getDataState() {
    return dataStateChild.getChild(this);
  }

  public void setDataState(DataState dataState) {
    dataStateChild.setChild(this, dataState);
  }

}

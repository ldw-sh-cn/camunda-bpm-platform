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

import org.camunda.bpm.model.xml.ModelBuilder;
import org.camunda.bpm.model.xml.impl.instance.ModelTypeInstanceContext;
import org.camunda.bpm.model.xml.type.ModelElementTypeBuilder;

import static org.camunda.bpm.model.bpmn.impl.BpmnModelConstants.BPMN20_NS;
import static org.camunda.bpm.model.bpmn.impl.BpmnModelConstants.BPMN_ELEMENT_PARTICIPANT_REF;
import static org.camunda.bpm.model.xml.type.ModelElementTypeBuilder.ModelTypeInstanceProvider;

/**
 * The BPMN participantRef element of the BPMN tConversationNode type
 *
 * @author Sebastian Menski
 */
public class ParticipantRef extends BpmnModelElementInstanceImpl {

  public static void registerType(ModelBuilder modelBuilder) {
    ModelElementTypeBuilder typeBuilder = modelBuilder.defineType(ParticipantRef.class, BPMN_ELEMENT_PARTICIPANT_REF)
      .namespaceUri(BPMN20_NS)
      .instanceProvider(new ModelTypeInstanceProvider<ParticipantRef>() {
        public ParticipantRef newInstance(ModelTypeInstanceContext instanceContext) {
          return new ParticipantRef(instanceContext);
        }
      });

    typeBuilder.build();
  }

  public ParticipantRef(ModelTypeInstanceContext instanceContext) {
    super(instanceContext);
  }
}

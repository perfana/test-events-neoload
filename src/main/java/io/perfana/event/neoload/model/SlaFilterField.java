/*
 * Copyright (C) 2024 Peter Paul Bakker, Perfana
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
package io.perfana.event.neoload.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

/**
 * SLA filter
 */

@Schema(name = "SlaFilterField", description = "SLA filter")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-04-06T15:29:22.895694+02:00[Europe/Amsterdam]", comments = "Generator version: 7.4.0")
public class SlaFilterField {

  /**
   * Gets or Sets elementType
   */
  public enum ElementTypeEnum {
    SCENARIO("SCENARIO"),
    
    TRANSACTION("TRANSACTION"),
    
    PAGE("PAGE"),
    
    ACTION("ACTION"),
    
    REQUEST("REQUEST");

    private String value;

    ElementTypeEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static ElementTypeEnum fromValue(String value) {
      for (ElementTypeEnum b : ElementTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @Valid
  private Set<ElementTypeEnum> elementType;

  /**
   * Gets or Sets slaStatus
   */
  public enum SlaStatusEnum {
    SUCCESS("SUCCESS"),
    
    WARN("WARN"),
    
    FAILED("FAILED");

    private String value;

    SlaStatusEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static SlaStatusEnum fromValue(String value) {
      for (SlaStatusEnum b : SlaStatusEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @Valid
  private Set<SlaStatusEnum> slaStatus;

  public SlaFilterField elementType(Set<ElementTypeEnum> elementType) {
    this.elementType = elementType;
    return this;
  }

  public SlaFilterField addElementTypeItem(ElementTypeEnum elementTypeItem) {
    if (this.elementType == null) {
      this.elementType = new LinkedHashSet<>();
    }
    this.elementType.add(elementTypeItem);
    return this;
  }

  /**
   * Get elementType
   * @return elementType
  */
  
  @Schema(name = "elementType", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("elementType")
  public Set<ElementTypeEnum> getElementType() {
    return elementType;
  }

  @JsonDeserialize(as = LinkedHashSet.class)
  public void setElementType(Set<ElementTypeEnum> elementType) {
    this.elementType = elementType;
  }

  public SlaFilterField slaStatus(Set<SlaStatusEnum> slaStatus) {
    this.slaStatus = slaStatus;
    return this;
  }

  public SlaFilterField addSlaStatusItem(SlaStatusEnum slaStatusItem) {
    if (this.slaStatus == null) {
      this.slaStatus = new LinkedHashSet<>();
    }
    this.slaStatus.add(slaStatusItem);
    return this;
  }

  /**
   * Get slaStatus
   * @return slaStatus
  */
  
  @Schema(name = "slaStatus", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("slaStatus")
  public Set<SlaStatusEnum> getSlaStatus() {
    return slaStatus;
  }

  @JsonDeserialize(as = LinkedHashSet.class)
  public void setSlaStatus(Set<SlaStatusEnum> slaStatus) {
    this.slaStatus = slaStatus;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SlaFilterField slaFilterField = (SlaFilterField) o;
    return Objects.equals(this.elementType, slaFilterField.elementType) &&
        Objects.equals(this.slaStatus, slaFilterField.slaStatus);
  }

  @Override
  public int hashCode() {
    return Objects.hash(elementType, slaStatus);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SlaFilterField {\n");
    sb.append("    elementType: ").append(toIndentedString(elementType)).append("\n");
    sb.append("    slaStatus: ").append(toIndentedString(slaStatus)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}


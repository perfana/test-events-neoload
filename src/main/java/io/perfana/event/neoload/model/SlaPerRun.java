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
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

/**
 * Service Level Agreement per run
 */

@Schema(name = "SlaPerRun", description = "Service Level Agreement per run")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-04-06T15:29:22.895694+02:00[Europe/Amsterdam]", comments = "Generator version: 7.4.0")
public class SlaPerRun {

  private String elementId;

  private String elementName;

  /**
   * Type of element
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

  private ElementTypeEnum elementType;

  private String parentName;

  private SlaThreshold slaThreshold;

  /**
   * Status of SLA
   */
  public enum StatusEnum {
    SUCCESS("SUCCESS"),
    
    WARN("WARN"),
    
    FAILED("FAILED");

    private String value;

    StatusEnum(String value) {
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
    public static StatusEnum fromValue(String value) {
      for (StatusEnum b : StatusEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private StatusEnum status;

  private String userPathName;

  private Double value;

  public SlaPerRun() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public SlaPerRun(String elementId, String elementName, ElementTypeEnum elementType, String parentName, SlaThreshold slaThreshold, StatusEnum status, String userPathName, Double value) {
    this.elementId = elementId;
    this.elementName = elementName;
    this.elementType = elementType;
    this.parentName = parentName;
    this.slaThreshold = slaThreshold;
    this.status = status;
    this.userPathName = userPathName;
    this.value = value;
  }

  public SlaPerRun elementId(String elementId) {
    this.elementId = elementId;
    return this;
  }

  /**
   * Id of element
   * @return elementId
  */
  @NotNull 
  @Schema(name = "elementId", description = "Id of element", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("elementId")
  public String getElementId() {
    return elementId;
  }

  public void setElementId(String elementId) {
    this.elementId = elementId;
  }

  public SlaPerRun elementName(String elementName) {
    this.elementName = elementName;
    return this;
  }

  /**
   * Name of element
   * @return elementName
  */
  @NotNull 
  @Schema(name = "elementName", description = "Name of element", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("elementName")
  public String getElementName() {
    return elementName;
  }

  public void setElementName(String elementName) {
    this.elementName = elementName;
  }

  public SlaPerRun elementType(ElementTypeEnum elementType) {
    this.elementType = elementType;
    return this;
  }

  /**
   * Type of element
   * @return elementType
  */
  @NotNull 
  @Schema(name = "elementType", description = "Type of element", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("elementType")
  public ElementTypeEnum getElementType() {
    return elementType;
  }

  public void setElementType(ElementTypeEnum elementType) {
    this.elementType = elementType;
  }

  public SlaPerRun parentName(String parentName) {
    this.parentName = parentName;
    return this;
  }

  /**
   * Name of parent
   * @return parentName
  */
  @NotNull 
  @Schema(name = "parentName", description = "Name of parent", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("parentName")
  public String getParentName() {
    return parentName;
  }

  public void setParentName(String parentName) {
    this.parentName = parentName;
  }

  public SlaPerRun slaThreshold(SlaThreshold slaThreshold) {
    this.slaThreshold = slaThreshold;
    return this;
  }

  /**
   * Get slaThreshold
   * @return slaThreshold
  */
  @NotNull @Valid 
  @Schema(name = "slaThreshold", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("slaThreshold")
  public SlaThreshold getSlaThreshold() {
    return slaThreshold;
  }

  public void setSlaThreshold(SlaThreshold slaThreshold) {
    this.slaThreshold = slaThreshold;
  }

  public SlaPerRun status(StatusEnum status) {
    this.status = status;
    return this;
  }

  /**
   * Status of SLA
   * @return status
  */
  @NotNull 
  @Schema(name = "status", description = "Status of SLA", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("status")
  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  public SlaPerRun userPathName(String userPathName) {
    this.userPathName = userPathName;
    return this;
  }

  /**
   * Name of User path
   * @return userPathName
  */
  @NotNull 
  @Schema(name = "userPathName", description = "Name of User path", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("userPathName")
  public String getUserPathName() {
    return userPathName;
  }

  public void setUserPathName(String userPathName) {
    this.userPathName = userPathName;
  }

  public SlaPerRun value(Double value) {
    this.value = value;
    return this;
  }

  /**
   * Value of SLA
   * @return value
  */
  @NotNull 
  @Schema(name = "value", description = "Value of SLA", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("value")
  public Double getValue() {
    return value;
  }

  public void setValue(Double value) {
    this.value = value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SlaPerRun slaPerRun = (SlaPerRun) o;
    return Objects.equals(this.elementId, slaPerRun.elementId) &&
        Objects.equals(this.elementName, slaPerRun.elementName) &&
        Objects.equals(this.elementType, slaPerRun.elementType) &&
        Objects.equals(this.parentName, slaPerRun.parentName) &&
        Objects.equals(this.slaThreshold, slaPerRun.slaThreshold) &&
        Objects.equals(this.status, slaPerRun.status) &&
        Objects.equals(this.userPathName, slaPerRun.userPathName) &&
        Objects.equals(this.value, slaPerRun.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(elementId, elementName, elementType, parentName, slaThreshold, status, userPathName, value);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SlaPerRun {\n");
    sb.append("    elementId: ").append(toIndentedString(elementId)).append("\n");
    sb.append("    elementName: ").append(toIndentedString(elementName)).append("\n");
    sb.append("    elementType: ").append(toIndentedString(elementType)).append("\n");
    sb.append("    parentName: ").append(toIndentedString(parentName)).append("\n");
    sb.append("    slaThreshold: ").append(toIndentedString(slaThreshold)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    userPathName: ").append(toIndentedString(userPathName)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
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


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
 * Service Level Agreement per interval
 */

@Schema(name = "SlaPerInterval", description = "Service Level Agreement per interval")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-04-06T15:29:22.895694+02:00[Europe/Amsterdam]", comments = "Generator version: 7.4.0")
public class SlaPerInterval {

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

  private Double failPercentage;

  private String parentName;

  private String populationId;

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

  private String userPathId;

  private String userPathName;

  private Double warnPercentage;

  private String zoneId;

  public SlaPerInterval() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public SlaPerInterval(String elementId, String elementName, ElementTypeEnum elementType, Double failPercentage, String parentName, String populationId, SlaThreshold slaThreshold, StatusEnum status, String userPathId, String userPathName, Double warnPercentage, String zoneId) {
    this.elementId = elementId;
    this.elementName = elementName;
    this.elementType = elementType;
    this.failPercentage = failPercentage;
    this.parentName = parentName;
    this.populationId = populationId;
    this.slaThreshold = slaThreshold;
    this.status = status;
    this.userPathId = userPathId;
    this.userPathName = userPathName;
    this.warnPercentage = warnPercentage;
    this.zoneId = zoneId;
  }

  public SlaPerInterval elementId(String elementId) {
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

  public SlaPerInterval elementName(String elementName) {
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

  public SlaPerInterval elementType(ElementTypeEnum elementType) {
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

  public SlaPerInterval failPercentage(Double failPercentage) {
    this.failPercentage = failPercentage;
    return this;
  }

  /**
   * Percentage of intervals failed
   * @return failPercentage
  */
  @NotNull 
  @Schema(name = "failPercentage", description = "Percentage of intervals failed", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("failPercentage")
  public Double getFailPercentage() {
    return failPercentage;
  }

  public void setFailPercentage(Double failPercentage) {
    this.failPercentage = failPercentage;
  }

  public SlaPerInterval parentName(String parentName) {
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

  public SlaPerInterval populationId(String populationId) {
    this.populationId = populationId;
    return this;
  }

  /**
   * Id of population
   * @return populationId
  */
  @NotNull 
  @Schema(name = "populationId", description = "Id of population", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("populationId")
  public String getPopulationId() {
    return populationId;
  }

  public void setPopulationId(String populationId) {
    this.populationId = populationId;
  }

  public SlaPerInterval slaThreshold(SlaThreshold slaThreshold) {
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

  public SlaPerInterval status(StatusEnum status) {
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

  public SlaPerInterval userPathId(String userPathId) {
    this.userPathId = userPathId;
    return this;
  }

  /**
   * Id of User path
   * @return userPathId
  */
  @NotNull 
  @Schema(name = "userPathId", description = "Id of User path", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("userPathId")
  public String getUserPathId() {
    return userPathId;
  }

  public void setUserPathId(String userPathId) {
    this.userPathId = userPathId;
  }

  public SlaPerInterval userPathName(String userPathName) {
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

  public SlaPerInterval warnPercentage(Double warnPercentage) {
    this.warnPercentage = warnPercentage;
    return this;
  }

  /**
   * Percentage of intervals warning
   * @return warnPercentage
  */
  @NotNull 
  @Schema(name = "warnPercentage", description = "Percentage of intervals warning", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("warnPercentage")
  public Double getWarnPercentage() {
    return warnPercentage;
  }

  public void setWarnPercentage(Double warnPercentage) {
    this.warnPercentage = warnPercentage;
  }

  public SlaPerInterval zoneId(String zoneId) {
    this.zoneId = zoneId;
    return this;
  }

  /**
   * Id of zone
   * @return zoneId
  */
  @NotNull 
  @Schema(name = "zoneId", description = "Id of zone", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("zoneId")
  public String getZoneId() {
    return zoneId;
  }

  public void setZoneId(String zoneId) {
    this.zoneId = zoneId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SlaPerInterval slaPerInterval = (SlaPerInterval) o;
    return Objects.equals(this.elementId, slaPerInterval.elementId) &&
        Objects.equals(this.elementName, slaPerInterval.elementName) &&
        Objects.equals(this.elementType, slaPerInterval.elementType) &&
        Objects.equals(this.failPercentage, slaPerInterval.failPercentage) &&
        Objects.equals(this.parentName, slaPerInterval.parentName) &&
        Objects.equals(this.populationId, slaPerInterval.populationId) &&
        Objects.equals(this.slaThreshold, slaPerInterval.slaThreshold) &&
        Objects.equals(this.status, slaPerInterval.status) &&
        Objects.equals(this.userPathId, slaPerInterval.userPathId) &&
        Objects.equals(this.userPathName, slaPerInterval.userPathName) &&
        Objects.equals(this.warnPercentage, slaPerInterval.warnPercentage) &&
        Objects.equals(this.zoneId, slaPerInterval.zoneId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(elementId, elementName, elementType, failPercentage, parentName, populationId, slaThreshold, status, userPathId, userPathName, warnPercentage, zoneId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SlaPerInterval {\n");
    sb.append("    elementId: ").append(toIndentedString(elementId)).append("\n");
    sb.append("    elementName: ").append(toIndentedString(elementName)).append("\n");
    sb.append("    elementType: ").append(toIndentedString(elementType)).append("\n");
    sb.append("    failPercentage: ").append(toIndentedString(failPercentage)).append("\n");
    sb.append("    parentName: ").append(toIndentedString(parentName)).append("\n");
    sb.append("    populationId: ").append(toIndentedString(populationId)).append("\n");
    sb.append("    slaThreshold: ").append(toIndentedString(slaThreshold)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    userPathId: ").append(toIndentedString(userPathId)).append("\n");
    sb.append("    userPathName: ").append(toIndentedString(userPathName)).append("\n");
    sb.append("    warnPercentage: ").append(toIndentedString(warnPercentage)).append("\n");
    sb.append("    zoneId: ").append(toIndentedString(zoneId)).append("\n");
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


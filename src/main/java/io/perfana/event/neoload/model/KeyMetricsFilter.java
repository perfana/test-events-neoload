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
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

/**
 * A filter for querying the Statistics Values endpoint
 */

@Schema(name = "KeyMetricsFilter", description = "A filter for querying the Statistics Values endpoint")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-04-06T15:29:22.895694+02:00[Europe/Amsterdam]", comments = "Generator version: 7.4.0")
public class KeyMetricsFilter implements DashboardFilter {

  /**
   * Gets or Sets elementType
   */
  public enum ElementTypeEnum {
    REQUEST("REQUEST"),
    
    TRANSACTION("TRANSACTION");

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

  /**
   * Gets or Sets type
   */
  public enum TypeEnum {
    KEY_METRICS("KEY_METRICS");

    private String value;

    TypeEnum(String value) {
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
    public static TypeEnum fromValue(String value) {
      for (TypeEnum b : TypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private TypeEnum type;

  public KeyMetricsFilter() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public KeyMetricsFilter(ElementTypeEnum elementType, TypeEnum type) {
    this.elementType = elementType;
    this.type = type;
  }

  public KeyMetricsFilter elementType(ElementTypeEnum elementType) {
    this.elementType = elementType;
    return this;
  }

  /**
   * Get elementType
   * @return elementType
  */
  @NotNull 
  @Schema(name = "elementType", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("elementType")
  public ElementTypeEnum getElementType() {
    return elementType;
  }

  public void setElementType(ElementTypeEnum elementType) {
    this.elementType = elementType;
  }

  public KeyMetricsFilter type(TypeEnum type) {
    this.type = type;
    return this;
  }

  /**
   * Get type
   * @return type
  */
  
  @Schema(name = "type", accessMode = Schema.AccessMode.READ_ONLY, requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("type")
  public String getType() {
    return String.valueOf(type);
  }

  public void setType(TypeEnum type) {
    this.type = type;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    KeyMetricsFilter keyMetricsFilter = (KeyMetricsFilter) o;
    return Objects.equals(this.elementType, keyMetricsFilter.elementType) &&
        Objects.equals(this.type, keyMetricsFilter.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(elementType, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class KeyMetricsFilter {\n");
    sb.append("    elementType: ").append(toIndentedString(elementType)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
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


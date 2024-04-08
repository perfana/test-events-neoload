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
 * A filter for querying the Elements Values endpoint
 */

@Schema(name = "ElementsValuesFilter", description = "A filter for querying the Elements Values endpoint")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-04-06T15:29:22.895694+02:00[Europe/Amsterdam]", comments = "Generator version: 7.4.0")
public class ElementsValuesFilter implements DashboardFilter {

  /**
   * Gets or Sets elementType
   */
  public enum ElementTypeEnum {
    TRANSACTION("TRANSACTION"),
    
    PAGE("PAGE"),
    
    REQUEST("REQUEST"),
    
    ACTION("ACTION");

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

  private Integer pageSize;

  private String sort;

  /**
   * Gets or Sets type
   */
  public enum TypeEnum {
    ELEMENTS_VALUES("ELEMENTS_VALUES");

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

  public ElementsValuesFilter() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public ElementsValuesFilter(ElementTypeEnum elementType, Integer pageSize, String sort, TypeEnum type) {
    this.elementType = elementType;
    this.pageSize = pageSize;
    this.sort = sort;
    this.type = type;
  }

  public ElementsValuesFilter elementType(ElementTypeEnum elementType) {
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

  public ElementsValuesFilter pageSize(Integer pageSize) {
    this.pageSize = pageSize;
    return this;
  }

  /**
   * Get pageSize
   * @return pageSize
  */
  @NotNull 
  @Schema(name = "pageSize", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("pageSize")
  public Integer getPageSize() {
    return pageSize;
  }

  public void setPageSize(Integer pageSize) {
    this.pageSize = pageSize;
  }

  public ElementsValuesFilter sort(String sort) {
    this.sort = sort;
    return this;
  }

  /**
   * Get sort
   * @return sort
  */
  @NotNull 
  @Schema(name = "sort", example = "-maxDuration", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("sort")
  public String getSort() {
    return sort;
  }

  public void setSort(String sort) {
    this.sort = sort;
  }

  public ElementsValuesFilter type(TypeEnum type) {
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
    ElementsValuesFilter elementsValuesFilter = (ElementsValuesFilter) o;
    return Objects.equals(this.elementType, elementsValuesFilter.elementType) &&
        Objects.equals(this.pageSize, elementsValuesFilter.pageSize) &&
        Objects.equals(this.sort, elementsValuesFilter.sort) &&
        Objects.equals(this.type, elementsValuesFilter.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(elementType, pageSize, sort, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ElementsValuesFilter {\n");
    sb.append("    elementType: ").append(toIndentedString(elementType)).append("\n");
    sb.append("    pageSize: ").append(toIndentedString(pageSize)).append("\n");
    sb.append("    sort: ").append(toIndentedString(sort)).append("\n");
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


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
import jakarta.validation.constraints.Pattern;

import java.util.Objects;

/**
 * A filter for querying the Elements Timeseries endpoint
 */

@Schema(name = "ElementsTimeseriesFilter", description = "A filter for querying the Elements Timeseries endpoint")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-04-06T15:29:22.895694+02:00[Europe/Amsterdam]", comments = "Generator version: 7.4.0")
public class ElementsTimeseriesFilter implements DashboardFilter {

  private String elementId;

  /**
   * Gets or Sets type
   */
  public enum TypeEnum {
    ELEMENTS_TIMESERIES("ELEMENTS_TIMESERIES");

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

  private String userPathId;

  public ElementsTimeseriesFilter() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public ElementsTimeseriesFilter(String elementId, TypeEnum type) {
    this.elementId = elementId;
    this.type = type;
  }

  public ElementsTimeseriesFilter elementId(String elementId) {
    this.elementId = elementId;
    return this;
  }

  /**
   * Unique identifier representing a specific Element. <br>  Could be a UUID or one of the following: <br>  all-transaction <br> all-requests <br> all-pages <br> all-actions <br> init-container <br> actions-container <br> end-container <br> 
   * @return elementId
  */
  @NotNull @Pattern(regexp = "^[0-9a-fA-F]{8}-([0-9a-fA-F]{4}-){3}[0-9a-fA-F]{12}$|all-transactions|all-pages|all-requests|all-actions|init-container|actions-container|end-container") 
  @Schema(name = "elementId", example = "all-transactions", description = "Unique identifier representing a specific Element. <br>  Could be a UUID or one of the following: <br>  all-transaction <br> all-requests <br> all-pages <br> all-actions <br> init-container <br> actions-container <br> end-container <br> ", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("elementId")
  public String getElementId() {
    return elementId;
  }

  public void setElementId(String elementId) {
    this.elementId = elementId;
  }

  public ElementsTimeseriesFilter type(TypeEnum type) {
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

  public ElementsTimeseriesFilter userPathId(String userPathId) {
    this.userPathId = userPathId;
    return this;
  }

  /**
   * Get userPathId
   * @return userPathId
  */
  
  @Schema(name = "userPathId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("userPathId")
  public String getUserPathId() {
    return userPathId;
  }

  public void setUserPathId(String userPathId) {
    this.userPathId = userPathId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ElementsTimeseriesFilter elementsTimeseriesFilter = (ElementsTimeseriesFilter) o;
    return Objects.equals(this.elementId, elementsTimeseriesFilter.elementId) &&
        Objects.equals(this.type, elementsTimeseriesFilter.type) &&
        Objects.equals(this.userPathId, elementsTimeseriesFilter.userPathId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(elementId, type, userPathId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ElementsTimeseriesFilter {\n");
    sb.append("    elementId: ").append(toIndentedString(elementId)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    userPathId: ").append(toIndentedString(userPathId)).append("\n");
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


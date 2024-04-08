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
 * A filter for querying the Events Tops
 */

@Schema(name = "ErrorsCountFilter", description = "A filter for querying the Events Tops")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-04-06T15:29:22.895694+02:00[Europe/Amsterdam]", comments = "Generator version: 7.4.0")
public class ErrorsCountFilter implements DashboardFilter {

  /**
   * Aggregation type
   */
  public enum AggregationTypeEnum {
    CODE("CODE"),
    
    LG_NAME("LG_NAME"),
    
    ELEMENT_ID("ELEMENT_ID");

    private String value;

    AggregationTypeEnum(String value) {
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
    public static AggregationTypeEnum fromValue(String value) {
      for (AggregationTypeEnum b : AggregationTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private AggregationTypeEnum aggregationType;

  private Integer pageNumber;

  private Integer pageSize;

  private String sort = "+count";

  /**
   * Gets or Sets type
   */
  public enum TypeEnum {
    ERRORS_COUNT("ERRORS_COUNT");

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

  public ErrorsCountFilter() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public ErrorsCountFilter(AggregationTypeEnum aggregationType, Integer pageNumber, Integer pageSize, String sort, TypeEnum type) {
    this.aggregationType = aggregationType;
    this.pageNumber = pageNumber;
    this.pageSize = pageSize;
    this.sort = sort;
    this.type = type;
  }

  public ErrorsCountFilter aggregationType(AggregationTypeEnum aggregationType) {
    this.aggregationType = aggregationType;
    return this;
  }

  /**
   * Aggregation type
   * @return aggregationType
  */
  @NotNull 
  @Schema(name = "aggregationType", description = "Aggregation type", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("aggregationType")
  public AggregationTypeEnum getAggregationType() {
    return aggregationType;
  }

  public void setAggregationType(AggregationTypeEnum aggregationType) {
    this.aggregationType = aggregationType;
  }

  public ErrorsCountFilter pageNumber(Integer pageNumber) {
    this.pageNumber = pageNumber;
    return this;
  }

  /**
   * Page number
   * @return pageNumber
  */
  @NotNull 
  @Schema(name = "pageNumber", description = "Page number", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("pageNumber")
  public Integer getPageNumber() {
    return pageNumber;
  }

  public void setPageNumber(Integer pageNumber) {
    this.pageNumber = pageNumber;
  }

  public ErrorsCountFilter pageSize(Integer pageSize) {
    this.pageSize = pageSize;
    return this;
  }

  /**
   * Page size
   * @return pageSize
  */
  @NotNull 
  @Schema(name = "pageSize", description = "Page size", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("pageSize")
  public Integer getPageSize() {
    return pageSize;
  }

  public void setPageSize(Integer pageSize) {
    this.pageSize = pageSize;
  }

  public ErrorsCountFilter sort(String sort) {
    this.sort = sort;
    return this;
  }

  /**
   * Update in which order the elements are returned, by default elements are sorted with count in ascending order, sort configuration is done by writing the field name prefixed with a + or a - for ascending or descending order Available fields are: parent, code, count, userpath, lg, element
   * @return sort
  */
  @NotNull @Pattern(regexp = "^(\\+|\\-)(parent|code|count|userpath|lg|element){1}$") 
  @Schema(name = "sort", example = "+count", description = "Update in which order the elements are returned, by default elements are sorted with count in ascending order, sort configuration is done by writing the field name prefixed with a + or a - for ascending or descending order Available fields are: parent, code, count, userpath, lg, element", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("sort")
  public String getSort() {
    return sort;
  }

  public void setSort(String sort) {
    this.sort = sort;
  }

  public ErrorsCountFilter type(TypeEnum type) {
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
    ErrorsCountFilter errorsCountFilter = (ErrorsCountFilter) o;
    return Objects.equals(this.aggregationType, errorsCountFilter.aggregationType) &&
        Objects.equals(this.pageNumber, errorsCountFilter.pageNumber) &&
        Objects.equals(this.pageSize, errorsCountFilter.pageSize) &&
        Objects.equals(this.sort, errorsCountFilter.sort) &&
        Objects.equals(this.type, errorsCountFilter.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(aggregationType, pageNumber, pageSize, sort, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ErrorsCountFilter {\n");
    sb.append("    aggregationType: ").append(toIndentedString(aggregationType)).append("\n");
    sb.append("    pageNumber: ").append(toIndentedString(pageNumber)).append("\n");
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


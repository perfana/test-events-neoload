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
import jakarta.validation.constraints.Pattern;

import java.util.Objects;

/**
 * A filter for querying the SLA Tops
 */

@Schema(name = "DashboardSlaFilter", description = "A filter for querying the SLA Tops")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-04-06T15:29:22.895694+02:00[Europe/Amsterdam]", comments = "Generator version: 7.4.0")
public class DashboardSlaFilter implements DashboardFilter {

  private SlaFilterField filter;

  private Integer pageSize;

  private String sort = "+elementName";

  /**
   * Gets or Sets type
   */
  public enum TypeEnum {
    SLA_PER_INTERVAL("SLA_PER_INTERVAL");

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

  public DashboardSlaFilter() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public DashboardSlaFilter(SlaFilterField filter, Integer pageSize, String sort, TypeEnum type) {
    this.filter = filter;
    this.pageSize = pageSize;
    this.sort = sort;
    this.type = type;
  }

  public DashboardSlaFilter filter(SlaFilterField filter) {
    this.filter = filter;
    return this;
  }

  /**
   * Get filter
   * @return filter
  */
  @NotNull @Valid 
  @Schema(name = "filter", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("filter")
  public SlaFilterField getFilter() {
    return filter;
  }

  public void setFilter(SlaFilterField filter) {
    this.filter = filter;
  }

  public DashboardSlaFilter pageSize(Integer pageSize) {
    this.pageSize = pageSize;
    return this;
  }

  /**
   * SLA page size
   * @return pageSize
  */
  @NotNull 
  @Schema(name = "pageSize", description = "SLA page size", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("pageSize")
  public Integer getPageSize() {
    return pageSize;
  }

  public void setPageSize(Integer pageSize) {
    this.pageSize = pageSize;
  }

  public DashboardSlaFilter sort(String sort) {
    this.sort = sort;
    return this;
  }

  /**
   * Update in which order the elements are returned, by default elements are sorted with elementName in ascending order, sort configuration is done by writing the field name prefixed with a + or a - for ascending or descending order Available fields are: userPathName, slaStatus, parentName, failPercentage, elementType, value, warnPercentage, elementName
   * @return sort
  */
  @NotNull @Pattern(regexp = "^(\\+|\\-)(userPathName|slaStatus|parentName|failPercentage|elementType|value|warnPercentage|elementName){1}$") 
  @Schema(name = "sort", example = "+elementName", description = "Update in which order the elements are returned, by default elements are sorted with elementName in ascending order, sort configuration is done by writing the field name prefixed with a + or a - for ascending or descending order Available fields are: userPathName, slaStatus, parentName, failPercentage, elementType, value, warnPercentage, elementName", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("sort")
  public String getSort() {
    return sort;
  }

  public void setSort(String sort) {
    this.sort = sort;
  }

  public DashboardSlaFilter type(TypeEnum type) {
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
    DashboardSlaFilter dashboardSlaFilter = (DashboardSlaFilter) o;
    return Objects.equals(this.filter, dashboardSlaFilter.filter) &&
        Objects.equals(this.pageSize, dashboardSlaFilter.pageSize) &&
        Objects.equals(this.sort, dashboardSlaFilter.sort) &&
        Objects.equals(this.type, dashboardSlaFilter.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(filter, pageSize, sort, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DashboardSlaFilter {\n");
    sb.append("    filter: ").append(toIndentedString(filter)).append("\n");
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


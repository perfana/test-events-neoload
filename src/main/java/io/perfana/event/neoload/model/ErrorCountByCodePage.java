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
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Number of errors by error code
 */

@Schema(name = "ErrorCountByCodePage", description = "Number of errors by error code")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-04-06T15:29:22.895694+02:00[Europe/Amsterdam]", comments = "Generator version: 7.4.0")
public class ErrorCountByCodePage implements ErrorsPage {

  @Valid
  private List<@Valid ErrorCountByCode> items = new ArrayList<>();

  private Long total;

  private Integer pageNumber = 0;

  private Integer pageSize = 25;

  /**
   * Gets or Sets type
   */
  public enum TypeEnum {
    LG("LG"),
    
    ELEMENT("ELEMENT"),
    
    CODE("CODE");

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

  public ErrorCountByCodePage() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public ErrorCountByCodePage(List<@Valid ErrorCountByCode> items, Long total) {
    this.items = items;
    this.total = total;
  }

  public ErrorCountByCodePage items(List<@Valid ErrorCountByCode> items) {
    this.items = items;
    return this;
  }

  public ErrorCountByCodePage addItemsItem(ErrorCountByCode itemsItem) {
    if (this.items == null) {
      this.items = new ArrayList<>();
    }
    this.items.add(itemsItem);
    return this;
  }

  /**
   * Items in the page
   * @return items
  */
  @NotNull @Valid 
  @Schema(name = "items", description = "Items in the page", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("items")
  public List<@Valid ErrorCountByCode> getItems() {
    return items;
  }

  public void setItems(List<@Valid ErrorCountByCode> items) {
    this.items = items;
  }

  public ErrorCountByCodePage total(Long total) {
    this.total = total;
    return this;
  }

  /**
   * Total items
   * @return total
  */
  @NotNull 
  @Schema(name = "total", description = "Total items", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("total")
  public Long getTotal() {
    return total;
  }

  public void setTotal(Long total) {
    this.total = total;
  }

  public ErrorCountByCodePage pageNumber(Integer pageNumber) {
    this.pageNumber = pageNumber;
    return this;
  }

  /**
   * The page number
   * @return pageNumber
  */
  
  @Schema(name = "pageNumber", description = "The page number", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("pageNumber")
  public Integer getPageNumber() {
    return pageNumber;
  }

  public void setPageNumber(Integer pageNumber) {
    this.pageNumber = pageNumber;
  }

  public ErrorCountByCodePage pageSize(Integer pageSize) {
    this.pageSize = pageSize;
    return this;
  }

  /**
   * The number of items per page
   * minimum: 1
   * maximum: 200
   * @return pageSize
  */
  @Min(1) @Max(200) 
  @Schema(name = "pageSize", description = "The number of items per page", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("pageSize")
  public Integer getPageSize() {
    return pageSize;
  }

  public void setPageSize(Integer pageSize) {
    this.pageSize = pageSize;
  }

  public ErrorCountByCodePage type(TypeEnum type) {
    this.type = type;
    return this;
  }

  /**
   * Get type
   *
   * @return type
   */
  
  @Schema(name = "type", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
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
    ErrorCountByCodePage errorCountByCodePage = (ErrorCountByCodePage) o;
    return Objects.equals(this.items, errorCountByCodePage.items) &&
        Objects.equals(this.total, errorCountByCodePage.total) &&
        Objects.equals(this.pageNumber, errorCountByCodePage.pageNumber) &&
        Objects.equals(this.pageSize, errorCountByCodePage.pageSize) &&
        Objects.equals(this.type, errorCountByCodePage.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(items, total, pageNumber, pageSize, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ErrorCountByCodePage {\n");
    sb.append("    items: ").append(toIndentedString(items)).append("\n");
    sb.append("    total: ").append(toIndentedString(total)).append("\n");
    sb.append("    pageNumber: ").append(toIndentedString(pageNumber)).append("\n");
    sb.append("    pageSize: ").append(toIndentedString(pageSize)).append("\n");
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


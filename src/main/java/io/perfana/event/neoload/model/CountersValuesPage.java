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

import com.fasterxml.jackson.annotation.JsonProperty;
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
 * The response to the get Test Result Counters values
 */

@Schema(name = "CountersValuesPage", description = "The response to the get Test Result Counters values")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-04-06T15:29:22.895694+02:00[Europe/Amsterdam]", comments = "Generator version: 7.4.0")
public class CountersValuesPage {

  @Valid
  private List<@Valid CounterValues> items = new ArrayList<>();

  private Long total;

  private Integer pageNumber = 0;

  private Integer pageSize = 25;

  public CountersValuesPage() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public CountersValuesPage(List<@Valid CounterValues> items, Long total) {
    this.items = items;
    this.total = total;
  }

  public CountersValuesPage items(List<@Valid CounterValues> items) {
    this.items = items;
    return this;
  }

  public CountersValuesPage addItemsItem(CounterValues itemsItem) {
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
  public List<@Valid CounterValues> getItems() {
    return items;
  }

  public void setItems(List<@Valid CounterValues> items) {
    this.items = items;
  }

  public CountersValuesPage total(Long total) {
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

  public CountersValuesPage pageNumber(Integer pageNumber) {
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

  public CountersValuesPage pageSize(Integer pageSize) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CountersValuesPage countersValuesPage = (CountersValuesPage) o;
    return Objects.equals(this.items, countersValuesPage.items) &&
        Objects.equals(this.total, countersValuesPage.total) &&
        Objects.equals(this.pageNumber, countersValuesPage.pageNumber) &&
        Objects.equals(this.pageSize, countersValuesPage.pageSize);
  }

  @Override
  public int hashCode() {
    return Objects.hash(items, total, pageNumber, pageSize);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CountersValuesPage {\n");
    sb.append("    items: ").append(toIndentedString(items)).append("\n");
    sb.append("    total: ").append(toIndentedString(total)).append("\n");
    sb.append("    pageNumber: ").append(toIndentedString(pageNumber)).append("\n");
    sb.append("    pageSize: ").append(toIndentedString(pageSize)).append("\n");
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


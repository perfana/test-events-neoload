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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Represents a dashboard tiles coordinates modification.
 */

@Schema(name = "DashboardTilesPatchAllRequest", description = "Represents a dashboard tiles coordinates modification.")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-04-06T15:29:22.895694+02:00[Europe/Amsterdam]", comments = "Generator version: 7.4.0")
public class DashboardTilesPatchAllRequest {

  @Valid
  private List<@Valid DashboardTilesPatchAllRequestItem> items;

  public DashboardTilesPatchAllRequest items(List<@Valid DashboardTilesPatchAllRequestItem> items) {
    this.items = items;
    return this;
  }

  public DashboardTilesPatchAllRequest addItemsItem(DashboardTilesPatchAllRequestItem itemsItem) {
    if (this.items == null) {
      this.items = new ArrayList<>();
    }
    this.items.add(itemsItem);
    return this;
  }

  /**
   * Tiles with coordinates
   * @return items
  */
  @Valid 
  @Schema(name = "items", description = "Tiles with coordinates", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("items")
  public List<@Valid DashboardTilesPatchAllRequestItem> getItems() {
    return items;
  }

  public void setItems(List<@Valid DashboardTilesPatchAllRequestItem> items) {
    this.items = items;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DashboardTilesPatchAllRequest dashboardTilesPatchAllRequest = (DashboardTilesPatchAllRequest) o;
    return Objects.equals(this.items, dashboardTilesPatchAllRequest.items);
  }

  @Override
  public int hashCode() {
    return Objects.hash(items);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DashboardTilesPatchAllRequest {\n");
    sb.append("    items: ").append(toIndentedString(items)).append("\n");
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


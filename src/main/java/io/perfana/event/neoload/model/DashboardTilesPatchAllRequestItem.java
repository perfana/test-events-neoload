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
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.util.Objects;

/**
 * A dashboard tile with updated coordinates.
 */

@Schema(name = "DashboardTilesPatchAllRequestItem", description = "A dashboard tile with updated coordinates.")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-04-06T15:29:22.895694+02:00[Europe/Amsterdam]", comments = "Generator version: 7.4.0")
public class DashboardTilesPatchAllRequestItem {

  private String id;

  private Integer height = 1;

  private Integer width = 1;

  private Integer x;

  private Integer y;

  public DashboardTilesPatchAllRequestItem() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public DashboardTilesPatchAllRequestItem(String id, Integer height, Integer width, Integer x, Integer y) {
    this.id = id;
    this.height = height;
    this.width = width;
    this.x = x;
    this.y = y;
  }

  public DashboardTilesPatchAllRequestItem id(String id) {
    this.id = id;
    return this;
  }

  /**
   * ID
   * @return id
  */
  @NotNull @Pattern(regexp = "^[0-9a-f]{24}$") 
  @Schema(name = "id", example = "69c9a277bb9a473ca3d0d567", description = "ID", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("id")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public DashboardTilesPatchAllRequestItem height(Integer height) {
    this.height = height;
    return this;
  }

  /**
   * Get height
   * minimum: 1
   * maximum: 100
   * @return height
  */
  @NotNull @Min(1) @Max(100) 
  @Schema(name = "height", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("height")
  public Integer getHeight() {
    return height;
  }

  public void setHeight(Integer height) {
    this.height = height;
  }

  public DashboardTilesPatchAllRequestItem width(Integer width) {
    this.width = width;
    return this;
  }

  /**
   * Get width
   * minimum: 1
   * maximum: 100
   * @return width
  */
  @NotNull @Min(1) @Max(100) 
  @Schema(name = "width", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("width")
  public Integer getWidth() {
    return width;
  }

  public void setWidth(Integer width) {
    this.width = width;
  }

  public DashboardTilesPatchAllRequestItem x(Integer x) {
    this.x = x;
    return this;
  }

  /**
   * Get x
   * minimum: 0
   * @return x
  */
  @NotNull @Min(0) 
  @Schema(name = "x", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("x")
  public Integer getX() {
    return x;
  }

  public void setX(Integer x) {
    this.x = x;
  }

  public DashboardTilesPatchAllRequestItem y(Integer y) {
    this.y = y;
    return this;
  }

  /**
   * Get y
   * minimum: 0
   * @return y
  */
  @NotNull @Min(0) 
  @Schema(name = "y", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("y")
  public Integer getY() {
    return y;
  }

  public void setY(Integer y) {
    this.y = y;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DashboardTilesPatchAllRequestItem dashboardTilesPatchAllRequestItem = (DashboardTilesPatchAllRequestItem) o;
    return Objects.equals(this.id, dashboardTilesPatchAllRequestItem.id) &&
        Objects.equals(this.height, dashboardTilesPatchAllRequestItem.height) &&
        Objects.equals(this.width, dashboardTilesPatchAllRequestItem.width) &&
        Objects.equals(this.x, dashboardTilesPatchAllRequestItem.x) &&
        Objects.equals(this.y, dashboardTilesPatchAllRequestItem.y);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, height, width, x, y);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DashboardTilesPatchAllRequestItem {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    height: ").append(toIndentedString(height)).append("\n");
    sb.append("    width: ").append(toIndentedString(width)).append("\n");
    sb.append("    x: ").append(toIndentedString(x)).append("\n");
    sb.append("    y: ").append(toIndentedString(y)).append("\n");
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


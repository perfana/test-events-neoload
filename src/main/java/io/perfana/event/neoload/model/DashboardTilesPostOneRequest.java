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
import jakarta.validation.constraints.Size;

import java.util.Objects;

/**
 * Fields for creating a Dashboard tile
 */

@Schema(name = "DashboardTilesPostOneRequest", description = "Fields for creating a Dashboard tile")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-04-06T15:29:22.895694+02:00[Europe/Amsterdam]", comments = "Generator version: 7.4.0")
public class DashboardTilesPostOneRequest {

  private Integer height = 1;

  private String title;

  private Integer width = 1;

  private Integer x;

  private Integer y;

  public DashboardTilesPostOneRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public DashboardTilesPostOneRequest(Integer height, String title, Integer width, Integer x, Integer y) {
    this.height = height;
    this.title = title;
    this.width = width;
    this.x = x;
    this.y = y;
  }

  public DashboardTilesPostOneRequest height(Integer height) {
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

  public DashboardTilesPostOneRequest title(String title) {
    this.title = title;
    return this;
  }

  /**
   * Get title
   * @return title
  */
  @NotNull @Size(max = 80) 
  @Schema(name = "title", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("title")
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public DashboardTilesPostOneRequest width(Integer width) {
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

  public DashboardTilesPostOneRequest x(Integer x) {
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

  public DashboardTilesPostOneRequest y(Integer y) {
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
    DashboardTilesPostOneRequest dashboardTilesPostOneRequest = (DashboardTilesPostOneRequest) o;
    return Objects.equals(this.height, dashboardTilesPostOneRequest.height) &&
        Objects.equals(this.title, dashboardTilesPostOneRequest.title) &&
        Objects.equals(this.width, dashboardTilesPostOneRequest.width) &&
        Objects.equals(this.x, dashboardTilesPostOneRequest.x) &&
        Objects.equals(this.y, dashboardTilesPostOneRequest.y);
  }

  @Override
  public int hashCode() {
    return Objects.hash(height, title, width, x, y);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DashboardTilesPostOneRequest {\n");
    sb.append("    height: ").append(toIndentedString(height)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
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


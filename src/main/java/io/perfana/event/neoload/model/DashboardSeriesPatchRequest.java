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
import jakarta.validation.constraints.Pattern;

import java.util.Objects;

/**
 * DashboardSeriesPatchRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-04-06T15:29:22.895694+02:00[Europe/Amsterdam]", comments = "Generator version: 7.4.0")
public class DashboardSeriesPatchRequest {

  private String color;

  private Boolean visible;

  public DashboardSeriesPatchRequest color(String color) {
    this.color = color;
    return this;
  }

  /**
   * The color of the series.
   * @return color
  */
  @Pattern(regexp = "^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$") 
  @Schema(name = "color", example = "#F00", description = "The color of the series.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("color")
  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public DashboardSeriesPatchRequest visible(Boolean visible) {
    this.visible = visible;
    return this;
  }

  /**
   * Defines whether the series should be displayed or hidden.
   * @return visible
  */
  
  @Schema(name = "visible", description = "Defines whether the series should be displayed or hidden.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("visible")
  public Boolean getVisible() {
    return visible;
  }

  public void setVisible(Boolean visible) {
    this.visible = visible;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DashboardSeriesPatchRequest dashboardSeriesPatchRequest = (DashboardSeriesPatchRequest) o;
    return Objects.equals(this.color, dashboardSeriesPatchRequest.color) &&
        Objects.equals(this.visible, dashboardSeriesPatchRequest.visible);
  }

  @Override
  public int hashCode() {
    return Objects.hash(color, visible);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DashboardSeriesPatchRequest {\n");
    sb.append("    color: ").append(toIndentedString(color)).append("\n");
    sb.append("    visible: ").append(toIndentedString(visible)).append("\n");
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


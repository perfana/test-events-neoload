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
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

/**
 * Point of an Monitor Timeseries
 */

@Schema(name = "MonitorPoint", description = "Point of an Monitor Timeseries")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-04-06T15:29:22.895694+02:00[Europe/Amsterdam]", comments = "Generator version: 7.4.0")
public class MonitorPoint {

  private String offset;

  private Double value;

  public MonitorPoint() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public MonitorPoint(String offset, Double value) {
    this.offset = offset;
    this.value = value;
  }

  public MonitorPoint offset(String offset) {
    this.offset = offset;
    return this;
  }

  /**
   * Offset relative to the result start date (ISO 8601 format).
   * @return offset
  */
  @NotNull 
  @Schema(name = "offset", example = "PT1S", description = "Offset relative to the result start date (ISO 8601 format).", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("offset")
  public String getOffset() {
    return offset;
  }

  public void setOffset(String offset) {
    this.offset = offset;
  }

  public MonitorPoint value(Double value) {
    this.value = value;
    return this;
  }

  /**
   * Value of the monitor in the time range.
   * @return value
  */
  @NotNull 
  @Schema(name = "value", example = "0.357", description = "Value of the monitor in the time range.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("value")
  public Double getValue() {
    return value;
  }

  public void setValue(Double value) {
    this.value = value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MonitorPoint monitorPoint = (MonitorPoint) o;
    return Objects.equals(this.offset, monitorPoint.offset) &&
        Objects.equals(this.value, monitorPoint.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(offset, value);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MonitorPoint {\n");
    sb.append("    offset: ").append(toIndentedString(offset)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
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


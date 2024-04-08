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
 * A filter for querying the Monitors Timeseries endpoint
 */

@Schema(name = "MonitorsTimeseriesFilter", description = "A filter for querying the Monitors Timeseries endpoint")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-04-06T15:29:22.895694+02:00[Europe/Amsterdam]", comments = "Generator version: 7.4.0")
public class MonitorsTimeseriesFilter implements DashboardFilter {

  private String monitorId;

  /**
   * Gets or Sets type
   */
  public enum TypeEnum {
    MONITORS_TIMESERIES("MONITORS_TIMESERIES");

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

  public MonitorsTimeseriesFilter() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public MonitorsTimeseriesFilter(String monitorId, TypeEnum type) {
    this.monitorId = monitorId;
    this.type = type;
  }

  public MonitorsTimeseriesFilter monitorId(String monitorId) {
    this.monitorId = monitorId;
    return this;
  }

  /**
   * ID
   * @return monitorId
  */
  @NotNull @Pattern(regexp = "^[0-9a-fA-F]{8}-([0-9a-fA-F]{4}-){3}[0-9a-fA-F]{12}$") 
  @Schema(name = "monitorId", example = "123e4567-e89b-12d3-a456-426655440000", description = "ID", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("monitorId")
  public String getMonitorId() {
    return monitorId;
  }

  public void setMonitorId(String monitorId) {
    this.monitorId = monitorId;
  }

  public MonitorsTimeseriesFilter type(TypeEnum type) {
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
    MonitorsTimeseriesFilter monitorsTimeseriesFilter = (MonitorsTimeseriesFilter) o;
    return Objects.equals(this.monitorId, monitorsTimeseriesFilter.monitorId) &&
        Objects.equals(this.type, monitorsTimeseriesFilter.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(monitorId, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MonitorsTimeseriesFilter {\n");
    sb.append("    monitorId: ").append(toIndentedString(monitorId)).append("\n");
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


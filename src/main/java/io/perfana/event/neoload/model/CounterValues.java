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
import jakarta.validation.constraints.Pattern;

import java.util.Objects;

/**
 * An item of category COUNTER with its values
 */

@Schema(name = "CounterValues", description = "An item of category COUNTER with its values")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-04-06T15:29:22.895694+02:00[Europe/Amsterdam]", comments = "Generator version: 7.4.0")
public class CounterValues {

  private String id;

  private String name;

  private Double avg;

  private Double max;

  private Double min;

  public CounterValues() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public CounterValues(String id, String name) {
    this.id = id;
    this.name = name;
  }

  public CounterValues id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Counter unique identifier.
   * @return id
  */
  @NotNull @Pattern(regexp = "^[0-9a-fA-F]{8}-([0-9a-fA-F]{4}-){3}[0-9a-fA-F]{12}$") 
  @Schema(name = "id", example = "123e4567-e89b-12d3-a456-426655440000", description = "Counter unique identifier.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("id")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public CounterValues name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Counter name.
   * @return name
  */
  @NotNull 
  @Schema(name = "name", example = "my counter", description = "Counter name.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public CounterValues avg(Double avg) {
    this.avg = avg;
    return this;
  }

  /**
   * Average of values for the counter.
   * @return avg
  */
  
  @Schema(name = "avg", example = "3.5", description = "Average of values for the counter.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("avg")
  public Double getAvg() {
    return avg;
  }

  public void setAvg(Double avg) {
    this.avg = avg;
  }

  public CounterValues max(Double max) {
    this.max = max;
    return this;
  }

  /**
   * Maximum value for the counter.
   * @return max
  */
  
  @Schema(name = "max", example = "6.123", description = "Maximum value for the counter.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("max")
  public Double getMax() {
    return max;
  }

  public void setMax(Double max) {
    this.max = max;
  }

  public CounterValues min(Double min) {
    this.min = min;
    return this;
  }

  /**
   * Minimum value for the counter.
   * @return min
  */
  
  @Schema(name = "min", example = "2.1", description = "Minimum value for the counter.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("min")
  public Double getMin() {
    return min;
  }

  public void setMin(Double min) {
    this.min = min;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CounterValues counterValues = (CounterValues) o;
    return Objects.equals(this.id, counterValues.id) &&
        Objects.equals(this.name, counterValues.name) &&
        Objects.equals(this.avg, counterValues.avg) &&
        Objects.equals(this.max, counterValues.max) &&
        Objects.equals(this.min, counterValues.min);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, avg, max, min);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CounterValues {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    avg: ").append(toIndentedString(avg)).append("\n");
    sb.append("    max: ").append(toIndentedString(max)).append("\n");
    sb.append("    min: ").append(toIndentedString(min)).append("\n");
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


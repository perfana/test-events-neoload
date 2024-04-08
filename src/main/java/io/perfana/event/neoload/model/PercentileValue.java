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
 * PercentileValue
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-04-06T15:29:22.895694+02:00[Europe/Amsterdam]", comments = "Generator version: 7.4.0")
public class PercentileValue {

  private Double percentile;

  private Double value;

  public PercentileValue() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public PercentileValue(Double percentile, Double value) {
    this.percentile = percentile;
    this.value = value;
  }

  public PercentileValue percentile(Double percentile) {
    this.percentile = percentile;
    return this;
  }

  /**
   * The percentile
   * @return percentile
  */
  @NotNull 
  @Schema(name = "percentile", example = "5.0", description = "The percentile", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("percentile")
  public Double getPercentile() {
    return percentile;
  }

  public void setPercentile(Double percentile) {
    this.percentile = percentile;
  }

  public PercentileValue value(Double value) {
    this.value = value;
    return this;
  }

  /**
   * The duration in milliseconds, with a 0.1 accuracy
   * @return value
  */
  @NotNull 
  @Schema(name = "value", example = "2.1", description = "The duration in milliseconds, with a 0.1 accuracy", requiredMode = Schema.RequiredMode.REQUIRED)
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
    PercentileValue percentileValue = (PercentileValue) o;
    return Objects.equals(this.percentile, percentileValue.percentile) &&
        Objects.equals(this.value, percentileValue.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(percentile, value);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PercentileValue {\n");
    sb.append("    percentile: ").append(toIndentedString(percentile)).append("\n");
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


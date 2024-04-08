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
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * FetchElementPercentilesResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-04-06T15:29:22.895694+02:00[Europe/Amsterdam]", comments = "Generator version: 7.4.0")
public class FetchElementPercentilesResponse {

  @Valid
  private List<@Valid PercentileValue> points = new ArrayList<>();

  public FetchElementPercentilesResponse() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public FetchElementPercentilesResponse(List<@Valid PercentileValue> points) {
    this.points = points;
  }

  public FetchElementPercentilesResponse points(List<@Valid PercentileValue> points) {
    this.points = points;
    return this;
  }

  public FetchElementPercentilesResponse addPointsItem(PercentileValue pointsItem) {
    if (this.points == null) {
      this.points = new ArrayList<>();
    }
    this.points.add(pointsItem);
    return this;
  }

  /**
   * Get points
   * @return points
  */
  @NotNull @Valid 
  @Schema(name = "points", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("points")
  public List<@Valid PercentileValue> getPoints() {
    return points;
  }

  public void setPoints(List<@Valid PercentileValue> points) {
    this.points = points;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FetchElementPercentilesResponse fetchElementPercentilesResponse = (FetchElementPercentilesResponse) o;
    return Objects.equals(this.points, fetchElementPercentilesResponse.points);
  }

  @Override
  public int hashCode() {
    return Objects.hash(points);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FetchElementPercentilesResponse {\n");
    sb.append("    points: ").append(toIndentedString(points)).append("\n");
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


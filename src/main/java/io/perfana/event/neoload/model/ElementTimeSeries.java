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
 * Element Timeseries fields
 */

@Schema(name = "ElementTimeSeries", description = "Element Timeseries fields")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-04-06T15:29:22.895694+02:00[Europe/Amsterdam]", comments = "Generator version: 7.4.0")
public class ElementTimeSeries {

  @Valid
  private List<@Valid ElementPoint> points = new ArrayList<>();

  private String samplingInterval;

  private Boolean isFromScratch;

  private String nextRequestToken;

  public ElementTimeSeries() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public ElementTimeSeries(List<@Valid ElementPoint> points, String samplingInterval) {
    this.points = points;
    this.samplingInterval = samplingInterval;
  }

  public ElementTimeSeries points(List<@Valid ElementPoint> points) {
    this.points = points;
    return this;
  }

  public ElementTimeSeries addPointsItem(ElementPoint pointsItem) {
    if (this.points == null) {
      this.points = new ArrayList<>();
    }
    this.points.add(pointsItem);
    return this;
  }

  /**
   * The list of points
   * @return points
  */
  @NotNull @Valid 
  @Schema(name = "points", description = "The list of points", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("points")
  public List<@Valid ElementPoint> getPoints() {
    return points;
  }

  public void setPoints(List<@Valid ElementPoint> points) {
    this.points = points;
  }

  public ElementTimeSeries samplingInterval(String samplingInterval) {
    this.samplingInterval = samplingInterval;
    return this;
  }

  /**
   * The duration between points (ISO 8601 format)
   * @return samplingInterval
  */
  @NotNull 
  @Schema(name = "samplingInterval", example = "PT1S", description = "The duration between points (ISO 8601 format)", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("samplingInterval")
  public String getSamplingInterval() {
    return samplingInterval;
  }

  public void setSamplingInterval(String samplingInterval) {
    this.samplingInterval = samplingInterval;
  }

  public ElementTimeSeries isFromScratch(Boolean isFromScratch) {
    this.isFromScratch = isFromScratch;
    return this;
  }

  /**
   * True if the points list contains all points since the beginning of the result
   * @return isFromScratch
  */
  
  @Schema(name = "isFromScratch", description = "True if the points list contains all points since the beginning of the result", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("isFromScratch")
  public Boolean getIsFromScratch() {
    return isFromScratch;
  }

  public void setIsFromScratch(Boolean isFromScratch) {
    this.isFromScratch = isFromScratch;
  }

  public ElementTimeSeries nextRequestToken(String nextRequestToken) {
    this.nextRequestToken = nextRequestToken;
    return this;
  }

  /**
   * The next request token. This is present when fetching on a running result, in order to use it on the next fetch, to get the following points
   * @return nextRequestToken
  */
  
  @Schema(name = "nextRequestToken", description = "The next request token. This is present when fetching on a running result, in order to use it on the next fetch, to get the following points", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("nextRequestToken")
  public String getNextRequestToken() {
    return nextRequestToken;
  }

  public void setNextRequestToken(String nextRequestToken) {
    this.nextRequestToken = nextRequestToken;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ElementTimeSeries elementTimeSeries = (ElementTimeSeries) o;
    return Objects.equals(this.points, elementTimeSeries.points) &&
        Objects.equals(this.samplingInterval, elementTimeSeries.samplingInterval) &&
        Objects.equals(this.isFromScratch, elementTimeSeries.isFromScratch) &&
        Objects.equals(this.nextRequestToken, elementTimeSeries.nextRequestToken);
  }

  @Override
  public int hashCode() {
    return Objects.hash(points, samplingInterval, isFromScratch, nextRequestToken);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ElementTimeSeries {\n");
    sb.append("    points: ").append(toIndentedString(points)).append("\n");
    sb.append("    samplingInterval: ").append(toIndentedString(samplingInterval)).append("\n");
    sb.append("    isFromScratch: ").append(toIndentedString(isFromScratch)).append("\n");
    sb.append("    nextRequestToken: ").append(toIndentedString(nextRequestToken)).append("\n");
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


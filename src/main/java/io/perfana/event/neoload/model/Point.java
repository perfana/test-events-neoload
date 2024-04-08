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
 * Point of a Test Result Timeseries
 */

@Schema(name = "Point", description = "Point of a Test Result Timeseries")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-04-06T15:29:22.895694+02:00[Europe/Amsterdam]", comments = "Generator version: 7.4.0")
public class Point {

  private String offset;

  private Double requestAvgDuration;

  private Double requestCountPerSecond;

  private Long requestErrors;

  private Long userLoad;

  public Point() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public Point(String offset) {
    this.offset = offset;
  }

  public Point offset(String offset) {
    this.offset = offset;
    return this;
  }

  /**
   * Start offset (ISO 8601 format).
   * @return offset
  */
  @NotNull 
  @Schema(name = "offset", example = "PT1S", description = "Start offset (ISO 8601 format).", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("offset")
  public String getOffset() {
    return offset;
  }

  public void setOffset(String offset) {
    this.offset = offset;
  }

  public Point requestAvgDuration(Double requestAvgDuration) {
    this.requestAvgDuration = requestAvgDuration;
    return this;
  }

  /**
   * Average response time in seconds of all requests
   * @return requestAvgDuration
  */
  
  @Schema(name = "requestAvgDuration", example = "0.354", description = "Average response time in seconds of all requests", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("requestAvgDuration")
  public Double getRequestAvgDuration() {
    return requestAvgDuration;
  }

  public void setRequestAvgDuration(Double requestAvgDuration) {
    this.requestAvgDuration = requestAvgDuration;
  }

  public Point requestCountPerSecond(Double requestCountPerSecond) {
    this.requestCountPerSecond = requestCountPerSecond;
    return this;
  }

  /**
   * Number of all requests per second
   * @return requestCountPerSecond
  */
  
  @Schema(name = "requestCountPerSecond", example = "22.3", description = "Number of all requests per second", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("requestCountPerSecond")
  public Double getRequestCountPerSecond() {
    return requestCountPerSecond;
  }

  public void setRequestCountPerSecond(Double requestCountPerSecond) {
    this.requestCountPerSecond = requestCountPerSecond;
  }

  public Point requestErrors(Long requestErrors) {
    this.requestErrors = requestErrors;
    return this;
  }

  /**
   * Errors
   * @return requestErrors
  */
  
  @Schema(name = "requestErrors", example = "103", description = "Errors", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("requestErrors")
  public Long getRequestErrors() {
    return requestErrors;
  }

  public void setRequestErrors(Long requestErrors) {
    this.requestErrors = requestErrors;
  }

  public Point userLoad(Long userLoad) {
    this.userLoad = userLoad;
    return this;
  }

  /**
   * User Load
   * @return userLoad
  */
  
  @Schema(name = "userLoad", example = "20", description = "User Load", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("userLoad")
  public Long getUserLoad() {
    return userLoad;
  }

  public void setUserLoad(Long userLoad) {
    this.userLoad = userLoad;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Point point = (Point) o;
    return Objects.equals(this.offset, point.offset) &&
        Objects.equals(this.requestAvgDuration, point.requestAvgDuration) &&
        Objects.equals(this.requestCountPerSecond, point.requestCountPerSecond) &&
        Objects.equals(this.requestErrors, point.requestErrors) &&
        Objects.equals(this.userLoad, point.userLoad);
  }

  @Override
  public int hashCode() {
    return Objects.hash(offset, requestAvgDuration, requestCountPerSecond, requestErrors, userLoad);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Point {\n");
    sb.append("    offset: ").append(toIndentedString(offset)).append("\n");
    sb.append("    requestAvgDuration: ").append(toIndentedString(requestAvgDuration)).append("\n");
    sb.append("    requestCountPerSecond: ").append(toIndentedString(requestCountPerSecond)).append("\n");
    sb.append("    requestErrors: ").append(toIndentedString(requestErrors)).append("\n");
    sb.append("    userLoad: ").append(toIndentedString(userLoad)).append("\n");
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


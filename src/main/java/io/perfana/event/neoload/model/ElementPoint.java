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
 * Point of an Element Timeseries
 */

@Schema(name = "ElementPoint", description = "Point of an Element Timeseries")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-04-06T15:29:22.895694+02:00[Europe/Amsterdam]", comments = "Generator version: 7.4.0")
public class ElementPoint {

  private String offset;

  private Double avgDuration;

  private Double avgTtfb;

  private Long count;

  private Double elementsPerSecond;

  private Double errorRate;

  private Long errors;

  private Double errorsPerSecond;

  private Double maxDuration;

  private Double maxTtfb;

  private Double minDuration;

  private Double minTtfb;

  private Double throughput;

  public ElementPoint() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public ElementPoint(String offset) {
    this.offset = offset;
  }

  public ElementPoint offset(String offset) {
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

  public ElementPoint avgDuration(Double avgDuration) {
    this.avgDuration = avgDuration;
    return this;
  }

  /**
   * Average response time, in seconds.
   * @return avgDuration
  */
  
  @Schema(name = "avgDuration", example = "0.357", description = "Average response time, in seconds.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("avgDuration")
  public Double getAvgDuration() {
    return avgDuration;
  }

  public void setAvgDuration(Double avgDuration) {
    this.avgDuration = avgDuration;
  }

  public ElementPoint avgTtfb(Double avgTtfb) {
    this.avgTtfb = avgTtfb;
    return this;
  }

  /**
   * Average time to first byte, in seconds.
   * @return avgTtfb
  */
  
  @Schema(name = "avgTtfb", example = "0.123", description = "Average time to first byte, in seconds.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("avgTtfb")
  public Double getAvgTtfb() {
    return avgTtfb;
  }

  public void setAvgTtfb(Double avgTtfb) {
    this.avgTtfb = avgTtfb;
  }

  public ElementPoint count(Long count) {
    this.count = count;
    return this;
  }

  /**
   * Number of full executions of an element of a User Path. If the element is interrupted (because of error or end of test), then the count number is not incremented.
   * @return count
  */
  
  @Schema(name = "count", example = "10", description = "Number of full executions of an element of a User Path. If the element is interrupted (because of error or end of test), then the count number is not incremented.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("count")
  public Long getCount() {
    return count;
  }

  public void setCount(Long count) {
    this.count = count;
  }

  public ElementPoint elementsPerSecond(Double elementsPerSecond) {
    this.elementsPerSecond = elementsPerSecond;
    return this;
  }

  /**
   * Average number of iterations of the element per second.
   * @return elementsPerSecond
  */
  
  @Schema(name = "elementsPerSecond", example = "20", description = "Average number of iterations of the element per second.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("elementsPerSecond")
  public Double getElementsPerSecond() {
    return elementsPerSecond;
  }

  public void setElementsPerSecond(Double elementsPerSecond) {
    this.elementsPerSecond = elementsPerSecond;
  }

  public ElementPoint errorRate(Double errorRate) {
    this.errorRate = errorRate;
    return this;
  }

  /**
   * Percentage of failed iterations out of count.
   * @return errorRate
  */
  
  @Schema(name = "errorRate", example = "0.8", description = "Percentage of failed iterations out of count.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("errorRate")
  public Double getErrorRate() {
    return errorRate;
  }

  public void setErrorRate(Double errorRate) {
    this.errorRate = errorRate;
  }

  public ElementPoint errors(Long errors) {
    this.errors = errors;
    return this;
  }

  /**
   * Errors
   * @return errors
  */
  
  @Schema(name = "errors", example = "5", description = "Errors", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("errors")
  public Long getErrors() {
    return errors;
  }

  public void setErrors(Long errors) {
    this.errors = errors;
  }

  public ElementPoint errorsPerSecond(Double errorsPerSecond) {
    this.errorsPerSecond = errorsPerSecond;
    return this;
  }

  /**
   * Errors Per Second
   * @return errorsPerSecond
  */
  
  @Schema(name = "errorsPerSecond", example = "1", description = "Errors Per Second", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("errorsPerSecond")
  public Double getErrorsPerSecond() {
    return errorsPerSecond;
  }

  public void setErrorsPerSecond(Double errorsPerSecond) {
    this.errorsPerSecond = errorsPerSecond;
  }

  public ElementPoint maxDuration(Double maxDuration) {
    this.maxDuration = maxDuration;
    return this;
  }

  /**
   * Maximum response time, in seconds.
   * @return maxDuration
  */
  
  @Schema(name = "maxDuration", example = "0.589", description = "Maximum response time, in seconds.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("maxDuration")
  public Double getMaxDuration() {
    return maxDuration;
  }

  public void setMaxDuration(Double maxDuration) {
    this.maxDuration = maxDuration;
  }

  public ElementPoint maxTtfb(Double maxTtfb) {
    this.maxTtfb = maxTtfb;
    return this;
  }

  /**
   * Maximum time to first byte, in seconds.
   * @return maxTtfb
  */
  
  @Schema(name = "maxTtfb", example = "0.348", description = "Maximum time to first byte, in seconds.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("maxTtfb")
  public Double getMaxTtfb() {
    return maxTtfb;
  }

  public void setMaxTtfb(Double maxTtfb) {
    this.maxTtfb = maxTtfb;
  }

  public ElementPoint minDuration(Double minDuration) {
    this.minDuration = minDuration;
    return this;
  }

  /**
   * Minimum response time, in seconds.
   * @return minDuration
  */
  
  @Schema(name = "minDuration", example = "0.125", description = "Minimum response time, in seconds.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("minDuration")
  public Double getMinDuration() {
    return minDuration;
  }

  public void setMinDuration(Double minDuration) {
    this.minDuration = minDuration;
  }

  public ElementPoint minTtfb(Double minTtfb) {
    this.minTtfb = minTtfb;
    return this;
  }

  /**
   * Minimum time to first byte, in seconds.
   * @return minTtfb
  */
  
  @Schema(name = "minTtfb", example = "0.118", description = "Minimum time to first byte, in seconds.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("minTtfb")
  public Double getMinTtfb() {
    return minTtfb;
  }

  public void setMinTtfb(Double minTtfb) {
    this.minTtfb = minTtfb;
  }

  public ElementPoint throughput(Double throughput) {
    this.throughput = throughput;
    return this;
  }

  /**
   * Throughput (bytes/s)
   * @return throughput
  */
  
  @Schema(name = "throughput", example = "1235.2", description = "Throughput (bytes/s)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("throughput")
  public Double getThroughput() {
    return throughput;
  }

  public void setThroughput(Double throughput) {
    this.throughput = throughput;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ElementPoint elementPoint = (ElementPoint) o;
    return Objects.equals(this.offset, elementPoint.offset) &&
        Objects.equals(this.avgDuration, elementPoint.avgDuration) &&
        Objects.equals(this.avgTtfb, elementPoint.avgTtfb) &&
        Objects.equals(this.count, elementPoint.count) &&
        Objects.equals(this.elementsPerSecond, elementPoint.elementsPerSecond) &&
        Objects.equals(this.errorRate, elementPoint.errorRate) &&
        Objects.equals(this.errors, elementPoint.errors) &&
        Objects.equals(this.errorsPerSecond, elementPoint.errorsPerSecond) &&
        Objects.equals(this.maxDuration, elementPoint.maxDuration) &&
        Objects.equals(this.maxTtfb, elementPoint.maxTtfb) &&
        Objects.equals(this.minDuration, elementPoint.minDuration) &&
        Objects.equals(this.minTtfb, elementPoint.minTtfb) &&
        Objects.equals(this.throughput, elementPoint.throughput);
  }

  @Override
  public int hashCode() {
    return Objects.hash(offset, avgDuration, avgTtfb, count, elementsPerSecond, errorRate, errors, errorsPerSecond, maxDuration, maxTtfb, minDuration, minTtfb, throughput);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ElementPoint {\n");
    sb.append("    offset: ").append(toIndentedString(offset)).append("\n");
    sb.append("    avgDuration: ").append(toIndentedString(avgDuration)).append("\n");
    sb.append("    avgTtfb: ").append(toIndentedString(avgTtfb)).append("\n");
    sb.append("    count: ").append(toIndentedString(count)).append("\n");
    sb.append("    elementsPerSecond: ").append(toIndentedString(elementsPerSecond)).append("\n");
    sb.append("    errorRate: ").append(toIndentedString(errorRate)).append("\n");
    sb.append("    errors: ").append(toIndentedString(errors)).append("\n");
    sb.append("    errorsPerSecond: ").append(toIndentedString(errorsPerSecond)).append("\n");
    sb.append("    maxDuration: ").append(toIndentedString(maxDuration)).append("\n");
    sb.append("    maxTtfb: ").append(toIndentedString(maxTtfb)).append("\n");
    sb.append("    minDuration: ").append(toIndentedString(minDuration)).append("\n");
    sb.append("    minTtfb: ").append(toIndentedString(minTtfb)).append("\n");
    sb.append("    throughput: ").append(toIndentedString(throughput)).append("\n");
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


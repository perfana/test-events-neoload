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
 * Test Result Statistics
 */

@Schema(name = "TestResultStatistics", description = "Test Result Statistics")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-04-06T15:29:22.895694+02:00[Europe/Amsterdam]", comments = "Generator version: 7.4.0")
public class TestResultStatistics {

  private Long totalGlobalCountFailure;

  private Long totalGlobalDownloadedBytes;

  private Double totalGlobalDownloadedBytesPerSecond;

  private Long totalIterationCountFailure;

  private Long totalIterationCountSuccess;

  private Long totalRequestCountFailure;

  private Double totalRequestCountPerSecond;

  private Long totalRequestCountSuccess;

  private Double totalRequestDurationAverage;

  private Long totalTransactionCountFailure;

  private Double totalTransactionCountPerSecond;

  private Long totalTransactionCountSuccess;

  private Double totalTransactionDurationAverage;

  private Double lastRequestCountPerSecond;

  private Double lastTransactionDurationAverage;

  private Long lastVirtualUserCount;

  public TestResultStatistics() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public TestResultStatistics(Long totalGlobalCountFailure, Long totalGlobalDownloadedBytes, Double totalGlobalDownloadedBytesPerSecond, Long totalIterationCountFailure, Long totalIterationCountSuccess, Long totalRequestCountFailure, Double totalRequestCountPerSecond, Long totalRequestCountSuccess, Double totalRequestDurationAverage, Long totalTransactionCountFailure, Double totalTransactionCountPerSecond, Long totalTransactionCountSuccess, Double totalTransactionDurationAverage) {
    this.totalGlobalCountFailure = totalGlobalCountFailure;
    this.totalGlobalDownloadedBytes = totalGlobalDownloadedBytes;
    this.totalGlobalDownloadedBytesPerSecond = totalGlobalDownloadedBytesPerSecond;
    this.totalIterationCountFailure = totalIterationCountFailure;
    this.totalIterationCountSuccess = totalIterationCountSuccess;
    this.totalRequestCountFailure = totalRequestCountFailure;
    this.totalRequestCountPerSecond = totalRequestCountPerSecond;
    this.totalRequestCountSuccess = totalRequestCountSuccess;
    this.totalRequestDurationAverage = totalRequestDurationAverage;
    this.totalTransactionCountFailure = totalTransactionCountFailure;
    this.totalTransactionCountPerSecond = totalTransactionCountPerSecond;
    this.totalTransactionCountSuccess = totalTransactionCountSuccess;
    this.totalTransactionDurationAverage = totalTransactionDurationAverage;
  }

  public TestResultStatistics totalGlobalCountFailure(Long totalGlobalCountFailure) {
    this.totalGlobalCountFailure = totalGlobalCountFailure;
    return this;
  }

  /**
   * Get totalGlobalCountFailure
   * @return totalGlobalCountFailure
  */
  @NotNull 
  @Schema(name = "totalGlobalCountFailure", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("totalGlobalCountFailure")
  public Long getTotalGlobalCountFailure() {
    return totalGlobalCountFailure;
  }

  public void setTotalGlobalCountFailure(Long totalGlobalCountFailure) {
    this.totalGlobalCountFailure = totalGlobalCountFailure;
  }

  public TestResultStatistics totalGlobalDownloadedBytes(Long totalGlobalDownloadedBytes) {
    this.totalGlobalDownloadedBytes = totalGlobalDownloadedBytes;
    return this;
  }

  /**
   * Total size of http traffic received in bytes.
   * @return totalGlobalDownloadedBytes
  */
  @NotNull 
  @Schema(name = "totalGlobalDownloadedBytes", description = "Total size of http traffic received in bytes.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("totalGlobalDownloadedBytes")
  public Long getTotalGlobalDownloadedBytes() {
    return totalGlobalDownloadedBytes;
  }

  public void setTotalGlobalDownloadedBytes(Long totalGlobalDownloadedBytes) {
    this.totalGlobalDownloadedBytes = totalGlobalDownloadedBytes;
  }

  public TestResultStatistics totalGlobalDownloadedBytesPerSecond(Double totalGlobalDownloadedBytesPerSecond) {
    this.totalGlobalDownloadedBytesPerSecond = totalGlobalDownloadedBytesPerSecond;
    return this;
  }

  /**
   * Average size of http traffic received in bytes per second.
   * @return totalGlobalDownloadedBytesPerSecond
  */
  @NotNull 
  @Schema(name = "totalGlobalDownloadedBytesPerSecond", description = "Average size of http traffic received in bytes per second.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("totalGlobalDownloadedBytesPerSecond")
  public Double getTotalGlobalDownloadedBytesPerSecond() {
    return totalGlobalDownloadedBytesPerSecond;
  }

  public void setTotalGlobalDownloadedBytesPerSecond(Double totalGlobalDownloadedBytesPerSecond) {
    this.totalGlobalDownloadedBytesPerSecond = totalGlobalDownloadedBytesPerSecond;
  }

  public TestResultStatistics totalIterationCountFailure(Long totalIterationCountFailure) {
    this.totalIterationCountFailure = totalIterationCountFailure;
    return this;
  }

  /**
   * Total number of times when the 'Actions' Container was run for each Virtual User and encountered an error.
   * @return totalIterationCountFailure
  */
  @NotNull 
  @Schema(name = "totalIterationCountFailure", description = "Total number of times when the 'Actions' Container was run for each Virtual User and encountered an error.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("totalIterationCountFailure")
  public Long getTotalIterationCountFailure() {
    return totalIterationCountFailure;
  }

  public void setTotalIterationCountFailure(Long totalIterationCountFailure) {
    this.totalIterationCountFailure = totalIterationCountFailure;
  }

  public TestResultStatistics totalIterationCountSuccess(Long totalIterationCountSuccess) {
    this.totalIterationCountSuccess = totalIterationCountSuccess;
    return this;
  }

  /**
   * Total number of times when the 'Actions' Container was run for each Virtual User without encountering any error.
   * @return totalIterationCountSuccess
  */
  @NotNull 
  @Schema(name = "totalIterationCountSuccess", description = "Total number of times when the 'Actions' Container was run for each Virtual User without encountering any error.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("totalIterationCountSuccess")
  public Long getTotalIterationCountSuccess() {
    return totalIterationCountSuccess;
  }

  public void setTotalIterationCountSuccess(Long totalIterationCountSuccess) {
    this.totalIterationCountSuccess = totalIterationCountSuccess;
  }

  public TestResultStatistics totalRequestCountFailure(Long totalRequestCountFailure) {
    this.totalRequestCountFailure = totalRequestCountFailure;
    return this;
  }

  /**
   * Total number of requests in the scenario that encountered errors.
   * @return totalRequestCountFailure
  */
  @NotNull 
  @Schema(name = "totalRequestCountFailure", description = "Total number of requests in the scenario that encountered errors.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("totalRequestCountFailure")
  public Long getTotalRequestCountFailure() {
    return totalRequestCountFailure;
  }

  public void setTotalRequestCountFailure(Long totalRequestCountFailure) {
    this.totalRequestCountFailure = totalRequestCountFailure;
  }

  public TestResultStatistics totalRequestCountPerSecond(Double totalRequestCountPerSecond) {
    this.totalRequestCountPerSecond = totalRequestCountPerSecond;
    return this;
  }

  /**
   * Total number of requests in the scenario that are performed per second.
   * @return totalRequestCountPerSecond
  */
  @NotNull 
  @Schema(name = "totalRequestCountPerSecond", description = "Total number of requests in the scenario that are performed per second.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("totalRequestCountPerSecond")
  public Double getTotalRequestCountPerSecond() {
    return totalRequestCountPerSecond;
  }

  public void setTotalRequestCountPerSecond(Double totalRequestCountPerSecond) {
    this.totalRequestCountPerSecond = totalRequestCountPerSecond;
  }

  public TestResultStatistics totalRequestCountSuccess(Long totalRequestCountSuccess) {
    this.totalRequestCountSuccess = totalRequestCountSuccess;
    return this;
  }

  /**
   * Total number of requests in the scenario that did not encounter any error.
   * @return totalRequestCountSuccess
  */
  @NotNull 
  @Schema(name = "totalRequestCountSuccess", description = "Total number of requests in the scenario that did not encounter any error.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("totalRequestCountSuccess")
  public Long getTotalRequestCountSuccess() {
    return totalRequestCountSuccess;
  }

  public void setTotalRequestCountSuccess(Long totalRequestCountSuccess) {
    this.totalRequestCountSuccess = totalRequestCountSuccess;
  }

  public TestResultStatistics totalRequestDurationAverage(Double totalRequestDurationAverage) {
    this.totalRequestDurationAverage = totalRequestDurationAverage;
    return this;
  }

  /**
   * Average time in seconds for all requests of the scenario to be performed (from first byte sent to last byte received).
   * @return totalRequestDurationAverage
  */
  @NotNull 
  @Schema(name = "totalRequestDurationAverage", example = "0.153", description = "Average time in seconds for all requests of the scenario to be performed (from first byte sent to last byte received).", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("totalRequestDurationAverage")
  public Double getTotalRequestDurationAverage() {
    return totalRequestDurationAverage;
  }

  public void setTotalRequestDurationAverage(Double totalRequestDurationAverage) {
    this.totalRequestDurationAverage = totalRequestDurationAverage;
  }

  public TestResultStatistics totalTransactionCountFailure(Long totalTransactionCountFailure) {
    this.totalTransactionCountFailure = totalTransactionCountFailure;
    return this;
  }

  /**
   * Total number of the scenario Transactions executed with errors.
   * @return totalTransactionCountFailure
  */
  @NotNull 
  @Schema(name = "totalTransactionCountFailure", description = "Total number of the scenario Transactions executed with errors.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("totalTransactionCountFailure")
  public Long getTotalTransactionCountFailure() {
    return totalTransactionCountFailure;
  }

  public void setTotalTransactionCountFailure(Long totalTransactionCountFailure) {
    this.totalTransactionCountFailure = totalTransactionCountFailure;
  }

  public TestResultStatistics totalTransactionCountPerSecond(Double totalTransactionCountPerSecond) {
    this.totalTransactionCountPerSecond = totalTransactionCountPerSecond;
    return this;
  }

  /**
   * Total number of the scenario Transactions executed per second.
   * @return totalTransactionCountPerSecond
  */
  @NotNull 
  @Schema(name = "totalTransactionCountPerSecond", description = "Total number of the scenario Transactions executed per second.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("totalTransactionCountPerSecond")
  public Double getTotalTransactionCountPerSecond() {
    return totalTransactionCountPerSecond;
  }

  public void setTotalTransactionCountPerSecond(Double totalTransactionCountPerSecond) {
    this.totalTransactionCountPerSecond = totalTransactionCountPerSecond;
  }

  public TestResultStatistics totalTransactionCountSuccess(Long totalTransactionCountSuccess) {
    this.totalTransactionCountSuccess = totalTransactionCountSuccess;
    return this;
  }

  /**
   * Total number of the scenario Transactions executed without encountering any error.
   * @return totalTransactionCountSuccess
  */
  @NotNull 
  @Schema(name = "totalTransactionCountSuccess", description = "Total number of the scenario Transactions executed without encountering any error.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("totalTransactionCountSuccess")
  public Long getTotalTransactionCountSuccess() {
    return totalTransactionCountSuccess;
  }

  public void setTotalTransactionCountSuccess(Long totalTransactionCountSuccess) {
    this.totalTransactionCountSuccess = totalTransactionCountSuccess;
  }

  public TestResultStatistics totalTransactionDurationAverage(Double totalTransactionDurationAverage) {
    this.totalTransactionDurationAverage = totalTransactionDurationAverage;
    return this;
  }

  /**
   * Average time in seconds for all Transactions of the scenario to be executed.
   * @return totalTransactionDurationAverage
  */
  @NotNull 
  @Schema(name = "totalTransactionDurationAverage", example = "0.065", description = "Average time in seconds for all Transactions of the scenario to be executed.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("totalTransactionDurationAverage")
  public Double getTotalTransactionDurationAverage() {
    return totalTransactionDurationAverage;
  }

  public void setTotalTransactionDurationAverage(Double totalTransactionDurationAverage) {
    this.totalTransactionDurationAverage = totalTransactionDurationAverage;
  }

  public TestResultStatistics lastRequestCountPerSecond(Double lastRequestCountPerSecond) {
    this.lastRequestCountPerSecond = lastRequestCountPerSecond;
    return this;
  }

  /**
   * Last value received for the number of requests in the scenario that are performed per second. Only present when the result is running.
   * @return lastRequestCountPerSecond
  */
  
  @Schema(name = "lastRequestCountPerSecond", description = "Last value received for the number of requests in the scenario that are performed per second. Only present when the result is running.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("lastRequestCountPerSecond")
  public Double getLastRequestCountPerSecond() {
    return lastRequestCountPerSecond;
  }

  public void setLastRequestCountPerSecond(Double lastRequestCountPerSecond) {
    this.lastRequestCountPerSecond = lastRequestCountPerSecond;
  }

  public TestResultStatistics lastTransactionDurationAverage(Double lastTransactionDurationAverage) {
    this.lastTransactionDurationAverage = lastTransactionDurationAverage;
    return this;
  }

  /**
   * Last value received for the average time in seconds for all Transactions of the scenario. Only present when the result is running.
   * @return lastTransactionDurationAverage
  */
  
  @Schema(name = "lastTransactionDurationAverage", example = "1.3547", description = "Last value received for the average time in seconds for all Transactions of the scenario. Only present when the result is running.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("lastTransactionDurationAverage")
  public Double getLastTransactionDurationAverage() {
    return lastTransactionDurationAverage;
  }

  public void setLastTransactionDurationAverage(Double lastTransactionDurationAverage) {
    this.lastTransactionDurationAverage = lastTransactionDurationAverage;
  }

  public TestResultStatistics lastVirtualUserCount(Long lastVirtualUserCount) {
    this.lastVirtualUserCount = lastVirtualUserCount;
    return this;
  }

  /**
   * Last value received for the total number of Virtual Users executed in the test. Only present when the result is running.
   * @return lastVirtualUserCount
  */
  
  @Schema(name = "lastVirtualUserCount", description = "Last value received for the total number of Virtual Users executed in the test. Only present when the result is running.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("lastVirtualUserCount")
  public Long getLastVirtualUserCount() {
    return lastVirtualUserCount;
  }

  public void setLastVirtualUserCount(Long lastVirtualUserCount) {
    this.lastVirtualUserCount = lastVirtualUserCount;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TestResultStatistics testResultStatistics = (TestResultStatistics) o;
    return Objects.equals(this.totalGlobalCountFailure, testResultStatistics.totalGlobalCountFailure) &&
        Objects.equals(this.totalGlobalDownloadedBytes, testResultStatistics.totalGlobalDownloadedBytes) &&
        Objects.equals(this.totalGlobalDownloadedBytesPerSecond, testResultStatistics.totalGlobalDownloadedBytesPerSecond) &&
        Objects.equals(this.totalIterationCountFailure, testResultStatistics.totalIterationCountFailure) &&
        Objects.equals(this.totalIterationCountSuccess, testResultStatistics.totalIterationCountSuccess) &&
        Objects.equals(this.totalRequestCountFailure, testResultStatistics.totalRequestCountFailure) &&
        Objects.equals(this.totalRequestCountPerSecond, testResultStatistics.totalRequestCountPerSecond) &&
        Objects.equals(this.totalRequestCountSuccess, testResultStatistics.totalRequestCountSuccess) &&
        Objects.equals(this.totalRequestDurationAverage, testResultStatistics.totalRequestDurationAverage) &&
        Objects.equals(this.totalTransactionCountFailure, testResultStatistics.totalTransactionCountFailure) &&
        Objects.equals(this.totalTransactionCountPerSecond, testResultStatistics.totalTransactionCountPerSecond) &&
        Objects.equals(this.totalTransactionCountSuccess, testResultStatistics.totalTransactionCountSuccess) &&
        Objects.equals(this.totalTransactionDurationAverage, testResultStatistics.totalTransactionDurationAverage) &&
        Objects.equals(this.lastRequestCountPerSecond, testResultStatistics.lastRequestCountPerSecond) &&
        Objects.equals(this.lastTransactionDurationAverage, testResultStatistics.lastTransactionDurationAverage) &&
        Objects.equals(this.lastVirtualUserCount, testResultStatistics.lastVirtualUserCount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(totalGlobalCountFailure, totalGlobalDownloadedBytes, totalGlobalDownloadedBytesPerSecond, totalIterationCountFailure, totalIterationCountSuccess, totalRequestCountFailure, totalRequestCountPerSecond, totalRequestCountSuccess, totalRequestDurationAverage, totalTransactionCountFailure, totalTransactionCountPerSecond, totalTransactionCountSuccess, totalTransactionDurationAverage, lastRequestCountPerSecond, lastTransactionDurationAverage, lastVirtualUserCount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TestResultStatistics {\n");
    sb.append("    totalGlobalCountFailure: ").append(toIndentedString(totalGlobalCountFailure)).append("\n");
    sb.append("    totalGlobalDownloadedBytes: ").append(toIndentedString(totalGlobalDownloadedBytes)).append("\n");
    sb.append("    totalGlobalDownloadedBytesPerSecond: ").append(toIndentedString(totalGlobalDownloadedBytesPerSecond)).append("\n");
    sb.append("    totalIterationCountFailure: ").append(toIndentedString(totalIterationCountFailure)).append("\n");
    sb.append("    totalIterationCountSuccess: ").append(toIndentedString(totalIterationCountSuccess)).append("\n");
    sb.append("    totalRequestCountFailure: ").append(toIndentedString(totalRequestCountFailure)).append("\n");
    sb.append("    totalRequestCountPerSecond: ").append(toIndentedString(totalRequestCountPerSecond)).append("\n");
    sb.append("    totalRequestCountSuccess: ").append(toIndentedString(totalRequestCountSuccess)).append("\n");
    sb.append("    totalRequestDurationAverage: ").append(toIndentedString(totalRequestDurationAverage)).append("\n");
    sb.append("    totalTransactionCountFailure: ").append(toIndentedString(totalTransactionCountFailure)).append("\n");
    sb.append("    totalTransactionCountPerSecond: ").append(toIndentedString(totalTransactionCountPerSecond)).append("\n");
    sb.append("    totalTransactionCountSuccess: ").append(toIndentedString(totalTransactionCountSuccess)).append("\n");
    sb.append("    totalTransactionDurationAverage: ").append(toIndentedString(totalTransactionDurationAverage)).append("\n");
    sb.append("    lastRequestCountPerSecond: ").append(toIndentedString(lastRequestCountPerSecond)).append("\n");
    sb.append("    lastTransactionDurationAverage: ").append(toIndentedString(lastTransactionDurationAverage)).append("\n");
    sb.append("    lastVirtualUserCount: ").append(toIndentedString(lastVirtualUserCount)).append("\n");
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


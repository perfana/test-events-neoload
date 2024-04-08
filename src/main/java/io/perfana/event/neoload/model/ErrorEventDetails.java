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

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Details of an event of type ERROR
 */

@Schema(name = "ErrorEventDetails", description = "Details of an event of type ERROR")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-04-06T15:29:22.895694+02:00[Europe/Amsterdam]", comments = "Generator version: 7.4.0")
public class ErrorEventDetails implements EventDetails {

  @Valid
  private List<@Valid AssertionResult> assertionResults;

  private BigDecimal iterationNumber;

  private String lgName;

  private String populationName;

  private String request;

  private BigDecimal requestDuration;

  private String screenshotRef;

  private String transaction;

  private String userPathId;

  private BigDecimal userPathInstance;

  private String virtualUserStep;

  private String zoneId;

  public ErrorEventDetails assertionResults(List<@Valid AssertionResult> assertionResults) {
    this.assertionResults = assertionResults;
    return this;
  }

  public ErrorEventDetails addAssertionResultsItem(AssertionResult assertionResultsItem) {
    if (this.assertionResults == null) {
      this.assertionResults = new ArrayList<>();
    }
    this.assertionResults.add(assertionResultsItem);
    return this;
  }

  /**
   * Assertions of the error.
   * @return assertionResults
  */
  @Valid 
  @Schema(name = "assertionResults", description = "Assertions of the error.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("assertionResults")
  public List<@Valid AssertionResult> getAssertionResults() {
    return assertionResults;
  }

  public void setAssertionResults(List<@Valid AssertionResult> assertionResults) {
    this.assertionResults = assertionResults;
  }

  public ErrorEventDetails iterationNumber(BigDecimal iterationNumber) {
    this.iterationNumber = iterationNumber;
    return this;
  }

  /**
   * Iteration number of the error.
   * @return iterationNumber
  */
  @Valid 
  @Schema(name = "iterationNumber", description = "Iteration number of the error.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("iterationNumber")
  public BigDecimal getIterationNumber() {
    return iterationNumber;
  }

  public void setIterationNumber(BigDecimal iterationNumber) {
    this.iterationNumber = iterationNumber;
  }

  public ErrorEventDetails lgName(String lgName) {
    this.lgName = lgName;
    return this;
  }

  /**
   * Lg name of the error.
   * @return lgName
  */
  
  @Schema(name = "lgName", description = "Lg name of the error.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("lgName")
  public String getLgName() {
    return lgName;
  }

  public void setLgName(String lgName) {
    this.lgName = lgName;
  }

  public ErrorEventDetails populationName(String populationName) {
    this.populationName = populationName;
    return this;
  }

  /**
   * Population name of the error.
   * @return populationName
  */
  
  @Schema(name = "populationName", description = "Population name of the error.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("populationName")
  public String getPopulationName() {
    return populationName;
  }

  public void setPopulationName(String populationName) {
    this.populationName = populationName;
  }

  public ErrorEventDetails request(String request) {
    this.request = request;
    return this;
  }

  /**
   * Request of the error.
   * @return request
  */
  
  @Schema(name = "request", description = "Request of the error.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("request")
  public String getRequest() {
    return request;
  }

  public void setRequest(String request) {
    this.request = request;
  }

  public ErrorEventDetails requestDuration(BigDecimal requestDuration) {
    this.requestDuration = requestDuration;
    return this;
  }

  /**
   * Request duration of the error.
   * @return requestDuration
  */
  @Valid 
  @Schema(name = "requestDuration", description = "Request duration of the error.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("requestDuration")
  public BigDecimal getRequestDuration() {
    return requestDuration;
  }

  public void setRequestDuration(BigDecimal requestDuration) {
    this.requestDuration = requestDuration;
  }

  public ErrorEventDetails screenshotRef(String screenshotRef) {
    this.screenshotRef = screenshotRef;
    return this;
  }

  /**
   * Screenshot ref of the error.
   * @return screenshotRef
  */
  
  @Schema(name = "screenshotRef", description = "Screenshot ref of the error.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("screenshotRef")
  public String getScreenshotRef() {
    return screenshotRef;
  }

  public void setScreenshotRef(String screenshotRef) {
    this.screenshotRef = screenshotRef;
  }

  public ErrorEventDetails transaction(String transaction) {
    this.transaction = transaction;
    return this;
  }

  /**
   * Transaction of the error.
   * @return transaction
  */
  
  @Schema(name = "transaction", description = "Transaction of the error.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("transaction")
  public String getTransaction() {
    return transaction;
  }

  public void setTransaction(String transaction) {
    this.transaction = transaction;
  }

  public ErrorEventDetails userPathId(String userPathId) {
    this.userPathId = userPathId;
    return this;
  }

  /**
   * User path id of the error.
   * @return userPathId
  */
  
  @Schema(name = "userPathId", description = "User path id of the error.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("userPathId")
  public String getUserPathId() {
    return userPathId;
  }

  public void setUserPathId(String userPathId) {
    this.userPathId = userPathId;
  }

  public ErrorEventDetails userPathInstance(BigDecimal userPathInstance) {
    this.userPathInstance = userPathInstance;
    return this;
  }

  /**
   * User path instance of the error.
   * @return userPathInstance
  */
  @Valid 
  @Schema(name = "userPathInstance", description = "User path instance of the error.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("userPathInstance")
  public BigDecimal getUserPathInstance() {
    return userPathInstance;
  }

  public void setUserPathInstance(BigDecimal userPathInstance) {
    this.userPathInstance = userPathInstance;
  }

  public ErrorEventDetails virtualUserStep(String virtualUserStep) {
    this.virtualUserStep = virtualUserStep;
    return this;
  }

  /**
   * Virtual user step of the error.
   * @return virtualUserStep
  */
  
  @Schema(name = "virtualUserStep", description = "Virtual user step of the error.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("virtualUserStep")
  public String getVirtualUserStep() {
    return virtualUserStep;
  }

  public void setVirtualUserStep(String virtualUserStep) {
    this.virtualUserStep = virtualUserStep;
  }

  public ErrorEventDetails zoneId(String zoneId) {
    this.zoneId = zoneId;
    return this;
  }

  /**
   * Zone id of the error.
   * @return zoneId
  */
  
  @Schema(name = "zoneId", description = "Zone id of the error.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("zoneId")
  public String getZoneId() {
    return zoneId;
  }

  public void setZoneId(String zoneId) {
    this.zoneId = zoneId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ErrorEventDetails errorEventDetails = (ErrorEventDetails) o;
    return Objects.equals(this.assertionResults, errorEventDetails.assertionResults) &&
        Objects.equals(this.iterationNumber, errorEventDetails.iterationNumber) &&
        Objects.equals(this.lgName, errorEventDetails.lgName) &&
        Objects.equals(this.populationName, errorEventDetails.populationName) &&
        Objects.equals(this.request, errorEventDetails.request) &&
        Objects.equals(this.requestDuration, errorEventDetails.requestDuration) &&
        Objects.equals(this.screenshotRef, errorEventDetails.screenshotRef) &&
        Objects.equals(this.transaction, errorEventDetails.transaction) &&
        Objects.equals(this.userPathId, errorEventDetails.userPathId) &&
        Objects.equals(this.userPathInstance, errorEventDetails.userPathInstance) &&
        Objects.equals(this.virtualUserStep, errorEventDetails.virtualUserStep) &&
        Objects.equals(this.zoneId, errorEventDetails.zoneId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(assertionResults, iterationNumber, lgName, populationName, request, requestDuration, screenshotRef, transaction, userPathId, userPathInstance, virtualUserStep, zoneId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ErrorEventDetails {\n");
    sb.append("    assertionResults: ").append(toIndentedString(assertionResults)).append("\n");
    sb.append("    iterationNumber: ").append(toIndentedString(iterationNumber)).append("\n");
    sb.append("    lgName: ").append(toIndentedString(lgName)).append("\n");
    sb.append("    populationName: ").append(toIndentedString(populationName)).append("\n");
    sb.append("    request: ").append(toIndentedString(request)).append("\n");
    sb.append("    requestDuration: ").append(toIndentedString(requestDuration)).append("\n");
    sb.append("    screenshotRef: ").append(toIndentedString(screenshotRef)).append("\n");
    sb.append("    transaction: ").append(toIndentedString(transaction)).append("\n");
    sb.append("    userPathId: ").append(toIndentedString(userPathId)).append("\n");
    sb.append("    userPathInstance: ").append(toIndentedString(userPathInstance)).append("\n");
    sb.append("    virtualUserStep: ").append(toIndentedString(virtualUserStep)).append("\n");
    sb.append("    zoneId: ").append(toIndentedString(zoneId)).append("\n");
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


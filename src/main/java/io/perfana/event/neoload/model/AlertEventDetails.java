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
import java.util.Objects;

/**
 * Details of an event of type ALERT or SLA or OBJECTIVE
 */

@Schema(name = "AlertEventDetails", description = "Details of an event of type ALERT or SLA or OBJECTIVE")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-04-06T15:29:22.895694+02:00[Europe/Amsterdam]", comments = "Generator version: 7.4.0")
public class AlertEventDetails implements EventDetails {

  private BigDecimal accuracy;

  private BigDecimal expectedValue;

  private String monitor;

  private String monitoredMachine;

  private String populationName;

  private String severity;

  private String slaProfileId;

  private String slaType;

  private String status;

  private String thresholdConditionId;

  private String thresholdId;

  private String userPathId;

  private String value;

  private String vuName;

  private String zoneId;

  public AlertEventDetails accuracy(BigDecimal accuracy) {
    this.accuracy = accuracy;
    return this;
  }

  /**
   * Accuracy of the alert
   * @return accuracy
  */
  @Valid 
  @Schema(name = "accuracy", description = "Accuracy of the alert", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("accuracy")
  public BigDecimal getAccuracy() {
    return accuracy;
  }

  public void setAccuracy(BigDecimal accuracy) {
    this.accuracy = accuracy;
  }

  public AlertEventDetails expectedValue(BigDecimal expectedValue) {
    this.expectedValue = expectedValue;
    return this;
  }

  /**
   * Expected value of the alert
   * @return expectedValue
  */
  @Valid 
  @Schema(name = "expectedValue", description = "Expected value of the alert", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("expectedValue")
  public BigDecimal getExpectedValue() {
    return expectedValue;
  }

  public void setExpectedValue(BigDecimal expectedValue) {
    this.expectedValue = expectedValue;
  }

  public AlertEventDetails monitor(String monitor) {
    this.monitor = monitor;
    return this;
  }

  /**
   * Monitor of the alert
   * @return monitor
  */
  
  @Schema(name = "monitor", description = "Monitor of the alert", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("monitor")
  public String getMonitor() {
    return monitor;
  }

  public void setMonitor(String monitor) {
    this.monitor = monitor;
  }

  public AlertEventDetails monitoredMachine(String monitoredMachine) {
    this.monitoredMachine = monitoredMachine;
    return this;
  }

  /**
   * Monitored machine of the alert
   * @return monitoredMachine
  */
  
  @Schema(name = "monitoredMachine", description = "Monitored machine of the alert", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("monitoredMachine")
  public String getMonitoredMachine() {
    return monitoredMachine;
  }

  public void setMonitoredMachine(String monitoredMachine) {
    this.monitoredMachine = monitoredMachine;
  }

  public AlertEventDetails populationName(String populationName) {
    this.populationName = populationName;
    return this;
  }

  /**
   * Population name of the alert
   * @return populationName
  */
  
  @Schema(name = "populationName", description = "Population name of the alert", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("populationName")
  public String getPopulationName() {
    return populationName;
  }

  public void setPopulationName(String populationName) {
    this.populationName = populationName;
  }

  public AlertEventDetails severity(String severity) {
    this.severity = severity;
    return this;
  }

  /**
   * Severity of the alert
   * @return severity
  */
  
  @Schema(name = "severity", description = "Severity of the alert", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("severity")
  public String getSeverity() {
    return severity;
  }

  public void setSeverity(String severity) {
    this.severity = severity;
  }

  public AlertEventDetails slaProfileId(String slaProfileId) {
    this.slaProfileId = slaProfileId;
    return this;
  }

  /**
   * Sla profile id of the alert
   * @return slaProfileId
  */
  
  @Schema(name = "slaProfileId", description = "Sla profile id of the alert", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("slaProfileId")
  public String getSlaProfileId() {
    return slaProfileId;
  }

  public void setSlaProfileId(String slaProfileId) {
    this.slaProfileId = slaProfileId;
  }

  public AlertEventDetails slaType(String slaType) {
    this.slaType = slaType;
    return this;
  }

  /**
   * Sla type of the alert
   * @return slaType
  */
  
  @Schema(name = "slaType", description = "Sla type of the alert", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("slaType")
  public String getSlaType() {
    return slaType;
  }

  public void setSlaType(String slaType) {
    this.slaType = slaType;
  }

  public AlertEventDetails status(String status) {
    this.status = status;
    return this;
  }

  /**
   * Status of the alert
   * @return status
  */
  
  @Schema(name = "status", description = "Status of the alert", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("status")
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public AlertEventDetails thresholdConditionId(String thresholdConditionId) {
    this.thresholdConditionId = thresholdConditionId;
    return this;
  }

  /**
   * Threshold condition id of the alert
   * @return thresholdConditionId
  */
  
  @Schema(name = "thresholdConditionId", description = "Threshold condition id of the alert", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("thresholdConditionId")
  public String getThresholdConditionId() {
    return thresholdConditionId;
  }

  public void setThresholdConditionId(String thresholdConditionId) {
    this.thresholdConditionId = thresholdConditionId;
  }

  public AlertEventDetails thresholdId(String thresholdId) {
    this.thresholdId = thresholdId;
    return this;
  }

  /**
   * Threshold id of the alert
   * @return thresholdId
  */
  
  @Schema(name = "thresholdId", description = "Threshold id of the alert", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("thresholdId")
  public String getThresholdId() {
    return thresholdId;
  }

  public void setThresholdId(String thresholdId) {
    this.thresholdId = thresholdId;
  }

  public AlertEventDetails userPathId(String userPathId) {
    this.userPathId = userPathId;
    return this;
  }

  /**
   * User path id of the alert
   * @return userPathId
  */
  
  @Schema(name = "userPathId", description = "User path id of the alert", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("userPathId")
  public String getUserPathId() {
    return userPathId;
  }

  public void setUserPathId(String userPathId) {
    this.userPathId = userPathId;
  }

  public AlertEventDetails value(String value) {
    this.value = value;
    return this;
  }

  /**
   * Value of the alert
   * @return value
  */
  
  @Schema(name = "value", description = "Value of the alert", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("value")
  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public AlertEventDetails vuName(String vuName) {
    this.vuName = vuName;
    return this;
  }

  /**
   * Vuname of the alert
   * @return vuName
  */
  
  @Schema(name = "vuName", description = "Vuname of the alert", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("vuName")
  public String getVuName() {
    return vuName;
  }

  public void setVuName(String vuName) {
    this.vuName = vuName;
  }

  public AlertEventDetails zoneId(String zoneId) {
    this.zoneId = zoneId;
    return this;
  }

  /**
   * Zone id of the alert
   * @return zoneId
  */
  
  @Schema(name = "zoneId", description = "Zone id of the alert", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
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
    AlertEventDetails alertEventDetails = (AlertEventDetails) o;
    return Objects.equals(this.accuracy, alertEventDetails.accuracy) &&
        Objects.equals(this.expectedValue, alertEventDetails.expectedValue) &&
        Objects.equals(this.monitor, alertEventDetails.monitor) &&
        Objects.equals(this.monitoredMachine, alertEventDetails.monitoredMachine) &&
        Objects.equals(this.populationName, alertEventDetails.populationName) &&
        Objects.equals(this.severity, alertEventDetails.severity) &&
        Objects.equals(this.slaProfileId, alertEventDetails.slaProfileId) &&
        Objects.equals(this.slaType, alertEventDetails.slaType) &&
        Objects.equals(this.status, alertEventDetails.status) &&
        Objects.equals(this.thresholdConditionId, alertEventDetails.thresholdConditionId) &&
        Objects.equals(this.thresholdId, alertEventDetails.thresholdId) &&
        Objects.equals(this.userPathId, alertEventDetails.userPathId) &&
        Objects.equals(this.value, alertEventDetails.value) &&
        Objects.equals(this.vuName, alertEventDetails.vuName) &&
        Objects.equals(this.zoneId, alertEventDetails.zoneId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accuracy, expectedValue, monitor, monitoredMachine, populationName, severity, slaProfileId, slaType, status, thresholdConditionId, thresholdId, userPathId, value, vuName, zoneId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AlertEventDetails {\n");
    sb.append("    accuracy: ").append(toIndentedString(accuracy)).append("\n");
    sb.append("    expectedValue: ").append(toIndentedString(expectedValue)).append("\n");
    sb.append("    monitor: ").append(toIndentedString(monitor)).append("\n");
    sb.append("    monitoredMachine: ").append(toIndentedString(monitoredMachine)).append("\n");
    sb.append("    populationName: ").append(toIndentedString(populationName)).append("\n");
    sb.append("    severity: ").append(toIndentedString(severity)).append("\n");
    sb.append("    slaProfileId: ").append(toIndentedString(slaProfileId)).append("\n");
    sb.append("    slaType: ").append(toIndentedString(slaType)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    thresholdConditionId: ").append(toIndentedString(thresholdConditionId)).append("\n");
    sb.append("    thresholdId: ").append(toIndentedString(thresholdId)).append("\n");
    sb.append("    userPathId: ").append(toIndentedString(userPathId)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("    vuName: ").append(toIndentedString(vuName)).append("\n");
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


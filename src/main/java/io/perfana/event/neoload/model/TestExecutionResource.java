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
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Test execution actual resources used, they can be different from the configuration
 */

@Schema(name = "TestExecutionResource", description = "Test execution actual resources used, they can be different from the configuration")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-04-06T15:29:22.895694+02:00[Europe/Amsterdam]", comments = "Generator version: 7.4.0")
public class TestExecutionResource {

  private String controllerZone;

  @Valid
  private Map<String, Integer> lgCountByZoneId = new HashMap<>();

  private Boolean cloudOverConsumption;

  @Valid
  private Map<String, Double> consumedCurrencyByConcurrencyType = new HashMap<>();

  private Duration maximumDuration;

  @Valid
  private Map<String, Integer> missingDedicatedIpByZone = new HashMap<>();

  private String reservationId;

  private String resourcesVersion;

  @Valid
  private Map<String, Integer> usedConcurrencyByConcurrencyType = new HashMap<>();

  public TestExecutionResource() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public TestExecutionResource(String controllerZone, Map<String, Integer> lgCountByZoneId) {
    this.controllerZone = controllerZone;
    this.lgCountByZoneId = lgCountByZoneId;
  }

  public TestExecutionResource controllerZone(String controllerZone) {
    this.controllerZone = controllerZone;
    return this;
  }

  /**
   * The zone where was located the controller
   * @return controllerZone
  */
  @NotNull @Pattern(regexp = "^[0-9a-zA-Z]{5,6}|defaultzone$") 
  @Schema(name = "controllerZone", example = "defaultzone", description = "The zone where was located the controller", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("controllerZone")
  public String getControllerZone() {
    return controllerZone;
  }

  public void setControllerZone(String controllerZone) {
    this.controllerZone = controllerZone;
  }

  public TestExecutionResource lgCountByZoneId(Map<String, Integer> lgCountByZoneId) {
    this.lgCountByZoneId = lgCountByZoneId;
    return this;
  }

  public TestExecutionResource putLgCountByZoneIdItem(String key, Integer lgCountByZoneIdItem) {
    if (this.lgCountByZoneId == null) {
      this.lgCountByZoneId = new HashMap<>();
    }
    this.lgCountByZoneId.put(key, lgCountByZoneIdItem);
    return this;
  }

  /**
   * Count of LG for each zone id used
   * @return lgCountByZoneId
  */
  @NotNull @Size(min = 1) 
  @Schema(name = "lgCountByZoneId", example = "{\"defaultzone\":1,\"otherZone\":1}", description = "Count of LG for each zone id used", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("lgCountByZoneId")
  public Map<String, Integer> getLgCountByZoneId() {
    return lgCountByZoneId;
  }

  public void setLgCountByZoneId(Map<String, Integer> lgCountByZoneId) {
    this.lgCountByZoneId = lgCountByZoneId;
  }

  public TestExecutionResource cloudOverConsumption(Boolean cloudOverConsumption) {
    this.cloudOverConsumption = cloudOverConsumption;
    return this;
  }

  /**
   * True when the test execution is in Cloud over consumption. Present when Cloud infrastructure is used.
   * @return cloudOverConsumption
  */
  
  @Schema(name = "cloudOverConsumption", description = "True when the test execution is in Cloud over consumption. Present when Cloud infrastructure is used.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("cloudOverConsumption")
  public Boolean getCloudOverConsumption() {
    return cloudOverConsumption;
  }

  public void setCloudOverConsumption(Boolean cloudOverConsumption) {
    this.cloudOverConsumption = cloudOverConsumption;
  }

  public TestExecutionResource consumedCurrencyByConcurrencyType(Map<String, Double> consumedCurrencyByConcurrencyType) {
    this.consumedCurrencyByConcurrencyType = consumedCurrencyByConcurrencyType;
    return this;
  }

  public TestExecutionResource putConsumedCurrencyByConcurrencyTypeItem(String key, Double consumedCurrencyByConcurrencyTypeItem) {
    if (this.consumedCurrencyByConcurrencyType == null) {
      this.consumedCurrencyByConcurrencyType = new HashMap<>();
    }
    this.consumedCurrencyByConcurrencyType.put(key, consumedCurrencyByConcurrencyTypeItem);
    return this;
  }

  /**
   * Count of concurrency consumed for each consumable concurrency type. Allowed keys are 'VUH' and 'CLOUD_CREDITS'.
   * @return consumedCurrencyByConcurrencyType
  */
  
  @Schema(name = "consumedCurrencyByConcurrencyType", example = "{\"VUH\":10,\"CLOUD_CREDITS\":10}", description = "Count of concurrency consumed for each consumable concurrency type. Allowed keys are 'VUH' and 'CLOUD_CREDITS'.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("consumedCurrencyByConcurrencyType")
  public Map<String, Double> getConsumedCurrencyByConcurrencyType() {
    return consumedCurrencyByConcurrencyType;
  }

  public void setConsumedCurrencyByConcurrencyType(Map<String, Double> consumedCurrencyByConcurrencyType) {
    this.consumedCurrencyByConcurrencyType = consumedCurrencyByConcurrencyType;
  }

  public TestExecutionResource maximumDuration(Duration maximumDuration) {
    this.maximumDuration = maximumDuration;
    return this;
  }

  /**
   * Maximum duration of the execution.
   * @return maximumDuration
  */
  @Schema(name = "maximumDuration", description = "Maximum duration of the execution.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("maximumDuration")
  public Duration getMaximumDuration() {
    return maximumDuration;
  }

  public void setMaximumDuration(Duration maximumDuration) {
    this.maximumDuration = maximumDuration;
  }

  public TestExecutionResource missingDedicatedIpByZone(Map<String, Integer> missingDedicatedIpByZone) {
    this.missingDedicatedIpByZone = missingDedicatedIpByZone;
    return this;
  }

  public TestExecutionResource putMissingDedicatedIpByZoneItem(String key, Integer missingDedicatedIpByZoneItem) {
    if (this.missingDedicatedIpByZone == null) {
      this.missingDedicatedIpByZone = new HashMap<>();
    }
    this.missingDedicatedIpByZone.put(key, missingDedicatedIpByZoneItem);
    return this;
  }

  /**
   * Missing dedicated IPs by Cloud zone
   * @return missingDedicatedIpByZone
  */
  
  @Schema(name = "missingDedicatedIpByZone", description = "Missing dedicated IPs by Cloud zone", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("missingDedicatedIpByZone")
  public Map<String, Integer> getMissingDedicatedIpByZone() {
    return missingDedicatedIpByZone;
  }

  public void setMissingDedicatedIpByZone(Map<String, Integer> missingDedicatedIpByZone) {
    this.missingDedicatedIpByZone = missingDedicatedIpByZone;
  }

  public TestExecutionResource reservationId(String reservationId) {
    this.reservationId = reservationId;
    return this;
  }

  /**
   * ID of the reservation used for the test
   * @return reservationId
  */
  @Pattern(regexp = "^[0-9a-fA-F]{8}-([0-9a-fA-F]{4}-){3}[0-9a-fA-F]{12}$") 
  @Schema(name = "reservationId", example = "123e4567-e89b-12d3-a456-426655440000", description = "ID of the reservation used for the test", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("reservationId")
  public String getReservationId() {
    return reservationId;
  }

  public void setReservationId(String reservationId) {
    this.reservationId = reservationId;
  }

  public TestExecutionResource resourcesVersion(String resourcesVersion) {
    this.resourcesVersion = resourcesVersion;
    return this;
  }

  /**
   * Resource version used for the test run
   * @return resourcesVersion
  */
  
  @Schema(name = "resourcesVersion", example = "2023.4.0", description = "Resource version used for the test run", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("resourcesVersion")
  public String getResourcesVersion() {
    return resourcesVersion;
  }

  public void setResourcesVersion(String resourcesVersion) {
    this.resourcesVersion = resourcesVersion;
  }

  public TestExecutionResource usedConcurrencyByConcurrencyType(Map<String, Integer> usedConcurrencyByConcurrencyType) {
    this.usedConcurrencyByConcurrencyType = usedConcurrencyByConcurrencyType;
    return this;
  }

  public TestExecutionResource putUsedConcurrencyByConcurrencyTypeItem(String key, Integer usedConcurrencyByConcurrencyTypeItem) {
    if (this.usedConcurrencyByConcurrencyType == null) {
      this.usedConcurrencyByConcurrencyType = new HashMap<>();
    }
    this.usedConcurrencyByConcurrencyType.put(key, usedConcurrencyByConcurrencyTypeItem);
    return this;
  }

  /**
   * Count of concurrency used for each reusable concurrency type. Allowed keys are 'WEB' and 'SAP'.
   * @return usedConcurrencyByConcurrencyType
  */
  
  @Schema(name = "usedConcurrencyByConcurrencyType", example = "{\"WEB\":10,\"SAP\":10}", description = "Count of concurrency used for each reusable concurrency type. Allowed keys are 'WEB' and 'SAP'.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("usedConcurrencyByConcurrencyType")
  public Map<String, Integer> getUsedConcurrencyByConcurrencyType() {
    return usedConcurrencyByConcurrencyType;
  }

  public void setUsedConcurrencyByConcurrencyType(Map<String, Integer> usedConcurrencyByConcurrencyType) {
    this.usedConcurrencyByConcurrencyType = usedConcurrencyByConcurrencyType;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TestExecutionResource testExecutionResource = (TestExecutionResource) o;
    return Objects.equals(this.controllerZone, testExecutionResource.controllerZone) &&
        Objects.equals(this.lgCountByZoneId, testExecutionResource.lgCountByZoneId) &&
        Objects.equals(this.cloudOverConsumption, testExecutionResource.cloudOverConsumption) &&
        Objects.equals(this.consumedCurrencyByConcurrencyType, testExecutionResource.consumedCurrencyByConcurrencyType) &&
        Objects.equals(this.maximumDuration, testExecutionResource.maximumDuration) &&
        Objects.equals(this.missingDedicatedIpByZone, testExecutionResource.missingDedicatedIpByZone) &&
        Objects.equals(this.reservationId, testExecutionResource.reservationId) &&
        Objects.equals(this.resourcesVersion, testExecutionResource.resourcesVersion) &&
        Objects.equals(this.usedConcurrencyByConcurrencyType, testExecutionResource.usedConcurrencyByConcurrencyType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(controllerZone, lgCountByZoneId, cloudOverConsumption, consumedCurrencyByConcurrencyType, maximumDuration, missingDedicatedIpByZone, reservationId, resourcesVersion, usedConcurrencyByConcurrencyType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TestExecutionResource {\n");
    sb.append("    controllerZone: ").append(toIndentedString(controllerZone)).append("\n");
    sb.append("    lgCountByZoneId: ").append(toIndentedString(lgCountByZoneId)).append("\n");
    sb.append("    cloudOverConsumption: ").append(toIndentedString(cloudOverConsumption)).append("\n");
    sb.append("    consumedCurrencyByConcurrencyType: ").append(toIndentedString(consumedCurrencyByConcurrencyType)).append("\n");
    sb.append("    maximumDuration: ").append(toIndentedString(maximumDuration)).append("\n");
    sb.append("    missingDedicatedIpByZone: ").append(toIndentedString(missingDedicatedIpByZone)).append("\n");
    sb.append("    reservationId: ").append(toIndentedString(reservationId)).append("\n");
    sb.append("    resourcesVersion: ").append(toIndentedString(resourcesVersion)).append("\n");
    sb.append("    usedConcurrencyByConcurrencyType: ").append(toIndentedString(usedConcurrencyByConcurrencyType)).append("\n");
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


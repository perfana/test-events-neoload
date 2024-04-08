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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
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
 * Test configuration used to create the test execution
 */

@Schema(name = "TestExecutionConfiguration", description = "Test configuration used to create the test execution")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-04-06T15:29:22.895694+02:00[Europe/Amsterdam]", comments = "Generator version: 7.4.0")
public class TestExecutionConfiguration {

  private String controllerZone;

  @Valid
  private Map<String, Integer> lgCountByZoneId = new HashMap<>();

  private String projectName;

  private String scenarioName;

  private String testId;

  @Valid
  private Map<String, Integer> vuCountByVuType = new HashMap<>();

  /**
   * The zone type of the controller and LG
   */
  public enum ZoneTypeEnum {
    STATIC("STATIC"),
    
    DYNAMIC("DYNAMIC"),
    
    NEOLOAD_CLOUD("NEOLOAD_CLOUD");

    private String value;

    ZoneTypeEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static ZoneTypeEnum fromValue(String value) {
      for (ZoneTypeEnum b : ZoneTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private ZoneTypeEnum zoneType;

  private String minimumResourcesVersion;

  private Duration testDuration;

  public TestExecutionConfiguration() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public TestExecutionConfiguration(String controllerZone, Map<String, Integer> lgCountByZoneId, String projectName, String scenarioName, String testId, Map<String, Integer> vuCountByVuType, ZoneTypeEnum zoneType) {
    this.controllerZone = controllerZone;
    this.lgCountByZoneId = lgCountByZoneId;
    this.projectName = projectName;
    this.scenarioName = scenarioName;
    this.testId = testId;
    this.vuCountByVuType = vuCountByVuType;
    this.zoneType = zoneType;
  }

  public TestExecutionConfiguration controllerZone(String controllerZone) {
    this.controllerZone = controllerZone;
    return this;
  }

  /**
   * The zone id where will be located the controller
   * @return controllerZone
  */
  @NotNull @Pattern(regexp = "^[0-9a-zA-Z]{5,6}|defaultzone$") 
  @Schema(name = "controllerZone", example = "defaultzone", description = "The zone id where will be located the controller", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("controllerZone")
  public String getControllerZone() {
    return controllerZone;
  }

  public void setControllerZone(String controllerZone) {
    this.controllerZone = controllerZone;
  }

  public TestExecutionConfiguration lgCountByZoneId(Map<String, Integer> lgCountByZoneId) {
    this.lgCountByZoneId = lgCountByZoneId;
    return this;
  }

  public TestExecutionConfiguration putLgCountByZoneIdItem(String key, Integer lgCountByZoneIdItem) {
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

  public TestExecutionConfiguration projectName(String projectName) {
    this.projectName = projectName;
    return this;
  }

  /**
   * Project name of the test run
   * @return projectName
  */
  @NotNull 
  @Schema(name = "projectName", example = "SampleProject.zip", description = "Project name of the test run", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("projectName")
  public String getProjectName() {
    return projectName;
  }

  public void setProjectName(String projectName) {
    this.projectName = projectName;
  }

  public TestExecutionConfiguration scenarioName(String scenarioName) {
    this.scenarioName = scenarioName;
    return this;
  }

  /**
   * Scenario name of the test run
   * @return scenarioName
  */
  @NotNull 
  @Schema(name = "scenarioName", example = "HEAVY_LOAD-LOGIN", description = "Scenario name of the test run", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("scenarioName")
  public String getScenarioName() {
    return scenarioName;
  }

  public void setScenarioName(String scenarioName) {
    this.scenarioName = scenarioName;
  }

  public TestExecutionConfiguration testId(String testId) {
    this.testId = testId;
    return this;
  }

  /**
   * Test setting id which will be used to configure the test execution
   * @return testId
  */
  @NotNull @Pattern(regexp = "^[0-9a-fA-F]{8}-([0-9a-fA-F]{4}-){3}[0-9a-fA-F]{12}$") 
  @Schema(name = "testId", example = "123e4567-e89b-12d3-a456-426655440000", description = "Test setting id which will be used to configure the test execution", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("testId")
  public String getTestId() {
    return testId;
  }

  public void setTestId(String testId) {
    this.testId = testId;
  }

  public TestExecutionConfiguration vuCountByVuType(Map<String, Integer> vuCountByVuType) {
    this.vuCountByVuType = vuCountByVuType;
    return this;
  }

  public TestExecutionConfiguration putVuCountByVuTypeItem(String key, Integer vuCountByVuTypeItem) {
    if (this.vuCountByVuType == null) {
      this.vuCountByVuType = new HashMap<>();
    }
    this.vuCountByVuType.put(key, vuCountByVuTypeItem);
    return this;
  }

  /**
   * Count of VU needed for each Vu type to run the test. Allowed keys are 'WEB' and 'SAP'.
   * @return vuCountByVuType
  */
  @NotNull 
  @Schema(name = "vuCountByVuType", example = "{\"WEB\":10,\"SAP\":10}", description = "Count of VU needed for each Vu type to run the test. Allowed keys are 'WEB' and 'SAP'.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("vuCountByVuType")
  public Map<String, Integer> getVuCountByVuType() {
    return vuCountByVuType;
  }

  public void setVuCountByVuType(Map<String, Integer> vuCountByVuType) {
    this.vuCountByVuType = vuCountByVuType;
  }

  public TestExecutionConfiguration zoneType(ZoneTypeEnum zoneType) {
    this.zoneType = zoneType;
    return this;
  }

  /**
   * The zone type of the controller and LG
   * @return zoneType
  */
  @NotNull 
  @Schema(name = "zoneType", example = "STATIC", description = "The zone type of the controller and LG", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("zoneType")
  public ZoneTypeEnum getZoneType() {
    return zoneType;
  }

  public void setZoneType(ZoneTypeEnum zoneType) {
    this.zoneType = zoneType;
  }

  public TestExecutionConfiguration minimumResourcesVersion(String minimumResourcesVersion) {
    this.minimumResourcesVersion = minimumResourcesVersion;
    return this;
  }

  /**
   * Minimum resources version compatible with this project, may be unknown if NeoLoad Web version is older than the NeoLoad GUI version used.
   * @return minimumResourcesVersion
  */
  @Pattern(regexp = "^\\d+\\.\\d+.\\d+$") 
  @Schema(name = "minimumResourcesVersion", example = "8.0.0", description = "Minimum resources version compatible with this project, may be unknown if NeoLoad Web version is older than the NeoLoad GUI version used.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("minimumResourcesVersion")
  public String getMinimumResourcesVersion() {
    return minimumResourcesVersion;
  }

  public void setMinimumResourcesVersion(String minimumResourcesVersion) {
    this.minimumResourcesVersion = minimumResourcesVersion;
  }

  public TestExecutionConfiguration testDuration(Duration testDuration) {
    this.testDuration = testDuration;
    return this;
  }

  /**
   * Duration of the scenario, duration is absent in iteration or when the scenario have an unlimited duration
   * @return testDuration
  */
  @Schema(name = "testDuration", description = "Duration of the scenario, duration is absent in iteration or when the scenario have an unlimited duration", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("testDuration")
  public Duration getTestDuration() {
    return testDuration;
  }

  public void setTestDuration(Duration testDuration) {
    this.testDuration = testDuration;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TestExecutionConfiguration testExecutionConfiguration = (TestExecutionConfiguration) o;
    return Objects.equals(this.controllerZone, testExecutionConfiguration.controllerZone) &&
        Objects.equals(this.lgCountByZoneId, testExecutionConfiguration.lgCountByZoneId) &&
        Objects.equals(this.projectName, testExecutionConfiguration.projectName) &&
        Objects.equals(this.scenarioName, testExecutionConfiguration.scenarioName) &&
        Objects.equals(this.testId, testExecutionConfiguration.testId) &&
        Objects.equals(this.vuCountByVuType, testExecutionConfiguration.vuCountByVuType) &&
        Objects.equals(this.zoneType, testExecutionConfiguration.zoneType) &&
        Objects.equals(this.minimumResourcesVersion, testExecutionConfiguration.minimumResourcesVersion) &&
        Objects.equals(this.testDuration, testExecutionConfiguration.testDuration);
  }

  @Override
  public int hashCode() {
    return Objects.hash(controllerZone, lgCountByZoneId, projectName, scenarioName, testId, vuCountByVuType, zoneType, minimumResourcesVersion, testDuration);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TestExecutionConfiguration {\n");
    sb.append("    controllerZone: ").append(toIndentedString(controllerZone)).append("\n");
    sb.append("    lgCountByZoneId: ").append(toIndentedString(lgCountByZoneId)).append("\n");
    sb.append("    projectName: ").append(toIndentedString(projectName)).append("\n");
    sb.append("    scenarioName: ").append(toIndentedString(scenarioName)).append("\n");
    sb.append("    testId: ").append(toIndentedString(testId)).append("\n");
    sb.append("    vuCountByVuType: ").append(toIndentedString(vuCountByVuType)).append("\n");
    sb.append("    zoneType: ").append(toIndentedString(zoneType)).append("\n");
    sb.append("    minimumResourcesVersion: ").append(toIndentedString(minimumResourcesVersion)).append("\n");
    sb.append("    testDuration: ").append(toIndentedString(testDuration)).append("\n");
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


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

import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Test
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-04-06T15:29:22.895694+02:00[Europe/Amsterdam]", comments = "Generator version: 7.4.0")
public class Test {

  private String id;


  private OffsetDateTime createdAt;

  private String name;


  private OffsetDateTime updatedAt;

  private String workspaceId;

  @Valid
  private Map<String, String> controllerEnvironmentVariables = new HashMap<>();

  private String controllerZoneId;

  private String description;

  private Boolean isConfigured;


  private OffsetDateTime lastRunDate;

  @Valid
  private Map<String, Integer> lgsByZone = new HashMap<>();

  private String projectName;

  private String selectedScenarioName;

  private String testResultNameTemplate;

  private String userModifierName;

  public Test() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public Test(String id, OffsetDateTime createdAt, String name, OffsetDateTime updatedAt, String workspaceId) {
    this.id = id;
    this.createdAt = createdAt;
    this.name = name;
    this.updatedAt = updatedAt;
    this.workspaceId = workspaceId;
  }

  public Test id(String id) {
    this.id = id;
    return this;
  }

  /**
   * ID
   * @return id
  */
  @NotNull @Pattern(regexp = "^[0-9a-fA-F]{8}-([0-9a-fA-F]{4}-){3}[0-9a-fA-F]{12}$") 
  @Schema(name = "id", example = "123e4567-e89b-12d3-a456-426655440000", description = "ID", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("id")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Test createdAt(OffsetDateTime createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  /**
   * Date and time in UTC when the entity was created.
   * @return createdAt
  */
  @NotNull @Valid 
  @Schema(name = "createdAt", example = "2021-01-30T08:30Z", description = "Date and time in UTC when the entity was created.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("createdAt")
  public OffsetDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(OffsetDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public Test name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Test name, name need to be unique between all tests in a same workspace
   * @return name
  */
  @NotNull @Pattern(regexp = "\\S+$") @Size(min = 1, max = 100) 
  @Schema(name = "name", example = "Trial user paths", description = "Test name, name need to be unique between all tests in a same workspace", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Test updatedAt(OffsetDateTime updatedAt) {
    this.updatedAt = updatedAt;
    return this;
  }

  /**
   * Date and time in UTC when the entity was updated for the last time
   * @return updatedAt
  */
  @NotNull @Valid 
  @Schema(name = "updatedAt", example = "2021-01-30T08:30Z", description = "Date and time in UTC when the entity was updated for the last time", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("updatedAt")
  public OffsetDateTime getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(OffsetDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }

  public Test workspaceId(String workspaceId) {
    this.workspaceId = workspaceId;
    return this;
  }

  /**
   * Unique identifier representing a Workspace.
   * @return workspaceId
  */
  @NotNull @Pattern(regexp = "^[0-9a-f]{24}$") 
  @Schema(name = "workspaceId", example = "69c9a277bb9a473ca3d0d567", description = "Unique identifier representing a Workspace.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("workspaceId")
  public String getWorkspaceId() {
    return workspaceId;
  }

  public void setWorkspaceId(String workspaceId) {
    this.workspaceId = workspaceId;
  }

  public Test controllerEnvironmentVariables(Map<String, String> controllerEnvironmentVariables) {
    this.controllerEnvironmentVariables = controllerEnvironmentVariables;
    return this;
  }

  public Test putControllerEnvironmentVariablesItem(String key, String controllerEnvironmentVariablesItem) {
    if (this.controllerEnvironmentVariables == null) {
      this.controllerEnvironmentVariables = new HashMap<>();
    }
    this.controllerEnvironmentVariables.put(key, controllerEnvironmentVariablesItem);
    return this;
  }

  /**
   * Controller environment variables. Allows to override controller.properties with a key NL_PROPERTY_[CATEGORY]_[MY_PROPERTY] and a value [VALUE]
   * @return controllerEnvironmentVariables
  */
  
  @Schema(name = "controllerEnvironmentVariables", description = "Controller environment variables. Allows to override controller.properties with a key NL_PROPERTY_[CATEGORY]_[MY_PROPERTY] and a value [VALUE]", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("controllerEnvironmentVariables")
  public Map<String, String> getControllerEnvironmentVariables() {
    return controllerEnvironmentVariables;
  }

  public void setControllerEnvironmentVariables(Map<String, String> controllerEnvironmentVariables) {
    this.controllerEnvironmentVariables = controllerEnvironmentVariables;
  }

  public Test controllerZoneId(String controllerZoneId) {
    this.controllerZoneId = controllerZoneId;
    return this;
  }

  /**
   * Controller zone, the zoneId is given
   * @return controllerZoneId
  */
  @Pattern(regexp = "^[0-9a-zA-Z]{5,6}|defaultzone$") 
  @Schema(name = "controllerZoneId", example = "defaultzone", description = "Controller zone, the zoneId is given", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("controllerZoneId")
  public String getControllerZoneId() {
    return controllerZoneId;
  }

  public void setControllerZoneId(String controllerZoneId) {
    this.controllerZoneId = controllerZoneId;
  }

  public Test description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Test description
   * @return description
  */
  @Size(max = 500) 
  @Schema(name = "description", example = "Load test on common trial user usage", description = "Test description", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("description")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Test isConfigured(Boolean isConfigured) {
    this.isConfigured = isConfigured;
    return this;
  }

  /**
   * Whether the project if fully configured and ready to run.
   * @return isConfigured
  */
  
  @Schema(name = "isConfigured", example = "true", description = "Whether the project if fully configured and ready to run.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("isConfigured")
  public Boolean getIsConfigured() {
    return isConfigured;
  }

  public void setIsConfigured(Boolean isConfigured) {
    this.isConfigured = isConfigured;
  }

  public Test lastRunDate(OffsetDateTime lastRunDate) {
    this.lastRunDate = lastRunDate;
    return this;
  }

  /**
   * Date and time in UTC when the last run on this test was done.
   * @return lastRunDate
  */
  @Valid 
  @Schema(name = "lastRunDate", example = "2021-01-30T08:30Z", description = "Date and time in UTC when the last run on this test was done.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("lastRunDate")
  public OffsetDateTime getLastRunDate() {
    return lastRunDate;
  }

  public void setLastRunDate(OffsetDateTime lastRunDate) {
    this.lastRunDate = lastRunDate;
  }

  public Test lgsByZone(Map<String, Integer> lgsByZone) {
    this.lgsByZone = lgsByZone;
    return this;
  }

  public Test putLgsByZoneItem(String key, Integer lgsByZoneItem) {
    if (this.lgsByZone == null) {
      this.lgsByZone = new HashMap<>();
    }
    this.lgsByZone.put(key, lgsByZoneItem);
    return this;
  }

  /**
   * Load Generators zones, the key is the zoneId
   * @return lgsByZone
  */
  
  @Schema(name = "lgsByZone", description = "Load Generators zones, the key is the zoneId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("lgsByZone")
  public Map<String, Integer> getLgsByZone() {
    return lgsByZone;
  }

  public void setLgsByZone(Map<String, Integer> lgsByZone) {
    this.lgsByZone = lgsByZone;
  }

  public Test projectName(String projectName) {
    this.projectName = projectName;
    return this;
  }

  /**
   * Project name used in the test setting
   * @return projectName
  */
  
  @Schema(name = "projectName", example = "Sample project", description = "Project name used in the test setting", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("projectName")
  public String getProjectName() {
    return projectName;
  }

  public void setProjectName(String projectName) {
    this.projectName = projectName;
  }

  public Test selectedScenarioName(String selectedScenarioName) {
    this.selectedScenarioName = selectedScenarioName;
    return this;
  }

  /**
   * Selected scenario in the uploaded project or test name for selecting the custom scenario
   * @return selectedScenarioName
  */
  
  @Schema(name = "selectedScenarioName", example = "Scenario1", description = "Selected scenario in the uploaded project or test name for selecting the custom scenario", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("selectedScenarioName")
  public String getSelectedScenarioName() {
    return selectedScenarioName;
  }

  public void setSelectedScenarioName(String selectedScenarioName) {
    this.selectedScenarioName = selectedScenarioName;
  }

  public Test testResultNameTemplate(String testResultNameTemplate) {
    this.testResultNameTemplate = testResultNameTemplate;
    return this;
  }

  /**
   * Test Result name template. Variable ${runID} is available, it's a value which is incremented for each run done on the test
   * @return testResultNameTemplate
  */
  
  @Schema(name = "testResultNameTemplate", example = "ProjectA Scenario1 #${runID}", description = "Test Result name template. Variable ${runID} is available, it's a value which is incremented for each run done on the test", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("testResultNameTemplate")
  public String getTestResultNameTemplate() {
    return testResultNameTemplate;
  }

  public void setTestResultNameTemplate(String testResultNameTemplate) {
    this.testResultNameTemplate = testResultNameTemplate;
  }

  public Test userModifierName(String userModifierName) {
    this.userModifierName = userModifierName;
    return this;
  }

  /**
   * Identifier of the user who modified the entity
   * @return userModifierName
  */
  
  @Schema(name = "userModifierName", example = "Bobby", description = "Identifier of the user who modified the entity", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("userModifierName")
  public String getUserModifierName() {
    return userModifierName;
  }

  public void setUserModifierName(String userModifierName) {
    this.userModifierName = userModifierName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Test test = (Test) o;
    return Objects.equals(this.id, test.id) &&
        Objects.equals(this.createdAt, test.createdAt) &&
        Objects.equals(this.name, test.name) &&
        Objects.equals(this.updatedAt, test.updatedAt) &&
        Objects.equals(this.workspaceId, test.workspaceId) &&
        Objects.equals(this.controllerEnvironmentVariables, test.controllerEnvironmentVariables) &&
        Objects.equals(this.controllerZoneId, test.controllerZoneId) &&
        Objects.equals(this.description, test.description) &&
        Objects.equals(this.isConfigured, test.isConfigured) &&
        Objects.equals(this.lastRunDate, test.lastRunDate) &&
        Objects.equals(this.lgsByZone, test.lgsByZone) &&
        Objects.equals(this.projectName, test.projectName) &&
        Objects.equals(this.selectedScenarioName, test.selectedScenarioName) &&
        Objects.equals(this.testResultNameTemplate, test.testResultNameTemplate) &&
        Objects.equals(this.userModifierName, test.userModifierName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, createdAt, name, updatedAt, workspaceId, controllerEnvironmentVariables, controllerZoneId, description, isConfigured, lastRunDate, lgsByZone, projectName, selectedScenarioName, testResultNameTemplate, userModifierName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Test {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    updatedAt: ").append(toIndentedString(updatedAt)).append("\n");
    sb.append("    workspaceId: ").append(toIndentedString(workspaceId)).append("\n");
    sb.append("    controllerEnvironmentVariables: ").append(toIndentedString(controllerEnvironmentVariables)).append("\n");
    sb.append("    controllerZoneId: ").append(toIndentedString(controllerZoneId)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    isConfigured: ").append(toIndentedString(isConfigured)).append("\n");
    sb.append("    lastRunDate: ").append(toIndentedString(lastRunDate)).append("\n");
    sb.append("    lgsByZone: ").append(toIndentedString(lgsByZone)).append("\n");
    sb.append("    projectName: ").append(toIndentedString(projectName)).append("\n");
    sb.append("    selectedScenarioName: ").append(toIndentedString(selectedScenarioName)).append("\n");
    sb.append("    testResultNameTemplate: ").append(toIndentedString(testResultNameTemplate)).append("\n");
    sb.append("    userModifierName: ").append(toIndentedString(userModifierName)).append("\n");
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


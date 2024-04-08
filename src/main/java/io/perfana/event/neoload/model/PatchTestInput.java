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
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Test mutable fields
 */

@Schema(name = "PatchTestInput", description = "Test mutable fields")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-04-06T15:29:22.895694+02:00[Europe/Amsterdam]", comments = "Generator version: 7.4.0")
public class PatchTestInput {

  @Valid
  private Map<String, String> controllerEnvironmentVariables = new HashMap<>();

  private String controllerZoneId;

  private String description;

  @Valid
  private Map<String, Integer> lgsByZone = new HashMap<>();

  private String name;

  private String selectedScenarioName;

  private String testResultNameTemplate;

  private String workspaceId;

  public PatchTestInput controllerEnvironmentVariables(Map<String, String> controllerEnvironmentVariables) {
    this.controllerEnvironmentVariables = controllerEnvironmentVariables;
    return this;
  }

  public PatchTestInput putControllerEnvironmentVariablesItem(String key, String controllerEnvironmentVariablesItem) {
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

  public PatchTestInput controllerZoneId(String controllerZoneId) {
    this.controllerZoneId = controllerZoneId;
    return this;
  }

  /**
   * Controller zone, the zoneId should be given
   * @return controllerZoneId
  */
  @Pattern(regexp = "^[0-9a-zA-Z]{5,6}|defaultzone$") 
  @Schema(name = "controllerZoneId", example = "defaultzone", description = "Controller zone, the zoneId should be given", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("controllerZoneId")
  public String getControllerZoneId() {
    return controllerZoneId;
  }

  public void setControllerZoneId(String controllerZoneId) {
    this.controllerZoneId = controllerZoneId;
  }

  public PatchTestInput description(String description) {
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

  public PatchTestInput lgsByZone(Map<String, Integer> lgsByZone) {
    this.lgsByZone = lgsByZone;
    return this;
  }

  public PatchTestInput putLgsByZoneItem(String key, Integer lgsByZoneItem) {
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

  public PatchTestInput name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Test name, name need to be unique between all tests in a same workspace
   * @return name
  */
  @Pattern(regexp = "\\S+$") @Size(min = 1, max = 100) 
  @Schema(name = "name", example = "Trial user paths", description = "Test name, name need to be unique between all tests in a same workspace", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public PatchTestInput selectedScenarioName(String selectedScenarioName) {
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

  public PatchTestInput testResultNameTemplate(String testResultNameTemplate) {
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

  public PatchTestInput workspaceId(String workspaceId) {
    this.workspaceId = workspaceId;
    return this;
  }

  /**
   * Unique identifier representing a Workspace
   * @return workspaceId
  */
  @Pattern(regexp = "^[0-9a-f]{24}$") 
  @Schema(name = "workspaceId", example = "69c9a277bb9a473ca3d0d567", description = "Unique identifier representing a Workspace", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("workspaceId")
  public String getWorkspaceId() {
    return workspaceId;
  }

  public void setWorkspaceId(String workspaceId) {
    this.workspaceId = workspaceId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PatchTestInput patchTestInput = (PatchTestInput) o;
    return Objects.equals(this.controllerEnvironmentVariables, patchTestInput.controllerEnvironmentVariables) &&
        Objects.equals(this.controllerZoneId, patchTestInput.controllerZoneId) &&
        Objects.equals(this.description, patchTestInput.description) &&
        Objects.equals(this.lgsByZone, patchTestInput.lgsByZone) &&
        Objects.equals(this.name, patchTestInput.name) &&
        Objects.equals(this.selectedScenarioName, patchTestInput.selectedScenarioName) &&
        Objects.equals(this.testResultNameTemplate, patchTestInput.testResultNameTemplate) &&
        Objects.equals(this.workspaceId, patchTestInput.workspaceId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(controllerEnvironmentVariables, controllerZoneId, description, lgsByZone, name, selectedScenarioName, testResultNameTemplate, workspaceId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PatchTestInput {\n");
    sb.append("    controllerEnvironmentVariables: ").append(toIndentedString(controllerEnvironmentVariables)).append("\n");
    sb.append("    controllerZoneId: ").append(toIndentedString(controllerZoneId)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    lgsByZone: ").append(toIndentedString(lgsByZone)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    selectedScenarioName: ").append(toIndentedString(selectedScenarioName)).append("\n");
    sb.append("    testResultNameTemplate: ").append(toIndentedString(testResultNameTemplate)).append("\n");
    sb.append("    workspaceId: ").append(toIndentedString(workspaceId)).append("\n");
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


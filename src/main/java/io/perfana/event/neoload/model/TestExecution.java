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

import java.util.Objects;

/**
 * Field available to create a test execution
 */

@Schema(name = "TestExecution", description = "Field available to create a test execution")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-04-06T15:29:22.895694+02:00[Europe/Amsterdam]", comments = "Generator version: 7.4.0")
public class TestExecution {

  private String id;

  private TestExecutionConfiguration _configuration;

  private String name;

  private TestExecutionResource resources;

  private String workspaceId;

  public TestExecution() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public TestExecution(String id, TestExecutionConfiguration _configuration, String name, TestExecutionResource resources, String workspaceId) {
    this.id = id;
    this._configuration = _configuration;
    this.name = name;
    this.resources = resources;
    this.workspaceId = workspaceId;
  }

  public TestExecution id(String id) {
    this.id = id;
    return this;
  }

  /**
   * ID of the test execution, it is the same id which will be used for the test results
   * @return id
  */
  @NotNull @Pattern(regexp = "^[0-9a-fA-F]{8}-([0-9a-fA-F]{4}-){3}[0-9a-fA-F]{12}$") 
  @Schema(name = "id", example = "123e4567-e89b-12d3-a456-426655440000", description = "ID of the test execution, it is the same id which will be used for the test results", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("id")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public TestExecution _configuration(TestExecutionConfiguration _configuration) {
    this._configuration = _configuration;
    return this;
  }

  /**
   * Get _configuration
   * @return _configuration
  */
  @NotNull @Valid 
  @Schema(name = "configuration", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("configuration")
  public TestExecutionConfiguration getConfiguration() {
    return _configuration;
  }

  public void setConfiguration(TestExecutionConfiguration _configuration) {
    this._configuration = _configuration;
  }

  public TestExecution name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Test execution and result name
   * @return name
  */
  @NotNull @Pattern(regexp = "^[0-9a-f]{24}$") 
  @Schema(name = "name", example = "69c9a277bb9a473ca3d0d567", description = "Test execution and result name", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public TestExecution resources(TestExecutionResource resources) {
    this.resources = resources;
    return this;
  }

  /**
   * Get resources
   * @return resources
  */
  @NotNull @Valid 
  @Schema(name = "resources", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("resources")
  public TestExecutionResource getResources() {
    return resources;
  }

  public void setResources(TestExecutionResource resources) {
    this.resources = resources;
  }

  public TestExecution workspaceId(String workspaceId) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TestExecution testExecution = (TestExecution) o;
    return Objects.equals(this.id, testExecution.id) &&
        Objects.equals(this._configuration, testExecution._configuration) &&
        Objects.equals(this.name, testExecution.name) &&
        Objects.equals(this.resources, testExecution.resources) &&
        Objects.equals(this.workspaceId, testExecution.workspaceId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, _configuration, name, resources, workspaceId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TestExecution {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    _configuration: ").append(toIndentedString(_configuration)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    resources: ").append(toIndentedString(resources)).append("\n");
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


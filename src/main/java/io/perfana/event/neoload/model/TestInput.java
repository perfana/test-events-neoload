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
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.Objects;

/**
 * Test mutable fields
 */

@Schema(name = "TestInput", description = "Test mutable fields")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-04-06T15:29:22.895694+02:00[Europe/Amsterdam]", comments = "Generator version: 7.4.0")
public class TestInput {

  private String name;

  private String workspaceId;

  private String description;

  public TestInput() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public TestInput(String name, String workspaceId) {
    this.name = name;
    this.workspaceId = workspaceId;
  }

  public TestInput name(String name) {
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

  public TestInput workspaceId(String workspaceId) {
    this.workspaceId = workspaceId;
    return this;
  }

  /**
   * Unique identifier representing a Workspace
   * @return workspaceId
  */
  @NotNull @Pattern(regexp = "^[0-9a-f]{24}$") 
  @Schema(name = "workspaceId", example = "69c9a277bb9a473ca3d0d567", description = "Unique identifier representing a Workspace", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("workspaceId")
  public String getWorkspaceId() {
    return workspaceId;
  }

  public void setWorkspaceId(String workspaceId) {
    this.workspaceId = workspaceId;
  }

  public TestInput description(String description) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TestInput testInput = (TestInput) o;
    return Objects.equals(this.name, testInput.name) &&
        Objects.equals(this.workspaceId, testInput.workspaceId) &&
        Objects.equals(this.description, testInput.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, workspaceId, description);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TestInput {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    workspaceId: ").append(toIndentedString(workspaceId)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
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


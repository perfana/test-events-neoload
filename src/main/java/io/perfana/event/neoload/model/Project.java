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

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Project summary from a test setting
 */

@Schema(name = "Project", description = "Project summary from a test setting")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-04-06T15:29:22.895694+02:00[Europe/Amsterdam]", comments = "Generator version: 7.4.0")
public class Project {

  private String name;


  private OffsetDateTime updatedAt;

  @Valid
  private List<@Valid Scenario> scenarios;

  private Long size;

  /**
   * Source from where was retrieved the project, can be unknown for project uploaded before 2022
   */
  public enum SourceEnum {
    GIT("GIT"),
    
    FILE("FILE");

    private String value;

    SourceEnum(String value) {
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
    public static SourceEnum fromValue(String value) {
      for (SourceEnum b : SourceEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private SourceEnum source;

  private String userModifierName;

  public Project() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public Project(String name, OffsetDateTime updatedAt) {
    this.name = name;
    this.updatedAt = updatedAt;
  }

  public Project name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name
   * @return name
  */
  @NotNull 
  @Schema(name = "name", example = "Sample project", description = "Name", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Project updatedAt(OffsetDateTime updatedAt) {
    this.updatedAt = updatedAt;
    return this;
  }

  /**
   * Date and time in UTC when the entity was updated for the last time
   * @return updatedAt
  */
  @NotNull @Valid 
  @Schema(name = "updatedAt", description = "Date and time in UTC when the entity was updated for the last time", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("updatedAt")
  public OffsetDateTime getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(OffsetDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }

  public Project scenarios(List<@Valid Scenario> scenarios) {
    this.scenarios = scenarios;
    return this;
  }

  public Project addScenariosItem(Scenario scenariosItem) {
    if (this.scenarios == null) {
      this.scenarios = new ArrayList<>();
    }
    this.scenarios.add(scenariosItem);
    return this;
  }

  /**
   * Scenarios extracted from the project
   * @return scenarios
  */
  @Valid 
  @Schema(name = "scenarios", description = "Scenarios extracted from the project", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("scenarios")
  public List<@Valid Scenario> getScenarios() {
    return scenarios;
  }

  public void setScenarios(List<@Valid Scenario> scenarios) {
    this.scenarios = scenarios;
  }

  public Project size(Long size) {
    this.size = size;
    return this;
  }

  /**
   * Size of the project in bytes
   * @return size
  */
  
  @Schema(name = "size", example = "1000", description = "Size of the project in bytes", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("size")
  public Long getSize() {
    return size;
  }

  public void setSize(Long size) {
    this.size = size;
  }

  public Project source(SourceEnum source) {
    this.source = source;
    return this;
  }

  /**
   * Source from where was retrieved the project, can be unknown for project uploaded before 2022
   * @return source
  */
  
  @Schema(name = "source", example = "GIT", description = "Source from where was retrieved the project, can be unknown for project uploaded before 2022", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("source")
  public SourceEnum getSource() {
    return source;
  }

  public void setSource(SourceEnum source) {
    this.source = source;
  }

  public Project userModifierName(String userModifierName) {
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
    Project project = (Project) o;
    return Objects.equals(this.name, project.name) &&
        Objects.equals(this.updatedAt, project.updatedAt) &&
        Objects.equals(this.scenarios, project.scenarios) &&
        Objects.equals(this.size, project.size) &&
        Objects.equals(this.source, project.source) &&
        Objects.equals(this.userModifierName, project.userModifierName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, updatedAt, scenarios, size, source, userModifierName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Project {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    updatedAt: ").append(toIndentedString(updatedAt)).append("\n");
    sb.append("    scenarios: ").append(toIndentedString(scenarios)).append("\n");
    sb.append("    size: ").append(toIndentedString(size)).append("\n");
    sb.append("    source: ").append(toIndentedString(source)).append("\n");
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


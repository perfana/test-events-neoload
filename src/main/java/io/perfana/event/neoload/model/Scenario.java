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
 * Scenario summary from a project
 */

@Schema(name = "Scenario", description = "Scenario summary from a project")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-04-06T15:29:22.895694+02:00[Europe/Amsterdam]", comments = "Generator version: 7.4.0")
public class Scenario {

  private String name;

  private String duration;

  private Long maximumVu;

  public Scenario() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public Scenario(String name) {
    this.name = name;
  }

  public Scenario name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name
   * @return name
  */
  @NotNull 
  @Schema(name = "name", example = "Order spike", description = "Name", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Scenario duration(String duration) {
    this.duration = duration;
    return this;
  }

  /**
   * Scenario duration (ISO 8601 format).
   * @return duration
  */
  
  @Schema(name = "duration", example = "PT20M", description = "Scenario duration (ISO 8601 format).", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("duration")
  public String getDuration() {
    return duration;
  }

  public void setDuration(String duration) {
    this.duration = duration;
  }

  public Scenario maximumVu(Long maximumVu) {
    this.maximumVu = maximumVu;
    return this;
  }

  /**
   * Maximum number of VU which can be expected during the scenario execution
   * @return maximumVu
  */
  
  @Schema(name = "maximumVu", example = "20", description = "Maximum number of VU which can be expected during the scenario execution", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("maximumVu")
  public Long getMaximumVu() {
    return maximumVu;
  }

  public void setMaximumVu(Long maximumVu) {
    this.maximumVu = maximumVu;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Scenario scenario = (Scenario) o;
    return Objects.equals(this.name, scenario.name) &&
        Objects.equals(this.duration, scenario.duration) &&
        Objects.equals(this.maximumVu, scenario.maximumVu);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, duration, maximumVu);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Scenario {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    duration: ").append(toIndentedString(duration)).append("\n");
    sb.append("    maximumVu: ").append(toIndentedString(maximumVu)).append("\n");
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


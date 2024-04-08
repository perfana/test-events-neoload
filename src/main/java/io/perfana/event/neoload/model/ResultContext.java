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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Test Result Context ids
 */

@Schema(name = "ResultContext", description = "Test Result Context ids")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-04-06T15:29:22.895694+02:00[Europe/Amsterdam]", comments = "Generator version: 7.4.0")
public class ResultContext {

  @Valid
  private List<String> populations = new ArrayList<>();

  @Valid
  private List<String> userPaths = new ArrayList<>();

  @Valid
  private List<String> zones = new ArrayList<>();

  public ResultContext() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public ResultContext(List<String> populations, List<String> userPaths, List<String> zones) {
    this.populations = populations;
    this.userPaths = userPaths;
    this.zones = zones;
  }

  public ResultContext populations(List<String> populations) {
    this.populations = populations;
    return this;
  }

  public ResultContext addPopulationsItem(String populationsItem) {
    if (this.populations == null) {
      this.populations = new ArrayList<>();
    }
    this.populations.add(populationsItem);
    return this;
  }

  /**
   * List of population names of this result.
   * @return populations
  */
  @NotNull 
  @Schema(name = "populations", example = "[\"MyPopulationSmallCities\",\"MyPopulationBigCities\"]", description = "List of population names of this result.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("populations")
  public List<String> getPopulations() {
    return populations;
  }

  public void setPopulations(List<String> populations) {
    this.populations = populations;
  }

  public ResultContext userPaths(List<String> userPaths) {
    this.userPaths = userPaths;
    return this;
  }

  public ResultContext addUserPathsItem(String userPathsItem) {
    if (this.userPaths == null) {
      this.userPaths = new ArrayList<>();
    }
    this.userPaths.add(userPathsItem);
    return this;
  }

  /**
   * List of user path of this result.
   * @return userPaths
  */
  @NotNull 
  @Schema(name = "userPaths", example = "[\"BrowserUser_Create_report\",\"MyiPhoneUser_Create_report\"]", description = "List of user path of this result.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("userPaths")
  public List<String> getUserPaths() {
    return userPaths;
  }

  public void setUserPaths(List<String> userPaths) {
    this.userPaths = userPaths;
  }

  public ResultContext zones(List<String> zones) {
    this.zones = zones;
    return this;
  }

  public ResultContext addZonesItem(String zonesItem) {
    if (this.zones == null) {
      this.zones = new ArrayList<>();
    }
    this.zones.add(zonesItem);
    return this;
  }

  /**
   * List of zone names of this result.
   * @return zones
  */
  @NotNull 
  @Schema(name = "zones", example = "[\"Default zone\",\"Asia-Pacific\"]", description = "List of zone names of this result.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("zones")
  public List<String> getZones() {
    return zones;
  }

  public void setZones(List<String> zones) {
    this.zones = zones;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResultContext resultContext = (ResultContext) o;
    return Objects.equals(this.populations, resultContext.populations) &&
        Objects.equals(this.userPaths, resultContext.userPaths) &&
        Objects.equals(this.zones, resultContext.zones);
  }

  @Override
  public int hashCode() {
    return Objects.hash(populations, userPaths, zones);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResultContext {\n");
    sb.append("    populations: ").append(toIndentedString(populations)).append("\n");
    sb.append("    userPaths: ").append(toIndentedString(userPaths)).append("\n");
    sb.append("    zones: ").append(toIndentedString(zones)).append("\n");
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


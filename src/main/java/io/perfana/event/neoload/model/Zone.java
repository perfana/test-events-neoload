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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Items in the page
 */

@Schema(name = "Zone", description = "Items in the page")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-04-06T15:29:22.895694+02:00[Europe/Amsterdam]", comments = "Generator version: 7.4.0")
public class Zone {

  @Valid
  private List<@Valid ZoneResource> controllers = new ArrayList<>();

  @Valid
  private List<@Valid ZoneResource> loadGenerators = new ArrayList<>();

  private String name;

  /**
   * Type of the zone
   */
  public enum TypeEnum {
    STATIC("STATIC"),
    
    DYNAMIC("DYNAMIC"),
    
    NCP("NCP");

    private String value;

    TypeEnum(String value) {
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
    public static TypeEnum fromValue(String value) {
      for (TypeEnum b : TypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private TypeEnum type;

  private String zoneId;

  public Zone() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public Zone(List<@Valid ZoneResource> controllers, List<@Valid ZoneResource> loadGenerators, String name, TypeEnum type, String zoneId) {
    this.controllers = controllers;
    this.loadGenerators = loadGenerators;
    this.name = name;
    this.type = type;
    this.zoneId = zoneId;
  }

  public Zone controllers(List<@Valid ZoneResource> controllers) {
    this.controllers = controllers;
    return this;
  }

  public Zone addControllersItem(ZoneResource controllersItem) {
    if (this.controllers == null) {
      this.controllers = new ArrayList<>();
    }
    this.controllers.add(controllersItem);
    return this;
  }

  /**
   * List of Controllers
   * @return controllers
  */
  @NotNull @Valid 
  @Schema(name = "controllers", description = "List of Controllers", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("controllers")
  public List<@Valid ZoneResource> getControllers() {
    return controllers;
  }

  public void setControllers(List<@Valid ZoneResource> controllers) {
    this.controllers = controllers;
  }

  public Zone loadGenerators(List<@Valid ZoneResource> loadGenerators) {
    this.loadGenerators = loadGenerators;
    return this;
  }

  public Zone addLoadGeneratorsItem(ZoneResource loadGeneratorsItem) {
    if (this.loadGenerators == null) {
      this.loadGenerators = new ArrayList<>();
    }
    this.loadGenerators.add(loadGeneratorsItem);
    return this;
  }

  /**
   * List of Load Generator
   * @return loadGenerators
  */
  @NotNull @Valid 
  @Schema(name = "loadGenerators", description = "List of Load Generator", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("loadGenerators")
  public List<@Valid ZoneResource> getLoadGenerators() {
    return loadGenerators;
  }

  public void setLoadGenerators(List<@Valid ZoneResource> loadGenerators) {
    this.loadGenerators = loadGenerators;
  }

  public Zone name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of the zone
   * @return name
  */
  @NotNull 
  @Schema(name = "name", example = "zone name", description = "Name of the zone", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Zone type(TypeEnum type) {
    this.type = type;
    return this;
  }

  /**
   * Type of the zone
   * @return type
  */
  @NotNull 
  @Schema(name = "type", example = "STATIC", description = "Type of the zone", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("type")
  public String getType() {
    return String.valueOf(type);
  }

  public void setType(TypeEnum type) {
    this.type = type;
  }

  public Zone zoneId(String zoneId) {
    this.zoneId = zoneId;
    return this;
  }

  /**
   * Unique identifier of the zone
   * @return zoneId
  */
  @NotNull @Pattern(regexp = "^[0-9a-zA-Z]{5,6}|defaultzone$") 
  @Schema(name = "zoneId", example = "defaultzone", description = "Unique identifier of the zone", requiredMode = Schema.RequiredMode.REQUIRED)
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
    Zone zone = (Zone) o;
    return Objects.equals(this.controllers, zone.controllers) &&
        Objects.equals(this.loadGenerators, zone.loadGenerators) &&
        Objects.equals(this.name, zone.name) &&
        Objects.equals(this.type, zone.type) &&
        Objects.equals(this.zoneId, zone.zoneId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(controllers, loadGenerators, name, type, zoneId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Zone {\n");
    sb.append("    controllers: ").append(toIndentedString(controllers)).append("\n");
    sb.append("    loadGenerators: ").append(toIndentedString(loadGenerators)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
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


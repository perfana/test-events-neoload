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

import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Field available to create a reservation
 */

@Schema(name = "Reservation", description = "Field available to create a reservation")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-04-06T15:29:22.895694+02:00[Europe/Amsterdam]", comments = "Generator version: 7.4.0")
public class Reservation {

  private String id;

  private String author;

  private String controllerVersion;

  private String controllerZoneId;

  private String description;

  private OffsetDateTime duration;

  @Valid
  private Map<String, Integer> lgZonesResourcesReservation = new HashMap<>();

  private String name;
  
  private OffsetDateTime startDateTime;

  /**
   * Status of the reservation.
   */
  public enum StatusEnum {
    WAITING("WAITING"),
    
    RUNNING("RUNNING"),
    
    PARTIALLY_RESERVED("PARTIALLY_RESERVED"),
    
    FAILED_TO_RESERVE("FAILED_TO_RESERVE"),
    
    RESERVED("RESERVED"),
    
    STOPPING("STOPPING"),
    
    ENDED("ENDED");

    private String value;

    StatusEnum(String value) {
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
    public static StatusEnum fromValue(String value) {
      for (StatusEnum b : StatusEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private StatusEnum status;

  /**
   * How the reservation has been created.
   */
  public enum TypeEnum {
    REAL("REAL"),
    
    ON_DEMAND("ON_DEMAND"),
    
    VU_ONLY("VU_ONLY");

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

  @Valid
  private Map<String, Integer> vuCountByVuType = new HashMap<>();


  private OffsetDateTime endDateTime;

  public Reservation() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public Reservation(String id, String author, String controllerVersion, String controllerZoneId, String description, OffsetDateTime duration, Map<String, Integer> lgZonesResourcesReservation, String name, OffsetDateTime startDateTime, StatusEnum status, TypeEnum type, Map<String, Integer> vuCountByVuType) {
    this.id = id;
    this.author = author;
    this.controllerVersion = controllerVersion;
    this.controllerZoneId = controllerZoneId;
    this.description = description;
    this.duration = duration;
    this.lgZonesResourcesReservation = lgZonesResourcesReservation;
    this.name = name;
    this.startDateTime = startDateTime;
    this.status = status;
    this.type = type;
    this.vuCountByVuType = vuCountByVuType;
  }

  public Reservation id(String id) {
    this.id = id;
    return this;
  }

  /**
   * ID of the reservation
   * @return id
  */
  @NotNull @Pattern(regexp = "^[0-9a-fA-F]{8}-([0-9a-fA-F]{4}-){3}[0-9a-fA-F]{12}$") 
  @Schema(name = "id", example = "123e4567-e89b-12d3-a456-426655440000", description = "ID of the reservation", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("id")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Reservation author(String author) {
    this.author = author;
    return this;
  }

  /**
   * Name of the user who created the reservation.
   * @return author
  */
  @NotNull 
  @Schema(name = "author", description = "Name of the user who created the reservation.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("author")
  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public Reservation controllerVersion(String controllerVersion) {
    this.controllerVersion = controllerVersion;
    return this;
  }

  /**
   * Controller version of the selected controller.
   * @return controllerVersion
  */
  @NotNull 
  @Schema(name = "controllerVersion", example = "6.6.0;build=1234", description = "Controller version of the selected controller.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("controllerVersion")
  public String getControllerVersion() {
    return controllerVersion;
  }

  public void setControllerVersion(String controllerVersion) {
    this.controllerVersion = controllerVersion;
  }

  public Reservation controllerZoneId(String controllerZoneId) {
    this.controllerZoneId = controllerZoneId;
    return this;
  }

  /**
   * ID of the zone.
   * @return controllerZoneId
  */
  @NotNull 
  @Schema(name = "controllerZoneId", example = "defaultzone", description = "ID of the zone.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("controllerZoneId")
  public String getControllerZoneId() {
    return controllerZoneId;
  }

  public void setControllerZoneId(String controllerZoneId) {
    this.controllerZoneId = controllerZoneId;
  }

  public Reservation description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Description of the reservation.
   * @return description
  */
  @NotNull 
  @Schema(name = "description", description = "Description of the reservation.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("description")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Reservation duration(OffsetDateTime duration) {
    this.duration = duration;
    return this;
  }

  /**
   * Duration of reservation.
   * @return duration
  */
  @NotNull @Valid 
  @Schema(name = "duration", description = "Duration of reservation.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("duration")
  public OffsetDateTime getDuration() {
    return duration;
  }

  public void setDuration(OffsetDateTime duration) {
    this.duration = duration;
  }

  public Reservation lgZonesResourcesReservation(Map<String, Integer> lgZonesResourcesReservation) {
    this.lgZonesResourcesReservation = lgZonesResourcesReservation;
    return this;
  }

  public Reservation putLgZonesResourcesReservationItem(String key, Integer lgZonesResourcesReservationItem) {
    if (this.lgZonesResourcesReservation == null) {
      this.lgZonesResourcesReservation = new HashMap<>();
    }
    this.lgZonesResourcesReservation.put(key, lgZonesResourcesReservationItem);
    return this;
  }

  /**
   * The number of load generators reserved for a specific zone.
   * @return lgZonesResourcesReservation
  */
  @NotNull 
  @Schema(name = "lgZonesResourcesReservation", example = "{defaultzone=1}", description = "The number of load generators reserved for a specific zone.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("lgZonesResourcesReservation")
  public Map<String, Integer> getLgZonesResourcesReservation() {
    return lgZonesResourcesReservation;
  }

  public void setLgZonesResourcesReservation(Map<String, Integer> lgZonesResourcesReservation) {
    this.lgZonesResourcesReservation = lgZonesResourcesReservation;
  }

  public Reservation name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Title of the reservation.
   * @return name
  */
  @NotNull 
  @Schema(name = "name", description = "Title of the reservation.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Reservation startDateTime(OffsetDateTime startDateTime) {
    this.startDateTime = startDateTime;
    return this;
  }

  /**
   * Date when the reservation begins.
   * @return startDateTime
  */
  @NotNull @Valid 
  @Schema(name = "startDateTime", description = "Date when the reservation begins.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("startDateTime")
  public OffsetDateTime getStartDateTime() {
    return startDateTime;
  }

  public void setStartDateTime(OffsetDateTime startDateTime) {
    this.startDateTime = startDateTime;
  }

  public Reservation status(StatusEnum status) {
    this.status = status;
    return this;
  }

  /**
   * Status of the reservation.
   * @return status
  */
  @NotNull 
  @Schema(name = "status", example = "RESERVED", description = "Status of the reservation.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("status")
  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  public Reservation type(TypeEnum type) {
    this.type = type;
    return this;
  }

  /**
   * How the reservation has been created.
   * @return type
  */
  @NotNull 
  @Schema(name = "type", description = "How the reservation has been created.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("type")
  public String getType() {
    return String.valueOf(type);
  }

  public void setType(TypeEnum type) {
    this.type = type;
  }

  public Reservation vuCountByVuType(Map<String, Integer> vuCountByVuType) {
    this.vuCountByVuType = vuCountByVuType;
    return this;
  }

  public Reservation putVuCountByVuTypeItem(String key, Integer vuCountByVuTypeItem) {
    if (this.vuCountByVuType == null) {
      this.vuCountByVuType = new HashMap<>();
    }
    this.vuCountByVuType.put(key, vuCountByVuTypeItem);
    return this;
  }

  /**
   * Count of VU needed for each Vu type to the reservation. Allowed keys are 'WEB' and 'SAP'.
   * @return vuCountByVuType
  */
  @NotNull 
  @Schema(name = "vuCountByVuType", example = "{\"WEB\":10,\"SAP\":10}", description = "Count of VU needed for each Vu type to the reservation. Allowed keys are 'WEB' and 'SAP'.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("vuCountByVuType")
  public Map<String, Integer> getVuCountByVuType() {
    return vuCountByVuType;
  }

  public void setVuCountByVuType(Map<String, Integer> vuCountByVuType) {
    this.vuCountByVuType = vuCountByVuType;
  }

  public Reservation endDateTime(OffsetDateTime endDateTime) {
    this.endDateTime = endDateTime;
    return this;
  }

  /**
   * Date when the reservation ends.
   * @return endDateTime
  */
  @Valid 
  @Schema(name = "endDateTime", description = "Date when the reservation ends.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("endDateTime")
  public OffsetDateTime getEndDateTime() {
    return endDateTime;
  }

  public void setEndDateTime(OffsetDateTime endDateTime) {
    this.endDateTime = endDateTime;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Reservation reservation = (Reservation) o;
    return Objects.equals(this.id, reservation.id) &&
        Objects.equals(this.author, reservation.author) &&
        Objects.equals(this.controllerVersion, reservation.controllerVersion) &&
        Objects.equals(this.controllerZoneId, reservation.controllerZoneId) &&
        Objects.equals(this.description, reservation.description) &&
        Objects.equals(this.duration, reservation.duration) &&
        Objects.equals(this.lgZonesResourcesReservation, reservation.lgZonesResourcesReservation) &&
        Objects.equals(this.name, reservation.name) &&
        Objects.equals(this.startDateTime, reservation.startDateTime) &&
        Objects.equals(this.status, reservation.status) &&
        Objects.equals(this.type, reservation.type) &&
        Objects.equals(this.vuCountByVuType, reservation.vuCountByVuType) &&
        Objects.equals(this.endDateTime, reservation.endDateTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, author, controllerVersion, controllerZoneId, description, duration, lgZonesResourcesReservation, name, startDateTime, status, type, vuCountByVuType, endDateTime);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Reservation {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    author: ").append(toIndentedString(author)).append("\n");
    sb.append("    controllerVersion: ").append(toIndentedString(controllerVersion)).append("\n");
    sb.append("    controllerZoneId: ").append(toIndentedString(controllerZoneId)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    duration: ").append(toIndentedString(duration)).append("\n");
    sb.append("    lgZonesResourcesReservation: ").append(toIndentedString(lgZonesResourcesReservation)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    startDateTime: ").append(toIndentedString(startDateTime)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    vuCountByVuType: ").append(toIndentedString(vuCountByVuType)).append("\n");
    sb.append("    endDateTime: ").append(toIndentedString(endDateTime)).append("\n");
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


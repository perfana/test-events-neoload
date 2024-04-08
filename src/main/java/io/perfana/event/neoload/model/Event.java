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

import java.util.Objects;

/**
 * Event
 */

@Schema(name = "Event", description = "Event")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-04-06T15:29:22.895694+02:00[Europe/Amsterdam]", comments = "Generator version: 7.4.0")
public class Event implements EventsResourceGetEventDetails200Response {

  private String id;

  private String duration;

  private Boolean hasScreenshot;

  private String offset;

  private String source;

  /**
   * The type of the Event.
   */
  public enum TypeEnum {
    ERROR("ERROR"),
    
    SLA("SLA"),
    
    OBJECTIVE("OBJECTIVE"),
    
    ALERT("ALERT"),
    
    CUSTOM("CUSTOM"),
    
    ANNOTATION("ANNOTATION");

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

  private String code;

  private EventDetails details;

  private String elementId;

  private String fullName;

  public Event() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public Event(String id, String duration, Boolean hasScreenshot, String offset, String source, TypeEnum type) {
    this.id = id;
    this.duration = duration;
    this.hasScreenshot = hasScreenshot;
    this.offset = offset;
    this.source = source;
    this.type = type;
  }

  public Event id(String id) {
    this.id = id;
    return this;
  }

  /**
   * The unique id of the Event.
   * @return id
  */
  @NotNull 
  @Schema(name = "id", example = "423-1-423-549000", description = "The unique id of the Event.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("id")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Event duration(String duration) {
    this.duration = duration;
    return this;
  }

  /**
   * Event duration (ISO 8601 format).
   * @return duration
  */
  @NotNull 
  @Schema(name = "duration", example = "PT0.01S", description = "Event duration (ISO 8601 format).", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("duration")
  public String getDuration() {
    return duration;
  }

  public void setDuration(String duration) {
    this.duration = duration;
  }

  public Event hasScreenshot(Boolean hasScreenshot) {
    this.hasScreenshot = hasScreenshot;
    return this;
  }

  /**
   * Indicates that the event has a screenshot attached.
   * @return hasScreenshot
  */
  @NotNull 
  @Schema(name = "hasScreenshot", example = "true", description = "Indicates that the event has a screenshot attached.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("hasScreenshot")
  public Boolean getHasScreenshot() {
    return hasScreenshot;
  }

  public void setHasScreenshot(Boolean hasScreenshot) {
    this.hasScreenshot = hasScreenshot;
  }

  public Event offset(String offset) {
    this.offset = offset;
    return this;
  }

  /**
   * The offset (ISO 8601 format) of the Event from the beginning of the test
   * @return offset
  */
  @NotNull 
  @Schema(name = "offset", example = "PT1M23S", description = "The offset (ISO 8601 format) of the Event from the beginning of the test", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("offset")
  public String getOffset() {
    return offset;
  }

  public void setOffset(String offset) {
    this.offset = offset;
  }

  public Event source(String source) {
    this.source = source;
    return this;
  }

  /**
   * The name of the element that raised the Event.
   * @return source
  */
  @NotNull 
  @Schema(name = "source", example = "Validate cart", description = "The name of the element that raised the Event.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("source")
  public String getSource() {
    return source;
  }

  public void setSource(String source) {
    this.source = source;
  }

  public Event type(TypeEnum type) {
    this.type = type;
    return this;
  }

  /**
   * The type of the Event.
   * @return type
  */
  @NotNull 
  @Schema(name = "type", example = "SLA", description = "The type of the Event.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("type")
  public String getType() {
    return String.valueOf(type);
  }

  public void setType(TypeEnum type) {
    this.type = type;
  }

  public Event code(String code) {
    this.code = code;
    return this;
  }

  /**
   * The code of the Event, it could be an HTTP response code in case of error event, a SLA warning (SLA w) or SLA critical (SLA c), an Objective passed (Objective p) or Objective failed (Objective f),  a Monitoring warning (Monitoring w) or Monitoring critical (Monitoring c).
   * @return code
  */
  
  @Schema(name = "code", example = "SLA w", description = "The code of the Event, it could be an HTTP response code in case of error event, a SLA warning (SLA w) or SLA critical (SLA c), an Objective passed (Objective p) or Objective failed (Objective f),  a Monitoring warning (Monitoring w) or Monitoring critical (Monitoring c).", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("code")
  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public Event details(EventDetails details) {
    this.details = details;
    return this;
  }

  /**
   * Get details
   * @return details
  */
  @Valid 
  @Schema(name = "details", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("details")
  public EventDetails getDetails() {
    return details;
  }

  public void setDetails(EventDetails details) {
    this.details = details;
  }

  public Event elementId(String elementId) {
    this.elementId = elementId;
    return this;
  }

  /**
   * The unique id of the element that raised the event.
   * @return elementId
  */
  @Pattern(regexp = "^[0-9a-fA-F]{8}-([0-9a-fA-F]{4}-){3}[0-9a-fA-F]{12}$") 
  @Schema(name = "elementId", example = "123e4567-e89b-12d3-a456-426655440000", description = "The unique id of the element that raised the event.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("elementId")
  public String getElementId() {
    return elementId;
  }

  public void setElementId(String elementId) {
    this.elementId = elementId;
  }

  public Event fullName(String fullName) {
    this.fullName = fullName;
    return this;
  }

  /**
   * The full name of the Event.
   * @return fullName
  */
  
  @Schema(name = "fullName", example = "Average Response Time : submit report >= 4.0 sec.", description = "The full name of the Event.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("fullName")
  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Event event = (Event) o;
    return Objects.equals(this.id, event.id) &&
        Objects.equals(this.duration, event.duration) &&
        Objects.equals(this.hasScreenshot, event.hasScreenshot) &&
        Objects.equals(this.offset, event.offset) &&
        Objects.equals(this.source, event.source) &&
        Objects.equals(this.type, event.type) &&
        Objects.equals(this.code, event.code) &&
        Objects.equals(this.details, event.details) &&
        Objects.equals(this.elementId, event.elementId) &&
        Objects.equals(this.fullName, event.fullName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, duration, hasScreenshot, offset, source, type, code, details, elementId, fullName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Event {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    duration: ").append(toIndentedString(duration)).append("\n");
    sb.append("    hasScreenshot: ").append(toIndentedString(hasScreenshot)).append("\n");
    sb.append("    offset: ").append(toIndentedString(offset)).append("\n");
    sb.append("    source: ").append(toIndentedString(source)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    details: ").append(toIndentedString(details)).append("\n");
    sb.append("    elementId: ").append(toIndentedString(elementId)).append("\n");
    sb.append("    fullName: ").append(toIndentedString(fullName)).append("\n");
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


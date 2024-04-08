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
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Event of type ERROR
 */

@Schema(name = "ErrorEvent", description = "Event of type ERROR")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-04-06T15:29:22.895694+02:00[Europe/Amsterdam]", comments = "Generator version: 7.4.0")
public class ErrorEvent implements EventsResourceGetEventDetails200Response {

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

  @Valid
  private Set<String> assertions;

  private String code;

  private RequestOrResponseDetails currentRequest;

  private RequestOrResponseDetails currentResponse;

  private EventDetails details;

  private String elementId;

  private RequestOrResponseDetails firstIterationCurrentRequest;

  private RequestOrResponseDetails firstIterationCurrentResponse;

  private RequestOrResponseDetails firstIterationPreviousRequest;

  private RequestOrResponseDetails firstIterationPreviousResponse;

  private String fullName;

  private RequestOrResponseDetails previousRequest;

  private RequestOrResponseDetails previousResponse;

  private String screenshotId;

  public ErrorEvent() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public ErrorEvent(String id, String duration, Boolean hasScreenshot, String offset, String source, TypeEnum type) {
    this.id = id;
    this.duration = duration;
    this.hasScreenshot = hasScreenshot;
    this.offset = offset;
    this.source = source;
    this.type = type;
  }

  public ErrorEvent id(String id) {
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

  public ErrorEvent duration(String duration) {
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

  public ErrorEvent hasScreenshot(Boolean hasScreenshot) {
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

  public ErrorEvent offset(String offset) {
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

  public ErrorEvent source(String source) {
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

  public ErrorEvent type(TypeEnum type) {
    this.type = type;
    return this;
  }

  /**
   * The type of the Event.
   * @return type
  */
  @NotNull 
  @Schema(name = "type", example = "ERROR", description = "The type of the Event.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("type")
  public String getType() {
    return String.valueOf(type);
  }

  public void setType(TypeEnum type) {
    this.type = type;
  }

  public ErrorEvent assertions(Set<String> assertions) {
    this.assertions = assertions;
    return this;
  }

  public ErrorEvent addAssertionsItem(String assertionsItem) {
    if (this.assertions == null) {
      this.assertions = new LinkedHashSet<>();
    }
    this.assertions.add(assertionsItem);
    return this;
  }

  /**
   * The list of assertions that raised this error.
   * @return assertions
  */
  
  @Schema(name = "assertions", description = "The list of assertions that raised this error.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("assertions")
  public Set<String> getAssertions() {
    return assertions;
  }

  @JsonDeserialize(as = LinkedHashSet.class)
  public void setAssertions(Set<String> assertions) {
    this.assertions = assertions;
  }

  public ErrorEvent code(String code) {
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

  public ErrorEvent currentRequest(RequestOrResponseDetails currentRequest) {
    this.currentRequest = currentRequest;
    return this;
  }

  /**
   * Get currentRequest
   * @return currentRequest
  */
  @Valid 
  @Schema(name = "currentRequest", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("currentRequest")
  public RequestOrResponseDetails getCurrentRequest() {
    return currentRequest;
  }

  public void setCurrentRequest(RequestOrResponseDetails currentRequest) {
    this.currentRequest = currentRequest;
  }

  public ErrorEvent currentResponse(RequestOrResponseDetails currentResponse) {
    this.currentResponse = currentResponse;
    return this;
  }

  /**
   * Get currentResponse
   * @return currentResponse
  */
  @Valid 
  @Schema(name = "currentResponse", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("currentResponse")
  public RequestOrResponseDetails getCurrentResponse() {
    return currentResponse;
  }

  public void setCurrentResponse(RequestOrResponseDetails currentResponse) {
    this.currentResponse = currentResponse;
  }

  public ErrorEvent details(EventDetails details) {
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

  public ErrorEvent elementId(String elementId) {
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

  public ErrorEvent firstIterationCurrentRequest(RequestOrResponseDetails firstIterationCurrentRequest) {
    this.firstIterationCurrentRequest = firstIterationCurrentRequest;
    return this;
  }

  /**
   * Get firstIterationCurrentRequest
   * @return firstIterationCurrentRequest
  */
  @Valid 
  @Schema(name = "firstIterationCurrentRequest", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("firstIterationCurrentRequest")
  public RequestOrResponseDetails getFirstIterationCurrentRequest() {
    return firstIterationCurrentRequest;
  }

  public void setFirstIterationCurrentRequest(RequestOrResponseDetails firstIterationCurrentRequest) {
    this.firstIterationCurrentRequest = firstIterationCurrentRequest;
  }

  public ErrorEvent firstIterationCurrentResponse(RequestOrResponseDetails firstIterationCurrentResponse) {
    this.firstIterationCurrentResponse = firstIterationCurrentResponse;
    return this;
  }

  /**
   * Get firstIterationCurrentResponse
   * @return firstIterationCurrentResponse
  */
  @Valid 
  @Schema(name = "firstIterationCurrentResponse", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("firstIterationCurrentResponse")
  public RequestOrResponseDetails getFirstIterationCurrentResponse() {
    return firstIterationCurrentResponse;
  }

  public void setFirstIterationCurrentResponse(RequestOrResponseDetails firstIterationCurrentResponse) {
    this.firstIterationCurrentResponse = firstIterationCurrentResponse;
  }

  public ErrorEvent firstIterationPreviousRequest(RequestOrResponseDetails firstIterationPreviousRequest) {
    this.firstIterationPreviousRequest = firstIterationPreviousRequest;
    return this;
  }

  /**
   * Get firstIterationPreviousRequest
   * @return firstIterationPreviousRequest
  */
  @Valid 
  @Schema(name = "firstIterationPreviousRequest", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("firstIterationPreviousRequest")
  public RequestOrResponseDetails getFirstIterationPreviousRequest() {
    return firstIterationPreviousRequest;
  }

  public void setFirstIterationPreviousRequest(RequestOrResponseDetails firstIterationPreviousRequest) {
    this.firstIterationPreviousRequest = firstIterationPreviousRequest;
  }

  public ErrorEvent firstIterationPreviousResponse(RequestOrResponseDetails firstIterationPreviousResponse) {
    this.firstIterationPreviousResponse = firstIterationPreviousResponse;
    return this;
  }

  /**
   * Get firstIterationPreviousResponse
   * @return firstIterationPreviousResponse
  */
  @Valid 
  @Schema(name = "firstIterationPreviousResponse", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("firstIterationPreviousResponse")
  public RequestOrResponseDetails getFirstIterationPreviousResponse() {
    return firstIterationPreviousResponse;
  }

  public void setFirstIterationPreviousResponse(RequestOrResponseDetails firstIterationPreviousResponse) {
    this.firstIterationPreviousResponse = firstIterationPreviousResponse;
  }

  public ErrorEvent fullName(String fullName) {
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

  public ErrorEvent previousRequest(RequestOrResponseDetails previousRequest) {
    this.previousRequest = previousRequest;
    return this;
  }

  /**
   * Get previousRequest
   * @return previousRequest
  */
  @Valid 
  @Schema(name = "previousRequest", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("previousRequest")
  public RequestOrResponseDetails getPreviousRequest() {
    return previousRequest;
  }

  public void setPreviousRequest(RequestOrResponseDetails previousRequest) {
    this.previousRequest = previousRequest;
  }

  public ErrorEvent previousResponse(RequestOrResponseDetails previousResponse) {
    this.previousResponse = previousResponse;
    return this;
  }

  /**
   * Get previousResponse
   * @return previousResponse
  */
  @Valid 
  @Schema(name = "previousResponse", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("previousResponse")
  public RequestOrResponseDetails getPreviousResponse() {
    return previousResponse;
  }

  public void setPreviousResponse(RequestOrResponseDetails previousResponse) {
    this.previousResponse = previousResponse;
  }

  public ErrorEvent screenshotId(String screenshotId) {
    this.screenshotId = screenshotId;
    return this;
  }

  /**
   * The identifier of the screenshot attached to this error.
   * @return screenshotId
  */
  
  @Schema(name = "screenshotId", description = "The identifier of the screenshot attached to this error.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("screenshotId")
  public String getScreenshotId() {
    return screenshotId;
  }

  public void setScreenshotId(String screenshotId) {
    this.screenshotId = screenshotId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ErrorEvent errorEvent = (ErrorEvent) o;
    return Objects.equals(this.id, errorEvent.id) &&
        Objects.equals(this.duration, errorEvent.duration) &&
        Objects.equals(this.hasScreenshot, errorEvent.hasScreenshot) &&
        Objects.equals(this.offset, errorEvent.offset) &&
        Objects.equals(this.source, errorEvent.source) &&
        Objects.equals(this.type, errorEvent.type) &&
        Objects.equals(this.assertions, errorEvent.assertions) &&
        Objects.equals(this.code, errorEvent.code) &&
        Objects.equals(this.currentRequest, errorEvent.currentRequest) &&
        Objects.equals(this.currentResponse, errorEvent.currentResponse) &&
        Objects.equals(this.details, errorEvent.details) &&
        Objects.equals(this.elementId, errorEvent.elementId) &&
        Objects.equals(this.firstIterationCurrentRequest, errorEvent.firstIterationCurrentRequest) &&
        Objects.equals(this.firstIterationCurrentResponse, errorEvent.firstIterationCurrentResponse) &&
        Objects.equals(this.firstIterationPreviousRequest, errorEvent.firstIterationPreviousRequest) &&
        Objects.equals(this.firstIterationPreviousResponse, errorEvent.firstIterationPreviousResponse) &&
        Objects.equals(this.fullName, errorEvent.fullName) &&
        Objects.equals(this.previousRequest, errorEvent.previousRequest) &&
        Objects.equals(this.previousResponse, errorEvent.previousResponse) &&
        Objects.equals(this.screenshotId, errorEvent.screenshotId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, duration, hasScreenshot, offset, source, type, assertions, code, currentRequest, currentResponse, details, elementId, firstIterationCurrentRequest, firstIterationCurrentResponse, firstIterationPreviousRequest, firstIterationPreviousResponse, fullName, previousRequest, previousResponse, screenshotId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ErrorEvent {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    duration: ").append(toIndentedString(duration)).append("\n");
    sb.append("    hasScreenshot: ").append(toIndentedString(hasScreenshot)).append("\n");
    sb.append("    offset: ").append(toIndentedString(offset)).append("\n");
    sb.append("    source: ").append(toIndentedString(source)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    assertions: ").append(toIndentedString(assertions)).append("\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    currentRequest: ").append(toIndentedString(currentRequest)).append("\n");
    sb.append("    currentResponse: ").append(toIndentedString(currentResponse)).append("\n");
    sb.append("    details: ").append(toIndentedString(details)).append("\n");
    sb.append("    elementId: ").append(toIndentedString(elementId)).append("\n");
    sb.append("    firstIterationCurrentRequest: ").append(toIndentedString(firstIterationCurrentRequest)).append("\n");
    sb.append("    firstIterationCurrentResponse: ").append(toIndentedString(firstIterationCurrentResponse)).append("\n");
    sb.append("    firstIterationPreviousRequest: ").append(toIndentedString(firstIterationPreviousRequest)).append("\n");
    sb.append("    firstIterationPreviousResponse: ").append(toIndentedString(firstIterationPreviousResponse)).append("\n");
    sb.append("    fullName: ").append(toIndentedString(fullName)).append("\n");
    sb.append("    previousRequest: ").append(toIndentedString(previousRequest)).append("\n");
    sb.append("    previousResponse: ").append(toIndentedString(previousResponse)).append("\n");
    sb.append("    screenshotId: ").append(toIndentedString(screenshotId)).append("\n");
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


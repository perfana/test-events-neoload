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
import jakarta.validation.constraints.Size;

import java.util.Objects;

/**
 * Post Event Request Body For Custom Event
 */

@Schema(name = "StoreCustomEventInput", description = "Post Event Request Body For Custom Event")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-04-06T15:29:22.895694+02:00[Europe/Amsterdam]", comments = "Generator version: 7.4.0")
public class StoreCustomEventInput implements StoreEventInput {

  private String fullName;

  private String startOffset;

  /**
   * Type of the Custom Event Timeframe
   */
  public enum TimeframeEnum {
    INSTANT("INSTANT"),
    
    TIME_RANGE("TIME_RANGE");

    private String value;

    TimeframeEnum(String value) {
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
    public static TimeframeEnum fromValue(String value) {
      for (TimeframeEnum b : TimeframeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private TimeframeEnum timeframe;

  /**
   * Gets or Sets type
   */
  public enum TypeEnum {
    CUSTOM("CUSTOM");

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

  private CustomEventDetails details;

  private String endOffset;

  private String source;

  public StoreCustomEventInput() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public StoreCustomEventInput(String fullName, String startOffset, TimeframeEnum timeframe, TypeEnum type) {
    this.fullName = fullName;
    this.startOffset = startOffset;
    this.timeframe = timeframe;
    this.type = type;
  }

  public StoreCustomEventInput fullName(String fullName) {
    this.fullName = fullName;
    return this;
  }

  /**
   * Full name of the Custom Event
   * @return fullName
  */
  @NotNull @Size(max = 256) 
  @Schema(name = "fullName", description = "Full name of the Custom Event", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("fullName")
  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public StoreCustomEventInput startOffset(String startOffset) {
    this.startOffset = startOffset;
    return this;
  }

  /**
   * The start offset (ISO 8601 format) of the Custom Event from the beginning of the Result
   * @return startOffset
  */
  @NotNull 
  @Schema(name = "startOffset", example = "PT1M23S", description = "The start offset (ISO 8601 format) of the Custom Event from the beginning of the Result", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("startOffset")
  public String getStartOffset() {
    return startOffset;
  }

  public void setStartOffset(String startOffset) {
    this.startOffset = startOffset;
  }

  public StoreCustomEventInput timeframe(TimeframeEnum timeframe) {
    this.timeframe = timeframe;
    return this;
  }

  /**
   * Type of the Custom Event Timeframe
   * @return timeframe
  */
  @NotNull 
  @Schema(name = "timeframe", description = "Type of the Custom Event Timeframe", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("timeframe")
  public TimeframeEnum getTimeframe() {
    return timeframe;
  }

  public void setTimeframe(TimeframeEnum timeframe) {
    this.timeframe = timeframe;
  }

  public StoreCustomEventInput type(TypeEnum type) {
    this.type = type;
    return this;
  }

  /**
   * Get type
   * @return type
  */
  @NotNull 
  @Schema(name = "type", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("type")
  public String getType() {
    return String.valueOf(type);
  }

  public void setType(TypeEnum type) {
    this.type = type;
  }

  public StoreCustomEventInput code(String code) {
    this.code = code;
    return this;
  }

  /**
   * Code of the Custom Event
   * @return code
  */
  @Size(max = 64) 
  @Schema(name = "code", description = "Code of the Custom Event", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("code")
  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public StoreCustomEventInput details(CustomEventDetails details) {
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
  public CustomEventDetails getDetails() {
    return details;
  }

  public void setDetails(CustomEventDetails details) {
    this.details = details;
  }

  public StoreCustomEventInput endOffset(String endOffset) {
    this.endOffset = endOffset;
    return this;
  }

  /**
   * The end offset (ISO 8601 format) of the Custom Event from the beginning of the Result
   * @return endOffset
  */
  
  @Schema(name = "endOffset", example = "PT1M23S", description = "The end offset (ISO 8601 format) of the Custom Event from the beginning of the Result", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("endOffset")
  public String getEndOffset() {
    return endOffset;
  }

  public void setEndOffset(String endOffset) {
    this.endOffset = endOffset;
  }

  public StoreCustomEventInput source(String source) {
    this.source = source;
    return this;
  }

  /**
   * Source of the Custom Event
   * @return source
  */
  @Size(max = 32) 
  @Schema(name = "source", description = "Source of the Custom Event", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("source")
  public String getSource() {
    return source;
  }

  public void setSource(String source) {
    this.source = source;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StoreCustomEventInput storeCustomEventInput = (StoreCustomEventInput) o;
    return Objects.equals(this.fullName, storeCustomEventInput.fullName) &&
        Objects.equals(this.startOffset, storeCustomEventInput.startOffset) &&
        Objects.equals(this.timeframe, storeCustomEventInput.timeframe) &&
        Objects.equals(this.type, storeCustomEventInput.type) &&
        Objects.equals(this.code, storeCustomEventInput.code) &&
        Objects.equals(this.details, storeCustomEventInput.details) &&
        Objects.equals(this.endOffset, storeCustomEventInput.endOffset) &&
        Objects.equals(this.source, storeCustomEventInput.source);
  }

  @Override
  public int hashCode() {
    return Objects.hash(fullName, startOffset, timeframe, type, code, details, endOffset, source);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StoreCustomEventInput {\n");
    sb.append("    fullName: ").append(toIndentedString(fullName)).append("\n");
    sb.append("    startOffset: ").append(toIndentedString(startOffset)).append("\n");
    sb.append("    timeframe: ").append(toIndentedString(timeframe)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    details: ").append(toIndentedString(details)).append("\n");
    sb.append("    endOffset: ").append(toIndentedString(endOffset)).append("\n");
    sb.append("    source: ").append(toIndentedString(source)).append("\n");
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


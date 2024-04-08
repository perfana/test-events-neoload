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
 * Annotation Event mutable fields
 */

@Schema(name = "PatchAnnotationEventInput", description = "Annotation Event mutable fields")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-04-06T15:29:22.895694+02:00[Europe/Amsterdam]", comments = "Generator version: 7.4.0")
public class PatchAnnotationEventInput implements PatchEventInput {

  /**
   * Type of the Event
   */
  public enum TypeEnum {
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

  private AnnotationEventDetails details;

  private String endOffset;

  private String fullName;

  private String source;

  private String startOffset;

  public PatchAnnotationEventInput() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public PatchAnnotationEventInput(TypeEnum type) {
    this.type = type;
  }

  public PatchAnnotationEventInput type(TypeEnum type) {
    this.type = type;
    return this;
  }

  /**
   * Type of the Event
   * @return type
  */
  @NotNull 
  @Schema(name = "type", description = "Type of the Event", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("type")
  public String getType() {
    return String.valueOf(type);
  }

  public void setType(TypeEnum type) {
    this.type = type;
  }

  public PatchAnnotationEventInput details(AnnotationEventDetails details) {
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
  public AnnotationEventDetails getDetails() {
    return details;
  }

  public void setDetails(AnnotationEventDetails details) {
    this.details = details;
  }

  public PatchAnnotationEventInput endOffset(String endOffset) {
    this.endOffset = endOffset;
    return this;
  }

  /**
   * The offset (ISO 8601 format) of the end of the Annotation from the beginning of the Result. If EndOffset equals StartOffset it means that the Annotation is about a single moment.
   * @return endOffset
  */
  
  @Schema(name = "endOffset", example = "PT1M23S", description = "The offset (ISO 8601 format) of the end of the Annotation from the beginning of the Result. If EndOffset equals StartOffset it means that the Annotation is about a single moment.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("endOffset")
  public String getEndOffset() {
    return endOffset;
  }

  public void setEndOffset(String endOffset) {
    this.endOffset = endOffset;
  }

  public PatchAnnotationEventInput fullName(String fullName) {
    this.fullName = fullName;
    return this;
  }

  /**
   * The name of the Annotation.
   * @return fullName
  */
  @Size(max = 256) 
  @Schema(name = "fullName", example = "Moment when the CPU Load reaches 90%", description = "The name of the Annotation.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("fullName")
  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public PatchAnnotationEventInput source(String source) {
    this.source = source;
    return this;
  }

  /**
   * The Source of the Annotation.
   * @return source
  */
  @Size(max = 32) 
  @Schema(name = "source", example = "source", description = "The Source of the Annotation.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("source")
  public String getSource() {
    return source;
  }

  public void setSource(String source) {
    this.source = source;
  }

  public PatchAnnotationEventInput startOffset(String startOffset) {
    this.startOffset = startOffset;
    return this;
  }

  /**
   * The offset (ISO 8601 format) of the start of the Annotation from the beginning of the Result
   * @return startOffset
  */
  
  @Schema(name = "startOffset", example = "PT1M23S", description = "The offset (ISO 8601 format) of the start of the Annotation from the beginning of the Result", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("startOffset")
  public String getStartOffset() {
    return startOffset;
  }

  public void setStartOffset(String startOffset) {
    this.startOffset = startOffset;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PatchAnnotationEventInput patchAnnotationEventInput = (PatchAnnotationEventInput) o;
    return Objects.equals(this.type, patchAnnotationEventInput.type) &&
        Objects.equals(this.details, patchAnnotationEventInput.details) &&
        Objects.equals(this.endOffset, patchAnnotationEventInput.endOffset) &&
        Objects.equals(this.fullName, patchAnnotationEventInput.fullName) &&
        Objects.equals(this.source, patchAnnotationEventInput.source) &&
        Objects.equals(this.startOffset, patchAnnotationEventInput.startOffset);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, details, endOffset, fullName, source, startOffset);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PatchAnnotationEventInput {\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    details: ").append(toIndentedString(details)).append("\n");
    sb.append("    endOffset: ").append(toIndentedString(endOffset)).append("\n");
    sb.append("    fullName: ").append(toIndentedString(fullName)).append("\n");
    sb.append("    source: ").append(toIndentedString(source)).append("\n");
    sb.append("    startOffset: ").append(toIndentedString(startOffset)).append("\n");
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


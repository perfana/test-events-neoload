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
 * IntervalPostRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-04-06T15:29:22.895694+02:00[Europe/Amsterdam]", comments = "Generator version: 7.4.0")
public class IntervalPostRequest {

  private String endOffset;

  private String name;

  private String startOffset;

  private String color;

  private String description;

  public IntervalPostRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public IntervalPostRequest(String endOffset, String name, String startOffset) {
    this.endOffset = endOffset;
    this.name = name;
    this.startOffset = startOffset;
  }

  public IntervalPostRequest endOffset(String endOffset) {
    this.endOffset = endOffset;
    return this;
  }

  /**
   * The offset (ISO 8601 format) of the <b>end of the Interval</b> from the beginning of the result.
   * @return endOffset
  */
  @NotNull 
  @Schema(name = "endOffset", example = "PT15M", description = "The offset (ISO 8601 format) of the <b>end of the Interval</b> from the beginning of the result.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("endOffset")
  public String getEndOffset() {
    return endOffset;
  }

  public void setEndOffset(String endOffset) {
    this.endOffset = endOffset;
  }

  public IntervalPostRequest name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of the Interval.
   * @return name
  */
  @NotNull @Size(max = 256) 
  @Schema(name = "name", example = "My interval", description = "Name of the Interval.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public IntervalPostRequest startOffset(String startOffset) {
    this.startOffset = startOffset;
    return this;
  }

  /**
   * The offset (ISO 8601 format) of the <b>beginning of the Interval</b> from the beginning of the result.
   * @return startOffset
  */
  @NotNull 
  @Schema(name = "startOffset", example = "PT10M", description = "The offset (ISO 8601 format) of the <b>beginning of the Interval</b> from the beginning of the result.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("startOffset")
  public String getStartOffset() {
    return startOffset;
  }

  public void setStartOffset(String startOffset) {
    this.startOffset = startOffset;
  }

  public IntervalPostRequest color(String color) {
    this.color = color;
    return this;
  }

  /**
   * Color of the Interval as an hexadecimal string.
   * @return color
  */
  @Pattern(regexp = "^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$") 
  @Schema(name = "color", example = "#F00", description = "Color of the Interval as an hexadecimal string.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("color")
  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public IntervalPostRequest description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Description of the Interval.
   * @return description
  */
  @Size(max = 2048) 
  @Schema(name = "description", example = "During this Interval, everything looks good.", description = "Description of the Interval.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
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
    IntervalPostRequest intervalPostRequest = (IntervalPostRequest) o;
    return Objects.equals(this.endOffset, intervalPostRequest.endOffset) &&
        Objects.equals(this.name, intervalPostRequest.name) &&
        Objects.equals(this.startOffset, intervalPostRequest.startOffset) &&
        Objects.equals(this.color, intervalPostRequest.color) &&
        Objects.equals(this.description, intervalPostRequest.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(endOffset, name, startOffset, color, description);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IntervalPostRequest {\n");
    sb.append("    endOffset: ").append(toIndentedString(endOffset)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    startOffset: ").append(toIndentedString(startOffset)).append("\n");
    sb.append("    color: ").append(toIndentedString(color)).append("\n");
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


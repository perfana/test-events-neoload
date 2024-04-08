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
 * The Content inside a result, it could be a request, a response or a screenshot
 */

@Schema(name = "EventContent", description = "The Content inside a result, it could be a request, a response or a screenshot")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-04-06T15:29:22.895694+02:00[Europe/Amsterdam]", comments = "Generator version: 7.4.0")
public class EventContent {

  private String id;

  private String stringContent;

  private Boolean truncated;

  public EventContent() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public EventContent(String id, String stringContent, Boolean truncated) {
    this.id = id;
    this.stringContent = stringContent;
    this.truncated = truncated;
  }

  public EventContent id(String id) {
    this.id = id;
    return this;
  }

  /**
   * The unique id of the Content.
   * @return id
  */
  @NotNull 
  @Schema(name = "id", example = "961RXT+5a329BHfANZLBxD5BFX0=", description = "The unique id of the Content.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("id")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public EventContent stringContent(String stringContent) {
    this.stringContent = stringContent;
    return this;
  }

  /**
   * The Content itself. For a screenshot, it will be encoded as a base 64 String.
   * @return stringContent
  */
  @NotNull 
  @Schema(name = "stringContent", description = "The Content itself. For a screenshot, it will be encoded as a base 64 String.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("stringContent")
  public String getStringContent() {
    return stringContent;
  }

  public void setStringContent(String stringContent) {
    this.stringContent = stringContent;
  }

  public EventContent truncated(Boolean truncated) {
    this.truncated = truncated;
    return this;
  }

  /**
   * Indicates that the Content was too long and has been truncated during runtime.
   * @return truncated
  */
  @NotNull 
  @Schema(name = "truncated", example = "true", description = "Indicates that the Content was too long and has been truncated during runtime.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("truncated")
  public Boolean getTruncated() {
    return truncated;
  }

  public void setTruncated(Boolean truncated) {
    this.truncated = truncated;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EventContent eventContent = (EventContent) o;
    return Objects.equals(this.id, eventContent.id) &&
        Objects.equals(this.stringContent, eventContent.stringContent) &&
        Objects.equals(this.truncated, eventContent.truncated);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, stringContent, truncated);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EventContent {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    stringContent: ").append(toIndentedString(stringContent)).append("\n");
    sb.append("    truncated: ").append(toIndentedString(truncated)).append("\n");
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


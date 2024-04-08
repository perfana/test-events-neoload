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
 * Number of errors for an element
 */

@Schema(name = "ErrorCountByElement", description = "Number of errors for an element")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-04-06T15:29:22.895694+02:00[Europe/Amsterdam]", comments = "Generator version: 7.4.0")
public class ErrorCountByElement {

  private Long count;

  private String element;

  private String parent;

  private String userPath;

  public ErrorCountByElement() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public ErrorCountByElement(Long count, String element, String parent, String userPath) {
    this.count = count;
    this.element = element;
    this.parent = parent;
    this.userPath = userPath;
  }

  public ErrorCountByElement count(Long count) {
    this.count = count;
    return this;
  }

  /**
   * Number of errors
   * @return count
  */
  @NotNull 
  @Schema(name = "count", example = "1", description = "Number of errors", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("count")
  public Long getCount() {
    return count;
  }

  public void setCount(Long count) {
    this.count = count;
  }

  public ErrorCountByElement element(String element) {
    this.element = element;
    return this;
  }

  /**
   * Element name
   * @return element
  */
  @NotNull 
  @Schema(name = "element", example = "element", description = "Element name", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("element")
  public String getElement() {
    return element;
  }

  public void setElement(String element) {
    this.element = element;
  }

  public ErrorCountByElement parent(String parent) {
    this.parent = parent;
    return this;
  }

  /**
   * Parent name
   * @return parent
  */
  @NotNull 
  @Schema(name = "parent", example = "parent", description = "Parent name", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("parent")
  public String getParent() {
    return parent;
  }

  public void setParent(String parent) {
    this.parent = parent;
  }

  public ErrorCountByElement userPath(String userPath) {
    this.userPath = userPath;
    return this;
  }

  /**
   * Userpath name
   * @return userPath
  */
  @NotNull 
  @Schema(name = "userPath", example = "userpath", description = "Userpath name", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("userPath")
  public String getUserPath() {
    return userPath;
  }

  public void setUserPath(String userPath) {
    this.userPath = userPath;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ErrorCountByElement errorCountByElement = (ErrorCountByElement) o;
    return Objects.equals(this.count, errorCountByElement.count) &&
        Objects.equals(this.element, errorCountByElement.element) &&
        Objects.equals(this.parent, errorCountByElement.parent) &&
        Objects.equals(this.userPath, errorCountByElement.userPath);
  }

  @Override
  public int hashCode() {
    return Objects.hash(count, element, parent, userPath);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ErrorCountByElement {\n");
    sb.append("    count: ").append(toIndentedString(count)).append("\n");
    sb.append("    element: ").append(toIndentedString(element)).append("\n");
    sb.append("    parent: ").append(toIndentedString(parent)).append("\n");
    sb.append("    userPath: ").append(toIndentedString(userPath)).append("\n");
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


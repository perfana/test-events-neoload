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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * GetUserPathElementsResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-04-06T15:29:22.895694+02:00[Europe/Amsterdam]", comments = "Generator version: 7.4.0")
public class GetUserPathElementsResponse {

  @Valid
  private List<@Valid UserPathElement> rootElements;

  public GetUserPathElementsResponse rootElements(List<@Valid UserPathElement> rootElements) {
    this.rootElements = rootElements;
    return this;
  }

  public GetUserPathElementsResponse addRootElementsItem(UserPathElement rootElementsItem) {
    if (this.rootElements == null) {
      this.rootElements = new ArrayList<>();
    }
    this.rootElements.add(rootElementsItem);
    return this;
  }

  /**
   * Get rootElements
   * @return rootElements
  */
  @Valid 
  @Schema(name = "rootElements", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("rootElements")
  public List<@Valid UserPathElement> getRootElements() {
    return rootElements;
  }

  public void setRootElements(List<@Valid UserPathElement> rootElements) {
    this.rootElements = rootElements;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetUserPathElementsResponse getUserPathElementsResponse = (GetUserPathElementsResponse) o;
    return Objects.equals(this.rootElements, getUserPathElementsResponse.rootElements);
  }

  @Override
  public int hashCode() {
    return Objects.hash(rootElements);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetUserPathElementsResponse {\n");
    sb.append("    rootElements: ").append(toIndentedString(rootElements)).append("\n");
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


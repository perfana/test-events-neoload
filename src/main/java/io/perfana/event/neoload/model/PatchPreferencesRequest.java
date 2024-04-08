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
import jakarta.validation.constraints.Pattern;

import java.util.Objects;

/**
 * PatchPreferencesRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-04-06T15:29:22.895694+02:00[Europe/Amsterdam]", comments = "Generator version: 7.4.0")
public class PatchPreferencesRequest {

  private String currentWorkspaceId;

  public PatchPreferencesRequest currentWorkspaceId(String currentWorkspaceId) {
    this.currentWorkspaceId = currentWorkspaceId;
    return this;
  }

  /**
   * Id of the currently selected workspace id.
   * @return currentWorkspaceId
  */
  @Pattern(regexp = "^[0-9a-f]{24}$") 
  @Schema(name = "currentWorkspaceId", example = "69c9a277bb9a473ca3d0d567", description = "Id of the currently selected workspace id.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("currentWorkspaceId")
  public String getCurrentWorkspaceId() {
    return currentWorkspaceId;
  }

  public void setCurrentWorkspaceId(String currentWorkspaceId) {
    this.currentWorkspaceId = currentWorkspaceId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PatchPreferencesRequest patchPreferencesRequest = (PatchPreferencesRequest) o;
    return Objects.equals(this.currentWorkspaceId, patchPreferencesRequest.currentWorkspaceId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(currentWorkspaceId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PatchPreferencesRequest {\n");
    sb.append("    currentWorkspaceId: ").append(toIndentedString(currentWorkspaceId)).append("\n");
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


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
import jakarta.validation.constraints.Size;

import java.util.Objects;

/**
 * Represents a dashboard modification.
 */

@Schema(name = "DashboardPatchRequest", description = "Represents a dashboard modification.")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-04-06T15:29:22.895694+02:00[Europe/Amsterdam]", comments = "Generator version: 7.4.0")
public class DashboardPatchRequest {

  private String name;

  /**
   * ShareStatus
   */
  public enum ShareStatusEnum {
    UNSHARED("UNSHARED"),
    
    SHARED_READ("SHARED_READ"),
    
    SHARED_WRITE("SHARED_WRITE");

    private String value;

    ShareStatusEnum(String value) {
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
    public static ShareStatusEnum fromValue(String value) {
      for (ShareStatusEnum b : ShareStatusEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private ShareStatusEnum shareStatus;

  public DashboardPatchRequest name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name
   * @return name
  */
  @Size(max = 80) 
  @Schema(name = "name", description = "Name", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public DashboardPatchRequest shareStatus(ShareStatusEnum shareStatus) {
    this.shareStatus = shareStatus;
    return this;
  }

  /**
   * ShareStatus
   * @return shareStatus
  */
  
  @Schema(name = "shareStatus", description = "ShareStatus", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("shareStatus")
  public ShareStatusEnum getShareStatus() {
    return shareStatus;
  }

  public void setShareStatus(ShareStatusEnum shareStatus) {
    this.shareStatus = shareStatus;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DashboardPatchRequest dashboardPatchRequest = (DashboardPatchRequest) o;
    return Objects.equals(this.name, dashboardPatchRequest.name) &&
        Objects.equals(this.shareStatus, dashboardPatchRequest.shareStatus);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, shareStatus);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DashboardPatchRequest {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    shareStatus: ").append(toIndentedString(shareStatus)).append("\n");
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


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

import java.time.OffsetDateTime;
import java.util.Objects;

/**
 * Dashboard
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-04-06T15:29:22.895694+02:00[Europe/Amsterdam]", comments = "Generator version: 7.4.0")
public class Dashboard {

  private String id;

  private OffsetDateTime createdAt;

  private String name;

  private String ownerFullName;

  private String ownerId;

  /**
   * Gets or Sets shareStatus
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

  private OffsetDateTime updatedAt;

  private String workspaceId;

  private String benchId;

  private String publicToken;

  private String userIdUpdate;

  public Dashboard() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public Dashboard(String id, OffsetDateTime createdAt, String name, String ownerFullName, String ownerId, ShareStatusEnum shareStatus, OffsetDateTime updatedAt, String workspaceId) {
    this.id = id;
    this.createdAt = createdAt;
    this.name = name;
    this.ownerFullName = ownerFullName;
    this.ownerId = ownerId;
    this.shareStatus = shareStatus;
    this.updatedAt = updatedAt;
    this.workspaceId = workspaceId;
  }

  public Dashboard id(String id) {
    this.id = id;
    return this;
  }

  /**
   * ID
   * @return id
  */
  @NotNull @Pattern(regexp = "^[0-9a-fA-F]{8}-([0-9a-fA-F]{4}-){3}[0-9a-fA-F]{12}$") 
  @Schema(name = "id", example = "123e4567-e89b-12d3-a456-426655440000", description = "ID", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("id")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Dashboard createdAt(OffsetDateTime createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  /**
   * Date and time in UTC when the entity was created.
   * @return createdAt
  */
  @NotNull @Valid 
  @Schema(name = "createdAt", example = "2021-01-30T08:30Z", description = "Date and time in UTC when the entity was created.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("createdAt")
  public OffsetDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(OffsetDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public Dashboard name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  */
  @NotNull 
  @Schema(name = "name", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Dashboard ownerFullName(String ownerFullName) {
    this.ownerFullName = ownerFullName;
    return this;
  }

  /**
   * Get ownerFullName
   * @return ownerFullName
  */
  @NotNull 
  @Schema(name = "ownerFullName", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("ownerFullName")
  public String getOwnerFullName() {
    return ownerFullName;
  }

  public void setOwnerFullName(String ownerFullName) {
    this.ownerFullName = ownerFullName;
  }

  public Dashboard ownerId(String ownerId) {
    this.ownerId = ownerId;
    return this;
  }

  /**
   * ID
   * @return ownerId
  */
  @NotNull @Pattern(regexp = "^[0-9a-f]{24}$") 
  @Schema(name = "ownerId", example = "69c9a277bb9a473ca3d0d567", description = "ID", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("ownerId")
  public String getOwnerId() {
    return ownerId;
  }

  public void setOwnerId(String ownerId) {
    this.ownerId = ownerId;
  }

  public Dashboard shareStatus(ShareStatusEnum shareStatus) {
    this.shareStatus = shareStatus;
    return this;
  }

  /**
   * Get shareStatus
   * @return shareStatus
  */
  @NotNull 
  @Schema(name = "shareStatus", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("shareStatus")
  public ShareStatusEnum getShareStatus() {
    return shareStatus;
  }

  public void setShareStatus(ShareStatusEnum shareStatus) {
    this.shareStatus = shareStatus;
  }

  public Dashboard updatedAt(OffsetDateTime updatedAt) {
    this.updatedAt = updatedAt;
    return this;
  }

  /**
   * Date and time in UTC when the entity was updated for the last time
   * @return updatedAt
  */
  @NotNull @Valid 
  @Schema(name = "updatedAt", example = "2021-01-30T08:30Z", description = "Date and time in UTC when the entity was updated for the last time", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("updatedAt")
  public OffsetDateTime getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(OffsetDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }

  public Dashboard workspaceId(String workspaceId) {
    this.workspaceId = workspaceId;
    return this;
  }

  /**
   * ID
   * @return workspaceId
  */
  @NotNull @Pattern(regexp = "^[0-9a-f]{24}$") 
  @Schema(name = "workspaceId", example = "69c9a277bb9a473ca3d0d567", description = "ID", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("workspaceId")
  public String getWorkspaceId() {
    return workspaceId;
  }

  public void setWorkspaceId(String workspaceId) {
    this.workspaceId = workspaceId;
  }

  public Dashboard benchId(String benchId) {
    this.benchId = benchId;
    return this;
  }

  /**
   * ID
   * @return benchId
  */
  @Pattern(regexp = "^[0-9a-f]{24}$") 
  @Schema(name = "benchId", example = "69c9a277bb9a473ca3d0d567", description = "ID", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("benchId")
  public String getBenchId() {
    return benchId;
  }

  public void setBenchId(String benchId) {
    this.benchId = benchId;
  }

  public Dashboard publicToken(String publicToken) {
    this.publicToken = publicToken;
    return this;
  }

  /**
   * Get publicToken
   * @return publicToken
  */
  
  @Schema(name = "publicToken", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("publicToken")
  public String getPublicToken() {
    return publicToken;
  }

  public void setPublicToken(String publicToken) {
    this.publicToken = publicToken;
  }

  public Dashboard userIdUpdate(String userIdUpdate) {
    this.userIdUpdate = userIdUpdate;
    return this;
  }

  /**
   * ID
   * @return userIdUpdate
  */
  @Pattern(regexp = "^[0-9a-f]{24}$") 
  @Schema(name = "userIdUpdate", example = "69c9a277bb9a473ca3d0d567", description = "ID", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("userIdUpdate")
  public String getUserIdUpdate() {
    return userIdUpdate;
  }

  public void setUserIdUpdate(String userIdUpdate) {
    this.userIdUpdate = userIdUpdate;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Dashboard dashboard = (Dashboard) o;
    return Objects.equals(this.id, dashboard.id) &&
        Objects.equals(this.createdAt, dashboard.createdAt) &&
        Objects.equals(this.name, dashboard.name) &&
        Objects.equals(this.ownerFullName, dashboard.ownerFullName) &&
        Objects.equals(this.ownerId, dashboard.ownerId) &&
        Objects.equals(this.shareStatus, dashboard.shareStatus) &&
        Objects.equals(this.updatedAt, dashboard.updatedAt) &&
        Objects.equals(this.workspaceId, dashboard.workspaceId) &&
        Objects.equals(this.benchId, dashboard.benchId) &&
        Objects.equals(this.publicToken, dashboard.publicToken) &&
        Objects.equals(this.userIdUpdate, dashboard.userIdUpdate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, createdAt, name, ownerFullName, ownerId, shareStatus, updatedAt, workspaceId, benchId, publicToken, userIdUpdate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Dashboard {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    ownerFullName: ").append(toIndentedString(ownerFullName)).append("\n");
    sb.append("    ownerId: ").append(toIndentedString(ownerId)).append("\n");
    sb.append("    shareStatus: ").append(toIndentedString(shareStatus)).append("\n");
    sb.append("    updatedAt: ").append(toIndentedString(updatedAt)).append("\n");
    sb.append("    workspaceId: ").append(toIndentedString(workspaceId)).append("\n");
    sb.append("    benchId: ").append(toIndentedString(benchId)).append("\n");
    sb.append("    publicToken: ").append(toIndentedString(publicToken)).append("\n");
    sb.append("    userIdUpdate: ").append(toIndentedString(userIdUpdate)).append("\n");
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


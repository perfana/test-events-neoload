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
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

/**
 * Set component content as text
 */

@Schema(name = "DashboardTextTilePatchOneRequest", description = "Set component content as text")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-04-06T15:29:22.895694+02:00[Europe/Amsterdam]", comments = "Generator version: 7.4.0")
public class DashboardTextTilePatchOneRequest implements DashboardTilesPatchOneRequest {

  private String text;

  /**
   * Type of the tile
   */
  public enum TypeEnum {
    TEXT("TEXT");

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

  private String title;

  public DashboardTextTilePatchOneRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public DashboardTextTilePatchOneRequest(String text, TypeEnum type) {
    this.text = text;
    this.type = type;
  }

  public DashboardTextTilePatchOneRequest text(String text) {
    this.text = text;
    return this;
  }

  /**
   * A text content to display inside the tile.
   * @return text
  */
  @NotNull 
  @Schema(name = "text", description = "A text content to display inside the tile.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("text")
  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public DashboardTextTilePatchOneRequest type(TypeEnum type) {
    this.type = type;
    return this;
  }

  /**
   * Type of the tile
   * @return type
  */
  @NotNull 
  @Schema(name = "type", description = "Type of the tile", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("type")
  public String getType() {
    return String.valueOf(type);
  }

  public void setType(TypeEnum type) {
    this.type = type;
  }

  public DashboardTextTilePatchOneRequest title(String title) {
    this.title = title;
    return this;
  }

  /**
   * Tile title
   * @return title
  */
  
  @Schema(name = "title", description = "Tile title", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("title")
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DashboardTextTilePatchOneRequest dashboardTextTilePatchOneRequest = (DashboardTextTilePatchOneRequest) o;
    return Objects.equals(this.text, dashboardTextTilePatchOneRequest.text) &&
        Objects.equals(this.type, dashboardTextTilePatchOneRequest.type) &&
        Objects.equals(this.title, dashboardTextTilePatchOneRequest.title);
  }

  @Override
  public int hashCode() {
    return Objects.hash(text, type, title);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DashboardTextTilePatchOneRequest {\n");
    sb.append("    text: ").append(toIndentedString(text)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
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


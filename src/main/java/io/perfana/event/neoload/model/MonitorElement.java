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
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * An element of the monitor tree
 */

@Schema(name = "MonitorElement", description = "An element of the monitor tree")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-04-06T15:29:22.895694+02:00[Europe/Amsterdam]", comments = "Generator version: 7.4.0")
public class MonitorElement {

  private String id;

  @Valid
  private List<@Valid MonitorElement> children = new ArrayList<>();

  private Boolean drawable;

  private String name;

  public MonitorElement() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public MonitorElement(String id, List<@Valid MonitorElement> children, Boolean drawable, String name) {
    this.id = id;
    this.children = children;
    this.drawable = drawable;
    this.name = name;
  }

  public MonitorElement id(String id) {
    this.id = id;
    return this;
  }

  /**
   * ID of the element
   * @return id
  */
  @NotNull 
  @Schema(name = "id", description = "ID of the element", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("id")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public MonitorElement children(List<@Valid MonitorElement> children) {
    this.children = children;
    return this;
  }

  public MonitorElement addChildrenItem(MonitorElement childrenItem) {
    if (this.children == null) {
      this.children = new ArrayList<>();
    }
    this.children.add(childrenItem);
    return this;
  }

  /**
   * List of children for this element
   * @return children
  */
  @NotNull @Valid 
  @Schema(name = "children", description = "List of children for this element", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("children")
  public List<@Valid MonitorElement> getChildren() {
    return children;
  }

  public void setChildren(List<@Valid MonitorElement> children) {
    this.children = children;
  }

  public MonitorElement drawable(Boolean drawable) {
    this.drawable = drawable;
    return this;
  }

  /**
   * Returns true if a timeseries can be drawn for this monitor
   * @return drawable
  */
  @NotNull 
  @Schema(name = "drawable", description = "Returns true if a timeseries can be drawn for this monitor", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("drawable")
  public Boolean getDrawable() {
    return drawable;
  }

  public void setDrawable(Boolean drawable) {
    this.drawable = drawable;
  }

  public MonitorElement name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of the element
   * @return name
  */
  @NotNull 
  @Schema(name = "name", description = "Name of the element", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MonitorElement monitorElement = (MonitorElement) o;
    return Objects.equals(this.id, monitorElement.id) &&
        Objects.equals(this.children, monitorElement.children) &&
        Objects.equals(this.drawable, monitorElement.drawable) &&
        Objects.equals(this.name, monitorElement.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, children, drawable, name);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MonitorElement {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    children: ").append(toIndentedString(children)).append("\n");
    sb.append("    drawable: ").append(toIndentedString(drawable)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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


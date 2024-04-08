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
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.util.*;

/**
 * An element of the user path tree
 */

@Schema(name = "UserPathElement", description = "An element of the user path tree")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-04-06T15:29:22.895694+02:00[Europe/Amsterdam]", comments = "Generator version: 7.4.0")
public class UserPathElement {

  private String id;

  @Valid
  private List<@Valid UserPathElement> children = new ArrayList<>();

  private String name;

  /**
   * List of available statistics for this element
   */
  public enum StatisticsEnum {
    AVGDURATION("avgDuration"),
    
    MINDURATION("minDuration"),
    
    MAXDURATION("maxDuration"),
    
    THROUGHPUT("throughput"),
    
    ELEMENTSPERSECOND("elementsPerSecond"),
    
    ERRORS("errors"),
    
    ERRORSPERSECOND("errorsPerSecond"),
    
    ERRORRATE("errorRate"),
    
    AVGTTFB("avgTtfb"),
    
    MINTTFB("minTtfb"),
    
    MAXTTFB("maxTtfb"),
    
    PERCENTILES("percentiles");

    private String value;

    StatisticsEnum(String value) {
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
    public static StatisticsEnum fromValue(String value) {
      for (StatisticsEnum b : StatisticsEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @Valid
  private Set<StatisticsEnum> statistics = new LinkedHashSet<>();

  /**
   * Type of the element
   */
  public enum TypeEnum {
    USER_PATH("USER_PATH"),
    
    SHARED_CONTAINERS("SHARED_CONTAINERS"),
    
    INIT_CONTAINER("INIT_CONTAINER"),
    
    ACTIONS_CONTAINER("ACTIONS_CONTAINER"),
    
    END_CONTAINER("END_CONTAINER"),
    
    TRANSACTION("TRANSACTION"),
    
    REQUEST("REQUEST"),
    
    PAGE("PAGE"),
    
    ACTION("ACTION"),
    
    DELAY("DELAY"),
    
    OTHER("OTHER");

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

  public UserPathElement() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public UserPathElement(String id, List<@Valid UserPathElement> children, String name, Set<StatisticsEnum> statistics, TypeEnum type) {
    this.id = id;
    this.children = children;
    this.name = name;
    this.statistics = statistics;
    this.type = type;
  }

  public UserPathElement id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier representing a specific Element. <br>  Could be a UUID or one of the following: <br>  all-transaction <br> all-requests <br> all-pages <br> all-actions <br> init-container <br> actions-container <br> end-container <br> 
   * @return id
  */
  @NotNull @Pattern(regexp = "^[0-9a-fA-F]{8}-([0-9a-fA-F]{4}-){3}[0-9a-fA-F]{12}$|all-transactions|all-pages|all-requests|all-actions|init-container|actions-container|end-container") 
  @Schema(name = "id", example = "all-transactions", description = "Unique identifier representing a specific Element. <br>  Could be a UUID or one of the following: <br>  all-transaction <br> all-requests <br> all-pages <br> all-actions <br> init-container <br> actions-container <br> end-container <br> ", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("id")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public UserPathElement children(List<@Valid UserPathElement> children) {
    this.children = children;
    return this;
  }

  public UserPathElement addChildrenItem(UserPathElement childrenItem) {
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
  public List<@Valid UserPathElement> getChildren() {
    return children;
  }

  public void setChildren(List<@Valid UserPathElement> children) {
    this.children = children;
  }

  public UserPathElement name(String name) {
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

  public UserPathElement statistics(Set<StatisticsEnum> statistics) {
    this.statistics = statistics;
    return this;
  }

  public UserPathElement addStatisticsItem(StatisticsEnum statisticsItem) {
    if (this.statistics == null) {
      this.statistics = new LinkedHashSet<>();
    }
    this.statistics.add(statisticsItem);
    return this;
  }

  /**
   * List of available statistics for this element
   * @return statistics
  */
  @NotNull 
  @Schema(name = "statistics", description = "List of available statistics for this element", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("statistics")
  public Set<StatisticsEnum> getStatistics() {
    return statistics;
  }

  @JsonDeserialize(as = LinkedHashSet.class)
  public void setStatistics(Set<StatisticsEnum> statistics) {
    this.statistics = statistics;
  }

  public UserPathElement type(TypeEnum type) {
    this.type = type;
    return this;
  }

  /**
   * Type of the element
   * @return type
  */
  @NotNull 
  @Schema(name = "type", description = "Type of the element", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("type")
  public String getType() {
    return String.valueOf(type);
  }

  public void setType(TypeEnum type) {
    this.type = type;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserPathElement userPathElement = (UserPathElement) o;
    return Objects.equals(this.id, userPathElement.id) &&
        Objects.equals(this.children, userPathElement.children) &&
        Objects.equals(this.name, userPathElement.name) &&
        Objects.equals(this.statistics, userPathElement.statistics) &&
        Objects.equals(this.type, userPathElement.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, children, name, statistics, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserPathElement {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    children: ").append(toIndentedString(children)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    statistics: ").append(toIndentedString(statistics)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
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


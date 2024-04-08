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

import java.util.Objects;

/**
 * A tile for displaying predefined widget components.
 */

@Schema(name = "WidgetDashboardTile", description = "A tile for displaying predefined widget components.")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-04-06T15:29:22.895694+02:00[Europe/Amsterdam]", comments = "Generator version: 7.4.0")
public class WidgetDashboardTile implements DashboardTile {

  private String id;

  private DashboardFilter filter;

  private Integer height;

  private String resultId;

  private String resultName;

  private String title;

  /**
   * Gets or Sets type
   */
  public enum TypeEnum {
    EMPTY("EMPTY"),
    
    SERIES("SERIES"),
    
    TEXT("TEXT"),
    
    WIDGET("WIDGET");

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

  private TypeEnum type = TypeEnum.WIDGET;

  /**
   * The type of visualisation for this widget.
   */
  public enum VisualizationEnum {
    LINE_CHART("LINE_CHART"),
    
    TABLE("TABLE"),
    
    TEXT("TEXT"),
    
    PIE_CHART("PIE_CHART"),
    
    COUNTER("COUNTER"),
    
    SUMMARY("SUMMARY"),
    
    CATEGORY("CATEGORY");

    private String value;

    VisualizationEnum(String value) {
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
    public static VisualizationEnum fromValue(String value) {
      for (VisualizationEnum b : VisualizationEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private VisualizationEnum visualization;

  private Integer width;

  private Integer x;

  private Integer y;

  private String testId;

  private String testName;

  public WidgetDashboardTile() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public WidgetDashboardTile(String id, DashboardFilter filter, Integer height, String resultId, String resultName, String title, TypeEnum type, VisualizationEnum visualization, Integer width, Integer x, Integer y) {
    this.id = id;
    this.filter = filter;
    this.height = height;
    this.resultId = resultId;
    this.resultName = resultName;
    this.title = title;
    this.type = type;
    this.visualization = visualization;
    this.width = width;
    this.x = x;
    this.y = y;
  }

  public WidgetDashboardTile id(String id) {
    this.id = id;
    return this;
  }

  /**
   * ID
   * @return id
  */
  @NotNull @Pattern(regexp = "^[0-9a-f]{24}$") 
  @Schema(name = "id", example = "69c9a277bb9a473ca3d0d567", description = "ID", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("id")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public WidgetDashboardTile filter(DashboardFilter filter) {
    this.filter = filter;
    return this;
  }

  /**
   * Get filter
   * @return filter
  */
  @NotNull @Valid 
  @Schema(name = "filter", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("filter")
  public DashboardFilter getFilter() {
    return filter;
  }

  public void setFilter(DashboardFilter filter) {
    this.filter = filter;
  }

  public WidgetDashboardTile height(Integer height) {
    this.height = height;
    return this;
  }

  /**
   * Get height
   * @return height
  */
  @NotNull 
  @Schema(name = "height", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("height")
  public Integer getHeight() {
    return height;
  }

  public void setHeight(Integer height) {
    this.height = height;
  }

  public WidgetDashboardTile resultId(String resultId) {
    this.resultId = resultId;
    return this;
  }

  /**
   * ID
   * @return resultId
  */
  @NotNull @Pattern(regexp = "^[0-9a-fA-F]{8}-([0-9a-fA-F]{4}-){3}[0-9a-fA-F]{12}$") 
  @Schema(name = "resultId", example = "123e4567-e89b-12d3-a456-426655440000", description = "ID", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("resultId")
  public String getResultId() {
    return resultId;
  }

  public void setResultId(String resultId) {
    this.resultId = resultId;
  }

  public WidgetDashboardTile resultName(String resultName) {
    this.resultName = resultName;
    return this;
  }

  /**
   * Get resultName
   * @return resultName
  */
  @NotNull 
  @Schema(name = "resultName", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("resultName")
  public String getResultName() {
    return resultName;
  }

  public void setResultName(String resultName) {
    this.resultName = resultName;
  }

  public WidgetDashboardTile title(String title) {
    this.title = title;
    return this;
  }

  /**
   * Get title
   * @return title
  */
  @NotNull 
  @Schema(name = "title", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("title")
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public WidgetDashboardTile type(TypeEnum type) {
    this.type = type;
    return this;
  }

  /**
   * Get type
   * @return type
  */
  
  @Schema(name = "type", accessMode = Schema.AccessMode.READ_ONLY, requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("type")
  public String getType() {
    return String.valueOf(type);
  }

  public void setType(TypeEnum type) {
    this.type = type;
  }

  public WidgetDashboardTile visualization(VisualizationEnum visualization) {
    this.visualization = visualization;
    return this;
  }

  /**
   * The type of visualisation for this widget.
   * @return visualization
  */
  @NotNull 
  @Schema(name = "visualization", description = "The type of visualisation for this widget.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("visualization")
  public VisualizationEnum getVisualization() {
    return visualization;
  }

  public void setVisualization(VisualizationEnum visualization) {
    this.visualization = visualization;
  }

  public WidgetDashboardTile width(Integer width) {
    this.width = width;
    return this;
  }

  /**
   * Get width
   * @return width
  */
  @NotNull 
  @Schema(name = "width", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("width")
  public Integer getWidth() {
    return width;
  }

  public void setWidth(Integer width) {
    this.width = width;
  }

  public WidgetDashboardTile x(Integer x) {
    this.x = x;
    return this;
  }

  /**
   * Get x
   * @return x
  */
  @NotNull 
  @Schema(name = "x", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("x")
  public Integer getX() {
    return x;
  }

  public void setX(Integer x) {
    this.x = x;
  }

  public WidgetDashboardTile y(Integer y) {
    this.y = y;
    return this;
  }

  /**
   * Get y
   * @return y
  */
  @NotNull 
  @Schema(name = "y", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("y")
  public Integer getY() {
    return y;
  }

  public void setY(Integer y) {
    this.y = y;
  }

  public WidgetDashboardTile testId(String testId) {
    this.testId = testId;
    return this;
  }

  /**
   * ID
   * @return testId
  */
  @Pattern(regexp = "^[0-9a-fA-F]{8}-([0-9a-fA-F]{4}-){3}[0-9a-fA-F]{12}$") 
  @Schema(name = "testId", example = "123e4567-e89b-12d3-a456-426655440000", description = "ID", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("testId")
  public String getTestId() {
    return testId;
  }

  public void setTestId(String testId) {
    this.testId = testId;
  }

  public WidgetDashboardTile testName(String testName) {
    this.testName = testName;
    return this;
  }

  /**
   * Get testName
   * @return testName
  */
  
  @Schema(name = "testName", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("testName")
  public String getTestName() {
    return testName;
  }

  public void setTestName(String testName) {
    this.testName = testName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WidgetDashboardTile widgetDashboardTile = (WidgetDashboardTile) o;
    return Objects.equals(this.id, widgetDashboardTile.id) &&
        Objects.equals(this.filter, widgetDashboardTile.filter) &&
        Objects.equals(this.height, widgetDashboardTile.height) &&
        Objects.equals(this.resultId, widgetDashboardTile.resultId) &&
        Objects.equals(this.resultName, widgetDashboardTile.resultName) &&
        Objects.equals(this.title, widgetDashboardTile.title) &&
        Objects.equals(this.type, widgetDashboardTile.type) &&
        Objects.equals(this.visualization, widgetDashboardTile.visualization) &&
        Objects.equals(this.width, widgetDashboardTile.width) &&
        Objects.equals(this.x, widgetDashboardTile.x) &&
        Objects.equals(this.y, widgetDashboardTile.y) &&
        Objects.equals(this.testId, widgetDashboardTile.testId) &&
        Objects.equals(this.testName, widgetDashboardTile.testName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, filter, height, resultId, resultName, title, type, visualization, width, x, y, testId, testName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WidgetDashboardTile {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    filter: ").append(toIndentedString(filter)).append("\n");
    sb.append("    height: ").append(toIndentedString(height)).append("\n");
    sb.append("    resultId: ").append(toIndentedString(resultId)).append("\n");
    sb.append("    resultName: ").append(toIndentedString(resultName)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    visualization: ").append(toIndentedString(visualization)).append("\n");
    sb.append("    width: ").append(toIndentedString(width)).append("\n");
    sb.append("    x: ").append(toIndentedString(x)).append("\n");
    sb.append("    y: ").append(toIndentedString(y)).append("\n");
    sb.append("    testId: ").append(toIndentedString(testId)).append("\n");
    sb.append("    testName: ").append(toIndentedString(testName)).append("\n");
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


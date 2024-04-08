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
 * Set component content as widget
 */

@Schema(name = "DashboardWidgetTilePatchOneRequest", description = "Set component content as widget")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-04-06T15:29:22.895694+02:00[Europe/Amsterdam]", comments = "Generator version: 7.4.0")
public class DashboardWidgetTilePatchOneRequest implements DashboardTilesPatchOneRequest {

  private DashboardFilter filter;

  private String resultId;

  private String resultName;

  /**
   * Type of the tile
   */
  public enum TypeEnum {
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

  private TypeEnum type;

  /**
   * The type of visualisation for this widget
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

  private String testId;

  private String testName;

  private String title;

  public DashboardWidgetTilePatchOneRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public DashboardWidgetTilePatchOneRequest(DashboardFilter filter, String resultId, String resultName, TypeEnum type, VisualizationEnum visualization) {
    this.filter = filter;
    this.resultId = resultId;
    this.resultName = resultName;
    this.type = type;
    this.visualization = visualization;
  }

  public DashboardWidgetTilePatchOneRequest filter(DashboardFilter filter) {
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

  public DashboardWidgetTilePatchOneRequest resultId(String resultId) {
    this.resultId = resultId;
    return this;
  }

  /**
   * Test result id to which the widget refers
   * @return resultId
  */
  @NotNull @Pattern(regexp = "^[0-9a-fA-F]{8}-([0-9a-fA-F]{4}-){3}[0-9a-fA-F]{12}$") 
  @Schema(name = "resultId", example = "123e4567-e89b-12d3-a456-426655440000", description = "Test result id to which the widget refers", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("resultId")
  public String getResultId() {
    return resultId;
  }

  public void setResultId(String resultId) {
    this.resultId = resultId;
  }

  public DashboardWidgetTilePatchOneRequest resultName(String resultName) {
    this.resultName = resultName;
    return this;
  }

  /**
   * Test result name to which the widget refers
   * @return resultName
  */
  @NotNull 
  @Schema(name = "resultName", description = "Test result name to which the widget refers", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("resultName")
  public String getResultName() {
    return resultName;
  }

  public void setResultName(String resultName) {
    this.resultName = resultName;
  }

  public DashboardWidgetTilePatchOneRequest type(TypeEnum type) {
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

  public DashboardWidgetTilePatchOneRequest visualization(VisualizationEnum visualization) {
    this.visualization = visualization;
    return this;
  }

  /**
   * The type of visualisation for this widget
   * @return visualization
  */
  @NotNull 
  @Schema(name = "visualization", description = "The type of visualisation for this widget", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("visualization")
  public VisualizationEnum getVisualization() {
    return visualization;
  }

  public void setVisualization(VisualizationEnum visualization) {
    this.visualization = visualization;
  }

  public DashboardWidgetTilePatchOneRequest testId(String testId) {
    this.testId = testId;
    return this;
  }

  /**
   * Test settings id to which the widget refers if exists
   * @return testId
  */
  @Pattern(regexp = "^[0-9a-fA-F]{8}-([0-9a-fA-F]{4}-){3}[0-9a-fA-F]{12}$") 
  @Schema(name = "testId", example = "123e4567-e89b-12d3-a456-426655440000", description = "Test settings id to which the widget refers if exists", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("testId")
  public String getTestId() {
    return testId;
  }

  public void setTestId(String testId) {
    this.testId = testId;
  }

  public DashboardWidgetTilePatchOneRequest testName(String testName) {
    this.testName = testName;
    return this;
  }

  /**
   * Test settings name to which the widget refers if exists
   * @return testName
  */
  
  @Schema(name = "testName", description = "Test settings name to which the widget refers if exists", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("testName")
  public String getTestName() {
    return testName;
  }

  public void setTestName(String testName) {
    this.testName = testName;
  }

  public DashboardWidgetTilePatchOneRequest title(String title) {
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
    DashboardWidgetTilePatchOneRequest dashboardWidgetTilePatchOneRequest = (DashboardWidgetTilePatchOneRequest) o;
    return Objects.equals(this.filter, dashboardWidgetTilePatchOneRequest.filter) &&
        Objects.equals(this.resultId, dashboardWidgetTilePatchOneRequest.resultId) &&
        Objects.equals(this.resultName, dashboardWidgetTilePatchOneRequest.resultName) &&
        Objects.equals(this.type, dashboardWidgetTilePatchOneRequest.type) &&
        Objects.equals(this.visualization, dashboardWidgetTilePatchOneRequest.visualization) &&
        Objects.equals(this.testId, dashboardWidgetTilePatchOneRequest.testId) &&
        Objects.equals(this.testName, dashboardWidgetTilePatchOneRequest.testName) &&
        Objects.equals(this.title, dashboardWidgetTilePatchOneRequest.title);
  }

  @Override
  public int hashCode() {
    return Objects.hash(filter, resultId, resultName, type, visualization, testId, testName, title);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DashboardWidgetTilePatchOneRequest {\n");
    sb.append("    filter: ").append(toIndentedString(filter)).append("\n");
    sb.append("    resultId: ").append(toIndentedString(resultId)).append("\n");
    sb.append("    resultName: ").append(toIndentedString(resultName)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    visualization: ").append(toIndentedString(visualization)).append("\n");
    sb.append("    testId: ").append(toIndentedString(testId)).append("\n");
    sb.append("    testName: ").append(toIndentedString(testName)).append("\n");
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


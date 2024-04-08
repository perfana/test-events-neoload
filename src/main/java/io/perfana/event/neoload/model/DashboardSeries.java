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
import jakarta.validation.constraints.Pattern;

import java.time.OffsetDateTime;
import java.util.Objects;

/**
 * A list of series to build a line chart.
 */

@Schema(name = "DashboardSeries", description = "A list of series to build a line chart.")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-04-06T15:29:22.895694+02:00[Europe/Amsterdam]", comments = "Generator version: 7.4.0")
public class DashboardSeries {

  private String id;

  private String color;

  private DashboardFilter filter;

  private String legend;

  private String resultId;

  private String resultName;

  private DashboardSeriesStatistic statistic;

  private Boolean visible;

  @Deprecated
  private String duration;

  @Deprecated
  private OffsetDateTime startDate;

  @Deprecated
  private String testId;

  @Deprecated
  private String testName;

  public DashboardSeries() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public DashboardSeries(String id, String color, DashboardFilter filter, String legend, String resultId, String resultName, DashboardSeriesStatistic statistic, Boolean visible) {
    this.id = id;
    this.color = color;
    this.filter = filter;
    this.legend = legend;
    this.resultId = resultId;
    this.resultName = resultName;
    this.statistic = statistic;
    this.visible = visible;
  }

  public DashboardSeries id(String id) {
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

  public DashboardSeries color(String color) {
    this.color = color;
    return this;
  }

  /**
   * The color of the series.
   * @return color
  */
  @NotNull @Pattern(regexp = "^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$") 
  @Schema(name = "color", example = "#F00", description = "The color of the series.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("color")
  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public DashboardSeries filter(DashboardFilter filter) {
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

  public DashboardSeries legend(String legend) {
    this.legend = legend;
    return this;
  }

  /**
   * The legend of the series.
   * @return legend
  */
  @NotNull 
  @Schema(name = "legend", description = "The legend of the series.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("legend")
  public String getLegend() {
    return legend;
  }

  public void setLegend(String legend) {
    this.legend = legend;
  }

  public DashboardSeries resultId(String resultId) {
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

  public DashboardSeries resultName(String resultName) {
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

  public DashboardSeries statistic(DashboardSeriesStatistic statistic) {
    this.statistic = statistic;
    return this;
  }

  /**
   * Get statistic
   * @return statistic
  */
  @NotNull @Valid 
  @Schema(name = "statistic", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("statistic")
  public DashboardSeriesStatistic getStatistic() {
    return statistic;
  }

  public void setStatistic(DashboardSeriesStatistic statistic) {
    this.statistic = statistic;
  }

  public DashboardSeries visible(Boolean visible) {
    this.visible = visible;
    return this;
  }

  /**
   * Defines whether the series should be displayed or hidden.
   * @return visible
  */
  @NotNull 
  @Schema(name = "visible", description = "Defines whether the series should be displayed or hidden.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("visible")
  public Boolean getVisible() {
    return visible;
  }

  public void setVisible(Boolean visible) {
    this.visible = visible;
  }

  public DashboardSeries duration(String duration) {
    this.duration = duration;
    return this;
  }

  /**
   * The duration of the series in ISO 8601 format.
   * @return duration
   * @deprecated
  */
  
  @Schema(name = "duration", example = "PT25M", description = "The duration of the series in ISO 8601 format.", deprecated = true, requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("duration")
  @Deprecated
  public String getDuration() {
    return duration;
  }

  /**
   * @deprecated
  */
  @Deprecated
  public void setDuration(String duration) {
    this.duration = duration;
  }

  public DashboardSeries startDate(OffsetDateTime startDate) {
    this.startDate = startDate;
    return this;
  }

  /**
   * UTC Datetime of the start of this series
   * @return startDate
   * @deprecated
  */
  @Valid 
  @Schema(name = "startDate", example = "2021-01-30T08:30Z", description = "UTC Datetime of the start of this series", deprecated = true, requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("startDate")
  @Deprecated
  public OffsetDateTime getStartDate() {
    return startDate;
  }

  /**
   * @deprecated
  */
  @Deprecated
  public void setStartDate(OffsetDateTime startDate) {
    this.startDate = startDate;
  }

  public DashboardSeries testId(String testId) {
    this.testId = testId;
    return this;
  }

  /**
   * ID
   * @return testId
   * @deprecated
  */
  
  @Schema(name = "testId", description = "ID", deprecated = true, requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("testId")
  @Deprecated
  public String getTestId() {
    return testId;
  }

  /**
   * @deprecated
  */
  @Deprecated
  public void setTestId(String testId) {
    this.testId = testId;
  }

  public DashboardSeries testName(String testName) {
    this.testName = testName;
    return this;
  }

  /**
   * Get testName
   * @return testName
   * @deprecated
  */
  
  @Schema(name = "testName", deprecated = true, requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("testName")
  @Deprecated
  public String getTestName() {
    return testName;
  }

  /**
   * @deprecated
  */
  @Deprecated
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
    DashboardSeries dashboardSeries = (DashboardSeries) o;
    return Objects.equals(this.id, dashboardSeries.id) &&
        Objects.equals(this.color, dashboardSeries.color) &&
        Objects.equals(this.filter, dashboardSeries.filter) &&
        Objects.equals(this.legend, dashboardSeries.legend) &&
        Objects.equals(this.resultId, dashboardSeries.resultId) &&
        Objects.equals(this.resultName, dashboardSeries.resultName) &&
        Objects.equals(this.statistic, dashboardSeries.statistic) &&
        Objects.equals(this.visible, dashboardSeries.visible) &&
        Objects.equals(this.duration, dashboardSeries.duration) &&
        Objects.equals(this.startDate, dashboardSeries.startDate) &&
        Objects.equals(this.testId, dashboardSeries.testId) &&
        Objects.equals(this.testName, dashboardSeries.testName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, color, filter, legend, resultId, resultName, statistic, visible, duration, startDate, testId, testName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DashboardSeries {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    color: ").append(toIndentedString(color)).append("\n");
    sb.append("    filter: ").append(toIndentedString(filter)).append("\n");
    sb.append("    legend: ").append(toIndentedString(legend)).append("\n");
    sb.append("    resultId: ").append(toIndentedString(resultId)).append("\n");
    sb.append("    resultName: ").append(toIndentedString(resultName)).append("\n");
    sb.append("    statistic: ").append(toIndentedString(statistic)).append("\n");
    sb.append("    visible: ").append(toIndentedString(visible)).append("\n");
    sb.append("    duration: ").append(toIndentedString(duration)).append("\n");
    sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
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


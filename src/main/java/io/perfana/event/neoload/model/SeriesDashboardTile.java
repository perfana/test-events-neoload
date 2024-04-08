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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A tile for displaying series-based line charts.
 */

@Schema(name = "SeriesDashboardTile", description = "A tile for displaying series-based line charts.")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-04-06T15:29:22.895694+02:00[Europe/Amsterdam]", comments = "Generator version: 7.4.0")
public class SeriesDashboardTile implements DashboardTile {

  private String id;

  private Integer height;

  @Valid
  private List<@Valid DashboardSeries> series = new ArrayList<>();

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

  private TypeEnum type = TypeEnum.SERIES;

  private Integer width;

  private Integer x;

  private Integer y;

  public SeriesDashboardTile() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public SeriesDashboardTile(String id, Integer height, List<@Valid DashboardSeries> series, String title, TypeEnum type, Integer width, Integer x, Integer y) {
    this.id = id;
    this.height = height;
    this.series = series;
    this.title = title;
    this.type = type;
    this.width = width;
    this.x = x;
    this.y = y;
  }

  public SeriesDashboardTile id(String id) {
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

  public SeriesDashboardTile height(Integer height) {
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

  public SeriesDashboardTile series(List<@Valid DashboardSeries> series) {
    this.series = series;
    return this;
  }

  public SeriesDashboardTile addSeriesItem(DashboardSeries seriesItem) {
    if (this.series == null) {
      this.series = new ArrayList<>();
    }
    this.series.add(seriesItem);
    return this;
  }

  /**
   * A list of series to build a line chart.
   * @return series
  */
  @NotNull @Valid 
  @Schema(name = "series", description = "A list of series to build a line chart.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("series")
  public List<@Valid DashboardSeries> getSeries() {
    return series;
  }

  public void setSeries(List<@Valid DashboardSeries> series) {
    this.series = series;
  }

  public SeriesDashboardTile title(String title) {
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

  public SeriesDashboardTile type(TypeEnum type) {
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

  public SeriesDashboardTile width(Integer width) {
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

  public SeriesDashboardTile x(Integer x) {
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

  public SeriesDashboardTile y(Integer y) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SeriesDashboardTile seriesDashboardTile = (SeriesDashboardTile) o;
    return Objects.equals(this.id, seriesDashboardTile.id) &&
        Objects.equals(this.height, seriesDashboardTile.height) &&
        Objects.equals(this.series, seriesDashboardTile.series) &&
        Objects.equals(this.title, seriesDashboardTile.title) &&
        Objects.equals(this.type, seriesDashboardTile.type) &&
        Objects.equals(this.width, seriesDashboardTile.width) &&
        Objects.equals(this.x, seriesDashboardTile.x) &&
        Objects.equals(this.y, seriesDashboardTile.y);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, height, series, title, type, width, x, y);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SeriesDashboardTile {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    height: ").append(toIndentedString(height)).append("\n");
    sb.append("    series: ").append(toIndentedString(series)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    width: ").append(toIndentedString(width)).append("\n");
    sb.append("    x: ").append(toIndentedString(x)).append("\n");
    sb.append("    y: ").append(toIndentedString(y)).append("\n");
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


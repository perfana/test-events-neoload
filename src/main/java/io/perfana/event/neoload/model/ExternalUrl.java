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
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

/**
 * Link to an external system, for example the CI job&#39;s link.
 */

@Schema(name = "ExternalUrl", description = "Link to an external system, for example the CI job's link.")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-04-06T15:29:22.895694+02:00[Europe/Amsterdam]", comments = "Generator version: 7.4.0")
public class ExternalUrl {

  private String url;

  private String title;

  public ExternalUrl() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public ExternalUrl(String url) {
    this.url = url;
  }

  public ExternalUrl url(String url) {
    this.url = url;
    return this;
  }

  /**
   * Url of the link
   * @return url
  */
  @NotNull 
  @Schema(name = "url", example = "https://dev.azure.com/myorg/myproject/_build?definitionId=123", description = "Url of the link", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("url")
  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public ExternalUrl title(String title) {
    this.title = title;
    return this;
  }

  /**
   * Label of the link
   * @return title
  */
  
  @Schema(name = "title", example = "AzureDevOps#123", description = "Label of the link", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
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
    ExternalUrl externalUrl = (ExternalUrl) o;
    return Objects.equals(this.url, externalUrl.url) &&
        Objects.equals(this.title, externalUrl.title);
  }

  @Override
  public int hashCode() {
    return Objects.hash(url, title);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ExternalUrl {\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
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


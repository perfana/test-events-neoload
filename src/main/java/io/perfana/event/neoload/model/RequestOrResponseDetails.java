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

import java.util.Objects;

/**
 * Request or Response content of the error events
 */

@Schema(name = "RequestOrResponseDetails", description = "Request or Response content of the error events")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-04-06T15:29:22.895694+02:00[Europe/Amsterdam]", comments = "Generator version: 7.4.0")
public class RequestOrResponseDetails {

  private String contentId;

  private String headers;

  private String statusLine;

  public RequestOrResponseDetails contentId(String contentId) {
    this.contentId = contentId;
    return this;
  }

  /**
   * The identifier of the content, it could be use in the endpoint /{resultId}/events/contents/{contentId} to retrieve the content.
   * @return contentId
  */
  
  @Schema(name = "contentId", description = "The identifier of the content, it could be use in the endpoint /{resultId}/events/contents/{contentId} to retrieve the content.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("contentId")
  public String getContentId() {
    return contentId;
  }

  public void setContentId(String contentId) {
    this.contentId = contentId;
  }

  public RequestOrResponseDetails headers(String headers) {
    this.headers = headers;
    return this;
  }

  /**
   * The headers of the request or the headers of the response.
   * @return headers
  */
  
  @Schema(name = "headers", description = "The headers of the request or the headers of the response.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("headers")
  public String getHeaders() {
    return headers;
  }

  public void setHeaders(String headers) {
    this.headers = headers;
  }

  public RequestOrResponseDetails statusLine(String statusLine) {
    this.statusLine = statusLine;
    return this;
  }

  /**
   * The HTTP request method plus the URL for the request or the response code for the response.
   * @return statusLine
  */
  
  @Schema(name = "statusLine", description = "The HTTP request method plus the URL for the request or the response code for the response.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("statusLine")
  public String getStatusLine() {
    return statusLine;
  }

  public void setStatusLine(String statusLine) {
    this.statusLine = statusLine;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RequestOrResponseDetails requestOrResponseDetails = (RequestOrResponseDetails) o;
    return Objects.equals(this.contentId, requestOrResponseDetails.contentId) &&
        Objects.equals(this.headers, requestOrResponseDetails.headers) &&
        Objects.equals(this.statusLine, requestOrResponseDetails.statusLine);
  }

  @Override
  public int hashCode() {
    return Objects.hash(contentId, headers, statusLine);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RequestOrResponseDetails {\n");
    sb.append("    contentId: ").append(toIndentedString(contentId)).append("\n");
    sb.append("    headers: ").append(toIndentedString(headers)).append("\n");
    sb.append("    statusLine: ").append(toIndentedString(statusLine)).append("\n");
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


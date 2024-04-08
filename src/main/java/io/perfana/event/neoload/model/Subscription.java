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

import java.util.Objects;

/**
 * Subscription
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-04-06T15:29:22.895694+02:00[Europe/Amsterdam]", comments = "Generator version: 7.4.0")
public class Subscription {

  private CloudCredits cloudCredits;

  private SapVus sapVu;

  private Vuhs vuhs;

  private WebVus webVu;

  public Subscription cloudCredits(CloudCredits cloudCredits) {
    this.cloudCredits = cloudCredits;
    return this;
  }

  /**
   * Get cloudCredits
   * @return cloudCredits
  */
  @Valid 
  @Schema(name = "cloudCredits", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("cloudCredits")
  public CloudCredits getCloudCredits() {
    return cloudCredits;
  }

  public void setCloudCredits(CloudCredits cloudCredits) {
    this.cloudCredits = cloudCredits;
  }

  public Subscription sapVu(SapVus sapVu) {
    this.sapVu = sapVu;
    return this;
  }

  /**
   * Get sapVu
   * @return sapVu
  */
  @Valid 
  @Schema(name = "sapVu", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("sapVu")
  public SapVus getSapVu() {
    return sapVu;
  }

  public void setSapVu(SapVus sapVu) {
    this.sapVu = sapVu;
  }

  public Subscription vuhs(Vuhs vuhs) {
    this.vuhs = vuhs;
    return this;
  }

  /**
   * Get vuhs
   * @return vuhs
  */
  @Valid 
  @Schema(name = "vuhs", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("vuhs")
  public Vuhs getVuhs() {
    return vuhs;
  }

  public void setVuhs(Vuhs vuhs) {
    this.vuhs = vuhs;
  }

  public Subscription webVu(WebVus webVu) {
    this.webVu = webVu;
    return this;
  }

  /**
   * Get webVu
   * @return webVu
  */
  @Valid 
  @Schema(name = "webVu", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("webVu")
  public WebVus getWebVu() {
    return webVu;
  }

  public void setWebVu(WebVus webVu) {
    this.webVu = webVu;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Subscription subscription = (Subscription) o;
    return Objects.equals(this.cloudCredits, subscription.cloudCredits) &&
        Objects.equals(this.sapVu, subscription.sapVu) &&
        Objects.equals(this.vuhs, subscription.vuhs) &&
        Objects.equals(this.webVu, subscription.webVu);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cloudCredits, sapVu, vuhs, webVu);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Subscription {\n");
    sb.append("    cloudCredits: ").append(toIndentedString(cloudCredits)).append("\n");
    sb.append("    sapVu: ").append(toIndentedString(sapVu)).append("\n");
    sb.append("    vuhs: ").append(toIndentedString(vuhs)).append("\n");
    sb.append("    webVu: ").append(toIndentedString(webVu)).append("\n");
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


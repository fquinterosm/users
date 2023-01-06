package com.bci.users.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.validation.Valid;
import org.springframework.validation.annotation.Validated;

/**
 * ApiCustomValidationsResponse
 */
@Validated




public class ApiCustomValidationsResponse   {
  @JsonProperty("customValidations")
  @Valid
  private List<ApiCustomValidation> customValidations = null;

  public ApiCustomValidationsResponse customValidations(List<ApiCustomValidation> customValidations) {
    this.customValidations = customValidations;
    return this;
  }

  public ApiCustomValidationsResponse addCustomValidationsItem(ApiCustomValidation customValidationsItem) {
    if (this.customValidations == null) {
      this.customValidations = new ArrayList<ApiCustomValidation>();
    }
    this.customValidations.add(customValidationsItem);
    return this;
  }

  /**
   * Get customValidations
   * @return customValidations
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<ApiCustomValidation> getCustomValidations() {
    return customValidations;
  }

  public void setCustomValidations(List<ApiCustomValidation> customValidations) {
    this.customValidations = customValidations;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ApiCustomValidationsResponse apiCustomValidationsResponse = (ApiCustomValidationsResponse) o;
    return Objects.equals(this.customValidations, apiCustomValidationsResponse.customValidations);
  }

  @Override
  public int hashCode() {
    return Objects.hash(customValidations);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApiCustomValidationsResponse {\n");
    
    sb.append("    customValidations: ").append(toIndentedString(customValidations)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}


package com.bci.users.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;
import javax.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

/**
 * ApiPhones
 */
@Validated




public class ApiPhones   {
  @JsonProperty("number")
  private String number = null;

  @JsonProperty("citycode")
  private String citycode = null;

  @JsonProperty("contrycode")
  private String contrycode = null;

  public ApiPhones number(String number) {
    this.number = number;
    return this;
  }

  /**
   * Get number
   * @return number
  **/
  @ApiModelProperty(example = "1234567", required = true, value = "")
  @NotNull


  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public ApiPhones citycode(String citycode) {
    this.citycode = citycode;
    return this;
  }

  /**
   * Get citycode
   * @return citycode
  **/
  @ApiModelProperty(example = "1", required = true, value = "")
  @NotNull


  public String getCitycode() {
    return citycode;
  }

  public void setCitycode(String citycode) {
    this.citycode = citycode;
  }

  public ApiPhones contrycode(String contrycode) {
    this.contrycode = contrycode;
    return this;
  }

  /**
   * Get contrycode
   * @return contrycode
  **/
  @ApiModelProperty(example = "57", required = true, value = "")
  @NotNull


  public String getContrycode() {
    return contrycode;
  }

  public void setContrycode(String contrycode) {
    this.contrycode = contrycode;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ApiPhones apiPhones = (ApiPhones) o;
    return Objects.equals(this.number, apiPhones.number) &&
        Objects.equals(this.citycode, apiPhones.citycode) &&
        Objects.equals(this.contrycode, apiPhones.contrycode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(number, citycode, contrycode);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApiPhones {\n");
    
    sb.append("    number: ").append(toIndentedString(number)).append("\n");
    sb.append("    citycode: ").append(toIndentedString(citycode)).append("\n");
    sb.append("    contrycode: ").append(toIndentedString(contrycode)).append("\n");
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


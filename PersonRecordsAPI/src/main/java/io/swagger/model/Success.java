/*
 * Patient Records API
 * Patient Api to Search, Update and Delete patient record.
 *
 * OpenAPI spec version: 1.0.0
 * Contact: amogh.kulkarni@cerner.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package io.swagger.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * Success
 */

public class Success {
	@JsonProperty("success")
	private Boolean success = null;

	public Success success(Boolean success) {
		this.success = success;
		return this;
	}

	/**
	 * Get success
	 * 
	 * @return success
	 **/
	@JsonProperty("success")
	@ApiModelProperty(value = "")
	public Boolean isSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Success success = (Success) o;
		return Objects.equals(this.success, success.success);
	}

	@Override
	public int hashCode() {
		return Objects.hash(success);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Success {\n");

		sb.append("    success: ").append(toIndentedString(success)).append("\n");
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
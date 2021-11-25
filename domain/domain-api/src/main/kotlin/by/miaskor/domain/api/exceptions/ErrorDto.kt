package by.miaskor.domain.api.exceptions

import com.fasterxml.jackson.annotation.JsonProperty

data class ErrorDto(
  val error: String,
  @JsonProperty("error_property")
  val errorDescription: String
)

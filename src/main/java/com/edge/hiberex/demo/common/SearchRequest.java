package com.edge.hiberex.demo.common;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchRequest<T> {
    @Valid
    @NotNull(message = "Search criteria must not be null")
    private T searchCriteria;
    private Pagination pagination;
}

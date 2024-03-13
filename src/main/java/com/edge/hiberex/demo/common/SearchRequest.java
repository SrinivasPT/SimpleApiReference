package com.edge.hiberex.demo.common;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchRequest<T> {
    @Valid
    private T searchCriteria;
    private Pagination pagination;
}

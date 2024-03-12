package com.edge.hiberex.demo.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchRequest<T> {

    private T searchCriteria;
    private Pagination pagination;
}

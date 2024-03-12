package com.edge.hiberex.demo.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pagination {
    private Integer page;
    private Integer size;
    private String sortBy;
    private String sortDir;
}

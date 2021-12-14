package com.koreait.ex14.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data    // @Getter, @Setter, @ToString
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Department {
	private int departmentId;
	private String departmentName;
	private int managerId;
	private int locationId;
}

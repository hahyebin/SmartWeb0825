package com.koreait.ex15.domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class BoardAttach {
	 private Long uuid;
	 private String path;
	 private String origin;
	 private String fileType;
	 private Long boardNo;
 
}

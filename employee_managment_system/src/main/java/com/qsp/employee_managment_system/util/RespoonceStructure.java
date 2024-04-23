package com.qsp.employee_managment_system.util;

import lombok.Data;

@Data
public class RespoonceStructure<T> {
	private String message;
	private int status;
	private T data;
}

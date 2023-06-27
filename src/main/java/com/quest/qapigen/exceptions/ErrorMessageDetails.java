package com.quest.qapigen.exceptions;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/**
 *  Contains error message details
 * 
 * @author RanjanRo
 *
 */
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ErrorMessageDetails {

	private String timestamp;
	private int statusCode;
	private List<String> messages;
	private String details;
}

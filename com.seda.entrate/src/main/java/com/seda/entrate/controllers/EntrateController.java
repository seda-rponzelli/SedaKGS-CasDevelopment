/**
 * 
 */
package com.seda.entrate.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author lmontesi
 *
 */
@Controller
public class EntrateController {

	@RequestMapping(value="/menu", method=RequestMethod.GET) 
	public String editAccount() {

		return "entrate";
	}
}

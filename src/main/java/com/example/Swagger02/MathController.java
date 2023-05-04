package com.example.Swagger02;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "MathController",description = "This is the controller to get some arithmetic operations' description")
public class MathController {
	@GetMapping
	@Operation(summary = "Welcome", description = "Welcomes the visitors")
	public String welcomeMathMsg() {
		return "Welcome to ArithmeticOperations!";
	}
	
	@GetMapping("/division-info")
	@Operation(summary = "Division", description = "Returns infos on the division operation")
	public ArithmeticOperations divisionInfo() {
		return new ArithmeticOperations("Division", 2, "Division is one of the four basic operations of arithmetic. The other operations are addition, subtraction, and multiplicationDivision is one of the four basic operations of arithmetic. The other operations are addition, subtraction, and multiplication", new String[]{"commutativity", "associativity", "identity element"});
	}
	
	@GetMapping("/multiplication")
	@Operation(summary = "Multiplication", description = "Returns the multiplication of 2 integers")
	public int multiplication(@RequestParam int n1, @RequestParam int n2) {
		return n1 * n2;
	}
	
	@GetMapping("/square/{n}")
	@Operation(summary = "Square", description = "Returns the square of n")
	public int square(@PathVariable int n) {
		return n * n;
	}
}

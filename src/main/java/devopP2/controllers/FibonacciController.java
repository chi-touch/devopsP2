package devopP2.controllers;

import devopP2.services.Fibonacci;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;

@RestController
public class FibonacciController {
    @GetMapping("/fibonacci/{n}")

    public BigInteger calculateFibonacci(@PathVariable int n) {
        return Fibonacci.calculateFibonacci(n);
    }
}

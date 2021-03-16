package org.quarkus.example.service;

import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;

import javax.enterprise.context.ApplicationScoped;
import java.util.Random;

@ApplicationScoped
public class FaultTolerantService {


    @Fallback(fallbackMethod = "fallbackMethod")
    public String fallBack() {
        boolean aBoolean = new Random().nextBoolean();
        if (aBoolean) {
            return "Returning response from normal method";
        } else {
            throw new RuntimeException("Calling Fallback");
        }
    }

    public String fallbackMethod() {
        return "Returning response from fallback method";
    }
@CircuitBreaker
    @Retry(maxRetries = 2, delay = 20L)
    public String retry() {
        boolean aBoolean = new Random().nextBoolean();
        if (aBoolean) {
            return "Returning response from normal method";
        } else {
            throw new RuntimeException("Exception caught");
        }
    }
}

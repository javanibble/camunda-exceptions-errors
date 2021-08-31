package com.javanibble.camunda.examples;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component("volatileService")
public class VolatileServiceDelegate implements JavaDelegate {

    private final Logger LOGGER = LoggerFactory.getLogger(VolatileServiceDelegate.class.getName());

    public void execute(DelegateExecution execution) throws Exception {
        String volatileProcess = (String) execution.getVariable("volatile");

        switch(volatileProcess) {
            case "yes":
                LOGGER.info("Process Volatile, exception occurred.");
                throw new RuntimeException();
            case "no":
                LOGGER.info("Process Volatile, no exception occurred.");
                break;
            default:
                LOGGER.info("Process Volatile, variable missing.");
        }

    }

}

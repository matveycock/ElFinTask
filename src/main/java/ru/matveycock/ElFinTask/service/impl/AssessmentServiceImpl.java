package ru.matveycock.ElFinTask.service.impl;

import org.camunda.bpm.dmn.engine.DmnDecision;
import org.camunda.bpm.dmn.engine.DmnDecisionRuleResult;
import org.camunda.bpm.dmn.engine.DmnDecisionTableResult;
import org.camunda.bpm.dmn.engine.DmnEngine;
import org.camunda.bpm.engine.variable.VariableMap;
import org.camunda.bpm.engine.variable.Variables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.matveycock.ElFinTask.model.Client;
import ru.matveycock.ElFinTask.model.Result;
import ru.matveycock.ElFinTask.service.AssessmentService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AssessmentServiceImpl implements AssessmentService {

    @Autowired
    private DmnEngine dmnEngine;
    @Autowired
    private DmnDecision decision;
    @Override
    public Result assessClient(Client client) {
        VariableMap variables = Variables.createVariables()
                .putValue("inn", client.getINN())
                .putValue("region", client.getRegion())
                .putValue("capital", client.getCapital());

        DmnDecisionTableResult decisionResult = dmnEngine.evaluateDecisionTable(decision, variables);

        List<String> details = new ArrayList<>();
        boolean successful = true;

        for (DmnDecisionRuleResult result : decisionResult) {
            String output = result.getSingleEntry();
            if (output != null) {
                details.add(output);
                successful = false;
            }
        }

        return new Result(successful, details);
    }
}

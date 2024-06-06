package ru.matveycock.ElFinTask.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import ru.matveycock.ElFinTask.model.Client;
import ru.matveycock.ElFinTask.model.Result;
import ru.matveycock.ElFinTask.service.AssessmentService;
import ru.matveycock.ElFinTask.service.ResultService;

@RestController
@RequestMapping("/api/assess")
public class AssessmentController {

    private final AssessmentService assessmentService;
    private final ResultService resultService;

    @Autowired
    public AssessmentController(AssessmentService assessmentService, ResultService resultService) {
        this.assessmentService = assessmentService;
        this.resultService = resultService;
    }

    @GetMapping
    public Result assessClient(@RequestBody Client client) {
        Result result = assessmentService.assessClient(client);
        resultService.save(result);
        return result;
    }

}

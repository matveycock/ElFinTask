package ru.matveycock.ElFinTask.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.matveycock.ElFinTask.model.Client;

@RestController
public class MainController {

    @PostMapping
    public void checkClient(@RequestBody Client client){

    }
}

package ru.matveycock.ElFinTask.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.matveycock.ElFinTask.model.Result;
import ru.matveycock.ElFinTask.repository.ResultRepository;


public interface ResultService {

    public void save(Result result);

    public Result findById(String id);

    public Result findAll();

}

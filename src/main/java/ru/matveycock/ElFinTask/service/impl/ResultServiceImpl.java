package ru.matveycock.ElFinTask.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.matveycock.ElFinTask.model.Result;
import ru.matveycock.ElFinTask.repository.ResultRepository;
import ru.matveycock.ElFinTask.service.ResultService;

@Service
public class ResultServiceImpl implements ResultService {

    private final ResultRepository repository;

    @Autowired
    public ResultServiceImpl(ResultRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(Result result) {
        //repository.save();
    }

    @Override
    public Result findById(String id) {
        //return repository.findById(id);
        return null;
    }

    @Override
    public Result findAll() {
        //return repository.findByAll();
        return null;
    }
}

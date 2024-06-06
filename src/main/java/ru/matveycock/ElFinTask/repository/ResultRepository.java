package ru.matveycock.ElFinTask.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import ru.matveycock.ElFinTask.model.Result;

public interface ResultRepository extends ElasticsearchRepository<Result, String> {
}

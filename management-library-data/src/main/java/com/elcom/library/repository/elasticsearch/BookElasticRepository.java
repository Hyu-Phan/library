package com.elcom.library.repository.elasticsearch;

import com.elcom.library.entity.lib.model.BookModel;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookElasticRepository extends ElasticsearchRepository<BookModel, String> {
}

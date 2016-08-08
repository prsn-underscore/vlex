package com.pearson.underscore.vlex.repository;

import com.pearson.underscore.vlex.domain.internal.WordAssociation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

public interface WordAssociationRepository extends MongoRepository<WordAssociation, String> {

	WordAssociation findByWord(String word);

}

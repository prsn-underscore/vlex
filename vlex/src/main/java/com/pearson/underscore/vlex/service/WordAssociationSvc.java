package com.pearson.underscore.vlex.service;

import com.pearson.underscore.vlex.domain.WordAssociationResponse;
import com.pearson.underscore.vlex.domain.internal.RankedTag;
import com.pearson.underscore.vlex.domain.internal.Tag;
import com.pearson.underscore.vlex.domain.internal.WordAssociation;
import com.pearson.underscore.vlex.repository.WordAssociationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class WordAssociationSvc {

	@Autowired
	WordAssociationRepository wordAssociationRepository;

	public WordAssociationResponse findAssociationsByWord(String word) {
		WordAssociation wordAssociation = wordAssociationRepository.findByWord(word);
		if (wordAssociation != null) {
			int wordOccurences = wordAssociation.getOccurences();
			WordAssociationResponse wordAssociationResponse = new WordAssociationResponse(word, wordAssociation.getTranslation(), wordOccurences);
			List<Tag> tags = wordAssociation.getRelatedTags();
			List<RankedTag> rankedTags = new ArrayList<RankedTag>();
			for (Tag tag: tags) {
				RankedTag rankedTag = new RankedTag(tag.getTag(), tag.getTranslation(), tag.getType());
				rankedTag.setRank(tag.getOccurences()/wordOccurences);
				rankedTags.add(rankedTag);
			}
			Collections.sort(rankedTags, new Comparator<RankedTag>() {
				@Override
				public int compare(RankedTag o1, RankedTag o2) {
					return Double.compare(o1.getRank(), o2.getRank());
				}
			});
			wordAssociationResponse.setRelatedTags(rankedTags);
			return wordAssociationResponse;
		} else {
			return null;
		}
	}

	public void updateWordAssociation(String word, String tag) {
		WordAssociation wordAssociation = wordAssociationRepository.findByWord(word);
		if (wordAssociation!=null) {
			wordAssociation.setOccurences(wordAssociation.getOccurences() + 1); //increment occurences
			List<Tag> tags = wordAssociation.getRelatedTags();
			boolean found = false;
			tagLoop:
			for (Tag currentTag : tags) {
				if(currentTag.getTag().equals(tag)) {
					currentTag.setOccurences(currentTag.getOccurences() + 1);
					found = true;
					break tagLoop;
				}
			}
			if(!found) {
				Tag relatedTag = new Tag();
				relatedTag.setType("verb");
				relatedTag.setTag(tag);
				//TODO: get translation
				relatedTag.setTranslation(null);
				relatedTag.setOccurences(1);
				wordAssociation.addRelatedTag(relatedTag);
			}
		} else {
			wordAssociation = new WordAssociation();
			wordAssociation.setWord(word);
			wordAssociation.setOccurences(1);
			//TODO: get translation
			wordAssociation.setTranslation(null);
			Tag relatedTag = new Tag();
			relatedTag.setType("verb");
			relatedTag.setTag(tag);
			//TODO: get translation
			relatedTag.setTranslation(null);
			relatedTag.setOccurences(1);
			wordAssociation.addRelatedTag(relatedTag);
		}
		wordAssociationRepository.save(wordAssociation);
	}

}

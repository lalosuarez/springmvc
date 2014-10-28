package org.lalosuarez.app.dao;

import java.util.List;
import java.util.Random;

import org.lalosuarez.app.dto.Linea;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class LineaMongoDaoImpl implements LineaDao {

	private MongoTemplate mongoTemplate;
	
	private static final String COLLECTION_NAME = "lineas";
	
	@Override
	public void save(Linea object) {
        
		if (!mongoTemplate.collectionExists(Linea.class)) {
            mongoTemplate.createCollection(Linea.class);
        }

        object.setId(randInt(0, 10000));
        //mongoTemplate.insert(object, COLLECTION_NAME);
        mongoTemplate.save(object, COLLECTION_NAME);
	}

	public int randInt(int min, int max) {

	    // NOTE: Usually this should be a field rather than a method
	    // variable so that it is not re-seeded every call.
	    Random rand = new Random();

	    // nextInt is normally exclusive of the top value,
	    // so add 1 to make it inclusive
	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Linea> findAll() {
		return mongoTemplate.findAll(Linea.class, COLLECTION_NAME);
	}

	@Override
	public Linea find(int id) {
		System.out.println("BUSCANDO " + id);
		Query query = new Query(Criteria.where("_id").is(id));
		
		Linea object = mongoTemplate.findOne(query, Linea.class);
		
		if (object != null) {
			System.out.println("FINDED " + object.getNombre());
		} else {
			System.out.println("NULL OBJECT");
		}
		return object;
	}

	public MongoTemplate getMongoTemplate() {
		return mongoTemplate;
	}

	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

}

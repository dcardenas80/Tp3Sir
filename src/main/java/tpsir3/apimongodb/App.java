package tpsir3.apimongodb;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.mongodb.MongoClient;

import redis.clients.jedis.Jedis;
import tpsir3.apimongodb.datamodel.Address;
import tpsir3.apimongodb.datamodel.Person;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
       App app = new App();
    	//app.mongoDBTest();	   
    	app.redisExemple1();
    	app.redisExemple2();
    	try {
			app.redisExemple3();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	app.redisExemple4();
	}

	public void mongoDBTest() {
		Morphia morphia = new Morphia();
		MongoClient mongo = new MongoClient();
		morphia.map(Person.class).map(Address.class);
		Datastore ds = morphia.createDatastore(mongo, "my_database");

		Person p = new Person();
		p.setName("Tintin");
		Address address = new Address();
		address.setStreet("123 Some street");
		address.setCity("Some city");
		address.setPostCode("123 456");
		address.setCountry("Some country");
		// set address
		p.setAdress(address);
		// Save the POJO
		ds.save(p);
		for (Person e : ds.find(Person.class))
			System.err.println(e);
	}
	public void redisExemple1() {
		Jedis jedis = new Jedis("localhost");
		jedis.set("foo", "bar");
		String value = jedis.get("foo");
		
		System.err.println(value);	
	}
	public void redisExemple2() {
		Jedis jedis = new Jedis("localhost");
		System.out.println(jedis.get("counter"));
		jedis.incr("counter");
		System.out.println(jedis.get("counter"));
	}
	public void redisExemple3() throws InterruptedException {
		String cacheKey = "cachekey";
		Jedis jedis = new Jedis("localhost");
		// adding a new key
		jedis.set(cacheKey, "cached value");
		// setting the TTL in seconds
		jedis.expire(cacheKey, 15);
		// Getting the remaining ttl
		System.out.println("TTL:" + jedis.ttl(cacheKey));
		Thread.sleep(1000);
		System.out.println("TTL:" + jedis.ttl(cacheKey));
		// Getting the cache value
		System.out.println("Cached Value:" + jedis.get(cacheKey));
		// Wait for the TTL finishs
		Thread.sleep(15000);
		// trying to get the expired key
		System.out.println("Expired Key:" + jedis.get(cacheKey));

	}
	public void redisExemple4() {
		String cacheKey = "languages";
		Jedis jedis = new Jedis("localhost");
		// Adding a set as value
		jedis.sadd(cacheKey, "Java");
		jedis.sadd(cacheKey, "C#");
		jedis.sadd(cacheKey, "Python");// SADD
		// Getting all values in the set: SMEMBERS
		System.out.println("Languages: " + jedis.smembers(cacheKey));
		// Adding new values
		jedis.sadd(cacheKey, "Java");
		jedis.sadd(cacheKey, "Ruby");
		// Getting the values... it doesn't allow duplicates
		System.out.println("Languages: " + jedis.smembers(cacheKey));
	}
}

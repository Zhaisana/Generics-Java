package eu.glowacki.utp.assignment01.sample;

import org.junit.*;

public class PersonTest {

	private static final int AGE = 20;

	private Person _person;


	@BeforeClass
	public static void beforeClass(){
		System.out.println("Hello");
	}


	@Before
	public void before() {
		_person = new Person(AGE);
		Assert.assertEquals(AGE, _person.age());
	}

	@Test
	public void aggregate() {
		int aggregate = _person.aggregate(null);
		Assert.assertEquals(AGE, aggregate);
		final int init = 20;
		Assert.assertEquals((int) (AGE + init), (int) (_person.aggregate(init)));
	}

	@Test
	public void deepClone() {
		Person clone = _person.deepClone();
		Assert.assertEquals(_person.age(), clone.age());
		Assert.assertNotSame(_person, clone);
	}
}
package com.auth;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
class CredencialTest {
	//Forma 2
	private static Credencial sut;
	
	@BeforeAll
	public static void setup() {
		sut=new Credencial("Daniel", "Gutierrez", "Password1");
	} 
	
	
	@Test
	void esPasswordSeguraTest() {
		this.sut.setPassword("Password1");
		assert(this.sut.esPasswordSegura());
	}
	 
	@Test
	void detectaPasswordNoSeguraTest() {
		this.sut.setPassword("Password"); 
		assertFalse(this.sut.esPasswordSegura());
		this.sut.setPassword("password2");
		assertFalse(this.sut.esPasswordSegura());
		assertFalse(this.sut.esPasswordSegura());
	}
	
	//Forma 1
	@Test
	void comprobarPasswordTest() {
		assert(new Credencial("Daniel", "Gutierrez", "password1").comprobarPassword("password1"));
	}
	
	@Test
	void comprobarPasswordNoIgualTest() {
		assertFalse(new Credencial("Daniel", "Gutierrez", "password1").comprobarPassword("password"));
	}
	
	
}

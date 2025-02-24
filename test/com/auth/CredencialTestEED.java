package com.auth;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import junit.framework.TestCase;

class CredencialTestEED extends TestCase{

	private static Credencial credencial1;
	private static Credencial credencial2;
	private static Credencial credencial3;

	@BeforeAll
	public static void setup() {
		credencial1 = new Credencial("Daniel", "Gutierrez", "Password1");
		credencial2 = new Credencial("Jose", "Guti", "Password");
		credencial3 = new Credencial("Jose", "Guti", "Passwor");
	}

	@Test
	public void testGenerarUsername() {
		assertTrue("dangut100".equals(credencial1.getUsername()));
		assertEquals("dangut100", credencial1.getUsername());
		assertNotEquals("", credencial1.getUsername());
	} 
	
	@Test
	public void testComprobarPassword() {
		assert(credencial1.comprobarPassword("Password1"));
	}
	
	@Test
	public void testEsPasswordSegura() {
		assert(credencial1.esPasswordSegura());
		assertFalse(credencial2.esPasswordSegura());
		assertFalse(credencial3.esPasswordSegura());
	}

}

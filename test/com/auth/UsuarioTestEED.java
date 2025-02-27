package com.auth;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


class UsuarioTestEED {
	 
	    private static Usuario usuario1;
	    private static Usuario usuario2;
	    private static Usuario usuario3;

	    @BeforeAll
	    public static void setUp() {
	        usuario1 = new Usuario("Daniel", "Gutierrez", "Password1");
	        usuario2 = new Usuario("Jose",  "Gutierrez", "Password1");
	        usuario3 = new Usuario("Jose", "Gutierrez", "Passwor");
	    }

	    @Test
	    void testCuentaBloqueada() {
	        usuario1.hacerLogin("DanGut100", "Password1");
	        usuario1.hacerLogin( "DanGut100", "Password1");
	        usuario1.hacerLogin( "DanGut100", "Password1");

	        assertTrue(usuario1.esCuentaBloqueada());
	    }

	    @Test
	    void testModificarPassword() {
	        assertTrue(usuario1.modificarPassword("Password1","NewPassword123", "NewPassword123"));
	        assertFalse(usuario2.modificarPassword("Password1", "NuevaPass123", "nueva"));
	        assertFalse(usuario3.modificarPassword("PasswordIncorrecta", "NuevaPass123", "Nueva"));
	    }

	    @Test
	    void testEsPasswordSegura() {
	        assertTrue(usuario1.esPasswordSegura());
	        assertTrue(usuario2.esPasswordSegura());
	        assertFalse(usuario3.esPasswordSegura());
	    }

	    @Test
	    void testHacerLogin() {
	        // Corrección del username
	        assertTrue(usuario2.hacerLogin("josgut101","Password1"));
	        assertFalse(usuario2.hacerLogin("Dani1602", "password"));
	    }

}

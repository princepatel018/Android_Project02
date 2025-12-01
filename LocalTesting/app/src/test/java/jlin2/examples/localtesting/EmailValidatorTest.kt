package jlin2.examples.localtesting

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class EmailValidatorTest {

    @Test
    fun email_CorrectSimple_ReturnsTrue() {
        assertTrue(EmailValidator.isValidEmail("123@abc.com"))
    }

    @Test
    fun email_CorrectSubdomain_ReturnsTrue() {
        assertTrue(EmailValidator.isValidEmail("123@abc.co.ca"))
    }

    @Test
    fun email_MissingDomainSuffix_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("123@abc"))
    }

    @Test
    fun email_DoubleDotInDomain_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("123@abc..com"))
    }

    @Test
    fun email_MissingUsername_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("@abc.com"))
    }

    @Test
    fun email_NoDomain_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("testing123"))
    }

    @Test
    fun email_EmptyString_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail(""))
    }

    @Test
    fun email_Null_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail(null))
    }
}
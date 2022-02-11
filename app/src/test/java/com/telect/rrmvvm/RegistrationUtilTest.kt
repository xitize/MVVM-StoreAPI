package com.telect.rrmvvm

import org.junit.Assert.*
import org.junit.Test

class RegistrationUtilTest {

    @Test
    fun `empty username return false`() {
        val result = RegistrationUtil.validateUser("", "3sfsfsf", "3sfsfsf")
        assertFalse(result)
    }

    @Test
    fun `username and correctly repeated password returns true`() {
        val result = RegistrationUtil.validateUser("Alka", "56", "56")
        assertTrue(result)
    }

    @Test
    fun `username already exist in the database`() {
        val result = RegistrationUtil.validateUser("Kshitiz", "67", "67")
        assertFalse(result)
    }


    @Test
    fun `password is less than 2 digit`() {
        val result = RegistrationUtil.validateUser("nonam", "1", "1")
        assertFalse(result)
    }

}
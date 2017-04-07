package com.wafer.moral

/**
 * The TestData class
 * Please put more info here.
 * @author wafer
 * @since 17/4/7 15:14
 */
object TestData {
    val userAuthData = listOf(UserAuthentication("2014211000", "1"), UserAuthentication("1111111111", "2"))

    val userMoralData = listOf(User("2014211000", 20), User("1111111111", isTeacher = true))
}
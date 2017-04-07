package com.wafer.moral

/**
 * The UserAuthentication class
 * Please put more info here.
 * @author wafer
 * @since 17/4/7 15:13
 */
data class UserAuthentication(val id: String, val password: String)

data class User(val id: String, val moral:Int = 0, val isTeacher: Boolean = false)

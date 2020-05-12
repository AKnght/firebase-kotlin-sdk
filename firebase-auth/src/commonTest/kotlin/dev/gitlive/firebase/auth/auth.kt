/*
 * Copyright (c) 2020 GitLive Ltd.  Use of this source code is governed by the Apache 2.0 license.
 */

package dev.gitlive.firebase.auth

import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.FirebaseOptions
import dev.gitlive.firebase.initialize
import kotlinx.coroutines.GlobalScope
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

expect val context: Any
expect fun runTest(test: suspend () -> Unit)

class FirebaseAuthTest {

    @BeforeTest
    fun initializeFirebase() {
        Firebase.initialize(
            context,
            FirebaseOptions(
                applicationId = "1:846484016111:ios:dd1f6688bad7af768c841a",
                apiKey = "AIzaSyCK87dcMFhzCz_kJVs2cT2AVlqOTLuyWV0",
                databaseUrl = "https://fir-kotlin-sdk.firebaseio.com",
                storageBucket = "fir-kotlin-sdk.appspot.com",
                projectId = "fir-kotlin-sdk"
            )
        )
    }

    @Test
    fun testSignInWithUsernameAndPassword() = runTest {
        val result = Firebase.auth.signInWithEmailAndPassword("test@test.com", "test123")
        assertEquals("mn8kgIFnxLO7il8GpTa5g0ObP6I2", result.user!!.uid)
    }
}
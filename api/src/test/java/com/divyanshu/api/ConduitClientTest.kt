package com.divyanshu.api

import com.divyanshu.api.models.entity.SignupData
import com.divyanshu.api.models.requests.SignupRequest
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test
import kotlin.random.Random

class ConduitClientTest {

  @Test
  fun `GET articles`() {
    runBlocking {
      val client = ConduitClient().publicAPI.getArticles()
      Assert.assertNotNull(client.body()?.articles)
    }
  }

  @Test
  fun `GET articles by author`() {
    runBlocking {
      val client = ConduitClient().publicAPI.getArticles(author = "Anah Benešová")
      Assert.assertNotNull(client.body()?.articles)
    }
  }

  @Test
  fun `GET articles by tags`() {
    runBlocking {
      val client = ConduitClient().publicAPI.getArticles(tag = "hic")
      Assert.assertNotNull(client.body()?.articles)
    }
  }


  @Test
  fun `signup request`() {
    val data =
      SignupData(
        email = "testEmail${Random.nextInt(999, 9999)}@test.com",
        password = "pass${Random.nextInt(9999, 999999)}",
        username = "test_user_${Random.nextInt(99, 999)}",
      )
    runBlocking {
      val client = ConduitClient().publicAPI.signupUser(signupRequest = SignupRequest(data))
      Assert.assertNotNull(client.body()?.user?.username)
    }
  }


}
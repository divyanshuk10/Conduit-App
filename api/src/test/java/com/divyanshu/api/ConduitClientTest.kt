package com.divyanshu.api

import org.junit.Assert
import org.junit.Test

class ConduitClientTest {

  @Test
  fun `GET articles()`() {
    val client = ConduitClient().api.getArticles().execute()

    Assert.assertNotNull(client.body()?.articles)
  }

}
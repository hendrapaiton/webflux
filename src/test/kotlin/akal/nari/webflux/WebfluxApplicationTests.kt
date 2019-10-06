package akal.nari.webflux

import akal.nari.webflux.data.mode
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import reactor.core.publisher.Mono
import java.security.MessageDigest
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import kotlin.experimental.and

@RunWith(SpringRunner::class)
@SpringBootTest
class WebfluxApplicationTests {

  @Test
  fun akalNari() {
    val key = "7bc074f97c3131d2e290a4707a54a623"
    val rq_datetime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
    val order_id = System.nanoTime()
    val mode = mode.PAYMENTREPORT
    val data = ("##" + key + "##" + rq_datetime + "##" + order_id + "##" + mode + "##").toUpperCase()
    val md = MessageDigest.getInstance("SHA-256")
    md.update(data.toByteArray())
    val byteData = md.digest()
    val sb = StringBuffer()
    for (i in byteData.indices) {
      sb.append(Integer.toString((byteData[i] and 0xff.toByte()) + 0x100, 16).substring(1))
    }
    println("Hex format : " + sb.toString())
  }

}

package akal.nari.webflux

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import reactor.core.publisher.Mono

@RunWith(SpringRunner::class)
@SpringBootTest
class WebfluxApplicationTests {

	@Test
	fun contextLoads() {
		val data = Mono.just("Spring Weblux")
				.log()
		data.subscribe(
				::println
		)
	}

}

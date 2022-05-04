package ru.romanow.merge.web

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.post
import java.util.stream.Stream

@SpringBootTest
@AutoConfigureMockMvc
internal class CalculationControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @MethodSource("factory")
    @ParameterizedTest(name = "''{0}'' -> ''{1}''")
    fun calculate_success(expr: String, result: Double) {
        mockMvc.post("/api/v1/eval") {
            accept(MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON)
            contentType = MediaType.TEXT_PLAIN
            content = expr
        }
            .andExpect {
                status { isOk() }
                content {
                    string(result.toString())
                    contentTypeCompatibleWith(MediaType.TEXT_PLAIN)
                }
            }
    }

    @ValueSource(strings = ["(2+2", "2+2)"])
    @ParameterizedTest
    fun calculate_error(expr: String) {
        mockMvc.post("/api/v1/eval") {
            accept(MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON)
            contentType = MediaType.TEXT_PLAIN
            content = expr
        }
            .andExpect {
                status { isBadRequest() }
                content { contentTypeCompatibleWith(MediaType.APPLICATION_JSON) }
            }
    }

    companion object {
        @JvmStatic
        fun factory() = Stream.of(
            Arguments.of("2+2", 4.0),
            Arguments.of("3 * 3", 9.0),
            Arguments.of("3^3*3+3/3", 82.0),
            Arguments.of("22 + 22", 44.0),
            Arguments.of("(3+3)*(3-3^1)", 0),
            Arguments.of("3-(3 + 3)*3", -15.0),
            Arguments.of("(3-(3 + 3)*3)", -15.0),
        )
    }
}
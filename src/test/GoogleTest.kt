package test
import com.codeborne.selenide.Selectors
import com.codeborne.selenide.Selectors.byText
import com.codeborne.selenide.Selectors.byValue
import com.codeborne.selenide.Selenide
import com.codeborne.selenide.Selenide.element
import com.codeborne.selenide.Selenide.elements
import com.codeborne.selenide.WebDriverRunner
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test


class GoogleTest {

    @Test
    @DisplayName("Проверка соответствия урла")
    fun checkUrl() {
        Selenide.open("/")
        assertThat(WebDriverRunner.currentFrameUrl()).isEqualTo("https://www.google.com/")
    }

    @Test
    @DisplayName("Поиск по selenide")
    fun checkSearch() {
        Selenide.open("/")
        element(Selectors.by("aria-label", "Search")).value = "selenide"
        element(byValue("Google Search")).click()
        elements(".g").forEach { assertThat(it.text.toLowerCase()).contains("selenide") }
    }
}
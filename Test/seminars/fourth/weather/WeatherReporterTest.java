package seminars.fourth.weather;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class WeatherReporterTest {

    @Test
    void weatherReporterGenerateReportTest() {
        WeatherService weatherService = mock(WeatherService.class);
        WeatherReporter weatherReporter = new WeatherReporter(weatherService);
        when(weatherService.getCurrentTemperature()).thenReturn(10);

        String temp = weatherReporter.generateReport();

        assertThat(temp).isEqualTo("Текущая температура: " + 10 + " градусов.");
        verify(weatherService, times(2)).getCurrentTemperature();

    }



}
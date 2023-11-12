package seminars.fourth.database;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class DataProcessorTest {

    @Test
    void DataProcessorTest() {
        Database database = mock(Database.class);
        DataProcessor dataProcessor = new DataProcessor(database);
        List<String> fakeData = new ArrayList<>();
        fakeData.add("Data1");
        fakeData.add("Data2");
        fakeData.add("Data3");
        when(database.query("SELECT * FROM data")).thenReturn(fakeData);

        dataProcessor.processData("SELECT * FROM data");

        verify(database).query("SELECT * FROM data");
        assertThat(dataProcessor.processData("SELECT * FROM data")).isEqualTo(fakeData);



    }
}
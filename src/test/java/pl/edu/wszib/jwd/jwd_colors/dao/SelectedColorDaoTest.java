package pl.edu.wszib.jwd.jwd_colors.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.wszib.jwd.jwd_colors.model.SelectedColor;

import java.util.Collection;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class SelectedColorDaoTest {


    public static final String COLOR_BLUE = "blue";
    public static final String COLOR_RED = "red";
    public static final int TOTAL_COLORS = 3;

    @Autowired
    SelectedColorDao selectedColorDao;

    @BeforeEach
    void setUp() {
        SelectedColor selectedColor1 = new SelectedColor(COLOR_BLUE, new Date());
        SelectedColor selectedColor2 = new SelectedColor(COLOR_BLUE, new Date());
        SelectedColor selectedColor3 = new SelectedColor(COLOR_RED, new Date());

        //SPRAWDZA CZY DANA METODA ZWRACA NULL, JAK NIE TO BŁĄD
        assertNull(selectedColor1.getId());
        assertNull(selectedColor2.getId());
        assertNull(selectedColor3.getId());

        selectedColorDao.save(selectedColor1);
        selectedColorDao.save(selectedColor2);
        selectedColorDao.save(selectedColor3);

        //SPRAWDZA CZY DANA METODA ZWRACA NIE NULL - ANALOGICZNIE JAK WYŻEJ
        assertNotNull(selectedColor1.getId());
        assertNotNull(selectedColor2.getId());
        assertNotNull(selectedColor3.getId());

    }

    @Test
    void testFetchData() {
        SelectedColor selectedColor = selectedColorDao.findFirstByColor(COLOR_RED);
        assertEquals(COLOR_RED, selectedColor.getColor(), "ZNALEZIONO NIEPOPRAWNY KOLOR");
}

    @Test
    void testFetchAllData() {
        Collection selectedColors = (Collection) selectedColorDao.findAll();
        assertEquals(TOTAL_COLORS, selectedColors.size(), "NIEPRAWIDŁOWA LICZBA KOLORÓW");
    }


}

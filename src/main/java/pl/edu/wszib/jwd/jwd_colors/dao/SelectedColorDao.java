package pl.edu.wszib.jwd.jwd_colors.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.jwd.jwd_colors.model.SelectedColor;

@Repository
public interface SelectedColorDao extends CrudRepository<SelectedColor, Integer> {

    SelectedColor findFirstByColor(String color);

}

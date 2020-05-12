package mapper;

import entity.Cat;

import java.util.List;

public interface CatMapper {
    int insert(Cat cat);
    List<Cat> selectAll();
}

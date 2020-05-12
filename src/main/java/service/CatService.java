package service;

import entity.Cat;

import java.util.List;

public interface CatService {
    int insert(Cat cat);
    List<Cat> selectAll();
}

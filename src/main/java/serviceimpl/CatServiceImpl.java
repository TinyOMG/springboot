package serviceimpl;

import entity.Cat;
import mapper.CatMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.CatService;

import java.util.List;

@Service
public class CatServiceImpl implements CatService {
    @Autowired
    CatMapper cm;

    @Override
    public int insert(Cat cat) {
        return cm.insert(cat);
    }

    @Override
    public List<Cat> selectAll() {
        return cm.selectAll();
    }
}

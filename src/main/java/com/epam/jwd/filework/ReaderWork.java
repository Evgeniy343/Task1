package com.epam.jwd.filework;

import com.epam.jwd.entity.CubeEntity;
import java.util.List;

public interface ReaderWork {
    static ReaderWork newInstance(){
        return new ReaderFileWork();
    }

    List<CubeEntity> execute(String path) throws Exception;
}

package com.epam.jwd.entity.observable;

import com.epam.jwd.registrar.CubeRegistrar;

public interface CubeObservable {
    CubeRegistrar addRegistrar(CubeRegistrar registrar);
    CubeRegistrar removeRegistrar(CubeRegistrar registrar);
    void notifyRegistrar();
}

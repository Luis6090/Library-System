package models.dao;

import java.util.List;

public interface InterfaceDAO <TypeID, Type>{
    void insert(Type object);
    void update(TypeID id, Type object);
    void delete(TypeID id);
    Type findByID(TypeID id);
    List<Type> findAll();
}

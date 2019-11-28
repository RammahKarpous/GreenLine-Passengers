package database.active_record;

public interface ActiveRecord
{
    void insert() throws Exception;
    void update() throws Exception;
    void delete() throws Exception;
}


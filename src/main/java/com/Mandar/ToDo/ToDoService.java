package com.Mandar.ToDo;




import org.springframework.stereotype.*;
import java.util.*;

@Service
public class ToDoService
{
    private ToDoDAO dao;

    public ToDoService(ToDoDAO dao)
    {
        this.dao = dao;
    }

    public String save(Task t)
    {
        String msg = "";

        try
        {
            dao.save(t);
            msg = "task created";
        }
        catch(Exception e)
        {
            msg = "create issue " + e;
        }

        return msg;
    }

    public List<Task> findAll()
    {
        return dao.findAll();
    }

    public String deleteById(int id)
    {
        String msg = "";

        try
        {
            int n = dao.deleteById(id);

            if (n > 0)
                msg = "task deleted";
            else
                msg = "task not found";
        }
        catch(Exception e)
        {
            msg = "delete issue " + e;
        }

        return msg;
    }
}

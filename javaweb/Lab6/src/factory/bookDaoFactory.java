package factory;

import daoInt.ImplBookDao;
import implement.bookDaoImpl;

// 返回Dao实现接口
public class bookDaoFactory {
    public static ImplBookDao getInterfaceFactory(){
       return new bookDaoImpl();
    }
}

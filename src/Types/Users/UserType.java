package Types.Users;

import Comparator.Comparator;

import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Интерфейс для создания объектов,
 * пользавательских типов данных.
 * @see UserType#typeName() Получение имя типа
 * @see UserType#create() Создание объекта
 * @see UserType#clone(Object) Клонирование текущего объекта
 * @see UserType#readValue(InputStreamReader) Чтение объекта
 * @see UserType#parseValue(String) Парсинг содержимого из стоки
 * @see UserType#getTypeComparator() Получение экземпляра компаратора
 */
public interface UserType{
    public String typeName();
    public Object create();
    public Object clone(Object object);
    public Object readValue(InputStreamReader in) throws IOException;
    public Object parseValue(String ss);
    public Comparator getTypeComparator();
}


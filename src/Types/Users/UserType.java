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
    public String typeName();			// Имя типа
    public Object create();				// Создает объект ИЛИ
    public Object clone(Object object);				// Клонирует текущий
    public Object readValue(InputStreamReader in) throws IOException; // Создает и читает объект
    public Object parseValue(String ss);		// Создает и парсит содержимое из строки
    public Comparator getTypeComparator();	// Возвращает компаратор для сравнения
}


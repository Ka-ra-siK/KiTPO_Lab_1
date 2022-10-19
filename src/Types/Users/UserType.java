package Types.Users;

import Comparator.Comparator;

import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 */
public interface UserType{
    public String typeName();			// Имя типа
    public Object create();				// Создает объект ИЛИ
    public Object clone(Object object);				// Клонирует текущий
    public Object readValue(InputStreamReader in) throws IOException; // Создает и читает объект
    public Object parseValue(String ss);		// Создает и парсит содержимое из строки
    public Comparator getTypeComparator();	// Возвращает компаратор для сравнения
}


package Comparator;

import Types.PointType;

import java.io.Serializable;

/**
 * Сравнение объектов типа 2D-точка
 */
public class PointComparator implements Comparator, Serializable {
    /**
     * Разница межды объектами вычисляется
     * с помощью разности, между длиннами векторов
     * от заданной точки до цетра координатной оси.
     * Вычисляется по формуле: sqrt(x^2+y^2).
     * @param o1 первая точка
     * @param o2 вторая точка
     * @return разницу между точками
     */
    @Override
    public float compare(Object o1, Object o2) {
        float firstX = ((PointType) o1).getX();
        float secondX = ((PointType) o2).getX();
        float firstY = ((PointType) o1).getY();
        float secondY = ((PointType) o2).getY();
        return getVectorLength(firstX, firstY) - getVectorLength(secondX, secondY);
    }

    /**
     * @param x Точка Х
     * @param y Точка Y
     * @return Длина вектора от точки (x;y) до координатоной оси
     */
    public float getVectorLength(float x, float y){
        return (float) Math.sqrt(Math.pow(x,2)+Math.pow(y,2));
    }
}

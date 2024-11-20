import java.util.ArrayList;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;

public class GenericMethods<T, P>
{
    public ArrayList<P> applyToList(ArrayList<T> list, Function<T, P> func)
    {
        ArrayList<P> res_list = new ArrayList<>();
        for (T l: list)
        {
            res_list.add(func.apply(l));
        }
        return res_list;
    }
    public ArrayList<T> testToList(ArrayList<T> list, Predicate<T> pred)
    {
        ArrayList<T> res_list = new ArrayList<>();
        for (T l: list)
        {
            if (pred.test(l))
                res_list.add(l);
        }
        return res_list;
    }
    public T reduceList(ArrayList<T> list, BinaryOperator<T> fold)
    {
        if (list == null || list.isEmpty()) 
        {
            return (T)"";
        }
        T res = list.get(0);
        for (int i = 1; i < list.size(); i++) 
        {
            res = fold.apply(res, list.get(i));
        }
        return res;
    }

    public ArrayList<Integer> addListSize(ArrayList<Integer> a1, ArrayList<Integer> a2)
    {
        a1.add(a2.size());
        return a1;
    }
}
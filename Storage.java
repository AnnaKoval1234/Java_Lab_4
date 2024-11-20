public class Storage<T>
{
    final T content;
    final T alter;

    public T getContent()
    {
        if (content == null)
            return alter;
        return content;
    }
    public T getAlter()
    {
        return alter;
    }

    public Storage(T content, T alter) 
    { 
        this.content = content;
        this.alter = alter;
    }
    
    @Override
    public String toString()
    {
        return "В хранилище находится " + content;
    }
}
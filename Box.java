public class Box<T>
{
    private T content;

    public T getContent()
    {
        T temp = content;
        content = null;
        return temp;
    }
    public void setContent(T content) throws Exception
    {
        if (this.content != null)
            throw new Exception("Коробка не пуста!");
        this.content = content;
    }

    public Box() { }
    public Box(T content) 
    { 
        this.content = content;
    }

    public boolean isEmpty() 
    {
        return content == null;    
    }
    
    @Override
    public String toString()
    {
        return "В коробке находится " + content;
    }
}
public class Point3D extends Point
{
    protected int Z;

    public int getZ()
    {
        return Z;
    }
    public void setZ(int z)
    {
        Z = z;
    }

    public Point3D(int X, int Y, int Z)
    {
        super(X, Y);
        this.Z = Z;
    }

    @Override
    public String toString()
    {
        return "{" + X + "; " + Y + "; " + Z + "}";
    }
}
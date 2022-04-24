class sample 
{
    public static void main(String... args)
    {
        try{
            int i = System.in.read();
        System.out.println((char)i);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
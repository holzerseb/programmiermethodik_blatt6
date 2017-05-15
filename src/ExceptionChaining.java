public class ExceptionChaining {
  private static class Ex1 extends Exception {}
  private static class Ex2 extends Ex1 {}
  private static class Ex3 extends Ex1 {}
  private static class Ex4 extends Ex2 {}
  private static class Ex5 extends Ex3 {}
  private static class Ex6 extends Ex2 {}

  public static void throwSomething(int number) throws Ex1, Ex2, Ex3, Ex4, Ex5, Ex6 {
    switch (number) {
      case 1: throw new Ex1();
      case 2: throw new Ex2();
      case 3: throw new Ex3();
      case 4: throw new Ex4();
      case 5: throw new Ex5();
      case 6: throw new Ex6();
      default: throw new IllegalArgumentException();
    }
  }

  public static void main(String[] args) {
    for (int i = 0; i < 7; i++) {
      try
      {
        try
        {
          throwSomething(i);
        }
        catch (Ex6 ex)
        {
          throw new IllegalStateException("FATAL ERROR!");
        }
        catch (Ex5 ex)
        {
          throw new Exception("Ex2 or Ex5");
        }
        catch (Ex4 ex)
        {
          throw new Exception("Ex1 or Ex4");
        }
        catch (Ex3 ex)
        {
          //i am an useless comment
        }
        catch (Ex2 ex)
        {
          throw new Exception("Ex2 or Ex5");
        }
        catch (Ex1 ex)
        {
          throw new Exception("Ex1 or Ex4");
        }
        catch (Exception ex)
        {
          Exception otherException = new Exception("Some other exception: " + ex.getMessage());
          otherException.setStackTrace(ex.getStackTrace()); //you usually want this information
          throw otherException;
        }
      }
      catch (Exception ex)
      {
        System.out.println(ex.getMessage());
      }
    }
  }
}


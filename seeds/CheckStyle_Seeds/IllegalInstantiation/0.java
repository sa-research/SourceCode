public class MyTest {
  public class Boolean {
    boolean a;

    public Boolean(boolean a) {
      this.a = a;
    }
  }

  public void myTest(boolean a, int b) {
    Boolean c = new Boolean(a); // OK
    java.lang.Boolean d = new java.lang.Boolean(a); // OK

    Integer e = new Integer(b); // OK
    Integer f = Integer.valueOf(b); // OK
  }
}


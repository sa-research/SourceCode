class Test1 {

  /** {@inheritDoc} */
  public void equals() { // violation, should be annotated with @Override
  }
}

interface Test2 {

  /** {@inheritDoc} */
  void test(); // violation, should be annotated with @Override
}

class Test3 extends SuperClass {

  /** {@inheritDoc} */
  public void test() { // OK, is ignored because class extends other class
  }
}

class Test4 implements SuperInterface {

  /** {@inheritDoc} */
  public void test() { // OK, is ignored because class implements interface
  }
}

class Test5 {
  Runnable r =
      new Runnable() {

        /** {@inheritDoc} */
        public void run() { // OK, is ignored because class is anonymous class
        }
      };
}


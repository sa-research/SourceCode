class Foo {

  @SuppressWarnings("deprecation") // violation, annotation should be on the same line
  public Foo() {}

  @SuppressWarnings("unchecked")
  public void fun2() { // OK
  }
}

@SuppressWarnings("unchecked")
class Bar extends Foo { // OK

  @Deprecated
  public Bar() { // OK
  }

  @Override // violation, annotation should be on the same line
  public void fun1() {}

  @Before
  @Override
  public void fun2() { // OK
  }

  @SuppressWarnings("deprecation") // violation, annotation should be on the same line
  @Before
  public void fun3() {}
}


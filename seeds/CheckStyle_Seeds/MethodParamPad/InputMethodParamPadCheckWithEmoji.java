/*
MethodParamPad
allowLineBreaks = true
option = (default)nospace
tokens = (default)CTOR_DEF, LITERAL_NEW, METHOD_CALL, METHOD_DEF, SUPER_CTOR_CALL, \
         ENUM_CONSTANT_DEF, RECORD_DEF


*/

package com.puppycrawl.tools.checkstyle.checks.whitespace.methodparampad;

import java.util.Arrays;

public class InputMethodParamPadCheckWithEmoji {

  class MyTestRecord {
    private boolean equal(Object obj) { // violation ''(' is preceded with whitespace.'
      String value = "ððda";
      if (value.equals("ðd")) { // violation ''(' is preceded with whitespace.'
        return true;
      }
      return value.equals(
          "ð" + // violation ''(' is preceded with whitespace.'
              "d");
    }
  }

  public void test() {
    java.lang.Integer.parseInt("ð ð¤ð» "); // violation ''(' is preceded with whitespace.'
    java.lang.Integer.parseInt("0 ð¤ð» asd asd");

    java.util.Vector<String> v =
        new java.util.Vector<String>(
            // violation above ''(' is preceded with whitespace.'
            Arrays.asList("aðsðd")); // violation ''(' is preceded with whitespace.'
  }

  public void test2() { // violation ''(' is preceded with whitespace.'
    Comparable<String> c =
        new String("ðdðð»ðð»ð"); // violation ''(' is preceded with whitespace.'
  }

  public void test3() { // violation ''(' is preceded with whitespace.'
    /* ð¤ð»OK ððð»*/ if ("ð¤ð»ð" == "ðð»ðð»") {}
  }

  void /* ð§ð§dsdsð§ð§ð§dsdsð§ð§ð§dsdsð§ { */ method4() {}
}


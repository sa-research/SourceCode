/*
SeparatorWrap
option = NL
tokens = DOT, COMMA,ELLIPSIS, ARRAY_DECLARATOR, METHOD_REF

*/

package com.puppycrawl.tools.checkstyle.checks.whitespace.separatorwrap;

import java.util.Arrays;

public class InputSeparatorWrapWithEmoji {
  protected String[] s1 =
      new String[/*π with text */ ] {
        "aabπ", "aπaπba"
      }; // violation above ''\[' should be on a new line'

  /* emojiπarray */ protected String[] s2 =
      new String[] {"π₯³", "π ", "π¨"}; // violation above''\[' should be on a new line'

  /*ππ» ππ»*/ public void test1(
      String... parameters) { // violation above ''...' should be on a new line'
  }

  public void test2(String/* ππ»ππ» */ ... parameters) { // ok
    String s = "ffffooooString";
    /* π§π₯³ */ s.isEmpty(); // violation above ''.' should be on a new line'
    try {
      test2("2", s);
    } catch (Exception e) {
    }

    test1("1"/*π§ sda π₯³ */ , s); // ok
  }

  void goodCase() {
    String[] stringArray = {
      "π", "ππ", "QWERTY", "π§π»", "John",
      /*π€π»*/ }; // violation above '',' should be on a new line'
    /*π€π» π€π»*/ Arrays.sort(
        stringArray, String::compareToIgnoreCase); // violation above ''::' should be on a new line'
  }
}


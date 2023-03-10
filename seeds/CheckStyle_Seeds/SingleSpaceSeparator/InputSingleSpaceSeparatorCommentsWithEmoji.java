/*
SingleSpaceSeparator
validateComments = true


*/

package com.puppycrawl.tools.checkstyle.checks.whitespace.singlespaceseparator;

public class InputSingleSpaceSeparatorCommentsWithEmoji {

  String s1 = "ð§ð           assa  "; // ok
  String s2 = "ð§ð" + "          " + "assa  "; // ok
  String s3 = "ð§" + "ð "; // ok
  String s4 = "dað"; // ok

  private void foo(String s) {
    if (s.equals("ð¤©ð")) { // ok
      foo(s);
    }
  }

  /* ok */
  /*ð§*/ String s = "ðð";
  String /* ð§  ok  */ st = "ð  assa"; // 2 violations
  String str = "ð¤©ð"; // violation 'Use a single space to separate non-whitespace characters'
  ;
  String j = ""; // violation 'Use a single space to separate non-whitespace characters'
  /** ok */
  void foo2() {
    /*ð§ ð§ ð§ ð§*/
    /* ok */
    String s = "ð§  ð§";
  } // violation 'Use a single space to separate non-whitespace characters'

  private void foo3(String s) { // ok
    // violation above 'Use a single space to separate non-whitespace characters'
    if (s.substring(0).equals("dað")) { // ok
      // violation above 'Use a single space to separate non-whitespace characters'
      /*ð§ ð§ ð§*/
      /* comment */ if ("ð§".isEmpty()) { // ok
        //  violation above 'Use a single space to separate non-whitespace characters'
      }
    }
  }
}


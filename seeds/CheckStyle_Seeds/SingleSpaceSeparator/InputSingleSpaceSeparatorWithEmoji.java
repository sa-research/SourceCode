/*
SingleSpaceSeparator
validateComments = (default)false


*/

package com.puppycrawl.tools.checkstyle.checks.whitespace.singlespaceseparator;

public class InputSingleSpaceSeparatorWithEmoji {

  String s1 = "ð§ð           assa  "; // ok
  String s2 = "ð§ð" + "          " + "assa  "; // ok
  String s3 = "ð§" + "ð "; // violation 'Use a single space to separate non-whitespace characters'
  String s4 = "dað"; // violation 'Use a single space to separate non-whitespace characters'

  private void foo(String s) {
    if (s.equals("ð¤©ð")) { // violation 'Use a single space to separate non-whitespace characters'
      foo(s);
    }
  }

  /* ok */
  /*ð§*/ String s = "ðð";
  String /* ð§  block comment ok */ st = "ð  assa";
  // violation above 'Use a single space to separate non-whitespace characters'
  String str = "ð¤©ð"; // Multiple whitespaces before comment
  ;
  String j = ""; // violation 'Use a single space to separate non-whitespace characters'
  /** ok */
  void foo2() {
    /* ok */
    String s = "ð§  ð§"; // violation 'Use a single space to separate non-whitespace characters'
  } // ok

  private void foo3(String s) { // 3 violations
    if (s.substring(0).equals("dað")) { // 2 violations
      if ("ð§"
          . // violation 'Use a single space to separate non-whitespace characters'
          isEmpty()) {
        /*ð§*/ } else { // violation 'Use a single space to separate non-whitespace characters'
      }
    }
  }
}


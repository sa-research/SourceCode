/*
EmptyForIteratorPad
option = (default)nospace


*/

package com.puppycrawl.tools.checkstyle.checks.whitespace.emptyforiteratorpad;

public class InputEmptyForIteratorPadWithEmoji {

  void method1() {
    String s = "asddað¤©ðð§";
    int j = 0;
    for (int i = 0; i < s.length() && s.substring(i) == "ð¤©ðð§"; i++) {}

    for (int i = 0; i < s.length() && s.substring(i) == "ð¤©ðð§asd"; i++) {}

    for (;
        j < s.length()
            && s.substring(j) == "ð¤©ð"; ) { // violation '';' is followed by whitespace.'
    }

    s = "ð¤©að¤©";
    for (; j < s.length() && s.substring(j) == "ð¤©ð§"; j++) {}

    s = "dað¤©dað¤©";
    for (; j < s.length() && s.substring(j) == "ð¤©ðð§"; ) {}
  }
}


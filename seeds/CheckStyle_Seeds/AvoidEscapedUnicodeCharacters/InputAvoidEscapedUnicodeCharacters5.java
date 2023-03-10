/*
AvoidEscapedUnicodeCharacters
allowEscapesForControlCharacters = (default)false
allowByTailComment = true
allowIfAllCharactersEscaped = (default)false
allowNonPrintableEscapes = (default)false


*/

package com.puppycrawl.tools.checkstyle.checks.avoidescapedunicodecharacters;

public class InputAvoidEscapedUnicodeCharacters5 {
  private String a = "π"; // violation below
  private String b = "\uD83E\uDD73absπ";
  private String c = "\uD83C\uDF84π\uD83C\uDF84"; // OK, allowed by trailing comment
  // violation below
  private String d = "\uD83C\uDF84π\uD83C\uDF84asdas\uD83C\uDF84abcd";

  public Object fooEmoji() {
    String unitAbbrev = "ΓΒΌsΓ°π"; // violation below
    String unitAbbrev2 = "\u03bcπ";
    String unitAbbrev3 = "π\u03bcs"; // Greek letter mu, "s"
    String fakeUnicode2 = "\\u23\\u123i\\uπ";
    String content = null;
    return "π" + content + "\u03bc"; /* OK, allowed by trailing comment */
  }

  public boolean matches(String c) {
    switch (c) {
        // violation below
      case "\u03bcπ":
      case "π\u03bc": /* OK, allowed by trailing comment */
        // violation below
      case "\t\u2028":
        // violation below
      case "\nπ\u3000":
        return true;
        // violation below
      case "π\uD83D\uDE02":
        return false;
      default:
        return c.equals("\u2000π\u2000"); // OK, allowed by trailing comment
    }
  }
}


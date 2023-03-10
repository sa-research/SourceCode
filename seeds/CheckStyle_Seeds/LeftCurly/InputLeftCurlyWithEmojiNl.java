/*
LeftCurly
option = NL
ignoreEnums = (default)true
tokens = (default)ANNOTATION_DEF, CLASS_DEF, CTOR_DEF, ENUM_CONSTANT_DEF, \
         ENUM_DEF, INTERFACE_DEF, LAMBDA, LITERAL_CASE, LITERAL_CATCH, \
         LITERAL_DEFAULT, LITERAL_DO, LITERAL_ELSE, LITERAL_FINALLY, LITERAL_FOR, \
         LITERAL_IF, LITERAL_SWITCH, LITERAL_SYNCHRONIZED, LITERAL_TRY, LITERAL_WHILE, \
         METHOD_DEF, OBJBLOCK, STATIC_INIT, RECORD_DEF, COMPACT_CTOR_DEF


*/

package com.puppycrawl.tools.checkstyle.checks.blocks.leftcurly;

public class InputLeftCurlyWithEmojiNl { // OK
  static Runnable r1 =
      () -> {
        String.valueOf("ð¥³ð!");
      };
  // violation above ''{' at column 32 should be on a new line.'
  private void method() { // violation ''{' at column 27 should be on a new line.'

    String a = "ð§ð§ð§";

    String b = "ð§ð§ð§ccvb";
    if (b.equals("ð§ð§")) { // violation ''{' at column 29 should be on a new line.'
    }
    if (b.equals("sð§dð§a")) { // violation ''{' at column 32 should be on a new line.'
    }

    while (b == "ð§ð§ð§") {} // violation ''{' at column 28 should be on a new line'
  }

  private void method2() { // violation ''{' at column 28 should be on a new line.'
    String x = "ðð¤£";

    try { // OK
      if (x.equals("ðð¤£")) { // OK

      } else if (!x.equals("ðð¤£")) { // violation ''{' at column 39 should be on a new line.'
        ;
      } else { // OK

      }
      switch (x) { // OK
        case "ð¤£ð¤£ð¤£":
          break;
        default:
          { // OK
            break;
          }
      }

      switch ("ð¤£ð¤£ð¤£") { // violation ''{' at column 27 should be on a new line.'
        case "qw":
          {
            return;
          } // violation ''{' at column 28 should be on a new line.'
        default:
          {
            return;
          }
      }
    } catch (Exception e) { // OK
    }
  }
}

enum InputLeftCurlyMethodEnumWithEmojiNl { // OK
  CONSTANT1("ð§ð§dsdsð§") { // violation ''{' at column 26 should be on a new line.'
    String method1() {
      return "sdsð§";
    } // violation ''{' at column 26 should be on a new line.'

    void method2() { // violation ''{' at column 24 should be on a new line.'
    }

    String method3() { // OK
      return "sdsð§";
    }

    boolean method4() { // OK
      return "sdsð§".equals("ð§ð§dsdsð§");
    }
  };

  InputLeftCurlyMethodEnumWithEmojiNl(String b) {
    // violation above ''{' at column 52 should be on a new line.'
  }
}


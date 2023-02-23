package checks;

class ConditionalOnNewLineCheck {
  void foo(boolean condition1, boolean condition2) {
    if (condition1) {
      // ...
    }
    if (condition2) { // Noncompliant [[sc=7;ec=9;secondary=7]] {{Move this "if" to a new line or
                      // add the missing "else".}}
      // ...
    }
    if (condition1) {
      // ...
    } else {

    }
    if (condition2) { // Noncompliant [[sc=7;ec=9;secondary=14]] {{Move this "if" to a new line or
                      // add the missing "else".}}
      // ...
    }

    if (condition1) {
      // ...
    } else if (condition2) {

    }
    if (condition2) { // Noncompliant [[sc=7;ec=9;secondary=22]] {{Move this "if" to a new line or
                      // add the missing "else".}}
      // ...
    }
    if (condition1) {
      // ...
    }
    if (condition2) { // compliant, if on next line
      // ...
    }

    if (condition1) {
      // ...
    } else if (condition2) { // compliant, else statement
      // ...
    }
    if (condition1) {
      if (condition2) {}
    } // compliant

    if (condition1) {}
    if (condition1) { // Noncompliant [[sc=7;ec=9;secondary=41]] {{Move this "if" to a new line or
                      // add the missing "else".}}
      // ...
    } else {
      // ...
    }

    if (condition1) {
      // ...
    } else {
      // ...
    }
    if (condition1) { // Noncompliant [[sc=7;ec=9;secondary=51]] {{Move this "if" to a new line or
                      // add the missing "else".}}
      // ...
    } else {
      // ...
    }

    if (condition1) {
      // ...
    } else if (condition2) {
      // ...
    }
    if (condition1) { // Noncompliant [[sc=7;ec=9;secondary=61]] {{Move this "if" to a new line or
                      // add the missing "else".}}
      // ...
    } else {
      // ...
    }

    if (condition1) {
      // ...
    } else if (condition2) {
      // ...
    }
    if (condition1) { // Compliant
      // ...
    } else {
      // ...
    }
  }
}


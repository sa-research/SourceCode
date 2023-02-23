package org.detector.report;

import com.fasterxml.jackson.databind.JsonNode;

public class Infer_Violation implements Violation {

    private int row;
    private String bugType;


    public Infer_Violation(JsonNode violation) {
        this.row = violation.get("line").asInt();
        this.bugType = violation.get("bug_type").asText();
    }

    public String getBugType() {
        return this.bugType;
    }

    public int getBeginLine() {
        return this.row;
    }

}

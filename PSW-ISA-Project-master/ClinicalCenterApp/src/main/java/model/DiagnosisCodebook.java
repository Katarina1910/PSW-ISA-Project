package model;

import java.util.ArrayList;

public class DiagnosisCodebook {
    private ArrayList<Diagnosis> diagnoses;

    public DiagnosisCodebook() {
    }

    public DiagnosisCodebook(ArrayList<Diagnosis> diagnoses) {
        this.diagnoses = diagnoses;
    }

    public ArrayList<Diagnosis> getDiagnoses() {
        return diagnoses;
    }

    public void setDiagnoses(ArrayList<Diagnosis> diagnoses) {
        this.diagnoses = diagnoses;
    }
}

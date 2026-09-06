package org.yourcompany.yourproject.hospital;

public class HospitalRequest {

    private String requestId;
    private String hospitalName;
    private String patientName;
    private String bloodGroup;
    private int unitsRequired;
    private String urgency;
    private String status;

    public HospitalRequest(String requestId, String hospitalName,
                           String patientName, String bloodGroup,
                           int unitsRequired, String urgency) {

        this.requestId = requestId;
        this.hospitalName = hospitalName;
        this.patientName = patientName;
        this.bloodGroup = bloodGroup;
        this.unitsRequired = unitsRequired;
        this.urgency = urgency;
        this.status = "Pending";
    }

    public String getRequestId() {
        return requestId;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public String getPatientName() {
        return patientName;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public int getUnitsRequired() {
        return unitsRequired;
    }

    public String getUrgency() {
        return urgency;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

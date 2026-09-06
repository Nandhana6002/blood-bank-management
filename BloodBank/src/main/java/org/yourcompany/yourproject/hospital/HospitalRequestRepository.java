package org.yourcompany.yourproject.hospital;

import java.util.List;

public interface HospitalRequestRepository {

    void save(HospitalRequest request);

    List<HospitalRequest> findAll();

    HospitalRequest findById(String requestId);

    void update(HospitalRequest request);

    void delete(String requestId);
}

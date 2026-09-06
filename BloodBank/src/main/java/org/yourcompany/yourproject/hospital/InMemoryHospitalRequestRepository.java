package org.yourcompany.yourproject.hospital;

import java.util.ArrayList;
import java.util.List;

public class InMemoryHospitalRequestRepository
        implements HospitalRequestRepository {

    private List<HospitalRequest> requests = new ArrayList<>();

    @Override
    public void save(HospitalRequest request) {
        requests.add(request);
    }

    @Override
    public List<HospitalRequest> findAll() {
        return requests;
    }

    @Override
    public HospitalRequest findById(String requestId) {
        for (HospitalRequest request : requests) {
            if (request.getRequestId().equals(requestId)) {
                return request;
            }
        }
        return null;
    }

    @Override
    public void update(HospitalRequest request) {
        for (int i = 0; i < requests.size(); i++) {
            if (requests.get(i).getRequestId().equals(request.getRequestId())) {
                requests.set(i, request);
                return;
            }
        }
    }

    @Override
    public void delete(String requestId) {
        requests.removeIf(
            request -> request.getRequestId().equals(requestId)
        );
    }
}

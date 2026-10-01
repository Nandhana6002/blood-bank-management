package org.yourcompany.yourproject.hospital;

public class HospitalRequestRepositoryProvider {

    private static final HospitalRequestRepository repository =
            new InMemoryHospitalRequestRepository();

    public static HospitalRequestRepository getRepository() {
        return repository;
    }
}

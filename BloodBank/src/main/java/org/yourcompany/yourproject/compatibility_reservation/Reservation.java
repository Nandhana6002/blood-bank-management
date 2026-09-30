package org.yourcompany.yourproject.compatibility_reservation;

import org.yourcompany.yourproject.inventory.BloodStatus;
import org.yourcompany.yourproject.inventory.BloodUnit;

public class Reservation {
    public void reserve(BloodUnit unit){
        unit.setStatus(BloodStatus.RESERVED);
    }
}

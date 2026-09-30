package org.yourcompany.yourproject.compatibility_reservation;

import org.yourcompany.yourproject.inventory.BloodGroup;
import org.yourcompany.yourproject.inventory.BloodStatus;
import org.yourcompany.yourproject.inventory.BloodUnit;

import java.time.LocalDate;

import org.yourcompany.yourproject.inventory.BloodComponent;

public class CompatibilityChecker {
    public boolean isCompatible(BloodGroup recipient, BloodGroup donor){
        switch (recipient){
            case A_POSITIVE:
                return donor==BloodGroup.A_POSITIVE||donor==BloodGroup.A_NEGATIVE||donor==BloodGroup.O_POSITIVE||donor==BloodGroup.O_NEGATIVE;
            case A_NEGATIVE:
                return donor==BloodGroup.A_NEGATIVE||donor==BloodGroup.O_NEGATIVE;
            case O_POSITIVE:
                return donor==BloodGroup.O_POSITIVE||donor==BloodGroup.O_NEGATIVE;
            case O_NEGATIVE:
                return donor==BloodGroup.O_NEGATIVE;
            case B_POSITIVE:
                return donor==BloodGroup.B_POSITIVE||donor==BloodGroup.B_NEGATIVE||donor==BloodGroup.O_POSITIVE||donor==BloodGroup.O_NEGATIVE;
            case B_NEGATIVE:
                return donor==BloodGroup.B_NEGATIVE||donor==BloodGroup.O_NEGATIVE;
            case AB_POSITIVE:
                return donor==BloodGroup.A_POSITIVE||donor==BloodGroup.A_NEGATIVE||donor==BloodGroup.O_POSITIVE||donor==BloodGroup.O_NEGATIVE||donor==BloodGroup.AB_NEGATIVE||donor==BloodGroup.AB_POSITIVE||donor==BloodGroup.B_POSITIVE||donor==BloodGroup.B_NEGATIVE;
            case AB_NEGATIVE:
                return donor==BloodGroup.AB_NEGATIVE||donor==BloodGroup.A_NEGATIVE||donor==BloodGroup.B_NEGATIVE||donor==BloodGroup.O_NEGATIVE;
            default:
                return false;
        }
    }
    public boolean isCompatible(BloodGroup recipient, BloodUnit unit){
        if (unit.getComponent()!=BloodComponent.PRBC){
            return false;
        }
        if (unit.getStatus()!=BloodStatus.AVAILABLE){
            return false;
        }
        return isCompatible(recipient, unit);
    }
    public static void main(String[] args){
        CompatibilityChecker checker = new CompatibilityChecker();
        BloodUnit unit = new BloodUnit(1, BloodGroup.B_NEGATIVE, BloodComponent.PRBC, "9999999999", LocalDate.now(), BloodStatus.EXPIRED);
        System.out.println(checker.isCompatible(BloodGroup.B_POSITIVE, unit));
    }
}
//mock data currently implemented using lists. Database to be integrated

package org.yourcompany.yourproject.inventory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class InventoryManager {
    private static List<BloodUnit> inventoryList = new ArrayList<>();
    private static int idCounter = 1;

    static {
        inventoryList.add(new BloodUnit(idCounter++, BloodGroup.A_POSITIVE, BloodComponent.PRBC, "9876543210", LocalDate.now().minusDays(10), BloodStatus.AVAILABLE));
        inventoryList.add(new BloodUnit(idCounter++, BloodGroup.O_NEGATIVE, BloodComponent.PLATELETS, "9123456789", LocalDate.now().minusDays(6), BloodStatus.AVAILABLE)); // Will auto-expire since platelets last only 5 days
        inventoryList.add(new BloodUnit(idCounter++, BloodGroup.B_POSITIVE, BloodComponent.FPP, "9988776655", LocalDate.now().minusDays(20), BloodStatus.AVAILABLE));
    }

    public List<BloodUnit> getAllBloodUnits() {
        return inventoryList;
    }

    public boolean addBloodUnit(BloodUnit unit) {
        unit.setUnitId(idCounter++);
        inventoryList.add(unit);
        return true;
    }
}